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
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.v;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemInfoView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1214a;
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

    public void a(Context context) {
        this.f1214a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_info, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(R.id.info_brief_box);
        this.c = (TextView) findViewById(R.id.info_brief_content);
        this.d = (ViewGroup) findViewById(R.id.info_dir_box);
        this.e = (TextView) findViewById(R.id.info_dir_name);
        this.f = (TextView) findViewById(R.id.info_rank_divider_line);
        this.g = (ViewGroup) findViewById(R.id.info_rank_box);
        this.h = (TextView) findViewById(R.id.info_rank_content);
        this.i = (TextView) findViewById(R.id.info_badge_divider_line);
        this.j = (ViewGroup) findViewById(R.id.info_badge_box);
    }

    public boolean a(ForumDetailData forumDetailData, com.baidu.tieba.j jVar) {
        boolean z;
        if (forumDetailData == null || (forumDetailData.forumInfo.contents.length == 0 && bc.c(forumDetailData.forumInfo.slogan) && forumDetailData.badges.length == 0 && forumDetailData.forumDir == null)) {
            return false;
        }
        boolean equals = jVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.BAR_DIR.toString());
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
                this.d.setOnClickListener(new o(this, equals, str2, valueOf2, valueOf, str, jVar));
                z = true;
            }
            if (forumDetailData.forumDir.rank != 0 || this.d.getVisibility() == 0) {
                if (forumDetailData.forumDir.rank != 0) {
                    this.h.setText(String.valueOf(forumDetailData.forumDir.rank));
                } else {
                    this.h.setText(getResources().getString(R.string.forum_detail_info_no_rank));
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
        if (forumDetailData.forumInfo.contents.length > 0 || !bc.c(forumDetailData.forumInfo.slogan)) {
            this.c.setText(a(forumDetailData.forumInfo.contents, forumDetailData.forumInfo.slogan));
            this.b.setVisibility(0);
            z = true;
        } else if (this.d.getVisibility() == 0) {
            this.c.setText(getResources().getString(R.string.forum_detail_info_no_brief));
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

    private SpannableStringBuilder a(ForumDetailData.ForumContent[] forumContentArr, String str) {
        v vVar = new v();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = forumContentArr.length;
        for (int i = 0; i < length; i++) {
            if (forumContentArr[i].type == 2) {
                Bitmap a2 = com.baidu.tieba.util.e.a(vVar.a(forumContentArr[i].text));
                if (a2 != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a2);
                    bitmapDrawable.setBounds(0, 0, a2.getWidth(), a2.getHeight());
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
                    int length2 = spannableStringBuilder.length() - 1;
                    spannableStringBuilder.setSpan(imageSpan, length2, length2 + 1, 33);
                } else {
                    spannableStringBuilder.append((CharSequence) forumContentArr[i].text);
                }
            } else {
                spannableStringBuilder.append((CharSequence) forumContentArr[i].text);
            }
        }
        return spannableStringBuilder;
    }

    private void a(ForumDetailData forumDetailData) {
        com.baidu.tieba.util.a aVar = new com.baidu.tieba.util.a(this.f1214a);
        int a2 = UtilHelper.a(this.f1214a, 20.0f);
        aVar.a(a2, a2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.rightMargin = UtilHelper.a(this.f1214a, 6.0f);
        int length = forumDetailData.badges.length;
        for (int i = 0; i < length; i++) {
            HeadImageView headImageView = new HeadImageView(this.f1214a);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setTag(forumDetailData.badges[i].badgeURL);
            this.j.addView(headImageView);
            com.baidu.adp.widget.ImageView.e d = aVar.d(forumDetailData.badges[i].badgeURL);
            if (d != null) {
                headImageView.setImageBitmap(d.f());
                headImageView.invalidate();
            } else {
                aVar.a(forumDetailData.badges[i].badgeURL, new p(this, headImageView));
            }
        }
        this.j.setVisibility(0);
    }

    public void setDirBoxOnClickListener(View.OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        if (i == 1) {
            setBackgroundResource(R.drawable.bg_brief_cell_1);
            this.c.setTextColor(getResources().getColor(R.color.forum_detail_brief_txt_color_1));
        } else {
            setBackgroundResource(R.drawable.bg_brief_cell);
            this.c.setTextColor(getResources().getColor(R.color.forum_detail_brief_txt_color));
        }
        jVar.m().a(i == 1);
        jVar.m().a(this);
    }
}
