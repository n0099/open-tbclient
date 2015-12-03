package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ap<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.d.a bHn;
    protected com.baidu.adp.lib.d.b bHo;
    private boolean bHu;
    private boolean bHv;
    protected int bHw;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bHn = null;
        this.bHo = null;
        this.mCurrentTime = 0L;
        this.bHu = false;
        this.bHv = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bHn = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bHo = bVar;
    }

    private void Vk() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Vl() {
        return this.bHu;
    }

    public void df(boolean z) {
        this.bHu = z;
    }

    public boolean Vm() {
        return this.bHv;
    }

    public void dg(boolean z) {
        this.bHv = z;
    }

    public void hH(int i) {
        this.bHw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Vk();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bHx;

        public a(View view, T t) {
            super(view);
            this.bHx = t;
        }

        public T Vn() {
            return this.bHx;
        }
    }
}
