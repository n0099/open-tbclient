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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView gCW;
    private TextView gCX;
    private TextView gCY;
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
        this.gCW = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.gCW.setAutoChangeStyle(true);
        this.gCW.setDefaultResource(17170445);
        this.gCW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCW.setDrawerType(1);
        this.gCW.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.gCW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gCW.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCW.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.gCX = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.gCY = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").ag("obj_locate", 10).dh("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.gCW;
    }

    public TextView getGameNameView() {
        return this.gCX;
    }

    public TextView getGameDscView() {
        return this.gCY;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.gCX, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.gCY, R.color.cp_cont_d, 1);
        }
    }
}
