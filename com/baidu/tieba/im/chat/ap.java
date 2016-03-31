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
    protected TbPageContext<MsglistActivity<?>> ND;
    protected com.baidu.adp.lib.d.a bZa;
    protected com.baidu.adp.lib.d.b bZb;
    private boolean bZh;
    private boolean bZi;
    protected int bZj;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZa = null;
        this.bZb = null;
        this.mCurrentTime = 0L;
        this.bZh = false;
        this.bZi = false;
        this.ND = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bZa = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bZb = bVar;
    }

    private void acn() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean aco() {
        return this.bZh;
    }

    public void dB(boolean z) {
        this.bZh = z;
    }

    public boolean acp() {
        return this.bZi;
    }

    public void dC(boolean z) {
        this.bZi = z;
    }

    public void jl(int i) {
        this.bZj = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        acn();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bZk;

        public a(View view, T t) {
            super(view);
            this.bZk = t;
        }

        public T acq() {
            return this.bZk;
        }
    }
}
