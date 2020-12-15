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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class j extends c<com.baidu.tieba.card.data.i> {
    private String fLi;
    private CustomMessageListener fLk;
    private CustomMessageListener fLl;
    private LikeModel fgf;
    private View.OnClickListener foP;
    private HListView iiO;
    private com.baidu.tieba.horizonalList.widget.b iiP;
    private d iiQ;
    private View iiR;
    private List<com.baidu.tieba.horizonalList.widget.c> iiS;
    private String iiT;
    private String iiU;
    private String iiV;
    private String iiW;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.iiO = new HListView(getContext());
        this.iiO.setHeaderDividersEnabled(false);
        this.iiO.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.iiR = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.iiQ = new d(this.iiR);
        this.ihk.addView(this.iiO);
        this.iiO.setSelector(R.drawable.list_selector_transparent);
        this.iiO.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        crL();
        if (this.iiP == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.iiP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iiQ);
            this.iiP.setOnClickListener(this.foP);
            this.iiO.setAdapter((ListAdapter) this.iiP);
        }
        this.ihc.setOnClickListener(this);
        this.fgf = new LikeModel(tbPageContext);
        this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.w) || j.this.fgf.getErrorCode() != 0) {
                    if (AntiHelper.bP(j.this.fgf.getErrorCode(), j.this.fgf.getErrorString())) {
                        AntiHelper.bn(j.this.getContext(), j.this.fgf.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.fgf.getErrorString());
                    }
                }
            }
        });
        this.iiO.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fLk != null && this.fLl != null) {
            this.fLk.setTag(bdUniqueId);
            this.fLl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLk);
            MessageManager.getInstance().registerListener(this.fLl);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iiO != null && this.iiP != null) {
            this.iiP.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((j) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.iiW = iVar.csF();
        this.stType = iVar.getStType();
        if (!s(iVar.getDataList(), this.iiS)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.iiS);
            this.iiS = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.iiP != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.iiS.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.iiP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iiQ);
                    this.iiP.setData(this.iiS);
                    this.iiP.setOnClickListener(this.foP);
                    this.iiO.setAdapter((ListAdapter) this.iiP);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iiP.setData(this.iiS);
                this.iiP.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Jp(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.iiS) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.iiS) {
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
    public void g(long j, boolean z) {
        com.baidu.tieba.card.data.g Jp = Jp(String.valueOf(j));
        if (Jp != null) {
            Jp.isLiked = z;
        }
        if (this.iiP != null) {
            this.iiP.setData(this.iiS);
            this.iiP.notifyDataSetChanged();
        }
    }

    private boolean s(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.getCount(list) <= 0 || com.baidu.tbadk.core.util.y.getCount(list2) <= 0 || com.baidu.tbadk.core.util.y.getCount(list) != com.baidu.tbadk.core.util.y.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list2, i);
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

    private void crL() {
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bh.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (au.isForumName(str)) {
                                j.this.fgf.gu(str, valueOf);
                                TiebaStatic.log(new ar(j.this.fLi).dY("fid", valueOf).dY(TiebaInitialize.Params.OBJ_PARAM3, n.crY()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (au.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ar(j.this.iiV).dY("fid", valueOf2).dY(TiebaInitialize.Params.OBJ_PARAM3, n.crY()));
                            } else {
                                TiebaStatic.log(new ar(j.this.iiU).dY("fid", valueOf2).dY(TiebaInitialize.Params.OBJ_PARAM3, n.crY()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.iiW)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.iiW)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void C(String str, String str2, String str3, String str4) {
        this.iiT = str;
        this.fLi = str2;
        this.iiU = str3;
        this.iiV = str4;
    }
}
