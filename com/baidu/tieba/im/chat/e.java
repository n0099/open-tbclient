package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long fwM;
    protected com.baidu.adp.lib.b.a jfA;
    protected com.baidu.adp.lib.b.b jfB;
    private boolean jfH;
    private boolean jfI;
    protected int jfJ;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jfA = null;
        this.jfB = null;
        this.fwM = 0L;
        this.jfH = false;
        this.jfI = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jfA = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfB = bVar;
    }

    private void cBP() {
        this.fwM = System.currentTimeMillis() / 1000;
    }

    public boolean cBQ() {
        return this.jfH;
    }

    public void qd(boolean z) {
        this.jfH = z;
    }

    public boolean cBR() {
        return this.jfI;
    }

    public void qe(boolean z) {
        this.jfI = z;
    }

    public void AK(int i) {
        this.jfJ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cBP();
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a<T> extends af.a {
        private T jfK;

        public a(View view, T t) {
            super(view);
            this.jfK = t;
        }

        public T cBS() {
            return this.jfK;
        }
    }
}
