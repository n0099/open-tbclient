package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends b<com.baidu.tieba.card.data.h> {
    private List<com.baidu.tieba.horizonalList.widget.c> bJY;
    private TbPageContext<?> ceu;
    private View.OnClickListener clw;
    private com.baidu.tieba.horizonalList.widget.b eLo;
    private HListView eLx;
    public k eLy;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.clw = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aZV() != null) {
                    j.this.aZV().a(view, null);
                }
            }
        };
        this.ceu = tbPageContext;
        this.eLx = new HListView(getContext());
        this.eLx.setHeaderDividersEnabled(false);
        this.eLx.setFooterDividersEnabled(false);
        this.eLx.setSelector(R.drawable.list_selector_transparent);
        this.eLx.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.eLy = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.eLo = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.eLy);
        this.eLo.setOnClickListener(this.clw);
        this.eLx.setAdapter((ListAdapter) this.eLo);
        this.eJJ.addView(this.eLx);
        this.eJI.setVisibility(8);
        this.eJC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.ds28));
        this.eJD.setVisibility(0);
        this.eJD.setText(this.ceu.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.eJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.ceu.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(j.this.ceu.getPageActivity())));
                }
            }
        });
        this.eLy.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eLx != null && this.eLo != null) {
            am.setViewTextColor(this.eJD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eJC, (int) R.color.cp_cont_d);
            this.eLo.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.isEmpty(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.eJC.setText(this.ceu.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bK(hVar.getDataList())) {
                this.bJY = hVar.getDataList();
                this.eLo.setData(this.bJY);
                this.eLo.notifyDataSetChanged();
            }
        }
    }

    private boolean bK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.bJY) && com.baidu.tbadk.core.util.v.getCount(this.bJY) == com.baidu.tbadk.core.util.v.getCount(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.getCount(this.bJY); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(this.bJY, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.cbv != null && !StringUtils.isNull(iVar.cbv.getUserId()) && iVar2.cbv != null && !StringUtils.isNull(iVar2.cbv.getUserId()) && !iVar.cbv.getUserId().equals(iVar2.cbv.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
