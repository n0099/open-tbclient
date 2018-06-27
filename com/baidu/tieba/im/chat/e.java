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
    protected com.baidu.adp.lib.c.a egK;
    protected com.baidu.adp.lib.c.b egL;
    protected long egR;
    private boolean egS;
    private boolean egT;
    protected int egU;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.egK = null;
        this.egL = null;
        this.egR = 0L;
        this.egS = false;
        this.egT = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.egK = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.egL = bVar;
    }

    private void aGs() {
        this.egR = System.currentTimeMillis() / 1000;
    }

    public boolean aGt() {
        return this.egS;
    }

    public void gX(boolean z) {
        this.egS = z;
    }

    public boolean aGu() {
        return this.egT;
    }

    public void gY(boolean z) {
        this.egT = z;
    }

    public void ny(int i) {
        this.egU = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aGs();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T egV;

        public a(View view, T t) {
            super(view);
            this.egV = t;
        }

        public T aGv() {
            return this.egV;
        }
    }
}
