package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import java.util.List;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemInfoView extends LinearLayout {
    private TextView bdo;

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
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_info, this, true);
        setVisibility(8);
        this.bdo = (TextView) findViewById(com.baidu.tieba.v.info_brief_content);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if ((recommendForumInfo != null && recommendForumInfo.content != null && recommendForumInfo.content.size() > 0) || !bd.isEmpty(recommendForumInfo.slogan)) {
            this.bdo.setText(b(recommendForumInfo.content, recommendForumInfo.slogan));
        } else {
            this.bdo.setText(getResources().getString(com.baidu.tieba.y.forum_detail_info_no_brief));
        }
        setVisibility(0);
    }

    private SpannableStringBuilder b(List<PbContent> list, String str) {
        com.baidu.tbadk.editortool.t tVar = new com.baidu.tbadk.editortool.t();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(str) + "\n");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PbContent pbContent = list.get(i);
            if (pbContent != null) {
                if (pbContent.type.intValue() == 2) {
                    Bitmap bO = com.baidu.tbadk.core.util.c.bO(tVar.ea(pbContent.text));
                    if (bO != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bO);
                        bitmapDrawable.setBounds(0, 0, bO.getWidth(), bO.getHeight());
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
        ba.b(this.bdo, com.baidu.tieba.s.forum_detail_brief_txt_color, 1);
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
