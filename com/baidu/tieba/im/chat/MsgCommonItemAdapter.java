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
    protected com.baidu.adp.lib.b.a kAf;
    protected com.baidu.adp.lib.b.b kAg;
    private boolean kAm;
    private boolean kAn;
    protected int kAo;
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
        this.kAf = null;
        this.kAg = null;
        this.mCurrentTime = 0L;
        this.kAm = false;
        this.kAn = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kAf = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAg = bVar;
    }

    private void cUC() {
        this.mCurrentTime = System.currentTimeMillis() / 1000;
    }

    public boolean cUD() {
        return this.kAm;
    }

    public void sB(boolean z) {
        this.kAm = z;
    }

    public boolean cUE() {
        return this.kAn;
    }

    public void sC(boolean z) {
        this.kAn = z;
    }

    public void CH(int i) {
        this.kAo = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cUC();
        return view;
    }

    /* loaded from: classes.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {
        private T kAp;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.kAp = t;
        }

        public T cUF() {
            return this.kAp;
        }
    }
}
