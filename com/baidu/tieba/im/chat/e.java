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
    protected com.baidu.adp.lib.c.a ezG;
    protected com.baidu.adp.lib.c.b ezH;
    protected long ezN;
    private boolean ezO;
    private boolean ezP;
    protected int ezQ;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ezG = null;
        this.ezH = null;
        this.ezN = 0L;
        this.ezO = false;
        this.ezP = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ezG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezH = bVar;
    }

    private void aMV() {
        this.ezN = System.currentTimeMillis() / 1000;
    }

    public boolean aMW() {
        return this.ezO;
    }

    public void hQ(boolean z) {
        this.ezO = z;
    }

    public boolean aMX() {
        return this.ezP;
    }

    public void hR(boolean z) {
        this.ezP = z;
    }

    public void oO(int i) {
        this.ezQ = i;
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
        private T ezR;

        public a(View view, T t) {
            super(view);
            this.ezR = t;
        }

        public T aMY() {
            return this.ezR;
        }
    }
}
