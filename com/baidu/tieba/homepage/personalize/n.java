package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.cq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tieba.play.ac aRh;
    private com.baidu.tieba.e.a aRi;
    private View aln;
    private com.baidu.tieba.tbadkCore.data.e bOQ;
    private boolean cpu;
    public com.baidu.tieba.homepage.framework.b.a cyo;
    private final com.baidu.tieba.homepage.personalize.b.ad czA;
    private final FrameLayout czB;
    private cq czC;
    private final com.baidu.tieba.homepage.personalize.model.a czD;
    private ScrollFragmentTabHost czF;
    private ViewGroup czG;
    private View.OnTouchListener czH;
    private int czK;
    private final long czt;
    private DataRes.Builder czv;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a czu = null;
    private final List<com.baidu.adp.widget.ListView.v> aSD = new LinkedList();
    private int bxh = 1;
    private boolean mIsLoading = false;
    private boolean czw = false;
    private long czx = 0;
    private int czy = 1;
    private int czz = 0;
    private TextView abp = null;
    private int bST = 2000;
    public com.baidu.tbadk.j.m czE = null;
    private boolean aRj = false;
    private int aRl = 0;
    private int aRk = 0;
    private boolean mIsBackground = false;
    private boolean czI = true;
    private boolean czJ = false;
    private boolean czL = false;
    private AbsListView.OnScrollListener mOnScrollListener = new o(this);
    private View.OnTouchListener aOj = new z(this);
    private a.InterfaceC0055a aRo = new ac(this);
    private View.OnClickListener czM = new ad(this);
    private final CustomMessageListener czN = new ae(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener czO = new af(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener czP = new ag(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener czQ = new ah(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener czR = new ai(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener amd = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener amU = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String czS = "lastReadReadPositionKey";
    private int czT = 0;
    private m czU = new r(this);
    private CustomMessageListener caF = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener caG = new u(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    /* loaded from: classes.dex */
    public interface a {
        void aw(int i, int i2);

        void bb(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cyo = eVar.ajW();
            this.czG = eVar.WQ();
            this.czH = eVar.ajX();
        }
    }

    public void Yk() {
        if (this.cyo != null) {
            this.cyo.fa(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.czF = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.abp != null && this.abp.getParent() != null && this.abp.getVisibility() != 8) {
                i2 = (i2 - this.abp.getMeasuredHeight()) - at(this.abp);
            }
            setHeaderViewHeight(i2);
        }
    }

    private void setHeaderViewHeight(int i) {
        if (this.aln != null && this.aln.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aln.getLayoutParams();
            layoutParams.height = i;
            this.aln.setLayoutParams(layoutParams);
        }
    }

    private int at(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void dT(boolean z) {
        this.mIsBackground = z;
        if (this.aRh != null) {
            this.aRh.gY(!z);
            if (z) {
                this.aRh.amG();
            } else if (this.czI) {
                this.aRh.a(this.aRl, this.aRk, this.aRj, true);
            }
        }
    }

    public n(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ad adVar, FrameLayout frameLayout) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.aln = view;
        this.mListView.setOnTouchListener(this.aOj);
        this.aRi = new com.baidu.tieba.e.a();
        this.aRi.a(this.aRo);
        this.czB = frameLayout;
        this.czA = adVar;
        this.czD = new com.baidu.tieba.homepage.personalize.model.a();
        this.czt = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.czC = new cq();
        akx();
        this.aRh = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean akk() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getBoolean(akm(), true);
    }

    private void akl() {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean(akm(), false);
    }

    private String akm() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aju().jK(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aju().f(System.currentTimeMillis(), 1);
        }
        this.bxh = 1;
        this.czL = true;
        if (this.aSD.size() == 0 && !this.czw && !akk()) {
            aks();
        } else {
            akp();
        }
    }

    public void akn() {
        if (this.aRh != null && !this.mIsBackground && this.czI) {
            this.aRh.a(this.aRl, this.aRk, this.aRj, true);
        }
        if (this.czJ) {
            if (this.cpu) {
                if (ff(false)) {
                    ax(3, this.czz);
                } else if (this.czK > 0) {
                    ax(2, this.czz);
                }
            } else if (!this.cpu && this.czz == 0) {
                ax(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.czJ = false;
            this.cpu = false;
            this.czK = 0;
            if (this.czL) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.czL = false;
        }
    }

    public void aaw() {
        if (!xj() && this.czu != null) {
            akr();
            this.bxh++;
            setIsLoading(true);
            this.czu.v(this.bxh, (this.czv == null || this.czv.thread_list == null) ? 0 : this.czv.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.czv == null || this.czv.thread_list == null) ? 0 : this.czv.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.czJ = false;
            if (this.aSD.size() > 0) {
                if (this.czu != null) {
                    this.czu.onError(1, str);
                    return;
                }
                return;
            } else if (this.czu != null) {
                this.czu.onError(2, str);
                return;
            } else {
                return;
            }
        }
        akl();
        if (this.czu != null) {
            this.czu.onSuccess();
        }
        this.czJ = true;
        this.cpu = z;
        this.czK = size;
        akt();
    }

    public void fe(boolean z) {
        if (z) {
            this.czA.notifyDataSetChanged();
        }
        if (!ako()) {
            akv();
        }
    }

    public void onDestroy() {
        if (this.aRh != null) {
            this.aRh.destroy();
        }
        if (this.czE != null) {
            this.czE.onDestroy();
        }
        if (this.czC != null) {
            this.czC.onDestroy();
        }
    }

    public void onPause() {
        jX(this.czT);
        jV(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jV(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jV(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$15
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean ako() {
        if (ff(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("close_new_user_guide_tip", false)) {
                fg(true);
            }
            akw();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void akp() {
        if (this.czu != null) {
            this.czu.aw((this.czv == null || this.czv.thread_list == null || aku()) ? 0 : this.czv.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.czw = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !aku()) {
                if (this.czu != null) {
                    this.czu.onSuccess();
                }
                akv();
                return;
            }
            akp();
            return;
        }
        akp();
    }

    private void akq() {
        boolean z;
        boolean z2;
        if (this.czv != null) {
            if (this.czv.age_sex != null) {
                if (this.czv.age_sex.sex_tag != null && this.czv.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.czv.age_sex.sex_tag.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        TagStruct next = it.next();
                        if (next != null && !StringUtils.isNull(next.tag_name) && next.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, com.baidu.tieba.homepage.personalize.data.g.a(next)));
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = new com.baidu.tieba.homepage.personalize.data.g();
                        gVar.cBo = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                    }
                }
                if (this.czv.age_sex.age_tag != null && this.czv.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.czv.age_sex.age_tag.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        TagStruct next2 = it2.next();
                        if (next2 != null && !StringUtils.isNull(next2.tag_name) && next2.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, com.baidu.tieba.homepage.personalize.data.g.a(next2)));
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        com.baidu.tieba.homepage.personalize.data.g gVar2 = new com.baidu.tieba.homepage.personalize.data.g();
                        gVar2.cBo = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar2));
                    }
                }
            }
            if (this.czv.age_sex == null && this.czv.interestion != null && this.czv.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.czv.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private void bc(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.q(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.Uk() != null) {
                        dVar.Uk().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.Uk().advertAppContext.Ty = "NEWINDEX";
                        dVar.Uk().advertAppContext.pn = 1;
                        dVar.Uk().advertAppContext.extensionInfo = dVar.Uk().extensionInfo;
                        dVar.Uk().advertAppContext.TD = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.czx = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && aku()) {
                this.czv = null;
            }
            int size = z2 ? 0 : this.aSD.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aSD.clear();
            com.baidu.tieba.homepage.personalize.model.d a2 = this.czD.a(z, this.czv, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.aPM;
                this.czz = a2.cBw;
                list = list2;
            }
            if (list != null) {
                this.aSD.addAll(list);
                if (z2) {
                    bc(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.czL) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.czv == null) {
                this.czv = builder;
            }
            akq();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.czu != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.mPageContext.getString(w.l.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                P(arrayList);
                this.czu.bb(arrayList);
            }
            if (this.aSD.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aSD);
                this.czA.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.czA.bd(linkedList);
                if (this.aRh != null && this.czI) {
                    this.aRh.a(this.aRl, this.aRk, this.aRj, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.aju().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jK = com.baidu.tieba.homepage.framework.a.aju().jK(1);
            if (jK > 0) {
                com.baidu.tieba.homepage.framework.a.aju().e(System.currentTimeMillis() - jK, 1);
                com.baidu.tieba.homepage.framework.a.aju().f(0L, 1);
            }
        }
        return r1;
    }

    private void P(ArrayList<TagInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<TagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TagInfo next = it.next();
                if (next.tag_type.intValue() == 5) {
                    com.baidu.tieba.lego.d.e eVar = new com.baidu.tieba.lego.d.e();
                    eVar.dAc = next.lego_page_id.longValue();
                    eVar.dAd = com.baidu.tieba.tbadkCore.t.pW(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.t.pU(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.t.pX(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void akr() {
        if (com.baidu.tbadk.core.util.x.p(this.aSD) >= this.czD.akE() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.czD.a(true, this.czv, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aPM : null;
            if (list != null) {
                this.aSD.clear();
                this.aSD.addAll(list);
                this.czA.bd(new LinkedList(this.aSD));
            }
        }
    }

    private void aks() {
        com.baidu.tbadk.util.t.a(new v(this), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akt() {
        if (this.czv != null) {
            DataRes.Builder builder = new DataRes.Builder(this.czv.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jG(String str) {
        if (!TextUtils.isEmpty(str) && this.czv != null && this.czv.banner_list != null && this.czv.banner_list.app != null && this.czv.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.czv.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.czv.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.czv.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(DataRes.Builder builder) {
        com.baidu.tbadk.util.t.a(new x(this, builder), null);
    }

    private boolean aku() {
        return ff(true);
    }

    private boolean ff(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.czt;
    }

    public void a(a aVar) {
        this.czu = aVar;
    }

    private boolean xj() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_guide_time", 0L);
        if (this.czx != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.czx) {
                ax(1, 0);
            }
        }
    }

    private void ax(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.czF != null && this.czF.ajL()) {
            this.czC.abO();
        } else if (this.czF == null || this.czF.getCurrentItem() <= 0) {
            this.czy = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.abp == null) {
                    this.abp = new TextView(this.mPageContext.getPageActivity());
                    this.abp.setGravity(17);
                    this.abp.setOnClickListener(this.czM);
                    setHeaderViewHeight(this.czG.getMeasuredHeight());
                }
                this.czC.abO();
                if (this.czG != null && this.abp.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.hk()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                            this.abp.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.abp.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aq.j(this.abp, w.g.bg_home_float);
                            aq.i(this.abp, w.e.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.abp.setPadding(0, 0, 0, 0);
                        this.abp.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                        aq.j(this.abp, w.e.common_color_10260);
                        aq.i(this.abp, w.e.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.abp.setText(str);
                    if (i == 1) {
                        this.bST = 4000;
                    } else {
                        this.bST = 2000;
                    }
                    this.czC.a(this.abp, this.czG, layoutParams, this.bST);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("close_new_user_guide_tip", true);
        if (this.czv != null && this.czv.age_sex != null) {
            this.czv.age_sex = null;
            if (z) {
                akt();
            }
        }
        if (this.aSD != null && this.aSD.size() > 0 && (this.aSD.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aSD.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aSD != null) {
            this.czA.bd(new ArrayList(this.aSD));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        if (this.czv != null && this.czv.interestion != null) {
            this.czv.interestion = null;
            akt();
        }
        if (this.aSD != null && this.aSD.size() > 0 && (this.aSD.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aSD.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aSD != null) {
            this.czA.bd(new ArrayList(this.aSD));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.amd != null) {
                this.amd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.amd);
            }
            if (this.czN != null) {
                this.czN.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.czN);
            }
            if (this.czO != null) {
                this.czO.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.czO);
            }
            if (this.czP != null) {
                this.czP.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.czP);
            }
            if (this.czQ != null) {
                this.czQ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.czQ);
            }
            this.czR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.czR);
            this.amU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amU);
            this.caF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caF);
            this.caG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caG);
        }
    }

    public void akx() {
        this.bOQ = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bOQ.biN();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bOQ != null) {
            if (i == 0) {
                this.bOQ.biN();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.fxH;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bOQ.bn(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i6 = i6;
                    i5 = i4;
                }
            }
        }
    }

    public void jW(int i) {
        if ((this.bOQ != null ? this.bOQ.rV(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bOQ.rW(i);
        }
    }

    public com.baidu.tieba.play.ac Lc() {
        return this.aRh;
    }

    public void fh(boolean z) {
        this.czI = z;
    }

    public void jX(int i) {
        com.baidu.tbadk.util.t.a(new y(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new aa(this), new ab(this, mVar));
    }

    public void aky() {
        a(this.czU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.adp.widget.ListView.v> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).Uk();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ah) {
                        com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                        if (ahVar.ra() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.ra()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.TT)) {
                    advertAppInfo2 = advertAppInfo;
                } else {
                    it.remove();
                    advertAppInfo2 = null;
                }
            }
        }
    }
}
