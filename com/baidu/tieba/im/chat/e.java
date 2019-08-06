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
    protected com.baidu.adp.lib.c.a gzE;
    protected com.baidu.adp.lib.c.b gzF;
    protected long gzL;
    private boolean gzM;
    private boolean gzN;
    protected int gzO;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gzE = null;
        this.gzF = null;
        this.gzL = 0L;
        this.gzM = false;
        this.gzN = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gzE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gzF = bVar;
    }

    private void bAI() {
        this.gzL = System.currentTimeMillis() / 1000;
    }

    public boolean bAJ() {
        return this.gzM;
    }

    public void lJ(boolean z) {
        this.gzM = z;
    }

    public boolean bAK() {
        return this.gzN;
    }

    public void lK(boolean z) {
        this.gzN = z;
    }

    public void vf(int i) {
        this.gzO = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bAI();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gzP;

        public a(View view, T t) {
            super(view);
            this.gzP = t;
        }

        public T bAL() {
            return this.gzP;
        }
    }
}
