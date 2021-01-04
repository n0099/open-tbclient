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
    protected long gsJ;
    protected com.baidu.adp.lib.b.a kwD;
    protected com.baidu.adp.lib.b.b kwE;
    private boolean kwK;
    private boolean kwL;
    protected int kwM;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        return a(i, view, viewGroup, chatMessage, (MsgViewHolder) ((MsgViewHolder) viewHolder));
    }

    public MsgCommonItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kwD = null;
        this.kwE = null;
        this.gsJ = 0L;
        this.kwK = false;
        this.kwL = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kwD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kwE = bVar;
    }

    private void cWv() {
        this.gsJ = System.currentTimeMillis() / 1000;
    }

    public boolean cWw() {
        return this.kwK;
    }

    public void ss(boolean z) {
        this.kwK = z;
    }

    public boolean cWx() {
        return this.kwL;
    }

    public void st(boolean z) {
        this.kwL = z;
    }

    public void DW(int i) {
        this.kwM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cWv();
        return view;
    }

    /* loaded from: classes.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {
        private T kwN;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.kwN = t;
        }

        public T cWy() {
            return this.kwN;
        }
    }
}
