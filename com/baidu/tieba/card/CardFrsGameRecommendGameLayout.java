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
/* loaded from: classes9.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {
    private int aPg;
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> gnG;
    private int gnH;
    private int gnI;
    private final ViewGroup.OnHierarchyChangeListener gnJ;
    private TbPageContext pageContext;

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.gnG = null;
        this.gnJ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.gnG != null) {
                    CardFrsGameRecommendGameLayout.this.gnG.returnObject((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnG = null;
        this.gnJ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.gnG != null) {
                    CardFrsGameRecommendGameLayout.this.gnG.returnObject((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnG = null;
        this.gnJ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.gnG != null) {
                    CardFrsGameRecommendGameLayout.this.gnG.returnObject((CardFrsGameRecommendGameItemView) view2);
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
        setOnHierarchyChangeListener(this.gnJ);
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.gnI = this.aPg + this.gnH;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                    CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                    a(cardFrsGameRecommendGameItemView, i, this.aPg);
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
                    CardFrsGameRecommendGameItemView borrowObject = this.gnG.borrowObject();
                    if (borrowObject.getParent() != null) {
                        ((ViewGroup) borrowObject.getParent()).removeView(borrowObject);
                    }
                    a(borrowObject, i3, this.aPg);
                    a(borrowObject, list.get(i3));
                    addView(borrowObject);
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
            layoutParams.leftMargin = this.gnH;
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
        return this.gnI;
    }

    public void setViewPool(com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> bVar) {
        this.gnG = bVar;
    }

    public void setItemSpace(int i) {
        this.gnH = i;
    }

    public void setItemWidth(int i) {
        this.aPg = i;
    }
}
