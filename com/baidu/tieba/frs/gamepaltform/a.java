package com.baidu.tieba.frs.gamepaltform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class a extends k<com.baidu.tieba.h.b, b> implements d {
    private com.baidu.tieba.frs.d.b iyS;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iyS = new com.baidu.tieba.frs.d.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.game_rank_list_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.h.b bVar, b bVar2) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tieba.h.b) bVar2);
        if (bVar == null) {
            return null;
        }
        ap.setBackgroundColor(view, R.color.cp_bg_line_d);
        if (this.iyS != null) {
            TiebaStatic.log(new aq("c12104").dK("fid", this.iyS.iNk));
        }
        if (bVar2.iEO != null) {
            bVar2.iEO.setData(bVar);
            bVar2.iEO.setOnCardClickListener(new GameRankHorizontalLayout.a() { // from class: com.baidu.tieba.frs.gamepaltform.a.1
                @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.a
                public void b(com.baidu.tieba.h.a aVar, int i2) {
                    if (aVar != null) {
                        if (a.this.iyS != null) {
                            TiebaStatic.log(new aq("c12105").dK("fid", a.this.iyS.iNk).aj("obj_locate", i2 + 1));
                        }
                        if (!StringUtils.isNull(aVar.cBL())) {
                            com.baidu.tbadk.browser.a.startWebActivity(a.this.mPageContext.getPageActivity(), aVar.cBL());
                        }
                    }
                }
            });
        }
        if (bVar2.iEP != null) {
            bVar2.iEP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.GAME_RANK_LIST_INFO, System.currentTimeMillis() + ",7");
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD));
                }
            });
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iyS;
    }
}
