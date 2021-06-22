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
    public Context f17368e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f17369f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f17370g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17371e;

        public a(String str) {
            this.f17371e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(ItemHotThreadView.this.f17368e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.f17368e).createNormalCfg(this.f17371e, "", "")));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17373a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17374b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17375c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17376d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17377e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public ItemHotThreadView(Context context) {
        super(context);
        this.f17369f = new HashMap<>();
        c(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        if (simpleThreadInfo == null) {
            return;
        }
        if (!this.f17369f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f17368e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f17373a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f17374b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f17375c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f17376d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f17377e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f17369f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f17369f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f17374b.setText(simpleThreadInfo.title);
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
            bVar.f17375c.setText(sb.toString());
            bVar.f17375c.setVisibility(0);
        } else {
            bVar.f17375c.setVisibility(8);
        }
        bVar.f17376d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f17373a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f17374b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f17375c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f17376d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f17376d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f17377e, R.color.CAM_X0204);
        if (z) {
            bVar.f17377e.setVisibility(0);
        } else {
            bVar.f17377e.setVisibility(8);
        }
        view.setOnClickListener(new a(String.valueOf(simpleThreadInfo.tid)));
    }

    public void c(Context context) {
        this.f17368e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void d(ForumDetailActivity forumDetailActivity, int i2) {
        forumDetailActivity.getLayoutMode().k(i2 == 1);
        forumDetailActivity.getLayoutMode().j(this);
        e();
    }

    public final void e() {
        setData(this.f17370g);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.f17370g = list;
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
        this.f17369f = new HashMap<>();
        c(context);
    }
}
