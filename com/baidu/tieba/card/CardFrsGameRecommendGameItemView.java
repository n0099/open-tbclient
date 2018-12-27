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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    private TbImageView cWo;
    private TextView cWp;
    private TextView cWq;
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
        LayoutInflater.from(context).inflate(e.h.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        this.cWo = (TbImageView) findViewById(e.g.card_frs_game_recommend_game_pic);
        this.cWo.setAutoChangeStyle(true);
        this.cWo.setDefaultResource(17170445);
        this.cWo.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWo.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWo.setDrawerType(1);
        this.cWo.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds26));
        this.cWo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cWo.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWo.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds2));
        this.cWp = (TextView) findViewById(e.g.card_frs_game_recommend_game_name);
        this.cWq = (TextView) findViewById(e.g.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameRecommendGameItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 10).aA(ImageViewerConfig.FORUM_ID, CardFrsGameRecommendGameItemView.this.mForumId));
                    com.baidu.tbadk.browser.a.ad(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getGamePicView() {
        return this.cWo;
    }

    public TextView getGameNameView() {
        return this.cWp;
    }

    public TextView getGameDscView() {
        return this.cWq;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.c(this.cWp, e.d.cp_cont_f, 1);
            al.c(this.cWq, e.d.cp_cont_d, 1);
        }
    }
}
