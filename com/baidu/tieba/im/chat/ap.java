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
    protected com.baidu.adp.lib.d.a cTk;
    protected com.baidu.adp.lib.d.b cTl;
    private boolean cTr;
    private boolean cTs;
    protected int cTt;
    protected long mCurrentTime;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, y.a aVar) {
        return a(i, view, viewGroup, chatMessage, (a) ((a) aVar));
    }

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cTk = null;
        this.cTl = null;
        this.mCurrentTime = 0L;
        this.cTr = false;
        this.cTs = false;
        this.GM = tbPageContext;
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        this.cTk = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        this.cTl = bVar;
    }

    private void aqa() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean aqb() {
        return this.cTr;
    }

    public void fn(boolean z) {
        this.cTr = z;
    }

    public boolean aqc() {
        return this.cTs;
    }

    public void fo(boolean z) {
        this.cTs = z;
    }

    public void kZ(int i) {
        this.cTt = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aqa();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cTu;

        public a(View view, T t) {
            super(view);
            this.cTu = t;
        }

        public T aqd() {
            return this.cTu;
        }
    }
}
