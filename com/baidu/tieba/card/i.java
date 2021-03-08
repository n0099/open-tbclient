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
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.card.data.i> {
    private String fTU;
    private CustomMessageListener fTW;
    private CustomMessageListener fTX;
    private LikeModel foW;
    private HListView iyd;
    private com.baidu.tieba.horizonalList.widget.b iye;
    private CardExtendForumItemHolder iyf;
    private View iyg;
    private List<com.baidu.tieba.horizonalList.widget.c> iyh;
    private String iyi;
    private String iyj;
    private String iyk;
    private String iyl;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.iyd = new HListView(getContext());
        this.iyd.setHeaderDividersEnabled(false);
        this.iyd.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.iyg = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.iyf = new CardExtendForumItemHolder(this.iyg);
        this.iwz.addView(this.iyd);
        this.iyd.setSelector(R.drawable.list_selector_transparent);
        this.iyd.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        csk();
        if (this.iye == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.iye = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iyf);
            this.iye.setOnClickListener(this.onClickListener);
            this.iyd.setAdapter((ListAdapter) this.iye);
        }
        this.iwr.setOnClickListener(this);
        this.foW = new LikeModel(tbPageContext);
        this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.w) || i.this.foW.getErrorCode() != 0) {
                    if (AntiHelper.bX(i.this.foW.getErrorCode(), i.this.foW.getErrorString())) {
                        AntiHelper.bq(i.this.getContext(), i.this.foW.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.foW.getErrorString());
                    }
                }
            }
        });
        this.iyd.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fTW != null && this.fTX != null) {
            this.fTW.setTag(bdUniqueId);
            this.fTX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fTW);
            MessageManager.getInstance().registerListener(this.fTX);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iyd != null && this.iye != null) {
            this.iye.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
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
        this.iyl = iVar.ctg();
        this.stType = iVar.getStType();
        if (!s(iVar.getDataList(), this.iyh)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.iyh);
            this.iyh = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.iye != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.iyh.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.iye = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iyf);
                    this.iye.setData(this.iyh);
                    this.iye.setOnClickListener(this.onClickListener);
                    this.iyd.setAdapter((ListAdapter) this.iye);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iye.setData(this.iyh);
                this.iye.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g IV(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.iyh) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.iyh) {
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
    public void i(long j, boolean z) {
        com.baidu.tieba.card.data.g IV = IV(String.valueOf(j));
        if (IV != null) {
            IV.isLiked = z;
        }
        if (this.iye != null) {
            this.iye.setData(this.iyh);
            this.iye.notifyDataSetChanged();
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

    private void csk() {
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bh.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (au.isForumName(str)) {
                                i.this.foW.gy(str, valueOf);
                                TiebaStatic.log(new ar(i.this.fTU).dR("fid", valueOf).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csx()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (au.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ar(i.this.iyk).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csx()));
                            } else {
                                TiebaStatic.log(new ar(i.this.iyj).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csx()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.iyl)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.iyl)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void B(String str, String str2, String str3, String str4) {
        this.iyi = str;
        this.fTU = str2;
        this.iyj = str3;
        this.iyk = str4;
    }
}
