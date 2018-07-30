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
    private LinearLayout awj;
    private View bzb;
    private com.baidu.adp.lib.c.b ekB;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> emi;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> emj;
    private com.baidu.adp.lib.e.b<SingleImageTextView> emk;
    private boolean eml;
    private String emm;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.ekB = null;
        this.eml = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekB = null;
        this.eml = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bzb = View.inflate(this.mContext, d.h.msg_multi_pic_text_content_view, this);
        this.awj = (LinearLayout) this.bzb.findViewById(d.g.view_container);
        b bVar = new b();
        this.emi = bVar.bH(this.mContext);
        this.emj = bVar.bI(this.mContext);
        this.emk = bVar.bJ(this.mContext);
        this.awj.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.emi.p((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.emj.p((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.emk.p((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.awj.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.awj.removeAllViews();
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
                        str = list.get(i).emq;
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
        if (this.emi != null) {
            multiImageTextTopView = this.emi.m9if();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.ekB);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eml) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            am.d(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.hf(this.eml);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.emm);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.awj.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.emj != null) {
            multiImageTextBottomView = this.emj.m9if();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.ekB);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eml) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.hf(this.eml);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eml) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.hf(this.eml);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.awj.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.emk != null) {
            singleImageTextView = this.emk.m9if();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.ekB);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eml) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            am.d(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.hf(this.eml);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.emm);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.awj.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekB = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.eml = z;
    }

    public void setTime(String str) {
        this.emm = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
