package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long ejb;
    protected com.baidu.adp.lib.b.a hsp;
    protected com.baidu.adp.lib.b.b hsq;
    private boolean hsw;
    private boolean hsx;
    protected int hsy;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hsp = null;
        this.hsq = null;
        this.ejb = 0L;
        this.hsw = false;
        this.hsx = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsp = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hsq = bVar;
    }

    private void bSj() {
        this.ejb = System.currentTimeMillis() / 1000;
    }

    public boolean bSk() {
        return this.hsw;
    }

    public void nc(boolean z) {
        this.hsw = z;
    }

    public boolean bSl() {
        return this.hsx;
    }

    public void nd(boolean z) {
        this.hsx = z;
    }

    public void wa(int i) {
        this.hsy = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bSj();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hsz;

        public a(View view, T t) {
            super(view);
            this.hsz = t;
        }

        public T bSm() {
            return this.hsz;
        }
    }
}
