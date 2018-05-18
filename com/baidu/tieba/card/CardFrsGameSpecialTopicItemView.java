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
    private RelativeLayout coI;
    private TbImageView coJ;
    private TextView coK;
    private TextView coL;
    private TextView coM;
    private View coi;
    private View coj;
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
        this.coI = (RelativeLayout) findViewById(d.g.card_frs_game_special_topic_layout);
        this.coJ = (TbImageView) findViewById(d.g.card_frs_game_special_topic_img);
        this.coK = (TextView) findViewById(d.g.card_frs_game_special_topic_title);
        this.coL = (TextView) findViewById(d.g.card_frs_game_special_topic_dsc);
        this.coM = (TextView) findViewById(d.g.card_frs_game_special_topic_update_time);
        this.coi = findViewById(d.g.divider_line_1);
        this.coj = findViewById(d.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coI.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.coI.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getTag() instanceof String) {
                    TiebaStatic.log(new al("c13047").r("obj_locate", 5).ac(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ax.wf().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view2.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.coJ;
    }

    public TextView getSpecialTopicNameView() {
        return this.coK;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.coM;
    }

    public TextView getSpecialTopicDscView() {
        return this.coL;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ak.i(this.coi, d.C0126d.cp_bg_line_e);
            ak.i(this.coj, d.C0126d.cp_bg_line_e);
            ak.c(this.coK, d.C0126d.cp_cont_i, 1);
            ak.c(this.coL, d.C0126d.cp_cont_i_alpha80, 1);
            ak.c(this.coM, d.C0126d.cp_cont_i_alpha80, 1);
        }
    }
}
