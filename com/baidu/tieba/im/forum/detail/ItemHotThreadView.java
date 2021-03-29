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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17976e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f17977f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f17978g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17979e;

        public a(String str) {
            this.f17979e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(ItemHotThreadView.this.f17976e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.f17976e).createNormalCfg(this.f17979e, "", "")));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17981a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17982b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17983c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17984d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17985e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public ItemHotThreadView(Context context) {
        super(context);
        this.f17977f = new HashMap<>();
        c(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        if (simpleThreadInfo == null) {
            return;
        }
        if (!this.f17977f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f17976e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f17981a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f17982b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f17983c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f17984d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f17985e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f17977f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f17977f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f17982b.setText(simpleThreadInfo.title);
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = simpleThreadInfo._abstract;
        if (list != null && list.size() != 0) {
            int size = simpleThreadInfo._abstract.size();
            for (int i = 0; i < size; i++) {
                if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                    sb.append(simpleThreadInfo._abstract.get(i).text);
                }
            }
        }
        if (!k.isEmpty(sb.toString().trim())) {
            bVar.f17983c.setText(sb.toString());
            bVar.f17983c.setVisibility(0);
        } else {
            bVar.f17983c.setVisibility(8);
        }
        bVar.f17984d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f17981a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f17982b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f17983c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f17984d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f17984d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f17985e, R.color.CAM_X0204);
        if (z) {
            bVar.f17985e.setVisibility(0);
        } else {
            bVar.f17985e.setVisibility(8);
        }
        view.setOnClickListener(new a(String.valueOf(simpleThreadInfo.tid)));
    }

    public void c(Context context) {
        this.f17976e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void d(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().k(i == 1);
        forumDetailActivity.getLayoutMode().j(this);
        e();
    }

    public final void e() {
        setData(this.f17978g);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.f17978g = list;
        if (list == null || list.size() == 0) {
            return;
        }
        setVisibility(0);
        for (int i = 0; i < list.size(); i++) {
            boolean z = true;
            if (i == list.size() - 1) {
                z = false;
            }
            b(list.get(i), z);
        }
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17977f = new HashMap<>();
        c(context);
    }
}
