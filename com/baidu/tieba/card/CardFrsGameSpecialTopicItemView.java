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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout eBA;
    private TbImageView eBB;
    private TextView eBC;
    private TextView eBD;
    private TextView eBE;
    private View eBa;
    private View eBb;
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
        this.eBA = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.eBB = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.eBC = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.eBD = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.eBE = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.eBa = findViewById(R.id.divider_line_1);
        this.eBb = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBA.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.eBA.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").P("obj_locate", 5).bT("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bb.ajC().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.eBB;
    }

    public TextView getSpecialTopicNameView() {
        return this.eBC;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.eBE;
    }

    public TextView getSpecialTopicDscView() {
        return this.eBD;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(this.eBa, R.color.cp_bg_line_e);
            am.k(this.eBb, R.color.cp_bg_line_e);
            am.f(this.eBC, R.color.cp_btn_a, 1);
            am.f(this.eBD, R.color.cp_btn_a, 1);
            am.f(this.eBE, R.color.cp_btn_a, 1);
        }
    }
}
