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
    private View.OnClickListener dLa;
    private View.OnClickListener dLb;
    private int dZM;
    private int dZN;
    private com.baidu.adp.lib.e.b<i> dZO;
    private final ViewGroup.OnHierarchyChangeListener dZP;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.dZN = 0;
        this.dLa = null;
        this.dLb = null;
        this.dZO = null;
        this.dZP = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof i) && UserRecommendLayout.this.dZO != null) {
                    i iVar = (i) view2;
                    if (iVar.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) iVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.dZO.ar((i) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZN = 0;
        this.dLa = null;
        this.dLb = null;
        this.dZO = null;
        this.dZP = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof i) && UserRecommendLayout.this.dZO != null) {
                    i iVar = (i) view2;
                    if (iVar.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) iVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.dZO.ar((i) view2);
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
        setOnHierarchyChangeListener(this.dZP);
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
        if (!v.E(list)) {
            int ao = ((com.baidu.adp.lib.util.e.ao(getContext()) - (getPaddingLeft() * 2)) - (this.dZN * 2)) / 3;
            this.dZM = this.dZN + ao;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof i) {
                    i iVar = (i) getChildAt(i);
                    a(iVar, i, ao);
                    a(iVar, list.get(i));
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
                    i nk = this.dZO.nk();
                    if (nk.getParent() != null) {
                        ((ViewGroup) nk.getParent()).removeView(nk);
                    }
                    a(nk, i3, ao);
                    a(nk, list.get(i3));
                    addView(nk);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(i iVar, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iVar.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.dZN;
        }
        iVar.setLayoutParams(layoutParams);
    }

    private void a(final i iVar, MetaData metaData) {
        com.baidu.tbadk.core.view.userLike.c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        iVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.I(metaData.getFansNum())));
        iVar.getUsername().setText(metaData.getName_show());
        iVar.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                iVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.I(i)));
            }
        });
        if (iVar.getLikeBtn().getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
            cVar = (com.baidu.tbadk.core.view.userLike.c) iVar.getLikeBtn().getTag();
        } else {
            cVar = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, iVar.getLikeBtn());
        }
        cVar.setFromType("7");
        iVar.getLikeBtn().setTag(cVar);
        cVar.a(metaData);
        iVar.getLikeBtn().setAfterOnClickListener(this.dLa);
        iVar.getHeaderView().setData(metaData);
        iVar.getHeaderView().setAfterClickListener(this.dLb);
        iVar.setIsGod(metaData.isGod());
        iVar.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.dZM;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<i> bVar) {
        this.dZO = bVar;
    }

    public void setItemSpace(int i) {
        this.dZN = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.dLa = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.dLb = onClickListener;
    }
}
