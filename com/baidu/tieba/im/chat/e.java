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
    protected TbPageContext<MsglistActivity<?>> ako;
    protected com.baidu.adp.lib.c.a dfO;
    protected b dfP;
    protected long dfV;
    private boolean dfW;
    private boolean dfX;
    protected int dfY;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dfO = null;
        this.dfP = null;
        this.dfV = 0L;
        this.dfW = false;
        this.dfX = false;
        this.ako = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dfO = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dfP = bVar;
    }

    private void arE() {
        this.dfV = System.currentTimeMillis() / 1000;
    }

    public boolean arF() {
        return this.dfW;
    }

    public void fS(boolean z) {
        this.dfW = z;
    }

    public boolean arG() {
        return this.dfX;
    }

    public void fT(boolean z) {
        this.dfX = z;
    }

    public void lL(int i) {
        this.dfY = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        arE();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dfZ;

        public a(View view, T t) {
            super(view);
            this.dfZ = t;
        }

        public T arH() {
            return this.dfZ;
        }
    }
}
