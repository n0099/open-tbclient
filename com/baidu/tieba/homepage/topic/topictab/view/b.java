package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topictab.b.c;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View eGv;
    private c fRf;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eGv = getView().findViewById(d.g.card_topic_list_placeholder);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.l(getView(), this.fRf.fQd);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_topic_list_placeholder_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fRf = cVar;
            ViewGroup.LayoutParams layoutParams = this.eGv.getLayoutParams();
            layoutParams.height = l.h(this.mContext, cVar.eEV);
            this.eGv.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
