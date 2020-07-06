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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j extends c<com.baidu.tieba.card.data.i> {
    private String eJs;
    private CustomMessageListener eJu;
    private CustomMessageListener eJv;
    private LikeModel egK;
    private View.OnClickListener eoP;
    private List<com.baidu.tieba.horizonalList.widget.c> gQA;
    private String gQB;
    private String gQC;
    private String gQD;
    private String gQE;
    private HListView gQw;
    private com.baidu.tieba.horizonalList.widget.b gQx;
    private d gQy;
    private View gQz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.gQw = new HListView(getContext());
        this.gQw.setHeaderDividersEnabled(false);
        this.gQw.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.gQz = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.gQy = new d(this.gQz);
        this.gOS.addView(this.gQw);
        this.gQw.setSelector(R.drawable.list_selector_transparent);
        this.gQw.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        bOf();
        if (this.gQx == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.gQx = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gQy);
            this.gQx.setOnClickListener(this.eoP);
            this.gQw.setAdapter((ListAdapter) this.gQx);
        }
        this.gOK.setOnClickListener(this);
        this.egK = new LikeModel(tbPageContext);
        this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.u) || j.this.egK.getErrorCode() != 0) {
                    if (AntiHelper.bA(j.this.egK.getErrorCode(), j.this.egK.getErrorString())) {
                        AntiHelper.aX(j.this.getContext(), j.this.egK.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.egK.getErrorString());
                    }
                }
            }
        });
        this.gQw.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.eJu != null && this.eJv != null) {
            this.eJu.setTag(bdUniqueId);
            this.eJv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eJu);
            MessageManager.getInstance().registerListener(this.eJv);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gQw != null && this.gQx != null) {
            this.gQx.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((j) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.w.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.w.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.gQE = iVar.bOV();
        this.stType = iVar.getStType();
        if (!l(iVar.getDataList(), this.gQA)) {
            boolean z = com.baidu.tbadk.core.util.w.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.w.getCount(this.gQA);
            this.gQA = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.gQx != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.gQA.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.gQx = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.gQy);
                    this.gQx.setData(this.gQA);
                    this.gQx.setOnClickListener(this.eoP);
                    this.gQw.setAdapter((ListAdapter) this.gQx);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gQx.setData(this.gQA);
                this.gQx.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g DN(String str) {
        if (com.baidu.tbadk.core.util.w.getCount(this.gQA) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.gQA) {
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
        com.baidu.tieba.card.data.g DN = DN(String.valueOf(j));
        if (DN != null) {
            DN.isLiked = z;
        }
        if (this.gQx != null) {
            this.gQx.setData(this.gQA);
            this.gQx.notifyDataSetChanged();
        }
    }

    private boolean l(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.w.getCount(list) <= 0 || com.baidu.tbadk.core.util.w.getCount(list2) <= 0 || com.baidu.tbadk.core.util.w.getCount(list) != com.baidu.tbadk.core.util.w.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.w.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.getItem(list2, i);
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

    private void bOf() {
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (be.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (ar.isForumName(str)) {
                                j.this.egK.fx(str, valueOf);
                                TiebaStatic.log(new ao(j.this.eJs).dk("fid", valueOf).dk(TiebaInitialize.Params.OBJ_PARAM3, m.bOs()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (ar.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ao(j.this.gQD).dk("fid", valueOf2).dk(TiebaInitialize.Params.OBJ_PARAM3, m.bOs()));
                            } else {
                                TiebaStatic.log(new ao(j.this.gQC).dk("fid", valueOf2).dk(TiebaInitialize.Params.OBJ_PARAM3, m.bOs()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.gQE)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.gQE)));
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
        this.gQB = str;
        this.eJs = str2;
        this.gQC = str3;
        this.gQD = str4;
    }
}
