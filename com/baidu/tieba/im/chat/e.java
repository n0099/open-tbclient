package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long ejo;
    protected com.baidu.adp.lib.b.a hsB;
    protected com.baidu.adp.lib.b.b hsC;
    private boolean hsI;
    private boolean hsJ;
    protected int hsK;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hsB = null;
        this.hsC = null;
        this.ejo = 0L;
        this.hsI = false;
        this.hsJ = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsB = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hsC = bVar;
    }

    private void bSk() {
        this.ejo = System.currentTimeMillis() / 1000;
    }

    public boolean bSl() {
        return this.hsI;
    }

    public void nc(boolean z) {
        this.hsI = z;
    }

    public boolean bSm() {
        return this.hsJ;
    }

    public void nd(boolean z) {
        this.hsJ = z;
    }

    public void wa(int i) {
        this.hsK = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bSk();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hsL;

        public a(View view, T t) {
            super(view);
            this.hsL = t;
        }

        public T bSn() {
            return this.hsL;
        }
    }
}
