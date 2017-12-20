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
    private View.OnClickListener avn;
    private CustomMessageListener bZA;
    private CustomMessageListener bZB;
    private HListView bZp;
    private com.baidu.tieba.horizonalList.widget.c bZq;
    private d bZr;
    private View bZs;
    private LikeModel bZt;
    private List<com.baidu.tieba.horizonalList.widget.d> bZu;
    private String bZv;
    private String bZw;
    private String bZx;
    private String bZy;
    private String bZz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZA = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bZB = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bZp = new HListView(getContext());
        this.bZp.setHeaderDividersEnabled(false);
        this.bZp.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bZs = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.bZr = new d(this.bZs);
        this.bZb.addView(this.bZp);
        this.bZp.setSelector(d.f.list_selector_transparent);
        this.bZp.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        abz();
        if (this.bZq == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bZq = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bZr);
            this.bZq.setOnClickListener(this.avn);
            this.bZp.setAdapter((ListAdapter) this.bZq);
        }
        this.bYT.setOnClickListener(this);
        this.bZt = new LikeModel(tbPageContext);
        this.bZt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.q) || e.this.bZt.getErrorCode() != 0) {
                    if (AntiHelper.uB(e.this.bZt.getErrorCode())) {
                        AntiHelper.am(e.this.getContext(), e.this.bZt.getErrorString());
                    } else {
                        e.this.abs().showToast(e.this.bZt.getErrorString());
                    }
                }
            }
        });
        this.bZp.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bZA != null && this.bZB != null) {
            this.bZA.setTag(bdUniqueId);
            this.bZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZA);
            MessageManager.getInstance().registerListener(this.bZB);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bZp != null && this.bZq != null) {
            this.bZq.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.v(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int v = com.baidu.tbadk.core.util.v.v(gVar.getDataList());
        if (v > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bZz = gVar.acl();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.bZu)) {
            boolean z = com.baidu.tbadk.core.util.v.v(gVar.getDataList()) != com.baidu.tbadk.core.util.v.v(this.bZu);
            this.bZu = gVar.getDataList();
            if (v <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bZq != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bZu.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bZq = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bZr);
                    this.bZq.setData(this.bZu);
                    this.bZq.setOnClickListener(this.avn);
                    this.bZp.setAdapter((ListAdapter) this.bZq);
                    d(abs(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bZq.setData(this.bZu);
                this.bZq.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jN(String str) {
        if (com.baidu.tbadk.core.util.v.v(this.bZu) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bZu) {
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
        com.baidu.tieba.card.data.e jN = jN(String.valueOf(j));
        if (jN != null) {
            jN.isLiked = z;
        }
        if (this.bZq != null) {
            this.bZq.setData(this.bZu);
            this.bZq.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.v(list) <= 0 || com.baidu.tbadk.core.util.v.v(list2) <= 0 || com.baidu.tbadk.core.util.v.v(list) != com.baidu.tbadk.core.util.v.v(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.v(list)) {
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

    private void abz() {
        this.avn = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ax.aS(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bZt.ce(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bZw).ac(ImageViewerConfig.FORUM_ID, valueOf).ac("obj_param3", k.abJ()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bZy).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", k.abJ()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bZx).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", k.abJ()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bZz)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bZz)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void h(String str, String str2, String str3, String str4) {
        this.bZv = str;
        this.bZw = str2;
        this.bZx = str3;
        this.bZy = str4;
    }
}
