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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView cwU;
    private TextView cwV;
    private TextView cwW;
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
        LayoutInflater.from(context).inflate(d.i.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.cwU = (TbImageView) findViewById(d.g.card_frs_game_recommend_game_pic);
        this.cwU.setAutoChangeStyle(true);
        this.cwU.setDefaultResource(17170445);
        this.cwU.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwU.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cwU.setDrawerType(1);
        this.cwU.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds26));
        this.cwU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cwU.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cwU.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds2));
        this.cwV = (TextView) findViewById(d.g.card_frs_game_recommend_game_name);
        this.cwW = (TextView) findViewById(d.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").r("obj_locate", 10).ah(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.O(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cwU;
    }

    public TextView getGameNameView() {
        return this.cwV;
    }

    public TextView getGameDscView() {
        return this.cwW;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.c(this.cwV, d.C0141d.cp_cont_f, 1);
            al.c(this.cwW, d.C0141d.cp_cont_d, 1);
        }
    }
}
