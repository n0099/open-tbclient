package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumEmotionVoteEntryView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15018e;

    /* renamed from: f  reason: collision with root package name */
    public int f15019f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15020g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15021h;

    /* renamed from: i  reason: collision with root package name */
    public View f15022i;

    public ForumEmotionVoteEntryView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_emotion_vote_entry_view, this);
        this.f15020g = (LinearLayout) findViewById(R.id.forum_vote_avatars);
        this.f15018e = context.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.f15019f = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f15021h = (TextView) findViewById(R.id.forum_emotion_vote_title);
        this.f15022i = findViewById(R.id.forum_vote_bottom_line);
    }

    public void b(int i2) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f15020g, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f15021h, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f15022i, R.color.common_color_10312);
    }

    public void setAvatarList(List<String> list) {
        this.f15020g.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            if (!StringUtils.isNull(str)) {
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.setDrawerType(1);
                tbImageView.setIsRound(true);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int i2 = this.f15018e;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.leftMargin = this.f15019f;
                layoutParams.gravity = 17;
                tbImageView.V(str, 10, false);
                this.f15020g.addView(tbImageView, layoutParams);
            }
        }
    }

    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
