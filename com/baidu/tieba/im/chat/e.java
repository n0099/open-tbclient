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
    private boolean eLA;
    private boolean eLB;
    protected int eLC;
    protected com.baidu.adp.lib.c.a eLs;
    protected com.baidu.adp.lib.c.b eLt;
    protected long eLz;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eLs = null;
        this.eLt = null;
        this.eLz = 0L;
        this.eLA = false;
        this.eLB = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eLs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eLt = bVar;
    }

    private void aPy() {
        this.eLz = System.currentTimeMillis() / 1000;
    }

    public boolean aPz() {
        return this.eLA;
    }

    /* renamed from: if  reason: not valid java name */
    public void m20if(boolean z) {
        this.eLA = z;
    }

    public boolean aPA() {
        return this.eLB;
    }

    public void ig(boolean z) {
        this.eLB = z;
    }

    public void pP(int i) {
        this.eLC = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aPy();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T eLD;

        public a(View view, T t) {
            super(view);
            this.eLD = t;
        }

        public T aPB() {
            return this.eLD;
        }
    }
}
