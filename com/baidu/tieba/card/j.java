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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j extends c<com.baidu.tieba.card.data.i> {
    private LikeModel dYI;
    private String eAd;
    private CustomMessageListener eAf;
    private CustomMessageListener eAg;
    private View.OnClickListener ege;
    private HListView gDG;
    private com.baidu.tieba.horizonalList.widget.b gDH;
    private d gDI;
    private View gDJ;
    private List<com.baidu.tieba.horizonalList.widget.c> gDK;
    private String gDL;
    private String gDM;
    private String gDN;
    private String gDO;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eAf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.eAg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.gDG = new HListView(getContext());
        this.gDG.setHeaderDividersEnabled(false);
        this.gDG.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.gDJ = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.gDI = new d(this.gDJ);
        this.gCc.addView(this.gDG);
        this.gDG.setSelector(R.drawable.list_selector_transparent);
        this.gDG.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bKW();
        if (this.gDH == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.gDH = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gDI);
            this.gDH.setOnClickListener(this.ege);
            this.gDG.setAdapter((ListAdapter) this.gDH);
        }
        this.gBU.setOnClickListener(this);
        this.dYI = new LikeModel(tbPageContext);
        this.dYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.u) || j.this.dYI.getErrorCode() != 0) {
                    if (AntiHelper.bv(j.this.dYI.getErrorCode(), j.this.dYI.getErrorString())) {
                        AntiHelper.aX(j.this.getContext(), j.this.dYI.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.dYI.getErrorString());
                    }
                }
            }
        });
        this.gDG.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.eAf != null && this.eAg != null) {
            this.eAf.setTag(bdUniqueId);
            this.eAg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eAf);
            MessageManager.getInstance().registerListener(this.eAg);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gDG != null && this.gDH != null) {
            this.gDH.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((j) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.gDO = iVar.bLK();
        this.stType = iVar.getStType();
        if (!k(iVar.getDataList(), this.gDK)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.gDK);
            this.gDK = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.gDH != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.gDK.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.gDH = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gDI);
                    this.gDH.setData(this.gDK);
                    this.gDH.setOnClickListener(this.ege);
                    this.gDG.setAdapter((ListAdapter) this.gDH);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gDH.setData(this.gDK);
                this.gDH.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Dm(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.gDK) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.gDK) {
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
        com.baidu.tieba.card.data.g Dm = Dm(String.valueOf(j));
        if (Dm != null) {
            Dm.isLiked = z;
        }
        if (this.gDH != null) {
            this.gDH.setData(this.gDK);
            this.gDH.notifyDataSetChanged();
        }
    }

    private boolean k(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.getCount(list) <= 0 || com.baidu.tbadk.core.util.v.getCount(list2) <= 0 || com.baidu.tbadk.core.util.v.getCount(list) != com.baidu.tbadk.core.util.v.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list2, i);
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

    private void bKW() {
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                j.this.dYI.fq(str, valueOf);
                                TiebaStatic.log(new an(j.this.eAd).dh("fid", valueOf).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLj()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(j.this.gDN).dh("fid", valueOf2).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLj()));
                            } else {
                                TiebaStatic.log(new an(j.this.gDM).dh("fid", valueOf2).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLj()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.gDO)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.gDO)));
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
        this.gDL = str;
        this.eAd = str2;
        this.gDM = str3;
        this.gDN = str4;
    }
}
