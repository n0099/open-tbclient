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
    protected long gbC;
    private boolean gbD;
    private boolean gbE;
    protected int gbF;
    protected com.baidu.adp.lib.c.a gbv;
    protected b gbw;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbv = null;
        this.gbw = null;
        this.gbC = 0L;
        this.gbD = false;
        this.gbE = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gbv = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.gbw = bVar;
    }

    private void bqe() {
        this.gbC = System.currentTimeMillis() / 1000;
    }

    public boolean bqf() {
        return this.gbD;
    }

    public void kF(boolean z) {
        this.gbD = z;
    }

    public boolean bqg() {
        return this.gbE;
    }

    public void kG(boolean z) {
        this.gbE = z;
    }

    public void tz(int i) {
        this.gbF = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bqe();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gbG;

        public a(View view, T t) {
            super(view);
            this.gbG = t;
        }

        public T bqh() {
            return this.gbG;
        }
    }
}
