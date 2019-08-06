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
    private TbImageView eBp;
    private TextView eBq;
    private TextView eBr;
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
        this.eBp = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.eBp.setAutoChangeStyle(true);
        this.eBp.setDefaultResource(17170445);
        this.eBp.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eBp.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eBp.setDrawerType(1);
        this.eBp.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.eBp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eBp.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eBp.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.eBq = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.eBr = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
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
        return this.eBp;
    }

    public TextView getGameNameView() {
        return this.eBq;
    }

    public TextView getGameDscView() {
        return this.eBr;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.f(this.eBq, R.color.cp_cont_f, 1);
            am.f(this.eBr, R.color.cp_cont_d, 1);
        }
    }
}
