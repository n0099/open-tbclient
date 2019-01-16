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
    private TbImageView cWZ;
    private TextView cXa;
    private TextView cXb;
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
        this.cWZ = (TbImageView) findViewById(e.g.card_frs_game_recommend_game_pic);
        this.cWZ.setAutoChangeStyle(true);
        this.cWZ.setDefaultResource(17170445);
        this.cWZ.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWZ.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWZ.setDrawerType(1);
        this.cWZ.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds26));
        this.cWZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cWZ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWZ.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds2));
        this.cXa = (TextView) findViewById(e.g.card_frs_game_recommend_game_name);
        this.cXb = (TextView) findViewById(e.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").y("obj_locate", 10).aB(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.ad(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cWZ;
    }

    public TextView getGameNameView() {
        return this.cXa;
    }

    public TextView getGameDscView() {
        return this.cXb;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.c(this.cXa, e.d.cp_cont_f, 1);
            al.c(this.cXb, e.d.cp_cont_d, 1);
        }
    }
}
