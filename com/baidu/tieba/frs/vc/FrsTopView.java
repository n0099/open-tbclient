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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsTopView extends LinearLayout {
    private ForumData dyP;
    private FrsTabViewPager gMW;
    private TbTabLayout gMX;
    private List<View> gMY;
    private List<com.baidu.tieba.frs.view.e> gMZ;
    private CommonViewPagerAdapter gNa;
    private ArrayList<Boolean> gNb;
    private com.baidu.tieba.frs.ad.g gNc;
    private boolean gNd;
    private s gpD;
    private am gwd;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
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
        this.mForumName = "";
        this.mForumId = "";
        this.textColor = 0;
        this.url = null;
        this.gMY = new ArrayList();
        this.gMZ = new ArrayList();
        this.topThreadList = new ArrayList();
        this.gNd = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.gMW = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.gMX = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.gMX.setTabMode(1);
    }

    private void bLb() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(R.dimen.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.dw(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.uI(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.gMY.add(linearLayout);
        this.gMZ.add(eVar);
    }

    public void onPrimary(boolean z) {
        if (this.gNc != null) {
            this.gNc.onPrimary(z);
        }
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.h hVar) {
        int i = 0;
        this.topThreadList.clear();
        this.gMZ.clear();
        this.gMY.clear();
        if (v.isEmpty(list) && hVar == null) {
            setVisibility(8);
            return;
        }
        if (hVar != null) {
            a(hVar);
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
                bLb();
                com.baidu.tieba.frs.view.e eVar = this.gMZ.get(i2);
                if (eVar != null) {
                    if (this.gpD == null) {
                        this.gpD = new a();
                    }
                    eVar.d(this.gpD);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        if (this.gNb == null && this.gMY != null) {
            this.gNb = new ArrayList<>(Collections.nCopies(this.gMY.size(), Boolean.FALSE));
        }
        bLc();
    }

    public void onChangeSkinType(int i) {
        if (this.gNc != null) {
            this.gNc.onChangeSkinType(i);
        }
        if (this.gMX != null) {
            this.gMX.setSelectedTabIndicatorColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_b));
            this.gMX.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds3), com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_a)));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < (this.topThreadList.size() + 1) / 2) {
                com.baidu.tieba.frs.view.e eVar = this.gMZ.get(i3);
                if (eVar != null) {
                    eVar.notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.h hVar) {
        int i = 6;
        if (hVar != null) {
            if (this.gNc == null) {
                this.gNc = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.gNc.a(this.dyP, hVar);
            this.gMY.add(this.gNc.getView());
            if (!this.gNd) {
                this.gNd = true;
                an anVar = new an("common_exp");
                anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cy("obj_isad", "1");
                if (hVar.getType() != 1) {
                    if (hVar.getType() == 2) {
                        i = 7;
                    } else if (hVar.getType() == 3) {
                        i = 8;
                    }
                }
                anVar.X("obj_floor", 1);
                anVar.X("obj_adlocate", i);
                anVar.s("obj_id", hVar.getId());
                if (this.dyP != null) {
                    anVar.cy("fid", this.dyP.getId());
                    anVar.cy("first_dir", this.dyP.getFirst_class());
                    anVar.cy("second_dir", this.dyP.getSecond_class());
                }
                if (hVar.getType() == 1) {
                    anVar.cy("tid", hVar.getThreadId());
                    anVar.X("thread_type", hVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    public void setStatListener(am amVar) {
        this.gwd = amVar;
    }

    private void bLc() {
        setVisibility(0);
        this.gMX.setVisibility(this.gMY.size() > 1 ? 0 : 8);
        if (this.gNa == null) {
            this.gNa = new CommonViewPagerAdapter(this.gMY);
            this.gMW.setAdapter(this.gNa);
            this.gMX.removeAllTabs();
            for (int i = 0; i < this.gMY.size(); i++) {
                this.gMX.a(this.gMX.kD());
            }
            this.gMX.setupWithViewPager(this.gMW, true);
            return;
        }
        this.gNa.cs(this.gMY);
    }

    /* loaded from: classes9.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> gNe;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.gNe = list;
        }

        public void cs(List<? extends View> list) {
            this.gNe = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gNe.size();
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
            View view = this.gNe.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.gNc != null) {
                i--;
            }
            if (i >= 0 && FrsTopView.this.gNb != null && v.getItem(FrsTopView.this.gNb, i) == Boolean.FALSE && FrsTopView.this.gMZ != null && FrsTopView.this.topThreadList != null && FrsTopView.this.gMZ.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.gMZ.get(i);
                List<com.baidu.adp.widget.ListView.m> subList = FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1);
                TbPageTag ed = com.baidu.tbadk.pageInfo.c.ed(FrsTopView.this.mContext);
                for (com.baidu.adp.widget.ListView.m mVar : subList) {
                    if (mVar instanceof bj) {
                        com.baidu.tieba.frs.d.c.bJH().a(eVar.bGV(), (bj) mVar);
                        com.baidu.tieba.frs.d.a.a((bj) mVar, FrsTopView.this.mBdUniqueId, eVar.bGV(), 0, ed);
                    }
                }
                FrsTopView.this.gNb.set(i, Boolean.TRUE);
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

    /* loaded from: classes9.dex */
    private final class a implements s {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bj)) {
                bj bjVar = (bj) mVar;
                if (bjVar.aDj() == null || bjVar.aDj().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                    if (bjVar.aCW() != 1 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                        if (bjVar.aCz() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                                String postUrl = bjVar.aCz().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bjVar.aDt() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aDt = bjVar.aDt();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aDt.getCartoonId(), aDt.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aCt = bjVar.aCt();
                            if (aCt != null && !aCt.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCt);
                                        xVar.aGe().aGF().mIsNeedAddCommenParam = false;
                                        xVar.aGe().aGF().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.aCh() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGE().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.cTc.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.aBS());
                            } else if (bdUniqueId.getId() == bj.cRC.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cy("obj_type", "2");
                                anVar.cy("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.gwd != null) {
                                FrsTopView.this.gwd.ak(bjVar);
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

    public void setForum(String str, String str2, ForumData forumData) {
        this.mForumId = str;
        this.mForumName = str2;
        this.dyP = forumData;
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
            if (bjVar.cTZ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.cTZ.id;
                str2 = valueOf;
            }
            if (bjVar.aCI() > 0 && com.baidu.tieba.tbadkCore.util.e.cMa()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aCI()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aDx());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aDp() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.gMZ) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.uI(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gNc != null) {
            this.gNc.onDestroy();
        }
    }
}
