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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView gPX;
    private TextView gPY;
    private TextView gPZ;
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
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.gPX = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.gPX.setAutoChangeStyle(true);
        this.gPX.setDefaultResource(17170445);
        this.gPX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPX.setDrawerType(1);
        this.gPX.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.gPX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gPX.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPX.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.gPY = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.gPZ = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ao("c13047").ag("obj_locate", 10).dk("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.gPX;
    }

    public TextView getGameNameView() {
        return this.gPY;
    }

    public TextView getGameDscView() {
        return this.gPZ;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            an.setViewTextColor(this.gPY, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.gPZ, R.color.cp_cont_d, 1);
        }
    }
}
