package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView cMR;
    private TextView cMS;
    private TextView cMT;
    private String mForumId;
    public int mSkinType;

    public CardFrsGameRecommendGameItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.cMR = (TbImageView) findViewById(e.g.card_frs_game_recommend_game_pic);
        this.cMR.setAutoChangeStyle(true);
        this.cMR.setDefaultResource(17170445);
        this.cMR.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cMR.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cMR.setDrawerType(1);
        this.cMR.setRadius(context.getResources().getDimensionPixelSize(e.C0200e.tbds26));
        this.cMR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cMR.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cMR.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0200e.tbds2));
        this.cMS = (TextView) findViewById(e.g.card_frs_game_recommend_game_name);
        this.cMT = (TextView) findViewById(e.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 10).ax(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.ac(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cMR;
    }

    public TextView getGameNameView() {
        return this.cMS;
    }

    public TextView getGameDscView() {
        return this.cMT;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.c(this.cMS, e.d.cp_cont_f, 1);
            al.c(this.cMT, e.d.cp_cont_d, 1);
        }
    }
}
