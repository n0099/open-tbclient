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
    protected com.baidu.adp.lib.c.a brD;
    protected com.baidu.adp.lib.c.b brE;
    private boolean brK;
    private boolean brL;
    protected int brM;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.x$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, x.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.brD = null;
        this.brE = null;
        this.mCurrentTime = 0L;
        this.brK = false;
        this.brL = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.brD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.brE = bVar;
    }

    private void RM() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean RN() {
        return this.brK;
    }

    public void cI(boolean z) {
        this.brK = z;
    }

    public boolean RO() {
        return this.brL;
    }

    public void cJ(boolean z) {
        this.brL = z;
    }

    public void gI(int i) {
        this.brM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        RM();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends x.a {
        private T brN;

        public a(View view, T t) {
            super(view);
            this.brN = t;
        }

        public T RP() {
            return this.brN;
        }
    }
}
