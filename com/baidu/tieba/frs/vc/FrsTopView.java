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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsTopView extends LinearLayout {
    private ForumData fpv;
    private ab iJO;
    private az iRB;
    private com.baidu.tieba.frs.d.b iRY;
    private FrsFoldingView jkQ;
    private com.baidu.tieba.frs.ad.g jkR;
    private boolean jkS;
    private List<View> jkT;
    private List<com.baidu.tieba.frs.view.g> jkU;
    private ArrayList<Boolean> jkV;
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
        this.jkS = false;
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.jkT = new ArrayList();
        this.jkU = new ArrayList();
        this.topThreadList = new ArrayList();
        this.iRY = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jkQ = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<q> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jkU.clear();
        this.jkT.clear();
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
                cGe();
                com.baidu.tieba.frs.view.g gVar = this.jkU.get(i2);
                if (gVar != null) {
                    if (this.iJO == null) {
                        this.iJO = new a();
                    }
                    gVar.d(this.iJO);
                    gVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jkV == null && this.jkT != null) {
            this.jkV = new ArrayList<>(Collections.nCopies(this.jkT.size(), Boolean.FALSE));
        }
        cGf();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jkR == null) {
                this.jkR = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jkR.getView());
            }
            this.jkR.a(this.fpv, iVar);
            if (!this.jkS) {
                this.jkS = true;
                ar arVar = new ar("common_exp");
                arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dR("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                arVar.ak("obj_floor", 1);
                arVar.ak("obj_adlocate", i);
                arVar.w("obj_id", iVar.getId());
                if (this.fpv != null) {
                    arVar.dR("fid", this.fpv.getId());
                    arVar.dR("first_dir", this.fpv.getFirst_class());
                    arVar.dR("second_dir", this.fpv.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    arVar.dR("tid", iVar.getThreadId());
                    arVar.ak("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(arVar);
            }
        }
    }

    private void cGe() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.g gVar = new com.baidu.tieba.frs.view.g(getContext());
        gVar.fj(this.mForumId, this.mForumName);
        gVar.a(this.fpv);
        gVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            gVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            gVar.Bv(this.textColor);
        }
        adapterLinearLayout.setAdapter(gVar);
        this.jkT.add(adapterLinearLayout);
        this.jkU.add(gVar);
    }

    public void setStatListener(az azVar) {
        this.iRB = azVar;
    }

    private void cGf() {
        if (!y.isEmpty(this.jkT)) {
            setVisibility(0);
            if (this.jkQ != null) {
                this.jkQ.setViews(this.jkT, this.jkU);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.g gVar : this.jkU) {
            gVar.notifyDataSetChanged();
        }
        if (this.jkQ != null) {
            this.jkQ.onChangeSkinType();
        }
    }

    /* loaded from: classes21.dex */
    private final class a implements ab {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bx)) {
                bx bxVar = (bx) qVar;
                if (bxVar.bmE() == null || bxVar.bmE().getGroup_id() == 0 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (bxVar.bmp() != 1 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bxVar.blO() != null) {
                            if (bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String postUrl = bxVar.blO().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                }
                            }
                        } else if (bxVar.bmP() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bh.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            s bmP = bxVar.bmP();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bmP.getCartoonId(), bmP.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String blI = bxVar.blI();
                            if (blI != null && !blI.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(blI);
                                        aaVar.bqa().bqH().mIsNeedAddCommenParam = false;
                                        aaVar.bqa().bqH().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bxVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bxVar.blx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bf.bqF().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                bxVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bx.eDS.getId()) {
                                com.baidu.tieba.frs.f.j.a(bxVar.bli());
                            } else if (bdUniqueId.getId() == bx.eCt.getId()) {
                                ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                arVar.dR("obj_type", "2");
                                arVar.dR("tid", bxVar.getTid());
                                TiebaStatic.log(arVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bxVar, i, z);
                            if (FrsTopView.this.iRB != null) {
                                FrsTopView.this.iRB.ao(bxVar);
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
        this.fpv = forumData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bx bxVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bxVar != null) {
            String valueOf = String.valueOf(bxVar.getFid());
            if (bxVar.eEQ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bxVar.eEQ.id;
                str2 = valueOf;
            }
            if (bxVar.blZ() > 0 && com.baidu.tieba.tbadkCore.util.e.dLe()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bxVar.getTid(), String.valueOf(bxVar.blZ()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bxVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bxVar.bmT());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bxVar.bmL() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.g gVar : this.jkU) {
            if (str != null) {
                gVar.setImageUrl(str);
                this.url = str;
            }
            gVar.Bv(i);
            gVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
