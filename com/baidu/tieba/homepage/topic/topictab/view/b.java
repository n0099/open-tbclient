package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.c;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<c> {
    private View iiO;
    private c jGj;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iiO = getView().findViewById(R.id.card_topic_list_placeholder);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_list_placeholder_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jGj = cVar;
            ap.setBackgroundColor(this.iiO, this.jGj.jFd);
            ViewGroup.LayoutParams layoutParams = this.iiO.getLayoutParams();
            layoutParams.height = l.getDimens(this.mContext, cVar.iho);
            this.iiO.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
