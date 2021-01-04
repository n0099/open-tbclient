package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View iuC;
    private View iuD;
    private RelativeLayout ivc;
    private TbImageView ivd;
    private TextView ive;
    private TextView ivf;
    private TextView ivg;
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
        this.ivc = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.ivd = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.ive = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.ivf = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.ivg = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.iuC = findViewById(R.id.divider_line_1);
        this.iuD = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivc.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.ivc.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").an("obj_locate", 5).dX("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    be.bwu().a((TbPageContext) com.baidu.adp.base.j.K(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.ivd;
    }

    public TextView getSpecialTopicNameView() {
        return this.ive;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.ivg;
    }

    public TextView getSpecialTopicDscView() {
        return this.ivf;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.iuC, R.color.CAM_X0205);
            ao.setBackgroundResource(this.iuD, R.color.CAM_X0205);
            ao.setViewTextColor(this.ive, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ivf, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ivg, R.color.CAM_X0101, 1);
        }
    }
}
