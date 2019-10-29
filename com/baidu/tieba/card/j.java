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
    private List<com.baidu.tieba.horizonalList.widget.c> bKP;
    private TbPageContext<?> cfl;
    private View.OnClickListener cmo;
    private com.baidu.tieba.horizonalList.widget.b eMf;
    private HListView eMo;
    public k eMp;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.cmo = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aZX() != null) {
                    j.this.aZX().a(view, null);
                }
            }
        };
        this.cfl = tbPageContext;
        this.eMo = new HListView(getContext());
        this.eMo.setHeaderDividersEnabled(false);
        this.eMo.setFooterDividersEnabled(false);
        this.eMo.setSelector(R.drawable.list_selector_transparent);
        this.eMo.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.eMp = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.eMf = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.eMp);
        this.eMf.setOnClickListener(this.cmo);
        this.eMo.setAdapter((ListAdapter) this.eMf);
        this.eKA.addView(this.eMo);
        this.eKz.setVisibility(8);
        this.eKt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.ds28));
        this.eKu.setVisibility(0);
        this.eKu.setText(this.cfl.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.eKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.cfl.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(j.this.cfl.getPageActivity())));
                }
            }
        });
        this.eMp.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eMo != null && this.eMf != null) {
            am.setViewTextColor(this.eKu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eKt, (int) R.color.cp_cont_d);
            this.eMf.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.isEmpty(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.eKt.setText(this.cfl.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bK(hVar.getDataList())) {
                this.bKP = hVar.getDataList();
                this.eMf.setData(this.bKP);
                this.eMf.notifyDataSetChanged();
            }
        }
    }

    private boolean bK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.bKP) && com.baidu.tbadk.core.util.v.getCount(this.bKP) == com.baidu.tbadk.core.util.v.getCount(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.getCount(this.bKP); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(this.bKP, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.ccm != null && !StringUtils.isNull(iVar.ccm.getUserId()) && iVar2.ccm != null && !StringUtils.isNull(iVar2.ccm.getUserId()) && !iVar.ccm.getUserId().equals(iVar2.ccm.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
