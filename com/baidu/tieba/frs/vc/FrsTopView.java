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
/* loaded from: classes7.dex */
public class FrsTopView extends LinearLayout {
    private ForumData duJ;
    private FrsTabViewPager gKX;
    private TbTabLayout gKY;
    private List<View> gKZ;
    private List<com.baidu.tieba.frs.view.e> gLa;
    private CommonViewPagerAdapter gLb;
    private ArrayList<Boolean> gLc;
    private com.baidu.tieba.frs.ad.g gLd;
    private boolean gLe;
    private s gnC;
    private am guc;
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
        this.gKZ = new ArrayList();
        this.gLa = new ArrayList();
        this.topThreadList = new ArrayList();
        this.gLe = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.gKX = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.gKY = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.gKY.setTabMode(1);
    }

    private void bJA() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(R.dimen.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.dn(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.uC(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.gKZ.add(linearLayout);
        this.gLa.add(eVar);
    }

    public void lg(boolean z) {
        if (this.gLd != null) {
            this.gLd.lg(z);
        }
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.h hVar) {
        int i = 0;
        this.topThreadList.clear();
        this.gLa.clear();
        this.gKZ.clear();
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
                bJA();
                com.baidu.tieba.frs.view.e eVar = this.gLa.get(i2);
                if (eVar != null) {
                    if (this.gnC == null) {
                        this.gnC = new a();
                    }
                    eVar.d(this.gnC);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        if (this.gLc == null && this.gKZ != null) {
            this.gLc = new ArrayList<>(Collections.nCopies(this.gKZ.size(), Boolean.FALSE));
        }
        bJB();
    }

    public void onChangeSkinType(int i) {
        if (this.gLd != null) {
            this.gLd.onChangeSkinType(i);
        }
        if (this.gKY != null) {
            this.gKY.setSelectedTabIndicatorColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_b));
            this.gKY.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds3), com.baidu.tbadk.core.util.am.getColor(R.color.cp_indicator_a)));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < (this.topThreadList.size() + 1) / 2) {
                com.baidu.tieba.frs.view.e eVar = this.gLa.get(i3);
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
            if (this.gLd == null) {
                this.gLd = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.gLd.a(this.duJ, hVar);
            this.gKZ.add(this.gLd.getView());
            if (!this.gLe) {
                this.gLe = true;
                an anVar = new an("common_exp");
                anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cp("obj_isad", "1");
                if (hVar.getType() != 1) {
                    if (hVar.getType() == 2) {
                        i = 7;
                    } else if (hVar.getType() == 3) {
                        i = 8;
                    }
                }
                anVar.Z("obj_floor", 1);
                anVar.Z("obj_adlocate", i);
                anVar.s("obj_id", hVar.getId());
                if (this.duJ != null) {
                    anVar.cp("fid", this.duJ.getId());
                    anVar.cp("first_dir", this.duJ.getFirst_class());
                    anVar.cp("second_dir", this.duJ.getSecond_class());
                }
                if (hVar.getType() == 1) {
                    anVar.cp("tid", hVar.getThreadId());
                    anVar.Z("thread_type", hVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    public void setStatListener(am amVar) {
        this.guc = amVar;
    }

    private void bJB() {
        setVisibility(0);
        this.gKY.setVisibility(this.gKZ.size() > 1 ? 0 : 8);
        if (this.gLb == null) {
            this.gLb = new CommonViewPagerAdapter(this.gKZ);
            this.gKX.setAdapter(this.gLb);
            this.gKY.removeAllTabs();
            for (int i = 0; i < this.gKZ.size(); i++) {
                this.gKY.a(this.gKY.ko());
            }
            this.gKY.setupWithViewPager(this.gKX, true);
            return;
        }
        this.gLb.cw(this.gKZ);
    }

    /* loaded from: classes7.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> gLf;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.gLf = list;
        }

        public void cw(List<? extends View> list) {
            this.gLf = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gLf.size();
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
            View view = this.gLf.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.gLd != null) {
                i--;
            }
            if (i >= 0 && FrsTopView.this.gLc != null && v.getItem(FrsTopView.this.gLc, i) == Boolean.FALSE && FrsTopView.this.gLa != null && FrsTopView.this.topThreadList != null && FrsTopView.this.gLa.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.gLa.get(i);
                List<com.baidu.adp.widget.ListView.m> subList = FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1);
                TbPageTag ea = com.baidu.tbadk.pageInfo.c.ea(FrsTopView.this.mContext);
                for (com.baidu.adp.widget.ListView.m mVar : subList) {
                    if (mVar instanceof bj) {
                        com.baidu.tieba.frs.d.c.bIf().a(eVar.bFt(), (bj) mVar);
                        com.baidu.tieba.frs.d.a.a((bj) mVar, FrsTopView.this.mBdUniqueId, eVar.bFt(), 0, ea);
                    }
                }
                FrsTopView.this.gLc.set(i, Boolean.TRUE);
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

    /* loaded from: classes7.dex */
    private final class a implements s {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bj)) {
                bj bjVar = (bj) mVar;
                if (bjVar.aAV() == null || bjVar.aAV().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                    if (bjVar.aAH() != 1 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                        if (bjVar.aAk() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                                String postUrl = bjVar.aAk().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bjVar.aBg() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aBg = bjVar.aBg();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aBg.getCartoonId(), aBg.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aAe = bjVar.aAe();
                            if (aAe != null && !aAe.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aAe);
                                        xVar.aDU().aEu().mIsNeedAddCommenParam = false;
                                        xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.azS() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aEt().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.cPa.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.azC());
                            } else if (bdUniqueId.getId() == bj.cNz.getId()) {
                                an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cp("obj_type", "2");
                                anVar.cp("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.guc != null) {
                                FrsTopView.this.guc.aj(bjVar);
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
        this.duJ = forumData;
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
            if (bjVar.cPX == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.cPX.id;
                str2 = valueOf;
            }
            if (bjVar.aAt() > 0 && com.baidu.tieba.tbadkCore.util.e.cKC()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aAt()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aBk());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aBc() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.gLa) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.uC(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gLd != null) {
            this.gLd.onDestroy();
        }
    }
}
