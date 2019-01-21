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
    protected long eLA;
    private boolean eLB;
    private boolean eLC;
    protected int eLD;
    protected com.baidu.adp.lib.c.a eLt;
    protected com.baidu.adp.lib.c.b eLu;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eLt = null;
        this.eLu = null;
        this.eLA = 0L;
        this.eLB = false;
        this.eLC = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eLt = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eLu = bVar;
    }

    private void aPy() {
        this.eLA = System.currentTimeMillis() / 1000;
    }

    public boolean aPz() {
        return this.eLB;
    }

    /* renamed from: if  reason: not valid java name */
    public void m20if(boolean z) {
        this.eLB = z;
    }

    public boolean aPA() {
        return this.eLC;
    }

    public void ig(boolean z) {
        this.eLC = z;
    }

    public void pP(int i) {
        this.eLD = i;
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
        private T eLE;

        public a(View view, T t) {
            super(view);
            this.eLE = t;
        }

        public T aPB() {
            return this.eLE;
        }
    }
}
