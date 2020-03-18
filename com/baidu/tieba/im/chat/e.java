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
    protected long ejE;
    protected com.baidu.adp.lib.b.a hub;
    protected com.baidu.adp.lib.b.b huc;
    private boolean hui;
    private boolean huj;
    protected int huk;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hub = null;
        this.huc = null;
        this.ejE = 0L;
        this.hui = false;
        this.huj = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hub = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.huc = bVar;
    }

    private void bSC() {
        this.ejE = System.currentTimeMillis() / 1000;
    }

    public boolean bSD() {
        return this.hui;
    }

    public void ni(boolean z) {
        this.hui = z;
    }

    public boolean bSE() {
        return this.huj;
    }

    public void nj(boolean z) {
        this.huj = z;
    }

    public void wi(int i) {
        this.huk = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bSC();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hul;

        public a(View view, T t) {
            super(view);
            this.hul = t;
        }

        public T bSF() {
            return this.hul;
        }
    }
}
