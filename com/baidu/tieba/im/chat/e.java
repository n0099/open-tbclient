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
    protected long eeP;
    protected com.baidu.adp.lib.b.a hmL;
    protected com.baidu.adp.lib.b.b hmM;
    private boolean hmS;
    private boolean hmT;
    protected int hmU;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hmL = null;
        this.hmM = null;
        this.eeP = 0L;
        this.hmS = false;
        this.hmT = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.hmL = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hmM = bVar;
    }

    private void bPx() {
        this.eeP = System.currentTimeMillis() / 1000;
    }

    public boolean bPy() {
        return this.hmS;
    }

    public void mO(boolean z) {
        this.hmS = z;
    }

    public boolean bPz() {
        return this.hmT;
    }

    public void mP(boolean z) {
        this.hmT = z;
    }

    public void vP(int i) {
        this.hmU = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bPx();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T hmV;

        public a(View view, T t) {
            super(view);
            this.hmV = t;
        }

        public T bPA() {
            return this.hmV;
        }
    }
}
