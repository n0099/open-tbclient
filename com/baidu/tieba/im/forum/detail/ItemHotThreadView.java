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
    public Context f17286e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f17287f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f17288g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17289e;

        public a(String str) {
            this.f17289e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(ItemHotThreadView.this.f17286e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.f17286e).createNormalCfg(this.f17289e, "", "")));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17291a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17292b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17293c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17294d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17295e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public ItemHotThreadView(Context context) {
        super(context);
        this.f17287f = new HashMap<>();
        c(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        if (simpleThreadInfo == null) {
            return;
        }
        if (!this.f17287f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f17286e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f17291a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f17292b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f17293c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f17294d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f17295e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f17287f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f17287f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f17292b.setText(simpleThreadInfo.title);
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
            bVar.f17293c.setText(sb.toString());
            bVar.f17293c.setVisibility(0);
        } else {
            bVar.f17293c.setVisibility(8);
        }
        bVar.f17294d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f17291a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f17292b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f17293c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f17294d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f17294d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f17295e, R.color.CAM_X0204);
        if (z) {
            bVar.f17295e.setVisibility(0);
        } else {
            bVar.f17295e.setVisibility(8);
        }
        view.setOnClickListener(new a(String.valueOf(simpleThreadInfo.tid)));
    }

    public void c(Context context) {
        this.f17286e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void d(ForumDetailActivity forumDetailActivity, int i2) {
        forumDetailActivity.getLayoutMode().k(i2 == 1);
        forumDetailActivity.getLayoutMode().j(this);
        e();
    }

    public final void e() {
        setData(this.f17288g);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.f17288g = list;
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
        this.f17287f = new HashMap<>();
        c(context);
    }
}
