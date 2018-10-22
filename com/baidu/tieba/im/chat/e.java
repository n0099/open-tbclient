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
    protected com.baidu.adp.lib.c.a ezH;
    protected com.baidu.adp.lib.c.b ezI;
    protected long ezO;
    private boolean ezP;
    private boolean ezQ;
    protected int ezR;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ezH = null;
        this.ezI = null;
        this.ezO = 0L;
        this.ezP = false;
        this.ezQ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ezH = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezI = bVar;
    }

    private void aMV() {
        this.ezO = System.currentTimeMillis() / 1000;
    }

    public boolean aMW() {
        return this.ezP;
    }

    public void hQ(boolean z) {
        this.ezP = z;
    }

    public boolean aMX() {
        return this.ezQ;
    }

    public void hR(boolean z) {
        this.ezQ = z;
    }

    public void oO(int i) {
        this.ezR = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aMV();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T ezS;

        public a(View view, T t) {
            super(view);
            this.ezS = t;
        }

        public T aMY() {
            return this.ezS;
        }
    }
}
