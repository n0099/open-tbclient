package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long eJv;
    protected com.baidu.adp.lib.b.a idU;
    protected com.baidu.adp.lib.b.b idV;
    private boolean ieb;
    private boolean iec;
    protected int ied;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.idU = null;
        this.idV = null;
        this.eJv = 0L;
        this.ieb = false;
        this.iec = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.idU = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.idV = bVar;
    }

    private void ccZ() {
        this.eJv = System.currentTimeMillis() / 1000;
    }

    public boolean cda() {
        return this.ieb;
    }

    public void om(boolean z) {
        this.ieb = z;
    }

    public boolean cdb() {
        return this.iec;
    }

    public void on(boolean z) {
        this.iec = z;
    }

    public void wG(int i) {
        this.ied = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        ccZ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T iee;

        public a(View view, T t) {
            super(view);
            this.iee = t;
        }

        public T cdc() {
            return this.iee;
        }
    }
}
