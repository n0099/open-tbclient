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
    private String cIV;
    private CustomMessageListener cIX;
    private CustomMessageListener cIY;
    private LikeModel cer;
    private View.OnClickListener cmX;
    private View eDA;
    private List<com.baidu.tieba.horizonalList.widget.c> eDB;
    private String eDC;
    private String eDD;
    private String eDE;
    private String eDF;
    private HListView eDx;
    private com.baidu.tieba.horizonalList.widget.b eDy;
    private c eDz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cIX = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cIY = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eDx = new HListView(getContext());
        this.eDx.setHeaderDividersEnabled(false);
        this.eDx.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.eDA = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.eDz = new c(this.eDA);
        this.eBS.addView(this.eDx);
        this.eDx.setSelector(R.drawable.list_selector_transparent);
        this.eDx.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        aZW();
        if (this.eDy == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.eDy = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eDz);
            this.eDy.setOnClickListener(this.cmX);
            this.eDx.setAdapter((ListAdapter) this.eDy);
        }
        this.eBK.setOnClickListener(this);
        this.cer = new LikeModel(tbPageContext);
        this.cer.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.cer.getErrorCode() != 0) {
                    if (AntiHelper.aG(i.this.cer.getErrorCode(), i.this.cer.getErrorString())) {
                        AntiHelper.aQ(i.this.getContext(), i.this.cer.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.cer.getErrorString());
                    }
                }
            }
        });
        this.eDx.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.cIX != null && this.cIY != null) {
            this.cIX.setTag(bdUniqueId);
            this.cIY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIX);
            MessageManager.getInstance().registerListener(this.cIY);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eDx != null && this.eDy != null) {
            this.eDy.iJ(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((i) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.Z(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(gVar.getDataList());
        if (Z > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.eDF = gVar.baM();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.eDB)) {
            boolean z = com.baidu.tbadk.core.util.v.Z(gVar.getDataList()) != com.baidu.tbadk.core.util.v.Z(this.eDB);
            this.eDB = gVar.getDataList();
            if (Z <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.eDy != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.eDB.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.eDy = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.eDz);
                    this.eDy.setData(this.eDB);
                    this.eDy.setOnClickListener(this.cmX);
                    this.eDx.setAdapter((ListAdapter) this.eDy);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eDy.setData(this.eDB);
                this.eDy.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e vV(String str) {
        if (com.baidu.tbadk.core.util.v.Z(this.eDB) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.eDB) {
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
        com.baidu.tieba.card.data.e vV = vV(String.valueOf(j));
        if (vV != null) {
            vV.isLiked = z;
        }
        if (this.eDy != null) {
            this.eDy.setData(this.eDB);
            this.eDy.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.Z(list) <= 0 || com.baidu.tbadk.core.util.v.Z(list2) <= 0 || com.baidu.tbadk.core.util.v.Z(list) != com.baidu.tbadk.core.util.v.Z(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.Z(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list2, i);
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

    private void aZW() {
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.cF(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.bg(str)) {
                                i.this.cer.em(str, valueOf);
                                TiebaStatic.log(new an(i.this.cIV).bT("fid", valueOf).bT("obj_param3", n.bak()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.bg(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.eDE).bT("fid", valueOf2).bT("obj_param3", n.bak()));
                            } else {
                                TiebaStatic.log(new an(i.this.eDD).bT("fid", valueOf2).bT("obj_param3", n.bak()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.eDF)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.eDF)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void p(String str, String str2, String str3, String str4) {
        this.eDC = str;
        this.cIV = str2;
        this.eDD = str3;
        this.eDE = str4;
    }
}
