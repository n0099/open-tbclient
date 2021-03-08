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
    private RelativeLayout ixW;
    private TbImageView ixX;
    private TextView ixY;
    private TextView ixZ;
    private View ixw;
    private View ixx;
    private TextView iya;
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
        this.ixW = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.ixX = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.ixY = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.ixZ = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.iya = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.ixw = findViewById(R.id.divider_line_1);
        this.ixx = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixW.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.ixW.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameSpecialTopicItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").aq("obj_locate", 5).dR("fid", CardFrsGameSpecialTopicItemView.this.mForumId));
                    bf.bsY().a((TbPageContext) com.baidu.adp.base.j.J(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.ixX;
    }

    public TextView getSpecialTopicNameView() {
        return this.ixY;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.iya;
    }

    public TextView getSpecialTopicDscView() {
        return this.ixZ;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.ixw, R.color.CAM_X0205);
            ap.setBackgroundResource(this.ixx, R.color.CAM_X0205);
            ap.setViewTextColor(this.ixY, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ixZ, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.iya, R.color.CAM_X0101, 1);
        }
    }
}
