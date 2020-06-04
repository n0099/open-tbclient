package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long eWd;
    protected com.baidu.adp.lib.b.a itq;
    protected com.baidu.adp.lib.b.b itr;
    private boolean itx;
    private boolean ity;
    protected int itz;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, aa.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.itq = null;
        this.itr = null;
        this.eWd = 0L;
        this.itx = false;
        this.ity = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.itq = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.itr = bVar;
    }

    private void cjH() {
        this.eWd = System.currentTimeMillis() / 1000;
    }

    public boolean cjI() {
        return this.itx;
    }

    public void oI(boolean z) {
        this.itx = z;
    }

    public boolean cjJ() {
        return this.ity;
    }

    public void oJ(boolean z) {
        this.ity = z;
    }

    public void xo(int i) {
        this.itz = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cjH();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends aa.a {
        private T itA;

        public a(View view, T t) {
            super(view);
            this.itA = t;
        }

        public T cjK() {
            return this.itA;
        }
    }
}
