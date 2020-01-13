package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long eeX;
    protected com.baidu.adp.lib.b.a hqo;
    protected com.baidu.adp.lib.b.b hqp;
    private boolean hqv;
    private boolean hqw;
    protected int hqx;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hqo = null;
        this.hqp = null;
        this.eeX = 0L;
        this.hqv = false;
        this.hqw = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hqo = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hqp = bVar;
    }

    private void bQG() {
        this.eeX = System.currentTimeMillis() / 1000;
    }

    public boolean bQH() {
        return this.hqv;
    }

    public void na(boolean z) {
        this.hqv = z;
    }

    public boolean bQI() {
        return this.hqw;
    }

    public void nb(boolean z) {
        this.hqw = z;
    }

    public void vU(int i) {
        this.hqx = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bQG();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hqy;

        public a(View view, T t) {
            super(view);
            this.hqy = t;
        }

        public T bQJ() {
            return this.hqy;
        }
    }
}
