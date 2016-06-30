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
    protected TbPageContext<MsglistActivity<?>> Ea;
    protected com.baidu.adp.lib.d.a cEP;
    protected com.baidu.adp.lib.d.b cEQ;
    private boolean cEW;
    private boolean cEX;
    protected int cEY;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cEP = null;
        this.cEQ = null;
        this.mCurrentTime = 0L;
        this.cEW = false;
        this.cEX = false;
        this.Ea = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cEP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cEQ = bVar;
    }

    private void akB() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean akC() {
        return this.cEW;
    }

    public void eQ(boolean z) {
        this.cEW = z;
    }

    public boolean akD() {
        return this.cEX;
    }

    public void eR(boolean z) {
        this.cEX = z;
    }

    public void kq(int i) {
        this.cEY = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        akB();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cEZ;

        public a(View view, T t) {
            super(view);
            this.cEZ = t;
        }

        public T akE() {
            return this.cEZ;
        }
    }
}
