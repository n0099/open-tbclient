package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ItemInfoView extends RelativeLayout {
    private ViewGroup axB;
    private TextView axC;
    private ViewGroup axD;
    private TextView axE;
    private TextView axF;
    private ViewGroup axG;
    private TextView axH;
    private TextView axI;
    private ViewGroup axJ;
    private Context mContext;

    public ItemInfoView(Context context) {
        super(context);
        init(context);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.forum_detail_info, this, true);
        this.axB = (ViewGroup) findViewById(v.info_brief_box);
        this.axC = (TextView) findViewById(v.info_brief_content);
        this.axD = (ViewGroup) findViewById(v.info_dir_box);
        this.axE = (TextView) findViewById(v.info_dir_name);
        this.axF = (TextView) findViewById(v.info_rank_divider_line);
        this.axG = (ViewGroup) findViewById(v.info_rank_box);
        this.axH = (TextView) findViewById(v.info_rank_content);
        this.axI = (TextView) findViewById(v.info_badge_divider_line);
        this.axJ = (ViewGroup) findViewById(v.info_badge_box);
    }

    public boolean a(ForumDetailData forumDetailData, BaseActivity baseActivity) {
        boolean z;
        if (forumDetailData == null || (forumDetailData.forum_info != null && forumDetailData.forum_info.content.length == 0 && ay.aA(forumDetailData.forum_info.slogan) && forumDetailData.badges.length == 0 && forumDetailData.forum_dir == null)) {
            return false;
        }
        boolean equals = baseActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.BAR_DIR.toString());
        if (forumDetailData.forum_dir != null) {
            String str = forumDetailData.forum_dir.level_2_name;
            String str2 = forumDetailData.forum_dir.level_1_name;
            String valueOf = String.valueOf(forumDetailData.forum_dir.level_1_menu_type);
            String valueOf2 = String.valueOf(forumDetailData.forum_dir.level_1_menu_id);
            if (ay.aA(str)) {
                z = false;
            } else {
                this.axE.setText(str);
                this.axD.setVisibility(0);
                this.axD.setOnClickListener(new l(this, equals, str2, valueOf2, valueOf, str, baseActivity));
                z = true;
            }
            if (forumDetailData.forum_dir.rank != 0 || this.axD.getVisibility() == 0) {
                if (forumDetailData.forum_dir.rank != 0) {
                    this.axH.setText(String.valueOf(forumDetailData.forum_dir.rank));
                } else {
                    this.axH.setText(getResources().getString(y.forum_detail_info_no_rank));
                }
                if (this.axD.getVisibility() == 8 && this.axB.getVisibility() == 0) {
                    this.axF.setVisibility(0);
                }
                this.axG.setVisibility(0);
                z = true;
            }
        } else {
            z = false;
        }
        if ((forumDetailData.forum_info != null && forumDetailData.forum_info.content != null && forumDetailData.forum_info.content.length > 0) || !ay.aA(forumDetailData.forum_info.slogan)) {
            this.axC.setText(a(forumDetailData.forum_info.content, forumDetailData.forum_info.slogan));
            this.axB.setVisibility(0);
            z = true;
        } else if (this.axD.getVisibility() == 0) {
            this.axC.setText(getResources().getString(y.forum_detail_info_no_brief));
            this.axB.setVisibility(0);
            z = true;
        }
        if (forumDetailData.badges.length > 0) {
            if (this.axD.getVisibility() == 0 || (this.axD.getVisibility() == 8 && (this.axB.getVisibility() == 0 || this.axG.getVisibility() == 0))) {
                this.axI.setVisibility(0);
            }
            f(forumDetailData);
            return true;
        }
        return z;
    }

    private SpannableStringBuilder a(ForumDetailData.ForumContent[] forumContentArr, String str) {
        com.baidu.tbadk.editortool.v vVar = new com.baidu.tbadk.editortool.v();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(str) + "\n");
        int length = forumContentArr.length;
        for (int i = 0; i < length; i++) {
            if (forumContentArr[i].type == 2) {
                Bitmap bl = com.baidu.tbadk.core.util.d.bl(vVar.dd(forumContentArr[i].text));
                if (bl != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bl);
                    bitmapDrawable.setBounds(0, 0, bl.getWidth(), bl.getHeight());
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
                    int length2 = spannableStringBuilder.length() - 1;
                    spannableStringBuilder.setSpan(imageSpan, length2, length2 + 1, 33);
                }
            } else {
                spannableStringBuilder.append((CharSequence) forumContentArr[i].text);
            }
        }
        return spannableStringBuilder;
    }

    private void f(ForumDetailData forumDetailData) {
        int dip2px = m.dip2px(this.mContext, 20.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.rightMargin = m.dip2px(this.mContext, 6.0f);
        int length = forumDetailData.badges.length;
        for (int i = 0; i < length; i++) {
            HeadImageView headImageView = new HeadImageView(this.mContext);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setTag(forumDetailData.badges[i].badge_url);
            this.axJ.addView(headImageView);
            headImageView.a(forumDetailData.badges[i].badge_url, 21, dip2px, dip2px, false);
        }
        this.axJ.setVisibility(0);
    }

    public void setDirBoxOnClickListener(View.OnClickListener onClickListener) {
        this.axD.setOnClickListener(onClickListener);
    }

    public void a(BaseActivity baseActivity, int i) {
        aw.b(this.axC, s.forum_detail_brief_txt_color, 1);
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
    }
}
