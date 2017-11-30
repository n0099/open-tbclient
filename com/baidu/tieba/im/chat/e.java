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
    protected com.baidu.adp.lib.c.a dCB;
    protected b dCC;
    protected long dCI;
    private boolean dCJ;
    private boolean dCK;
    protected int dCL;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dCB = null;
        this.dCC = null;
        this.dCI = 0L;
        this.dCJ = false;
        this.dCK = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dCB = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dCC = bVar;
    }

    private void axd() {
        this.dCI = System.currentTimeMillis() / 1000;
    }

    public boolean axe() {
        return this.dCJ;
    }

    public void gl(boolean z) {
        this.dCJ = z;
    }

    public boolean axf() {
        return this.dCK;
    }

    public void gm(boolean z) {
        this.dCK = z;
    }

    public void mO(int i) {
        this.dCL = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        axd();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dCM;

        public a(View view, T t) {
            super(view);
            this.dCM = t;
        }

        public T axg() {
            return this.dCM;
        }
    }
}
