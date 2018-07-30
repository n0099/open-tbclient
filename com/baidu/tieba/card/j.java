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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener aGU;
    private LikeModel azq;
    private String bbg;
    private CustomMessageListener bbi;
    private CustomMessageListener bbj;
    private HListView cyc;
    private com.baidu.tieba.horizonalList.widget.b cyd;
    private d cye;
    private View cyf;
    private List<com.baidu.tieba.horizonalList.widget.c> cyg;
    private String cyh;
    private String cyi;
    private String cyj;
    private String cyk;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbi = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbj = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cyc = new HListView(getContext());
        this.cyc.setHeaderDividersEnabled(false);
        this.cyc.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cyf = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.cye = new d(this.cyf);
        this.cws.addView(this.cyc);
        this.cyc.setSelector(d.f.list_selector_transparent);
        this.cyc.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aiF();
        if (this.cyd == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cyd = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.cye);
            this.cyd.setOnClickListener(this.aGU);
            this.cyc.setAdapter((ListAdapter) this.cyd);
        }
        this.cwk.setOnClickListener(this);
        this.azq = new LikeModel(tbPageContext);
        this.azq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.azq.getErrorCode() != 0) {
                    if (AntiHelper.al(j.this.azq.getErrorCode(), j.this.azq.getErrorString())) {
                        AntiHelper.aq(j.this.getContext(), j.this.azq.getErrorString());
                    } else {
                        j.this.aiy().showToast(j.this.azq.getErrorString());
                    }
                }
            }
        });
        this.cyc.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bbi != null && this.bbj != null) {
            this.bbi.setTag(bdUniqueId);
            this.bbj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbi);
            MessageManager.getInstance().registerListener(this.bbj);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cyc != null && this.cyd != null) {
            this.cyd.dn(i);
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
        this.cyk = gVar.ajr();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cyg)) {
            boolean z = com.baidu.tbadk.core.util.w.y(gVar.getDataList()) != com.baidu.tbadk.core.util.w.y(this.cyg);
            this.cyg = gVar.getDataList();
            if (y <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cyd != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cyg.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cyd = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.cye);
                    this.cyd.setData(this.cyg);
                    this.cyd.setOnClickListener(this.aGU);
                    this.cyc.setAdapter((ListAdapter) this.cyd);
                    d(aiy(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cyd.setData(this.cyg);
                this.cyd.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kV(String str) {
        if (com.baidu.tbadk.core.util.w.y(this.cyg) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cyg) {
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
    public void a(long j, boolean z) {
        com.baidu.tieba.card.data.e kV = kV(String.valueOf(j));
        if (kV != null) {
            kV.isLiked = z;
        }
        if (this.cyd != null) {
            this.cyd.setData(this.cyg);
            this.cyd.notifyDataSetChanged();
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
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list2, i);
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

    private void aiF() {
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ba.aV(j.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ap.bf(str)) {
                                j.this.azq.ck(str, valueOf);
                                TiebaStatic.log(new an(j.this.bbg).af(ImageViewerConfig.FORUM_ID, valueOf).af("obj_param3", o.aiP()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ap.bf(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new an(j.this.cyj).af(ImageViewerConfig.FORUM_ID, valueOf2).af("obj_param3", o.aiP()));
                            } else {
                                TiebaStatic.log(new an(j.this.cyi).af(ImageViewerConfig.FORUM_ID, valueOf2).af("obj_param3", o.aiP()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cyk)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cyk)));
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
        this.cyh = str;
        this.bbg = str2;
        this.cyi = str3;
        this.cyj = str4;
    }
}
