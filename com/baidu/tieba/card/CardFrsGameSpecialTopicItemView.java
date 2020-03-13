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
    private View fIA;
    private View fIB;
    private RelativeLayout fJa;
    private TbImageView fJb;
    private TextView fJc;
    private TextView fJd;
    private TextView fJe;
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
        this.fJa = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.fJb = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.fJc = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.fJd = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.fJe = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.fIA = findViewById(R.id.divider_line_1);
        this.fIB = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJa.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.fJa.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 5).cy("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.fJb;
    }

    public TextView getSpecialTopicNameView() {
        return this.fJc;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.fJe;
    }

    public TextView getSpecialTopicDscView() {
        return this.fJd;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.fIA, R.color.cp_bg_line_e);
            am.setBackgroundResource(this.fIB, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fJc, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fJd, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fJe, R.color.cp_cont_a, 1);
        }
    }
}
