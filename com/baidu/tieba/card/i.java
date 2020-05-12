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
public class i extends b<com.baidu.tieba.card.data.i> {
    private LikeModel dKs;
    private View.OnClickListener dRK;
    private String eln;
    private CustomMessageListener elp;
    private CustomMessageListener elq;
    private HListView goB;
    private com.baidu.tieba.horizonalList.widget.b goC;
    private c goD;
    private View goE;
    private List<com.baidu.tieba.horizonalList.widget.c> goF;
    private String goG;
    private String goH;
    private String goI;
    private String goJ;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.elp = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.elq = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.goB = new HListView(getContext());
        this.goB.setHeaderDividersEnabled(false);
        this.goB.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.goE = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.goD = new c(this.goE);
        this.gmX.addView(this.goB);
        this.goB.setSelector(R.drawable.list_selector_transparent);
        this.goB.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bEz();
        if (this.goC == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.goC = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.goD);
            this.goC.setOnClickListener(this.dRK);
            this.goB.setAdapter((ListAdapter) this.goC);
        }
        this.gmP.setOnClickListener(this);
        this.dKs = new LikeModel(tbPageContext);
        this.dKs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.u) || i.this.dKs.getErrorCode() != 0) {
                    if (AntiHelper.bq(i.this.dKs.getErrorCode(), i.this.dKs.getErrorString())) {
                        AntiHelper.aW(i.this.getContext(), i.this.dKs.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.dKs.getErrorString());
                    }
                }
            }
        });
        this.goB.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.elp != null && this.elq != null) {
            this.elp.setTag(bdUniqueId);
            this.elq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.elp);
            MessageManager.getInstance().registerListener(this.elq);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.goB != null && this.goC != null) {
            this.goC.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
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
        this.goJ = iVar.bFo();
        this.stType = iVar.getStType();
        if (!j(iVar.getDataList(), this.goF)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.goF);
            this.goF = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.goC != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.goF.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.goC = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.goD);
                    this.goC.setData(this.goF);
                    this.goC.setOnClickListener(this.dRK);
                    this.goB.setAdapter((ListAdapter) this.goC);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.goC.setData(this.goF);
                this.goC.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g BD(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.goF) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.goF) {
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
        com.baidu.tieba.card.data.g BD = BD(String.valueOf(j));
        if (BD != null) {
            BD.isLiked = z;
        }
        if (this.goC != null) {
            this.goC.setData(this.goF);
            this.goC.notifyDataSetChanged();
        }
    }

    private boolean j(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
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

    private void bEz() {
        this.dRK = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                i.this.dKs.eP(str, valueOf);
                                TiebaStatic.log(new an(i.this.eln).cI("fid", valueOf).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEO()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.goI).cI("fid", valueOf2).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEO()));
                            } else {
                                TiebaStatic.log(new an(i.this.goH).cI("fid", valueOf2).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEO()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.goJ)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.goJ)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void w(String str, String str2, String str3, String str4) {
        this.goG = str;
        this.eln = str2;
        this.goH = str3;
        this.goI = str4;
    }
}
