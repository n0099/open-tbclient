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
    private RelativeLayout cTQ;
    private TbImageView cTR;
    private TextView cTS;
    private TextView cTT;
    private TextView cTU;
    private View cTq;
    private View cTr;
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
        this.cTQ = (RelativeLayout) findViewById(e.g.card_frs_game_special_topic_layout);
        this.cTR = (TbImageView) findViewById(e.g.card_frs_game_special_topic_img);
        this.cTS = (TextView) findViewById(e.g.card_frs_game_special_topic_title);
        this.cTT = (TextView) findViewById(e.g.card_frs_game_special_topic_dsc);
        this.cTU = (TextView) findViewById(e.g.card_frs_game_special_topic_update_time);
        this.cTq = findViewById(e.g.divider_line_1);
        this.cTr = findViewById(e.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0210e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cTQ.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cTQ.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 5).aA(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cTR;
    }

    public TextView getSpecialTopicNameView() {
        return this.cTS;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cTU;
    }

    public TextView getSpecialTopicDscView() {
        return this.cTT;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(this.cTq, e.d.cp_bg_line_e);
            al.i(this.cTr, e.d.cp_bg_line_e);
            al.c(this.cTS, e.d.cp_cont_i, 1);
            al.c(this.cTT, e.d.cp_cont_i_alpha80, 1);
            al.c(this.cTU, e.d.cp_cont_i_alpha80, 1);
        }
    }
}
