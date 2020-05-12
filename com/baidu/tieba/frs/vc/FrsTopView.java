package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsTopView extends LinearLayout {
    private ForumData dZc;
    private v gZQ;
    private com.baidu.tieba.frs.d.b hgM;
    private ar hgq;
    private com.baidu.tieba.frs.ad.g hyA;
    private boolean hyB;
    private List<View> hyC;
    private List<com.baidu.tieba.frs.view.d> hyD;
    private ArrayList<Boolean> hyE;
    private FrsFoldingView hyz;
    private BdUniqueId mBdUniqueId;
    private String mForumId;
    private String mForumName;
    private int textColor;
    private List<com.baidu.adp.widget.ListView.m> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hyB = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.hyC = new ArrayList();
        this.hyD = new ArrayList();
        this.topThreadList = new ArrayList();
        this.hgM = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.hyz = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.hyD.clear();
        this.hyC.clear();
        if (com.baidu.tbadk.core.util.v.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                bVX();
                com.baidu.tieba.frs.view.d dVar = this.hyD.get(i2);
                if (dVar != null) {
                    if (this.gZQ == null) {
                        this.gZQ = new a();
                    }
                    dVar.d(this.gZQ);
                    dVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.hyE == null && this.hyC != null) {
            this.hyE = new ArrayList<>(Collections.nCopies(this.hyC.size(), Boolean.FALSE));
        }
        bVY();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.hyA == null) {
                this.hyA = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.hyA.getView());
            }
            this.hyA.a(this.dZc, iVar);
            if (!this.hyB) {
                this.hyB = true;
                an anVar = new an("common_exp");
                anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cI("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                anVar.af("obj_floor", 1);
                anVar.af("obj_adlocate", i);
                anVar.t("obj_id", iVar.getId());
                if (this.dZc != null) {
                    anVar.cI("fid", this.dZc.getId());
                    anVar.cI("first_dir", this.dZc.getFirst_class());
                    anVar.cI("second_dir", this.dZc.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    anVar.cI("tid", iVar.getThreadId());
                    anVar.af("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    private void bVX() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(getContext());
        dVar.dJ(this.mForumId, this.mForumName);
        dVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            dVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            dVar.vn(this.textColor);
        }
        adapterLinearLayout.setAdapter(dVar);
        this.hyC.add(adapterLinearLayout);
        this.hyD.add(dVar);
    }

    public void setStatListener(ar arVar) {
        this.hgq = arVar;
    }

    private void bVY() {
        setVisibility(0);
        if (this.hyz != null) {
            this.hyz.setViews(this.hyC, this.hyD);
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.d dVar : this.hyD) {
            dVar.notifyDataSetChanged();
        }
        if (this.hyz != null) {
            this.hyz.onChangeSkinType();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements v {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bj)) {
                bj bjVar = (bj) mVar;
                if (bjVar.aLz() == null || bjVar.aLz().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bjVar.aLm() != 1 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bjVar.aKP() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bjVar.aKP().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bjVar.aLK() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aLK = bjVar.aLK();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aLK.getCartoonId(), aLK.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aKJ = bjVar.aKJ();
                            if (aKJ != null && !aKJ.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aKJ);
                                        xVar.aOw().aOW().mIsNeedAddCommenParam = false;
                                        xVar.aOw().aOW().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.aKx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aOV().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.dsF.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.aKi());
                            } else if (bdUniqueId.getId() == bj.drd.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cI("obj_type", "2");
                                anVar.cI("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.hgq != null) {
                                FrsTopView.this.hgq.an(bjVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getTbPageContext() {
        if (getContext() instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) getContext()).getPageContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragmentActivity getFragmentActivity() {
        if (getContext() instanceof BaseFragmentActivity) {
            return (BaseFragmentActivity) getContext();
        }
        return null;
    }

    public void setForum(String str, String str2, ForumData forumData) {
        this.mForumId = str;
        this.mForumName = str2;
        this.dZc = forumData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bj bjVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bjVar != null) {
            String valueOf = String.valueOf(bjVar.getFid());
            if (bjVar.dtD == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.dtD.id;
                str2 = valueOf;
            }
            if (bjVar.aKY() > 0 && com.baidu.tieba.tbadkCore.util.e.cXr()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aKY()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aLO());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aLG() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.d dVar : this.hyD) {
            if (str != null) {
                dVar.setImageUrl(str);
                this.url = str;
            }
            dVar.vn(i);
            dVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgM;
    }
}
