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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.emotiontool.b;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemInfoView extends LinearLayout {
    private TextView giu;

    public ItemInfoView(Context context) {
        super(context);
        init(context);
    }

    public ItemInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.forum_detail_info, (ViewGroup) this, true);
        setVisibility(8);
        this.giu = (TextView) findViewById(d.g.info_brief_content);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if ((recommendForumInfo != null && recommendForumInfo.content != null && recommendForumInfo.content.size() > 0) || (recommendForumInfo != null && !ap.isEmpty(recommendForumInfo.slogan))) {
            this.giu.setText(i(recommendForumInfo.content, recommendForumInfo.slogan));
        } else {
            this.giu.setText(getResources().getString(d.j.forum_detail_info_no_brief));
        }
        setVisibility(0);
    }

    private SpannableStringBuilder i(List<PbContent> list, String str) {
        b bVar = new b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "\n");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PbContent pbContent = list.get(i);
            if (pbContent != null) {
                if (pbContent.type.intValue() == 2) {
                    Bitmap cashBitmap = BitmapHelper.getCashBitmap(bVar.oG(pbContent.text));
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

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        al.d(this.giu, d.C0277d.common_color_10177, 1);
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
