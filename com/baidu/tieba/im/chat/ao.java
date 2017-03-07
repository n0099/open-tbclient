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
    protected TbPageContext<MsglistActivity<?>> ajF;
    protected com.baidu.adp.lib.c.a cOV;
    protected com.baidu.adp.lib.c.b cOW;
    protected long cPc;
    private boolean cPd;
    private boolean cPe;
    protected int cPf;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cOV = null;
        this.cOW = null;
        this.cPc = 0L;
        this.cPd = false;
        this.cPe = false;
        this.ajF = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cOV = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cOW = bVar;
    }

    private void anz() {
        this.cPc = System.currentTimeMillis() / 1000;
    }

    public boolean anA() {
        return this.cPd;
    }

    public void fo(boolean z) {
        this.cPd = z;
    }

    public boolean anB() {
        return this.cPe;
    }

    public void fp(boolean z) {
        this.cPe = z;
    }

    public void lc(int i) {
        this.cPf = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        anz();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cPg;

        public a(View view, T t) {
            super(view);
            this.cPg = t;
        }

        public T anC() {
            return this.cPg;
        }
    }
}
