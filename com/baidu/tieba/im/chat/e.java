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
    protected com.baidu.adp.lib.c.b dQA;
    protected long dQG;
    private boolean dQH;
    private boolean dQI;
    protected int dQJ;
    protected com.baidu.adp.lib.c.a dQz;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQz = null;
        this.dQA = null;
        this.dQG = 0L;
        this.dQH = false;
        this.dQI = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dQz = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQA = bVar;
    }

    private void aAR() {
        this.dQG = System.currentTimeMillis() / 1000;
    }

    public boolean aAS() {
        return this.dQH;
    }

    public void gG(boolean z) {
        this.dQH = z;
    }

    public boolean aAT() {
        return this.dQI;
    }

    public void gH(boolean z) {
        this.dQI = z;
    }

    public void nh(int i) {
        this.dQJ = i;
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
        private T dQK;

        public a(View view2, T t) {
            super(view2);
            this.dQK = t;
        }

        public T aAU() {
            return this.dQK;
        }
    }
}
