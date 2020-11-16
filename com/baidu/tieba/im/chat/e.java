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
    protected long fZY;
    protected com.baidu.adp.lib.b.a jWp;
    protected com.baidu.adp.lib.b.b jWq;
    private boolean jWw;
    private boolean jWx;
    protected int jWy;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jWp = null;
        this.jWq = null;
        this.fZY = 0L;
        this.jWw = false;
        this.jWx = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jWp = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jWq = bVar;
    }

    private void cOu() {
        this.fZY = System.currentTimeMillis() / 1000;
    }

    public boolean cOv() {
        return this.jWw;
    }

    public void rx(boolean z) {
        this.jWw = z;
    }

    public boolean cOw() {
        return this.jWx;
    }

    public void ry(boolean z) {
        this.jWx = z;
    }

    public void CV(int i) {
        this.jWy = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cOu();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jWz;

        public a(View view, T t) {
            super(view);
            this.jWz = t;
        }

        public T cOx() {
            return this.jWz;
        }
    }
}
