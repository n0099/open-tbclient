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
    protected TbPageContext<MsglistActivity<?>> Nw;
    protected com.baidu.adp.lib.d.a bOI;
    protected com.baidu.adp.lib.d.b bOJ;
    private boolean bOP;
    private boolean bOQ;
    protected int bOR;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOI = null;
        this.bOJ = null;
        this.mCurrentTime = 0L;
        this.bOP = false;
        this.bOQ = false;
        this.Nw = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.bOI = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.bOJ = bVar;
    }

    private void YU() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean YV() {
        return this.bOP;
    }

    public void dh(boolean z) {
        this.bOP = z;
    }

    public boolean YW() {
        return this.bOQ;
    }

    public void di(boolean z) {
        this.bOQ = z;
    }

    public void iE(int i) {
        this.bOR = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        YU();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T bOS;

        public a(View view, T t) {
            super(view);
            this.bOS = t;
        }

        public T YX() {
            return this.bOS;
        }
    }
}
