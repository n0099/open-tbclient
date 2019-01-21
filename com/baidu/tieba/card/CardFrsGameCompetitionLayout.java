package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
import java.util.List;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionLayout extends LinearLayout {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> cWD;
    private int cWE;
    private int cWF;
    private int cWG;
    private final ViewGroup.OnHierarchyChangeListener cWH;
    private TbPageContext pageContext;

    public CardFrsGameCompetitionLayout(Context context) {
        super(context);
        this.cWD = null;
        this.cWH = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cWD != null) {
                    CardFrsGameCompetitionLayout.this.cWD.t((CardFrsGameCompetitionItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWD = null;
        this.cWH = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cWD != null) {
                    CardFrsGameCompetitionLayout.this.cWD.t((CardFrsGameCompetitionItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWD = null;
        this.cWH = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cWD != null) {
                    CardFrsGameCompetitionLayout.this.cWD.t((CardFrsGameCompetitionItemView) view2);
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
        setOnHierarchyChangeListener(this.cWH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setData(List<FeatureCardCompetitionSubNode> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            this.cWG = this.cWF + this.cWE;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameCompetitionItemView) {
                    CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) getChildAt(i);
                    a(cardFrsGameCompetitionItemView, i, this.cWF);
                    a(cardFrsGameCompetitionItemView, list.get(i));
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
                    CardFrsGameCompetitionItemView jy = this.cWD.jy();
                    if (jy.getParent() != null) {
                        ((ViewGroup) jy.getParent()).removeView(jy);
                    }
                    a(jy, i3, this.cWF);
                    a(jy, list.get(i3));
                    addView(jy);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameCompetitionItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.cWE;
        }
        cardFrsGameCompetitionItemView.setLayoutParams(layoutParams);
    }

    private void a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView, FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        if (featureCardCompetitionSubNode != null) {
            cardFrsGameCompetitionItemView.a(featureCardCompetitionSubNode);
            cardFrsGameCompetitionItemView.setTag(featureCardCompetitionSubNode.url);
            cardFrsGameCompetitionItemView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public int getChildItemWidth() {
        return this.cWG;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> bVar) {
        this.cWD = bVar;
    }

    public void setItemSpace(int i) {
        this.cWE = i;
    }

    public void setItemWidth(int i) {
        this.cWF = i;
    }
}
