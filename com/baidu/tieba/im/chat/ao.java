package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ao<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> ajU;
    protected com.baidu.adp.lib.c.a cPJ;
    protected com.baidu.adp.lib.c.b cPK;
    protected long cPQ;
    private boolean cPR;
    private boolean cPS;
    protected int cPT;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cPJ = null;
        this.cPK = null;
        this.cPQ = 0L;
        this.cPR = false;
        this.cPS = false;
        this.ajU = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cPJ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cPK = bVar;
    }

    private void aou() {
        this.cPQ = System.currentTimeMillis() / 1000;
    }

    public boolean aov() {
        return this.cPR;
    }

    public void fy(boolean z) {
        this.cPR = z;
    }

    public boolean aow() {
        return this.cPS;
    }

    public void fz(boolean z) {
        this.cPS = z;
    }

    public void lj(int i) {
        this.cPT = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aou();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cPU;

        public a(View view, T t) {
            super(view);
            this.cPU = t;
        }

        public T aox() {
            return this.cPU;
        }
    }
}
