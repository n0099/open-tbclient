package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a dqC;
    protected b dqD;
    protected long dqJ;
    private boolean dqK;
    private boolean dqL;
    protected int dqM;
    protected TbPageContext<MsglistActivity<?>> mF;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dqC = null;
        this.dqD = null;
        this.dqJ = 0L;
        this.dqK = false;
        this.dqL = false;
        this.mF = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dqC = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dqD = bVar;
    }

    private void aul() {
        this.dqJ = System.currentTimeMillis() / 1000;
    }

    public boolean aum() {
        return this.dqK;
    }

    public void ge(boolean z) {
        this.dqK = z;
    }

    public boolean aun() {
        return this.dqL;
    }

    public void gf(boolean z) {
        this.dqL = z;
    }

    public void mo(int i) {
        this.dqM = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aul();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dqN;

        public a(View view, T t) {
            super(view);
            this.dqN = t;
        }

        public T auo() {
            return this.dqN;
        }
    }
}
