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
import d.a.c.e.p.k;
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ItemHotThreadView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17300e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f17301f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f17302g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17303e;

        public a(String str) {
            this.f17303e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(ItemHotThreadView.this.f17300e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.f17300e).createNormalCfg(this.f17303e, "", "")));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17305a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17306b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17307c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17308d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17309e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public ItemHotThreadView(Context context) {
        super(context);
        this.f17301f = new HashMap<>();
        c(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        if (simpleThreadInfo == null) {
            return;
        }
        if (!this.f17301f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f17300e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f17305a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f17306b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f17307c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f17308d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f17309e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f17301f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f17301f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f17306b.setText(simpleThreadInfo.title);
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = simpleThreadInfo._abstract;
        if (list != null && list.size() != 0) {
            int size = simpleThreadInfo._abstract.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (simpleThreadInfo._abstract.get(i2) != null && simpleThreadInfo._abstract.get(i2).type.intValue() == 0) {
                    sb.append(simpleThreadInfo._abstract.get(i2).text);
                }
            }
        }
        if (!k.isEmpty(sb.toString().trim())) {
            bVar.f17307c.setText(sb.toString());
            bVar.f17307c.setVisibility(0);
        } else {
            bVar.f17307c.setVisibility(8);
        }
        bVar.f17308d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f17305a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f17306b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f17307c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f17308d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f17308d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f17309e, R.color.CAM_X0204);
        if (z) {
            bVar.f17309e.setVisibility(0);
        } else {
            bVar.f17309e.setVisibility(8);
        }
        view.setOnClickListener(new a(String.valueOf(simpleThreadInfo.tid)));
    }

    public void c(Context context) {
        this.f17300e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void d(ForumDetailActivity forumDetailActivity, int i2) {
        forumDetailActivity.getLayoutMode().k(i2 == 1);
        forumDetailActivity.getLayoutMode().j(this);
        e();
    }

    public final void e() {
        setData(this.f17302g);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.f17302g = list;
        if (list == null || list.size() == 0) {
            return;
        }
        setVisibility(0);
        for (int i2 = 0; i2 < list.size(); i2++) {
            boolean z = true;
            if (i2 == list.size() - 1) {
                z = false;
            }
            b(list.get(i2), z);
        }
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17301f = new HashMap<>();
        c(context);
    }
}
