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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes13.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> izl;
    private List<SimpleThreadInfo> izm;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.izl = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.izl = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.izm = list;
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
        setData(this.izm);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.izl.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.izo = (LinearLayout) view.findViewById(R.id.thread_item_ll);
                aVar.izp = (TextView) view.findViewById(R.id.ht_item_title);
                aVar.izq = (TextView) view.findViewById(R.id.ht_item_content);
                aVar.izr = (TextView) view.findViewById(R.id.ht_item_reply);
                aVar.izs = (TextView) view.findViewById(R.id.ht_divider_line);
                view.setTag(aVar);
                this.izl.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.izl.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.izp.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!aq.isEmpty(sb.toString().trim())) {
                aVar.izq.setText(sb.toString());
                aVar.izq.setVisibility(0);
            } else {
                aVar.izq.setVisibility(8);
            }
            aVar.izr.setText(String.valueOf(simpleThreadInfo.reply_num));
            am.setBackgroundResource(aVar.izo, R.drawable.live_frs_list_item_bg);
            am.setViewTextColor(aVar.izp, R.color.cp_cont_b, 1);
            am.setViewTextColor(aVar.izq, R.color.cp_cont_c, 1);
            am.setViewTextColor(aVar.izr, R.color.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(R.drawable.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.izr.setCompoundDrawables(bitmapDrawable, null, null, null);
            am.setBackgroundResource(aVar.izs, R.color.cp_bg_line_c);
            if (z) {
                aVar.izs.setVisibility(0);
            } else {
                aVar.izs.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.tid);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(ItemHotThreadView.this.mContext).createNormalCfg(valueOf, "", "")));
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
    /* loaded from: classes13.dex */
    public static class a {
        LinearLayout izo;
        TextView izp;
        TextView izq;
        TextView izr;
        TextView izs;

        private a() {
        }
    }
}
