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
    protected com.baidu.adp.lib.c.b gsA;
    protected long gsG;
    private boolean gsH;
    private boolean gsI;
    protected int gsJ;
    protected com.baidu.adp.lib.c.a gsz;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gsz = null;
        this.gsA = null;
        this.gsG = 0L;
        this.gsH = false;
        this.gsI = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsz = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsA = bVar;
    }

    private void bxP() {
        this.gsG = System.currentTimeMillis() / 1000;
    }

    public boolean bxQ() {
        return this.gsH;
    }

    public void lu(boolean z) {
        this.gsH = z;
    }

    public boolean bxR() {
        return this.gsI;
    }

    public void lv(boolean z) {
        this.gsI = z;
    }

    public void uC(int i) {
        this.gsJ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bxP();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gsK;

        public a(View view, T t) {
            super(view);
            this.gsK = t;
        }

        public T bxS() {
            return this.gsK;
        }
    }
}
