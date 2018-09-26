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
    private RelativeLayout cDI;
    private TbImageView cDJ;
    private TextView cDK;
    private TextView cDL;
    private TextView cDM;
    private View cDi;
    private View cDj;
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
        this.cDI = (RelativeLayout) findViewById(e.g.card_frs_game_special_topic_layout);
        this.cDJ = (TbImageView) findViewById(e.g.card_frs_game_special_topic_img);
        this.cDK = (TextView) findViewById(e.g.card_frs_game_special_topic_title);
        this.cDL = (TextView) findViewById(e.g.card_frs_game_special_topic_dsc);
        this.cDM = (TextView) findViewById(e.g.card_frs_game_special_topic_update_time);
        this.cDi = findViewById(e.g.divider_line_1);
        this.cDj = findViewById(e.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0141e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cDI.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cDI.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").w("obj_locate", 5).al(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ay.AN().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cDJ;
    }

    public TextView getSpecialTopicNameView() {
        return this.cDK;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cDM;
    }

    public TextView getSpecialTopicDscView() {
        return this.cDL;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(this.cDi, e.d.cp_bg_line_e);
            al.i(this.cDj, e.d.cp_bg_line_e);
            al.c(this.cDK, e.d.cp_cont_i, 1);
            al.c(this.cDL, e.d.cp_cont_i_alpha80, 1);
            al.c(this.cDM, e.d.cp_cont_i_alpha80, 1);
        }
    }
}
