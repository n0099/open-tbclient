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
    private TbImageView eBi;
    private TextView eBj;
    private TextView eBk;
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
        this.eBi = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.eBi.setAutoChangeStyle(true);
        this.eBi.setDefaultResource(17170445);
        this.eBi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eBi.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eBi.setDrawerType(1);
        this.eBi.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.eBi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eBi.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eBi.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.eBj = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.eBk = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").P("obj_locate", 10).bT("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.ae(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.eBi;
    }

    public TextView getGameNameView() {
        return this.eBj;
    }

    public TextView getGameDscView() {
        return this.eBk;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.f(this.eBj, R.color.cp_cont_f, 1);
            am.f(this.eBk, R.color.cp_cont_d, 1);
        }
    }
}
