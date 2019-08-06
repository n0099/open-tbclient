package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends b<com.baidu.tieba.card.data.g> {
    private String cIe;
    private CustomMessageListener cIg;
    private CustomMessageListener cIh;
    private LikeModel cdy;
    private View.OnClickListener cmb;
    private HListView eBO;
    private com.baidu.tieba.horizonalList.widget.b eBP;
    private c eBQ;
    private View eBR;
    private List<com.baidu.tieba.horizonalList.widget.c> eBS;
    private String eBT;
    private String eBU;
    private String eBV;
    private String eBW;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cIg = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cIh = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eBO = new HListView(getContext());
        this.eBO.setHeaderDividersEnabled(false);
        this.eBO.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.eBR = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.eBQ = new c(this.eBR);
        this.eAj.addView(this.eBO);
        this.eBO.setSelector(R.drawable.list_selector_transparent);
        this.eBO.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        aZs();
        if (this.eBP == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.eBP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eBQ);
            this.eBP.setOnClickListener(this.cmb);
            this.eBO.setAdapter((ListAdapter) this.eBP);
        }
        this.eAb.setOnClickListener(this);
        this.cdy = new LikeModel(tbPageContext);
        this.cdy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.cdy.getErrorCode() != 0) {
                    if (AntiHelper.aG(i.this.cdy.getErrorCode(), i.this.cdy.getErrorString())) {
                        AntiHelper.aJ(i.this.getContext(), i.this.cdy.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.cdy.getErrorString());
                    }
                }
            }
        });
        this.eBO.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.cIg != null && this.cIh != null) {
            this.cIg.setTag(bdUniqueId);
            this.cIh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIg);
            MessageManager.getInstance().registerListener(this.cIh);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eBO != null && this.eBP != null) {
            this.eBP.iG(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((i) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.Z(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(gVar.getDataList());
        if (Z > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.eBW = gVar.bai();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.eBS)) {
            boolean z = com.baidu.tbadk.core.util.v.Z(gVar.getDataList()) != com.baidu.tbadk.core.util.v.Z(this.eBS);
            this.eBS = gVar.getDataList();
            if (Z <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.eBP != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.eBS.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.eBP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eBQ);
                    this.eBP.setData(this.eBS);
                    this.eBP.setOnClickListener(this.cmb);
                    this.eBO.setAdapter((ListAdapter) this.eBP);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eBP.setData(this.eBS);
                this.eBP.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e vw(String str) {
        if (com.baidu.tbadk.core.util.v.Z(this.eBS) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.eBS) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) cVar;
                    if (String.valueOf(eVar.forumId).equals(str)) {
                        return eVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        com.baidu.tieba.card.data.e vw = vw(String.valueOf(j));
        if (vw != null) {
            vw.isLiked = z;
        }
        if (this.eBP != null) {
            this.eBP.setData(this.eBS);
            this.eBP.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.Z(list) <= 0 || com.baidu.tbadk.core.util.v.Z(list2) <= 0 || com.baidu.tbadk.core.util.v.Z(list) != com.baidu.tbadk.core.util.v.Z(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.Z(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list2, i);
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.e) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) cVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) cVar2;
                if (eVar.forumId != eVar2.forumId) {
                    z2 = false;
                }
                if (!eVar.forumAvatar.equals(eVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!eVar.forumName.equals(eVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void aZs() {
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bd.cF(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.bg(str)) {
                                i.this.cdy.el(str, valueOf);
                                TiebaStatic.log(new an(i.this.cIe).bT("fid", valueOf).bT("obj_param3", n.aZG()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.bg(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.eBV).bT("fid", valueOf2).bT("obj_param3", n.aZG()));
                            } else {
                                TiebaStatic.log(new an(i.this.eBU).bT("fid", valueOf2).bT("obj_param3", n.aZG()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.eBW)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.eBW)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void o(String str, String str2, String str3, String str4) {
        this.eBT = str;
        this.cIe = str2;
        this.eBU = str3;
        this.eBV = str4;
    }
}
