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
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> efX;
    private int efY;
    private int efZ;
    private int ega;
    private final ViewGroup.OnHierarchyChangeListener egb;
    private TbPageContext pageContext;

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.efX = null;
        this.egb = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.efX != null) {
                    CardFrsGameRecommendGameLayout.this.efX.t((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efX = null;
        this.egb = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.efX != null) {
                    CardFrsGameRecommendGameLayout.this.efX.t((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efX = null;
        this.egb = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.efX != null) {
                    CardFrsGameRecommendGameLayout.this.efX.t((CardFrsGameRecommendGameItemView) view2);
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
        setOnHierarchyChangeListener(this.egb);
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
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            this.ega = this.efZ + this.efY;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                    CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                    a(cardFrsGameRecommendGameItemView, i, this.efZ);
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
                    CardFrsGameRecommendGameItemView jA = this.efX.jA();
                    if (jA.getParent() != null) {
                        ((ViewGroup) jA.getParent()).removeView(jA);
                    }
                    a(jA, i3, this.efZ);
                    a(jA, list.get(i3));
                    addView(jA);
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
            layoutParams.leftMargin = this.efY;
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
        return this.ega;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> bVar) {
        this.efX = bVar;
    }

    public void setItemSpace(int i) {
        this.efY = i;
    }

    public void setItemWidth(int i) {
        this.efZ = i;
    }
}
