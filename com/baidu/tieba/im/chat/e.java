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
    protected long dQD;
    private boolean dQE;
    private boolean dQF;
    protected int dQG;
    protected com.baidu.adp.lib.c.a dQw;
    protected com.baidu.adp.lib.c.b dQx;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQw = null;
        this.dQx = null;
        this.dQD = 0L;
        this.dQE = false;
        this.dQF = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dQw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQx = bVar;
    }

    private void aAR() {
        this.dQD = System.currentTimeMillis() / 1000;
    }

    public boolean aAS() {
        return this.dQE;
    }

    public void gG(boolean z) {
        this.dQE = z;
    }

    public boolean aAT() {
        return this.dQF;
    }

    public void gH(boolean z) {
        this.dQF = z;
    }

    public void ng(int i) {
        this.dQG = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aAR();
        return view2;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T dQH;

        public a(View view2, T t) {
            super(view2);
            this.dQH = t;
        }

        public T aAU() {
            return this.dQH;
        }
    }
}
