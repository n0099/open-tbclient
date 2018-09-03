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
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> cxd;
    private int cxe;
    private int cxf;
    private int cxg;
    private final ViewGroup.OnHierarchyChangeListener cxh;
    private TbPageContext pageContext;

    public CardFrsGameCompetitionLayout(Context context) {
        super(context);
        this.cxd = null;
        this.cxh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cxd != null) {
                    CardFrsGameCompetitionLayout.this.cxd.p((CardFrsGameCompetitionItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxd = null;
        this.cxh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cxd != null) {
                    CardFrsGameCompetitionLayout.this.cxd.p((CardFrsGameCompetitionItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxd = null;
        this.cxh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameCompetitionItemView) && CardFrsGameCompetitionLayout.this.cxd != null) {
                    CardFrsGameCompetitionLayout.this.cxd.p((CardFrsGameCompetitionItemView) view2);
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
        setOnHierarchyChangeListener(this.cxh);
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
        if (!com.baidu.tbadk.core.util.w.z(list)) {
            this.cxg = this.cxf + this.cxe;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameCompetitionItemView) {
                    CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) getChildAt(i);
                    a(cardFrsGameCompetitionItemView, i, this.cxf);
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
                    CardFrsGameCompetitionItemView m9if = this.cxd.m9if();
                    if (m9if.getParent() != null) {
                        ((ViewGroup) m9if.getParent()).removeView(m9if);
                    }
                    a(m9if, i3, this.cxf);
                    a(m9if, list.get(i3));
                    addView(m9if);
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
            layoutParams.leftMargin = this.cxe;
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
        return this.cxg;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> bVar) {
        this.cxd = bVar;
    }

    public void setItemSpace(int i) {
        this.cxe = i;
    }

    public void setItemWidth(int i) {
        this.cxf = i;
    }
}
