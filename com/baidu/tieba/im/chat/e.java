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
    protected com.baidu.adp.lib.c.a ecQ;
    protected com.baidu.adp.lib.c.b ecR;
    protected long ecX;
    private boolean ecY;
    private boolean ecZ;
    protected int eda;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ecQ = null;
        this.ecR = null;
        this.ecX = 0L;
        this.ecY = false;
        this.ecZ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ecQ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ecR = bVar;
    }

    private void aFK() {
        this.ecX = System.currentTimeMillis() / 1000;
    }

    public boolean aFL() {
        return this.ecY;
    }

    public void gN(boolean z) {
        this.ecY = z;
    }

    public boolean aFM() {
        return this.ecZ;
    }

    public void gO(boolean z) {
        this.ecZ = z;
    }

    public void nr(int i) {
        this.eda = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aFK();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T edb;

        public a(View view, T t) {
            super(view);
            this.edb = t;
        }

        public T aFN() {
            return this.edb;
        }
    }
}
