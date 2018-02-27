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
    protected com.baidu.adp.lib.c.a evD;
    protected com.baidu.adp.lib.c.b evE;
    protected long evK;
    private boolean evL;
    private boolean evM;
    protected int evN;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.evD = null;
        this.evE = null;
        this.evK = 0L;
        this.evL = false;
        this.evM = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evE = bVar;
    }

    private void aFQ() {
        this.evK = System.currentTimeMillis() / 1000;
    }

    public boolean aFR() {
        return this.evL;
    }

    public void hb(boolean z) {
        this.evL = z;
    }

    public boolean aFS() {
        return this.evM;
    }

    public void hc(boolean z) {
        this.evM = z;
    }

    public void pH(int i) {
        this.evN = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aFQ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T evO;

        public a(View view, T t) {
            super(view);
            this.evO = t;
        }

        public T aFT() {
            return this.evO;
        }
    }
}
