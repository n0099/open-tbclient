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
    private boolean kAA;
    private boolean kAB;
    protected int kAC;
    protected com.baidu.adp.lib.b.a kAt;
    protected com.baidu.adp.lib.b.b kAu;
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
        this.kAt = null;
        this.kAu = null;
        this.mCurrentTime = 0L;
        this.kAA = false;
        this.kAB = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kAt = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAu = bVar;
    }

    private void cUJ() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean cUK() {
        return this.kAA;
    }

    public void sB(boolean z) {
        this.kAA = z;
    }

    public boolean cUL() {
        return this.kAB;
    }

    public void sC(boolean z) {
        this.kAB = z;
    }

    public void CH(int i) {
        this.kAC = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cUJ();
        return view;
    }

    /* loaded from: classes.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {
        private T kAD;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.kAD = t;
        }

        public T cUM() {
            return this.kAD;
        }
    }
}
