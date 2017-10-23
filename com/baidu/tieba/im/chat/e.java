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
    protected com.baidu.adp.lib.c.a dmE;
    protected b dmF;
    protected long dmL;
    private boolean dmM;
    private boolean dmN;
    protected int dmO;
    protected TbPageContext<MsglistActivity<?>> mH;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dmE = null;
        this.dmF = null;
        this.dmL = 0L;
        this.dmM = false;
        this.dmN = false;
        this.mH = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dmE = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dmF = bVar;
    }

    private void asR() {
        this.dmL = System.currentTimeMillis() / 1000;
    }

    public boolean asS() {
        return this.dmM;
    }

    public void fP(boolean z) {
        this.dmM = z;
    }

    public boolean asT() {
        return this.dmN;
    }

    public void fQ(boolean z) {
        this.dmN = z;
    }

    public void mj(int i) {
        this.dmO = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        asR();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dmP;

        public a(View view, T t) {
            super(view);
            this.dmP = t;
        }

        public T asU() {
            return this.dmP;
        }
    }
}
