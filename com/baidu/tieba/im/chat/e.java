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
    protected com.baidu.adp.lib.c.a dDF;
    protected b dDG;
    protected long dDM;
    private boolean dDN;
    private boolean dDO;
    protected int dDP;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dDF = null;
        this.dDG = null;
        this.dDM = 0L;
        this.dDN = false;
        this.dDO = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dDF = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dDG = bVar;
    }

    private void axl() {
        this.dDM = System.currentTimeMillis() / 1000;
    }

    public boolean axm() {
        return this.dDN;
    }

    public void gm(boolean z) {
        this.dDN = z;
    }

    public boolean axn() {
        return this.dDO;
    }

    public void gn(boolean z) {
        this.dDO = z;
    }

    public void mV(int i) {
        this.dDP = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        axl();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dDQ;

        public a(View view, T t) {
            super(view);
            this.dDQ = t;
        }

        public T axo() {
            return this.dDQ;
        }
    }
}
