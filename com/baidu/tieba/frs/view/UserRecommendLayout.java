package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class UserRecommendLayout extends LinearLayout {
    private com.baidu.adp.lib.d.b<UserRecommendItemView> gCA;
    private int gCB;
    private int gCC;
    private final ViewGroup.OnHierarchyChangeListener gCD;
    private View.OnClickListener hwQ;
    private View.OnClickListener hwR;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.gCB = 0;
        this.hwQ = null;
        this.hwR = null;
        this.gCA = null;
        this.gCD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.gCA != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.gCA.returnObject((UserRecommendItemView) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCB = 0;
        this.hwQ = null;
        this.hwR = null;
        this.gCA = null;
        this.gCD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof UserRecommendItemView) && UserRecommendLayout.this.gCA != null) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                    if (userRecommendItemView.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
                        ((com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.gCA.returnObject((UserRecommendItemView) view2);
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
        setOnHierarchyChangeListener(this.gCD);
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
        if (!v.isEmpty(list)) {
            int equipmentWidth = ((e.getEquipmentWidth(getContext()) - (getPaddingLeft() * 2)) - (this.gCB * 2)) / 3;
            this.gCC = this.gCB + equipmentWidth;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof UserRecommendItemView) {
                    UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i);
                    a(userRecommendItemView, i, equipmentWidth);
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
                    UserRecommendItemView borrowObject = this.gCA.borrowObject();
                    if (borrowObject.getParent() != null) {
                        ((ViewGroup) borrowObject.getParent()).removeView(borrowObject);
                    }
                    a(borrowObject, i3, equipmentWidth);
                    a(borrowObject, list.get(i3));
                    addView(borrowObject);
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
            layoutParams.leftMargin = this.gCB;
        }
        userRecommendItemView.setLayoutParams(layoutParams);
    }

    private void a(final UserRecommendItemView userRecommendItemView, MetaData metaData) {
        com.baidu.tbadk.core.view.userLike.c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", aq.numFormatOverWanNa(metaData.getFansNum())));
        userRecommendItemView.getUsername().setText(metaData.getName_show());
        userRecommendItemView.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void mp(int i) {
                userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", aq.numFormatOverWanNa(i)));
            }
        });
        if (userRecommendItemView.getLikeBtn().getTag() instanceof com.baidu.tbadk.core.view.userLike.c) {
            cVar = (com.baidu.tbadk.core.view.userLike.c) userRecommendItemView.getLikeBtn().getTag();
        } else {
            cVar = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, userRecommendItemView.getLikeBtn());
        }
        cVar.vA("7");
        userRecommendItemView.getLikeBtn().setTag(cVar);
        cVar.a(metaData);
        userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.hwQ);
        userRecommendItemView.getHeaderView().setData(metaData);
        userRecommendItemView.getHeaderView().setAfterClickListener(this.hwR);
        userRecommendItemView.setIsGod(metaData.isGod());
        userRecommendItemView.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.gCC;
    }

    public void setViewPool(com.baidu.adp.lib.d.b<UserRecommendItemView> bVar) {
        this.gCA = bVar;
    }

    public void setItemSpace(int i) {
        this.gCB = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.hwQ = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.hwR = onClickListener;
    }
}
