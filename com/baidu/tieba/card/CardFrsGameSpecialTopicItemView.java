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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout hXI;
    private TbImageView hXJ;
    private TextView hXK;
    private TextView hXL;
    private TextView hXM;
    private View hXi;
    private View hXj;
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
        this.hXI = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.hXJ = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.hXK = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.hXL = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.hXM = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.hXi = findViewById(R.id.divider_line_1);
        this.hXj = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hXI.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.hXI.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").ak("obj_locate", 5).dR("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bf.bqF().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.hXJ;
    }

    public TextView getSpecialTopicNameView() {
        return this.hXK;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.hXM;
    }

    public TextView getSpecialTopicDscView() {
        return this.hXL;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.hXi, R.color.CAM_X0205);
            ap.setBackgroundResource(this.hXj, R.color.CAM_X0205);
            ap.setViewTextColor(this.hXK, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hXL, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hXM, R.color.CAM_X0101, 1);
        }
    }
}
