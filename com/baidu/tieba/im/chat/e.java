package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long eVS;
    protected com.baidu.adp.lib.b.a isD;
    protected com.baidu.adp.lib.b.b isE;
    private boolean isK;
    private boolean isL;
    protected int isM;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, aa.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.isD = null;
        this.isE = null;
        this.eVS = 0L;
        this.isK = false;
        this.isL = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.isD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.isE = bVar;
    }

    private void cjy() {
        this.eVS = System.currentTimeMillis() / 1000;
    }

    public boolean cjz() {
        return this.isK;
    }

    public void oI(boolean z) {
        this.isK = z;
    }

    public boolean cjA() {
        return this.isL;
    }

    public void oJ(boolean z) {
        this.isL = z;
    }

    public void xm(int i) {
        this.isM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cjy();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends aa.a {
        private T isN;

        public a(View view, T t) {
            super(view);
            this.isN = t;
        }

        public T cjB() {
            return this.isN;
        }
    }
}
