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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View cMJ;
    private View cMK;
    private RelativeLayout cNj;
    private TbImageView cNk;
    private TextView cNl;
    private TextView cNm;
    private TextView cNn;
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
        LayoutInflater.from(context).inflate(e.h.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.cNj = (RelativeLayout) findViewById(e.g.card_frs_game_special_topic_layout);
        this.cNk = (TbImageView) findViewById(e.g.card_frs_game_special_topic_img);
        this.cNl = (TextView) findViewById(e.g.card_frs_game_special_topic_title);
        this.cNm = (TextView) findViewById(e.g.card_frs_game_special_topic_dsc);
        this.cNn = (TextView) findViewById(e.g.card_frs_game_special_topic_update_time);
        this.cMJ = findViewById(e.g.divider_line_1);
        this.cMK = findViewById(e.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0200e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNj.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cNj.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 5).ax(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ay.Db().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cNk;
    }

    public TextView getSpecialTopicNameView() {
        return this.cNl;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cNn;
    }

    public TextView getSpecialTopicDscView() {
        return this.cNm;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(this.cMJ, e.d.cp_bg_line_e);
            al.i(this.cMK, e.d.cp_bg_line_e);
            al.c(this.cNl, e.d.cp_cont_i, 1);
            al.c(this.cNm, e.d.cp_cont_i_alpha80, 1);
            al.c(this.cNn, e.d.cp_cont_i_alpha80, 1);
        }
    }
}
