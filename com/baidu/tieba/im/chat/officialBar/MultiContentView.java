package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiContentView extends LinearLayout {
    private View elg;
    private com.baidu.adp.lib.b.b krZ;
    private com.baidu.adp.lib.d.b<MultiImageTextTopView> ktO;
    private com.baidu.adp.lib.d.b<MultiImageTextBottomView> ktP;
    private com.baidu.adp.lib.d.b<SingleImageTextView> ktQ;
    private boolean ktR;
    private String ktS;
    private LinearLayout mContainer;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.krZ = null;
        this.ktR = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.krZ = null;
        this.ktR = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.elg = View.inflate(this.mContext, R.layout.msg_multi_pic_text_content_view, this);
        this.mContainer = (LinearLayout) this.elg.findViewById(R.id.view_container);
        c cVar = new c();
        this.ktO = cVar.gs(this.mContext);
        this.ktP = cVar.gt(this.mContext);
        this.ktQ = cVar.gu(this.mContext);
        this.mContainer.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.ktO.returnObject((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.ktP.returnObject((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.ktQ.returnObject((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.mContainer.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<a.C0758a> list, View view) {
        this.mContainer.removeAllViews();
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
                        str = list.get(i).ktW;
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
        if (this.ktO != null) {
            multiImageTextTopView = this.ktO.borrowObject();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.krZ);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.ktR) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ao.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            ao.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.st(this.ktR);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, a.C0758a c0758a, MultiImageTextTopView multiImageTextTopView, View view) {
        if (c0758a != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.ktS);
            multiImageTextTopView.setData(tbPageContext, c0758a, view, this.mType);
            this.mContainer.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.ktP != null) {
            multiImageTextBottomView = this.ktP.borrowObject();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.krZ);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.ktR) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ao.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            ao.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.st(this.ktR);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.ktR) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ao.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            ao.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.st(this.ktR);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, a.C0758a c0758a, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (c0758a != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(R.dimen.ds132)));
            multiImageTextBottomView.setData(tbPageContext, c0758a, view, this.mType);
            this.mContainer.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.ktQ != null) {
            singleImageTextView = this.ktQ.borrowObject();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.krZ);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.ktR) {
            skinType = 0;
        }
        if (this.mType == 2) {
            ao.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            ao.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.st(this.ktR);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, a.C0758a c0758a, SingleImageTextView singleImageTextView, View view) {
        if (c0758a != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.ktS);
            singleImageTextView.setData(tbPageContext, c0758a, view, this.mType);
            this.mContainer.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.krZ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.ktR = z;
    }

    public void setTime(String str) {
        this.ktS = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
