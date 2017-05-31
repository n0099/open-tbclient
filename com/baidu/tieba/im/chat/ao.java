package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ao<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> ajh;
    protected com.baidu.adp.lib.c.a cPk;
    protected com.baidu.adp.lib.c.b cPl;
    protected long cPr;
    private boolean cPs;
    private boolean cPt;
    protected int cPu;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cPk = null;
        this.cPl = null;
        this.cPr = 0L;
        this.cPs = false;
        this.cPt = false;
        this.ajh = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cPk = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cPl = bVar;
    }

    private void amn() {
        this.cPr = System.currentTimeMillis() / 1000;
    }

    public boolean amo() {
        return this.cPs;
    }

    public void fn(boolean z) {
        this.cPs = z;
    }

    public boolean amp() {
        return this.cPt;
    }

    public void fo(boolean z) {
        this.cPt = z;
    }

    public void lq(int i) {
        this.cPu = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        amn();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends z.a {
        private T cPv;

        public a(View view, T t) {
            super(view);
            this.cPv = t;
        }

        public T amq() {
            return this.cPv;
        }
    }
}
