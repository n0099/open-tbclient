package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a gbi;
    protected com.baidu.adp.lib.c.b gbj;
    protected long gbp;
    private boolean gbq;
    private boolean gbr;
    protected int gbs;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbi = null;
        this.gbj = null;
        this.gbp = 0L;
        this.gbq = false;
        this.gbr = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbi = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbj = bVar;
    }

    private void bqa() {
        this.gbp = System.currentTimeMillis() / 1000;
    }

    public boolean bqb() {
        return this.gbq;
    }

    public void kF(boolean z) {
        this.gbq = z;
    }

    public boolean bqc() {
        return this.gbr;
    }

    public void kG(boolean z) {
        this.gbr = z;
    }

    public void tv(int i) {
        this.gbs = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bqa();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gbt;

        public a(View view, T t) {
            super(view);
            this.gbt = t;
        }

        public T bqd() {
            return this.gbt;
        }
    }
}
