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
    private ForumData dYX;
    private v gZK;
    private com.baidu.tieba.frs.d.b hgG;
    private ar hgk;
    private FrsFoldingView hyt;
    private com.baidu.tieba.frs.ad.g hyu;
    private boolean hyv;
    private List<View> hyw;
    private List<com.baidu.tieba.frs.view.d> hyx;
    private ArrayList<Boolean> hyy;
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
        this.hyv = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.hyw = new ArrayList();
        this.hyx = new ArrayList();
        this.topThreadList = new ArrayList();
        this.hgG = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.hyt = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.hyx.clear();
        this.hyw.clear();
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
                bVY();
                com.baidu.tieba.frs.view.d dVar = this.hyx.get(i2);
                if (dVar != null) {
                    if (this.gZK == null) {
                        this.gZK = new a();
                    }
                    dVar.d(this.gZK);
                    dVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.hyy == null && this.hyw != null) {
            this.hyy = new ArrayList<>(Collections.nCopies(this.hyw.size(), Boolean.FALSE));
        }
        bVZ();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.hyu == null) {
                this.hyu = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.hyu.getView());
            }
            this.hyu.a(this.dYX, iVar);
            if (!this.hyv) {
                this.hyv = true;
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
                if (this.dYX != null) {
                    anVar.cI("fid", this.dYX.getId());
                    anVar.cI("first_dir", this.dYX.getFirst_class());
                    anVar.cI("second_dir", this.dYX.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    anVar.cI("tid", iVar.getThreadId());
                    anVar.af("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    private void bVY() {
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
        this.hyw.add(adapterLinearLayout);
        this.hyx.add(dVar);
    }

    public void setStatListener(ar arVar) {
        this.hgk = arVar;
    }

    private void bVZ() {
        setVisibility(0);
        if (this.hyt != null) {
            this.hyt.setViews(this.hyw, this.hyx);
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.d dVar : this.hyx) {
            dVar.notifyDataSetChanged();
        }
        if (this.hyt != null) {
            this.hyt.onChangeSkinType();
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
                if (bjVar.aLB() == null || bjVar.aLB().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bjVar.aLo() != 1 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bjVar.aKR() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bjVar.aKR().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bjVar.aLM() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aLM = bjVar.aLM();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aLM.getCartoonId(), aLM.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aKL = bjVar.aKL();
                            if (aKL != null && !aKL.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aKL);
                                        xVar.aOy().aOZ().mIsNeedAddCommenParam = false;
                                        xVar.aOy().aOZ().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.aKz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aOY().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.dsB.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.aKk());
                            } else if (bdUniqueId.getId() == bj.dqZ.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cI("obj_type", "2");
                                anVar.cI("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.hgk != null) {
                                FrsTopView.this.hgk.an(bjVar);
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
        this.dYX = forumData;
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
            if (bjVar.dtz == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.dtz.id;
                str2 = valueOf;
            }
            if (bjVar.aLa() > 0 && com.baidu.tieba.tbadkCore.util.e.cXt()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aLa()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aLQ());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aLI() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.d dVar : this.hyx) {
            if (str != null) {
                dVar.setImageUrl(str);
                this.url = str;
            }
            dVar.vn(i);
            dVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }
}
