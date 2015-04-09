package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class bd<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, be<T>> {
    private boolean aXA;
    protected int aXB;
    protected com.baidu.adp.lib.c.a aXs;
    protected com.baidu.adp.lib.c.b aXt;
    private boolean aXz;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.am] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, am amVar) {
        return a(i, view, viewGroup, chatMessage, (be) ((be) amVar));
    }

    public bd(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aXs = null;
        this.aXt = null;
        this.mCurrentTime = 0L;
        this.aXz = false;
        this.aXA = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aXs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXt = bVar;
    }

    private void Oc() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Od() {
        return this.aXz;
    }

    public void cn(boolean z) {
        this.aXz = z;
    }

    public boolean Oe() {
        return this.aXA;
    }

    public void co(boolean z) {
        this.aXA = z;
    }

    public void fA(int i) {
        this.aXB = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<T> beVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Oc();
        return view;
    }
}
