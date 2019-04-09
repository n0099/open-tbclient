package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> ghZ;
    private List<SimpleThreadInfo> gia;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.ghZ = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghZ = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.gia = list;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            int i = 0;
            while (i < list.size()) {
                a(list.get(i), i != list.size() + (-1));
                i++;
            }
        }
    }

    private void refresh() {
        setData(this.gia);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.ghZ.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.gic = (LinearLayout) view.findViewById(d.g.thread_item_ll);
                aVar.gie = (TextView) view.findViewById(d.g.ht_item_title);
                aVar.gif = (TextView) view.findViewById(d.g.ht_item_content);
                aVar.gig = (TextView) view.findViewById(d.g.ht_item_reply);
                aVar.gih = (TextView) view.findViewById(d.g.ht_divider_line);
                view.setTag(aVar);
                this.ghZ.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.ghZ.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.gie.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!ap.isEmpty(sb.toString().trim())) {
                aVar.gif.setText(sb.toString());
                aVar.gif.setVisibility(0);
            } else {
                aVar.gif.setVisibility(8);
            }
            aVar.gig.setText(String.valueOf(simpleThreadInfo.reply_num));
            al.k(aVar.gic, d.f.live_frs_list_item_bg);
            al.d(aVar.gie, d.C0277d.cp_cont_b, 1);
            al.d(aVar.gif, d.C0277d.cp_cont_c, 1);
            al.d(aVar.gig, d.C0277d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) al.getDrawable(d.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.gig.setCompoundDrawables(bitmapDrawable, null, null, null);
            al.k(aVar.gih, d.C0277d.cp_bg_line_c);
            if (z) {
                aVar.gih.setVisibility(0);
            } else {
                aVar.gih.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.tid);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.mContext).createNormalCfg(valueOf, "", "")));
                }
            });
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        LinearLayout gic;
        TextView gie;
        TextView gif;
        TextView gig;
        TextView gih;

        private a() {
        }
    }
}
