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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView egu;
    private TextView egv;
    private TextView egw;
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
        LayoutInflater.from(context).inflate(d.h.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.egu = (TbImageView) findViewById(d.g.card_frs_game_recommend_game_pic);
        this.egu.setAutoChangeStyle(true);
        this.egu.setDefaultResource(17170445);
        this.egu.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.egu.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.egu.setDrawerType(1);
        this.egu.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds26));
        this.egu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egu.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egu.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds2));
        this.egv = (TextView) findViewById(d.g.card_frs_game_recommend_game_name);
        this.egw = (TextView) findViewById(d.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").T("obj_locate", 10).bJ(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.ar(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.egu;
    }

    public TextView getGameNameView() {
        return this.egv;
    }

    public TextView getGameDscView() {
        return this.egw;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.d(this.egv, d.C0277d.cp_cont_f, 1);
            al.d(this.egw, d.C0277d.cp_cont_d, 1);
        }
    }
}
