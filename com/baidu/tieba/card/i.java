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
/* loaded from: classes3.dex */
public class i extends b<com.baidu.tieba.card.data.g> {
    private String cTa;
    private CustomMessageListener cTc;
    private CustomMessageListener cTd;
    private LikeModel csF;
    private View.OnClickListener czV;
    private HListView eMe;
    private com.baidu.tieba.horizonalList.widget.b eMf;
    private c eMg;
    private View eMh;
    private List<com.baidu.tieba.horizonalList.widget.c> eMi;
    private String eMj;
    private String eMk;
    private String eMl;
    private String eMm;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cTc = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cTd = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eMe = new HListView(getContext());
        this.eMe.setHeaderDividersEnabled(false);
        this.eMe.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.eMh = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.eMg = new c(this.eMh);
        this.eKA.addView(this.eMe);
        this.eMe.setSelector(R.drawable.list_selector_transparent);
        this.eMe.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        aZZ();
        if (this.eMf == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.eMf = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eMg);
            this.eMf.setOnClickListener(this.czV);
            this.eMe.setAdapter((ListAdapter) this.eMf);
        }
        this.eKs.setOnClickListener(this);
        this.csF = new LikeModel(tbPageContext);
        this.csF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.csF.getErrorCode() != 0) {
                    if (AntiHelper.aH(i.this.csF.getErrorCode(), i.this.csF.getErrorString())) {
                        AntiHelper.aS(i.this.getContext(), i.this.csF.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.csF.getErrorString());
                    }
                }
            }
        });
        this.eMe.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.cTc != null && this.cTd != null) {
            this.cTc.setTag(bdUniqueId);
            this.cTd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTc);
            MessageManager.getInstance().registerListener(this.cTd);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eMe != null && this.eMf != null) {
            this.eMf.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((i) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.getCount(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(gVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.eMm = gVar.baO();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.eMi)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(gVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.eMi);
            this.eMi = gVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.eMf != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.eMi.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.eMf = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eMg);
                    this.eMf.setData(this.eMi);
                    this.eMf.setOnClickListener(this.czV);
                    this.eMe.setAdapter((ListAdapter) this.eMf);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eMf.setData(this.eMi);
                this.eMf.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e uy(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eMi) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.eMi) {
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
    public void d(long j, boolean z) {
        com.baidu.tieba.card.data.e uy = uy(String.valueOf(j));
        if (uy != null) {
            uy.isLiked = z;
        }
        if (this.eMf != null) {
            this.eMf.setData(this.eMi);
            this.eMf.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.getCount(list) <= 0 || com.baidu.tbadk.core.util.v.getCount(list2) <= 0 || com.baidu.tbadk.core.util.v.getCount(list) != com.baidu.tbadk.core.util.v.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list2, i);
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

    private void aZZ() {
        this.czV = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                i.this.csF.dY(str, valueOf);
                                TiebaStatic.log(new an(i.this.cTa).bS("fid", valueOf).bS(TiebaInitialize.Params.OBJ_PARAM3, n.ban()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.eMl).bS("fid", valueOf2).bS(TiebaInitialize.Params.OBJ_PARAM3, n.ban()));
                            } else {
                                TiebaStatic.log(new an(i.this.eMk).bS("fid", valueOf2).bS(TiebaInitialize.Params.OBJ_PARAM3, n.ban()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.eMm)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.eMm)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void r(String str, String str2, String str3, String str4) {
        this.eMj = str;
        this.cTa = str2;
        this.eMk = str3;
        this.eMl = str4;
    }
}
