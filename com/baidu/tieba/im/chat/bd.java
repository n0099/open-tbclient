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
    protected com.baidu.adp.lib.c.a aZZ;
    protected com.baidu.adp.lib.c.b baa;
    private boolean bag;
    private boolean bah;
    protected int bai;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.am] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, am amVar) {
        return a(i, view, viewGroup, chatMessage, (be) ((be) amVar));
    }

    public bd(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aZZ = null;
        this.baa = null;
        this.mCurrentTime = 0L;
        this.bag = false;
        this.bah = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aZZ = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.baa = bVar;
    }

    private void Ps() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean Pt() {
        return this.bag;
    }

    public void cy(boolean z) {
        this.bag = z;
    }

    public boolean Pu() {
        return this.bah;
    }

    public void cz(boolean z) {
        this.bah = z;
    }

    public void fR(int i) {
        this.bai = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<T> beVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        Ps();
        return view;
    }
}
