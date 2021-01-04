package com.baidu.tieba.homepage.personalize.readProgressBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class ReadProgessDelegetAdapter extends com.baidu.adp.widget.ListView.a<b, ViewHolder> {
    private w kiu;
    private final TbPageContext<?> mPageContext;

    public ReadProgessDelegetAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kiu = new w() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                TiebaStatic.log(new aq("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            }
        };
        this.mPageContext = tbPageContext;
        a(this.kiu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bX */
    public ViewHolder e(ViewGroup viewGroup) {
        return new ViewHolder(new a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, ViewHolder viewHolder) {
        s.cva().e(new aq("c11272"));
        viewHolder.kiw.a(bVar);
        return viewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public a kiw;

        public ViewHolder(a aVar) {
            super(aVar.getView());
            this.kiw = aVar;
        }
    }
}
