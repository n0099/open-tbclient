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
    protected com.baidu.adp.lib.c.a eHP;
    protected com.baidu.adp.lib.c.b eHQ;
    protected long eHW;
    private boolean eHX;
    private boolean eHY;
    protected int eHZ;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eHP = null;
        this.eHQ = null;
        this.eHW = 0L;
        this.eHX = false;
        this.eHY = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eHP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eHQ = bVar;
    }

    private void aOl() {
        this.eHW = System.currentTimeMillis() / 1000;
    }

    public boolean aOm() {
        return this.eHX;
    }

    public void ic(boolean z) {
        this.eHX = z;
    }

    public boolean aOn() {
        return this.eHY;
    }

    public void id(boolean z) {
        this.eHY = z;
    }

    public void pB(int i) {
        this.eHZ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aOl();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T eIa;

        public a(View view, T t) {
            super(view);
            this.eIa = t;
        }

        public T aOo() {
            return this.eIa;
        }
    }
}
