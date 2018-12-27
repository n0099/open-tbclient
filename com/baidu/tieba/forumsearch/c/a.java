package com.baidu.tieba.forumsearch.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private final TextView bNG;
    private final ImageView dJG;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dJG = (ImageView) getView().findViewById(e.g.history_delete);
        this.bNG = (TextView) getView().findViewById(e.g.history_title);
        this.dJG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.dJG, e.f.icon_search_history_del);
            al.h(this.bNG, e.d.cp_cont_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.forum_search_history_header;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dJG) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            aVar.da(e.j.confirm_delete_all_history);
            aVar.bg(true);
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.forumsearch.controller.e.aAC();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mTbPageContext);
            aVar.BF();
        }
    }
}
