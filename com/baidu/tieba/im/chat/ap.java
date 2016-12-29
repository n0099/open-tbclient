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
    protected TbPageContext<MsglistActivity<?>> GO;
    protected long cFF;
    private boolean cFG;
    private boolean cFH;
    protected int cFI;
    protected com.baidu.adp.lib.d.a cFy;
    protected com.baidu.adp.lib.d.b cFz;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cFy = null;
        this.cFz = null;
        this.cFF = 0L;
        this.cFG = false;
        this.cFH = false;
        this.GO = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cFy = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cFz = bVar;
    }

    private void amX() {
        this.cFF = System.currentTimeMillis() / 1000;
    }

    public boolean amY() {
        return this.cFG;
    }

    public void fv(boolean z) {
        this.cFG = z;
    }

    public boolean amZ() {
        return this.cFH;
    }

    public void fw(boolean z) {
        this.cFH = z;
    }

    public void kz(int i) {
        this.cFI = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        amX();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cFJ;

        public a(View view, T t) {
            super(view);
            this.cFJ = t;
        }

        public T ana() {
            return this.cFJ;
        }
    }
}
