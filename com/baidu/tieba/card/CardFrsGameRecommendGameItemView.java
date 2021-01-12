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
    private TbImageView iqd;
    private TextView iqe;
    private TextView iqf;
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
        this.iqd = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.iqd.setAutoChangeStyle(true);
        this.iqd.setDefaultResource(17170445);
        this.iqd.setDefaultBgResource(R.color.CAM_X0205);
        this.iqd.setDrawerType(1);
        this.iqd.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.iqd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iqd.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iqd.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.iqe = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.iqf = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").an("obj_locate", 10).dW("fid", CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.startWebActivity(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.iqd;
    }

    public TextView getGameNameView() {
        return this.iqe;
    }

    public TextView getGameDscView() {
        return this.iqf;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iqe, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.iqf, R.color.CAM_X0109, 1);
        }
    }
}
