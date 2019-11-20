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
    private String cSj;
    private CustomMessageListener cSl;
    private CustomMessageListener cSm;
    private LikeModel crO;
    private View.OnClickListener cze;
    private HListView eLn;
    private com.baidu.tieba.horizonalList.widget.b eLo;
    private c eLp;
    private View eLq;
    private List<com.baidu.tieba.horizonalList.widget.c> eLr;
    private String eLs;
    private String eLt;
    private String eLu;
    private String eLv;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cSl = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cSm = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eLn = new HListView(getContext());
        this.eLn.setHeaderDividersEnabled(false);
        this.eLn.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.eLq = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.eLp = new c(this.eLq);
        this.eJJ.addView(this.eLn);
        this.eLn.setSelector(R.drawable.list_selector_transparent);
        this.eLn.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        aZX();
        if (this.eLo == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.eLo = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eLp);
            this.eLo.setOnClickListener(this.cze);
            this.eLn.setAdapter((ListAdapter) this.eLo);
        }
        this.eJB.setOnClickListener(this);
        this.crO = new LikeModel(tbPageContext);
        this.crO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.crO.getErrorCode() != 0) {
                    if (AntiHelper.aG(i.this.crO.getErrorCode(), i.this.crO.getErrorString())) {
                        AntiHelper.aS(i.this.getContext(), i.this.crO.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.crO.getErrorString());
                    }
                }
            }
        });
        this.eLn.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.cSl != null && this.cSm != null) {
            this.cSl.setTag(bdUniqueId);
            this.cSm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cSl);
            MessageManager.getInstance().registerListener(this.cSm);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eLn != null && this.eLo != null) {
            this.eLo.onSkinTypeChanged(i);
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
        this.eLv = gVar.baM();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.eLr)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(gVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.eLr);
            this.eLr = gVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.eLo != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.eLr.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.eLo = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eLp);
                    this.eLo.setData(this.eLr);
                    this.eLo.setOnClickListener(this.cze);
                    this.eLn.setAdapter((ListAdapter) this.eLo);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eLo.setData(this.eLr);
                this.eLo.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e uy(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eLr) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.eLr) {
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
        if (this.eLo != null) {
            this.eLo.setData(this.eLr);
            this.eLo.notifyDataSetChanged();
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

    private void aZX() {
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                i.this.crO.dY(str, valueOf);
                                TiebaStatic.log(new an(i.this.cSj).bS("fid", valueOf).bS(TiebaInitialize.Params.OBJ_PARAM3, n.bal()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.eLu).bS("fid", valueOf2).bS(TiebaInitialize.Params.OBJ_PARAM3, n.bal()));
                            } else {
                                TiebaStatic.log(new an(i.this.eLt).bS("fid", valueOf2).bS(TiebaInitialize.Params.OBJ_PARAM3, n.bal()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.eLv)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.eLv)));
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
        this.eLs = str;
        this.cSj = str2;
        this.eLt = str3;
        this.eLu = str4;
    }
}
