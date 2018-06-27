package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout awD;
    private com.baidu.adp.lib.c.b egL;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eis;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> eit;
    private com.baidu.adp.lib.e.b<SingleImageTextView> eiu;
    private boolean eiv;
    private Context mContext;
    private int mPosition;
    private String mTime;
    private int mType;
    private View root;

    public MultiContentView(Context context) {
        super(context);
        this.egL = null;
        this.eiv = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egL = null;
        this.eiv = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.msg_multi_pic_text_content_view, this);
        this.awD = (LinearLayout) this.root.findViewById(d.g.view_container);
        b bVar = new b();
        this.eis = bVar.bG(this.mContext);
        this.eit = bVar.bH(this.mContext);
        this.eiu = bVar.bI(this.mContext);
        this.awD.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.eis.p((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.eit.p((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.eiu.p((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.awD.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.awD.removeAllViews();
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
                        str = list.get(i).eiz;
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
        if (this.eis != null) {
            multiImageTextTopView = this.eis.ie();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.egL);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eiv) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            am.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.hc(this.eiv);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.mTime);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.awD.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.eit != null) {
            multiImageTextBottomView = this.eit.ie();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.egL);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eiv) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.hc(this.eiv);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eiv) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.hc(this.eiv);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.awD.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.eiu != null) {
            singleImageTextView = this.eiu.ie();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.egL);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eiv) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            am.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.hc(this.eiv);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.mTime);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.awD.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.egL = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.eiv = z;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
