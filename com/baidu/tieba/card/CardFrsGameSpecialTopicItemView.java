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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    private View ivN;
    private View ivO;
    private RelativeLayout iwn;
    private TbImageView iwo;
    private TextView iwp;
    private TextView iwq;
    private TextView iwr;
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
        this.iwn = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.iwo = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.iwp = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.iwq = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.iwr = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.ivN = findViewById(R.id.divider_line_1);
        this.ivO = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwn.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.iwn.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").ap("obj_locate", 5).dR("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.iwo;
    }

    public TextView getSpecialTopicNameView() {
        return this.iwp;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.iwr;
    }

    public TextView getSpecialTopicDscView() {
        return this.iwq;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.ivN, R.color.CAM_X0205);
            ap.setBackgroundResource(this.ivO, R.color.CAM_X0205);
            ap.setViewTextColor(this.iwp, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.iwq, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.iwr, R.color.CAM_X0101, 1);
        }
    }
}
