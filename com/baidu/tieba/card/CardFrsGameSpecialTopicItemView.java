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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View egA;
    private View egB;
    private RelativeLayout eha;
    private TbImageView ehb;
    private TextView ehc;
    private TextView ehd;
    private TextView ehe;
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
        LayoutInflater.from(context).inflate(d.h.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.eha = (RelativeLayout) findViewById(d.g.card_frs_game_special_topic_layout);
        this.ehb = (TbImageView) findViewById(d.g.card_frs_game_special_topic_img);
        this.ehc = (TextView) findViewById(d.g.card_frs_game_special_topic_title);
        this.ehd = (TextView) findViewById(d.g.card_frs_game_special_topic_dsc);
        this.ehe = (TextView) findViewById(d.g.card_frs_game_special_topic_update_time);
        this.egA = findViewById(d.g.divider_line_1);
        this.egB = findViewById(d.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eha.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.eha.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").T("obj_locate", 5).bJ(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ba.adD().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.ehb;
    }

    public TextView getSpecialTopicNameView() {
        return this.ehc;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.ehe;
    }

    public TextView getSpecialTopicDscView() {
        return this.ehd;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.egA, d.C0277d.cp_bg_line_e);
            al.k(this.egB, d.C0277d.cp_bg_line_e);
            al.d(this.ehc, d.C0277d.cp_btn_a, 1);
            al.d(this.ehd, d.C0277d.cp_btn_a, 1);
            al.d(this.ehe, d.C0277d.cp_btn_a, 1);
        }
    }
}
