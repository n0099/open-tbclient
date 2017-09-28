package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a dmR;
    protected b dmS;
    protected long dmY;
    private boolean dmZ;
    private boolean dna;
    protected int dnb;
    protected TbPageContext<MsglistActivity<?>> mG;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dmR = null;
        this.dmS = null;
        this.dmY = 0L;
        this.dmZ = false;
        this.dna = false;
        this.mG = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.dmR = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dmS = bVar;
    }

    private void asW() {
        this.dmY = System.currentTimeMillis() / 1000;
    }

    public boolean asX() {
        return this.dmZ;
    }

    public void fQ(boolean z) {
        this.dmZ = z;
    }

    public boolean asY() {
        return this.dna;
    }

    public void fR(boolean z) {
        this.dna = z;
    }

    public void mk(int i) {
        this.dnb = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        asW();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T dnc;

        public a(View view, T t) {
            super(view);
            this.dnc = t;
        }

        public T asZ() {
            return this.dnc;
        }
    }
}
