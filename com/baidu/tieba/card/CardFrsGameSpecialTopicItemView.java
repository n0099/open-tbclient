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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout cxV;
    private TbImageView cxW;
    private TextView cxX;
    private TextView cxY;
    private TextView cxZ;
    private View cxv;
    private View cxw;
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
        this.cxV = (RelativeLayout) findViewById(d.g.card_frs_game_special_topic_layout);
        this.cxW = (TbImageView) findViewById(d.g.card_frs_game_special_topic_img);
        this.cxX = (TextView) findViewById(d.g.card_frs_game_special_topic_title);
        this.cxY = (TextView) findViewById(d.g.card_frs_game_special_topic_dsc);
        this.cxZ = (TextView) findViewById(d.g.card_frs_game_special_topic_update_time);
        this.cxv = findViewById(d.g.divider_line_1);
        this.cxw = findViewById(d.g.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxV.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.cxV.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 5).af(ImageViewerConfig.FORUM_ID, CardFrsGameSpecialTopicItemView.this.mForumId));
                    ay.zK().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.cxW;
    }

    public TextView getSpecialTopicNameView() {
        return this.cxX;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.cxZ;
    }

    public TextView getSpecialTopicDscView() {
        return this.cxY;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.i(this.cxv, d.C0140d.cp_bg_line_e);
            am.i(this.cxw, d.C0140d.cp_bg_line_e);
            am.c(this.cxX, d.C0140d.cp_cont_i, 1);
            am.c(this.cxY, d.C0140d.cp_cont_i_alpha80, 1);
            am.c(this.cxZ, d.C0140d.cp_cont_i_alpha80, 1);
        }
    }
}
