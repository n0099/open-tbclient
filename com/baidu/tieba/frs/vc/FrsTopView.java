package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.design.TbTabLayout;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {
    private al fDz;
    private FrsTabViewPager fUc;
    private TbTabLayout fUd;
    private List<View> fUe;
    private List<com.baidu.tieba.frs.view.e> fUf;
    private CommonViewPagerAdapter fUg;
    private ArrayList<Boolean> fUh;
    private com.baidu.tieba.frs.ad.g fUi;
    private boolean fUj;
    private s fwO;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private int textColor;
    private List<m> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.fUe = new ArrayList();
        this.fUf = new ArrayList();
        this.topThreadList = new ArrayList();
        this.fUh = new ArrayList<>(Collections.nCopies(3, Boolean.FALSE));
        this.fUj = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.fUc = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.fUd = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.fUd.setTabMode(1);
    }

    private void bqZ() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(R.dimen.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.setForum(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.sq(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.fUe.add(linearLayout);
        this.fUf.add(eVar);
    }

    public void jJ(boolean z) {
        if (this.fUi != null) {
            this.fUi.jJ(z);
        }
    }

    public void setDatas(List<m> list, com.baidu.tieba.tbadkCore.h hVar) {
        int i = 0;
        this.topThreadList.clear();
        this.fUf.clear();
        this.fUe.clear();
        if (v.isEmpty(list) && hVar == null) {
            setVisibility(8);
            return;
        }
        if (hVar != null) {
            b(hVar);
        }
        if (!v.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            while (true) {
                int i2 = i;
                if (i2 >= (this.topThreadList.size() + 1) / 2) {
                    break;
                }
                bqZ();
                com.baidu.tieba.frs.view.e eVar = this.fUf.get(i2);
                if (eVar != null) {
                    if (this.fwO == null) {
                        this.fwO = new a();
                    }
                    eVar.d(this.fwO);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        bra();
    }

    public void onChangeSkinType(int i) {
        if (this.fUi != null) {
            this.fUi.onChangeSkinType(i);
        }
        if (this.fUd != null) {
            this.fUd.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
            this.fUd.setBackgroundDrawable(am.ab(l.getDimens(this.mContext, R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        }
    }

    private void b(com.baidu.tieba.tbadkCore.h hVar) {
        if (hVar != null) {
            if (this.fUi == null) {
                this.fUi = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.fUi.a(hVar);
            this.fUe.add(this.fUi.getView());
            if (!this.fUj) {
                this.fUj = true;
                an anVar = new an("common_exp");
                anVar.bS("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.bS("obj_isad", "1");
                String str = "6";
                if (hVar.getType() == 1) {
                    str = "6";
                } else if (hVar.getType() == 2) {
                    str = "7";
                } else if (hVar.getType() == 3) {
                    str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                }
                anVar.bS("obj_adlocate", str);
                anVar.p("obj_id", hVar.getId());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void setStatListener(al alVar) {
        this.fDz = alVar;
    }

    private void bra() {
        setVisibility(0);
        this.fUd.setVisibility(this.fUe.size() > 1 ? 0 : 8);
        if (this.fUg == null) {
            this.fUg = new CommonViewPagerAdapter(this.fUe);
            this.fUc.setAdapter(this.fUg);
            this.fUd.removeAllTabs();
            for (int i = 0; i < this.fUe.size(); i++) {
                this.fUd.a(this.fUd.jW());
            }
            this.fUd.setupWithViewPager(this.fUc, true);
            return;
        }
        this.fUg.cA(this.fUe);
    }

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> fUk;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.fUk = list;
        }

        public void cA(List<? extends View> list) {
            this.fUk = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fUk.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.fUk.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.fUh != null && FrsTopView.this.fUh.get(i) == Boolean.FALSE && FrsTopView.this.fUf != null && FrsTopView.this.topThreadList != null && FrsTopView.this.fUf.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.fUf.get(i);
                for (m mVar : FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1)) {
                    if (mVar instanceof bh) {
                        com.baidu.tieba.frs.d.c.bpJ().a(eVar.bmX(), (bh) mVar);
                        com.baidu.tieba.frs.d.a.a((bh) mVar, FrsTopView.this.mBdUniqueId, eVar.bmX(), 0);
                    }
                }
                FrsTopView.this.fUh.set(i, Boolean.TRUE);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return "";
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements s {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bh)) {
                bh bhVar = (bh) mVar;
                if (bhVar.ajy() == null || bhVar.ajy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                    if (bhVar.ajq() != 1 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                        if (bhVar.aiT() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                                String postUrl = bhVar.aiT().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bhVar.ajJ() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            o ajJ = bhVar.ajJ();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), ajJ.getCartoonId(), ajJ.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aiN = bhVar.aiN();
                            if (aiN != null && !aiN.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aiN);
                                        xVar.amr().amR().mIsNeedAddCommenParam = false;
                                        xVar.amr().amR().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bhVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bhVar.aiB() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.amQ().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bhVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bh.cdh.getId()) {
                                com.baidu.tieba.frs.f.h.a(bhVar.aim());
                            } else if (bdUniqueId.getId() == bh.cbM.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.bS("obj_type", "2");
                                anVar.bS("tid", bhVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bhVar, i, z);
                            if (FrsTopView.this.fDz != null) {
                                FrsTopView.this.fDz.ab(bhVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragmentActivity getFragmentActivity() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return (BaseFragmentActivity) this.mContext;
        }
        return null;
    }

    public void setForum(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bh bhVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bhVar != null) {
            String valueOf = String.valueOf(bhVar.getFid());
            if (bhVar.cem == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bhVar.cem.id;
                str2 = valueOf;
            }
            if (bhVar.ajc() > 0 && com.baidu.tieba.tbadkCore.util.e.cps()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bhVar.getTid(), String.valueOf(bhVar.ajc()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bhVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bhVar.ajO());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bhVar.ajF() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.fUf) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.sq(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fUi != null) {
            this.fUi.onDestroy();
        }
    }
}
