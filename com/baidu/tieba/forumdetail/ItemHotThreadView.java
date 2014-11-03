package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> axC;
    private ForumDetailData axD;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.axC = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axC = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.forum_detail_hot_thread, this, true);
    }

    public boolean e(ForumDetailData forumDetailData) {
        this.axD = forumDetailData;
        if (forumDetailData == null || forumDetailData.thread_list.length == 0) {
            return false;
        }
        for (ForumDetailData.ThreadInfo threadInfo : forumDetailData.thread_list) {
            a(threadInfo);
        }
        return true;
    }

    private void refresh() {
        e(this.axD);
    }

    private void a(ForumDetailData.ThreadInfo threadInfo) {
        k kVar;
        View view;
        if (!this.axC.containsKey(String.valueOf(threadInfo.tid))) {
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, w.forum_detail_hot_thread_item, this, false);
            kVar = new k(null);
            kVar.axG = (TextView) view.findViewById(v.ht_item_title);
            kVar.axH = (TextView) view.findViewById(v.ht_item_content);
            kVar.axI = (TextView) view.findViewById(v.ht_item_reply);
            kVar.axJ = (TextView) view.findViewById(v.ht_divider_line);
            view.setTag(kVar);
            this.axC.put(String.valueOf(threadInfo.tid), view);
            addView(view);
        } else {
            View view2 = this.axC.get(String.valueOf(threadInfo.tid));
            kVar = (k) view2.getTag();
            view = view2;
        }
        kVar.axG.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.Abstract.length;
        for (int i = 0; i < length; i++) {
            if (threadInfo.Abstract[i].type == 0) {
                sb.append(threadInfo.Abstract[i].text);
            }
        }
        if (!az.aA(sb.toString().trim())) {
            kVar.axH.setText(sb.toString());
            kVar.axH.setVisibility(0);
        } else {
            kVar.axH.setVisibility(8);
        }
        kVar.axI.setText(String.valueOf(threadInfo.reply_num));
        aw.b(kVar.axG, s.forum_detail_htitem_title_color, 1);
        aw.b(kVar.axH, s.forum_detail_htitem_txt_color, 1);
        aw.b(kVar.axI, s.forum_detail_ht_cmt, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) aw.getDrawable(u.icon_bestlittle_comment_b);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        kVar.axI.setCompoundDrawables(bitmapDrawable, null, null, null);
        aw.h((View) kVar.axJ, s.forum_detail_sep_line);
        view.setOnClickListener(new j(this, String.valueOf(threadInfo.id)));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
        refresh();
    }
}
