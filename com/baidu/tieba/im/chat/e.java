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
    protected com.baidu.adp.lib.c.a dpH;
    protected b dpI;
    protected long dpO;
    private boolean dpP;
    private boolean dpQ;
    protected int dpR;
    protected TbPageContext<MsglistActivity<?>> mF;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dpH = null;
        this.dpI = null;
        this.dpO = 0L;
        this.dpP = false;
        this.dpQ = false;
        this.mF = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dpH = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dpI = bVar;
    }

    private void aua() {
        this.dpO = System.currentTimeMillis() / 1000;
    }

    public boolean aub() {
        return this.dpP;
    }

    public void gd(boolean z) {
        this.dpP = z;
    }

    public boolean auc() {
        return this.dpQ;
    }

    public void ge(boolean z) {
        this.dpQ = z;
    }

    public void mm(int i) {
        this.dpR = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aua();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dpS;

        public a(View view, T t) {
            super(view);
            this.dpS = t;
        }

        public T aud() {
            return this.dpS;
        }
    }
}
