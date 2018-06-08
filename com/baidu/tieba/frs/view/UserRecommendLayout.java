package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class UserRecommendLayout extends LinearLayout {
    private int cwA;
    private final ViewGroup.OnHierarchyChangeListener cwB;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> cwx;
    private int cwy;
    private View.OnClickListener doC;
    private View.OnClickListener doD;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.cwy = 0;
        this.doC = null;
        this.doD = null;
        this.cwx = null;
        this.cwB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.cwx != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.cwx.p((UserRecommendItemView) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwy = 0;
        this.doC = null;
        this.doD = null;
        this.cwx = null;
        this.cwB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.cwx != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.cwx.p((UserRecommendItemView) view2);
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
        setOnHierarchyChangeListener(this.cwB);
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
        if (!w.z(list)) {
            int ah = ((com.baidu.adp.lib.util.e.ah(getContext()) - (getPaddingLeft() * 2)) - (this.cwy * 2)) / 3;
            this.cwA = this.cwy + ah;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof UserRecommendItemView) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i);
                    a(userRecommendItemView, i, ah);
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
                    UserRecommendItemView ie = this.cwx.ie();
                    if (ie.getParent() != null) {
                        ((ViewGroup) ie.getParent()).removeView(ie);
                    }
                    a(ie, i3, ah);
                    a(ie, list.get(i3));
                    addView(ie);
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
            layoutParams.leftMargin = this.cwy;
        }
        userRecommendItemView.setLayoutParams(layoutParams);
    }

    private void a(final UserRecommendItemView userRecommendItemView, MetaData metaData) {
        com.baidu.tbadk.core.view.userLike.c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", ao.D(metaData.getFansNum())));
        userRecommendItemView.getUsername().setText(metaData.getName_show());
        userRecommendItemView.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dF(int i) {
                userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", ao.D(i)));
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
        userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.doC);
        userRecommendItemView.getHeaderView().setData(metaData);
        userRecommendItemView.getHeaderView().setAfterClickListener(this.doD);
        userRecommendItemView.setIsGod(metaData.isGod());
        userRecommendItemView.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.cwA;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<UserRecommendItemView> bVar) {
        this.cwx = bVar;
    }

    public void setItemSpace(int i) {
        this.cwy = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.doC = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.doD = onClickListener;
    }
}
