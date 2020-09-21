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
    protected long fAb;
    protected com.baidu.adp.lib.b.a jom;
    protected com.baidu.adp.lib.b.b jon;
    private boolean jot;
    private boolean jou;
    protected int jov;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jom = null;
        this.jon = null;
        this.fAb = 0L;
        this.jot = false;
        this.jou = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jom = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jon = bVar;
    }

    private void cFx() {
        this.fAb = System.currentTimeMillis() / 1000;
    }

    public boolean cFy() {
        return this.jot;
    }

    public void qn(boolean z) {
        this.jot = z;
    }

    public boolean cFz() {
        return this.jou;
    }

    public void qo(boolean z) {
        this.jou = z;
    }

    public void Bl(int i) {
        this.jov = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cFx();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jow;

        public a(View view, T t) {
            super(view);
            this.jow = t;
        }

        public T cFA() {
            return this.jow;
        }
    }
}
