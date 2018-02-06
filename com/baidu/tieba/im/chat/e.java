package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a evP;
    protected com.baidu.adp.lib.c.b evQ;
    protected long evW;
    private boolean evX;
    private boolean evY;
    protected int evZ;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.evP = null;
        this.evQ = null;
        this.evW = 0L;
        this.evX = false;
        this.evY = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evP = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evQ = bVar;
    }

    private void aFR() {
        this.evW = System.currentTimeMillis() / 1000;
    }

    public boolean aFS() {
        return this.evX;
    }

    public void hb(boolean z) {
        this.evX = z;
    }

    public boolean aFT() {
        return this.evY;
    }

    public void hc(boolean z) {
        this.evY = z;
    }

    public void pH(int i) {
        this.evZ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aFR();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T ewa;

        public a(View view, T t) {
            super(view);
            this.ewa = t;
        }

        public T aFU() {
            return this.ewa;
        }
    }
}
