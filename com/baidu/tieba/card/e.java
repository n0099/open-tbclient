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
    private View.OnClickListener auH;
    private HListView bRn;
    private com.baidu.tieba.horizonalList.widget.c bRo;
    private d bRp;
    private View bRq;
    private LikeModel bRr;
    private List<com.baidu.tieba.horizonalList.widget.d> bRs;
    private String bRt;
    private String bRu;
    private String bRv;
    private String bRw;
    private String bRx;
    private CustomMessageListener bRy;
    private CustomMessageListener bRz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bRy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bRz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bRn = new HListView(getContext());
        this.bRn.setHeaderDividersEnabled(false);
        this.bRn.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bRq = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.bRp = new d(this.bRq);
        this.bQZ.addView(this.bRn);
        this.bRn.setSelector(d.f.list_selector_transparent);
        this.bRn.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        ZP();
        if (this.bRo == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bRo = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bRp);
            this.bRo.setOnClickListener(this.auH);
            this.bRn.setAdapter((ListAdapter) this.bRo);
        }
        this.bQR.setOnClickListener(this);
        this.bRr = new LikeModel(tbPageContext);
        this.bRr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.p) || e.this.bRr.getErrorCode() != 0) {
                    if (AntiHelper.ua(e.this.bRr.getErrorCode())) {
                        AntiHelper.ao(e.this.getContext(), e.this.bRr.getErrorString());
                    } else {
                        e.this.ZI().showToast(e.this.bRr.getErrorString());
                    }
                }
            }
        });
        this.bRn.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bRy != null && this.bRz != null) {
            this.bRy.setTag(bdUniqueId);
            this.bRz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bRy);
            MessageManager.getInstance().registerListener(this.bRz);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bRn != null && this.bRo != null) {
            this.bRo.di(i);
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
        this.bRx = gVar.aat();
        this.stType = gVar.getStType();
        if (!g(gVar.getDataList(), this.bRs)) {
            boolean z = com.baidu.tbadk.core.util.v.u(gVar.getDataList()) != com.baidu.tbadk.core.util.v.u(this.bRs);
            this.bRs = gVar.getDataList();
            if (u <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bRo != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bRs.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bRo = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bRp);
                    this.bRo.setData(this.bRs);
                    this.bRo.setOnClickListener(this.auH);
                    this.bRn.setAdapter((ListAdapter) this.bRo);
                    d(ZI(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bRo.setData(this.bRs);
                this.bRo.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jK(String str) {
        if (com.baidu.tbadk.core.util.v.u(this.bRs) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bRs) {
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
        com.baidu.tieba.card.data.e jK = jK(String.valueOf(j));
        if (jK != null) {
            jK.isLiked = z;
        }
        if (this.bRo != null) {
            this.bRo.setData(this.bRs);
            this.bRo.notifyDataSetChanged();
        }
    }

    private boolean g(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
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

    private void ZP() {
        this.auH = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ax.aT(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bRr.cb(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bRu).ac(ImageViewerConfig.FORUM_ID, valueOf).ac("obj_param3", m.ZY()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bRw).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", m.ZY()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bRv).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", m.ZY()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bRx)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bRx)));
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
        this.bRt = str;
        this.bRu = str2;
        this.bRv = str3;
        this.bRw = str4;
    }
}
