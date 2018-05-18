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
    protected com.baidu.adp.lib.c.a dRD;
    protected com.baidu.adp.lib.c.b dRE;
    protected long dRK;
    private boolean dRL;
    private boolean dRM;
    protected int dRN;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dRD = null;
        this.dRE = null;
        this.dRK = 0L;
        this.dRL = false;
        this.dRM = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dRD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dRE = bVar;
    }

    private void aAP() {
        this.dRK = System.currentTimeMillis() / 1000;
    }

    public boolean aAQ() {
        return this.dRL;
    }

    public void gH(boolean z) {
        this.dRL = z;
    }

    public boolean aAR() {
        return this.dRM;
    }

    public void gI(boolean z) {
        this.dRM = z;
    }

    public void nf(int i) {
        this.dRN = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aAP();
        return view2;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T dRO;

        public a(View view2, T t) {
            super(view2);
            this.dRO = t;
        }

        public T aAS() {
            return this.dRO;
        }
    }
}
