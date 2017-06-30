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
    protected TbPageContext<MsglistActivity<?>> ajP;
    protected com.baidu.adp.lib.c.a cXg;
    protected com.baidu.adp.lib.c.b cXh;
    protected long cXn;
    private boolean cXo;
    private boolean cXp;
    protected int cXq;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cXg = null;
        this.cXh = null;
        this.cXn = 0L;
        this.cXo = false;
        this.cXp = false;
        this.ajP = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cXg = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cXh = bVar;
    }

    private void apY() {
        this.cXn = System.currentTimeMillis() / 1000;
    }

    public boolean apZ() {
        return this.cXo;
    }

    public void fE(boolean z) {
        this.cXo = z;
    }

    public boolean aqa() {
        return this.cXp;
    }

    public void fF(boolean z) {
        this.cXp = z;
    }

    public void lB(int i) {
        this.cXq = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        apY();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends z.a {
        private T cXr;

        public a(View view, T t) {
            super(view);
            this.cXr = t;
        }

        public T aqb() {
            return this.cXr;
        }
    }
}
