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
    private View.OnClickListener avW;
    private HListView bGH;
    private com.baidu.tieba.horizonalList.widget.c bGI;
    private d bGJ;
    private View bGK;
    private LikeModel bGL;
    private List<com.baidu.tieba.horizonalList.widget.d> bGM;
    private String bGN;
    private String bGO;
    private String bGP;
    private String bGQ;
    private String bGR;
    private CustomMessageListener bGS;
    private CustomMessageListener bGT;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGS = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bGT = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bGH = new HListView(getContext());
        this.bGH.setHeaderDividersEnabled(false);
        this.bGH.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bGK = this.mInflater.inflate(d.j.extend_forum_item, (ViewGroup) null);
        this.bGJ = new d(this.bGK);
        this.bGs.addView(this.bGH);
        this.bGH.setSelector(d.g.list_selector_transparent);
        this.bGH.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        WG();
        if (this.bGI == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bGI = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bGJ);
            this.bGI.setOnClickListener(this.avW);
            this.bGH.setAdapter((ListAdapter) this.bGI);
        }
        this.bGk.setOnClickListener(this);
        this.bGL = new LikeModel(tbPageContext);
        this.bGL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.o) || e.this.bGL.getErrorCode() != 0) {
                    if (AntiHelper.tx(e.this.bGL.getErrorCode())) {
                        AntiHelper.ar(e.this.getContext(), e.this.bGL.getErrorString());
                    } else {
                        e.this.Wz().showToast(e.this.bGL.getErrorString());
                    }
                }
            }
        });
        this.bGH.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bGS != null && this.bGT != null) {
            this.bGS.setTag(bdUniqueId);
            this.bGT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bGS);
            MessageManager.getInstance().registerListener(this.bGT);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bGH != null && this.bGI != null) {
            this.bGI.di(i);
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
        this.bGR = gVar.Xi();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bGM)) {
            boolean z = com.baidu.tbadk.core.util.u.u(gVar.getDataList()) != com.baidu.tbadk.core.util.u.u(this.bGM);
            this.bGM = gVar.getDataList();
            if (u <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bGI != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bGM.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bGI = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bGJ);
                    this.bGI.setData(this.bGM);
                    this.bGI.setOnClickListener(this.avW);
                    this.bGH.setAdapter((ListAdapter) this.bGI);
                    d(Wz(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bGI.setData(this.bGM);
                this.bGI.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jd(String str) {
        if (com.baidu.tbadk.core.util.u.u(this.bGM) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bGM) {
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
        com.baidu.tieba.card.data.e jd = jd(String.valueOf(j));
        if (jd != null) {
            jd.isLiked = z;
        }
        if (this.bGI != null) {
            this.bGI.setData(this.bGM);
            this.bGI.notifyDataSetChanged();
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

    private void WG() {
        this.avW = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.forum_add_love) {
                        if (aw.aO(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.h.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.h.tag_forum_id));
                            if (al.aO(str)) {
                                e.this.bGL.cf(str, valueOf);
                                TiebaStatic.log(new aj(e.this.bGO).aa("fid", valueOf).aa("obj_param3", m.WO()));
                            }
                        }
                    } else if (view.getTag(d.h.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.h.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.h.tag_forum_id));
                        if (al.aO(str2)) {
                            if (view.getId() == d.h.m_forum_name_textview) {
                                TiebaStatic.log(new aj(e.this.bGQ).aa("fid", valueOf2).aa("obj_param3", m.WO()));
                            } else {
                                TiebaStatic.log(new aj(e.this.bGP).aa("fid", valueOf2).aa("obj_param3", m.WO()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bGR)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bGR)));
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
        this.bGN = str;
        this.bGO = str2;
        this.bGP = str3;
        this.bGQ = str4;
    }
}
