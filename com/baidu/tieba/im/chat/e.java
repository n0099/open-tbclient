package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long gbB;
    private boolean gbC;
    private boolean gbD;
    protected int gbE;
    protected com.baidu.adp.lib.c.a gbu;
    protected b gbv;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbu = null;
        this.gbv = null;
        this.gbB = 0L;
        this.gbC = false;
        this.gbD = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbu = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.gbv = bVar;
    }

    private void bqd() {
        this.gbB = System.currentTimeMillis() / 1000;
    }

    public boolean bqe() {
        return this.gbC;
    }

    public void kF(boolean z) {
        this.gbC = z;
    }

    public boolean bqf() {
        return this.gbD;
    }

    public void kG(boolean z) {
        this.gbD = z;
    }

    public void tz(int i) {
        this.gbE = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bqd();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gbF;

        public a(View view, T t) {
            super(view);
            this.gbF = t;
        }

        public T bqg() {
            return this.gbF;
        }
    }
}
