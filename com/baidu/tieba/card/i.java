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
    private LikeModel dKo;
    private View.OnClickListener dRF;
    private String eli;
    private CustomMessageListener elk;
    private CustomMessageListener ell;
    private String goA;
    private String goB;
    private String goC;
    private String goD;
    private HListView gov;
    private com.baidu.tieba.horizonalList.widget.b gow;
    private c gox;
    private View goy;
    private List<com.baidu.tieba.horizonalList.widget.c> goz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.elk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ell = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.gov = new HListView(getContext());
        this.gov.setHeaderDividersEnabled(false);
        this.gov.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.goy = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.gox = new c(this.goy);
        this.gmR.addView(this.gov);
        this.gov.setSelector(R.drawable.list_selector_transparent);
        this.gov.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bEA();
        if (this.gow == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.gow = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gox);
            this.gow.setOnClickListener(this.dRF);
            this.gov.setAdapter((ListAdapter) this.gow);
        }
        this.gmJ.setOnClickListener(this);
        this.dKo = new LikeModel(tbPageContext);
        this.dKo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.u) || i.this.dKo.getErrorCode() != 0) {
                    if (AntiHelper.bq(i.this.dKo.getErrorCode(), i.this.dKo.getErrorString())) {
                        AntiHelper.bi(i.this.getContext(), i.this.dKo.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.dKo.getErrorString());
                    }
                }
            }
        });
        this.gov.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.elk != null && this.ell != null) {
            this.elk.setTag(bdUniqueId);
            this.ell.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.elk);
            MessageManager.getInstance().registerListener(this.ell);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gov != null && this.gow != null) {
            this.gow.onSkinTypeChanged(i);
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
        this.goD = iVar.bFp();
        this.stType = iVar.getStType();
        if (!j(iVar.getDataList(), this.goz)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.goz);
            this.goz = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.gow != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.goz.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.gow = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gox);
                    this.gow.setData(this.goz);
                    this.gow.setOnClickListener(this.dRF);
                    this.gov.setAdapter((ListAdapter) this.gow);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gow.setData(this.goz);
                this.gow.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g BA(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.goz) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.goz) {
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
        com.baidu.tieba.card.data.g BA = BA(String.valueOf(j));
        if (BA != null) {
            BA.isLiked = z;
        }
        if (this.gow != null) {
            this.gow.setData(this.goz);
            this.gow.notifyDataSetChanged();
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

    private void bEA() {
        this.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                i.this.dKo.eP(str, valueOf);
                                TiebaStatic.log(new an(i.this.eli).cI("fid", valueOf).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEP()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.goC).cI("fid", valueOf2).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEP()));
                            } else {
                                TiebaStatic.log(new an(i.this.goB).cI("fid", valueOf2).cI(TiebaInitialize.Params.OBJ_PARAM3, l.bEP()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.goD)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.goD)));
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
        this.goA = str;
        this.eli = str2;
        this.goB = str3;
        this.goC = str4;
    }
}
