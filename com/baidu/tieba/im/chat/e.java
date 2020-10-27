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
    protected long fUB;
    protected com.baidu.adp.lib.b.a jPI;
    protected com.baidu.adp.lib.b.b jPJ;
    private boolean jPP;
    private boolean jPQ;
    protected int jPR;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jPI = null;
        this.jPJ = null;
        this.fUB = 0L;
        this.jPP = false;
        this.jPQ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jPI = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jPJ = bVar;
    }

    private void cMn() {
        this.fUB = System.currentTimeMillis() / 1000;
    }

    public boolean cMo() {
        return this.jPP;
    }

    public void rl(boolean z) {
        this.jPP = z;
    }

    public boolean cMp() {
        return this.jPQ;
    }

    public void rm(boolean z) {
        this.jPQ = z;
    }

    public void Ck(int i) {
        this.jPR = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cMn();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jPS;

        public a(View view, T t) {
            super(view);
            this.jPS = t;
        }

        public T cMq() {
            return this.jPS;
        }
    }
}
