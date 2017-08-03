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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener auE;
    private HListView bEO;
    private com.baidu.tieba.horizonalList.widget.c bEP;
    private d bEQ;
    private View bER;
    private LikeModel bES;
    private List<com.baidu.tieba.horizonalList.widget.d> bET;
    private String bEU;
    private String bEV;
    private String bEW;
    private String bEX;
    private String bEY;
    private CustomMessageListener bEZ;
    private CustomMessageListener bFa;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEZ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bFa = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bEO = new HListView(getContext());
        this.bEO.setHeaderDividersEnabled(false);
        this.bEO.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bER = this.mInflater.inflate(d.j.extend_forum_item, (ViewGroup) null);
        this.bEQ = new d(this.bER);
        this.bEz.addView(this.bEO);
        this.bEO.setSelector(d.g.list_selector_transparent);
        this.bEO.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        Wf();
        if (this.bEP == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bEP = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bEQ);
            this.bEP.setOnClickListener(this.auE);
            this.bEO.setAdapter((ListAdapter) this.bEP);
        }
        this.bEr.setOnClickListener(this);
        this.bES = new LikeModel(tbPageContext);
        this.bES.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.o) || e.this.bES.getErrorCode() != 0) {
                    if (AntiHelper.tn(e.this.bES.getErrorCode())) {
                        AntiHelper.ar(e.this.getContext(), e.this.bES.getErrorString());
                    } else {
                        e.this.VY().showToast(e.this.bES.getErrorString());
                    }
                }
            }
        });
        this.bEO.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bEZ != null && this.bFa != null) {
            this.bEZ.setTag(bdUniqueId);
            this.bFa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bEZ);
            MessageManager.getInstance().registerListener(this.bFa);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bEO != null && this.bEP != null) {
            this.bEP.dg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.u.u(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int u = com.baidu.tbadk.core.util.u.u(gVar.getDataList());
        if (u > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bEY = gVar.WH();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bET)) {
            boolean z = com.baidu.tbadk.core.util.u.u(gVar.getDataList()) != com.baidu.tbadk.core.util.u.u(this.bET);
            this.bET = gVar.getDataList();
            if (u <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bEP != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bET.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bEP = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bEQ);
                    this.bEP.setData(this.bET);
                    this.bEP.setOnClickListener(this.auE);
                    this.bEO.setAdapter((ListAdapter) this.bEP);
                    d(VY(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bEP.setData(this.bET);
                this.bEP.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e iX(String str) {
        if (com.baidu.tbadk.core.util.u.u(this.bET) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bET) {
                if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) dVar;
                    if (String.valueOf(eVar.forumId).equals(str)) {
                        return eVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        com.baidu.tieba.card.data.e iX = iX(String.valueOf(j));
        if (iX != null) {
            iX.isLiked = z;
        }
        if (this.bEP != null) {
            this.bEP.setData(this.bET);
            this.bEP.notifyDataSetChanged();
        }
    }

    private boolean f(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.u.u(list) <= 0 || com.baidu.tbadk.core.util.u.u(list2) <= 0 || com.baidu.tbadk.core.util.u.u(list) != com.baidu.tbadk.core.util.u.u(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.u.u(list)) {
            com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.u.c(list, i);
            com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.u.c(list2, i);
            if (dVar == null || !(dVar instanceof com.baidu.tieba.card.data.e) || dVar2 == null || !(dVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) dVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) dVar2;
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

    private void Wf() {
        this.auE = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.forum_add_love) {
                        if (aw.aN(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.h.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.h.tag_forum_id));
                            if (al.aI(str)) {
                                e.this.bES.ce(str, valueOf);
                                TiebaStatic.log(new aj(e.this.bEV).aa("fid", valueOf).aa("obj_param3", m.Wn()));
                            }
                        }
                    } else if (view.getTag(d.h.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.h.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.h.tag_forum_id));
                        if (al.aI(str2)) {
                            if (view.getId() == d.h.m_forum_name_textview) {
                                TiebaStatic.log(new aj(e.this.bEX).aa("fid", valueOf2).aa("obj_param3", m.Wn()));
                            } else {
                                TiebaStatic.log(new aj(e.this.bEW).aa("fid", valueOf2).aa("obj_param3", m.Wn()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bEY)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bEY)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void k(String str, String str2, String str3, String str4) {
        this.bEU = str;
        this.bEV = str2;
        this.bEW = str3;
        this.bEX = str4;
    }
}
