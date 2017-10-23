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
    private View.OnClickListener auc;
    private String bJA;
    private String bJB;
    private String bJC;
    private String bJD;
    private String bJE;
    private CustomMessageListener bJF;
    private CustomMessageListener bJG;
    private HListView bJu;
    private com.baidu.tieba.horizonalList.widget.c bJv;
    private d bJw;
    private View bJx;
    private LikeModel bJy;
    private List<com.baidu.tieba.horizonalList.widget.d> bJz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJF = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bJG = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bJu = new HListView(getContext());
        this.bJu.setHeaderDividersEnabled(false);
        this.bJu.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bJx = this.mInflater.inflate(d.j.extend_forum_item, (ViewGroup) null);
        this.bJw = new d(this.bJx);
        this.bJg.addView(this.bJu);
        this.bJu.setSelector(d.g.list_selector_transparent);
        this.bJu.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        Xt();
        if (this.bJv == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bJv = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bJw);
            this.bJv.setOnClickListener(this.auc);
            this.bJu.setAdapter((ListAdapter) this.bJv);
        }
        this.bIY.setOnClickListener(this);
        this.bJy = new LikeModel(tbPageContext);
        this.bJy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.o) || e.this.bJy.getErrorCode() != 0) {
                    if (AntiHelper.tF(e.this.bJy.getErrorCode())) {
                        AntiHelper.ao(e.this.getContext(), e.this.bJy.getErrorString());
                    } else {
                        e.this.Xm().showToast(e.this.bJy.getErrorString());
                    }
                }
            }
        });
        this.bJu.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bJF != null && this.bJG != null) {
            this.bJF.setTag(bdUniqueId);
            this.bJG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bJF);
            MessageManager.getInstance().registerListener(this.bJG);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bJu != null && this.bJv != null) {
            this.bJv.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.t(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int t = com.baidu.tbadk.core.util.v.t(gVar.getDataList());
        if (t > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bJE = gVar.XX();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bJz)) {
            boolean z = com.baidu.tbadk.core.util.v.t(gVar.getDataList()) != com.baidu.tbadk.core.util.v.t(this.bJz);
            this.bJz = gVar.getDataList();
            if (t <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bJv != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bJz.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bJv = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bJw);
                    this.bJv.setData(this.bJz);
                    this.bJv.setOnClickListener(this.auc);
                    this.bJu.setAdapter((ListAdapter) this.bJv);
                    d(Xm(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bJv.setData(this.bJz);
                this.bJv.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jk(String str) {
        if (com.baidu.tbadk.core.util.v.t(this.bJz) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bJz) {
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
        com.baidu.tieba.card.data.e jk = jk(String.valueOf(j));
        if (jk != null) {
            jk.isLiked = z;
        }
        if (this.bJv != null) {
            this.bJv.setData(this.bJz);
            this.bJv.notifyDataSetChanged();
        }
    }

    private boolean f(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.t(list) <= 0 || com.baidu.tbadk.core.util.v.t(list2) <= 0 || com.baidu.tbadk.core.util.v.t(list) != com.baidu.tbadk.core.util.v.t(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.t(list)) {
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

    private void Xt() {
        this.auc = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.forum_add_love) {
                        if (ax.aT(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.h.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.h.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bJy.ca(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bJB).ac("fid", valueOf).ac("obj_param3", m.XC()));
                            }
                        }
                    } else if (view.getTag(d.h.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.h.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.h.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.h.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bJD).ac("fid", valueOf2).ac("obj_param3", m.XC()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bJC).ac("fid", valueOf2).ac("obj_param3", m.XC()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bJE)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bJE)));
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
        this.bJA = str;
        this.bJB = str2;
        this.bJC = str3;
        this.bJD = str4;
    }
}
