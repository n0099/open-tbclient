package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGameSubNode;
import java.util.List;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> cnT;
    private int cnU;
    private int cnV;
    private int cnW;
    private final ViewGroup.OnHierarchyChangeListener cnX;
    private TbPageContext pageContext;

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.cnT = null;
        this.cnX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cnT != null) {
                    CardFrsGameRecommendGameLayout.this.cnT.m((CardFrsGameRecommendGameItemView) view3);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnT = null;
        this.cnX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cnT != null) {
                    CardFrsGameRecommendGameLayout.this.cnT.m((CardFrsGameRecommendGameItemView) view3);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnT = null;
        this.cnX = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cnT != null) {
                    CardFrsGameRecommendGameLayout.this.cnT.m((CardFrsGameRecommendGameItemView) view3);
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
        setGravity(17);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.cnX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setData(List<FeatureCardGameSubNode> list) {
        if (!com.baidu.tbadk.core.util.v.w(list)) {
            this.cnW = this.cnV + this.cnU;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                    CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                    a(cardFrsGameRecommendGameItemView, i, this.cnV);
                    a(cardFrsGameRecommendGameItemView, list.get(i));
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
                    CardFrsGameRecommendGameItemView fn = this.cnT.fn();
                    if (fn.getParent() != null) {
                        ((ViewGroup) fn.getParent()).removeView(fn);
                    }
                    a(fn, i3, this.cnV);
                    a(fn, list.get(i3));
                    addView(fn);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameRecommendGameItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.cnU;
        }
        cardFrsGameRecommendGameItemView.setLayoutParams(layoutParams);
    }

    private void a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, FeatureCardGameSubNode featureCardGameSubNode) {
        if (featureCardGameSubNode != null) {
            cardFrsGameRecommendGameItemView.getGamePicView().startLoad(featureCardGameSubNode.image, 10, false);
            cardFrsGameRecommendGameItemView.getGameNameView().setText(featureCardGameSubNode.name);
            cardFrsGameRecommendGameItemView.getGameDscView().setText(featureCardGameSubNode.title);
            cardFrsGameRecommendGameItemView.setTag(featureCardGameSubNode.url);
            cardFrsGameRecommendGameItemView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public int getChildItemWidth() {
        return this.cnW;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> bVar) {
        this.cnT = bVar;
    }

    public void setItemSpace(int i) {
        this.cnU = i;
    }

    public void setItemWidth(int i) {
        this.cnV = i;
    }
}
