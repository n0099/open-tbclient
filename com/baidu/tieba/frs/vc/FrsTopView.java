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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsTopView extends LinearLayout {
    private ForumData fkv;
    private ab iDd;
    private az iKR;
    private com.baidu.tieba.frs.d.b iLo;
    private FrsFoldingView jei;
    private com.baidu.tieba.frs.ad.g jej;
    private boolean jek;
    private List<View> jel;
    private List<com.baidu.tieba.frs.view.g> jem;
    private ArrayList<Boolean> jen;
    private BdUniqueId mBdUniqueId;
    private String mForumId;
    private String mForumName;
    private int textColor;
    private List<q> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jek = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.jel = new ArrayList();
        this.jem = new ArrayList();
        this.topThreadList = new ArrayList();
        this.iLo = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jei = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<q> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jem.clear();
        this.jel.clear();
        if (y.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!y.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                cDY();
                com.baidu.tieba.frs.view.g gVar = this.jem.get(i2);
                if (gVar != null) {
                    if (this.iDd == null) {
                        this.iDd = new a();
                    }
                    gVar.d(this.iDd);
                    gVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jen == null && this.jel != null) {
            this.jen = new ArrayList<>(Collections.nCopies(this.jel.size(), Boolean.FALSE));
        }
        cDZ();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jej == null) {
                this.jej = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jej.getView());
            }
            this.jej.a(this.fkv, iVar);
            if (!this.jek) {
                this.jek = true;
                aq aqVar = new aq("common_exp");
                aqVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dR("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                aqVar.aj("obj_floor", 1);
                aqVar.aj("obj_adlocate", i);
                aqVar.w("obj_id", iVar.getId());
                if (this.fkv != null) {
                    aqVar.dR("fid", this.fkv.getId());
                    aqVar.dR("first_dir", this.fkv.getFirst_class());
                    aqVar.dR("second_dir", this.fkv.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    aqVar.dR("tid", iVar.getThreadId());
                    aqVar.aj("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void cDY() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.g gVar = new com.baidu.tieba.frs.view.g(getContext());
        gVar.fj(this.mForumId, this.mForumName);
        gVar.a(this.fkv);
        gVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            gVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            gVar.AK(this.textColor);
        }
        adapterLinearLayout.setAdapter(gVar);
        this.jel.add(adapterLinearLayout);
        this.jem.add(gVar);
    }

    public void setStatListener(az azVar) {
        this.iKR = azVar;
    }

    private void cDZ() {
        if (!y.isEmpty(this.jel)) {
            setVisibility(0);
            if (this.jei != null) {
                this.jei.setViews(this.jel, this.jem);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.g gVar : this.jem) {
            gVar.notifyDataSetChanged();
        }
        if (this.jei != null) {
            this.jei.onChangeSkinType();
        }
    }

    /* loaded from: classes22.dex */
    private final class a implements ab {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bw)) {
                bw bwVar = (bw) qVar;
                if (bwVar.bla() == null || bwVar.bla().getGroup_id() == 0 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bwVar.bkN() != 1 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bwVar.bkm() != null) {
                            if (bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bwVar.bkm().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bwVar.bll() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bg.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            r bll = bwVar.bll();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bll.getCartoonId(), bll.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String bkg = bwVar.bkg();
                            if (bkg != null && !bkg.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bkg);
                                        aaVar.bon().boT().mIsNeedAddCommenParam = false;
                                        aaVar.bon().boT().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bwVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bwVar.bjV() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.boR().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bwVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bw.ezL.getId()) {
                                com.baidu.tieba.frs.f.j.a(bwVar.bjG());
                            } else if (bdUniqueId.getId() == bw.eyl.getId()) {
                                aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                aqVar.dR("obj_type", "2");
                                aqVar.dR("tid", bwVar.getTid());
                                TiebaStatic.log(aqVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bwVar, i, z);
                            if (FrsTopView.this.iKR != null) {
                                FrsTopView.this.iKR.am(bwVar);
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
        this.fkv = forumData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bw bwVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bwVar != null) {
            String valueOf = String.valueOf(bwVar.getFid());
            if (bwVar.eAJ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bwVar.eAJ.id;
                str2 = valueOf;
            }
            if (bwVar.bkx() > 0 && com.baidu.tieba.tbadkCore.util.e.dID()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bwVar.getTid(), String.valueOf(bwVar.bkx()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bwVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bwVar.blp());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bwVar.blh() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.g gVar : this.jem) {
            if (str != null) {
                gVar.setImageUrl(str);
                this.url = str;
            }
            gVar.AK(i);
            gVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }
}
