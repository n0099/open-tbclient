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
    protected TbPageContext<MsglistActivity<?>> alI;
    protected com.baidu.adp.lib.c.a dhg;
    protected b dhh;
    protected long dhn;
    private boolean dho;
    private boolean dhp;
    protected int dhq;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dhg = null;
        this.dhh = null;
        this.dhn = 0L;
        this.dho = false;
        this.dhp = false;
        this.alI = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dhg = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dhh = bVar;
    }

    private void arQ() {
        this.dhn = System.currentTimeMillis() / 1000;
    }

    public boolean arR() {
        return this.dho;
    }

    public void fS(boolean z) {
        this.dho = z;
    }

    public boolean arS() {
        return this.dhp;
    }

    public void fT(boolean z) {
        this.dhp = z;
    }

    public void lK(int i) {
        this.dhq = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        arQ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dhr;

        public a(View view, T t) {
            super(view);
            this.dhr = t;
        }

        public T arT() {
            return this.dhr;
        }
    }
}
