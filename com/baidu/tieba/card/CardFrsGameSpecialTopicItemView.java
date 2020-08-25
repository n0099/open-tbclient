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
/* loaded from: classes16.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout hiO;
    private TbImageView hiP;
    private TextView hiQ;
    private TextView hiR;
    private TextView hiS;
    private View hio;
    private View hip;
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
        this.hiO = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.hiP = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.hiQ = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.hiR = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.hiS = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.hio = findViewById(R.id.divider_line_1);
        this.hip = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiO.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.hiO.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").ai("obj_locate", 5).dD("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    be.bju().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.hiP;
    }

    public TextView getSpecialTopicNameView() {
        return this.hiQ;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.hiS;
    }

    public TextView getSpecialTopicDscView() {
        return this.hiR;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.hio, R.color.cp_bg_line_e);
            ap.setBackgroundResource(this.hip, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hiQ, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hiR, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hiS, R.color.cp_cont_a, 1);
        }
    }
}
