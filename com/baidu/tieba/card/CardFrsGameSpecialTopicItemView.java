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
    private RelativeLayout hiS;
    private TbImageView hiT;
    private TextView hiU;
    private TextView hiV;
    private TextView hiW;
    private View his;
    private View hit;
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
        this.hiS = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.hiT = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.hiU = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.hiV = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.hiW = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.his = findViewById(R.id.divider_line_1);
        this.hit = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiS.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.hiS.setLayoutParams(layoutParams);
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
        return this.hiT;
    }

    public TextView getSpecialTopicNameView() {
        return this.hiU;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.hiW;
    }

    public TextView getSpecialTopicDscView() {
        return this.hiV;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.his, R.color.cp_bg_line_e);
            ap.setBackgroundResource(this.hit, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hiU, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hiV, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hiW, R.color.cp_cont_a, 1);
        }
    }
}
