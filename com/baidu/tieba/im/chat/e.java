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
    protected long flq;
    protected com.baidu.adp.lib.b.a iQB;
    protected com.baidu.adp.lib.b.b iQC;
    private boolean iQI;
    private boolean iQJ;
    protected int iQK;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ad.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iQB = null;
        this.iQC = null;
        this.flq = 0L;
        this.iQI = false;
        this.iQJ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.iQB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQC = bVar;
    }

    private void cqX() {
        this.flq = System.currentTimeMillis() / 1000;
    }

    public boolean cqY() {
        return this.iQI;
    }

    public void px(boolean z) {
        this.iQI = z;
    }

    public boolean cqZ() {
        return this.iQJ;
    }

    public void py(boolean z) {
        this.iQJ = z;
    }

    public void yq(int i) {
        this.iQK = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cqX();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends ad.a {
        private T iQL;

        public a(View view, T t) {
            super(view);
            this.iQL = t;
        }

        public T cra() {
            return this.iQL;
        }
    }
}
