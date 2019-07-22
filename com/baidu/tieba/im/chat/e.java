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
    protected com.baidu.adp.lib.c.a gyM;
    protected com.baidu.adp.lib.c.b gyN;
    protected long gyT;
    private boolean gyU;
    private boolean gyV;
    protected int gyW;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gyM = null;
        this.gyN = null;
        this.gyT = 0L;
        this.gyU = false;
        this.gyV = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gyM = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gyN = bVar;
    }

    private void bAu() {
        this.gyT = System.currentTimeMillis() / 1000;
    }

    public boolean bAv() {
        return this.gyU;
    }

    public void lJ(boolean z) {
        this.gyU = z;
    }

    public boolean bAw() {
        return this.gyV;
    }

    public void lK(boolean z) {
        this.gyV = z;
    }

    public void vd(int i) {
        this.gyW = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bAu();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gyX;

        public a(View view, T t) {
            super(view);
            this.gyX = t;
        }

        public T bAx() {
            return this.gyX;
        }
    }
}
