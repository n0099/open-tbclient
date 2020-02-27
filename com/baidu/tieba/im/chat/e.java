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
    protected long eja;
    protected com.baidu.adp.lib.b.a hsn;
    protected com.baidu.adp.lib.b.b hso;
    private boolean hsu;
    private boolean hsv;
    protected int hsw;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hsn = null;
        this.hso = null;
        this.eja = 0L;
        this.hsu = false;
        this.hsv = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hsn = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hso = bVar;
    }

    private void bSh() {
        this.eja = System.currentTimeMillis() / 1000;
    }

    public boolean bSi() {
        return this.hsu;
    }

    public void nc(boolean z) {
        this.hsu = z;
    }

    public boolean bSj() {
        return this.hsv;
    }

    public void nd(boolean z) {
        this.hsv = z;
    }

    public void wa(int i) {
        this.hsw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bSh();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hsx;

        public a(View view, T t) {
            super(view);
            this.hsx = t;
        }

        public T bSk() {
            return this.hsx;
        }
    }
}
