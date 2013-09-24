package com.baidu.tieba.chat;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.util.at;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ChatActivity f966a;
    private com.baidu.tieba.data.a.c b = null;
    private int c = 0;
    private com.baidu.tieba.util.a d;

    public j(ChatActivity chatActivity) {
        this.f966a = null;
        this.d = null;
        this.f966a = chatActivity;
        this.d = new com.baidu.tieba.util.a(chatActivity);
    }

    public com.baidu.tieba.util.a a() {
        return this.d;
    }

    public void a(com.baidu.tieba.data.a.c cVar) {
        this.b = cVar;
    }

    public void a(int i) {
        this.c = i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = b(itemViewType);
        }
        a((k) view.getTag(), (com.baidu.tieba.data.a.d) getItem(i), i, itemViewType);
        return view;
    }

    private View b(int i) {
        View inflate;
        k kVar = new k(this, null);
        LayoutInflater from = LayoutInflater.from(this.f966a);
        if (i == 0) {
            inflate = from.inflate(R.layout.chat_item_opposite, (ViewGroup) null);
        } else {
            inflate = from.inflate(R.layout.chat_item_own, (ViewGroup) null);
        }
        kVar.f967a = (HeadImageView) inflate.findViewById(R.id.photo);
        kVar.b = (TbRichTextView) inflate.findViewById(R.id.text);
        kVar.c = (TextView) inflate.findViewById(R.id.time);
        kVar.f967a.setOnClickListener(this.f966a);
        kVar.b.setOnLongClickListener(this.f966a);
        inflate.setTag(kVar);
        return inflate;
    }

    private void a(k kVar, com.baidu.tieba.data.a.d dVar, int i, int i2) {
        long f;
        String b;
        if (i <= 0) {
            f = dVar.f();
        } else {
            com.baidu.tieba.data.a.d dVar2 = (com.baidu.tieba.data.a.d) getItem(i - 1);
            f = (dVar2 == null || dVar.f() - dVar2.f() <= 60) ? 0L : dVar.f();
        }
        if (f > 0) {
            kVar.c.setVisibility(0);
            if (new Date().getDay() != new Date(f * 1000).getDay()) {
                kVar.c.setText(at.a(new Date(f * 1000)));
            } else {
                kVar.c.setText(at.b(new Date(f * 1000)));
            }
        } else {
            kVar.c.setVisibility(8);
        }
        kVar.b.setVoiceViewRes(R.layout.voice_play_btn);
        kVar.b.setText(dVar.a(this.f966a));
        kVar.b.setTag(dVar);
        if (dVar.e() == 1) {
            kVar.f967a.setUserId(dVar.d());
            b = this.b.a();
        } else {
            kVar.f967a.setUserId(dVar.c());
            b = this.b.b();
        }
        com.baidu.adp.widget.a.c c = this.d.c(b);
        if (c != null) {
            c.a(kVar.f967a);
        } else {
            kVar.f967a.setTag(b);
            kVar.f967a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.e.a((int) R.drawable.photo)));
        }
        if (this.c == 1) {
            if (i2 == 0) {
                kVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_friends_1);
            } else {
                kVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_me_1);
            }
            kVar.b.setTextColor(this.f966a.getResources().getColor(R.color.gray_night_4));
            kVar.c.setTextColor(this.f966a.getResources().getColor(R.color.gray_night_2));
            return;
        }
        if (i2 == 0) {
            kVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_friends);
        } else {
            kVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_me);
        }
        kVar.b.setTextColor(this.f966a.getResources().getColor(R.color.black));
        kVar.c.setTextColor(this.f966a.getResources().getColor(R.color.white));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d().size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= this.b.d().size()) {
            return 0;
        }
        return this.b.d().get(i).e() == 1 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null) {
            return null;
        }
        return this.b.a(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
