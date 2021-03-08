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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumEmotionVoteEntryView extends RelativeLayout {
    private View izp;
    private int jct;
    private int jcu;
    private LinearLayout jcv;
    private TextView title;

    public ForumEmotionVoteEntryView(Context context) {
        super(context);
        init(context);
    }

    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_emotion_vote_entry_view, this);
        this.jcv = (LinearLayout) findViewById(R.id.forum_vote_avatars);
        this.jct = context.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jcu = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.title = (TextView) findViewById(R.id.forum_emotion_vote_title);
        this.izp = findViewById(R.id.forum_vote_bottom_line);
    }

    public void setAvatarList(List<String> list) {
        this.jcv.removeAllViews();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    TbImageView tbImageView = new TbImageView(getContext());
                    tbImageView.setDrawerType(1);
                    tbImageView.setIsRound(true);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jct, this.jct);
                    layoutParams.leftMargin = this.jcu;
                    layoutParams.gravity = 17;
                    tbImageView.startLoad(str, 10, false);
                    this.jcv.addView(tbImageView, layoutParams);
                }
            }
        }
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jcv, R.color.CAM_X0201);
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        ap.setBackgroundColor(this.izp, R.color.common_color_10312);
    }
}
