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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes8.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> kDq;
    private List<SimpleThreadInfo> kDr;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.kDq = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kDq = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.kDr = list;
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
        setData(this.kDr);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        a aVar;
        if (simpleThreadInfo != null) {
            if (!this.kDq.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.kDt = (LinearLayout) inflate.findViewById(R.id.thread_item_ll);
                aVar.kDu = (TextView) inflate.findViewById(R.id.ht_item_title);
                aVar.kDv = (TextView) inflate.findViewById(R.id.ht_item_content);
                aVar.kDw = (TextView) inflate.findViewById(R.id.ht_item_reply);
                aVar.kDx = (TextView) inflate.findViewById(R.id.ht_divider_line);
                inflate.setTag(aVar);
                this.kDq.put(String.valueOf(simpleThreadInfo.tid), inflate);
                addView(inflate);
                view = inflate;
            } else {
                View view2 = this.kDq.get(String.valueOf(simpleThreadInfo.tid));
                view = view2;
                aVar = (a) view2.getTag();
            }
            aVar.kDu.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!at.isEmpty(sb.toString().trim())) {
                aVar.kDv.setText(sb.toString());
                aVar.kDv.setVisibility(0);
            } else {
                aVar.kDv.setVisibility(8);
            }
            aVar.kDw.setText(String.valueOf(simpleThreadInfo.reply_num));
            ao.setBackgroundResource(aVar.kDt, R.drawable.live_frs_list_item_bg);
            ao.setViewTextColor(aVar.kDu, R.color.CAM_X0105, 1);
            ao.setViewTextColor(aVar.kDv, R.color.CAM_X0108, 1);
            ao.setViewTextColor(aVar.kDw, R.color.CAM_X0304, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ao.getDrawable(R.drawable.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.kDw.setCompoundDrawables(bitmapDrawable, null, null, null);
            ao.setBackgroundResource(aVar.kDx, R.color.CAM_X0204);
            if (z) {
                aVar.kDx.setVisibility(0);
            } else {
                aVar.kDx.setVisibility(8);
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
    /* loaded from: classes8.dex */
    public static class a {
        LinearLayout kDt;
        TextView kDu;
        TextView kDv;
        TextView kDw;
        TextView kDx;

        private a() {
        }
    }
}
