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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private View.OnClickListener bjG;
    private com.baidu.tieba.horizonalList.widget.c cSA;
    private d cSB;
    private View cSC;
    private LikeModel cSD;
    private List<com.baidu.tieba.horizonalList.widget.d> cSE;
    private String cSF;
    private String cSG;
    private String cSH;
    private String cSI;
    private String cSJ;
    private CustomMessageListener cSK;
    private CustomMessageListener cSL;
    private HListView cSz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cSK = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cSL = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cSz = new HListView(getContext());
        this.cSz.setHeaderDividersEnabled(false);
        this.cSz.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cSC = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.cSB = new d(this.cSC);
        this.cSm.addView(this.cSz);
        this.cSz.setSelector(d.f.list_selector_transparent);
        this.cSz.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        akh();
        if (this.cSA == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cSA = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cSB);
            this.cSA.setOnClickListener(this.bjG);
            this.cSz.setAdapter((ListAdapter) this.cSA);
        }
        this.cSe.setOnClickListener(this);
        this.cSD = new LikeModel(tbPageContext);
        this.cSD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || e.this.cSD.getErrorCode() != 0) {
                    if (AntiHelper.vQ(e.this.cSD.getErrorCode())) {
                        AntiHelper.ao(e.this.getContext(), e.this.cSD.getErrorString());
                    } else {
                        e.this.aka().showToast(e.this.cSD.getErrorString());
                    }
                }
            }
        });
        this.cSz.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cSK != null && this.cSL != null) {
            this.cSK.setTag(bdUniqueId);
            this.cSL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cSK);
            MessageManager.getInstance().registerListener(this.cSL);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cSz != null && this.cSA != null) {
            this.cSA.gg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.D(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int D = com.baidu.tbadk.core.util.v.D(gVar.getDataList());
        if (D > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cSJ = gVar.akU();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cSE)) {
            boolean z = com.baidu.tbadk.core.util.v.D(gVar.getDataList()) != com.baidu.tbadk.core.util.v.D(this.cSE);
            this.cSE = gVar.getDataList();
            if (D <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cSA != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cSE.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cSA = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cSB);
                    this.cSA.setData(this.cSE);
                    this.cSA.setOnClickListener(this.bjG);
                    this.cSz.setAdapter((ListAdapter) this.cSA);
                    d(aka(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cSA.setData(this.cSE);
                this.cSA.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kb(String str) {
        if (com.baidu.tbadk.core.util.v.D(this.cSE) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.cSE) {
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
    public void b(long j, boolean z) {
        com.baidu.tieba.card.data.e kb = kb(String.valueOf(j));
        if (kb != null) {
            kb.isLiked = z;
        }
        if (this.cSA != null) {
            this.cSA.setData(this.cSE);
            this.cSA.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.D(list) <= 0 || com.baidu.tbadk.core.util.v.D(list2) <= 0 || com.baidu.tbadk.core.util.v.D(list) != com.baidu.tbadk.core.util.v.D(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.D(list)) {
            com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
            com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list2, i);
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

    private void akh() {
        this.bjG = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ax.be(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aT(str)) {
                                e.this.cSD.cb(str, valueOf);
                                TiebaStatic.log(new ak(e.this.cSG).ab(ImageViewerConfig.FORUM_ID, valueOf).ab("obj_param3", k.aks()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aT(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.cSI).ab(ImageViewerConfig.FORUM_ID, valueOf2).ab("obj_param3", k.aks()));
                            } else {
                                TiebaStatic.log(new ak(e.this.cSH).ab(ImageViewerConfig.FORUM_ID, valueOf2).ab("obj_param3", k.aks()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.cSJ)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.cSJ)));
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
        this.cSF = str;
        this.cSG = str2;
        this.cSH = str3;
        this.cSI = str4;
    }
}
