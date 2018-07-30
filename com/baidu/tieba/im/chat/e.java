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
    protected com.baidu.adp.lib.c.a ekA;
    protected com.baidu.adp.lib.c.b ekB;
    protected long ekH;
    private boolean ekI;
    private boolean ekJ;
    protected int ekK;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ekA = null;
        this.ekB = null;
        this.ekH = 0L;
        this.ekI = false;
        this.ekJ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekA = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekB = bVar;
    }

    private void aHs() {
        this.ekH = System.currentTimeMillis() / 1000;
    }

    public boolean aHt() {
        return this.ekI;
    }

    public void ha(boolean z) {
        this.ekI = z;
    }

    public boolean aHu() {
        return this.ekJ;
    }

    public void hb(boolean z) {
        this.ekJ = z;
    }

    public void nM(int i) {
        this.ekK = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aHs();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T ekL;

        public a(View view, T t) {
            super(view);
            this.ekL = t;
        }

        public T aHv() {
            return this.ekL;
        }
    }
}
