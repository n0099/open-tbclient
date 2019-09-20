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
    protected long gBC;
    private boolean gBD;
    private boolean gBE;
    protected int gBF;
    protected com.baidu.adp.lib.c.a gBv;
    protected com.baidu.adp.lib.c.b gBw;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gBv = null;
        this.gBw = null;
        this.gBC = 0L;
        this.gBD = false;
        this.gBE = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gBv = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gBw = bVar;
    }

    private void bBw() {
        this.gBC = System.currentTimeMillis() / 1000;
    }

    public boolean bBx() {
        return this.gBD;
    }

    public void lM(boolean z) {
        this.gBD = z;
    }

    public boolean bBy() {
        return this.gBE;
    }

    public void lN(boolean z) {
        this.gBE = z;
    }

    public void vj(int i) {
        this.gBF = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bBw();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gBG;

        public a(View view, T t) {
            super(view);
            this.gBG = t;
        }

        public T bBz() {
            return this.gBG;
        }
    }
}
