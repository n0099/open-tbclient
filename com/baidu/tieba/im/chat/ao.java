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
    protected TbPageContext<MsglistActivity<?>> FY;
    protected com.baidu.adp.lib.c.a cMG;
    protected com.baidu.adp.lib.c.b cMH;
    protected long cMN;
    private boolean cMO;
    private boolean cMP;
    protected int cMQ;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cMG = null;
        this.cMH = null;
        this.cMN = 0L;
        this.cMO = false;
        this.cMP = false;
        this.FY = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cMG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cMH = bVar;
    }

    private void aof() {
        this.cMN = System.currentTimeMillis() / 1000;
    }

    public boolean aog() {
        return this.cMO;
    }

    public void fy(boolean z) {
        this.cMO = z;
    }

    public boolean aoh() {
        return this.cMP;
    }

    public void fz(boolean z) {
        this.cMP = z;
    }

    public void lm(int i) {
        this.cMQ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aof();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cMR;

        public a(View view, T t) {
            super(view);
            this.cMR = t;
        }

        public T aoi() {
            return this.cMR;
        }
    }
}
