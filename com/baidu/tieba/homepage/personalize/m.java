package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d.a;
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
public class m {
    private com.baidu.tieba.play.k aMo;
    private com.baidu.tieba.d.a aMp;
    private final com.baidu.adp.base.h<?> aSm;
    private View agA;
    private final BdTypeListView bCe;
    private com.baidu.tieba.tbadkCore.data.f bPe;
    public com.baidu.tieba.homepage.framework.b.a cEo;
    private final com.baidu.tieba.homepage.personalize.b.ac cFB;
    private final FrameLayout cFC;
    private final com.baidu.tieba.homepage.personalize.c.a cFE;
    private ScrollFragmentTabHost cFG;
    private ViewGroup cFH;
    private View.OnTouchListener cFI;
    private int cFM;
    private final Animation cFQ;
    private final TranslateAnimation cFR;
    private final long cFu;
    private DataRes.Builder cFw;
    private boolean cwq;
    private a cFv = null;
    private final List<com.baidu.adp.widget.ListView.v> aMf = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cFx = false;
    private long cFy = 0;
    private int cFz = 1;
    private int cFA = 0;
    private TextView WE = null;
    private int cFD = 2000;
    public com.baidu.tbadk.performanceLog.m cFF = null;
    private boolean aMq = false;
    private int aMt = 0;
    private int aMs = 0;
    private boolean cFJ = false;
    private boolean cFK = true;
    private boolean cFL = false;
    private boolean cFN = false;
    private AbsListView.OnScrollListener BL = new n(this);
    private View.OnTouchListener aJD = new y(this);
    private a.InterfaceC0058a aMy = new ad(this);
    private Runnable cFO = new ae(this);
    private View.OnClickListener cFP = new af(this);
    private final CustomMessageListener cFS = new ag(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cFT = new ah(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cFU = new ai(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cFV = new aj(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cFW = new o(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener ahi = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener ahO = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cFX = "lastReadReadPositionKey";
    private int cFY = 0;
    private l cFZ = new r(this);
    private CustomMessageListener cGa = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    /* loaded from: classes.dex */
    public interface a {
        void az(int i, int i2);

        void bu(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.cEo = eVar.amm();
            this.cFH = eVar.XL();
            this.cFI = eVar.amn();
        }
    }

    public void Zd() {
        if (this.cEo != null) {
            this.cEo.eV(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cFG = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.WE != null && this.WE.getParent() != null && this.WE.getVisibility() != 8) {
                i2 = (i2 - this.WE.getMeasuredHeight()) - as(this.WE);
            }
            ke(i2);
        }
    }

    private void ke(int i) {
        if (this.agA != null && this.agA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.agA.getLayoutParams();
            layoutParams.height = i;
            this.agA.setLayoutParams(layoutParams);
        }
    }

    private int as(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.cFJ = z;
    }

    public void dM(boolean z) {
        this.cFJ = z;
        if (this.aMo != null) {
            this.aMo.jX(!z);
            if (z) {
                this.aMo.bap();
            } else if (this.cFK) {
                this.aMo.a(this.aMt, this.aMs, this.aMq, true);
            }
        }
    }

    public m(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ac acVar, FrameLayout frameLayout) {
        this.aSm = hVar;
        this.bCe = bdTypeListView;
        this.agA = view;
        this.bCe.setOnTouchListener(this.aJD);
        this.aMp = new com.baidu.tieba.d.a();
        this.aMp.a(this.aMy);
        this.cFC = frameLayout;
        this.cFB = acVar;
        this.cFE = new com.baidu.tieba.homepage.personalize.c.a();
        this.cFu = com.baidu.tbadk.core.sharedPref.b.uh().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.BL);
        this.cFQ = AnimationUtils.loadAnimation(hVar.getPageActivity(), r.a.fade_out);
        this.cFQ.setAnimationListener(new u(this));
        this.cFR = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds56), 0.0f);
        this.cFR.setDuration(400L);
        this.cFR.setAnimationListener(new v(this));
        amP();
        this.aMo = new com.baidu.tieba.play.k(this.aSm, this.bCe);
    }

    private boolean amB() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getBoolean(amD(), true);
    }

    private void amC() {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean(amD(), false);
    }

    private String amD() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.alK().jT(1) == -1) {
            com.baidu.tieba.homepage.framework.a.alK().g(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cFN = true;
        if (this.aMf.size() == 0 && !this.cFx && !amB()) {
            amJ();
        } else {
            amG();
        }
    }

    public void amE() {
        if (this.aMo != null && !this.cFJ && this.cFK) {
            this.aMo.a(this.aMt, this.aMs, this.aMq, true);
        }
        if (this.cFL) {
            if (this.cwq && this.cFA > 0) {
                if (fa(false)) {
                    aA(3, this.cFA);
                } else if (this.cFM > 0) {
                    aA(2, this.cFA);
                }
            } else if (!this.cwq && this.cFA == 0) {
                aA(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.uh().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cFL = false;
            this.cwq = false;
            this.cFM = 0;
            if (this.cFN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cFN = false;
        }
    }

    public void abm() {
        if (!wG() && this.cFv != null) {
            amI();
            this.mPn++;
            setIsLoading(true);
            this.cFv.v(this.mPn, (this.cFw == null || this.cFw.thread_list == null) ? 0 : this.cFw.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.bCe.l(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.uh().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cFw == null || this.cFw.thread_list == null) ? 0 : this.cFw.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cFL = false;
            if (this.aMf.size() > 0) {
                if (this.cFv != null) {
                    this.cFv.onError(1, str);
                    return;
                }
                return;
            } else if (this.cFv != null) {
                this.cFv.onError(2, str);
                return;
            } else {
                return;
            }
        }
        amC();
        if (this.cFv != null) {
            this.cFv.onSuccess();
        }
        this.cFL = true;
        this.cwq = z;
        this.cFM = size;
        amK();
    }

    public void eZ(boolean z) {
        if (z) {
            this.cFB.notifyDataSetChanged();
        }
        if (!amF()) {
            amM();
        }
    }

    public void onDestroy() {
        if (this.aMo != null) {
            this.aMo.destroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cFO);
        if (this.cFF != null) {
            this.cFF.onDestroy();
        }
    }

    public void onPause() {
        kh(this.cFY);
        kf(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        kf(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void kf(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.aSm.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$17
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean amF() {
        if (fa(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("close_new_user_guide_tip", false)) {
                fb(true);
            }
            amO();
            if (this.bCe != null) {
                this.bCe.setSelection(0);
                this.bCe.kv();
                return true;
            }
            return true;
        }
        return false;
    }

    private void amG() {
        if (this.cFv != null) {
            this.cFv.az((this.cFw == null || this.cFw.thread_list == null || amL()) ? 0 : this.cFw.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cFx = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !amL()) {
                if (this.cFv != null) {
                    this.cFv.onSuccess();
                }
                amM();
                return;
            }
            amG();
            return;
        }
        amG();
    }

    private void amH() {
        boolean z;
        boolean z2;
        if (this.cFw != null) {
            if (this.cFw.age_sex != null) {
                if (this.cFw.age_sex.sex_tag != null && this.cFw.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cFw.age_sex.sex_tag.iterator();
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
                        iVar.cHD = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                    }
                }
                if (this.cFw.age_sex.age_tag != null && this.cFw.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cFw.age_sex.age_tag.iterator();
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
                        iVar2.cHD = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar2));
                    }
                }
            }
            if (this.cFw.age_sex == null && this.cFw.interestion != null && this.cFw.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cFw.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cFy = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && amL()) {
                this.cFw = null;
            }
            int size = z2 ? 0 : this.aMf.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aMf.clear();
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cFE.a(z, this.cFw, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.cHL;
                this.cFA = a2.cHM;
                list = list2;
            }
            if (list != null) {
                this.aMf.addAll(list);
                a(z2 ? 0 : 1, list, size);
                if (this.cFN) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cFw == null) {
                this.cFw = builder;
            }
            amH();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cFv != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aSm.getString(r.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                T(arrayList);
                this.cFv.bu(arrayList);
            }
            if (this.aMf.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aMf);
                this.cFB.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cFB.bv(linkedList);
                if (this.aMo != null && this.cFK) {
                    this.aMo.a(this.aMt, this.aMs, this.aMq, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.alK().e(System.currentTimeMillis() - currentTimeMillis, 1);
            long jT = com.baidu.tieba.homepage.framework.a.alK().jT(1);
            if (jT > 0) {
                com.baidu.tieba.homepage.framework.a.alK().f(System.currentTimeMillis() - jT, 1);
                com.baidu.tieba.homepage.framework.a.alK().g(0L, 1);
            }
        }
        return r1;
    }

    private void T(ArrayList<TagInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<TagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TagInfo next = it.next();
                if (next.tag_type.intValue() == 5) {
                    com.baidu.tieba.lego.c.e eVar = new com.baidu.tieba.lego.c.e();
                    eVar.dFB = next.lego_page_id.longValue();
                    eVar.dFC = com.baidu.tieba.tbadkCore.v.rd(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.v.rb(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.v.re(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void amI() {
        if (com.baidu.tbadk.core.util.y.s(this.aMf) >= this.cFE.amV() - 40) {
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cFE.a(true, this.cFw, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.cHL : null;
            if (list != null) {
                this.aMf.clear();
                this.aMf.addAll(list);
                this.cFB.bv(new LinkedList(this.aMf));
            }
        }
    }

    private void amJ() {
        com.baidu.tbadk.util.u.a(new w(this), new x(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amK() {
        if (this.cFw != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cFw.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.u.a(new z(this, builder), null);
        }
    }

    private boolean amL() {
        return fa(true);
    }

    private boolean fa(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.uh().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cFu;
    }

    public void a(a aVar) {
        this.cFv = aVar;
    }

    private boolean wG() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amM() {
        long j = com.baidu.tbadk.core.sharedPref.b.uh().getLong("recommend_frs_guide_time", 0L);
        if (this.cFy != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cFy) {
                aA(1, 0);
            }
        }
    }

    private void aA(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cFG != null && this.cFG.ama()) {
            amN();
        } else if (this.cFG == null || this.cFG.getCurrentItem() <= 0) {
            this.cFz = i;
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
                if (this.WE == null) {
                    this.WE = new TextView(this.aSm.getPageActivity());
                    this.WE.setGravity(17);
                    this.WE.setOnClickListener(this.cFP);
                    ke(this.cFH.getMeasuredHeight());
                }
                amN();
                if (this.cFH != null && this.WE.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int dimensionPixelSize = this.aSm.getResources().getDimensionPixelSize(r.e.ds20);
                            int dimensionPixelSize2 = this.aSm.getResources().getDimensionPixelSize(r.e.ds40);
                            this.WE.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.WE.setTextSize(0, this.aSm.getResources().getDimensionPixelSize(r.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.uh().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            av.k(this.WE, r.f.bg_home_float);
                            av.j((View) this.WE, r.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.WE.setPadding(0, 0, 0, 0);
                        this.WE.setTextSize(0, this.aSm.getResources().getDimensionPixelSize(r.e.fontsize24));
                        av.k(this.WE, r.d.common_color_10260);
                        av.j((View) this.WE, r.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.cFH.addView(this.WE, layoutParams);
                    this.WE.setText(str);
                    this.WE.setVisibility(0);
                    if (i == 1) {
                        this.cFD = 4000;
                    } else {
                        this.cFD = 2000;
                    }
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cFO);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.cFO, this.cFD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cFO);
        if (this.WE != null && this.WE.getParent() != null) {
            this.WE.startAnimation(this.cFQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amN() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cFO);
        if (this.WE != null) {
            this.WE.clearAnimation();
            if (this.WE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.WE.getParent()).removeView(this.WE);
            }
            this.WE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("close_new_user_guide_tip", true);
        if (this.cFw != null && this.cFw.age_sex != null) {
            this.cFw.age_sex = null;
            if (z) {
                amK();
            }
        }
        if (this.aMf != null && this.aMf.size() > 0 && (this.aMf.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j)) {
            this.aMf.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aMf != null) {
            this.cFB.bv(new ArrayList(this.aMf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amO() {
        if (this.cFw != null && this.cFw.interestion != null) {
            this.cFw.interestion = null;
            amK();
        }
        if (this.aMf != null && this.aMf.size() > 0 && (this.aMf.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aMf.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aMf != null) {
            this.cFB.bv(new ArrayList(this.aMf));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ahi != null) {
                this.ahi.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ahi);
            }
            if (this.cFS != null) {
                this.cFS.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cFS);
            }
            if (this.cFT != null) {
                this.cFT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cFT);
            }
            if (this.cFU != null) {
                this.cFU.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cFU);
            }
            if (this.cFV != null) {
                this.cFV.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cFV);
            }
            this.cFW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFW);
            this.ahO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahO);
            this.cGa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cGa);
        }
    }

    public void amP() {
        this.bPe = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bPe.bjo();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bPe != null) {
            if (i == 0) {
                this.bPe.bjo();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.fuG;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bPe.bq(i3, i7 + 1);
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

    public void kg(int i) {
        int rJ = this.bPe != null ? this.bPe.rJ(i) : -1;
        if (rJ >= 0 && this.bCe != null && this.bCe.getData() != null && this.bCe.getData().size() > i) {
            this.bPe.rK(i);
            com.baidu.adp.widget.ListView.v vVar = this.bCe.getData().get(i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.card.data.d)) {
                this.bPe.a(((com.baidu.tieba.card.data.d) vVar).Ox(), 1, "NEWINDEX");
            } else {
                this.bPe.d(1, rJ, "NEWINDEX");
            }
        }
    }

    public com.baidu.tieba.play.k JP() {
        return this.aMo;
    }

    public void fc(boolean z) {
        this.cFK = z;
    }

    public void kh(int i) {
        com.baidu.tbadk.util.u.a(new aa(this, i), null);
    }

    public void a(l lVar) {
        com.baidu.tbadk.util.u.a(new ab(this), new ac(this, lVar));
    }

    public void amQ() {
        a(this.cFZ);
    }
}
