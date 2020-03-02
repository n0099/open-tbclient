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
    private TbImageView fIv;
    private TextView fIw;
    private TextView fIx;
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
        this.fIv = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.fIv.setAutoChangeStyle(true);
        this.fIv.setDefaultResource(17170445);
        this.fIv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIv.setDrawerType(1);
        this.fIv.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.fIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fIv.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIv.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.fIw = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.fIx = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 10).cy("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.fIv;
    }

    public TextView getGameNameView() {
        return this.fIw;
    }

    public TextView getGameDscView() {
        return this.fIx;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.fIw, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fIx, R.color.cp_cont_d, 1);
        }
    }
}
