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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tieba.play.ac aLe;
    private com.baidu.tieba.f.a aLf;
    private View afF;
    private com.baidu.tieba.tbadkCore.data.e bFB;
    private boolean cne;
    public com.baidu.tieba.homepage.framework.b.a cvY;
    private final long cxd;
    private DataRes.Builder cxf;
    private final com.baidu.tieba.homepage.personalize.b.ad cxk;
    private final FrameLayout cxl;
    private co cxm;
    private final com.baidu.tieba.homepage.personalize.model.a cxn;
    private ScrollFragmentTabHost cxp;
    private ViewGroup cxq;
    private View.OnTouchListener cxr;
    private int cxu;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cxe = null;
    private final List<com.baidu.adp.widget.ListView.v> aMy = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cxg = false;
    private long cxh = 0;
    private int cxi = 1;
    private int cxj = 0;
    private TextView VM = null;
    private int bJH = 2000;
    public com.baidu.tbadk.performanceLog.m cxo = null;
    private boolean aLg = false;
    private int aLi = 0;
    private int aLh = 0;
    private boolean mIsBackground = false;
    private boolean cxs = true;
    private boolean cxt = false;
    private boolean cxv = false;
    private boolean cxw = false;
    private boolean cxx = false;
    private AbsListView.OnScrollListener mOnScrollListener = new o(this);
    private View.OnTouchListener aIu = new z(this);
    private a.InterfaceC0057a aLl = new ab(this);
    private View.OnClickListener cxy = new ac(this);
    private final CustomMessageListener cxz = new ad(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cxA = new ae(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cxB = new af(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cxC = new ag(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cxD = new ah(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener agw = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener ahk = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cxE = "lastReadReadPositionKey";
    private int cxF = 0;
    private m cxG = new r(this);
    private CustomMessageListener cxH = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    /* loaded from: classes.dex */
    public interface a {
        void av(int i, int i2);

        void bu(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cvY = eVar.ajP();
            this.cxq = eVar.Ut();
            this.cxr = eVar.ajQ();
        }
    }

    public void VN() {
        if (this.cvY != null) {
            this.cvY.eZ(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxp = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.VM != null && this.VM.getParent() != null && this.VM.getVisibility() != 8) {
                i2 = (i2 - this.VM.getMeasuredHeight()) - ax(this.VM);
            }
            kj(i2);
        }
    }

    private void kj(int i) {
        if (this.afF != null && this.afF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.afF.getLayoutParams();
            layoutParams.height = i;
            this.afF.setLayoutParams(layoutParams);
        }
    }

    private int ax(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
        if (!this.cxx && z) {
            this.cxx = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP, false));
        }
    }

    public void dH(boolean z) {
        this.mIsBackground = z;
        if (this.aLe != null) {
            this.aLe.gY(!z);
            if (z) {
                this.aLe.amY();
            } else if (this.cxs) {
                this.aLe.a(this.aLi, this.aLh, this.aLg, true);
            }
        }
    }

    public n(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ad adVar, FrameLayout frameLayout) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.afF = view;
        this.mListView.setOnTouchListener(this.aIu);
        this.aLf = new com.baidu.tieba.f.a();
        this.aLf.a(this.aLl);
        this.cxl = frameLayout;
        this.cxk = adVar;
        this.cxn = new com.baidu.tieba.homepage.personalize.model.a();
        this.cxd = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cxm = new co();
        akq();
        this.aLe = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean akd() {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean(akf(), true);
    }

    private void ake() {
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean(akf(), false);
    }

    private String akf() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.ajm().jY(1) == -1) {
            com.baidu.tieba.homepage.framework.a.ajm().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cxv = true;
        if (this.aMy.size() == 0 && !this.cxg && !akd()) {
            akl();
        } else {
            aki();
        }
    }

    public void akg() {
        if (this.aLe != null && !this.mIsBackground && this.cxs) {
            this.aLe.a(this.aLi, this.aLh, this.aLg, true);
        }
        if (this.cxt) {
            if (this.cne && this.cxj > 0) {
                if (fe(false)) {
                    aw(3, this.cxj);
                } else if (this.cxu > 0) {
                    aw(2, this.cxj);
                }
            } else if (!this.cne && this.cxj == 0) {
                aw(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.tQ().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cxt = false;
            this.cne = false;
            this.cxu = 0;
            if (this.cxv) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cxv = false;
        }
    }

    public void Ya() {
        if (!wq() && this.cxe != null) {
            akk();
            this.mPn++;
            setIsLoading(true);
            this.cxe.v(this.mPn, (this.cxf == null || this.cxf.thread_list == null) ? 0 : this.cxf.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cxf == null || this.cxf.thread_list == null) ? 0 : this.cxf.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cxt = false;
            if (this.aMy.size() > 0) {
                if (this.cxe != null) {
                    this.cxe.onError(1, str);
                }
            } else if (this.cxe != null) {
                this.cxe.onError(2, str);
            }
        } else {
            ake();
            if (this.cxe != null) {
                this.cxe.onSuccess();
            }
            this.cxt = true;
            this.cne = z;
            this.cxu = size;
            akm();
        }
        if (!this.cxw) {
            this.cxw = true;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP, true));
        }
    }

    public void fd(boolean z) {
        if (z) {
            this.cxk.notifyDataSetChanged();
        }
        if (!akh()) {
            ako();
        }
    }

    public void onDestroy() {
        if (this.aLe != null) {
            this.aLe.destroy();
        }
        if (this.cxo != null) {
            this.cxo.onDestroy();
        }
        if (this.cxm != null) {
            this.cxm.onDestroy();
        }
    }

    public void onPause() {
        km(this.cxF);
        kk(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        kk(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void kk(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$14
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean akh() {
        if (fe(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("close_new_user_guide_tip", false)) {
                ff(true);
            }
            akp();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aki() {
        if (this.cxe != null) {
            this.cxe.av((this.cxf == null || this.cxf.thread_list == null || akn()) ? 0 : this.cxf.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cxg = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !akn()) {
                if (this.cxe != null) {
                    this.cxe.onSuccess();
                }
                ako();
            } else {
                aki();
            }
        } else {
            aki();
        }
        if (!this.cxw) {
            this.cxw = true;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP, true));
        }
    }

    private void akj() {
        boolean z;
        boolean z2;
        if (this.cxf != null) {
            if (this.cxf.age_sex != null) {
                if (this.cxf.age_sex.sex_tag != null && this.cxf.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cxf.age_sex.sex_tag.iterator();
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
                        gVar.czb = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                    }
                }
                if (this.cxf.age_sex.age_tag != null && this.cxf.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cxf.age_sex.age_tag.iterator();
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
                        gVar2.czb = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar2));
                    }
                }
            }
            if (this.cxf.age_sex == null && this.cxf.interestion != null && this.cxf.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cxf.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private void bv(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.w.s(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.RM() != null) {
                        dVar.RM().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.RM().advertAppContext.Oa = "NEWINDEX";
                        dVar.RM().advertAppContext.pn = 1;
                        dVar.RM().advertAppContext.extensionInfo = dVar.RM().extensionInfo;
                        dVar.RM().advertAppContext.Of = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cxh = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && akn()) {
                this.cxf = null;
            }
            int size = z2 ? 0 : this.aMy.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aMy.clear();
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cxn.a(z, this.cxf, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.aJL;
                this.cxj = a2.czj;
                list = list2;
            }
            if (list != null) {
                this.aMy.addAll(list);
                if (z2) {
                    bv(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.cxv) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cxf == null) {
                this.cxf = builder;
            }
            akj();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cxe != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.w.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.mPageContext.getString(r.l.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.w.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                P(arrayList);
                this.cxe.bu(arrayList);
            }
            if (this.aMy.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aMy);
                this.cxk.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cxk.bw(linkedList);
                if (this.aLe != null && this.cxs) {
                    this.aLe.a(this.aLi, this.aLh, this.aLg, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.ajm().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jY = com.baidu.tieba.homepage.framework.a.ajm().jY(1);
            if (jY > 0) {
                com.baidu.tieba.homepage.framework.a.ajm().e(System.currentTimeMillis() - jY, 1);
                com.baidu.tieba.homepage.framework.a.ajm().f(0L, 1);
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
                    eVar.dyG = next.lego_page_id.longValue();
                    eVar.dyH = com.baidu.tieba.tbadkCore.t.qv(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.t.qt(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.t.qw(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void akk() {
        if (com.baidu.tbadk.core.util.w.r(this.aMy) >= this.cxn.akx() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cxn.a(true, this.cxf, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aJL : null;
            if (list != null) {
                this.aMy.clear();
                this.aMy.addAll(list);
                this.cxk.bw(new LinkedList(this.aMy));
            }
        }
    }

    private void akl() {
        com.baidu.tbadk.util.t.a(new u(this), new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akm() {
        if (this.cxf != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cxf.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.t.a(new w(this, builder), null);
        }
    }

    private boolean akn() {
        return fe(true);
    }

    private boolean fe(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cxd;
    }

    public void a(a aVar) {
        this.cxe = aVar;
    }

    private boolean wq() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("recommend_frs_guide_time", 0L);
        if (this.cxh != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cxh) {
                aw(1, 0);
            }
        }
    }

    private void aw(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cxp != null && this.cxp.ajD()) {
            this.cxm.Zs();
        } else if (this.cxp == null || this.cxp.getCurrentItem() <= 0) {
            this.cxi = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m9getInst().getString(r.l.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.VM == null) {
                    this.VM = new TextView(this.mPageContext.getPageActivity());
                    this.VM.setGravity(17);
                    this.VM.setOnClickListener(this.cxy);
                    kj(this.cxq.getMeasuredHeight());
                }
                this.cxm.Zs();
                if (this.cxq != null && this.VM.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.gk()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(r.f.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(r.f.ds40);
                            this.VM.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.VM.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(r.f.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.tQ().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            ap.j((View) this.VM, r.g.bg_home_float);
                            ap.i((View) this.VM, r.e.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.VM.setPadding(0, 0, 0, 0);
                        this.VM.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(r.f.fontsize24));
                        ap.j((View) this.VM, r.e.common_color_10260);
                        ap.i((View) this.VM, r.e.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.VM.setText(str);
                    if (i == 1) {
                        this.bJH = 4000;
                    } else {
                        this.bJH = 2000;
                    }
                    this.cxm.a(this.VM, this.cxq, layoutParams, this.bJH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("close_new_user_guide_tip", true);
        if (this.cxf != null && this.cxf.age_sex != null) {
            this.cxf.age_sex = null;
            if (z) {
                akm();
            }
        }
        if (this.aMy != null && this.aMy.size() > 0 && (this.aMy.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aMy.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aMy != null) {
            this.cxk.bw(new ArrayList(this.aMy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.cxf != null && this.cxf.interestion != null) {
            this.cxf.interestion = null;
            akm();
        }
        if (this.aMy != null && this.aMy.size() > 0 && (this.aMy.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aMy.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aMy != null) {
            this.cxk.bw(new ArrayList(this.aMy));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.agw != null) {
                this.agw.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.agw);
            }
            if (this.cxz != null) {
                this.cxz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxz);
            }
            if (this.cxA != null) {
                this.cxA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxA);
            }
            if (this.cxB != null) {
                this.cxB.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxB);
            }
            if (this.cxC != null) {
                this.cxC.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cxC);
            }
            this.cxD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxD);
            this.ahk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahk);
            this.cxH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxH);
        }
    }

    public void akq() {
        this.bFB = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bFB.bho();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bFB != null) {
            if (i == 0) {
                this.bFB.bho();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.fpl;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bFB.bl(i3, i7 + 1);
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

    public void kl(int i) {
        if ((this.bFB != null ? this.bFB.rS(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bFB.rT(i);
        }
    }

    public com.baidu.tieba.play.ac JX() {
        return this.aLe;
    }

    public void fg(boolean z) {
        this.cxs = z;
    }

    public void km(int i) {
        com.baidu.tbadk.util.t.a(new x(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new y(this), new aa(this, mVar));
    }

    public void akr() {
        a(this.cxG);
    }
}
