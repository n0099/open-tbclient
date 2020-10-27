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
/* loaded from: classes21.dex */
public class j extends c<com.baidu.tieba.card.data.j> {
    private LikeModel eTL;
    private View.OnClickListener fcr;
    private String fyd;
    private CustomMessageListener fyf;
    private CustomMessageListener fyg;
    private String hRA;
    private HListView hRs;
    private com.baidu.tieba.horizonalList.widget.b hRt;
    private d hRu;
    private View hRv;
    private List<com.baidu.tieba.horizonalList.widget.c> hRw;
    private String hRx;
    private String hRy;
    private String hRz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fyf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fyg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.hRs = new HListView(getContext());
        this.hRs.setHeaderDividersEnabled(false);
        this.hRs.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.hRv = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.hRu = new d(this.hRv);
        this.hPO.addView(this.hRs);
        this.hRs.setSelector(R.drawable.list_selector_transparent);
        this.hRs.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        clu();
        if (this.hRt == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.hRt = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hRu);
            this.hRt.setOnClickListener(this.fcr);
            this.hRs.setAdapter((ListAdapter) this.hRt);
        }
        this.hPG.setOnClickListener(this);
        this.eTL = new LikeModel(tbPageContext);
        this.eTL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.v) || j.this.eTL.getErrorCode() != 0) {
                    if (AntiHelper.bN(j.this.eTL.getErrorCode(), j.this.eTL.getErrorString())) {
                        AntiHelper.bm(j.this.getContext(), j.this.eTL.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.eTL.getErrorString());
                    }
                }
            }
        });
        this.hRs.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fyf != null && this.fyg != null) {
            this.fyf.setTag(bdUniqueId);
            this.fyg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fyf);
            MessageManager.getInstance().registerListener(this.fyg);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hRs != null && this.hRt != null) {
            this.hRt.onSkinTypeChanged(i);
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
        this.hRA = jVar.cml();
        this.stType = jVar.getStType();
        if (!s(jVar.getDataList(), this.hRw)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(jVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.hRw);
            this.hRw = jVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.hRt != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.hRw.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.hRt = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hRu);
                    this.hRt.setData(this.hRw);
                    this.hRt.setOnClickListener(this.fcr);
                    this.hRs.setAdapter((ListAdapter) this.hRt);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hRt.setData(this.hRw);
                this.hRt.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.h IH(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.hRw) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.hRw) {
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
    public void g(long j, boolean z) {
        com.baidu.tieba.card.data.h IH = IH(String.valueOf(j));
        if (IH != null) {
            IH.isLiked = z;
        }
        if (this.hRt != null) {
            this.hRt.setData(this.hRw);
            this.hRt.notifyDataSetChanged();
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

    private void clu() {
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bg.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (at.isForumName(str)) {
                                j.this.eTL.gp(str, valueOf);
                                TiebaStatic.log(new aq(j.this.fyd).dR("fid", valueOf).dR(TiebaInitialize.Params.OBJ_PARAM3, n.clH()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (at.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new aq(j.this.hRz).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.clH()));
                            } else {
                                TiebaStatic.log(new aq(j.this.hRy).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.clH()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.hRA)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.hRA)));
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
        this.hRx = str;
        this.fyd = str2;
        this.hRy = str3;
        this.hRz = str4;
    }
}
