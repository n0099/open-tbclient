package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long fgo;
    private boolean iKD;
    private boolean iKE;
    protected int iKF;
    protected com.baidu.adp.lib.b.a iKw;
    protected com.baidu.adp.lib.b.b iKx;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ad.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iKw = null;
        this.iKx = null;
        this.fgo = 0L;
        this.iKD = false;
        this.iKE = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.iKw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iKx = bVar;
    }

    private void cnx() {
        this.fgo = System.currentTimeMillis() / 1000;
    }

    public boolean cny() {
        return this.iKD;
    }

    public void oS(boolean z) {
        this.iKD = z;
    }

    public boolean cnz() {
        return this.iKE;
    }

    public void oT(boolean z) {
        this.iKE = z;
    }

    public void xY(int i) {
        this.iKF = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cnx();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends ad.a {
        private T iKG;

        public a(View view, T t) {
            super(view);
            this.iKG = t;
        }

        public T cnA() {
            return this.iKG;
        }
    }
}
