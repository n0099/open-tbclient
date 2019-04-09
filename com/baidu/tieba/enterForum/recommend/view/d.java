package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.recommend.b.e;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<e> {
    private View eGe;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eGe = getView().findViewById(d.g.card_recommend_list_placeholder);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.l(getView(), d.C0277d.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.recommend_forum_placeholder_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null) {
            ViewGroup.LayoutParams layoutParams = this.eGe.getLayoutParams();
            layoutParams.height = l.h(this.mContext, eVar.eED);
            this.eGe.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
