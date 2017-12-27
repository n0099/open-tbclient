package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class UserRecommendLayout extends LinearLayout {
    private View.OnClickListener dDp;
    private View.OnClickListener dDq;
    private int dQC;
    private int dQD;
    private com.baidu.adp.lib.e.b<h> dQE;
    private final ViewGroup.OnHierarchyChangeListener dQF;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.dQD = 0;
        this.dDp = null;
        this.dDq = null;
        this.dQE = null;
        this.dQF = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof h) && UserRecommendLayout.this.dQE != null) {
                    h hVar = (h) view2;
                    if (hVar.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) hVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.dQE.ar((h) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dQD = 0;
        this.dDp = null;
        this.dDq = null;
        this.dQE = null;
        this.dQF = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof h) && UserRecommendLayout.this.dQE != null) {
                    h hVar = (h) view2;
                    if (hVar.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) hVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.dQE.ar((h) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.dQF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setData(List<MetaData> list) {
        if (!v.G(list)) {
            int ao = ((com.baidu.adp.lib.util.e.ao(getContext()) - (getPaddingLeft() * 2)) - (this.dQD * 2)) / 3;
            this.dQC = this.dQD + ao;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof h) {
                    h hVar = (h) getChildAt(i);
                    a(hVar, i, ao);
                    a(hVar, list.get(i));
                }
                i++;
            }
            int i2 = i;
            while (i2 < childCount) {
                removeViewAt(i2);
                i2++;
            }
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    h nj = this.dQE.nj();
                    if (nj.getParent() != null) {
                        ((ViewGroup) nj.getParent()).removeView(nj);
                    }
                    a(nj, i3, ao);
                    a(nj, list.get(i3));
                    addView(nj);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(h hVar, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.dQD;
        }
        hVar.setLayoutParams(layoutParams);
    }

    private void a(final h hVar, MetaData metaData) {
        com.baidu.tbadk.core.view.userLike.c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        hVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.H(metaData.getFansNum())));
        hVar.getUsername().setText(metaData.getName_show());
        hVar.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gF(int i) {
                hVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.H(i)));
            }
        });
        if (hVar.getLikeBtn().getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
            cVar = (com.baidu.tbadk.core.view.userLike.c) hVar.getLikeBtn().getTag();
        } else {
            cVar = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, hVar.getLikeBtn());
        }
        cVar.setFromType("7");
        hVar.getLikeBtn().setTag(cVar);
        cVar.a(metaData);
        hVar.getLikeBtn().setAfterOnClickListener(this.dDp);
        hVar.getHeaderView().setData(metaData);
        hVar.getHeaderView().setAfterClickListener(this.dDq);
        hVar.setIsGod(metaData.isGod());
        hVar.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.dQC;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<h> bVar) {
        this.dQE = bVar;
    }

    public void setItemSpace(int i) {
        this.dQD = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.dDp = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.dDq = onClickListener;
    }
}
