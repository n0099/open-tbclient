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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener aGc;
    private String bad;
    private CustomMessageListener baf;
    private CustomMessageListener bag;
    private LikeModel bvr;
    private String cxA;
    private String cxB;
    private HListView cxt;
    private com.baidu.tieba.horizonalList.widget.b cxu;
    private d cxv;
    private View cxw;
    private List<com.baidu.tieba.horizonalList.widget.c> cxx;
    private String cxy;
    private String cxz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.baf = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bag = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cxt = new HListView(getContext());
        this.cxt.setHeaderDividersEnabled(false);
        this.cxt.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cxw = this.mInflater.inflate(d.i.extend_forum_item, (ViewGroup) null);
        this.cxv = new d(this.cxw);
        this.cvJ.addView(this.cxt);
        this.cxt.setSelector(d.f.list_selector_transparent);
        this.cxt.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aiO();
        if (this.cxu == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cxu = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.cxv);
            this.cxu.setOnClickListener(this.aGc);
            this.cxt.setAdapter((ListAdapter) this.cxu);
        }
        this.cvB.setOnClickListener(this);
        this.bvr = new LikeModel(tbPageContext);
        this.bvr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.bvr.getErrorCode() != 0) {
                    if (AntiHelper.tE(j.this.bvr.getErrorCode())) {
                        AntiHelper.ao(j.this.getContext(), j.this.bvr.getErrorString());
                    } else {
                        j.this.aiH().showToast(j.this.bvr.getErrorString());
                    }
                }
            }
        });
        this.cxt.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.baf != null && this.bag != null) {
            this.baf.setTag(bdUniqueId);
            this.bag.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.baf);
            MessageManager.getInstance().registerListener(this.bag);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cxt != null && this.cxu != null) {
            this.cxu.dk(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.w.y(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int y = com.baidu.tbadk.core.util.w.y(gVar.getDataList());
        if (y > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cxB = gVar.ajy();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cxx)) {
            boolean z = com.baidu.tbadk.core.util.w.y(gVar.getDataList()) != com.baidu.tbadk.core.util.w.y(this.cxx);
            this.cxx = gVar.getDataList();
            if (y <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cxu != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cxx.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cxu = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.cxv);
                    this.cxu.setData(this.cxx);
                    this.cxu.setOnClickListener(this.aGc);
                    this.cxt.setAdapter((ListAdapter) this.cxu);
                    d(aiH(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cxu.setData(this.cxx);
                this.cxu.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e la(String str) {
        if (com.baidu.tbadk.core.util.w.y(this.cxx) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cxx) {
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
    public void b(long j, boolean z) {
        com.baidu.tieba.card.data.e la = la(String.valueOf(j));
        if (la != null) {
            la.isLiked = z;
        }
        if (this.cxu != null) {
            this.cxu.setData(this.cxx);
            this.cxu.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.w.y(list) <= 0 || com.baidu.tbadk.core.util.w.y(list2) <= 0 || com.baidu.tbadk.core.util.w.y(list) != com.baidu.tbadk.core.util.w.y(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.w.y(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.c(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.c(list2, i);
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

    private void aiO() {
        this.aGc = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ba.aU(j.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ao.bc(str)) {
                                j.this.bvr.cj(str, valueOf);
                                TiebaStatic.log(new am(j.this.bad).ah(ImageViewerConfig.FORUM_ID, valueOf).ah("obj_param3", o.aiY()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ao.bc(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cxA).ah(ImageViewerConfig.FORUM_ID, valueOf2).ah("obj_param3", o.aiY()));
                            } else {
                                TiebaStatic.log(new am(j.this.cxz).ah(ImageViewerConfig.FORUM_ID, valueOf2).ah("obj_param3", o.aiY()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cxB)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cxB)));
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
        this.cxy = str;
        this.bad = str2;
        this.cxz = str3;
        this.cxA = str4;
    }
}
