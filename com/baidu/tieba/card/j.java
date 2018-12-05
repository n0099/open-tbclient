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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private LikeModel aLl;
    private View.OnClickListener aSY;
    private String bna;
    private CustomMessageListener bnc;
    private CustomMessageListener bnd;
    private HListView cTX;
    private com.baidu.tieba.horizonalList.widget.b cTY;
    private d cTZ;
    private View cUa;
    private List<com.baidu.tieba.horizonalList.widget.c> cUb;
    private String cUc;
    private String cUd;
    private String cUe;
    private String cUf;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bnc = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bnd = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cTX = new HListView(getContext());
        this.cTX.setHeaderDividersEnabled(false);
        this.cTX.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cUa = this.mInflater.inflate(e.h.extend_forum_item, (ViewGroup) null);
        this.cTZ = new d(this.cUa);
        this.cSn.addView(this.cTX);
        this.cTX.setSelector(e.f.list_selector_transparent);
        this.cTX.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0);
        apj();
        if (this.cTY == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cTY = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cTZ);
            this.cTY.setOnClickListener(this.aSY);
            this.cTX.setAdapter((ListAdapter) this.cTY);
        }
        this.cSf.setOnClickListener(this);
        this.aLl = new LikeModel(tbPageContext);
        this.aLl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.aLl.getErrorCode() != 0) {
                    if (AntiHelper.ai(j.this.aLl.getErrorCode(), j.this.aLl.getErrorString())) {
                        AntiHelper.aJ(j.this.getContext(), j.this.aLl.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.aLl.getErrorString());
                    }
                }
            }
        });
        this.cTX.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bnc != null && this.bnd != null) {
            this.bnc.setTag(bdUniqueId);
            this.bnd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bnc);
            MessageManager.getInstance().registerListener(this.bnd);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cTX != null && this.cTY != null) {
            this.cTY.ej(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.H(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int H = com.baidu.tbadk.core.util.v.H(gVar.getDataList());
        if (H > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cUf = gVar.apW();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cUb)) {
            boolean z = com.baidu.tbadk.core.util.v.H(gVar.getDataList()) != com.baidu.tbadk.core.util.v.H(this.cUb);
            this.cUb = gVar.getDataList();
            if (H <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cTY != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cUb.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cTY = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cTZ);
                    this.cTY.setData(this.cUb);
                    this.cTY.setOnClickListener(this.aSY);
                    this.cTX.setAdapter((ListAdapter) this.cTY);
                    d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cTY.setData(this.cUb);
                this.cTY.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e mC(String str) {
        if (com.baidu.tbadk.core.util.v.H(this.cUb) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cUb) {
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
    public void c(long j, boolean z) {
        com.baidu.tieba.card.data.e mC = mC(String.valueOf(j));
        if (mC != null) {
            mC.isLiked = z;
        }
        if (this.cTY != null) {
            this.cTY.setData(this.cUb);
            this.cTY.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.H(list) <= 0 || com.baidu.tbadk.core.util.v.H(list2) <= 0 || com.baidu.tbadk.core.util.v.H(list) != com.baidu.tbadk.core.util.v.H(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.H(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list2, i);
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

    private void apj() {
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == e.g.forum_add_love) {
                        if (ba.bJ(j.this.getView().getContext())) {
                            String str = (String) view.getTag(e.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                            if (ao.bv(str)) {
                                j.this.aLl.cK(str, valueOf);
                                TiebaStatic.log(new am(j.this.bna).aA(ImageViewerConfig.FORUM_ID, valueOf).aA("obj_param3", o.apu()));
                            }
                        }
                    } else if (view.getTag(e.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(e.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(e.g.tag_forum_id));
                        if (ao.bv(str2)) {
                            if (view.getId() == e.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cUe).aA(ImageViewerConfig.FORUM_ID, valueOf2).aA("obj_param3", o.apu()));
                            } else {
                                TiebaStatic.log(new am(j.this.cUd).aA(ImageViewerConfig.FORUM_ID, valueOf2).aA("obj_param3", o.apu()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cUf)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cUf)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void k(String str, String str2, String str3, String str4) {
        this.cUc = str;
        this.bna = str2;
        this.cUd = str3;
        this.cUe = str4;
    }
}
