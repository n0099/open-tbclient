package com.baidu.tieba.frs.gamepaltform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class a extends h<com.baidu.tieba.h.b, b> implements c {
    private com.baidu.tieba.frs.e.a dtV;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dtV = new com.baidu.tieba.frs.e.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(f.h.game_rank_list_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.h.b bVar, b bVar2) {
        super.onFillViewHolder(i, view, viewGroup, bVar, bVar2);
        if (bVar == null) {
            return null;
        }
        am.j(view, f.d.cp_bg_line_d);
        if (this.dtV != null) {
            TiebaStatic.log(new an("c12104").ae(ImageViewerConfig.FORUM_ID, this.dtV.dEC));
        }
        if (bVar2.dyf != null) {
            bVar2.dyf.setData(bVar);
            bVar2.dyf.setOnCardClickListener(new GameRankHorizontalLayout.a() { // from class: com.baidu.tieba.frs.gamepaltform.a.1
                @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.a
                public void b(com.baidu.tieba.h.a aVar, int i2) {
                    if (aVar != null) {
                        if (a.this.dtV != null) {
                            TiebaStatic.log(new an("c12105").ae(ImageViewerConfig.FORUM_ID, a.this.dtV.dEC).r("obj_locate", i2 + 1));
                        }
                        if (!StringUtils.isNull(aVar.aCd())) {
                            com.baidu.tbadk.browser.a.Q(a.this.mPageContext.getPageActivity(), aVar.aCd());
                        }
                    }
                }
            });
        }
        if (bVar2.dyg != null) {
            bVar2.dyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("game_rank_list_info", System.currentTimeMillis() + ",7");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
                }
            });
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
