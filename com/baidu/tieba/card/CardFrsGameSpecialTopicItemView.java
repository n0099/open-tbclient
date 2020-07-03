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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View gPP;
    private View gPQ;
    private RelativeLayout gQp;
    private TbImageView gQq;
    private TextView gQr;
    private TextView gQs;
    private TextView gQt;
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
        this.gQp = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.gQq = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.gQr = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.gQs = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.gQt = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.gPP = findViewById(R.id.divider_line_1);
        this.gPQ = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gQp.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.gQp.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ao("c13047").ag("obj_locate", 5).dk("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bc.aWU().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.gQq;
    }

    public TextView getSpecialTopicNameView() {
        return this.gQr;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.gQt;
    }

    public TextView getSpecialTopicDscView() {
        return this.gQs;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            an.setBackgroundResource(this.gPP, R.color.cp_bg_line_e);
            an.setBackgroundResource(this.gPQ, R.color.cp_bg_line_e);
            an.setViewTextColor(this.gQr, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gQs, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gQt, R.color.cp_cont_a, 1);
        }
    }
}
