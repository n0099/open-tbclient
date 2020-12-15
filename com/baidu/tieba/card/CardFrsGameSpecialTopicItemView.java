package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private RelativeLayout iiH;
    private TbImageView iiI;
    private TextView iiJ;
    private TextView iiK;
    private TextView iiL;
    private View iih;
    private View iii;
    private String mForumId;
    public int mSkinType;

    public CardFrsGameSpecialTopicItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.iiH = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.iiI = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.iiJ = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.iiK = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.iiL = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.iih = findViewById(R.id.divider_line_1);
        this.iii = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iiH.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.iiH.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").al("obj_locate", 5).dY("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.iiI;
    }

    public TextView getSpecialTopicNameView() {
        return this.iiJ;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.iiL;
    }

    public TextView getSpecialTopicDscView() {
        return this.iiK;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.iih, R.color.CAM_X0205);
            ap.setBackgroundResource(this.iii, R.color.CAM_X0205);
            ap.setViewTextColor(this.iiJ, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.iiK, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.iiL, R.color.CAM_X0101, 1);
        }
    }
}
