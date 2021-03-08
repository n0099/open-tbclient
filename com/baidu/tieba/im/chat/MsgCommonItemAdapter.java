package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class MsgCommonItemAdapter<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, MsgViewHolder<T>> {
    private boolean kCC;
    private boolean kCD;
    protected int kCE;
    protected com.baidu.adp.lib.b.a kCv;
    protected com.baidu.adp.lib.b.b kCw;
    protected long mCurrentTime;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        return a(i, view, viewGroup, chatMessage, (MsgViewHolder) ((MsgViewHolder) viewHolder));
    }

    public MsgCommonItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kCv = null;
        this.kCw = null;
        this.mCurrentTime = 0L;
        this.kCC = false;
        this.kCD = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kCv = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kCw = bVar;
    }

    private void cUQ() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean cUR() {
        return this.kCC;
    }

    public void sB(boolean z) {
        this.kCC = z;
    }

    public boolean cUS() {
        return this.kCD;
    }

    public void sC(boolean z) {
        this.kCD = z;
    }

    public void CK(int i) {
        this.kCE = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cUQ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {
        private T kCF;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.kCF = t;
        }

        public T cUT() {
            return this.kCF;
        }
    }
}
