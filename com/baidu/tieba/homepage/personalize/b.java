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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d.a;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.play.f aJx;
    private final com.baidu.adp.base.h<?> aLK;
    private com.baidu.tieba.d.a aLl;
    private View adl;
    private com.baidu.tieba.tbadkCore.data.f bDG;
    private final BdTypeListView bqG;
    private boolean ckI;
    public com.baidu.tieba.homepage.framework.b.a csC;
    private final long csR;
    private DataRes.Builder csT;
    private final com.baidu.tieba.homepage.personalize.a.ad csY;
    private final FrameLayout csZ;
    private final com.baidu.tieba.homepage.personalize.b.a ctb;
    private ScrollFragmentTabHost ctd;
    private ViewGroup cte;
    private View.OnTouchListener ctf;
    private int ctj;
    private final Animation ctm;
    private final TranslateAnimation ctn;
    private a csS = null;
    private final List<com.baidu.adp.widget.ListView.v> aKa = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean csU = false;
    private long csV = 0;
    private int csW = 1;
    private int csX = 0;
    private TextView TE = null;
    private int cta = 2000;
    public com.baidu.tbadk.performanceLog.m ctc = null;
    private boolean aLm = false;
    private int aLr = 0;
    private int aLq = 0;
    private boolean ctg = false;
    private boolean cth = true;
    private boolean cti = false;
    private AbsListView.OnScrollListener zw = new c(this);
    private View.OnTouchListener aGS = new o(this);
    private a.InterfaceC0054a aLt = new r(this);
    private Runnable ctk = new s(this);
    private View.OnClickListener ctl = new t(this);
    private final CustomMessageListener cto = new u(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener ctp = new v(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener ctq = new w(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener ctr = new x(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cts = new d(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener aeF = new e(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener afl = new f(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String ctt = "lastReadReadPositionKey";
    private int ctu = 0;
    private com.baidu.tieba.homepage.personalize.a ctv = new g(this);

    /* loaded from: classes.dex */
    public interface a {
        void av(int i, int i2);

        void bs(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void s(int i, int i2, int i3);
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        this.csC = aVar;
        this.cte = viewGroup;
        this.ctf = onTouchListener;
    }

    public void XC() {
        if (this.csC != null) {
            this.csC.ey(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ctd = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.TE != null && this.TE.getParent() != null && this.TE.getVisibility() != 8) {
                i2 = (i2 - this.TE.getMeasuredHeight()) - at(this.TE);
            }
            jw(i2);
        }
    }

    private void jw(int i) {
        if (this.adl != null && this.adl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.adl.getLayoutParams();
            layoutParams.height = i;
            this.adl.setLayoutParams(layoutParams);
        }
    }

    private int at(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void dn(boolean z) {
        this.ctg = z;
        if (this.aJx != null) {
            this.aJx.jG(!z);
            if (z) {
                this.aJx.aWB();
            } else if (this.cth) {
                this.aJx.a(this.aLr, this.aLq, this.aLm, true);
            }
        }
    }

    public b(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.a.ad adVar, FrameLayout frameLayout) {
        this.aLK = hVar;
        this.bqG = bdTypeListView;
        this.adl = view;
        this.bqG.setOnTouchListener(this.aGS);
        this.aLl = new com.baidu.tieba.d.a();
        this.aLl.a(this.aLt);
        this.csZ = frameLayout;
        this.csY = adVar;
        this.ctb = new com.baidu.tieba.homepage.personalize.b.a();
        this.csR = com.baidu.tbadk.core.sharedPref.b.sN().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.zw);
        this.ctm = AnimationUtils.loadAnimation(hVar.getPageActivity(), u.a.fade_out);
        this.ctm.setAnimationListener(new i(this));
        this.ctn = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m10getInst().getResources().getDimension(u.e.ds56), 0.0f);
        this.ctn.setDuration(400L);
        this.ctn.setAnimationListener(new j(this));
        ahI();
        this.aJx = new com.baidu.tieba.play.f(this.aLK, this.bqG);
    }

    private boolean ahu() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getBoolean(ahw(), true);
    }

    private void ahv() {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean(ahw(), false);
    }

    private String ahw() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.agL().jl(1) == -1) {
            com.baidu.tieba.homepage.framework.a.agL().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        if (this.aKa.size() == 0 && !this.csU && !ahu()) {
            ahC();
        } else {
            ahz();
        }
    }

    public void ahx() {
        if (this.aJx != null && !this.ctg && this.cth) {
            this.aJx.a(this.aLr, this.aLq, this.aLm, true);
        }
        if (this.cti) {
            if (this.ckI && this.csX > 0) {
                if (eD(false)) {
                    au(3, this.csX);
                } else if (this.ctj > 0) {
                    au(2, this.csX);
                }
            } else if (!this.ckI && this.csX == 0) {
                au(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.sN().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cti = false;
            this.ckI = false;
            this.ctj = 0;
        }
    }

    public void Wd() {
        if (!DJ() && this.csS != null) {
            ahB();
            this.mPn++;
            setIsLoading(true);
            this.csS.s(this.mPn, (this.csT == null || this.csT.thread_list == null) ? 0 : this.csT.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.bqG.l(2000L);
            com.baidu.tbadk.core.sharedPref.b.sN().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.csT == null || this.csT.thread_list == null) ? 0 : this.csT.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cti = false;
            if (this.aKa.size() > 0) {
                if (this.csS != null) {
                    this.csS.onError(1, str);
                    return;
                }
                return;
            } else if (this.csS != null) {
                this.csS.onError(2, str);
                return;
            } else {
                return;
            }
        }
        ahv();
        if (this.csS != null) {
            this.csS.onSuccess();
        }
        this.cti = true;
        this.ckI = z;
        this.ctj = size;
        ahD();
    }

    public void eC(boolean z) {
        if (z) {
            this.csY.notifyDataSetChanged();
        }
        if (!ahy()) {
            ahF();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ctk);
        if (this.ctc != null) {
            this.ctc.onDestroy();
        }
    }

    public void onPause() {
        jy(this.ctu);
    }

    public boolean ahy() {
        if (eD(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("close_new_user_guide_tip", false)) {
                eE(true);
            }
            ahH();
            if (this.bqG != null) {
                this.bqG.setSelection(0);
                this.bqG.jA();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ahz() {
        if (this.csS != null) {
            this.csS.av((this.csT == null || this.csT.thread_list == null || ahE()) ? 0 : this.csT.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.csU = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !ahE()) {
                if (this.csS != null) {
                    this.csS.onSuccess();
                }
                ahF();
                return;
            }
            ahz();
            return;
        }
        ahz();
    }

    private void ahA() {
        boolean z;
        boolean z2;
        if (this.csT != null) {
            if (this.csT.age_sex != null) {
                if (this.csT.age_sex.sex_tag != null && this.csT.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.csT.age_sex.sex_tag.iterator();
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
                        iVar.cvk = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                    }
                }
                if (this.csT.age_sex.age_tag != null && this.csT.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.csT.age_sex.age_tag.iterator();
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
                        iVar2.cvk = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar2));
                    }
                }
            }
            if (this.csT.age_sex == null && this.csT.interestion != null && this.csT.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.csT.interestion) {
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
            this.csV = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && ahE()) {
                this.csT = null;
            }
            int size = z2 ? 0 : this.aKa.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aKa.clear();
            com.baidu.tieba.homepage.personalize.b.d a2 = this.ctb.a(z, this.csT, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.cvs;
                this.csX = a2.cvt;
                list = list2;
            }
            if (list != null) {
                this.aKa.addAll(list);
                a(z2 ? 0 : 1, list, size);
            }
            if (this.csT == null) {
                this.csT = builder;
            }
            ahA();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.csS != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aLK.getString(u.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                T(arrayList);
                this.csS.bs(arrayList);
            }
            if (this.aKa.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aKa);
                this.csY.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.csY.bt(linkedList);
                if (this.aJx != null && this.cth) {
                    this.aJx.a(this.aLr, this.aLq, this.aLm, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.agL().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jl = com.baidu.tieba.homepage.framework.a.agL().jl(1);
            if (jl > 0) {
                com.baidu.tieba.homepage.framework.a.agL().e(System.currentTimeMillis() - jl, 1);
                com.baidu.tieba.homepage.framework.a.agL().f(0L, 1);
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
                    eVar.drT = next.lego_page_id.longValue();
                    eVar.drU = com.baidu.tieba.tbadkCore.w.qf(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.w.qd(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.w.qg(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void ahB() {
        int ahS = this.ctb.ahS() - 40;
        if (com.baidu.tbadk.core.util.y.s(this.aKa) >= ahS) {
            com.baidu.tieba.homepage.personalize.b.d a2 = this.ctb.a(true, this.csT, null, 1, ahS);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.cvs : null;
            if (list != null) {
                this.aKa.clear();
                this.aKa.addAll(list);
                this.csY.bt(new LinkedList(this.aKa));
            }
        }
    }

    private void ahC() {
        com.baidu.tbadk.util.u.a(new k(this), new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahD() {
        if (this.csT != null) {
            DataRes.Builder builder = new DataRes.Builder(this.csT.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.u.a(new m(this, builder), null);
        }
    }

    private boolean ahE() {
        return eD(true);
    }

    private boolean eD(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.sN().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.csR;
    }

    public void a(a aVar) {
        this.csS = aVar;
    }

    private boolean DJ() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahF() {
        long j = com.baidu.tbadk.core.sharedPref.b.sN().getLong("recommend_frs_guide_time", 0L);
        if (this.csV != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.csV) {
                au(1, 0);
            }
        }
    }

    private void au(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.ctd != null && this.ctd.aha()) {
            ahG();
        } else if (this.ctd == null || this.ctd.getCurrentItem() <= 0) {
            this.csW = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m10getInst().getString(u.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m10getInst().getString(u.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m10getInst().getString(u.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m10getInst().getString(u.j.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.TE == null) {
                    this.TE = new TextView(this.aLK.getPageActivity());
                    this.TE.setGravity(17);
                    this.TE.setOnClickListener(this.ctl);
                    jw(this.cte.getMeasuredHeight());
                }
                ahG();
                if (this.cte != null && this.TE.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.fq()) {
                            int dimensionPixelSize = this.aLK.getResources().getDimensionPixelSize(u.e.ds20);
                            int dimensionPixelSize2 = this.aLK.getResources().getDimensionPixelSize(u.e.ds40);
                            this.TE.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.TE.setTextSize(0, this.aLK.getResources().getDimensionPixelSize(u.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.sN().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            av.k(this.TE, u.f.bg_home_float);
                            av.j((View) this.TE, u.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.TE.setPadding(0, 0, 0, 0);
                        this.TE.setTextSize(0, this.aLK.getResources().getDimensionPixelSize(u.e.fontsize24));
                        av.k(this.TE, u.d.common_color_10260);
                        av.j((View) this.TE, u.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.cte.addView(this.TE, layoutParams);
                    this.TE.setText(str);
                    this.TE.setVisibility(0);
                    if (i == 1) {
                        this.cta = 4000;
                    } else {
                        this.cta = 2000;
                    }
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ctk);
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.ctk, this.cta);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ctk);
        if (this.TE != null && this.TE.getParent() != null) {
            this.TE.startAnimation(this.ctm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahG() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ctk);
        if (this.TE != null) {
            this.TE.clearAnimation();
            if (this.TE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.TE.getParent()).removeView(this.TE);
            }
            this.TE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("close_new_user_guide_tip", true);
        if (this.csT != null && this.csT.age_sex != null) {
            this.csT.age_sex = null;
            if (z) {
                ahD();
            }
        }
        if (this.aKa != null && this.aKa.size() > 0 && (this.aKa.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j)) {
            this.aKa.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        this.csY.bt(new ArrayList(this.aKa));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahH() {
        if (this.csT != null && this.csT.interestion != null) {
            this.csT.interestion = null;
            ahD();
        }
        if (this.aKa != null && this.aKa.size() > 0 && (this.aKa.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aKa.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        this.csY.bt(new ArrayList(this.aKa));
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aeF != null) {
                this.aeF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.aeF);
            }
            if (this.cto != null) {
                this.cto.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cto);
            }
            if (this.ctp != null) {
                this.ctp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ctp);
            }
            if (this.ctq != null) {
                this.ctq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ctq);
            }
            if (this.ctr != null) {
                this.ctr.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ctr);
            }
            this.cts.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cts);
            this.afl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.afl);
        }
    }

    public void ahI() {
        this.bDG = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bDG.beY();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bDG != null) {
            if (i == 0) {
                this.bDG.beY();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.fkg;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.a.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bDG.bj(i3, i7 + 1);
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

    public void jx(int i) {
        int qU = this.bDG != null ? this.bDG.qU(i) : -1;
        if (qU >= 0 && this.bqG != null && this.bqG.getData() != null && this.bqG.getData().size() > i) {
            this.bDG.qV(i);
            com.baidu.adp.widget.ListView.v vVar = this.bqG.getData().get(i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.card.a.d)) {
                com.baidu.tieba.card.e.a((com.baidu.tieba.card.a.d) vVar, 1);
            } else {
                com.baidu.tieba.card.e.N(1, qU);
            }
        }
    }

    public com.baidu.tieba.play.f Ij() {
        return this.aJx;
    }

    public void eF(boolean z) {
        this.cth = z;
    }

    public void jy(int i) {
        com.baidu.tbadk.util.u.a(new n(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.personalize.a aVar) {
        com.baidu.tbadk.util.u.a(new p(this), new q(this, aVar));
    }

    public void ahJ() {
        a(this.ctv);
    }
}
