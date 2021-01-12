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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.b.d;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.i.b;
/* loaded from: classes2.dex */
public class a extends k<b, GameRankListViewHolder> implements d {
    private com.baidu.tieba.frs.b.b jkJ;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jkJ = new com.baidu.tieba.frs.b.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public GameRankListViewHolder e(ViewGroup viewGroup) {
        return new GameRankListViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.game_rank_list_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, GameRankListViewHolder gameRankListViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) gameRankListViewHolder);
        if (bVar == null) {
            return null;
        }
        ao.setBackgroundColor(view, R.color.CAM_X0201);
        if (this.jkJ != null) {
            TiebaStatic.log(new aq("c12104").dW("fid", this.jkJ.jBI));
        }
        if (gameRankListViewHolder.jtn != null) {
            gameRankListViewHolder.jtn.setData(bVar);
            gameRankListViewHolder.jtn.setOnCardClickListener(new GameRankHorizontalLayout.a() { // from class: com.baidu.tieba.frs.gamepaltform.a.1
                @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.a
                public void b(com.baidu.tieba.i.a aVar, int i2) {
                    if (aVar != null) {
                        if (a.this.jkJ != null) {
                            TiebaStatic.log(new aq("c12105").dW("fid", a.this.jkJ.jBI).an("obj_locate", i2 + 1));
                        }
                        if (!StringUtils.isNull(aVar.cLJ())) {
                            com.baidu.tbadk.browser.a.startWebActivity(a.this.mPageContext.getPageActivity(), aVar.cLJ());
                        }
                    }
                }
            });
        }
        if (gameRankListViewHolder.jto != null) {
            gameRankListViewHolder.jto.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.GAME_RANK_LIST_INFO, System.currentTimeMillis() + ",7");
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD));
                }
            });
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }
}
