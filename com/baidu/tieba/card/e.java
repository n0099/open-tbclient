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
    private View.OnClickListener avg;
    private String bKA;
    private String bKB;
    private String bKC;
    private String bKD;
    private CustomMessageListener bKE;
    private CustomMessageListener bKF;
    private HListView bKt;
    private com.baidu.tieba.horizonalList.widget.c bKu;
    private d bKv;
    private View bKw;
    private LikeModel bKx;
    private List<com.baidu.tieba.horizonalList.widget.d> bKy;
    private String bKz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKE = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bKF = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bKt = new HListView(getContext());
        this.bKt.setHeaderDividersEnabled(false);
        this.bKt.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bKw = this.mInflater.inflate(d.j.extend_forum_item, (ViewGroup) null);
        this.bKv = new d(this.bKw);
        this.bKe.addView(this.bKt);
        this.bKt.setSelector(d.g.list_selector_transparent);
        this.bKt.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        XR();
        if (this.bKu == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bKu = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bKv);
            this.bKu.setOnClickListener(this.avg);
            this.bKt.setAdapter((ListAdapter) this.bKu);
        }
        this.bJW.setOnClickListener(this);
        this.bKx = new LikeModel(tbPageContext);
        this.bKx.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.o) || e.this.bKx.getErrorCode() != 0) {
                    if (AntiHelper.tB(e.this.bKx.getErrorCode())) {
                        AntiHelper.ar(e.this.getContext(), e.this.bKx.getErrorString());
                    } else {
                        e.this.XK().showToast(e.this.bKx.getErrorString());
                    }
                }
            }
        });
        this.bKt.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bKE != null && this.bKF != null) {
            this.bKE.setTag(bdUniqueId);
            this.bKF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKE);
            MessageManager.getInstance().registerListener(this.bKF);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bKt != null && this.bKu != null) {
            this.bKu.dj(i);
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
        this.bKD = gVar.Yt();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bKy)) {
            boolean z = com.baidu.tbadk.core.util.v.u(gVar.getDataList()) != com.baidu.tbadk.core.util.v.u(this.bKy);
            this.bKy = gVar.getDataList();
            if (u <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bKu != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bKy.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bKu = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.extend_forum_item, this.bKv);
                    this.bKu.setData(this.bKy);
                    this.bKu.setOnClickListener(this.avg);
                    this.bKt.setAdapter((ListAdapter) this.bKu);
                    d(XK(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bKu.setData(this.bKy);
                this.bKu.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jt(String str) {
        if (com.baidu.tbadk.core.util.v.u(this.bKy) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bKy) {
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
        com.baidu.tieba.card.data.e jt = jt(String.valueOf(j));
        if (jt != null) {
            jt.isLiked = z;
        }
        if (this.bKu != null) {
            this.bKu.setData(this.bKy);
            this.bKu.notifyDataSetChanged();
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

    private void XR() {
        this.avg = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.forum_add_love) {
                        if (ax.aU(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.h.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.h.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bKx.cg(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bKA).ad("fid", valueOf).ad("obj_param3", m.Ya()));
                            }
                        }
                    } else if (view.getTag(d.h.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.h.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.h.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.h.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bKC).ad("fid", valueOf2).ad("obj_param3", m.Ya()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bKB).ad("fid", valueOf2).ad("obj_param3", m.Ya()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bKD)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bKD)));
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
        this.bKz = str;
        this.bKA = str2;
        this.bKB = str3;
        this.bKC = str4;
    }
}
