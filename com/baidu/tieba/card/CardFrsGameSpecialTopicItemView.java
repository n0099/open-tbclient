package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout ewA;
    private TbImageView ewB;
    private TextView ewC;
    private TextView ewD;
    private TextView ewE;
    private View ewa;
    private View ewb;
    private String mForumId;
    public int mSkinType;

    public CardFrsGameSpecialTopicItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.ewA = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.ewB = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.ewC = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.ewD = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.ewE = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.ewa = findViewById(R.id.divider_line_1);
        this.ewb = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ewA.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.ewA.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").P("obj_locate", 5).bT("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.aiz().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.ewB;
    }

    public TextView getSpecialTopicNameView() {
        return this.ewC;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.ewE;
    }

    public TextView getSpecialTopicDscView() {
        return this.ewD;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.ewa, R.color.cp_bg_line_e);
            al.k(this.ewb, R.color.cp_bg_line_e);
            al.f(this.ewC, R.color.cp_btn_a, 1);
            al.f(this.ewD, R.color.cp_btn_a, 1);
            al.f(this.ewE, R.color.cp_btn_a, 1);
        }
    }
}
