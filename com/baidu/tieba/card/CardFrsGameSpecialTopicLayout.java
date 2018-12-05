package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopicSubNode;
import java.util.List;
/* loaded from: classes3.dex */
public class CardFrsGameSpecialTopicLayout extends LinearLayout {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> cTb;
    private int cTc;
    private int cTd;
    private int cTe;
    private final ViewGroup.OnHierarchyChangeListener cTf;
    private TbPageContext pageContext;

    public CardFrsGameSpecialTopicLayout(Context context) {
        super(context);
        this.cTb = null;
        this.cTf = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.cTb != null) {
                    CardFrsGameSpecialTopicLayout.this.cTb.t((CardFrsGameSpecialTopicItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTb = null;
        this.cTf = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.cTb != null) {
                    CardFrsGameSpecialTopicLayout.this.cTb.t((CardFrsGameSpecialTopicItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cTb = null;
        this.cTf = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.cTb != null) {
                    CardFrsGameSpecialTopicLayout.this.cTb.t((CardFrsGameSpecialTopicItemView) view2);
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
        setOnHierarchyChangeListener(this.cTf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setData(List<FeatureCardTopicSubNode> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            this.cTe = this.cTd + this.cTc;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameSpecialTopicItemView) {
                    CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = (CardFrsGameSpecialTopicItemView) getChildAt(i);
                    a(cardFrsGameSpecialTopicItemView, i, this.cTd);
                    a(cardFrsGameSpecialTopicItemView, list.get(i));
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
                    CardFrsGameSpecialTopicItemView jy = this.cTb.jy();
                    if (jy.getParent() != null) {
                        ((ViewGroup) jy.getParent()).removeView(jy);
                    }
                    a(jy, i3, this.cTd);
                    a(jy, list.get(i3));
                    addView(jy);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameSpecialTopicItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.cTc;
        }
        cardFrsGameSpecialTopicItemView.setLayoutParams(layoutParams);
    }

    private void a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, FeatureCardTopicSubNode featureCardTopicSubNode) {
        if (featureCardTopicSubNode != null) {
            cardFrsGameSpecialTopicItemView.getSpecialTopicPicView().startLoad(featureCardTopicSubNode.image, 10, false);
            cardFrsGameSpecialTopicItemView.getSpecialTopicNameView().setText(featureCardTopicSubNode.title);
            cardFrsGameSpecialTopicItemView.getSpecialTopicDscView().setText(getContext().getResources().getString(e.j.frs_game_special_card_article_num, String.valueOf(featureCardTopicSubNode.article_num)));
            cardFrsGameSpecialTopicItemView.getSpecialTopicUpdateTimeView().setText(getContext().getString(e.j.frs_game_special_card_last_update_time, ao.J(featureCardTopicSubNode.update_time)));
            cardFrsGameSpecialTopicItemView.setTag(featureCardTopicSubNode.url);
            cardFrsGameSpecialTopicItemView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public int getChildItemWidth() {
        return this.cTe;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> bVar) {
        this.cTb = bVar;
    }

    public void setItemSpace(int i) {
        this.cTc = i;
    }

    public void setItemWidth(int i) {
        this.cTd = i;
    }
}
