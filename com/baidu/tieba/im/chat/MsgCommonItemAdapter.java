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
    protected long goc;
    protected com.baidu.adp.lib.b.a krY;
    protected com.baidu.adp.lib.b.b krZ;
    private boolean ksf;
    private boolean ksg;
    protected int ksh;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        return a(i, view, viewGroup, chatMessage, (MsgViewHolder) ((MsgViewHolder) viewHolder));
    }

    public MsgCommonItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.krY = null;
        this.krZ = null;
        this.goc = 0L;
        this.ksf = false;
        this.ksg = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.krY = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.krZ = bVar;
    }

    private void cSE() {
        this.goc = System.currentTimeMillis() / 1000;
    }

    public boolean cSF() {
        return this.ksf;
    }

    public void so(boolean z) {
        this.ksf = z;
    }

    public boolean cSG() {
        return this.ksg;
    }

    public void sp(boolean z) {
        this.ksg = z;
    }

    public void Cp(int i) {
        this.ksh = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgViewHolder<T> msgViewHolder) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        cSE();
        return view;
    }

    /* loaded from: classes.dex */
    public static class MsgViewHolder<T> extends TypeAdapter.ViewHolder {
        private T ksi;

        public MsgViewHolder(View view, T t) {
            super(view);
            this.ksi = t;
        }

        public T cSH() {
            return this.ksi;
        }
    }
}
