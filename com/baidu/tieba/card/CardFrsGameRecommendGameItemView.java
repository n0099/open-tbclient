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
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView eKO;
    private TextView eKP;
    private TextView eKQ;
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
        this.eKO = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.eKO.setAutoChangeStyle(true);
        this.eKO.setDefaultResource(17170445);
        this.eKO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKO.setDrawerType(1);
        this.eKO.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.eKO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKO.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKO.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.eKP = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.eKQ = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").O("obj_locate", 10).bS("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.eKO;
    }

    public TextView getGameNameView() {
        return this.eKP;
    }

    public TextView getGameDscView() {
        return this.eKQ;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.eKP, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eKQ, R.color.cp_cont_d, 1);
        }
    }
}
