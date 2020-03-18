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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout fJI;
    private TbImageView fJJ;
    private TextView fJK;
    private TextView fJL;
    private TextView fJM;
    private View fJi;
    private View fJj;
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
        this.fJI = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.fJJ = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.fJK = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.fJL = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.fJM = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.fJi = findViewById(R.id.divider_line_1);
        this.fJj = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJI.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.fJI.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 5).cx("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.aGK().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.fJJ;
    }

    public TextView getSpecialTopicNameView() {
        return this.fJK;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.fJM;
    }

    public TextView getSpecialTopicDscView() {
        return this.fJL;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.fJi, R.color.cp_bg_line_e);
            am.setBackgroundResource(this.fJj, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fJK, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fJL, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fJM, R.color.cp_cont_a, 1);
        }
    }
}
