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
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> cWC;
    private int cWD;
    private int cWE;
    private int cWF;
    private final ViewGroup.OnHierarchyChangeListener cWG;
    private TbPageContext pageContext;

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.cWC = null;
        this.cWG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cWC != null) {
                    CardFrsGameRecommendGameLayout.this.cWC.t((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWC = null;
        this.cWG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cWC != null) {
                    CardFrsGameRecommendGameLayout.this.cWC.t((CardFrsGameRecommendGameItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWC = null;
        this.cWG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameRecommendGameItemView) && CardFrsGameRecommendGameLayout.this.cWC != null) {
                    CardFrsGameRecommendGameLayout.this.cWC.t((CardFrsGameRecommendGameItemView) view2);
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
        setOnHierarchyChangeListener(this.cWG);
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
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            this.cWF = this.cWE + this.cWD;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                    CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                    a(cardFrsGameRecommendGameItemView, i, this.cWE);
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
                    CardFrsGameRecommendGameItemView jy = this.cWC.jy();
                    if (jy.getParent() != null) {
                        ((ViewGroup) jy.getParent()).removeView(jy);
                    }
                    a(jy, i3, this.cWE);
                    a(jy, list.get(i3));
                    addView(jy);
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
            layoutParams.leftMargin = this.cWD;
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
        return this.cWF;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> bVar) {
        this.cWC = bVar;
    }

    public void setItemSpace(int i) {
        this.cWD = i;
    }

    public void setItemWidth(int i) {
        this.cWE = i;
    }
}
