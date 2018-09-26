package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a erQ;
    protected com.baidu.adp.lib.c.b erR;
    protected long erX;
    private boolean erY;
    private boolean erZ;
    protected int esa;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.erQ = null;
        this.erR = null;
        this.erX = 0L;
        this.erY = false;
        this.erZ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erQ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.erR = bVar;
    }

    private void aJE() {
        this.erX = System.currentTimeMillis() / 1000;
    }

    public boolean aJF() {
        return this.erY;
    }

    public void hy(boolean z) {
        this.erY = z;
    }

    public boolean aJG() {
        return this.erZ;
    }

    public void hz(boolean z) {
        this.erZ = z;
    }

    public void oq(int i) {
        this.esa = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aJE();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T esb;

        public a(View view, T t) {
            super(view);
            this.esb = t;
        }

        public T aJH() {
            return this.esb;
        }
    }
}
