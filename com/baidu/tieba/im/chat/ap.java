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
    protected com.baidu.adp.lib.d.a bKU;
    protected com.baidu.adp.lib.d.b bKV;
    private boolean bLb;
    private boolean bLc;
    protected int bLd;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKU = null;
        this.bKV = null;
        this.mCurrentTime = 0L;
        this.bLb = false;
        this.bLc = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bKU = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bKV = bVar;
    }

    private void Wq() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Wr() {
        return this.bLb;
    }

    public void df(boolean z) {
        this.bLb = z;
    }

    public boolean Ws() {
        return this.bLc;
    }

    public void dg(boolean z) {
        this.bLc = z;
    }

    public void ih(int i) {
        this.bLd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Wq();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bLe;

        public a(View view, T t) {
            super(view);
            this.bLe = t;
        }

        public T Wt() {
            return this.bLe;
        }
    }
}
