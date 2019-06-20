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
    protected com.baidu.adp.lib.c.a gsB;
    protected com.baidu.adp.lib.c.b gsC;
    protected long gsI;
    private boolean gsJ;
    private boolean gsK;
    protected int gsL;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gsB = null;
        this.gsC = null;
        this.gsI = 0L;
        this.gsJ = false;
        this.gsK = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsC = bVar;
    }

    private void bxQ() {
        this.gsI = System.currentTimeMillis() / 1000;
    }

    public boolean bxR() {
        return this.gsJ;
    }

    public void lv(boolean z) {
        this.gsJ = z;
    }

    public boolean bxS() {
        return this.gsK;
    }

    public void lw(boolean z) {
        this.gsK = z;
    }

    public void uC(int i) {
        this.gsL = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bxQ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gsM;

        public a(View view, T t) {
            super(view);
            this.gsM = t;
        }

        public T bxT() {
            return this.gsM;
        }
    }
}
