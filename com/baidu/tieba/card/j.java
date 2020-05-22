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
    private View.OnClickListener ege;
    private String ezS;
    private CustomMessageListener ezU;
    private CustomMessageListener ezV;
    private String gDA;
    private String gDB;
    private String gDC;
    private String gDD;
    private HListView gDv;
    private com.baidu.tieba.horizonalList.widget.b gDw;
    private d gDx;
    private View gDy;
    private List<com.baidu.tieba.horizonalList.widget.c> gDz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ezU = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ezV = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.gDv = new HListView(getContext());
        this.gDv.setHeaderDividersEnabled(false);
        this.gDv.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.gDy = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.gDx = new d(this.gDy);
        this.gBR.addView(this.gDv);
        this.gDv.setSelector(R.drawable.list_selector_transparent);
        this.gDv.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bKU();
        if (this.gDw == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.gDw = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gDx);
            this.gDw.setOnClickListener(this.ege);
            this.gDv.setAdapter((ListAdapter) this.gDw);
        }
        this.gBJ.setOnClickListener(this);
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
        this.gDv.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.ezU != null && this.ezV != null) {
            this.ezU.setTag(bdUniqueId);
            this.ezV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ezU);
            MessageManager.getInstance().registerListener(this.ezV);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gDv != null && this.gDw != null) {
            this.gDw.onSkinTypeChanged(i);
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
        this.gDD = iVar.bLI();
        this.stType = iVar.getStType();
        if (!k(iVar.getDataList(), this.gDz)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.gDz);
            this.gDz = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.gDw != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.gDz.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.gDw = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gDx);
                    this.gDw.setData(this.gDz);
                    this.gDw.setOnClickListener(this.ege);
                    this.gDv.setAdapter((ListAdapter) this.gDw);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gDw.setData(this.gDz);
                this.gDw.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Dm(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.gDz) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.gDz) {
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
        if (this.gDw != null) {
            this.gDw.setData(this.gDz);
            this.gDw.notifyDataSetChanged();
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

    private void bKU() {
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
                                TiebaStatic.log(new an(j.this.ezS).dh("fid", valueOf).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLh()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(j.this.gDC).dh("fid", valueOf2).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLh()));
                            } else {
                                TiebaStatic.log(new an(j.this.gDB).dh("fid", valueOf2).dh(TiebaInitialize.Params.OBJ_PARAM3, m.bLh()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.gDD)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.gDD)));
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
        this.gDA = str;
        this.ezS = str2;
        this.gDB = str3;
        this.gDC = str4;
    }
}
