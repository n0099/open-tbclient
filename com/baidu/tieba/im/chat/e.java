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
    protected long gik;
    protected com.baidu.adp.lib.b.a kjV;
    protected com.baidu.adp.lib.b.b kjW;
    private boolean kkc;
    private boolean kkd;
    protected int kke;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kjV = null;
        this.kjW = null;
        this.gik = 0L;
        this.kkc = false;
        this.kkd = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kjV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjW = bVar;
    }

    private void cTI() {
        this.gik = System.currentTimeMillis() / 1000;
    }

    public boolean cTJ() {
        return this.kkc;
    }

    public void rZ(boolean z) {
        this.kkc = z;
    }

    public boolean cTK() {
        return this.kkd;
    }

    public void sa(boolean z) {
        this.kkd = z;
    }

    public void DK(int i) {
        this.kke = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cTI();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T kkf;

        public a(View view, T t) {
            super(view);
            this.kkf = t;
        }

        public T cTL() {
            return this.kkf;
        }
    }
}
