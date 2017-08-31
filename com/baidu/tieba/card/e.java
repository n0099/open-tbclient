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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener avj;
    private HListView bJC;
    private com.baidu.tieba.horizonalList.widget.c bJD;
    private d bJE;
    private View bJF;
    private LikeModel bJG;
    private List<com.baidu.tieba.horizonalList.widget.d> bJH;
    private String bJI;
    private String bJJ;
    private String bJK;
    private String bJL;
    private String bJM;
    private CustomMessageListener bJN;
    private CustomMessageListener bJO;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJN = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bJO = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bJC = new HListView(getContext());
        this.bJC.setHeaderDividersEnabled(false);
        this.bJC.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bJF = this.mInflater.inflate(d.j.extend_forum_item, (ViewGroup) null);
        this.bJE = new d(this.bJF);
        this.bJn.addView(this.bJC);
        this.bJC.setSelector(d.g.list_selector_transparent);
        this.bJC.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        XG();
        if (this.bJD == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bJD = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bJE);
            this.bJD.setOnClickListener(this.avj);
            this.bJC.setAdapter((ListAdapter) this.bJD);
        }
        this.bJf.setOnClickListener(this);
        this.bJG = new LikeModel(tbPageContext);
        this.bJG.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.o) || e.this.bJG.getErrorCode() != 0) {
                    if (AntiHelper.tz(e.this.bJG.getErrorCode())) {
                        AntiHelper.ar(e.this.getContext(), e.this.bJG.getErrorString());
                    } else {
                        e.this.Xz().showToast(e.this.bJG.getErrorString());
                    }
                }
            }
        });
        this.bJC.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bJN != null && this.bJO != null) {
            this.bJN.setTag(bdUniqueId);
            this.bJO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bJN);
            MessageManager.getInstance().registerListener(this.bJO);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bJC != null && this.bJD != null) {
            this.bJD.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.u(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int u = com.baidu.tbadk.core.util.v.u(gVar.getDataList());
        if (u > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bJM = gVar.Yi();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bJH)) {
            boolean z = com.baidu.tbadk.core.util.v.u(gVar.getDataList()) != com.baidu.tbadk.core.util.v.u(this.bJH);
            this.bJH = gVar.getDataList();
            if (u <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bJD != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bJH.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bJD = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bJE);
                    this.bJD.setData(this.bJH);
                    this.bJD.setOnClickListener(this.avj);
                    this.bJC.setAdapter((ListAdapter) this.bJD);
                    d(Xz(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bJD.setData(this.bJH);
                this.bJD.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jr(String str) {
        if (com.baidu.tbadk.core.util.v.u(this.bJH) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bJH) {
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
        com.baidu.tieba.card.data.e jr = jr(String.valueOf(j));
        if (jr != null) {
            jr.isLiked = z;
        }
        if (this.bJD != null) {
            this.bJD.setData(this.bJH);
            this.bJD.notifyDataSetChanged();
        }
    }

    private boolean f(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.u(list) <= 0 || com.baidu.tbadk.core.util.v.u(list2) <= 0 || com.baidu.tbadk.core.util.v.u(list) != com.baidu.tbadk.core.util.v.u(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.u(list)) {
            com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
            com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list2, i);
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

    private void XG() {
        this.avj = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.forum_add_love) {
                        if (ax.aT(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.h.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.h.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bJG.cg(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bJJ).ad("fid", valueOf).ad("obj_param3", m.XP()));
                            }
                        }
                    } else if (view.getTag(d.h.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.h.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.h.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.h.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bJL).ad("fid", valueOf2).ad("obj_param3", m.XP()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bJK).ad("fid", valueOf2).ad("obj_param3", m.XP()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bJM)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bJM)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void i(String str, String str2, String str3, String str4) {
        this.bJI = str;
        this.bJJ = str2;
        this.bJK = str3;
        this.bJL = str4;
    }
}
