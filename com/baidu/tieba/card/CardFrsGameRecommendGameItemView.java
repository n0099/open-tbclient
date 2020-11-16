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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView hXq;
    private TextView hXr;
    private TextView hXs;
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
        this.hXq = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.hXq.setAutoChangeStyle(true);
        this.hXq.setDefaultResource(17170445);
        this.hXq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hXq.setDefaultBgResource(R.color.CAM_X0205);
        this.hXq.setDrawerType(1);
        this.hXq.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.hXq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXq.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hXq.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.hXr = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.hXs = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").ak("obj_locate", 10).dR("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.hXq;
    }

    public TextView getGameNameView() {
        return this.hXr;
    }

    public TextView getGameDscView() {
        return this.hXs;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hXr, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.hXs, R.color.CAM_X0109, 1);
        }
    }
}
