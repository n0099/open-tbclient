package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.c.e.h.b;
import d.a.c.j.e.a;
/* loaded from: classes4.dex */
public abstract class MsgCommonItemAdapter<T> extends a<ChatMessage, MsgViewHolder<T>> {
    public TbPageContext<MsglistActivity<?>> m;
    public d.a.c.e.h.a n;
    public b o;
    public long p;
    public boolean q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public T f17073a;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.f17073a = t;
        }

        public T b() {
            return this.f17073a;
        }
    }

    public MsgCommonItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = null;
        this.o = null;
        this.p = 0L;
        this.q = false;
        this.r = false;
        this.m = tbPageContext;
    }

    public final void e0() {
        this.p = System.currentTimeMillis() / 1000;
    }

    public boolean f0() {
        return this.r;
    }

    public boolean g0() {
        return this.q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        e0();
        return view;
    }

    public void i0(boolean z) {
        this.r = z;
    }

    public void j0(boolean z) {
        this.q = z;
    }

    public void m0(d.a.c.e.h.a aVar) {
        this.n = aVar;
    }

    public void n0(b bVar) {
        this.o = bVar;
    }

    public void p0(int i2) {
        this.s = i2;
    }
}
