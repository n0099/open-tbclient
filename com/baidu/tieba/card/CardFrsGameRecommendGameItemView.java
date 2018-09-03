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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView cxA;
    private TextView cxB;
    private TextView cxC;
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
        LayoutInflater.from(context).inflate(f.h.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.cxA = (TbImageView) findViewById(f.g.card_frs_game_recommend_game_pic);
        this.cxA.setAutoChangeStyle(true);
        this.cxA.setDefaultResource(17170445);
        this.cxA.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cxA.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cxA.setDrawerType(1);
        this.cxA.setRadius(context.getResources().getDimensionPixelSize(f.e.tbds26));
        this.cxA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cxA.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cxA.setBorderWidth(context.getResources().getDimensionPixelSize(f.e.tbds2));
        this.cxB = (TextView) findViewById(f.g.card_frs_game_recommend_game_name);
        this.cxC = (TextView) findViewById(f.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 10).ae(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.Q(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cxA;
    }

    public TextView getGameNameView() {
        return this.cxB;
    }

    public TextView getGameDscView() {
        return this.cxC;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.c(this.cxB, f.d.cp_cont_f, 1);
            am.c(this.cxC, f.d.cp_cont_d, 1);
        }
    }
}
