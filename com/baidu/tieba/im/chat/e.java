package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a dDJ;
    protected b dDK;
    protected long dDQ;
    private boolean dDR;
    private boolean dDS;
    protected int dDT;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dDJ = null;
        this.dDK = null;
        this.dDQ = 0L;
        this.dDR = false;
        this.dDS = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dDJ = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dDK = bVar;
    }

    private void axm() {
        this.dDQ = System.currentTimeMillis() / 1000;
    }

    public boolean axn() {
        return this.dDR;
    }

    public void gm(boolean z) {
        this.dDR = z;
    }

    public boolean axo() {
        return this.dDS;
    }

    public void gn(boolean z) {
        this.dDS = z;
    }

    public void mV(int i) {
        this.dDT = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        axm();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dDU;

        public a(View view, T t) {
            super(view);
            this.dDU = t;
        }

        public T axp() {
            return this.dDU;
        }
    }
}
