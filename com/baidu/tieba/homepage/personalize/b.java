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
import com.baidu.tieba.e.a;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.play.i aNV;
    private com.baidu.tieba.e.a aPW;
    private final com.baidu.adp.base.h<?> aRe;
    private View aga;
    private final BdTypeListView bBT;
    private com.baidu.tieba.tbadkCore.data.f bPk;
    public com.baidu.tieba.homepage.framework.b.a cDK;
    private final com.baidu.tieba.homepage.personalize.a.ac cEE;
    private final FrameLayout cEF;
    private final com.baidu.tieba.homepage.personalize.b.a cEH;
    private ScrollFragmentTabHost cEJ;
    private ViewGroup cEK;
    private View.OnTouchListener cEL;
    private int cEP;
    private final Animation cES;
    private final TranslateAnimation cET;
    private final long cEx;
    private DataRes.Builder cEz;
    private boolean cvT;
    private a cEy = null;
    private final List<com.baidu.adp.widget.ListView.v> aOE = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cEA = false;
    private long cEB = 0;
    private int cEC = 1;
    private int cED = 0;
    private TextView Wu = null;
    private int cEG = 2000;
    public com.baidu.tbadk.performanceLog.m cEI = null;
    private boolean aPX = false;
    private int aQc = 0;
    private int aQb = 0;
    private boolean cEM = false;
    private boolean cEN = true;
    private boolean cEO = false;
    private AbsListView.OnScrollListener BL = new c(this);
    private View.OnTouchListener aKe = new n(this);
    private a.InterfaceC0055a aQg = new r(this);
    private Runnable cEQ = new s(this);
    private View.OnClickListener cER = new t(this);
    private final CustomMessageListener cEU = new u(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cEV = new v(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cEW = new w(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cEX = new x(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cEY = new d(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener ahA = new e(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aig = new f(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cEZ = "lastReadReadPositionKey";
    private int cFa = 0;
    private com.baidu.tieba.homepage.personalize.a cFb = new g(this);

    /* loaded from: classes.dex */
    public interface a {
        void az(int i, int i2);

        void bu(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void t(int i, int i2, int i3);
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        this.cDK = aVar;
        this.cEK = viewGroup;
        this.cEL = onTouchListener;
    }

    public void YO() {
        if (this.cDK != null) {
            this.cDK.eU(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cEJ = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.Wu != null && this.Wu.getParent() != null && this.Wu.getVisibility() != 8) {
                i2 = (i2 - this.Wu.getMeasuredHeight()) - at(this.Wu);
            }
            jY(i2);
        }
    }

    private void jY(int i) {
        if (this.aga != null && this.aga.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aga.getLayoutParams();
            layoutParams.height = i;
            this.aga.setLayoutParams(layoutParams);
        }
    }

    private int at(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void dL(boolean z) {
        this.cEM = z;
        if (this.aNV != null) {
            this.aNV.jU(!z);
            if (z) {
                this.aNV.aZR();
            } else if (this.cEN) {
                this.aNV.a(this.aQc, this.aQb, this.aPX, true);
            }
        }
    }

    public b(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.a.ac acVar, FrameLayout frameLayout) {
        this.aRe = hVar;
        this.bBT = bdTypeListView;
        this.aga = view;
        this.bBT.setOnTouchListener(this.aKe);
        this.aPW = new com.baidu.tieba.e.a();
        this.aPW.a(this.aQg);
        this.cEF = frameLayout;
        this.cEE = acVar;
        this.cEH = new com.baidu.tieba.homepage.personalize.b.a();
        this.cEx = com.baidu.tbadk.core.sharedPref.b.tS().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.BL);
        this.cES = AnimationUtils.loadAnimation(hVar.getPageActivity(), t.a.fade_out);
        this.cES.setAnimationListener(new i(this));
        this.cET = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.cET.setDuration(400L);
        this.cET.setAnimationListener(new j(this));
        amx();
        this.aNV = new com.baidu.tieba.play.i(this.aRe, this.bBT);
    }

    private boolean amj() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getBoolean(aml(), true);
    }

    private void amk() {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean(aml(), false);
    }

    private String aml() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.alw().jN(1) == -1) {
            com.baidu.tieba.homepage.framework.a.alw().g(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        if (this.aOE.size() == 0 && !this.cEA && !amj()) {
            amr();
        } else {
            amo();
        }
    }

    public void amm() {
        if (this.aNV != null && !this.cEM && this.cEN) {
            this.aNV.a(this.aQc, this.aQb, this.aPX, true);
        }
        if (this.cEO) {
            if (this.cvT && this.cED > 0) {
                if (eZ(false)) {
                    ay(3, this.cED);
                } else if (this.cEP > 0) {
                    ay(2, this.cED);
                }
            } else if (!this.cvT && this.cED == 0) {
                ay(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.tS().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cEO = false;
            this.cvT = false;
            this.cEP = 0;
        }
    }

    public void aba() {
        if (!Fd() && this.cEy != null) {
            amq();
            this.mPn++;
            setIsLoading(true);
            this.cEy.t(this.mPn, (this.cEz == null || this.cEz.thread_list == null) ? 0 : this.cEz.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.bBT.l(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.tS().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cEz == null || this.cEz.thread_list == null) ? 0 : this.cEz.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cEO = false;
            if (this.aOE.size() > 0) {
                if (this.cEy != null) {
                    this.cEy.onError(1, str);
                    return;
                }
                return;
            } else if (this.cEy != null) {
                this.cEy.onError(2, str);
                return;
            } else {
                return;
            }
        }
        amk();
        if (this.cEy != null) {
            this.cEy.onSuccess();
        }
        this.cEO = true;
        this.cvT = z;
        this.cEP = size;
        ams();
    }

    public void eY(boolean z) {
        if (z) {
            this.cEE.notifyDataSetChanged();
        }
        if (!amn()) {
            amu();
        }
    }

    public void onDestroy() {
        if (this.aNV != null) {
            this.aNV.destroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cEQ);
        if (this.cEI != null) {
            this.cEI.onDestroy();
        }
    }

    public void onPause() {
        kb(this.cFa);
        this.bBT.getAdapter();
        jZ(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jZ(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jZ(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.aRe.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$16
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean amn() {
        if (eZ(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("close_new_user_guide_tip", false)) {
                fa(true);
            }
            amw();
            if (this.bBT != null) {
                this.bBT.setSelection(0);
                this.bBT.kv();
                return true;
            }
            return true;
        }
        return false;
    }

    private void amo() {
        if (this.cEy != null) {
            this.cEy.az((this.cEz == null || this.cEz.thread_list == null || amt()) ? 0 : this.cEz.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cEA = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !amt()) {
                if (this.cEy != null) {
                    this.cEy.onSuccess();
                }
                amu();
                return;
            }
            amo();
            return;
        }
        amo();
    }

    private void amp() {
        boolean z;
        boolean z2;
        if (this.cEz != null) {
            if (this.cEz.age_sex != null) {
                if (this.cEz.age_sex.sex_tag != null && this.cEz.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cEz.age_sex.sex_tag.iterator();
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
                        iVar.cGO = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                    }
                }
                if (this.cEz.age_sex.age_tag != null && this.cEz.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cEz.age_sex.age_tag.iterator();
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
                        iVar2.cGO = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar2));
                    }
                }
            }
            if (this.cEz.age_sex == null && this.cEz.interestion != null && this.cEz.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cEz.interestion) {
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
            this.cEB = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && amt()) {
                this.cEz = null;
            }
            int size = z2 ? 0 : this.aOE.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aOE.clear();
            com.baidu.tieba.homepage.personalize.b.d a2 = this.cEH.a(z, this.cEz, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.cGW;
                this.cED = a2.cGX;
                list = list2;
            }
            if (list != null) {
                this.aOE.addAll(list);
                a(z2 ? 0 : 1, list, size);
            }
            if (this.cEz == null) {
                this.cEz = builder;
            }
            amp();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cEy != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aRe.getString(t.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                T(arrayList);
                this.cEy.bu(arrayList);
            }
            if (this.aOE.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aOE);
                this.cEE.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cEE.bv(linkedList);
                if (this.aNV != null && this.cEN) {
                    this.aNV.a(this.aQc, this.aQb, this.aPX, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.alw().e(System.currentTimeMillis() - currentTimeMillis, 1);
            long jN = com.baidu.tieba.homepage.framework.a.alw().jN(1);
            if (jN > 0) {
                com.baidu.tieba.homepage.framework.a.alw().f(System.currentTimeMillis() - jN, 1);
                com.baidu.tieba.homepage.framework.a.alw().g(0L, 1);
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
                    eVar.dDI = next.lego_page_id.longValue();
                    eVar.dDJ = com.baidu.tieba.tbadkCore.v.qP(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.v.qN(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.v.qQ(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void amq() {
        int amH = this.cEH.amH() - 40;
        if (com.baidu.tbadk.core.util.y.s(this.aOE) >= amH) {
            com.baidu.tieba.homepage.personalize.b.d a2 = this.cEH.a(true, this.cEz, null, 1, amH);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.cGW : null;
            if (list != null) {
                this.aOE.clear();
                this.aOE.addAll(list);
                this.cEE.bv(new LinkedList(this.aOE));
            }
        }
    }

    private void amr() {
        com.baidu.tbadk.util.u.a(new k(this), new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ams() {
        if (this.cEz != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cEz.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.u.a(new m(this, builder), null);
        }
    }

    private boolean amt() {
        return eZ(true);
    }

    private boolean eZ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.tS().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cEx;
    }

    public void a(a aVar) {
        this.cEy = aVar;
    }

    private boolean Fd() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amu() {
        long j = com.baidu.tbadk.core.sharedPref.b.tS().getLong("recommend_frs_guide_time", 0L);
        if (this.cEB != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cEB) {
                ay(1, 0);
            }
        }
    }

    private void ay(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cEJ != null && this.cEJ.alL()) {
            amv();
        } else if (this.cEJ == null || this.cEJ.getCurrentItem() <= 0) {
            this.cEC = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m9getInst().getString(t.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m9getInst().getString(t.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m9getInst().getString(t.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m9getInst().getString(t.j.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.Wu == null) {
                    this.Wu = new TextView(this.aRe.getPageActivity());
                    this.Wu.setGravity(17);
                    this.Wu.setOnClickListener(this.cER);
                    jY(this.cEK.getMeasuredHeight());
                }
                amv();
                if (this.cEK != null && this.Wu.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int dimensionPixelSize = this.aRe.getResources().getDimensionPixelSize(t.e.ds20);
                            int dimensionPixelSize2 = this.aRe.getResources().getDimensionPixelSize(t.e.ds40);
                            this.Wu.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.Wu.setTextSize(0, this.aRe.getResources().getDimensionPixelSize(t.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.tS().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            av.k(this.Wu, t.f.bg_home_float);
                            av.j((View) this.Wu, t.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.Wu.setPadding(0, 0, 0, 0);
                        this.Wu.setTextSize(0, this.aRe.getResources().getDimensionPixelSize(t.e.fontsize24));
                        av.k(this.Wu, t.d.common_color_10260);
                        av.j((View) this.Wu, t.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.cEK.addView(this.Wu, layoutParams);
                    this.Wu.setText(str);
                    this.Wu.setVisibility(0);
                    if (i == 1) {
                        this.cEG = 4000;
                    } else {
                        this.cEG = 2000;
                    }
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cEQ);
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.cEQ, this.cEG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cEQ);
        if (this.Wu != null && this.Wu.getParent() != null) {
            this.Wu.startAnimation(this.cES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amv() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cEQ);
        if (this.Wu != null) {
            this.Wu.clearAnimation();
            if (this.Wu.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.Wu.getParent()).removeView(this.Wu);
            }
            this.Wu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("close_new_user_guide_tip", true);
        if (this.cEz != null && this.cEz.age_sex != null) {
            this.cEz.age_sex = null;
            if (z) {
                ams();
            }
        }
        if (this.aOE != null && this.aOE.size() > 0 && (this.aOE.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j)) {
            this.aOE.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        this.cEE.bv(new ArrayList(this.aOE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amw() {
        if (this.cEz != null && this.cEz.interestion != null) {
            this.cEz.interestion = null;
            ams();
        }
        if (this.aOE != null && this.aOE.size() > 0 && (this.aOE.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aOE.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        this.cEE.bv(new ArrayList(this.aOE));
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ahA != null) {
                this.ahA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ahA);
            }
            if (this.cEU != null) {
                this.cEU.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cEU);
            }
            if (this.cEV != null) {
                this.cEV.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cEV);
            }
            if (this.cEW != null) {
                this.cEW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cEW);
            }
            if (this.cEX != null) {
                this.cEX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cEX);
            }
            this.cEY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cEY);
            this.aig.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aig);
        }
    }

    public void amx() {
        this.bPk = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bPk.biD();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bPk != null) {
            if (i == 0) {
                this.bPk.biD();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.fsa;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bPk.bo(i3, i7 + 1);
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

    public void ka(int i) {
        int rv = this.bPk != null ? this.bPk.rv(i) : -1;
        if (rv >= 0 && this.bBT != null && this.bBT.getData() != null && this.bBT.getData().size() > i) {
            this.bPk.rw(i);
            com.baidu.adp.widget.ListView.v vVar = this.bBT.getData().get(i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.card.data.d)) {
                this.bPk.a(((com.baidu.tieba.card.data.d) vVar).NV(), 1, "NEWINDEX");
            } else {
                this.bPk.d(1, rv, "NEWINDEX");
            }
        }
    }

    public com.baidu.tieba.play.i Ki() {
        return this.aNV;
    }

    public void fb(boolean z) {
        this.cEN = z;
    }

    public void kb(int i) {
        com.baidu.tbadk.util.u.a(new o(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.personalize.a aVar) {
        com.baidu.tbadk.util.u.a(new p(this), new q(this, aVar));
    }

    public void amy() {
        a(this.cFb);
    }
}
