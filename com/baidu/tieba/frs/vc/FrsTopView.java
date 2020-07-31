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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsTopView extends LinearLayout {
    private ForumData eCv;
    private z hHk;
    private com.baidu.tieba.frs.d.b hOE;
    private ax hOh;
    private FrsFoldingView ihn;
    private com.baidu.tieba.frs.ad.f iho;
    private boolean ihp;
    private List<View> ihq;
    private List<com.baidu.tieba.frs.view.g> ihr;
    private ArrayList<Boolean> ihs;
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
        this.ihp = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.ihq = new ArrayList();
        this.ihr = new ArrayList();
        this.topThreadList = new ArrayList();
        this.hOE = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.ihn = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<q> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.ihr.clear();
        this.ihq.clear();
        if (x.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!x.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                cjw();
                com.baidu.tieba.frs.view.g gVar = this.ihr.get(i2);
                if (gVar != null) {
                    if (this.hHk == null) {
                        this.hHk = new a();
                    }
                    gVar.d(this.hHk);
                    gVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.ihs == null && this.ihq != null) {
            this.ihs = new ArrayList<>(Collections.nCopies(this.ihq.size(), Boolean.FALSE));
        }
        cjx();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.iho == null) {
                this.iho = new com.baidu.tieba.frs.ad.f(getContext());
                addView(this.iho.getView());
            }
            this.iho.a(this.eCv, iVar);
            if (!this.ihp) {
                this.ihp = true;
                ap apVar = new ap("common_exp");
                apVar.dn("page_type", PageStayDurationConstants.PageName.FRS);
                apVar.dn("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                apVar.ah("obj_floor", 1);
                apVar.ah("obj_adlocate", i);
                apVar.t("obj_id", iVar.getId());
                if (this.eCv != null) {
                    apVar.dn("fid", this.eCv.getId());
                    apVar.dn("first_dir", this.eCv.getFirst_class());
                    apVar.dn("second_dir", this.eCv.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    apVar.dn("tid", iVar.getThreadId());
                    apVar.ah("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(apVar);
            }
        }
    }

    private void cjw() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.g gVar = new com.baidu.tieba.frs.view.g(getContext());
        gVar.es(this.mForumId, this.mForumName);
        gVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            gVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            gVar.wT(this.textColor);
        }
        adapterLinearLayout.setAdapter(gVar);
        this.ihq.add(adapterLinearLayout);
        this.ihr.add(gVar);
    }

    public void setStatListener(ax axVar) {
        this.hOh = axVar;
    }

    private void cjx() {
        setVisibility(0);
        if (this.ihn != null) {
            this.ihn.setViews(this.ihq, this.ihr);
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.g gVar : this.ihr) {
            gVar.notifyDataSetChanged();
        }
        if (this.ihn != null) {
            this.ihn.onChangeSkinType();
        }
    }

    /* loaded from: classes16.dex */
    private final class a implements z {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bv bvVar = (bv) qVar;
                if (bvVar.aXl() == null || bvVar.aXl().getGroup_id() == 0 || bf.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bvVar.aWY() != 1 || bf.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bvVar.aWx() != null) {
                            if (bf.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bvVar.aWx().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bvVar.aXw() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bf.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            r aXw = bvVar.aXw();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aXw.getCartoonId(), aXw.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aWr = bvVar.aWr();
                            if (aWr != null && !aWr.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(aWr);
                                        zVar.bav().baW().mIsNeedAddCommenParam = false;
                                        zVar.bav().baW().mIsUseCurrentBDUSS = false;
                                        zVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bvVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bvVar.aWg() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bd.baV().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bvVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bv.dTv.getId()) {
                                com.baidu.tieba.frs.f.h.a(bvVar.aVR());
                            } else if (bdUniqueId.getId() == bv.dRW.getId()) {
                                ap apVar = new ap(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                apVar.dn("obj_type", "2");
                                apVar.dn("tid", bvVar.getTid());
                                TiebaStatic.log(apVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bvVar, i, z);
                            if (FrsTopView.this.hOh != null) {
                                FrsTopView.this.hOh.al(bvVar);
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
        this.eCv = forumData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bv bvVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bvVar != null) {
            String valueOf = String.valueOf(bvVar.getFid());
            if (bvVar.dUt == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bvVar.dUt.id;
                str2 = valueOf;
            }
            if (bvVar.aWI() > 0 && com.baidu.tieba.tbadkCore.util.e.dmp()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bvVar.getTid(), String.valueOf(bvVar.aWI()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bvVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bvVar.aXA());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bvVar.aXs() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.g gVar : this.ihr) {
            if (str != null) {
                gVar.setImageUrl(str);
                this.url = str;
            }
            gVar.wT(i);
            gVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOE;
    }
}
