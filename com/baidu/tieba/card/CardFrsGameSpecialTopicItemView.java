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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View cwM;
    private View cwN;
    private RelativeLayout cxm;
    private TbImageView cxn;
    private TextView cxo;
    private TextView cxp;
    private TextView cxq;
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
        this.cxm = (RelativeLayout) findViewById(d.g.card_frs_game_special_topic_layout);
        this.cxn = (TbImageView) findViewById(d.g.card_frs_game_special_topic_img);
        this.cxo = (TextView) findViewById(d.g.card_frs_game_special_topic_title);
        this.cxp = (TextView) findViewById(d.g.card_frs_game_special_topic_dsc);
        this.cxq = (TextView) findViewById(d.g.card_frs_game_special_topic_update_time);
        this.cwM = findViewById(d.g.divider_line_1);
        this.cwN = findViewById(d.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxm.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cxm.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").r("obj_locate", 5).ah(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ay.zG().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cxn;
    }

    public TextView getSpecialTopicNameView() {
        return this.cxo;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cxq;
    }

    public TextView getSpecialTopicDscView() {
        return this.cxp;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(this.cwM, d.C0141d.cp_bg_line_e);
            al.i(this.cwN, d.C0141d.cp_bg_line_e);
            al.c(this.cxo, d.C0141d.cp_cont_i, 1);
            al.c(this.cxp, d.C0141d.cp_cont_i_alpha80, 1);
            al.c(this.cxq, d.C0141d.cp_cont_i_alpha80, 1);
        }
    }
}
