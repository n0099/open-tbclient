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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView hWQ;
    private TextView hWR;
    private TextView hWS;
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
        this.hWQ = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.hWQ.setAutoChangeStyle(true);
        this.hWQ.setDefaultResource(17170445);
        this.hWQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWQ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hWQ.setDrawerType(1);
        this.hWQ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.hWQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hWQ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWQ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.hWR = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.hWS = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").al("obj_locate", 10).dR("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.hWQ;
    }

    public TextView getGameNameView() {
        return this.hWR;
    }

    public TextView getGameDscView() {
        return this.hWS;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hWR, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hWS, R.color.cp_cont_d, 1);
        }
    }
}
