package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long gim;
    protected com.baidu.adp.lib.b.a kjX;
    protected com.baidu.adp.lib.b.b kjY;
    private boolean kke;
    private boolean kkf;
    protected int kkg;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kjX = null;
        this.kjY = null;
        this.gim = 0L;
        this.kke = false;
        this.kkf = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kjX = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjY = bVar;
    }

    private void cTJ() {
        this.gim = System.currentTimeMillis() / 1000;
    }

    public boolean cTK() {
        return this.kke;
    }

    public void rZ(boolean z) {
        this.kke = z;
    }

    public boolean cTL() {
        return this.kkf;
    }

    public void sa(boolean z) {
        this.kkf = z;
    }

    public void DK(int i) {
        this.kkg = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cTJ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T kkh;

        public a(View view, T t) {
            super(view);
            this.kkh = t;
        }

        public T cTM() {
            return this.kkh;
        }
    }
}
