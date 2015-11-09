package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ap<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a bsh;
    protected com.baidu.adp.lib.c.b bsi;
    private boolean bso;
    private boolean bsp;
    protected int bsq;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsh = null;
        this.bsi = null;
        this.mCurrentTime = 0L;
        this.bso = false;
        this.bsp = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bsh = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bsi = bVar;
    }

    private void Se() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Sf() {
        return this.bso;
    }

    public void cK(boolean z) {
        this.bso = z;
    }

    public boolean Sg() {
        return this.bsp;
    }

    public void cL(boolean z) {
        this.bsp = z;
    }

    public void gV(int i) {
        this.bsq = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Se();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bsr;

        public a(View view, T t) {
            super(view);
            this.bsr = t;
        }

        public T Sh() {
            return this.bsr;
        }
    }
}
