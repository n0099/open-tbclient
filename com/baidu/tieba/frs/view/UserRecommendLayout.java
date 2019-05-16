package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class UserRecommendLayout extends LinearLayout {
    private com.baidu.adp.lib.e.b<UserRecommendItemView> evL;
    private int evM;
    private int evO;
    private final ViewGroup.OnHierarchyChangeListener evP;
    private View.OnClickListener fyb;
    private View.OnClickListener fyc;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.evM = 0;
        this.fyb = null;
        this.fyc = null;
        this.evL = null;
        this.evP = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.evL != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.evL.t((UserRecommendItemView) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evM = 0;
        this.fyb = null;
        this.fyc = null;
        this.evL = null;
        this.evP = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.evL != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.evL.t((UserRecommendItemView) view2);
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
        setOnHierarchyChangeListener(this.evP);
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
        if (!v.aa(list)) {
            int af = ((com.baidu.adp.lib.util.e.af(getContext()) - (getPaddingLeft() * 2)) - (this.evM * 2)) / 3;
            this.evO = this.evM + af;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof UserRecommendItemView) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i);
                    a(userRecommendItemView, i, af);
                    a(userRecommendItemView, list.get(i));
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
                    UserRecommendItemView iu = this.evL.iu();
                    if (iu.getParent() != null) {
                        ((ViewGroup) iu.getParent()).removeView(iu);
                    }
                    a(iu, i3, af);
                    a(iu, list.get(i3));
                    addView(iu);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(UserRecommendItemView userRecommendItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) userRecommendItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.evM;
        }
        userRecommendItemView.setLayoutParams(layoutParams);
    }

    private void a(final UserRecommendItemView userRecommendItemView, MetaData metaData) {
        com.baidu.tbadk.core.view.userLike.c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", ap.aM(metaData.getFansNum())));
        userRecommendItemView.getUsername().setText(metaData.getName_show());
        userRecommendItemView.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void iZ(int i) {
                userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", ap.aM(i)));
            }
        });
        if (userRecommendItemView.getLikeBtn().getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
            cVar = (com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getLikeBtn().getTag();
        } else {
            cVar = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, userRecommendItemView.getLikeBtn());
        }
        cVar.setFromType("7");
        userRecommendItemView.getLikeBtn().setTag(cVar);
        cVar.a(metaData);
        userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.fyb);
        userRecommendItemView.getHeaderView().setData(metaData);
        userRecommendItemView.getHeaderView().setAfterClickListener(this.fyc);
        userRecommendItemView.setIsGod(metaData.isGod());
        userRecommendItemView.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.evO;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<UserRecommendItemView> bVar) {
        this.evL = bVar;
    }

    public void setItemSpace(int i) {
        this.evM = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.fyb = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.fyc = onClickListener;
    }
}
