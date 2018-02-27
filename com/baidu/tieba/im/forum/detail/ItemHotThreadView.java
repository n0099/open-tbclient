package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.b;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> eCu;
    private List<SimpleThreadInfo> eCv;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.eCu = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eCu = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.eCv = list;
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
        setData(this.eCv);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.eCu.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.eCy = (LinearLayout) view.findViewById(d.g.thread_item_ll);
                aVar.eCz = (TextView) view.findViewById(d.g.ht_item_title);
                aVar.eCA = (TextView) view.findViewById(d.g.ht_item_content);
                aVar.eCB = (TextView) view.findViewById(d.g.ht_item_reply);
                aVar.eCC = (TextView) view.findViewById(d.g.ht_divider_line);
                view.setTag(aVar);
                this.eCu.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.eCu.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            if (simpleThreadInfo.thread_type != null && simpleThreadInfo.thread_type.longValue() == 33) {
                aVar.eCz.setText(s(simpleThreadInfo.title));
            } else {
                aVar.eCz.setText(simpleThreadInfo.title);
            }
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!am.isEmpty(sb.toString().trim())) {
                aVar.eCA.setText(sb.toString());
                aVar.eCA.setVisibility(0);
            } else {
                aVar.eCA.setVisibility(8);
            }
            aVar.eCB.setText(String.valueOf(simpleThreadInfo.reply_num));
            aj.s(aVar.eCy, d.f.live_frs_list_item_bg);
            aj.e(aVar.eCz, d.C0141d.cp_cont_b, 1);
            aj.e(aVar.eCA, d.C0141d.cp_cont_c, 1);
            aj.e(aVar.eCB, d.C0141d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) aj.getDrawable(d.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.eCB.setCompoundDrawables(bitmapDrawable, null, null, null);
            aj.s(aVar.eCC, d.C0141d.cp_bg_line_c);
            if (z) {
                aVar.eCC.setVisibility(0);
            } else {
                aVar.eCC.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.thread_type);
            final String valueOf2 = String.valueOf(simpleThreadInfo.tid);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", "click", 1, new Object[0]);
                    if (valueOf == String.valueOf(33)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(ItemHotThreadView.this.mContext, valueOf2).xD()));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.mContext).createNormalCfg(valueOf2, "", "")));
                    }
                }
            });
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap fO = aj.fO(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
        int height = fO.getHeight();
        bitmapDrawable.setBounds(0, 0, fO.getWidth(), height);
        spannableStringBuilder.setSpan(new b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return am.a(spannableStringBuilder);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().aQ(i == 1);
        forumDetailActivity.getLayoutMode().aM(this);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView eCA;
        TextView eCB;
        TextView eCC;
        LinearLayout eCy;
        TextView eCz;

        private a() {
        }
    }
}
