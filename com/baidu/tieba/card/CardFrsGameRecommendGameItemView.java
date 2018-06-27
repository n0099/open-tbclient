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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView cvb;
    private TextView cvc;
    private TextView cvd;
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
        LayoutInflater.from(context).inflate(d.i.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.cvb = (TbImageView) findViewById(d.g.card_frs_game_recommend_game_pic);
        this.cvb.setAutoChangeStyle(true);
        this.cvb.setDefaultResource(17170445);
        this.cvb.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cvb.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cvb.setDrawerType(1);
        this.cvb.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds26));
        this.cvb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cvb.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cvb.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds2));
        this.cvc = (TextView) findViewById(d.g.card_frs_game_recommend_game_name);
        this.cvd = (TextView) findViewById(d.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 10).ah(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.O(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cvb;
    }

    public TextView getGameNameView() {
        return this.cvc;
    }

    public TextView getGameDscView() {
        return this.cvd;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.c(this.cvc, d.C0142d.cp_cont_f, 1);
            am.c(this.cvd, d.C0142d.cp_cont_d, 1);
        }
    }
}
