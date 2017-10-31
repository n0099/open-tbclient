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
    protected long duB;
    private boolean duC;
    private boolean duD;
    protected int duE;
    protected com.baidu.adp.lib.c.a duu;
    protected b duv;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.duu = null;
        this.duv = null;
        this.duB = 0L;
        this.duC = false;
        this.duD = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.duu = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.duv = bVar;
    }

    private void avm() {
        this.duB = System.currentTimeMillis() / 1000;
    }

    public boolean avn() {
        return this.duC;
    }

    public void fL(boolean z) {
        this.duC = z;
    }

    public boolean avo() {
        return this.duD;
    }

    public void fM(boolean z) {
        this.duD = z;
    }

    public void mA(int i) {
        this.duE = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        avm();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T duF;

        public a(View view, T t) {
            super(view);
            this.duF = t;
        }

        public T avp() {
            return this.duF;
        }
    }
}
