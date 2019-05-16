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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {
    private FrsTabViewPager fNd;
    private TbTabLayout fNe;
    private List<LinearLayout> fNf;
    private List<com.baidu.tieba.frs.view.e> fNg;
    private CommonViewPagerAdapter fNh;
    private ArrayList<Boolean> fNi;
    private s fqp;
    private al fwK;
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
        this.fNf = new ArrayList();
        this.fNg = new ArrayList();
        this.topThreadList = new ArrayList();
        this.fNi = new ArrayList<>(Collections.nCopies(3, Boolean.FALSE));
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.fNd = (FrsTabViewPager) findViewById(R.id.frs_top_viewpager);
        this.fNe = (TbTabLayout) findViewById(R.id.frs_top_tab_layout);
        this.fNe.setTabMode(1);
        this.fNe.setSelectedTabIndicatorColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_c));
    }

    private void bqP() {
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
            eVar.sY(this.textColor);
        }
        roundAdapterLinearLayout.setAdapter(eVar);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(roundAdapterLinearLayout);
        this.fNf.add(linearLayout);
        this.fNg.add(eVar);
    }

    public void setDatas(List<m> list) {
        int i = 0;
        this.topThreadList.clear();
        this.fNg.clear();
        this.fNf.clear();
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
                bqP();
                com.baidu.tieba.frs.view.e eVar = this.fNg.get(i2);
                if (eVar != null) {
                    if (this.fqp == null) {
                        this.fqp = new a();
                    }
                    eVar.c(this.fqp);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 2) + 2, this.topThreadList.size())));
                }
                i = i2 + 1;
            } else {
                bqQ();
                return;
            }
        }
    }

    public void setStatListener(al alVar) {
        this.fwK = alVar;
    }

    private void bqQ() {
        setVisibility(0);
        this.fNe.setVisibility(this.fNf.size() > 1 ? 0 : 8);
        if (this.fNh == null) {
            this.fNh = new CommonViewPagerAdapter(this.fNf);
            this.fNd.setAdapter(this.fNh);
            this.fNe.removeAllTabs();
            for (int i = 0; i < this.fNf.size(); i++) {
                this.fNe.a(this.fNe.ou());
            }
            this.fNe.setupWithViewPager(this.fNd, true);
            return;
        }
        this.fNh.cn(this.fNf);
    }

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private List<? extends View> fNj;

        public CommonViewPagerAdapter(List<? extends View> list) {
            this.fNj = list;
        }

        public void cn(List<? extends View> list) {
            this.fNj = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fNj.size();
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
            View view = this.fNj.get(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsTopView.this.fNi != null && FrsTopView.this.fNi.get(i) == Boolean.FALSE && FrsTopView.this.fNg != null && FrsTopView.this.topThreadList != null && FrsTopView.this.fNg.size() > i && FrsTopView.this.topThreadList.size() > i * 2) {
                com.baidu.tieba.frs.view.e eVar = (com.baidu.tieba.frs.view.e) FrsTopView.this.fNg.get(i);
                for (m mVar : FrsTopView.this.topThreadList.size() > (i * 2) + 1 ? FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 2) : FrsTopView.this.topThreadList.subList(i * 2, (i * 2) + 1)) {
                    if (mVar instanceof bg) {
                        com.baidu.tieba.frs.d.c.bpz().a(eVar.bmQ(), (bg) mVar);
                        com.baidu.tieba.frs.d.a.a((bg) mVar, FrsTopView.this.mBdUniqueId, eVar.bmQ(), 0);
                    }
                }
                FrsTopView.this.fNi.set(i, Boolean.TRUE);
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
                if (bgVar.aen() == null || bgVar.aen().getGroup_id() == 0 || bc.cE(FrsTopView.this.mContext)) {
                    if (bgVar.aef() != 1 || bc.cE(FrsTopView.this.mContext)) {
                        if (bgVar.adI() != null) {
                            if (bc.cE(FrsTopView.this.mContext)) {
                                String postUrl = bgVar.adI().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && l.ki()) {
                                    com.baidu.tbadk.browser.a.ag(FrsTopView.this.mContext, postUrl);
                                }
                            }
                        } else if (bgVar.aey() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bc.cD(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            o aey = bgVar.aey();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), aey.getCartoonId(), aey.getChapterId(), 2)));
                        } else {
                            boolean z = false;
                            final String adC = bgVar.adC();
                            if (adC != null && !adC.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(adC);
                                        xVar.ahC().aiB().mIsNeedAddCommenParam = false;
                                        xVar.ahC().aiB().mIsUseCurrentBDUSS = false;
                                        xVar.ahf();
                                    }
                                }).start();
                            }
                            String tid = bgVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bgVar.adq() == 2 && !tid.startsWith("pb:")) {
                                ba.aiz().c(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                bgVar.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == bg.bJU.getId()) {
                                com.baidu.tieba.frs.f.h.a(bgVar.adb());
                            } else if (bdUniqueId.getId() == bg.bIA.getId()) {
                                am amVar = new am("c12940");
                                amVar.bT("obj_type", "2");
                                amVar.bT("tid", bgVar.getTid());
                                TiebaStatic.log(amVar);
                            }
                            FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bgVar, i, z);
                            if (FrsTopView.this.fwK != null) {
                                FrsTopView.this.fwK.ab(bgVar);
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
            if (bgVar.bKZ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bgVar.bKZ.id;
                str2 = valueOf;
            }
            if (bgVar.adR() > 0 && com.baidu.tieba.tbadkCore.util.e.cnt()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bgVar.getTid(), String.valueOf(bgVar.adR()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bgVar, this.mForumName, "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bgVar.aeE());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bgVar.aeu() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.fNg) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.sY(i);
            this.textColor = i;
            eVar.notifyDataSetChanged();
        }
    }
}
