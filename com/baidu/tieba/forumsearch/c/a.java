package com.baidu.tieba.forumsearch.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private final TextView bsw;
    private final ImageView dgD;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dgD = (ImageView) getView().findViewById(d.g.history_delete);
        this.bsw = (TextView) getView().findViewById(d.g.history_title);
        this.dgD.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.dgD, d.f.icon_search_history_del);
            al.h(this.bsw, d.C0141d.cp_cont_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.forum_search_history_header;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dgD) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            aVar.cb(d.k.confirm_delete_all_history);
            aVar.av(true);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    e.asH();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mTbPageContext);
            aVar.xa();
        }
    }
}
