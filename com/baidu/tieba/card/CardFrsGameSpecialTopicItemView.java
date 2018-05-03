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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View cmY;
    private View cmZ;
    private TbImageView cnA;
    private TextView cnB;
    private TextView cnC;
    private TextView cnD;
    private RelativeLayout cnz;
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
        LayoutInflater.from(context).inflate(d.i.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.cnz = (RelativeLayout) findViewById(d.g.card_frs_game_special_topic_layout);
        this.cnA = (TbImageView) findViewById(d.g.card_frs_game_special_topic_img);
        this.cnB = (TextView) findViewById(d.g.card_frs_game_special_topic_title);
        this.cnC = (TextView) findViewById(d.g.card_frs_game_special_topic_dsc);
        this.cnD = (TextView) findViewById(d.g.card_frs_game_special_topic_update_time);
        this.cmY = findViewById(d.g.divider_line_1);
        this.cmZ = findViewById(d.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnz.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cnz.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getTag() instanceof String) {
                    TiebaStatic.log(new al("c13047").r("obj_locate", 5).ac(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view2.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cnA;
    }

    public TextView getSpecialTopicNameView() {
        return this.cnB;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cnD;
    }

    public TextView getSpecialTopicDscView() {
        return this.cnC;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ak.i(this.cmY, d.C0126d.cp_bg_line_e);
            ak.i(this.cmZ, d.C0126d.cp_bg_line_e);
            ak.c(this.cnB, d.C0126d.cp_cont_i, 1);
            ak.c(this.cnC, d.C0126d.cp_cont_i_alpha80, 1);
            ak.c(this.cnD, d.C0126d.cp_cont_i_alpha80, 1);
        }
    }
}
