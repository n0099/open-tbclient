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
    private View.OnClickListener avi;
    private HListView bZl;
    private com.baidu.tieba.horizonalList.widget.c bZm;
    private d bZn;
    private View bZo;
    private LikeModel bZp;
    private List<com.baidu.tieba.horizonalList.widget.d> bZq;
    private String bZr;
    private String bZs;
    private String bZt;
    private String bZu;
    private String bZv;
    private CustomMessageListener bZw;
    private CustomMessageListener bZx;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bZx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bZl = new HListView(getContext());
        this.bZl.setHeaderDividersEnabled(false);
        this.bZl.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bZo = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.bZn = new d(this.bZo);
        this.bYX.addView(this.bZl);
        this.bZl.setSelector(d.f.list_selector_transparent);
        this.bZl.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aby();
        if (this.bZm == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bZm = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bZn);
            this.bZm.setOnClickListener(this.avi);
            this.bZl.setAdapter((ListAdapter) this.bZm);
        }
        this.bYP.setOnClickListener(this);
        this.bZp = new LikeModel(tbPageContext);
        this.bZp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.q) || e.this.bZp.getErrorCode() != 0) {
                    if (AntiHelper.uq(e.this.bZp.getErrorCode())) {
                        AntiHelper.an(e.this.getContext(), e.this.bZp.getErrorString());
                    } else {
                        e.this.abr().showToast(e.this.bZp.getErrorString());
                    }
                }
            }
        });
        this.bZl.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bZw != null && this.bZx != null) {
            this.bZw.setTag(bdUniqueId);
            this.bZx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZw);
            MessageManager.getInstance().registerListener(this.bZx);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bZl != null && this.bZm != null) {
            this.bZm.dj(i);
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
        this.bZv = gVar.acc();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.bZq)) {
            boolean z = com.baidu.tbadk.core.util.v.v(gVar.getDataList()) != com.baidu.tbadk.core.util.v.v(this.bZq);
            this.bZq = gVar.getDataList();
            if (v <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bZm != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bZq.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bZm = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.bZn);
                    this.bZm.setData(this.bZq);
                    this.bZm.setOnClickListener(this.avi);
                    this.bZl.setAdapter((ListAdapter) this.bZm);
                    d(abr(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.bZm.setData(this.bZq);
                this.bZm.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e jP(String str) {
        if (com.baidu.tbadk.core.util.v.v(this.bZq) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.bZq) {
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
        com.baidu.tieba.card.data.e jP = jP(String.valueOf(j));
        if (jP != null) {
            jP.isLiked = z;
        }
        if (this.bZm != null) {
            this.bZm.setData(this.bZq);
            this.bZm.notifyDataSetChanged();
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

    private void aby() {
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ax.aV(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aL(str)) {
                                e.this.bZp.cd(str, valueOf);
                                TiebaStatic.log(new ak(e.this.bZs).ac(ImageViewerConfig.FORUM_ID, valueOf).ac("obj_param3", k.abH()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aL(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.bZu).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", k.abH()));
                            } else {
                                TiebaStatic.log(new ak(e.this.bZt).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", k.abH()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.bZv)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.bZv)));
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
        this.bZr = str;
        this.bZs = str2;
        this.bZt = str3;
        this.bZu = str4;
    }
}
