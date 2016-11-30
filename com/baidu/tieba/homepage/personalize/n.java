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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.cs;
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
    private final BdTypeListView aML;
    private com.baidu.tieba.play.aa aMM;
    private com.baidu.tieba.d.a aMN;
    private final com.baidu.adp.base.h<?> aUn;
    private View aha;
    private com.baidu.tieba.tbadkCore.data.f bRS;
    private boolean cBz;
    public com.baidu.tieba.homepage.framework.b.a cJB;
    private final long cKI;
    private DataRes.Builder cKK;
    private final com.baidu.tieba.homepage.personalize.b.ac cKP;
    private final FrameLayout cKQ;
    private cs cKR;
    private final com.baidu.tieba.homepage.personalize.c.a cKS;
    private ScrollFragmentTabHost cKU;
    private ViewGroup cKV;
    private View.OnTouchListener cKW;
    private int cLa;
    private a cKJ = null;
    private final List<com.baidu.adp.widget.ListView.v> aOf = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cKL = false;
    private long cKM = 0;
    private int cKN = 1;
    private int cKO = 0;
    private TextView Xc = null;
    private int bWh = 2000;
    public com.baidu.tbadk.performanceLog.m cKT = null;
    private boolean aMO = false;
    private int aMQ = 0;
    private int aMP = 0;
    private boolean cKX = false;
    private boolean cKY = true;
    private boolean cKZ = false;
    private boolean cLb = false;
    private AbsListView.OnScrollListener BL = new o(this);
    private View.OnTouchListener aKw = new z(this);
    private a.InterfaceC0058a aMT = new ab(this);
    private View.OnClickListener cLc = new ac(this);
    private final CustomMessageListener cLd = new ad(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cLe = new ae(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cLf = new af(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cLg = new ag(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cLh = new ah(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener ahI = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aiv = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cLi = "lastReadReadPositionKey";
    private int cLj = 0;
    private m cLk = new r(this);
    private CustomMessageListener cLl = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    /* loaded from: classes.dex */
    public interface a {
        void aA(int i, int i2);

        void bw(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void u(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cJB = eVar.aoh();
            this.cKV = eVar.YN();
            this.cKW = eVar.aoi();
        }
    }

    public void aaf() {
        if (this.cJB != null) {
            this.cJB.fk(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cKU = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.Xc != null && this.Xc.getParent() != null && this.Xc.getVisibility() != 8) {
                i2 = (i2 - this.Xc.getMeasuredHeight()) - as(this.Xc);
            }
            kl(i2);
        }
    }

    private void kl(int i) {
        if (this.aha != null && this.aha.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aha.getLayoutParams();
            layoutParams.height = i;
            this.aha.setLayoutParams(layoutParams);
        }
    }

    private int as(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.cKX = z;
    }

    public void dT(boolean z) {
        this.cKX = z;
        if (this.aMM != null) {
            this.aMM.ky(!z);
            if (z) {
                this.aMM.aro();
            } else if (this.cKY) {
                this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
            }
        }
    }

    public n(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ac acVar, FrameLayout frameLayout) {
        this.aUn = hVar;
        this.aML = bdTypeListView;
        this.aha = view;
        this.aML.setOnTouchListener(this.aKw);
        this.aMN = new com.baidu.tieba.d.a();
        this.aMN.a(this.aMT);
        this.cKQ = frameLayout;
        this.cKP = acVar;
        this.cKS = new com.baidu.tieba.homepage.personalize.c.a();
        this.cKI = com.baidu.tbadk.core.sharedPref.b.um().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.BL);
        this.cKR = new cs();
        aoJ();
        this.aMM = new com.baidu.tieba.play.aa(this.aUn, this.aML);
    }

    private boolean aow() {
        return com.baidu.tbadk.core.sharedPref.b.um().getBoolean(aoy(), true);
    }

    private void aox() {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean(aoy(), false);
    }

    private String aoy() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.anF().ka(1) == -1) {
            com.baidu.tieba.homepage.framework.a.anF().g(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cLb = true;
        if (this.aOf.size() == 0 && !this.cKL && !aow()) {
            aoE();
        } else {
            aoB();
        }
    }

    public void aoz() {
        if (this.aMM != null && !this.cKX && this.cKY) {
            this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
        }
        if (this.cKZ) {
            if (this.cBz && this.cKO > 0) {
                if (fp(false)) {
                    aB(3, this.cKO);
                } else if (this.cLa > 0) {
                    aB(2, this.cKO);
                }
            } else if (!this.cBz && this.cKO == 0) {
                aB(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.um().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cKZ = false;
            this.cBz = false;
            this.cLa = 0;
            if (this.cLb) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cLb = false;
        }
    }

    public void acw() {
        if (!wL() && this.cKJ != null) {
            aoD();
            this.mPn++;
            setIsLoading(true);
            this.cKJ.u(this.mPn, (this.cKK == null || this.cKK.thread_list == null) ? 0 : this.cKK.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.aML.l(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.um().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cKK == null || this.cKK.thread_list == null) ? 0 : this.cKK.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cKZ = false;
            if (this.aOf.size() > 0) {
                if (this.cKJ != null) {
                    this.cKJ.onError(1, str);
                    return;
                }
                return;
            } else if (this.cKJ != null) {
                this.cKJ.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aox();
        if (this.cKJ != null) {
            this.cKJ.onSuccess();
        }
        this.cKZ = true;
        this.cBz = z;
        this.cLa = size;
        aoF();
    }

    public void fo(boolean z) {
        if (z) {
            this.cKP.notifyDataSetChanged();
        }
        if (!aoA()) {
            aoH();
        }
    }

    public void onDestroy() {
        if (this.aMM != null) {
            this.aMM.destroy();
        }
        if (this.cKT != null) {
            this.cKT.onDestroy();
        }
        if (this.cKR != null) {
            this.cKR.onDestroy();
        }
    }

    public void onPause() {
        ko(this.cLj);
        km(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        km(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void km(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.aUn.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$14
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aoA() {
        if (fp(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.um().getBoolean("close_new_user_guide_tip", false)) {
                fq(true);
            }
            aoI();
            if (this.aML != null) {
                this.aML.setSelection(0);
                this.aML.kv();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aoB() {
        if (this.cKJ != null) {
            this.cKJ.aA((this.cKK == null || this.cKK.thread_list == null || aoG()) ? 0 : this.cKK.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cKL = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !aoG()) {
                if (this.cKJ != null) {
                    this.cKJ.onSuccess();
                }
                aoH();
                return;
            }
            aoB();
            return;
        }
        aoB();
    }

    private void aoC() {
        boolean z;
        boolean z2;
        if (this.cKK != null) {
            if (this.cKK.age_sex != null) {
                if (this.cKK.age_sex.sex_tag != null && this.cKK.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cKK.age_sex.sex_tag.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        TagStruct next = it.next();
                        if (next != null && !StringUtils.isNull(next.tag_name) && next.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, com.baidu.tieba.homepage.personalize.data.i.a(next)));
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = new com.baidu.tieba.homepage.personalize.data.i();
                        iVar.cMQ = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                    }
                }
                if (this.cKK.age_sex.age_tag != null && this.cKK.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cKK.age_sex.age_tag.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        TagStruct next2 = it2.next();
                        if (next2 != null && !StringUtils.isNull(next2.tag_name) && next2.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, com.baidu.tieba.homepage.personalize.data.i.a(next2)));
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        com.baidu.tieba.homepage.personalize.data.i iVar2 = new com.baidu.tieba.homepage.personalize.data.i();
                        iVar2.cMQ = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar2));
                    }
                }
            }
            if (this.cKK.age_sex == null && this.cKK.interestion != null && this.cKK.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cKK.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private void bx(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.t(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.PA() != null) {
                        dVar.PA().PD = new com.baidu.tbadk.core.data.b();
                        dVar.PA().PD.OS = "NEWINDEX";
                        dVar.PA().PD.pn = 1;
                        dVar.PA().PD.extensionInfo = dVar.PA().extensionInfo;
                        dVar.PA().PD.OX = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cKM = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && aoG()) {
                this.cKK = null;
            }
            int size = z2 ? 0 : this.aOf.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aOf.clear();
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cKS.a(z, this.cKK, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.cMY;
                this.cKO = a2.cMZ;
                list = list2;
            }
            if (list != null) {
                this.aOf.addAll(list);
                if (z2) {
                    bx(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.cLb) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cKK == null) {
                this.cKK = builder;
            }
            aoC();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cKJ != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aUn.getString(r.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                W(arrayList);
                this.cKJ.bw(arrayList);
            }
            if (this.aOf.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aOf);
                this.cKP.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cKP.by(linkedList);
                if (this.aMM != null && this.cKY) {
                    this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.anF().e(System.currentTimeMillis() - currentTimeMillis, 1);
            long ka = com.baidu.tieba.homepage.framework.a.anF().ka(1);
            if (ka > 0) {
                com.baidu.tieba.homepage.framework.a.anF().f(System.currentTimeMillis() - ka, 1);
                com.baidu.tieba.homepage.framework.a.anF().g(0L, 1);
            }
        }
        return r1;
    }

    private void W(ArrayList<TagInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<TagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TagInfo next = it.next();
                if (next.tag_type.intValue() == 5) {
                    com.baidu.tieba.lego.c.e eVar = new com.baidu.tieba.lego.c.e();
                    eVar.dLo = next.lego_page_id.longValue();
                    eVar.dLp = com.baidu.tieba.tbadkCore.v.rx(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.v.rv(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.v.ry(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void aoD() {
        if (com.baidu.tbadk.core.util.x.s(this.aOf) >= this.cKS.aoP() - 40) {
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cKS.a(true, this.cKK, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.cMY : null;
            if (list != null) {
                this.aOf.clear();
                this.aOf.addAll(list);
                this.cKP.by(new LinkedList(this.aOf));
            }
        }
    }

    private void aoE() {
        com.baidu.tbadk.util.t.a(new u(this), new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoF() {
        if (this.cKK != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cKK.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.t.a(new w(this, builder), null);
        }
    }

    private boolean aoG() {
        return fp(true);
    }

    private boolean fp(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.um().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cKI;
    }

    public void a(a aVar) {
        this.cKJ = aVar;
    }

    private boolean wL() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoH() {
        long j = com.baidu.tbadk.core.sharedPref.b.um().getLong("recommend_frs_guide_time", 0L);
        if (this.cKM != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cKM) {
                aB(1, 0);
            }
        }
    }

    private void aB(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cKU != null && this.cKU.anV()) {
            this.cKR.adP();
        } else if (this.cKU == null || this.cKU.getCurrentItem() <= 0) {
            this.cKN = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m9getInst().getString(r.j.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.Xc == null) {
                    this.Xc = new TextView(this.aUn.getPageActivity());
                    this.Xc.setGravity(17);
                    this.Xc.setOnClickListener(this.cLc);
                    kl(this.cKV.getMeasuredHeight());
                }
                this.cKR.adP();
                if (this.cKV != null && this.Xc.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int dimensionPixelSize = this.aUn.getResources().getDimensionPixelSize(r.e.ds20);
                            int dimensionPixelSize2 = this.aUn.getResources().getDimensionPixelSize(r.e.ds40);
                            this.Xc.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.Xc.setTextSize(0, this.aUn.getResources().getDimensionPixelSize(r.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.um().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            at.k(this.Xc, r.f.bg_home_float);
                            at.j((View) this.Xc, r.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.Xc.setPadding(0, 0, 0, 0);
                        this.Xc.setTextSize(0, this.aUn.getResources().getDimensionPixelSize(r.e.fontsize24));
                        at.k(this.Xc, r.d.common_color_10260);
                        at.j((View) this.Xc, r.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.Xc.setText(str);
                    if (i == 1) {
                        this.bWh = 4000;
                    } else {
                        this.bWh = 2000;
                    }
                    this.cKR.a(this.Xc, this.cKV, layoutParams, this.bWh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("close_new_user_guide_tip", true);
        if (this.cKK != null && this.cKK.age_sex != null) {
            this.cKK.age_sex = null;
            if (z) {
                aoF();
            }
        }
        if (this.aOf != null && this.aOf.size() > 0 && (this.aOf.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j)) {
            this.aOf.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aOf != null) {
            this.cKP.by(new ArrayList(this.aOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        if (this.cKK != null && this.cKK.interestion != null) {
            this.cKK.interestion = null;
            aoF();
        }
        if (this.aOf != null && this.aOf.size() > 0 && (this.aOf.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aOf.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aOf != null) {
            this.cKP.by(new ArrayList(this.aOf));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ahI != null) {
                this.ahI.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ahI);
            }
            if (this.cLd != null) {
                this.cLd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cLd);
            }
            if (this.cLe != null) {
                this.cLe.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cLe);
            }
            if (this.cLf != null) {
                this.cLf.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cLf);
            }
            if (this.cLg != null) {
                this.cLg.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cLg);
            }
            this.cLh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cLh);
            this.aiv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aiv);
            this.cLl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cLl);
        }
    }

    public void aoJ() {
        this.bRS = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bRS.blJ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bRS != null) {
            if (i == 0) {
                this.bRS.blJ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.fBS;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bRS.bv(i3, i7 + 1);
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

    public void kn(int i) {
        if ((this.bRS != null ? this.bRS.sc(i) : -1) >= 0 && this.aML != null && this.aML.getData() != null && this.aML.getData().size() > i) {
            this.bRS.sd(i);
        }
    }

    public com.baidu.tieba.play.aa Kp() {
        return this.aMM;
    }

    public void fr(boolean z) {
        this.cKY = z;
    }

    public void ko(int i) {
        com.baidu.tbadk.util.t.a(new x(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new y(this), new aa(this, mVar));
    }

    public void aoK() {
        a(this.cLk);
    }
}
