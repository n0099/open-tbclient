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
    private boolean boA;
    private boolean boB;
    protected int boC;
    protected com.baidu.adp.lib.c.a bot;
    protected com.baidu.adp.lib.c.b bou;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bot = null;
        this.bou = null;
        this.mCurrentTime = 0L;
        this.boA = false;
        this.boB = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.bot = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.bou = bVar;
    }

    private void Rf() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Rg() {
        return this.boA;
    }

    public void cI(boolean z) {
        this.boA = z;
    }

    public boolean Rh() {
        return this.boB;
    }

    public void cJ(boolean z) {
        this.boB = z;
    }

    public void gC(int i) {
        this.boC = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Rf();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T boD;

        public a(View view, T t) {
            super(view);
            this.boD = t;
        }

        public T Ri() {
            return this.boD;
        }
    }
}
