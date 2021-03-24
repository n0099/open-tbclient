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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.a.j;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f15247e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15248f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15249g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15250h;
    public TextView i;
    public View j;
    public View k;
    public String l;
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 5).param("fid", CardFrsGameSpecialTopicItemView.this.l));
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(CardFrsGameSpecialTopicItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    public CardFrsGameSpecialTopicItemView(Context context) {
        super(context);
        this.m = 3;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
        this.f15247e = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
        this.f15248f = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
        this.f15249g = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
        this.f15250h = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
        this.i = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
        this.j = findViewById(R.id.divider_line_1);
        this.k = findViewById(R.id.divider_line_2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15247e.getLayoutParams();
        layoutParams.width = (dimensionPixelSize * 21) / 9;
        layoutParams.height = dimensionPixelSize;
        this.f15247e.setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i) {
        if (i == this.m) {
            return;
        }
        this.m = i;
        SkinManager.setBackgroundResource(this.j, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f15249g, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f15250h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
    }

    public TextView getSpecialTopicDscView() {
        return this.f15250h;
    }

    public TextView getSpecialTopicNameView() {
        return this.f15249g;
    }

    public TbImageView getSpecialTopicPicView() {
        return this.f15248f;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        return this.i;
    }

    public void setForumId(String str) {
        this.l = str;
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 3;
        b(context);
    }

    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 3;
        b(context);
    }
}
