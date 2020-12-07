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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes26.dex */
public class ItemHotThreadView extends LinearLayout {
    private List<SimpleThreadInfo> ksA;
    private HashMap<String, View> ksz;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.ksz = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ksz = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.ksA = list;
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
        setData(this.ksA);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.ksz.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.ksC = (LinearLayout) view.findViewById(R.id.thread_item_ll);
                aVar.ksD = (TextView) view.findViewById(R.id.ht_item_title);
                aVar.ksE = (TextView) view.findViewById(R.id.ht_item_content);
                aVar.ksF = (TextView) view.findViewById(R.id.ht_item_reply);
                aVar.ksG = (TextView) view.findViewById(R.id.ht_divider_line);
                view.setTag(aVar);
                this.ksz.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.ksz.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.ksD.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!au.isEmpty(sb.toString().trim())) {
                aVar.ksE.setText(sb.toString());
                aVar.ksE.setVisibility(0);
            } else {
                aVar.ksE.setVisibility(8);
            }
            aVar.ksF.setText(String.valueOf(simpleThreadInfo.reply_num));
            ap.setBackgroundResource(aVar.ksC, R.drawable.live_frs_list_item_bg);
            ap.setViewTextColor(aVar.ksD, R.color.CAM_X0105, 1);
            ap.setViewTextColor(aVar.ksE, R.color.CAM_X0108, 1);
            ap.setViewTextColor(aVar.ksF, R.color.CAM_X0304, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.ksF.setCompoundDrawables(bitmapDrawable, null, null, null);
            ap.setBackgroundResource(aVar.ksG, R.color.CAM_X0204);
            if (z) {
                aVar.ksG.setVisibility(0);
            } else {
                aVar.ksG.setVisibility(8);
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
    /* loaded from: classes26.dex */
    public static class a {
        LinearLayout ksC;
        TextView ksD;
        TextView ksE;
        TextView ksF;
        TextView ksG;

        private a() {
        }
    }
}
