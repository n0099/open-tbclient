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
    private HashMap<String, View> ksB;
    private List<SimpleThreadInfo> ksC;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.ksB = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ksB = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.ksC = list;
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
        setData(this.ksC);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.ksB.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.ksE = (LinearLayout) view.findViewById(R.id.thread_item_ll);
                aVar.ksF = (TextView) view.findViewById(R.id.ht_item_title);
                aVar.ksG = (TextView) view.findViewById(R.id.ht_item_content);
                aVar.ksH = (TextView) view.findViewById(R.id.ht_item_reply);
                aVar.ksI = (TextView) view.findViewById(R.id.ht_divider_line);
                view.setTag(aVar);
                this.ksB.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.ksB.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.ksF.setText(simpleThreadInfo.title);
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
                aVar.ksG.setText(sb.toString());
                aVar.ksG.setVisibility(0);
            } else {
                aVar.ksG.setVisibility(8);
            }
            aVar.ksH.setText(String.valueOf(simpleThreadInfo.reply_num));
            ap.setBackgroundResource(aVar.ksE, R.drawable.live_frs_list_item_bg);
            ap.setViewTextColor(aVar.ksF, R.color.CAM_X0105, 1);
            ap.setViewTextColor(aVar.ksG, R.color.CAM_X0108, 1);
            ap.setViewTextColor(aVar.ksH, R.color.CAM_X0304, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.ksH.setCompoundDrawables(bitmapDrawable, null, null, null);
            ap.setBackgroundResource(aVar.ksI, R.color.CAM_X0204);
            if (z) {
                aVar.ksI.setVisibility(0);
            } else {
                aVar.ksI.setVisibility(8);
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
        LinearLayout ksE;
        TextView ksF;
        TextView ksG;
        TextView ksH;
        TextView ksI;

        private a() {
        }
    }
}
