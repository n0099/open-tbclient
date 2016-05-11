package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ap<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> DV;
    protected com.baidu.adp.lib.d.a bZF;
    protected com.baidu.adp.lib.d.b bZG;
    private boolean bZM;
    private boolean bZN;
    protected int bZO;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZF = null;
        this.bZG = null;
        this.mCurrentTime = 0L;
        this.bZM = false;
        this.bZN = false;
        this.DV = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bZF = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bZG = bVar;
    }

    private void acn() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean aco() {
        return this.bZM;
    }

    public void ec(boolean z) {
        this.bZM = z;
    }

    public boolean acp() {
        return this.bZN;
    }

    public void ed(boolean z) {
        this.bZN = z;
    }

    public void iP(int i) {
        this.bZO = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        acn();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T bZP;

        public a(View view, T t) {
            super(view);
            this.bZP = t;
        }

        public T acq() {
            return this.bZP;
        }
    }
}
