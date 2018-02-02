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
    private View.OnClickListener bjO;
    private HListView cSU;
    private com.baidu.tieba.horizonalList.widget.c cSV;
    private d cSW;
    private View cSX;
    private LikeModel cSY;
    private List<com.baidu.tieba.horizonalList.widget.d> cSZ;
    private String cTa;
    private String cTb;
    private String cTc;
    private String cTd;
    private String cTe;
    private CustomMessageListener cTf;
    private CustomMessageListener cTg;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cTf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cTg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cSU = new HListView(getContext());
        this.cSU.setHeaderDividersEnabled(false);
        this.cSU.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cSX = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.cSW = new d(this.cSX);
        this.cSH.addView(this.cSU);
        this.cSU.setSelector(d.f.list_selector_transparent);
        this.cSU.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        akm();
        if (this.cSV == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cSV = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cSW);
            this.cSV.setOnClickListener(this.bjO);
            this.cSU.setAdapter((ListAdapter) this.cSV);
        }
        this.cSz.setOnClickListener(this);
        this.cSY = new LikeModel(tbPageContext);
        this.cSY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || e.this.cSY.getErrorCode() != 0) {
                    if (AntiHelper.vQ(e.this.cSY.getErrorCode())) {
                        AntiHelper.an(e.this.getContext(), e.this.cSY.getErrorString());
                    } else {
                        e.this.akf().showToast(e.this.cSY.getErrorString());
                    }
                }
            }
        });
        this.cSU.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cTf != null && this.cTg != null) {
            this.cTf.setTag(bdUniqueId);
            this.cTg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTf);
            MessageManager.getInstance().registerListener(this.cTg);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cSU != null && this.cSV != null) {
            this.cSV.gg(i);
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
        this.cTe = gVar.akZ();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cSZ)) {
            boolean z = com.baidu.tbadk.core.util.v.D(gVar.getDataList()) != com.baidu.tbadk.core.util.v.D(this.cSZ);
            this.cSZ = gVar.getDataList();
            if (D <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cSV != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cSZ.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cSV = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cSW);
                    this.cSV.setData(this.cSZ);
                    this.cSV.setOnClickListener(this.bjO);
                    this.cSU.setAdapter((ListAdapter) this.cSV);
                    d(akf(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cSV.setData(this.cSZ);
                this.cSV.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kj(String str) {
        if (com.baidu.tbadk.core.util.v.D(this.cSZ) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.cSZ) {
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
        com.baidu.tieba.card.data.e kj = kj(String.valueOf(j));
        if (kj != null) {
            kj.isLiked = z;
        }
        if (this.cSV != null) {
            this.cSV.setData(this.cSZ);
            this.cSV.notifyDataSetChanged();
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

    private void akm() {
        this.bjO = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ax.bb(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aT(str)) {
                                e.this.cSY.ca(str, valueOf);
                                TiebaStatic.log(new ak(e.this.cTb).aa(ImageViewerConfig.FORUM_ID, valueOf).aa("obj_param3", k.akx()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aT(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.cTd).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", k.akx()));
                            } else {
                                TiebaStatic.log(new ak(e.this.cTc).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", k.akx()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.cTe)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.cTe)));
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
        this.cTa = str;
        this.cTb = str2;
        this.cTc = str3;
        this.cTd = str4;
    }
}
