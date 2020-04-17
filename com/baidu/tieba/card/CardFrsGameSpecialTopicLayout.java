package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopicSubNode;
import java.util.List;
/* loaded from: classes9.dex */
public class CardFrsGameSpecialTopicLayout extends LinearLayout {
    private int aPa;
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> gnA;
    private int gnB;
    private int gnC;
    private final ViewGroup.OnHierarchyChangeListener gnD;
    private TbPageContext pageContext;

    public CardFrsGameSpecialTopicLayout(Context context) {
        super(context);
        this.gnA = null;
        this.gnD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.gnA != null) {
                    CardFrsGameSpecialTopicLayout.this.gnA.returnObject((CardFrsGameSpecialTopicItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnA = null;
        this.gnD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.gnA != null) {
                    CardFrsGameSpecialTopicLayout.this.gnA.returnObject((CardFrsGameSpecialTopicItemView) view2);
                }
            }
        };
        init();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnA = null;
        this.gnD = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof CardFrsGameSpecialTopicItemView) && CardFrsGameSpecialTopicLayout.this.gnA != null) {
                    CardFrsGameSpecialTopicLayout.this.gnA.returnObject((CardFrsGameSpecialTopicItemView) view2);
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
        setOnHierarchyChangeListener(this.gnD);
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.gnC = this.aPa + this.gnB;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof CardFrsGameSpecialTopicItemView) {
                    CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = (CardFrsGameSpecialTopicItemView) getChildAt(i);
                    a(cardFrsGameSpecialTopicItemView, i, this.aPa);
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
                    CardFrsGameSpecialTopicItemView borrowObject = this.gnA.borrowObject();
                    if (borrowObject.getParent() != null) {
                        ((ViewGroup) borrowObject.getParent()).removeView(borrowObject);
                    }
                    a(borrowObject, i3, this.aPa);
                    a(borrowObject, list.get(i3));
                    addView(borrowObject);
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
            layoutParams.leftMargin = this.gnB;
        }
        cardFrsGameSpecialTopicItemView.setLayoutParams(layoutParams);
    }

    private void a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, FeatureCardTopicSubNode featureCardTopicSubNode) {
        if (featureCardTopicSubNode != null) {
            cardFrsGameSpecialTopicItemView.getSpecialTopicPicView().startLoad(featureCardTopicSubNode.image, 10, false);
            cardFrsGameSpecialTopicItemView.getSpecialTopicNameView().setText(featureCardTopicSubNode.title);
            cardFrsGameSpecialTopicItemView.getSpecialTopicDscView().setText(getContext().getResources().getString(R.string.frs_game_special_card_article_num, String.valueOf(featureCardTopicSubNode.article_num)));
            cardFrsGameSpecialTopicItemView.getSpecialTopicUpdateTimeView().setText(getContext().getString(R.string.frs_game_special_card_last_update_time, aq.getTimeInterval(featureCardTopicSubNode.update_time)));
            cardFrsGameSpecialTopicItemView.setTag(featureCardTopicSubNode.url);
            cardFrsGameSpecialTopicItemView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public int getChildItemWidth() {
        return this.gnC;
    }

    public void setViewPool(com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> bVar) {
        this.gnA = bVar;
    }

    public void setItemSpace(int i) {
        this.gnB = i;
    }

    public void setItemWidth(int i) {
        this.aPa = i;
    }
}
