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
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.card.data.i> {
    private String fQh;
    private CustomMessageListener fQj;
    private CustomMessageListener fQk;
    private LikeModel fle;
    private HListView iqC;
    private com.baidu.tieba.horizonalList.widget.b iqD;
    private CardExtendForumItemHolder iqE;
    private View iqF;
    private List<com.baidu.tieba.horizonalList.widget.c> iqG;
    private String iqH;
    private String iqI;
    private String iqJ;
    private String iqK;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.iqC = new HListView(getContext());
        this.iqC.setHeaderDividersEnabled(false);
        this.iqC.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.iqF = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.iqE = new CardExtendForumItemHolder(this.iqF);
        this.ioY.addView(this.iqC);
        this.iqC.setSelector(R.drawable.list_selector_transparent);
        this.iqC.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        cqN();
        if (this.iqD == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.iqD = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iqE);
            this.iqD.setOnClickListener(this.onClickListener);
            this.iqC.setAdapter((ListAdapter) this.iqD);
        }
        this.ioQ.setOnClickListener(this);
        this.fle = new LikeModel(tbPageContext);
        this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.w) || i.this.fle.getErrorCode() != 0) {
                    if (AntiHelper.bQ(i.this.fle.getErrorCode(), i.this.fle.getErrorString())) {
                        AntiHelper.bs(i.this.getContext(), i.this.fle.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.fle.getErrorString());
                    }
                }
            }
        });
        this.iqC.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fQj != null && this.fQk != null) {
            this.fQj.setTag(bdUniqueId);
            this.fQk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fQj);
            MessageManager.getInstance().registerListener(this.fQk);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iqC != null && this.iqD != null) {
            this.iqD.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
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
        this.iqK = iVar.crH();
        this.stType = iVar.getStType();
        if (!u(iVar.getDataList(), this.iqG)) {
            boolean z = com.baidu.tbadk.core.util.x.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.x.getCount(this.iqG);
            this.iqG = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.iqD != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.iqG.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.iqD = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iqE);
                    this.iqD.setData(this.iqG);
                    this.iqD.setOnClickListener(this.onClickListener);
                    this.iqC.setAdapter((ListAdapter) this.iqD);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iqD.setData(this.iqG);
                this.iqD.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Ib(String str) {
        if (com.baidu.tbadk.core.util.x.getCount(this.iqG) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.iqG) {
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
        com.baidu.tieba.card.data.g Ib = Ib(String.valueOf(j));
        if (Ib != null) {
            Ib.isLiked = z;
        }
        if (this.iqD != null) {
            this.iqD.setData(this.iqG);
            this.iqD.notifyDataSetChanged();
        }
    }

    private boolean u(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
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

    private void cqN() {
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bg.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (at.isForumName(str)) {
                                i.this.fle.gq(str, valueOf);
                                TiebaStatic.log(new aq(i.this.fQh).dW("fid", valueOf).dW(TiebaInitialize.Params.OBJ_PARAM3, m.cra()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (at.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new aq(i.this.iqJ).dW("fid", valueOf2).dW(TiebaInitialize.Params.OBJ_PARAM3, m.cra()));
                            } else {
                                TiebaStatic.log(new aq(i.this.iqI).dW("fid", valueOf2).dW(TiebaInitialize.Params.OBJ_PARAM3, m.cra()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.iqK)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.iqK)));
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
        this.iqH = str;
        this.fQh = str2;
        this.iqI = str3;
        this.iqJ = str4;
    }
}
