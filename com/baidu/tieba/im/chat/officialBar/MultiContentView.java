package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes13.dex */
public class MultiContentView extends LinearLayout {
    private View djj;
    private com.baidu.adp.lib.b.b iKx;
    private com.baidu.adp.lib.d.b<MultiImageTextTopView> iMb;
    private com.baidu.adp.lib.d.b<MultiImageTextBottomView> iMc;
    private com.baidu.adp.lib.d.b<SingleImageTextView> iMd;
    private boolean iMe;
    private String iMf;
    private LinearLayout mContainer;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.iKx = null;
        this.iMe = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKx = null;
        this.iMe = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.djj = View.inflate(this.mContext, R.layout.msg_multi_pic_text_content_view, this);
        this.mContainer = (LinearLayout) this.djj.findViewById(R.id.view_container);
        b bVar = new b();
        this.iMb = bVar.eS(this.mContext);
        this.iMc = bVar.eT(this.mContext);
        this.iMd = bVar.eU(this.mContext);
        this.mContainer.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.iMb.returnObject((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.iMc.returnObject((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.iMd.returnObject((SingleImageTextView) view2);
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

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
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
                        str = list.get(i).iMj;
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
        if (this.iMb != null) {
            multiImageTextTopView = this.iMb.borrowObject();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.iKx);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.iMe) {
            skinType = 0;
        }
        if (this.mType == 2) {
            an.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            an.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.oX(this.iMe);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.iMf);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.mContainer.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.iMc != null) {
            multiImageTextBottomView = this.iMc.borrowObject();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.iKx);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.iMe) {
            skinType = 0;
        }
        if (this.mType == 2) {
            an.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            an.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.oX(this.iMe);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.iMe) {
            skinType = 0;
        }
        if (this.mType == 2) {
            an.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            an.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.oX(this.iMe);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(R.dimen.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.mContainer.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.iMd != null) {
            singleImageTextView = this.iMd.borrowObject();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.iKx);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.iMe) {
            skinType = 0;
        }
        if (this.mType == 2) {
            an.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            an.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.oX(this.iMe);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.iMf);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.mContainer.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iKx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.iMe = z;
    }

    public void setTime(String str) {
        this.iMf = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
