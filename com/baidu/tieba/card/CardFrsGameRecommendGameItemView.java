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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView coq;
    private TextView cor;
    private TextView cos;
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
        this.coq = (TbImageView) findViewById(d.g.card_frs_game_recommend_game_pic);
        this.coq.setAutoChangeStyle(true);
        this.coq.setDefaultResource(17170445);
        this.coq.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.coq.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.coq.setDrawerType(1);
        this.coq.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds26));
        this.coq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.coq.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.coq.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds2));
        this.cor = (TextView) findViewById(d.g.card_frs_game_recommend_game_name);
        this.cos = (TextView) findViewById(d.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getTag() instanceof String) {
                    TiebaStatic.log(new al("c13047").r("obj_locate", 10).ac(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.M(CardFrsGameRecommendGameItemView.this.getContext(), (String) view2.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.coq;
    }

    public TextView getGameNameView() {
        return this.cor;
    }

    public TextView getGameDscView() {
        return this.cos;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ak.c(this.cor, d.C0126d.cp_cont_f, 1);
            ak.c(this.cos, d.C0126d.cp_cont_d, 1);
        }
    }
}
