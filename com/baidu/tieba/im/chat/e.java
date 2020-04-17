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
    protected long eJq;
    protected com.baidu.adp.lib.b.a idO;
    protected com.baidu.adp.lib.b.b idP;
    private boolean idV;
    private boolean idW;
    protected int idX;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.idO = null;
        this.idP = null;
        this.eJq = 0L;
        this.idV = false;
        this.idW = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.idO = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.idP = bVar;
    }

    private void cdb() {
        this.eJq = System.currentTimeMillis() / 1000;
    }

    public boolean cdc() {
        return this.idV;
    }

    public void om(boolean z) {
        this.idV = z;
    }

    public boolean cdd() {
        return this.idW;
    }

    public void on(boolean z) {
        this.idW = z;
    }

    public void wG(int i) {
        this.idX = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cdb();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T idY;

        public a(View view, T t) {
            super(view);
            this.idY = t;
        }

        public T cde() {
            return this.idY;
        }
    }
}
