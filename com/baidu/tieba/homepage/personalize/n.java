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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tieba.play.ac aQP;
    private com.baidu.tieba.e.a aQQ;
    private View akX;
    private com.baidu.tieba.tbadkCore.data.e bMJ;
    private boolean coD;
    public com.baidu.tieba.homepage.framework.b.a cxx;
    private final long cyC;
    private DataRes.Builder cyE;
    private final com.baidu.tieba.homepage.personalize.b.ad cyJ;
    private final FrameLayout cyK;
    private co cyL;
    private final com.baidu.tieba.homepage.personalize.model.a cyM;
    private ScrollFragmentTabHost cyO;
    private ViewGroup cyP;
    private View.OnTouchListener cyQ;
    private int cyT;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cyD = null;
    private final List<com.baidu.adp.widget.ListView.v> aSl = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cyF = false;
    private long cyG = 0;
    private int cyH = 1;
    private int cyI = 0;
    private TextView aaZ = null;
    private int bQN = 2000;
    public com.baidu.tbadk.performanceLog.m cyN = null;
    private boolean aQR = false;
    private int aQT = 0;
    private int aQS = 0;
    private boolean mIsBackground = false;
    private boolean cyR = true;
    private boolean cyS = false;
    private boolean cyU = false;
    private AbsListView.OnScrollListener mOnScrollListener = new o(this);
    private View.OnTouchListener aNR = new z(this);
    private a.InterfaceC0056a aQW = new ab(this);
    private View.OnClickListener cyV = new ac(this);
    private final CustomMessageListener cyW = new ad(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cyX = new ae(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cyY = new af(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cyZ = new ag(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cza = new ah(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener alP = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener amG = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String czb = "lastReadReadPositionKey";
    private int czc = 0;
    private m czd = new r(this);
    private CustomMessageListener bZO = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    /* loaded from: classes.dex */
    public interface a {
        void ay(int i, int i2);

        void bb(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cxx = eVar.ajb();
            this.cyP = eVar.Vr();
            this.cyQ = eVar.ajc();
        }
    }

    public void WL() {
        if (this.cxx != null) {
            this.cxx.eQ(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cyO = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.aaZ != null && this.aaZ.getParent() != null && this.aaZ.getVisibility() != 8) {
                i2 = (i2 - this.aaZ.getMeasuredHeight()) - av(this.aaZ);
            }
            setHeaderViewHeight(i2);
        }
    }

    private void setHeaderViewHeight(int i) {
        if (this.akX != null && this.akX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.akX.getLayoutParams();
            layoutParams.height = i;
            this.akX.setLayoutParams(layoutParams);
        }
    }

    private int av(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void dH(boolean z) {
        this.mIsBackground = z;
        if (this.aQP != null) {
            this.aQP.gP(!z);
            if (z) {
                this.aQP.alL();
            } else if (this.cyR) {
                this.aQP.a(this.aQT, this.aQS, this.aQR, true);
            }
        }
    }

    public n(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ad adVar, FrameLayout frameLayout) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.akX = view;
        this.mListView.setOnTouchListener(this.aNR);
        this.aQQ = new com.baidu.tieba.e.a();
        this.aQQ.a(this.aQW);
        this.cyK = frameLayout;
        this.cyJ = adVar;
        this.cyM = new com.baidu.tieba.homepage.personalize.model.a();
        this.cyC = com.baidu.tbadk.core.sharedPref.b.uo().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cyL = new co();
        ajC();
        this.aQP = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean ajp() {
        return com.baidu.tbadk.core.sharedPref.b.uo().getBoolean(ajr(), true);
    }

    private void ajq() {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean(ajr(), false);
    }

    private String ajr() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aiz().jD(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aiz().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cyU = true;
        if (this.aSl.size() == 0 && !this.cyF && !ajp()) {
            ajx();
        } else {
            aju();
        }
    }

    public void ajs() {
        if (this.aQP != null && !this.mIsBackground && this.cyR) {
            this.aQP.a(this.aQT, this.aQS, this.aQR, true);
        }
        if (this.cyS) {
            if (this.coD && this.cyI > 0) {
                if (eV(false)) {
                    az(3, this.cyI);
                } else if (this.cyT > 0) {
                    az(2, this.cyI);
                }
            } else if (!this.coD && this.cyI == 0) {
                az(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.uo().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cyS = false;
            this.coD = false;
            this.cyT = 0;
            if (this.cyU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cyU = false;
        }
    }

    public void YZ() {
        if (!wN() && this.cyD != null) {
            ajw();
            this.mPn++;
            setIsLoading(true);
            this.cyD.v(this.mPn, (this.cyE == null || this.cyE.thread_list == null) ? 0 : this.cyE.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.uo().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cyE == null || this.cyE.thread_list == null) ? 0 : this.cyE.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cyS = false;
            if (this.aSl.size() > 0) {
                if (this.cyD != null) {
                    this.cyD.onError(1, str);
                    return;
                }
                return;
            } else if (this.cyD != null) {
                this.cyD.onError(2, str);
                return;
            } else {
                return;
            }
        }
        ajq();
        if (this.cyD != null) {
            this.cyD.onSuccess();
        }
        this.cyS = true;
        this.coD = z;
        this.cyT = size;
        ajy();
    }

    public void eU(boolean z) {
        if (z) {
            this.cyJ.notifyDataSetChanged();
        }
        if (!ajt()) {
            ajA();
        }
    }

    public void onDestroy() {
        if (this.aQP != null) {
            this.aQP.destroy();
        }
        if (this.cyN != null) {
            this.cyN.onDestroy();
        }
        if (this.cyL != null) {
            this.cyL.onDestroy();
        }
    }

    public void onPause() {
        jQ(this.czc);
        jO(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jO(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jO(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$14
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean ajt() {
        if (eV(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("close_new_user_guide_tip", false)) {
                eW(true);
            }
            ajB();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aju() {
        if (this.cyD != null) {
            this.cyD.ay((this.cyE == null || this.cyE.thread_list == null || ajz()) ? 0 : this.cyE.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cyF = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !ajz()) {
                if (this.cyD != null) {
                    this.cyD.onSuccess();
                }
                ajA();
                return;
            }
            aju();
            return;
        }
        aju();
    }

    private void ajv() {
        boolean z;
        boolean z2;
        if (this.cyE != null) {
            if (this.cyE.age_sex != null) {
                if (this.cyE.age_sex.sex_tag != null && this.cyE.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cyE.age_sex.sex_tag.iterator();
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
                        gVar.cAx = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                    }
                }
                if (this.cyE.age_sex.age_tag != null && this.cyE.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cyE.age_sex.age_tag.iterator();
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
                        gVar2.cAx = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar2));
                    }
                }
            }
            if (this.cyE.age_sex == null && this.cyE.interestion != null && this.cyE.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cyE.interestion) {
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
                    if (dVar.SK() != null) {
                        dVar.SK().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.SK().advertAppContext.Te = "NEWINDEX";
                        dVar.SK().advertAppContext.pn = 1;
                        dVar.SK().advertAppContext.extensionInfo = dVar.SK().extensionInfo;
                        dVar.SK().advertAppContext.Tj = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cyG = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && ajz()) {
                this.cyE = null;
            }
            int size = z2 ? 0 : this.aSl.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aSl.clear();
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cyM.a(z, this.cyE, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.aPu;
                this.cyI = a2.cAF;
                list = list2;
            }
            if (list != null) {
                this.aSl.addAll(list);
                if (z2) {
                    bc(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.cyU) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cyE == null) {
                this.cyE = builder;
            }
            ajv();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cyD != null) {
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
                this.cyD.bb(arrayList);
            }
            if (this.aSl.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aSl);
                this.cyJ.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cyJ.bd(linkedList);
                if (this.aQP != null && this.cyR) {
                    this.aQP.a(this.aQT, this.aQS, this.aQR, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.aiz().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jD = com.baidu.tieba.homepage.framework.a.aiz().jD(1);
            if (jD > 0) {
                com.baidu.tieba.homepage.framework.a.aiz().e(System.currentTimeMillis() - jD, 1);
                com.baidu.tieba.homepage.framework.a.aiz().f(0L, 1);
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
                    eVar.dBe = next.lego_page_id.longValue();
                    eVar.dBf = com.baidu.tieba.tbadkCore.t.pE(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.t.pC(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.t.pF(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void ajw() {
        if (com.baidu.tbadk.core.util.x.p(this.aSl) >= this.cyM.ajJ() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cyM.a(true, this.cyE, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aPu : null;
            if (list != null) {
                this.aSl.clear();
                this.aSl.addAll(list);
                this.cyJ.bd(new LinkedList(this.aSl));
            }
        }
    }

    private void ajx() {
        com.baidu.tbadk.util.t.a(new u(this), new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajy() {
        if (this.cyE != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cyE.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.t.a(new w(this, builder), null);
        }
    }

    private boolean ajz() {
        return eV(true);
    }

    private boolean eV(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.uo().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cyC;
    }

    public void a(a aVar) {
        this.cyD = aVar;
    }

    private boolean wN() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajA() {
        long j = com.baidu.tbadk.core.sharedPref.b.uo().getLong("recommend_frs_guide_time", 0L);
        if (this.cyG != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cyG) {
                az(1, 0);
            }
        }
    }

    private void az(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cyO != null && this.cyO.aiQ()) {
            this.cyL.aap();
        } else if (this.cyO == null || this.cyO.getCurrentItem() <= 0) {
            this.cyH = i;
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
                if (this.aaZ == null) {
                    this.aaZ = new TextView(this.mPageContext.getPageActivity());
                    this.aaZ.setGravity(17);
                    this.aaZ.setOnClickListener(this.cyV);
                    setHeaderViewHeight(this.cyP.getMeasuredHeight());
                }
                this.cyL.aap();
                if (this.cyP != null && this.aaZ.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.he()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                            this.aaZ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.aaZ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.uo().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aq.j(this.aaZ, w.g.bg_home_float);
                            aq.i((View) this.aaZ, w.e.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.aaZ.setPadding(0, 0, 0, 0);
                        this.aaZ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                        aq.j(this.aaZ, w.e.common_color_10260);
                        aq.i((View) this.aaZ, w.e.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.aaZ.setText(str);
                    if (i == 1) {
                        this.bQN = 4000;
                    } else {
                        this.bQN = 2000;
                    }
                    this.cyL.a(this.aaZ, this.cyP, layoutParams, this.bQN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("close_new_user_guide_tip", true);
        if (this.cyE != null && this.cyE.age_sex != null) {
            this.cyE.age_sex = null;
            if (z) {
                ajy();
            }
        }
        if (this.aSl != null && this.aSl.size() > 0 && (this.aSl.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aSl.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aSl != null) {
            this.cyJ.bd(new ArrayList(this.aSl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajB() {
        if (this.cyE != null && this.cyE.interestion != null) {
            this.cyE.interestion = null;
            ajy();
        }
        if (this.aSl != null && this.aSl.size() > 0 && (this.aSl.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aSl.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aSl != null) {
            this.cyJ.bd(new ArrayList(this.aSl));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.alP != null) {
                this.alP.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.alP);
            }
            if (this.cyW != null) {
                this.cyW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cyW);
            }
            if (this.cyX != null) {
                this.cyX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cyX);
            }
            if (this.cyY != null) {
                this.cyY.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cyY);
            }
            if (this.cyZ != null) {
                this.cyZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cyZ);
            }
            this.cza.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cza);
            this.amG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amG);
            this.bZO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZO);
        }
    }

    public void ajC() {
        this.bMJ = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bMJ.bhb();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bMJ != null) {
            if (i == 0) {
                this.bMJ.bhb();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.ftH;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bMJ.bq(i3, i7 + 1);
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

    public void jP(int i) {
        if ((this.bMJ != null ? this.bMJ.rR(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bMJ.rS(i);
        }
    }

    public com.baidu.tieba.play.ac KC() {
        return this.aQP;
    }

    public void eX(boolean z) {
        this.cyR = z;
    }

    public void jQ(int i) {
        com.baidu.tbadk.util.t.a(new x(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new y(this), new aa(this, mVar));
    }

    public void ajD() {
        a(this.czd);
    }
}
