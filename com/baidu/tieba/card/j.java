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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class j extends c<com.baidu.tieba.card.data.j> {
    private View.OnClickListener eHN;
    private LikeModel ezi;
    private String fdr;
    private CustomMessageListener fdt;
    private CustomMessageListener fdu;
    private HListView hqc;
    private com.baidu.tieba.horizonalList.widget.b hqd;
    private d hqe;
    private View hqf;
    private List<com.baidu.tieba.horizonalList.widget.c> hqg;
    private String hqh;
    private String hqi;
    private String hqj;
    private String hqk;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.f(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.f(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.hqc = new HListView(getContext());
        this.hqc.setHeaderDividersEnabled(false);
        this.hqc.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.hqf = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.hqe = new d(this.hqf);
        this.hoy.addView(this.hqc);
        this.hqc.setSelector(R.drawable.list_selector_transparent);
        this.hqc.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        ceR();
        if (this.hqd == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.hqd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hqe);
            this.hqd.setOnClickListener(this.eHN);
            this.hqc.setAdapter((ListAdapter) this.hqd);
        }
        this.hoq.setOnClickListener(this);
        this.ezi = new LikeModel(tbPageContext);
        this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.v) || j.this.ezi.getErrorCode() != 0) {
                    if (AntiHelper.bC(j.this.ezi.getErrorCode(), j.this.ezi.getErrorString())) {
                        AntiHelper.bh(j.this.getContext(), j.this.ezi.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.ezi.getErrorString());
                    }
                }
            }
        });
        this.hqc.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fdt != null && this.fdu != null) {
            this.fdt.setTag(bdUniqueId);
            this.fdu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fdt);
            MessageManager.getInstance().registerListener(this.fdu);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hqc != null && this.hqd != null) {
            this.hqd.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.a((j) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.getCount(jVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(jVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(jVar.getDataList());
            jVar.getDataList().clear();
            jVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.hqk = jVar.cfI();
        this.stType = jVar.getStType();
        if (!p(jVar.getDataList(), this.hqg)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(jVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.hqg);
            this.hqg = jVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.hqd != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.hqg.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.hqd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hqe);
                    this.hqd.setData(this.hqg);
                    this.hqd.setOnClickListener(this.eHN);
                    this.hqc.setAdapter((ListAdapter) this.hqd);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hqd.setData(this.hqg);
                this.hqd.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.h Hv(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.hqg) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.hqg) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
                    com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) cVar;
                    if (String.valueOf(hVar.forumId).equals(str)) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j, boolean z) {
        com.baidu.tieba.card.data.h Hv = Hv(String.valueOf(j));
        if (Hv != null) {
            Hv.isLiked = z;
        }
        if (this.hqd != null) {
            this.hqd.setData(this.hqg);
            this.hqd.notifyDataSetChanged();
        }
    }

    private boolean p(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.getCount(list) <= 0 || com.baidu.tbadk.core.util.y.getCount(list2) <= 0 || com.baidu.tbadk.core.util.y.getCount(list) != com.baidu.tbadk.core.util.y.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list2, i);
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.h) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.h)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) cVar;
                com.baidu.tieba.card.data.h hVar2 = (com.baidu.tieba.card.data.h) cVar2;
                if (hVar.forumId != hVar2.forumId) {
                    z2 = false;
                }
                if (!hVar.forumAvatar.equals(hVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!hVar.forumName.equals(hVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void ceR() {
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bg.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (at.isForumName(str)) {
                                j.this.ezi.gd(str, valueOf);
                                TiebaStatic.log(new aq(j.this.fdr).dF("fid", valueOf).dF(TiebaInitialize.Params.OBJ_PARAM3, m.cfe()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (at.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new aq(j.this.hqj).dF("fid", valueOf2).dF(TiebaInitialize.Params.OBJ_PARAM3, m.cfe()));
                            } else {
                                TiebaStatic.log(new aq(j.this.hqi).dF("fid", valueOf2).dF(TiebaInitialize.Params.OBJ_PARAM3, m.cfe()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.hqk)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.hqk)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void A(String str, String str2, String str3, String str4) {
        this.hqh = str;
        this.fdr = str2;
        this.hqi = str3;
        this.hqj = str4;
    }
}
