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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
    private al fCv;
    private FrsTabViewPager fSR;
    private TbTabLayout fSS;
    private List<View> fST;
    private List<com.baidu.tieba.frs.view.e> fSU;
    private CommonViewPagerAdapter fSV;
    private ArrayList<Boolean> fSW;
    private com.baidu.tieba.frs.ad.g fSX;
    private boolean fSY;
    private s fvN;
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
        this.fST = new ArrayList();
        this.fSU = new ArrayList();
        this.topThreadList = new ArrayList();
        this.fSW = new ArrayList<>(Collections.nCopies(3, Boolean.FALSE));
        this.fSY = false;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.fSR = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.fSS = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.fSS.setTabMode(1);
        this.fSS.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_c));
    }

    private void bti() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(R.dimen.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, l.g(this.mContext, R.dimen.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.setForum(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.ts(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.fST.add(linearLayout);
        this.fSU.add(eVar);
    }

    public void jS(boolean z) {
        if (this.fSX != null) {
            this.fSX.jS(z);
        }
    }

    public void setDatas(List<m> list, com.baidu.tieba.tbadkCore.h hVar) {
        int i = 0;
        this.topThreadList.clear();
        this.fSU.clear();
        this.fST.clear();
        if (v.aa(list) && hVar == null) {
            setVisibility(8);
            return;
        }
        if (hVar != null) {
            b(hVar);
        }
        if (!v.aa(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            while (true) {
                int i2 = i;
                if (i2 >= (this.topThreadList.size() + 1) / 2) {
                    break;
                }
                bti();
                com.baidu.tieba.frs.view.e eVar = this.fSU.get(i2);
                if (eVar != null) {
                    if (this.fvN == null) {
                        this.fvN = new a();
                    }
                    eVar.c(this.fvN);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            }
        }
        btj();
    }

    public void onChangeSkinType(int i) {
        if (this.fSX != null) {
            this.fSX.onChangeSkinType(i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.h hVar) {
        if (hVar != null) {
            if (this.fSX == null) {
                this.fSX = new com.baidu.tieba.frs.ad.g(this.mContext);
            }
            this.fSX.a(hVar);
            this.fST.add(this.fSX.getView());
            if (!this.fSY) {
                this.fSY = true;
                an anVar = new an("common_exp");
                anVar.bT("page_type", "a006");
                anVar.bT("obj_isad", "1");
                String str = Constants.VIA_SHARE_TYPE_INFO;
                if (hVar.getType() == 1) {
                    str = Constants.VIA_SHARE_TYPE_INFO;
                } else if (hVar.getType() == 2) {
                    str = "7";
                } else if (hVar.getType() == 3) {
                    str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                }
                anVar.bT("obj_adlocate", str);
                anVar.l(VideoPlayActivityConfig.OBJ_ID, hVar.getId());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void setStatListener(al alVar) {
        this.fCv = alVar;
    }

    private void btj() {
        setVisibility(0);
        this.fSS.setVisibility(this.fST.size() > 1 ? 0 : 8);
        if (this.fSV == null) {
            this.fSV = new CommonViewPagerAdapter(this.fST);
            this.fSR.setAdapter(this.fSV);
            this.fSS.removeAllTabs();
            for (int i = 0; i < this.fST.size(); i++) {
                this.fSS.a(this.fSS.oP());
            }
            this.fSS.setupWithViewPager(this.fSR, true);
            return;
        }
        this.fSV.cn(this.fST);
    }

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> fSZ;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.fSZ = list;
        }

        public void cn(List<? extends View> list) {
            this.fSZ = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fSZ.size();
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
            View view = this.fSZ.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.fSW != null && FrsTopView.this.fSW.get(i) == Boolean.FALSE && FrsTopView.this.fSU != null && FrsTopView.this.topThreadList != null && FrsTopView.this.fSU.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.fSU.get(i);
                for (m mVar : FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1)) {
                    if (mVar instanceof bh) {
                        com.baidu.tieba.frs.d.c.brS().a(eVar.bph(), (bh) mVar);
                        com.baidu.tieba.frs.d.a.a((bh) mVar, FrsTopView.this.mBdUniqueId, eVar.bph(), 0);
                    }
                }
                FrsTopView.this.fSW.set(i, Boolean.TRUE);
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
                if (bhVar.afq() == null || bhVar.afq().getGroup_id() == 0 || bd.cF(FrsTopView.this.mContext)) {
                    if (bhVar.afi() != 1 || bd.cF(FrsTopView.this.mContext)) {
                        if (bhVar.aeL() != null) {
                            if (bd.cF(FrsTopView.this.mContext)) {
                                String postUrl = bhVar.aeL().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && l.kt()) {
                                    com.baidu.tbadk.browser.a.af(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bhVar.afB() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bd.cE(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            o afB = bhVar.afB();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), afB.getCartoonId(), afB.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String aeF = bhVar.aeF();
                            if (aeF != null && !aeF.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aeF);
                                        xVar.aiG().ajG().mIsNeedAddCommenParam = false;
                                        xVar.aiG().ajG().mIsUseCurrentBDUSS = false;
                                        xVar.aij();
                                    }
                                }).start();
                            }
                            String tid = bhVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bhVar.aet() == 2 && !tid.startsWith("pb:")) {
                                bb.ajE().c(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                bhVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bh.bLa.getId()) {
                                com.baidu.tieba.frs.f.h.a(bhVar.aee());
                            } else if (bdUniqueId.getId() == bh.bJG.getId()) {
                                an anVar = new an("c12940");
                                anVar.bT("obj_type", "2");
                                anVar.bT("tid", bhVar.getTid());
                                TiebaStatic.log(anVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bhVar, i, z);
                            if (FrsTopView.this.fCv != null) {
                                FrsTopView.this.fCv.ac(bhVar);
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
            if (bhVar.bMf == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bhVar.bMf.id;
                str2 = valueOf;
            }
            if (bhVar.aeU() > 0 && com.baidu.tieba.tbadkCore.util.e.cqL()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bhVar.getTid(), String.valueOf(bhVar.aeU()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bhVar, this.mForumName, "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bhVar.afH());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bhVar.afx() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.fSU) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.ts(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fSX != null) {
            this.fSX.onDestroy();
        }
    }
}
