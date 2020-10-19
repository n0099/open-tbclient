package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long fMk;
    protected com.baidu.adp.lib.b.a jDj;
    protected com.baidu.adp.lib.b.b jDk;
    private boolean jDq;
    private boolean jDr;
    protected int jDs;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jDj = null;
        this.jDk = null;
        this.fMk = 0L;
        this.jDq = false;
        this.jDr = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jDj = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jDk = bVar;
    }

    private void cJg() {
        this.fMk = System.currentTimeMillis() / 1000;
    }

    public boolean cJh() {
        return this.jDq;
    }

    public void qT(boolean z) {
        this.jDq = z;
    }

    public boolean cJi() {
        return this.jDr;
    }

    public void qU(boolean z) {
        this.jDr = z;
    }

    public void BR(int i) {
        this.jDs = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cJg();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jDt;

        public a(View view, T t) {
            super(view);
            this.jDt = t;
        }

        public T cJj() {
            return this.jDt;
        }
    }
}
