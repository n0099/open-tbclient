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
    protected com.baidu.adp.lib.c.a aXc;
    protected com.baidu.adp.lib.c.b aXd;
    private boolean aXj;
    private boolean aXk;
    protected int aXl;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.am] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, am amVar) {
        return a(i, view, viewGroup, chatMessage, (be) ((be) amVar));
    }

    public bd(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aXc = null;
        this.aXd = null;
        this.mCurrentTime = 0L;
        this.aXj = false;
        this.aXk = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aXc = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXd = bVar;
    }

    private void NP() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean NQ() {
        return this.aXj;
    }

    public void cp(boolean z) {
        this.aXj = z;
    }

    public boolean NR() {
        return this.aXk;
    }

    public void cq(boolean z) {
        this.aXk = z;
    }

    public void fy(int i) {
        this.aXl = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<T> beVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        NP();
        return view;
    }
}
