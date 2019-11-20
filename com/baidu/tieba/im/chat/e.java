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
    protected long dGu;
    protected com.baidu.adp.lib.c.a gyD;
    protected com.baidu.adp.lib.c.b gyE;
    private boolean gyK;
    private boolean gyL;
    protected int gyM;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gyD = null;
        this.gyE = null;
        this.dGu = 0L;
        this.gyK = false;
        this.gyL = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gyD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gyE = bVar;
    }

    private void byf() {
        this.dGu = System.currentTimeMillis() / 1000;
    }

    public boolean byg() {
        return this.gyK;
    }

    public void lA(boolean z) {
        this.gyK = z;
    }

    public boolean byh() {
        return this.gyL;
    }

    public void lB(boolean z) {
        this.gyL = z;
    }

    public void tN(int i) {
        this.gyM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        byf();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gyN;

        public a(View view, T t) {
            super(view);
            this.gyN = t;
        }

        public T byi() {
            return this.gyN;
        }
    }
}
