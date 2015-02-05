package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.PbContent;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemInfoView extends LinearLayout {
    private TextView bbm;

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
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.forum_detail_info, this, true);
        setVisibility(8);
        this.bbm = (TextView) findViewById(com.baidu.tieba.w.info_brief_content);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if ((recommendForumInfo != null && recommendForumInfo.content != null && recommendForumInfo.content.size() > 0) || !bf.isEmpty(recommendForumInfo.slogan)) {
            this.bbm.setText(c(recommendForumInfo.content, recommendForumInfo.slogan));
        } else {
            this.bbm.setText(getResources().getString(z.forum_detail_info_no_brief));
        }
        setVisibility(0);
    }

    private SpannableStringBuilder c(List<PbContent> list, String str) {
        com.baidu.tbadk.editortool.v vVar = new com.baidu.tbadk.editortool.v();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(str) + "\n");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PbContent pbContent = list.get(i);
            if (pbContent != null) {
                if (pbContent.type.intValue() == 2) {
                    Bitmap bN = com.baidu.tbadk.core.util.d.bN(vVar.dW(pbContent.text));
                    if (bN != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bN);
                        bitmapDrawable.setBounds(0, 0, bN.getWidth(), bN.getHeight());
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
        bc.b(this.bbm, com.baidu.tieba.t.forum_detail_brief_txt_color, 1);
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
