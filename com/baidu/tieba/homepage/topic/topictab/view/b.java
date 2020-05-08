package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.c;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View gGi;
    private c hUu;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gGi = getView().findViewById(R.id.card_topic_list_placeholder);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_list_placeholder_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.hUu = cVar;
            am.setBackgroundColor(this.gGi, this.hUu.hTn);
            ViewGroup.LayoutParams layoutParams = this.gGi.getLayoutParams();
            layoutParams.height = l.getDimens(this.mContext, cVar.gEI);
            this.gGi.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
