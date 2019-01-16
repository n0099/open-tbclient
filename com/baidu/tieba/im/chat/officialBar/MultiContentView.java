package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout aIS;
    private View bSL;
    private com.baidu.adp.lib.c.b eLt;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eNa;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> eNb;
    private com.baidu.adp.lib.e.b<SingleImageTextView> eNc;
    private boolean eNd;
    private String eNe;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.eLt = null;
        this.eNd = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLt = null;
        this.eNd = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSL = View.inflate(this.mContext, e.h.msg_multi_pic_text_content_view, this);
        this.aIS = (LinearLayout) this.bSL.findViewById(e.g.view_container);
        b bVar = new b();
        this.eNa = bVar.cA(this.mContext);
        this.eNb = bVar.cB(this.mContext);
        this.eNc = bVar.cC(this.mContext);
        this.aIS.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.eNa.t((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.eNb.t((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.eNc.t((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.aIS.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.aIS.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            String str = "";
            if (size == 1) {
                a(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (list.get(i) != null) {
                        str = list.get(i).eNi;
                    }
                    a(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    MultiImageTextBottomView bottomView = getBottomView();
                    if (bottomView != null) {
                        bottomView.setStPosition(i);
                        bottomView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), bottomView, view);
                } else {
                    MultiImageTextBottomView midView = getMidView();
                    if (midView != null) {
                        midView.setStPosition(i);
                        midView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), midView, view);
                }
            }
        }
    }

    private MultiImageTextTopView getTopView() {
        MultiImageTextTopView multiImageTextTopView = null;
        if (this.eNa != null) {
            multiImageTextTopView = this.eNa.jy();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.eLt);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eNd) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(multiImageTextTopView, e.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            al.d(multiImageTextTopView, e.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.ik(this.eNd);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.eNe);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.aIS.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.eNb != null) {
            multiImageTextBottomView = this.eNb.jy();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.eLt);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eNd) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(commonBottomView, e.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            al.d(commonBottomView, e.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.ik(this.eNd);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eNd) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(commonBottomView, e.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            al.d(commonBottomView, e.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.ik(this.eNd);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(e.C0210e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.aIS.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.eNc != null) {
            singleImageTextView = this.eNc.jy();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.eLt);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eNd) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(singleImageTextView, e.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            al.d(singleImageTextView, e.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.ik(this.eNd);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.eNe);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.aIS.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eLt = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.eNd = z;
    }

    public void setTime(String str) {
        this.eNe = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
