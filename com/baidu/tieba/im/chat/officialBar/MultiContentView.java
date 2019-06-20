package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiContentView extends LinearLayout {
    private LinearLayout bZj;
    private View bmd;
    private com.baidu.adp.lib.c.b gsC;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> gui;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> guj;
    private com.baidu.adp.lib.e.b<SingleImageTextView> guk;
    private boolean gul;
    private String gum;
    private Context mContext;
    private int mPosition;
    private int mType;

    public MultiContentView(Context context) {
        super(context);
        this.gsC = null;
        this.gul = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsC = null;
        this.gul = true;
        this.mType = 2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmd = View.inflate(this.mContext, R.layout.msg_multi_pic_text_content_view, this);
        this.bZj = (LinearLayout) this.bmd.findViewById(R.id.view_container);
        b bVar = new b();
        this.gui = bVar.dL(this.mContext);
        this.guj = bVar.dM(this.mContext);
        this.guk = bVar.dN(this.mContext);
        this.bZj.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiContentView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof MultiImageTextTopView) {
                    MultiContentView.this.gui.t((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    MultiContentView.this.guj.t((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    MultiContentView.this.guk.t((SingleImageTextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.bZj.addView(view);
    }

    public void setData(TbPageContext<?> tbPageContext, List<c.a> list, View view) {
        this.bZj.removeAllViews();
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
                        str = list.get(i).guq;
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
        if (this.gui != null) {
            multiImageTextTopView = this.gui.iu();
        }
        if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
            multiImageTextTopView = new MultiImageTextTopView(this.mContext);
        }
        multiImageTextTopView.setOnItemViewLongClickListener(this.gsC);
        multiImageTextTopView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gul) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.g(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        } else if (this.mType == 1) {
            al.g(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
        }
        multiImageTextTopView.lA(this.gul);
        return multiImageTextTopView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextTopView multiImageTextTopView, View view) {
        if (aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.gum);
            multiImageTextTopView.setData(tbPageContext, aVar, view, this.mType);
            this.bZj.addView(multiImageTextTopView);
        }
    }

    private MultiImageTextBottomView getCommonBottomView() {
        MultiImageTextBottomView multiImageTextBottomView = null;
        if (this.guj != null) {
            multiImageTextBottomView = this.guj.iu();
        }
        if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
            multiImageTextBottomView = new MultiImageTextBottomView(this.mContext);
        }
        multiImageTextBottomView.setOnItemViewLongClickListener(this.gsC);
        multiImageTextBottomView.setPosition(this.mPosition);
        return multiImageTextBottomView;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gul) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.g(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        } else if (this.mType == 1) {
            al.g(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.lA(this.gul);
        return commonBottomView;
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gul) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.g(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        } else if (this.mType == 1) {
            al.g(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.lA(this.gul);
        return commonBottomView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(R.dimen.ds132)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view, this.mType);
            this.bZj.addView(multiImageTextBottomView);
        }
    }

    private SingleImageTextView getSingleView() {
        SingleImageTextView singleImageTextView = null;
        if (this.guk != null) {
            singleImageTextView = this.guk.iu();
        }
        if (singleImageTextView == null || singleImageTextView.getParent() == null) {
            singleImageTextView = new SingleImageTextView(this.mContext);
        }
        singleImageTextView.setOnItemViewLongClickListener(this.gsC);
        singleImageTextView.setPosition(this.mPosition);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !this.gul) {
            skinType = 0;
        }
        if (this.mType == 2) {
            al.g(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        } else if (this.mType == 1) {
            al.g(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
        }
        singleImageTextView.lA(this.gul);
        return singleImageTextView;
    }

    private void a(TbPageContext<?> tbPageContext, c.a aVar, SingleImageTextView singleImageTextView, View view) {
        if (aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.gum);
            singleImageTextView.setData(tbPageContext, aVar, view, this.mType);
            this.bZj.addView(singleImageTextView);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setNeedNightMode(boolean z) {
        this.gul = z;
    }

    public void setTime(String str) {
        this.gum = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
