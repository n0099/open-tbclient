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
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout eLX;
    private TbImageView eLY;
    private TextView eLZ;
    private View eLx;
    private View eLy;
    private TextView eMa;
    private TextView eMb;
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
        this.eLX = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.eLY = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.eLZ = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.eMa = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.eMb = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.eLx = findViewById(R.id.divider_line_1);
        this.eLy = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLX.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.eLX.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").O("obj_locate", 5).bS("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.amQ().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.eLY;
    }

    public TextView getSpecialTopicNameView() {
        return this.eLZ;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.eMb;
    }

    public TextView getSpecialTopicDscView() {
        return this.eMa;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.eLx, R.color.cp_bg_line_e);
            am.setBackgroundResource(this.eLy, R.color.cp_bg_line_e);
            am.setViewTextColor(this.eLZ, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eMa, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eMb, R.color.cp_cont_a, 1);
        }
    }
}
