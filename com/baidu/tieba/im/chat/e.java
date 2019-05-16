package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected long gsF;
    private boolean gsG;
    private boolean gsH;
    protected int gsI;
    protected com.baidu.adp.lib.c.a gsy;
    protected com.baidu.adp.lib.c.b gsz;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gsy = null;
        this.gsz = null;
        this.gsF = 0L;
        this.gsG = false;
        this.gsH = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.gsy = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsz = bVar;
    }

    private void bxM() {
        this.gsF = System.currentTimeMillis() / 1000;
    }

    public boolean bxN() {
        return this.gsG;
    }

    public void lu(boolean z) {
        this.gsG = z;
    }

    public boolean bxO() {
        return this.gsH;
    }

    public void lv(boolean z) {
        this.gsH = z;
    }

    public void uC(int i) {
        this.gsI = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        bxM();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends v.a {
        private T gsJ;

        public a(View view, T t) {
            super(view);
            this.gsJ = t;
        }

        public T bxP() {
            return this.gsJ;
        }
    }
}
