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
    protected long dHl;
    private boolean gzB;
    private boolean gzC;
    protected int gzD;
    protected com.baidu.adp.lib.c.a gzu;
    protected com.baidu.adp.lib.c.b gzv;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, v.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gzu = null;
        this.gzv = null;
        this.dHl = 0L;
        this.gzB = false;
        this.gzC = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gzu = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gzv = bVar;
    }

    private void byh() {
        this.dHl = System.currentTimeMillis() / 1000;
    }

    public boolean byi() {
        return this.gzB;
    }

    public void lA(boolean z) {
        this.gzB = z;
    }

    public boolean byj() {
        return this.gzC;
    }

    public void lB(boolean z) {
        this.gzC = z;
    }

    public void tO(int i) {
        this.gzD = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        byh();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gzE;

        public a(View view, T t) {
            super(view);
            this.gzE = t;
        }

        public T byk() {
            return this.gzE;
        }
    }
}
