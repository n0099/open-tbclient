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
    private LinearLayout aIp;
    private View bRX;
    private com.baidu.adp.lib.c.b eHQ;
    private boolean eJA;
    private String eJB;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eJx;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> eJy;
    private com.baidu.adp.lib.e.b<SingleImageTextView> eJz;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.eHQ = null;
        this.eJA = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHQ = null;
        this.eJA = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bRX = View.inflate(this.mContext, e.h.msg_multi_pic_text_content_view, this);
        this.aIp = (LinearLayout) this.bRX.findViewById(e.g.view_container);
        b bVar = new b();
        this.eJx = bVar.cA(this.mContext);
        this.eJy = bVar.cB(this.mContext);
        this.eJz = bVar.cC(this.mContext);
        this.aIp.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.eJx.t((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.eJy.t((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.eJz.t((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.aIp.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.aIp.removeAllViews();
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
                        str = list.get(i).eJF;
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
        if (this.eJx != null) {
            multiImageTextTopView = this.eJx.jy();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.eHQ);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eJA) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(multiImageTextTopView, e.f.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            al.d(multiImageTextTopView, e.f.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.ih(this.eJA);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.eJB);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.aIp.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.eJy != null) {
            multiImageTextBottomView = this.eJy.jy();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.eHQ);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eJA) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(commonBottomView, e.f.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            al.d(commonBottomView, e.f.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.ih(this.eJA);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eJA) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(commonBottomView, e.f.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            al.d(commonBottomView, e.f.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.ih(this.eJA);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(e.C0210e.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.aIp.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.eJz != null) {
            singleImageTextView = this.eJz.jy();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.eHQ);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.eJA) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.d(singleImageTextView, e.f.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            al.d(singleImageTextView, e.f.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.ih(this.eJA);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.eJB);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.aIp.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eHQ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.eJA = z;
    }

    public void setTime(String str) {
        this.eJB = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
