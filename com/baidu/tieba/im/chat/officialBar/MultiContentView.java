package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout bRo;
    private View dcL;
    private com.baidu.adp.lib.c.b gbv;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> gdc;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> gdd;
    private com.baidu.adp.lib.e.b<SingleImageTextView> gde;
    private boolean gdf;
    private String gdg;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.gbv = null;
        this.gdf = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbv = null;
        this.gdf = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dcL = View.inflate(this.mContext, d.h.msg_multi_pic_text_content_view, this);
        this.bRo = (LinearLayout) this.dcL.findViewById(d.g.view_container);
        b bVar = new b();
        this.gdc = bVar.dV(this.mContext);
        this.gdd = bVar.dW(this.mContext);
        this.gde = bVar.dX(this.mContext);
        this.bRo.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.gdc.t((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.gdd.t((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.gde.t((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.bRo.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.bRo.removeAllViews();
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
                        str = list.get(i).gdk;
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
        if (this.gdc != null) {
            multiImageTextTopView = this.gdc.jA();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.gbv);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gdf) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.e(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            al.e(multiImageTextTopView, d.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.kK(this.gdf);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.gdg);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.bRo.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.gdd != null) {
            multiImageTextBottomView = this.gdd.jA();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.gbv);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gdf) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.e(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            al.e(commonBottomView, d.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.kK(this.gdf);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gdf) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.e(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            al.e(commonBottomView, d.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.kK(this.gdf);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(d.e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.bRo.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.gde != null) {
            singleImageTextView = this.gde.jA();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.gbv);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gdf) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.e(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            al.e(singleImageTextView, d.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.kK(this.gdf);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.gdg);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.bRo.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbv = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.gdf = z;
    }

    public void setTime(String str) {
        this.gdg = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
