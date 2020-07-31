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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class j extends c<com.baidu.tieba.card.data.i> {
    private String ePO;
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private LikeModel emT;
    private View.OnClickListener eve;
    private HListView gWc;
    private com.baidu.tieba.horizonalList.widget.b gWd;
    private d gWe;
    private View gWf;
    private List<com.baidu.tieba.horizonalList.widget.c> gWg;
    private String gWh;
    private String gWi;
    private String gWj;
    private String gWk;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.gWc = new HListView(getContext());
        this.gWc.setHeaderDividersEnabled(false);
        this.gWc.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.gWf = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.gWe = new d(this.gWf);
        this.gUy.addView(this.gWc);
        this.gWc.setSelector(R.drawable.list_selector_transparent);
        this.gWc.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bRp();
        if (this.gWd == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.gWd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gWe);
            this.gWd.setOnClickListener(this.eve);
            this.gWc.setAdapter((ListAdapter) this.gWd);
        }
        this.gUq.setOnClickListener(this);
        this.emT = new LikeModel(tbPageContext);
        this.emT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.u) || j.this.emT.getErrorCode() != 0) {
                    if (AntiHelper.bB(j.this.emT.getErrorCode(), j.this.emT.getErrorString())) {
                        AntiHelper.aW(j.this.getContext(), j.this.emT.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.emT.getErrorString());
                    }
                }
            }
        });
        this.gWc.setOnItemClickListener(null);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (this.ePQ != null && this.ePR != null) {
            this.ePQ.setTag(bdUniqueId);
            this.ePR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ePQ);
            MessageManager.getInstance().registerListener(this.ePR);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gWc != null && this.gWd != null) {
            this.gWd.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((j) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.x.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.gWk = iVar.bSg();
        this.stType = iVar.getStType();
        if (!l(iVar.getDataList(), this.gWg)) {
            boolean z = com.baidu.tbadk.core.util.x.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.x.getCount(this.gWg);
            this.gWg = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.gWd != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.gWg.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.gWd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gWe);
                    this.gWd.setData(this.gWg);
                    this.gWd.setOnClickListener(this.eve);
                    this.gWc.setAdapter((ListAdapter) this.gWd);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gWd.setData(this.gWg);
                this.gWd.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Ey(String str) {
        if (com.baidu.tbadk.core.util.x.getCount(this.gWg) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.gWg) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
                    com.baidu.tieba.card.data.g gVar = (com.baidu.tieba.card.data.g) cVar;
                    if (String.valueOf(gVar.forumId).equals(str)) {
                        return gVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        com.baidu.tieba.card.data.g Ey = Ey(String.valueOf(j));
        if (Ey != null) {
            Ey.isLiked = z;
        }
        if (this.gWd != null) {
            this.gWd.setData(this.gWg);
            this.gWd.notifyDataSetChanged();
        }
    }

    private boolean l(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.getCount(list) <= 0 || com.baidu.tbadk.core.util.x.getCount(list2) <= 0 || com.baidu.tbadk.core.util.x.getCount(list) != com.baidu.tbadk.core.util.x.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(list2, i);
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.g) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.g)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.g gVar = (com.baidu.tieba.card.data.g) cVar;
                com.baidu.tieba.card.data.g gVar2 = (com.baidu.tieba.card.data.g) cVar2;
                if (gVar.forumId != gVar2.forumId) {
                    z2 = false;
                }
                if (!gVar.forumAvatar.equals(gVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!gVar.forumName.equals(gVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void bRp() {
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bf.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (as.isForumName(str)) {
                                j.this.emT.fz(str, valueOf);
                                TiebaStatic.log(new ap(j.this.ePO).dn("fid", valueOf).dn(TiebaInitialize.Params.OBJ_PARAM3, m.bRC()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (as.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ap(j.this.gWj).dn("fid", valueOf2).dn(TiebaInitialize.Params.OBJ_PARAM3, m.bRC()));
                            } else {
                                TiebaStatic.log(new ap(j.this.gWi).dn("fid", valueOf2).dn(TiebaInitialize.Params.OBJ_PARAM3, m.bRC()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.gWk)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.gWk)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void x(String str, String str2, String str3, String str4) {
        this.gWh = str;
        this.ePO = str2;
        this.gWi = str3;
        this.gWj = str4;
    }
}
