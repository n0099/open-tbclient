package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a erF;
    protected b erG;
    protected long erM;
    private boolean erN;
    private boolean erO;
    protected int erP;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.erF = null;
        this.erG = null;
        this.erM = 0L;
        this.erN = false;
        this.erO = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erF = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.erG = bVar;
    }

    private void aEx() {
        this.erM = System.currentTimeMillis() / 1000;
    }

    public boolean aEy() {
        return this.erN;
    }

    public void gQ(boolean z) {
        this.erN = z;
    }

    public boolean aEz() {
        return this.erO;
    }

    public void gR(boolean z) {
        this.erO = z;
    }

    public void pG(int i) {
        this.erP = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aEx();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T erQ;

        public a(View view, T t) {
            super(view);
            this.erQ = t;
        }

        public T aEA() {
            return this.erQ;
        }
    }
}
