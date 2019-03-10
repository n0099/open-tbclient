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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {
    private s fap;
    private al fgG;
    private FrsTabViewPager fwB;
    private TbTabLayout fwC;
    private List<LinearLayout> fwD;
    private List<com.baidu.tieba.frs.view.e> fwE;
    private CommonViewPagerAdapter fwF;
    private ArrayList<Boolean> fwG;
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
        this.fwD = new ArrayList();
        this.fwE = new ArrayList();
        this.topThreadList = new ArrayList();
        this.fwG = new ArrayList<>(Collections.nCopies(3, Boolean.FALSE));
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_top_view_layout, (ViewGroup) this, true);
        this.fwB = (FrsTabViewPager) findViewById(d.g.frs_top_viewpager);
        this.fwC = (TbTabLayout) findViewById(d.g.frs_top_tab_layout);
        this.fwC.setTabMode(1);
        this.fwC.setSelectedTabIndicatorColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_c));
    }

    private void bjA() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = new RoundAdapterLinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        roundAdapterLinearLayout.setRadius(getResources().getDimension(d.e.tbds20));
        roundAdapterLinearLayout.setLayoutParams(layoutParams);
        roundAdapterLinearLayout.setOrientation(1);
        roundAdapterLinearLayout.setPadding(0, 0, 0, l.h(this.mContext, d.e.tbds26));
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(this.mContext);
        eVar.setForum(this.mForumId, this.mForumName);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.rU(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.fwD.add(linearLayout);
        this.fwE.add(eVar);
    }

    public void setDatas(List<m> list) {
        int i = 0;
        this.topThreadList.clear();
        this.fwE.clear();
        this.fwD.clear();
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        if (list.size() > 6) {
            list = list.subList(0, 6);
        }
        this.topThreadList.addAll(list);
        while (true) {
            int i2 = i;
            if (i2 < (this.topThreadList.size() + 1) / 2) {
                bjA();
                com.baidu.tieba.frs.view.e eVar = this.fwE.get(i2);
                if (eVar != null) {
                    if (this.fap == null) {
                        this.fap = new a();
                    }
                    eVar.c(this.fap);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            } else {
                bjB();
                return;
            }
        }
    }

    public void setStatListener(al alVar) {
        this.fgG = alVar;
    }

    private void bjB() {
        setVisibility(0);
        this.fwC.setVisibility(this.fwD.size() > 1 ? 0 : 8);
        if (this.fwF == null) {
            this.fwF = new CommonViewPagerAdapter(this.fwD);
            this.fwB.setAdapter(this.fwF);
            this.fwC.removeAllTabs();
            for (int i = 0; i < this.fwD.size(); i++) {
                this.fwC.a(this.fwC.pz());
            }
            this.fwC.setupWithViewPager(this.fwB, true);
            return;
        }
        this.fwF.ci(this.fwD);
    }

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> fwH;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.fwH = list;
        }

        public void ci(List<? extends View> list) {
            this.fwH = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fwH.size();
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
            View view = this.fwH.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.fwG != null && FrsTopView.this.fwG.get(i) == Boolean.FALSE && FrsTopView.this.fwE != null && FrsTopView.this.topThreadList != null && FrsTopView.this.fwE.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.fwE.get(i);
                for (m mVar : FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1)) {
                    if (mVar instanceof bg) {
                        com.baidu.tieba.frs.d.c.bim().a(eVar.bfA(), (bg) mVar);
                        com.baidu.tieba.frs.d.a.a((bg) mVar, FrsTopView.this.mBdUniqueId, eVar.bfA(), 0);
                    }
                }
                FrsTopView.this.fwG.set(i, Boolean.TRUE);
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
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bg bgVar = (bg) mVar;
                if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsTopView.this.mContext)) {
                    if (bgVar.ZB() != 1 || bc.cZ(FrsTopView.this.mContext)) {
                        if (bgVar.Ze() != null) {
                            if (bc.cZ(FrsTopView.this.mContext)) {
                                String postUrl = bgVar.Ze().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && l.lo()) {
                                    com.baidu.tbadk.browser.a.as(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bgVar.ZU() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.cY(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            o ZU = bgVar.ZU();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), ZU.getCartoonId(), ZU.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String YY = bgVar.YY();
                            if (YY != null && !YY.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(YY);
                                        xVar.acH().adF().mIsNeedAddCommenParam = false;
                                        xVar.acH().adF().mIsUseCurrentBDUSS = false;
                                        xVar.ack();
                                    }
                                }).start();
                            }
                            String tid = bgVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bgVar.YM() == 2 && !tid.startsWith("pb:")) {
                                ba.adD().c(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                bgVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bg.bCy.getId()) {
                                com.baidu.tieba.frs.f.h.a(bgVar.Yx());
                            } else if (bdUniqueId.getId() == bg.bBf.getId()) {
                                am amVar = new am("c12940");
                                amVar.bJ("obj_type", "2");
                                amVar.bJ("tid", bgVar.getTid());
                                TiebaStatic.log(amVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bgVar, i, z);
                            if (FrsTopView.this.fgG != null) {
                                FrsTopView.this.fgG.ac(bgVar);
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

    public void a(BaseFragmentActivity baseFragmentActivity, bg bgVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bgVar != null) {
            String valueOf = String.valueOf(bgVar.getFid());
            if (bgVar.bDC == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bgVar.bDC.id;
                str2 = valueOf;
            }
            if (bgVar.Zn() > 0 && com.baidu.tieba.tbadkCore.util.e.cfr()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bgVar.getTid(), String.valueOf(bgVar.Zn()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bgVar, this.mForumName, "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bgVar.aaa());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bgVar.ZQ() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.fwE) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.rU(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }
}
