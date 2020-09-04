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
    protected long fwQ;
    protected com.baidu.adp.lib.b.a jfG;
    protected com.baidu.adp.lib.b.b jfH;
    private boolean jfN;
    private boolean jfO;
    protected int jfP;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jfG = null;
        this.jfH = null;
        this.fwQ = 0L;
        this.jfN = false;
        this.jfO = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jfG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfH = bVar;
    }

    private void cBQ() {
        this.fwQ = System.currentTimeMillis() / 1000;
    }

    public boolean cBR() {
        return this.jfN;
    }

    public void qf(boolean z) {
        this.jfN = z;
    }

    public boolean cBS() {
        return this.jfO;
    }

    public void qg(boolean z) {
        this.jfO = z;
    }

    public void AK(int i) {
        this.jfP = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cBQ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jfQ;

        public a(View view, T t) {
            super(view);
            this.jfQ = t;
        }

        public T cBT() {
            return this.jfQ;
        }
    }
}
