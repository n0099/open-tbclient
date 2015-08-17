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
    protected TbPageContext<MsglistActivity<?>> Mr;
    protected com.baidu.adp.lib.c.a bnV;
    protected com.baidu.adp.lib.c.b bnW;
    private boolean boc;
    private boolean bod;
    protected int boe;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bnV = null;
        this.bnW = null;
        this.mCurrentTime = 0L;
        this.boc = false;
        this.bod = false;
        this.Mr = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bnV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bnW = bVar;
    }

    private void Rd() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Re() {
        return this.boc;
    }

    public void cD(boolean z) {
        this.boc = z;
    }

    public boolean Rf() {
        return this.bod;
    }

    public void cE(boolean z) {
        this.bod = z;
    }

    public void gs(int i) {
        this.boe = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Rd();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bof;

        public a(View view, T t) {
            super(view);
            this.bof = t;
        }

        public T Rg() {
            return this.bof;
        }
    }
}
