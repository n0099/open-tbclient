package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ap<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> EA;
    protected com.baidu.adp.lib.d.a cHE;
    protected com.baidu.adp.lib.d.b cHF;
    private boolean cHL;
    private boolean cHM;
    protected int cHN;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cHE = null;
        this.cHF = null;
        this.mCurrentTime = 0L;
        this.cHL = false;
        this.cHM = false;
        this.EA = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cHE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cHF = bVar;
    }

    private void all() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean alm() {
        return this.cHL;
    }

    public void eR(boolean z) {
        this.cHL = z;
    }

    public boolean aln() {
        return this.cHM;
    }

    public void eS(boolean z) {
        this.cHM = z;
    }

    public void kw(int i) {
        this.cHN = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        all();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cHO;

        public a(View view, T t) {
            super(view);
            this.cHO = t;
        }

        public T alo() {
            return this.cHO;
        }
    }
}
