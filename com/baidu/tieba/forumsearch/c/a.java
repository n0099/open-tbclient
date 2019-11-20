package com.baidu.tieba.forumsearch.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private final TextView duZ;
    private final ImageView fth;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fth = (ImageView) getView().findViewById(R.id.history_delete);
        this.duZ = (TextView) getView().findViewById(R.id.history_title);
        this.fth.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fth, R.drawable.icon_search_history_del);
            am.setViewTextColor(this.duZ, (int) R.color.cp_cont_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.forum_search_history_header;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fth) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            aVar.hS(R.string.confirm_delete_all_history);
            aVar.eh(true);
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    e.biN();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.forumsearch.c.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mTbPageContext);
            aVar.akM();
        }
    }
}
