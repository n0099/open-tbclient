package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout awg;
    private View bzd;
    private com.baidu.adp.lib.c.b ekx;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eme;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> emf;
    private com.baidu.adp.lib.e.b<SingleImageTextView> emg;
    private boolean emh;
    private String emi;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.ekx = null;
        this.emh = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekx = null;
        this.emh = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bzd = View.inflate(this.mContext, f.h.msg_multi_pic_text_content_view, this);
        this.awg = (LinearLayout) this.bzd.findViewById(f.g.view_container);
        b bVar = new b();
        this.eme = bVar.bH(this.mContext);
        this.emf = bVar.bI(this.mContext);
        this.emg = bVar.bJ(this.mContext);
        this.awg.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.eme.p((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.emf.p((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.emg.p((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.awg.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.awg.removeAllViews();
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
                        str = list.get(i).emm;
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
        if (this.eme != null) {
            multiImageTextTopView = this.eme.m9if();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.ekx);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.emh) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(multiImageTextTopView, f.C0146f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            am.d(multiImageTextTopView, f.C0146f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.hf(this.emh);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.emi);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.awg.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.emf != null) {
            multiImageTextBottomView = this.emf.m9if();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.ekx);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.emh) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, f.C0146f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, f.C0146f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.hf(this.emh);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.emh) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(commonBottomView, f.C0146f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            am.d(commonBottomView, f.C0146f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.hf(this.emh);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(f.e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.awg.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.emg != null) {
            singleImageTextView = this.emg.m9if();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.ekx);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.emh) {
            skinType = 0;
        }
        if (this.mType == 2) {
            am.d(singleImageTextView, f.C0146f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            am.d(singleImageTextView, f.C0146f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.hf(this.emh);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.emi);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.awg.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.emh = z;
    }

    public void setTime(String str) {
        this.emi = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
