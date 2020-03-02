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
    private ForumData dyQ;
    private FrsTabViewPager gMY;
    private TbTabLayout gMZ;
    private List<View> gNa;
    private List<com.baidu.tieba.frs.view.e> gNb;
    private CommonViewPagerAdapter gNc;
    private ArrayList<Boolean> gNd;
    private com.baidu.tieba.frs.ad.g gNe;
    private boolean gNf;
    private s gpF;
    private am gwf;
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
        this.gNa = new ArrayList();
        this.gNb = new ArrayList();
        this.topThreadList = new ArrayList();
        this.gNf = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.gMY = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.gMZ = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.gMZ.setTabMode(1);
    }

    private void bLd() {
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
        this.gNa.add(linearLayout);
        this.gNb.add(eVar);
    }

    public void onPrimary(boolean z) {
        if (this.gNe != null) {
            this.gNe.onPrimary(z);
        }
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.h hVar) {
        int i = 0;
        this.topThreadList.clear();
        this.gNb.clear();
        this.gNa.clear();
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
                bLd();
                com.baidu.tieba.frs.view.e eVar = this.gNb.get(i2);
                if (eVar != null) {
                    if (this.gpF == null) {
                        this.gpF = new a();
                    }
                    eVar.d(this.gpF);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        if (this.gNd == null && this.gNa != null) {
            this.gNd = new ArrayList<>(Collections.nCopies(this.gNa.size(), Boolean.FALSE));
        }
        bLe();
    }

    public void onChangeSkinType(int i) {
        if (this.gNe != null) {
            this.gNe.onChangeSkinType(i);
        }
        if (this.gMZ != null) {
            this.gMZ.setSelectedTabIndicatorColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_b));
            this.gMZ.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds3), com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_a)));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < (this.topThreadList.size() + 1) / 2) {
                com.baidu.tieba.frs.view.e eVar = this.gNb.get(i3);
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
            if (this.gNe == null) {
                this.gNe = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.gNe.a(this.dyQ, hVar);
            this.gNa.add(this.gNe.getView());
            if (!this.gNf) {
                this.gNf = true;
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
                if (this.dyQ != null) {
                    anVar.cy("fid", this.dyQ.getId());
                    anVar.cy("first_dir", this.dyQ.getFirst_class());
                    anVar.cy("second_dir", this.dyQ.getSecond_class());
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
        this.gwf = amVar;
    }

    private void bLe() {
        setVisibility(0);
        this.gMZ.setVisibility(this.gNa.size() > 1 ? 0 : 8);
        if (this.gNc == null) {
            this.gNc = new CommonViewPagerAdapter(this.gNa);
            this.gMY.setAdapter(this.gNc);
            this.gMZ.removeAllTabs();
            for (int i = 0; i < this.gNa.size(); i++) {
                this.gMZ.a(this.gMZ.kD());
            }
            this.gMZ.setupWithViewPager(this.gMY, true);
            return;
        }
        this.gNc.cs(this.gNa);
    }

    /* loaded from: classes9.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> gNg;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.gNg = list;
        }

        public void cs(List<? extends View> list) {
            this.gNg = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gNg.size();
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
            View view = this.gNg.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.gNe != null) {
                i--;
            }
            if (i >= 0 && FrsTopView.this.gNd != null && v.getItem(FrsTopView.this.gNd, i) == Boolean.FALSE && FrsTopView.this.gNb != null && FrsTopView.this.topThreadList != null && FrsTopView.this.gNb.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.gNb.get(i);
                List<com.baidu.adp.widget.ListView.m> subList = FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1);
                TbPageTag ed = com.baidu.tbadk.pageInfo.c.ed(FrsTopView.this.mContext);
                for (com.baidu.adp.widget.ListView.m mVar : subList) {
                    if (mVar instanceof bj) {
                        com.baidu.tieba.frs.d.c.bJJ().a(eVar.bGX(), (bj) mVar);
                        com.baidu.tieba.frs.d.a.a((bj) mVar, FrsTopView.this.mBdUniqueId, eVar.bGX(), 0, ed);
                    }
                }
                FrsTopView.this.gNd.set(i, Boolean.TRUE);
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
                if (bjVar.aDl() == null || bjVar.aDl().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                    if (bjVar.aCY() != 1 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                        if (bjVar.aCB() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                                String postUrl = bjVar.aCB().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bjVar.aDv() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aDv = bjVar.aDv();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aDv.getCartoonId(), aDv.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aCv = bjVar.aCv();
                            if (aCv != null && !aCv.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCv);
                                        xVar.aGg().aGH().mIsNeedAddCommenParam = false;
                                        xVar.aGg().aGH().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.aCj() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGG().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.cTd.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.aBU());
                            } else if (bdUniqueId.getId() == bj.cRD.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cy("obj_type", "2");
                                anVar.cy("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.gwf != null) {
                                FrsTopView.this.gwf.ak(bjVar);
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
        this.dyQ = forumData;
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
            if (bjVar.cUa == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.cUa.id;
                str2 = valueOf;
            }
            if (bjVar.aCK() > 0 && com.baidu.tieba.tbadkCore.util.e.cMc()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aCK()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aDz());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aDr() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.gNb) {
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
        if (this.gNe != null) {
            this.gNe.onDestroy();
        }
    }
}
