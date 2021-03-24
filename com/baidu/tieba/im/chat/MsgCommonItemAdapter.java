package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.b.e.h.b;
import d.b.b.j.e.a;
/* loaded from: classes4.dex */
public abstract class MsgCommonItemAdapter<T> extends a<ChatMessage, MsgViewHolder<T>> {
    public TbPageContext<MsglistActivity<?>> m;
    public d.b.b.e.h.a n;
    public b o;
    public long p;
    public boolean q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public T f17763a;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.f17763a = t;
        }

        public T b() {
            return this.f17763a;
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

    public final void h0() {
        this.p = System.currentTimeMillis() / 1000;
    }

    public boolean i0() {
        return this.r;
    }

    public boolean j0() {
        return this.q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        h0();
        return view;
    }

    public void m0(boolean z) {
        this.r = z;
    }

    public void n0(boolean z) {
        this.q = z;
    }

    public void o0(d.b.b.e.h.a aVar) {
        this.n = aVar;
    }

    public void p0(b bVar) {
        this.o = bVar;
    }

    public void q0(int i) {
        this.s = i;
    }
}
