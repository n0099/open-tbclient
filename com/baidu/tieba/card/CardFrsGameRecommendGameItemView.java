package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView iuK;
    private TextView iuL;
    private TextView iuM;
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
        this.iuK = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.iuK.setAutoChangeStyle(true);
        this.iuK.setDefaultResource(17170445);
        this.iuK.setDefaultBgResource(R.color.CAM_X0205);
        this.iuK.setDrawerType(1);
        this.iuK.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.iuK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iuK.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iuK.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.iuL = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.iuM = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").an("obj_locate", 10).dX("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.iuK;
    }

    public TextView getGameNameView() {
        return this.iuL;
    }

    public TextView getGameDscView() {
        return this.iuM;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iuL, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.iuM, R.color.CAM_X0109, 1);
        }
    }
}
