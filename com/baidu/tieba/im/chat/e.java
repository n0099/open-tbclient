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
    protected long gas;
    protected com.baidu.adp.lib.b.a jVF;
    protected com.baidu.adp.lib.b.b jVG;
    private boolean jVM;
    private boolean jVN;
    protected int jVO;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, af.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jVF = null;
        this.jVG = null;
        this.gas = 0L;
        this.jVM = false;
        this.jVN = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.jVF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jVG = bVar;
    }

    private void cOO() {
        this.gas = System.currentTimeMillis() / 1000;
    }

    public boolean cOP() {
        return this.jVM;
    }

    public void ru(boolean z) {
        this.jVM = z;
    }

    public boolean cOQ() {
        return this.jVN;
    }

    public void rv(boolean z) {
        this.jVN = z;
    }

    public void Cx(int i) {
        this.jVO = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cOO();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends af.a {
        private T jVP;

        public a(View view, T t) {
            super(view);
            this.jVP = t;
        }

        public T cOR() {
            return this.jVP;
        }
    }
}
