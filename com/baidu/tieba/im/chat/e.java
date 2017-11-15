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
    protected com.baidu.adp.lib.c.a duO;
    protected b duP;
    protected long duV;
    private boolean duW;
    private boolean duX;
    protected int duY;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.duO = null;
        this.duP = null;
        this.duV = 0L;
        this.duW = false;
        this.duX = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.duO = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.duP = bVar;
    }

    private void avD() {
        this.duV = System.currentTimeMillis() / 1000;
    }

    public boolean avE() {
        return this.duW;
    }

    public void fR(boolean z) {
        this.duW = z;
    }

    public boolean avF() {
        return this.duX;
    }

    public void fS(boolean z) {
        this.duX = z;
    }

    public void mA(int i) {
        this.duY = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        avD();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T duZ;

        public a(View view, T t) {
            super(view);
            this.duZ = t;
        }

        public T avG() {
            return this.duZ;
        }
    }
}
