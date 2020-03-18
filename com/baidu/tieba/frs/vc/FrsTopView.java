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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsTopView extends LinearLayout {
    private ForumData dzq;
    private FrsTabViewPager gOr;
    private TbTabLayout gOs;
    private List<View> gOt;
    private List<com.baidu.tieba.frs.view.e> gOu;
    private CommonViewPagerAdapter gOv;
    private ArrayList<Boolean> gOw;
    private com.baidu.tieba.frs.ad.g gOx;
    private boolean gOy;
    private s gqC;
    private an gxa;
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
        this.gOt = new ArrayList();
        this.gOu = new ArrayList();
        this.topThreadList = new ArrayList();
        this.gOy = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.gOr = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.gOs = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.gOs.setTabMode(1);
    }

    private void bLs() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(R.dimen.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.du(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.uP(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.gOt.add(linearLayout);
        this.gOu.add(eVar);
    }

    public void onPrimary(boolean z) {
        if (this.gOx != null) {
            this.gOx.onPrimary(z);
        }
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list, com.baidu.tieba.tbadkCore.i iVar) {
        int i = 0;
        this.topThreadList.clear();
        this.gOu.clear();
        this.gOt.clear();
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
            while (true) {
                int i2 = i;
                if (i2 >= (this.topThreadList.size() + 1) / 2) {
                    break;
                }
                bLs();
                com.baidu.tieba.frs.view.e eVar = this.gOu.get(i2);
                if (eVar != null) {
                    if (this.gqC == null) {
                        this.gqC = new a();
                    }
                    eVar.d(this.gqC);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        if (this.gOw == null && this.gOt != null) {
            this.gOw = new ArrayList<>(Collections.nCopies(this.gOt.size(), Boolean.FALSE));
        }
        bLt();
    }

    public void onChangeSkinType(int i) {
        if (this.gOx != null) {
            this.gOx.onChangeSkinType(i);
        }
        if (this.gOs != null) {
            this.gOs.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
            this.gOs.setBackgroundDrawable(am.ay(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < (this.topThreadList.size() + 1) / 2) {
                com.baidu.tieba.frs.view.e eVar = this.gOu.get(i3);
                if (eVar != null) {
                    eVar.notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.gOx == null) {
                this.gOx = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.gOx.a(this.dzq, iVar);
            this.gOt.add(this.gOx.getView());
            if (!this.gOy) {
                this.gOy = true;
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("common_exp");
                anVar.cx("page_type", PageStayDurationConstants.PageName.FRS);
                anVar.cx("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                anVar.X("obj_floor", 1);
                anVar.X("obj_adlocate", i);
                anVar.s("obj_id", iVar.getId());
                if (this.dzq != null) {
                    anVar.cx("fid", this.dzq.getId());
                    anVar.cx("first_dir", this.dzq.getFirst_class());
                    anVar.cx("second_dir", this.dzq.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    anVar.cx("tid", iVar.getThreadId());
                    anVar.X("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    public void setStatListener(an anVar) {
        this.gxa = anVar;
    }

    private void bLt() {
        setVisibility(0);
        this.gOs.setVisibility(this.gOt.size() > 1 ? 0 : 8);
        if (this.gOv == null) {
            this.gOv = new CommonViewPagerAdapter(this.gOt);
            this.gOr.setAdapter(this.gOv);
            this.gOs.removeAllTabs();
            for (int i = 0; i < this.gOt.size(); i++) {
                this.gOs.a(this.gOs.kD());
            }
            this.gOs.setupWithViewPager(this.gOr, true);
            return;
        }
        this.gOv.cs(this.gOt);
    }

    /* loaded from: classes9.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> gOz;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.gOz = list;
        }

        public void cs(List<? extends View> list) {
            this.gOz = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gOz.size();
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
            View view = this.gOz.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.gOx != null) {
                i--;
            }
            if (i >= 0 && FrsTopView.this.gOw != null && v.getItem(FrsTopView.this.gOw, i) == Boolean.FALSE && FrsTopView.this.gOu != null && FrsTopView.this.topThreadList != null && FrsTopView.this.gOu.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.gOu.get(i);
                List<com.baidu.adp.widget.ListView.m> subList = FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1);
                TbPageTag ec = com.baidu.tbadk.pageInfo.c.ec(FrsTopView.this.mContext);
                for (com.baidu.adp.widget.ListView.m mVar : subList) {
                    if (mVar instanceof bj) {
                        com.baidu.tieba.frs.d.c.bJX().a(eVar.bHn(), (bj) mVar);
                        com.baidu.tieba.frs.d.a.a((bj) mVar, FrsTopView.this.mBdUniqueId, eVar.bHn(), 0, ec);
                    }
                }
                FrsTopView.this.gOw.set(i, Boolean.TRUE);
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
                if (bjVar.aDo() == null || bjVar.aDo().getGroup_id() == 0 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                    if (bjVar.aDb() != 1 || bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                        if (bjVar.aCE() != null) {
                            if (bc.checkUpIsLogin(FrsTopView.this.mContext)) {
                                String postUrl = bjVar.aCE().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                    com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bjVar.aDz() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            p aDz = bjVar.aDz();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aDz.getCartoonId(), aDz.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aCy = bjVar.aCy();
                            if (aCy != null && !aCy.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCy);
                                        xVar.aGk().aGL().mIsNeedAddCommenParam = false;
                                        xVar.aGk().aGL().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjVar.aCm() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGK().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bj.cTr.getId()) {
                                com.baidu.tieba.frs.f.h.a(bjVar.aBX());
                            } else if (bdUniqueId.getId() == bj.cRR.getId()) {
                                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                anVar.cx("obj_type", "2");
                                anVar.cx("tid", bjVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bjVar, i, z);
                            if (FrsTopView.this.gxa != null) {
                                FrsTopView.this.gxa.al(bjVar);
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
        this.dzq = forumData;
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
            if (bjVar.cUo == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bjVar.cUo.id;
                str2 = valueOf;
            }
            if (bjVar.aCN() > 0 && com.baidu.tieba.tbadkCore.util.e.cMx()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.aCN()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bjVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.aDD());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bjVar.aDv() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.gOu) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.uP(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gOx != null) {
            this.gOx.onDestroy();
        }
    }
}
