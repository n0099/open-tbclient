package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.i0.w.p.b;
import java.util.List;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemInfoView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17995e;

    public ItemInfoView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.forum_detail_info, (ViewGroup) this, true);
        setVisibility(8);
        this.f17995e = (TextView) findViewById(R.id.info_brief_content);
    }

    public void b(ForumDetailActivity forumDetailActivity, int i2) {
        SkinManager.setViewTextColor(this.f17995e, R.color.common_color_10177, 1);
        forumDetailActivity.getLayoutMode().k(i2 == 1);
        forumDetailActivity.getLayoutMode().j(this);
    }

    public final SpannableStringBuilder c(List<PbContent> list, String str) {
        b bVar = new b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "\n");
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            PbContent pbContent = list.get(i2);
            if (pbContent != null) {
                if (pbContent.type.intValue() == 2) {
                    Bitmap cashBitmap = BitmapHelper.getCashBitmap(bVar.d(pbContent.text));
                    if (cashBitmap != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(cashBitmap);
                        bitmapDrawable.setBounds(0, 0, cashBitmap.getWidth(), cashBitmap.getHeight());
                        ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
                        int length = spannableStringBuilder.length() - 1;
                        spannableStringBuilder.setSpan(imageSpan, length, length + 1, 33);
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) pbContent.text);
                }
            }
        }
        return spannableStringBuilder;
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        List<PbContent> list;
        if ((recommendForumInfo != null && (list = recommendForumInfo.content) != null && list.size() > 0) || (recommendForumInfo != null && !k.isEmpty(recommendForumInfo.slogan))) {
            this.f17995e.setText(c(recommendForumInfo.content, recommendForumInfo.slogan));
        } else {
            this.f17995e.setText(getResources().getString(R.string.forum_detail_info_no_brief));
        }
        setVisibility(0);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
