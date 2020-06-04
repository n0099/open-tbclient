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
    private View gCZ;
    private TbImageView gDA;
    private TextView gDB;
    private TextView gDC;
    private TextView gDD;
    private View gDa;
    private RelativeLayout gDz;
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
        this.gDz = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.gDA = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.gDB = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.gDC = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.gDD = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.gCZ = findViewById(R.id.divider_line_1);
        this.gDa = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDz.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.gDz.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").ag("obj_locate", 5).dh("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.aVa().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.gDA;
    }

    public TextView getSpecialTopicNameView() {
        return this.gDB;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.gDD;
    }

    public TextView getSpecialTopicDscView() {
        return this.gDC;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.gCZ, R.color.cp_bg_line_e);
            am.setBackgroundResource(this.gDa, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gDB, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gDC, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gDD, R.color.cp_cont_a, 1);
        }
    }
}
