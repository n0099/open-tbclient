package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tbadk.editortool.w;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.forumdetail.ForumDetailData;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class ItemInfoView extends RelativeLayout {
    private Context a;
    private ViewGroup b;
    private TextView c;
    private ViewGroup d;
    private TextView e;
    private TextView f;
    private ViewGroup g;
    private TextView h;
    private TextView i;
    private ViewGroup j;

    public ItemInfoView(Context context) {
        super(context);
        a(context);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.forum_detail_info, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(com.baidu.tieba.a.h.info_brief_box);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.info_brief_content);
        this.d = (ViewGroup) findViewById(com.baidu.tieba.a.h.info_dir_box);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.info_dir_name);
        this.f = (TextView) findViewById(com.baidu.tieba.a.h.info_rank_divider_line);
        this.g = (ViewGroup) findViewById(com.baidu.tieba.a.h.info_rank_box);
        this.h = (TextView) findViewById(com.baidu.tieba.a.h.info_rank_content);
        this.i = (TextView) findViewById(com.baidu.tieba.a.h.info_badge_divider_line);
        this.j = (ViewGroup) findViewById(com.baidu.tieba.a.h.info_badge_box);
    }

    public final boolean a(ForumDetailData forumDetailData, com.baidu.tbadk.a aVar) {
        boolean z;
        if (forumDetailData == null || (forumDetailData.forumInfo != null && forumDetailData.forumInfo.contents.length == 0 && bc.c(forumDetailData.forumInfo.slogan) && forumDetailData.badges.length == 0 && forumDetailData.forumDir == null)) {
            return false;
        }
        boolean equals = aVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.BAR_DIR.toString());
        if (forumDetailData.forumDir != null) {
            String str = forumDetailData.forumDir.levelTwoName;
            String str2 = forumDetailData.forumDir.levelOneName;
            String valueOf = String.valueOf(forumDetailData.forumDir.levelOneMenuType);
            String valueOf2 = String.valueOf(forumDetailData.forumDir.levelOneMenuID);
            if (bc.c(str)) {
                z = false;
            } else {
                this.e.setText(str);
                this.d.setVisibility(0);
                this.d.setOnClickListener(new m(this, equals, str2, valueOf2, valueOf, str, aVar));
                z = true;
            }
            if (forumDetailData.forumDir.rank != 0 || this.d.getVisibility() == 0) {
                if (forumDetailData.forumDir.rank != 0) {
                    this.h.setText(String.valueOf(forumDetailData.forumDir.rank));
                } else {
                    this.h.setText(getResources().getString(com.baidu.tieba.a.k.forum_detail_info_no_rank));
                }
                if (this.d.getVisibility() == 8 && this.b.getVisibility() == 0) {
                    this.f.setVisibility(0);
                }
                this.g.setVisibility(0);
                z = true;
            }
        } else {
            z = false;
        }
        if ((forumDetailData.forumInfo != null && forumDetailData.forumInfo.contents != null && forumDetailData.forumInfo.contents.length > 0) || !bc.c(forumDetailData.forumInfo.slogan)) {
            TextView textView = this.c;
            ForumDetailData.ForumContent[] forumContentArr = forumDetailData.forumInfo.contents;
            String str3 = forumDetailData.forumInfo.slogan;
            w wVar = new w();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(str3) + IOUtils.LINE_SEPARATOR_UNIX);
            int length = forumContentArr.length;
            for (int i = 0; i < length; i++) {
                if (forumContentArr[i].type == 2) {
                    Bitmap a = com.baidu.tbadk.core.util.g.a(wVar.a(forumContentArr[i].text));
                    if (a != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                        bitmapDrawable.setBounds(0, 0, a.getWidth(), a.getHeight());
                        ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
                        int length2 = spannableStringBuilder.length() - 1;
                        spannableStringBuilder.setSpan(imageSpan, length2, length2 + 1, 33);
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) forumContentArr[i].text);
                }
            }
            textView.setText(spannableStringBuilder);
            this.b.setVisibility(0);
            z = true;
        } else if (this.d.getVisibility() == 0) {
            this.c.setText(getResources().getString(com.baidu.tieba.a.k.forum_detail_info_no_brief));
            this.b.setVisibility(0);
            z = true;
        }
        if (forumDetailData.badges.length > 0) {
            if (this.d.getVisibility() == 0 || (this.d.getVisibility() == 8 && (this.b.getVisibility() == 0 || this.g.getVisibility() == 0))) {
                this.i.setVisibility(0);
            }
            a(forumDetailData);
            return true;
        }
        return z;
    }

    private void a(ForumDetailData forumDetailData) {
        aa aaVar = new aa(this.a);
        int a = com.baidu.adp.lib.util.i.a(this.a, 20.0f);
        aaVar.a(a, a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        layoutParams.rightMargin = com.baidu.adp.lib.util.i.a(this.a, 6.0f);
        int length = forumDetailData.badges.length;
        for (int i = 0; i < length; i++) {
            HeadImageView headImageView = new HeadImageView(this.a);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setTag(forumDetailData.badges[i].badgeURL);
            this.j.addView(headImageView);
            aaVar.b(forumDetailData.badges[i].badgeURL, new n(this, headImageView));
        }
        this.j.setVisibility(0);
    }

    public void setDirBoxOnClickListener(View.OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public final void a(com.baidu.tbadk.a aVar, int i) {
        if (i == 1) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.a.e.forum_detail_brief_txt_color_1));
        } else {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.a.e.forum_detail_brief_txt_color));
        }
        aVar.getLayoutMode().a(i == 1);
        aVar.getLayoutMode().a(this);
    }
}
