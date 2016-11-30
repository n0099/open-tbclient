package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ap<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> GO;
    protected com.baidu.adp.lib.d.a dam;
    protected com.baidu.adp.lib.d.b dan;
    protected long dau;
    private boolean dav;
    private boolean daw;
    protected int dax;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dam = null;
        this.dan = null;
        this.dau = 0L;
        this.dav = false;
        this.daw = false;
        this.GO = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.dam = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.dan = bVar;
    }

    private void asw() {
        this.dau = System.currentTimeMillis() / 1000;
    }

    public boolean asx() {
        return this.dav;
    }

    public void fK(boolean z) {
        this.dav = z;
    }

    public boolean asy() {
        return this.daw;
    }

    public void fL(boolean z) {
        this.daw = z;
    }

    public void lp(int i) {
        this.dax = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        asw();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T daz;

        public a(View view, T t) {
            super(view);
            this.daz = t;
        }

        public T asz() {
            return this.daz;
        }
    }
}
