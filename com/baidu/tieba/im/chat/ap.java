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
    protected TbPageContext<MsglistActivity<?>> GM;
    protected com.baidu.adp.lib.d.a cUE;
    protected com.baidu.adp.lib.d.b cUF;
    private boolean cUL;
    private boolean cUM;
    protected int cUN;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cUE = null;
        this.cUF = null;
        this.mCurrentTime = 0L;
        this.cUL = false;
        this.cUM = false;
        this.GM = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cUE = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cUF = bVar;
    }

    private void aqz() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean aqA() {
        return this.cUL;
    }

    public void fq(boolean z) {
        this.cUL = z;
    }

    public boolean aqB() {
        return this.cUM;
    }

    public void fr(boolean z) {
        this.cUM = z;
    }

    public void lh(int i) {
        this.cUN = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aqz();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cUO;

        public a(View view, T t) {
            super(view);
            this.cUO = t;
        }

        public T aqC() {
            return this.cUO;
        }
    }
}
