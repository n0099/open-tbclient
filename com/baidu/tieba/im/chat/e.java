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
    protected com.baidu.adp.lib.c.a eBa;
    protected com.baidu.adp.lib.c.b eBb;
    protected long eBh;
    private boolean eBi;
    private boolean eBj;
    protected int eBk;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eBa = null;
        this.eBb = null;
        this.eBh = 0L;
        this.eBi = false;
        this.eBj = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eBa = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eBb = bVar;
    }

    private void aMt() {
        this.eBh = System.currentTimeMillis() / 1000;
    }

    public boolean aMu() {
        return this.eBi;
    }

    public void hZ(boolean z) {
        this.eBi = z;
    }

    public boolean aMv() {
        return this.eBj;
    }

    public void ia(boolean z) {
        this.eBj = z;
    }

    public void pg(int i) {
        this.eBk = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aMt();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T eBl;

        public a(View view, T t) {
            super(view);
            this.eBl = t;
        }

        public T aMw() {
            return this.eBl;
        }
    }
}
