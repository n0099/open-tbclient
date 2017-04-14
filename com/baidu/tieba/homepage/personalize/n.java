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
    private com.baidu.tieba.play.ac aRf;
    private com.baidu.tieba.e.a aRg;
    private View alm;
    private com.baidu.tieba.tbadkCore.data.e bMz;
    private boolean cnc;
    public com.baidu.tieba.homepage.framework.b.a cvX;
    private final long cxc;
    private DataRes.Builder cxe;
    private final com.baidu.tieba.homepage.personalize.b.ad cxj;
    private final FrameLayout cxk;
    private cq cxl;
    private final com.baidu.tieba.homepage.personalize.model.a cxm;
    private ScrollFragmentTabHost cxo;
    private ViewGroup cxp;
    private View.OnTouchListener cxq;
    private int cxt;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cxd = null;
    private final List<com.baidu.adp.widget.ListView.v> aSB = new LinkedList();
    private int buQ = 1;
    private boolean mIsLoading = false;
    private boolean cxf = false;
    private long cxg = 0;
    private int cxh = 1;
    private int cxi = 0;
    private TextView abo = null;
    private int bQC = 2000;
    public com.baidu.tbadk.j.m cxn = null;
    private boolean aRh = false;
    private int aRj = 0;
    private int aRi = 0;
    private boolean mIsBackground = false;
    private boolean cxr = true;
    private boolean cxs = false;
    private boolean cxu = false;
    private AbsListView.OnScrollListener mOnScrollListener = new o(this);
    private View.OnTouchListener aOh = new z(this);
    private a.InterfaceC0055a aRm = new ac(this);
    private View.OnClickListener cxv = new ad(this);
    private final CustomMessageListener cxw = new ae(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cxx = new af(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cxy = new ag(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cxz = new ah(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cxA = new ai(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener amd = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener amU = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cxB = "lastReadReadPositionKey";
    private int cxC = 0;
    private m cxD = new r(this);
    private CustomMessageListener bYo = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener bYp = new u(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    /* loaded from: classes.dex */
    public interface a {
        void aw(int i, int i2);

        void ba(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cvX = eVar.aiV();
            this.cxp = eVar.VP();
            this.cxq = eVar.aiW();
        }
    }

    public void Xj() {
        if (this.cvX != null) {
            this.cvX.eQ(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxo = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.abo != null && this.abo.getParent() != null && this.abo.getVisibility() != 8) {
                i2 = (i2 - this.abo.getMeasuredHeight()) - at(this.abo);
            }
            setHeaderViewHeight(i2);
        }
    }

    private void setHeaderViewHeight(int i) {
        if (this.alm != null && this.alm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.alm.getLayoutParams();
            layoutParams.height = i;
            this.alm.setLayoutParams(layoutParams);
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

    public void dJ(boolean z) {
        this.mIsBackground = z;
        if (this.aRf != null) {
            this.aRf.gO(!z);
            if (z) {
                this.aRf.alF();
            } else if (this.cxr) {
                this.aRf.a(this.aRj, this.aRi, this.aRh, true);
            }
        }
    }

    public n(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ad adVar, FrameLayout frameLayout) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.alm = view;
        this.mListView.setOnTouchListener(this.aOh);
        this.aRg = new com.baidu.tieba.e.a();
        this.aRg.a(this.aRm);
        this.cxk = frameLayout;
        this.cxj = adVar;
        this.cxm = new com.baidu.tieba.homepage.personalize.model.a();
        this.cxc = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cxl = new cq();
        ajw();
        this.aRf = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean ajj() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getBoolean(ajl(), true);
    }

    private void ajk() {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean(ajl(), false);
    }

    private String ajl() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.ait().jE(1) == -1) {
            com.baidu.tieba.homepage.framework.a.ait().f(System.currentTimeMillis(), 1);
        }
        this.buQ = 1;
        this.cxu = true;
        if (this.aSB.size() == 0 && !this.cxf && !ajj()) {
            ajr();
        } else {
            ajo();
        }
    }

    public void ajm() {
        if (this.aRf != null && !this.mIsBackground && this.cxr) {
            this.aRf.a(this.aRj, this.aRi, this.aRh, true);
        }
        if (this.cxs) {
            if (this.cnc) {
                if (eV(false)) {
                    ax(3, this.cxi);
                } else if (this.cxt > 0) {
                    ax(2, this.cxi);
                }
            } else if (!this.cnc && this.cxi == 0) {
                ax(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cxs = false;
            this.cnc = false;
            this.cxt = 0;
            if (this.cxu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cxu = false;
        }
    }

    public void Zv() {
        if (!xj() && this.cxd != null) {
            ajq();
            this.buQ++;
            setIsLoading(true);
            this.cxd.v(this.buQ, (this.cxe == null || this.cxe.thread_list == null) ? 0 : this.cxe.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cxe == null || this.cxe.thread_list == null) ? 0 : this.cxe.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cxs = false;
            if (this.aSB.size() > 0) {
                if (this.cxd != null) {
                    this.cxd.onError(1, str);
                    return;
                }
                return;
            } else if (this.cxd != null) {
                this.cxd.onError(2, str);
                return;
            } else {
                return;
            }
        }
        ajk();
        if (this.cxd != null) {
            this.cxd.onSuccess();
        }
        this.cxs = true;
        this.cnc = z;
        this.cxt = size;
        ajs();
    }

    public void eU(boolean z) {
        if (z) {
            this.cxj.notifyDataSetChanged();
        }
        if (!ajn()) {
            aju();
        }
    }

    public void onDestroy() {
        if (this.aRf != null) {
            this.aRf.destroy();
        }
        if (this.cxn != null) {
            this.cxn.onDestroy();
        }
        if (this.cxl != null) {
            this.cxl.onDestroy();
        }
    }

    public void onPause() {
        jR(this.cxC);
        jP(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jP(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jP(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$15
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean ajn() {
        if (eV(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("close_new_user_guide_tip", false)) {
                eW(true);
            }
            ajv();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ajo() {
        if (this.cxd != null) {
            this.cxd.aw((this.cxe == null || this.cxe.thread_list == null || ajt()) ? 0 : this.cxe.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cxf = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !ajt()) {
                if (this.cxd != null) {
                    this.cxd.onSuccess();
                }
                aju();
                return;
            }
            ajo();
            return;
        }
        ajo();
    }

    private void ajp() {
        boolean z;
        boolean z2;
        if (this.cxe != null) {
            if (this.cxe.age_sex != null) {
                if (this.cxe.age_sex.sex_tag != null && this.cxe.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cxe.age_sex.sex_tag.iterator();
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
                        gVar.cyX = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                    }
                }
                if (this.cxe.age_sex.age_tag != null && this.cxe.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cxe.age_sex.age_tag.iterator();
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
                        gVar2.cyX = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar2));
                    }
                }
            }
            if (this.cxe.age_sex == null && this.cxe.interestion != null && this.cxe.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cxe.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private void bb(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.q(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.Ti() != null) {
                        dVar.Ti().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.Ti().advertAppContext.Tw = "NEWINDEX";
                        dVar.Ti().advertAppContext.pn = 1;
                        dVar.Ti().advertAppContext.extensionInfo = dVar.Ti().extensionInfo;
                        dVar.Ti().advertAppContext.TB = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cxg = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && ajt()) {
                this.cxe = null;
            }
            int size = z2 ? 0 : this.aSB.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aSB.clear();
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cxm.a(z, this.cxe, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.aPK;
                this.cxi = a2.czf;
                list = list2;
            }
            if (list != null) {
                this.aSB.addAll(list);
                if (z2) {
                    bb(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.cxu) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cxe == null) {
                this.cxe = builder;
            }
            ajp();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cxd != null) {
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
                this.cxd.ba(arrayList);
            }
            if (this.aSB.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aSB);
                this.cxj.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cxj.bc(linkedList);
                if (this.aRf != null && this.cxr) {
                    this.aRf.a(this.aRj, this.aRi, this.aRh, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.ait().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jE = com.baidu.tieba.homepage.framework.a.ait().jE(1);
            if (jE > 0) {
                com.baidu.tieba.homepage.framework.a.ait().e(System.currentTimeMillis() - jE, 1);
                com.baidu.tieba.homepage.framework.a.ait().f(0L, 1);
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
                    eVar.dxM = next.lego_page_id.longValue();
                    eVar.dxN = com.baidu.tieba.tbadkCore.t.pV(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.t.pT(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.t.pW(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void ajq() {
        if (com.baidu.tbadk.core.util.x.p(this.aSB) >= this.cxm.ajD() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cxm.a(true, this.cxe, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aPK : null;
            if (list != null) {
                this.aSB.clear();
                this.aSB.addAll(list);
                this.cxj.bc(new LinkedList(this.aSB));
            }
        }
    }

    private void ajr() {
        com.baidu.tbadk.util.t.a(new v(this), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        if (this.cxe != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cxe.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(String str) {
        if (!TextUtils.isEmpty(str) && this.cxe != null && this.cxe.banner_list != null && this.cxe.banner_list.app != null && this.cxe.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cxe.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cxe.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cxe.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(DataRes.Builder builder) {
        com.baidu.tbadk.util.t.a(new x(this, builder), null);
    }

    private boolean ajt() {
        return eV(true);
    }

    private boolean eV(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cxc;
    }

    public void a(a aVar) {
        this.cxd = aVar;
    }

    private boolean xj() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aju() {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("recommend_frs_guide_time", 0L);
        if (this.cxg != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cxg) {
                ax(1, 0);
            }
        }
    }

    private void ax(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cxo != null && this.cxo.aiK()) {
            this.cxl.aaN();
        } else if (this.cxo == null || this.cxo.getCurrentItem() <= 0) {
            this.cxh = i;
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
                if (this.abo == null) {
                    this.abo = new TextView(this.mPageContext.getPageActivity());
                    this.abo.setGravity(17);
                    this.abo.setOnClickListener(this.cxv);
                    setHeaderViewHeight(this.cxp.getMeasuredHeight());
                }
                this.cxl.aaN();
                if (this.cxp != null && this.abo.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.hj()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                            this.abo.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.abo.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.uL().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aq.j(this.abo, w.g.bg_home_float);
                            aq.i(this.abo, w.e.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.abo.setPadding(0, 0, 0, 0);
                        this.abo.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                        aq.j(this.abo, w.e.common_color_10260);
                        aq.i(this.abo, w.e.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.abo.setText(str);
                    if (i == 1) {
                        this.bQC = 4000;
                    } else {
                        this.bQC = 2000;
                    }
                    this.cxl.a(this.abo, this.cxp, layoutParams, this.bQC);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("close_new_user_guide_tip", true);
        if (this.cxe != null && this.cxe.age_sex != null) {
            this.cxe.age_sex = null;
            if (z) {
                ajs();
            }
        }
        if (this.aSB != null && this.aSB.size() > 0 && (this.aSB.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aSB.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aSB != null) {
            this.cxj.bc(new ArrayList(this.aSB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajv() {
        if (this.cxe != null && this.cxe.interestion != null) {
            this.cxe.interestion = null;
            ajs();
        }
        if (this.aSB != null && this.aSB.size() > 0 && (this.aSB.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aSB.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aSB != null) {
            this.cxj.bc(new ArrayList(this.aSB));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.amd != null) {
                this.amd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.amd);
            }
            if (this.cxw != null) {
                this.cxw.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxw);
            }
            if (this.cxx != null) {
                this.cxx.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxx);
            }
            if (this.cxy != null) {
                this.cxy.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxy);
            }
            if (this.cxz != null) {
                this.cxz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxz);
            }
            this.cxA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxA);
            this.amU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amU);
            this.bYo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bYo);
            this.bYp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bYp);
        }
    }

    public void ajw() {
        this.bMz = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bMz.bhM();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bMz != null) {
            if (i == 0) {
                this.bMz.bhM();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.fvq;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bMz.bn(i3, i7 + 1);
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

    public void jQ(int i) {
        if ((this.bMz != null ? this.bMz.rP(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bMz.rQ(i);
        }
    }

    public com.baidu.tieba.play.ac Lc() {
        return this.aRf;
    }

    public void eX(boolean z) {
        this.cxr = z;
    }

    public void jR(int i) {
        com.baidu.tbadk.util.t.a(new y(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new aa(this), new ab(this, mVar));
    }

    public void ajx() {
        a(this.cxD);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).Ti();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ah) {
                        com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                        if (ahVar.ra() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.ra()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.TR)) {
                    advertAppInfo2 = advertAppInfo;
                } else {
                    it.remove();
                    advertAppInfo2 = null;
                }
            }
        }
    }
}
