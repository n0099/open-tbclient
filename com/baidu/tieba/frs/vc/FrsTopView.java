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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsTopView extends LinearLayout {
    private ForumData enm;
    private FrsFoldingView hNm;
    private com.baidu.tieba.frs.ad.g hNn;
    private boolean hNo;
    private List<View> hNp;
    private List<com.baidu.tieba.frs.view.d> hNq;
    private ArrayList<Boolean> hNr;
    private x hoE;
    private com.baidu.tieba.frs.d.b hvA;
    private ar hve;
    private BdUniqueId mBdUniqueId;
    private String mForumId;
    private String mForumName;
    private int textColor;
    private List<o> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNo = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.hNp = new ArrayList();
        this.hNq = new ArrayList();
        this.topThreadList = new ArrayList();
        this.hvA = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.hNm = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<o> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.hNq.clear();
        this.hNp.clear();
        if (v.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!v.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                ccv();
                com.baidu.tieba.frs.view.d dVar = this.hNq.get(i2);
                if (dVar != null) {
                    if (this.hoE == null) {
                        this.hoE = new a();
                    }
                    dVar.d(this.hoE);
                    dVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.hNr == null && this.hNp != null) {
            this.hNr = new ArrayList<>(Collections.nCopies(this.hNp.size(), Boolean.FALSE));
        }
        ccw();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.hNn == null) {
                this.hNn = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.hNn.getView());
            }
            this.hNn.a(this.enm, iVar);
            if (!this.hNo) {
                this.hNo = true;
                an anVar = new an("common_exp");
                anVar.dh("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.dh("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                anVar.ag("obj_floor", 1);
                anVar.ag("obj_adlocate", i);
                anVar.s("obj_id", iVar.getId());
                if (this.enm != null) {
                    anVar.dh("fid", this.enm.getId());
                    anVar.dh("first_dir", this.enm.getFirst_class());
                    anVar.dh("second_dir", this.enm.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    anVar.dh("tid", iVar.getThreadId());
                    anVar.ag("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    private void ccv() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(getContext());
        dVar.ek(this.mForumId, this.mForumName);
        dVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            dVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            dVar.vT(this.textColor);
        }
        adapterLinearLayout.setAdapter(dVar);
        this.hNp.add(adapterLinearLayout);
        this.hNq.add(dVar);
    }

    public void setStatListener(ar arVar) {
        this.hve = arVar;
    }

    private void ccw() {
        setVisibility(0);
        if (this.hNm != null) {
            this.hNm.setViews(this.hNp, this.hNq);
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.d dVar : this.hNq) {
            dVar.notifyDataSetChanged();
        }
        if (this.hNm != null) {
            this.hNm.onChangeSkinType();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements x {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && oVar != null && (oVar instanceof bk)) {
                bk bkVar = (bk) oVar;
                if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bkVar.aQK() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bkVar.aQK().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bkVar.aRJ() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            com.baidu.tbadk.core.data.o aRJ = bkVar.aRJ();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aRJ.getCartoonId(), aRJ.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aQE = bkVar.aQE();
                            if (aQE != null && !aQE.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                        xVar.aUA().aVa().mIsNeedAddCommenParam = false;
                                        xVar.aUA().aVa().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bkVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bkVar.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aUZ().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bkVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bk.dGz.getId()) {
                                com.baidu.tieba.frs.f.h.a(bkVar.aQd());
                            } else if (bdUniqueId.getId() == bk.dEZ.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.dh("obj_type", "2");
                                anVar.dh("tid", bkVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bkVar, i, z);
                            if (FrsTopView.this.hve != null) {
                                FrsTopView.this.hve.ao(bkVar);
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
        this.enm = forumData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bk bkVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bkVar != null) {
            String valueOf = String.valueOf(bkVar.getFid());
            if (bkVar.dHw == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bkVar.dHw.id;
                str2 = valueOf;
            }
            if (bkVar.aQV() > 0 && com.baidu.tieba.tbadkCore.util.e.deF()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bkVar.getTid(), String.valueOf(bkVar.aQV()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bkVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bkVar.aRN());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bkVar.aRF() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.d dVar : this.hNq) {
            if (str != null) {
                dVar.setImageUrl(str);
                this.url = str;
            }
            dVar.vT(i);
            dVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
    }
}
