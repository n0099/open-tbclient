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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View hWI;
    private View hWJ;
    private RelativeLayout hXi;
    private TbImageView hXj;
    private TextView hXk;
    private TextView hXl;
    private TextView hXm;
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
        this.hXi = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.hXj = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.hXk = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.hXl = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.hXm = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.hWI = findViewById(R.id.divider_line_1);
        this.hWJ = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hXi.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.hXi.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").al("obj_locate", 5).dR("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    be.brr().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.hXj;
    }

    public TextView getSpecialTopicNameView() {
        return this.hXk;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.hXm;
    }

    public TextView getSpecialTopicDscView() {
        return this.hXl;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.hWI, R.color.cp_bg_line_e);
            ap.setBackgroundResource(this.hWJ, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hXk, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hXl, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hXm, R.color.cp_cont_a, 1);
        }
    }
}
