package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout anM;
    private com.baidu.adp.lib.c.b dRE;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> dTl;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> dTm;
    private com.baidu.adp.lib.e.b<SingleImageTextView> dTn;
    private boolean dTo;
    private Context mContext;
    private int mPosition;
    private String mTime;
    private int mType;
    private View root;

    public MultiContentView(Context context) {
        super(context);
        this.dRE = null;
        this.dTo = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRE = null;
        this.dTo = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.msg_multi_pic_text_content_view, this);
        this.anM = (LinearLayout) this.root.findViewById(d.g.view_container);
        b bVar = new b();
        this.dTl = bVar.bw(this.mContext);
        this.dTm = bVar.bx(this.mContext);
        this.dTn = bVar.by(this.mContext);
        this.anM.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if (view3 instanceof MultiImageTextTopView) {
                    MultiContentView.this.dTl.m((MultiImageTextTopView) view3);
                } else if (view3 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.dTm.m((MultiImageTextBottomView) view3);
                } else if (view3 instanceof SingleImageTextView) {
                    MultiContentView.this.dTn.m((SingleImageTextView) view3);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        this.anM.addView(view2);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view2) {
        this.anM.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            String str = "";
            if (size == 1) {
                a(tbPageContext, list.get(0), getSingleView(), view2);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (list.get(i) != null) {
                        str = list.get(i).dTs;
                    }
                    a(tbPageContext, list.get(i), getTopView(), view2);
                } else if (i == size - 1) {
                    MultiImageTextBottomView bottomView = getBottomView();
                    if (bottomView != null) {
                        bottomView.setStPosition(i);
                        bottomView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), bottomView, view2);
                } else {
                    MultiImageTextBottomView midView = getMidView();
                    if (midView != null) {
                        midView.setStPosition(i);
                        midView.setTaskInfo(str);
                    }
                    a(tbPageContext, list.get(i), midView, view2);
                }
            }
        }
    }

    private MultiImageTextTopView getTopView() {
        MultiImageTextTopView multiImageTextTopView = null;
        if (this.dTl != null) {
            multiImageTextTopView = this.dTl.fn();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.dRE);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.dTo) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ak.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            ak.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.gM(this.dTo);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view2) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.mTime);
            multiImageTextTopView.setData(tbPageContext, aVar, view2, this.mType);
            this.anM.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.dTm != null) {
            multiImageTextBottomView = this.dTm.fn();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.dRE);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.dTo) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ak.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            ak.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.gM(this.dTo);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.dTo) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ak.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            ak.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.gM(this.dTo);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view2) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view2, this.mType);
            this.anM.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.dTn != null) {
            singleImageTextView = this.dTn.fn();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.dRE);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.dTo) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ak.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            ak.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.gM(this.dTo);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view2) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.mTime);
            singleImageTextView.setData(tbPageContext, aVar, view2, this.mType);
            this.anM.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dRE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.dTo = z;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
