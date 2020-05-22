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
    private View gCO;
    private View gCP;
    private RelativeLayout gDo;
    private TbImageView gDp;
    private TextView gDq;
    private TextView gDr;
    private TextView gDs;
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
        this.gDo = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.gDp = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.gDq = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.gDr = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.gDs = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.gCO = findViewById(R.id.divider_line_1);
        this.gCP = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDo.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.gDo.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").ag("obj_locate", 5).dh("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.aUZ().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.gDp;
    }

    public TextView getSpecialTopicNameView() {
        return this.gDq;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.gDs;
    }

    public TextView getSpecialTopicDscView() {
        return this.gDr;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.gCO, R.color.cp_bg_line_e);
            am.setBackgroundResource(this.gCP, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gDq, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gDr, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gDs, R.color.cp_cont_a, 1);
        }
    }
}
