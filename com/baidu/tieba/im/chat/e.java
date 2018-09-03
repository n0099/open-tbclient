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
    protected long ekD;
    private boolean ekE;
    private boolean ekF;
    protected int ekG;
    protected com.baidu.adp.lib.c.a ekw;
    protected com.baidu.adp.lib.c.b ekx;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ekw = null;
        this.ekx = null;
        this.ekD = 0L;
        this.ekE = false;
        this.ekF = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekw = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    private void aHp() {
        this.ekD = System.currentTimeMillis() / 1000;
    }

    public boolean aHq() {
        return this.ekE;
    }

    public void ha(boolean z) {
        this.ekE = z;
    }

    public boolean aHr() {
        return this.ekF;
    }

    public void hb(boolean z) {
        this.ekF = z;
    }

    public void nM(int i) {
        this.ekG = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aHp();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T ekH;

        public a(View view, T t) {
            super(view);
            this.ekH = t;
        }

        public T aHs() {
            return this.ekH;
        }
    }
}
