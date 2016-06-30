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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d.a;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ad;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.play.f aIG;
    private final com.baidu.adp.base.h<?> aKR;
    private com.baidu.tieba.d.a aKs;
    private View acA;
    private com.baidu.tieba.tbadkCore.data.f bCz;
    private final BdTypeListView bou;
    private boolean civ;
    public com.baidu.tieba.homepage.framework.b.a cpX;
    private View.OnTouchListener cqA;
    private int cqE;
    private final Animation cqH;
    private final TranslateAnimation cqI;
    private final long cqm;
    private DataRes.Builder cqo;
    private final ad cqt;
    private final FrameLayout cqu;
    private final com.baidu.tieba.homepage.personalize.b.a cqw;
    private ScrollFragmentTabHost cqy;
    private ViewGroup cqz;
    private InterfaceC0060a cqn = null;
    private final List<com.baidu.adp.widget.ListView.v> aJj = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cqp = false;
    private long cqq = 0;
    private int cqr = 1;
    private int cqs = 0;
    private TextView SW = null;
    private int cqv = 2000;
    public com.baidu.tbadk.performanceLog.m cqx = null;
    private boolean aKt = false;
    private int aKy = 0;
    private int aKx = 0;
    private boolean cqB = false;
    private boolean cqC = true;
    private boolean cqD = false;
    private AbsListView.OnScrollListener yV = new b(this);
    private View.OnTouchListener aGb = new j(this);
    private a.InterfaceC0053a aKA = new k(this);
    private Runnable cqF = new l(this);
    private View.OnClickListener cqG = new m(this);
    private final CustomMessageListener cqJ = new n(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cqK = new o(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cqL = new p(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cqM = new q(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cqN = new c(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener adR = new d(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aex = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    /* renamed from: com.baidu.tieba.homepage.personalize.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        void as(int i, int i2);

        void bo(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void r(int i, int i2, int i3);
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        this.cpX = aVar;
        this.cqz = viewGroup;
        this.cqA = onTouchListener;
    }

    public void Xk() {
        if (this.cpX != null) {
            this.cpX.ex(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cqy = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.SW != null && this.SW.getParent() != null && this.SW.getVisibility() != 8) {
                i2 = (i2 - this.SW.getMeasuredHeight()) - av(this.SW);
            }
            jr(i2);
        }
    }

    private void jr(int i) {
        if (this.acA != null && this.acA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.acA.getLayoutParams();
            layoutParams.height = i;
            this.acA.setLayoutParams(layoutParams);
        }
    }

    private int av(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void dq(boolean z) {
        this.cqB = z;
        if (this.aIG != null) {
            if (z) {
                this.aIG.aTy();
            } else if (this.cqC) {
                this.aIG.a(this.aKy, this.aKx, this.aKt, true);
            }
        }
    }

    public a(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, ad adVar, FrameLayout frameLayout) {
        this.aKR = hVar;
        this.bou = bdTypeListView;
        this.acA = view;
        this.bou.setOnTouchListener(this.aGb);
        this.aKs = new com.baidu.tieba.d.a();
        this.aKs.a(this.aKA);
        this.cqu = frameLayout;
        this.cqt = adVar;
        this.cqw = new com.baidu.tieba.homepage.personalize.b.a();
        this.cqm = com.baidu.tbadk.core.sharedPref.b.sO().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.yV);
        this.cqH = AnimationUtils.loadAnimation(hVar.getPageActivity(), u.a.fade_out);
        this.cqH.setAnimationListener(new f(this));
        this.cqI = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(u.e.ds56), 0.0f);
        this.cqI.setDuration(400L);
        this.cqI.setAnimationListener(new g(this));
        ahb();
        this.aIG = new com.baidu.tieba.play.f(this.aKR, this.bou);
    }

    private boolean UT() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getBoolean(agP(), true);
    }

    private void agO() {
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean(agP(), false);
    }

    private String agP() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.agi().jk(1) == -1) {
            com.baidu.tieba.homepage.framework.a.agi().e(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        if (this.aJj.size() == 0 && !this.cqp && !UT()) {
            agV();
        } else {
            agS();
        }
    }

    public void agQ() {
        if (this.aIG != null && !this.cqB && this.cqC) {
            this.aIG.a(this.aKy, this.aKx, this.aKt, true);
        }
        if (this.cqD) {
            if (this.civ && this.cqs > 0) {
                if (eC(false)) {
                    ar(3, this.cqs);
                } else if (this.cqE > 0) {
                    ar(2, this.cqs);
                }
            } else if (!this.civ && this.cqs == 0) {
                ar(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.sO().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cqD = false;
            this.civ = false;
            this.cqE = 0;
        }
    }

    public void UU() {
        if (!DK() && this.cqn != null) {
            agU();
            this.mPn++;
            setIsLoading(true);
            this.cqn.r(this.mPn, (this.cqo == null || this.cqo.thread_list == null) ? 0 : this.cqo.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.bou.k(2000L);
            com.baidu.tbadk.core.sharedPref.b.sO().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cqo == null || this.cqo.thread_list == null) ? 0 : this.cqo.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cqD = false;
            if (this.aJj.size() > 0) {
                if (this.cqn != null) {
                    this.cqn.onError(1, str);
                    return;
                }
                return;
            } else if (this.cqn != null) {
                this.cqn.onError(2, str);
                return;
            } else {
                return;
            }
        }
        agO();
        if (this.cqn != null) {
            this.cqn.onSuccess();
        }
        this.cqD = true;
        this.civ = z;
        this.cqE = size;
        agW();
    }

    public void eB(boolean z) {
        if (z) {
            this.cqt.notifyDataSetChanged();
        }
        if (!agR()) {
            agY();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.cqF);
        if (this.cqx != null) {
            this.cqx.onDestroy();
        }
    }

    public boolean agR() {
        if (eC(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("close_new_user_guide_tip", false)) {
                eD(true);
            }
            aha();
            if (this.bou != null) {
                this.bou.setSelection(0);
                this.bou.jB();
                return true;
            }
            return true;
        }
        return false;
    }

    private void agS() {
        if (this.cqn != null) {
            this.cqn.as((this.cqo == null || this.cqo.thread_list == null || agX()) ? 0 : this.cqo.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cqp = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !agX()) {
                if (this.cqn != null) {
                    this.cqn.onSuccess();
                }
                agY();
                return;
            }
            agS();
            return;
        }
        agS();
    }

    private void agT() {
        boolean z;
        boolean z2;
        if (this.cqo != null) {
            if (this.cqo.age_sex != null) {
                if (this.cqo.age_sex.sex_tag != null && this.cqo.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cqo.age_sex.sex_tag.iterator();
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
                        iVar.csA = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                    }
                }
                if (this.cqo.age_sex.age_tag != null && this.cqo.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cqo.age_sex.age_tag.iterator();
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
                        iVar2.csA = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar2));
                    }
                }
            }
            if (this.cqo.age_sex == null && this.cqo.interestion != null && this.cqo.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cqo.interestion) {
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
            this.cqq = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && agX()) {
                this.cqo = null;
            }
            int size = z2 ? 0 : this.aJj.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aJj.clear();
            com.baidu.tieba.homepage.personalize.b.d a = this.cqw.a(z, this.cqo, builder, z2 ? 0 : 1);
            if (a != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a.bCg;
                this.cqs = a.csI;
                list = list2;
            }
            if (list != null) {
                this.aJj.addAll(list);
                a(z2 ? 0 : 1, list, size);
            }
            if (this.cqo == null) {
                this.cqo = builder;
            }
            agT();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cqn != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aKR.getString(u.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                R(arrayList);
                this.cqn.bo(arrayList);
            }
            if (this.aJj.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aJj);
                this.cqt.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cqt.bp(linkedList);
                if (this.aIG != null && this.cqC) {
                    this.aIG.a(this.aKy, this.aKx, this.aKt, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.agi().c(System.currentTimeMillis() - currentTimeMillis, 1);
            long jk = com.baidu.tieba.homepage.framework.a.agi().jk(1);
            if (jk > 0) {
                com.baidu.tieba.homepage.framework.a.agi().d(System.currentTimeMillis() - jk, 1);
                com.baidu.tieba.homepage.framework.a.agi().e(0L, 1);
            }
        }
        return r1;
    }

    private void R(ArrayList<TagInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<TagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TagInfo next = it.next();
                if (next.tag_type.intValue() == 5) {
                    com.baidu.tieba.lego.c.e eVar = new com.baidu.tieba.lego.c.e();
                    eVar.doL = next.lego_page_id.longValue();
                    eVar.doM = com.baidu.tieba.tbadkCore.w.pv(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.w.pt(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.w.pw(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void agU() {
        int ahj = this.cqw.ahj() - 40;
        if (com.baidu.tbadk.core.util.y.s(this.aJj) >= ahj) {
            com.baidu.tieba.homepage.personalize.b.d a = this.cqw.a(true, this.cqo, null, 1, ahj);
            List<com.baidu.adp.widget.ListView.v> list = a != null ? a.bCg : null;
            if (list != null) {
                this.aJj.clear();
                this.aJj.addAll(list);
                this.cqt.bp(new LinkedList(this.aJj));
            }
        }
    }

    private void agV() {
        com.baidu.tbadk.util.t.a(new h(this, com.baidu.tbadk.core.b.a.rP().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())), new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agW() {
        if (this.cqo != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cqo.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            try {
                com.baidu.tbadk.core.b.a.rP().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder.build(true).toByteArray());
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean agX() {
        return eC(true);
    }

    private boolean eC(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.sO().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cqm;
    }

    public void a(InterfaceC0060a interfaceC0060a) {
        this.cqn = interfaceC0060a;
    }

    private boolean DK() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agY() {
        long j = com.baidu.tbadk.core.sharedPref.b.sO().getLong("recommend_frs_guide_time", 0L);
        if (this.cqq != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cqq) {
                ar(1, 0);
            }
        }
    }

    private void ar(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cqy != null && this.cqy.agw()) {
            agZ();
        } else if (this.cqy == null || this.cqy.getCurrentItem() <= 0) {
            this.cqr = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m9getInst().getString(u.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m9getInst().getString(u.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m9getInst().getString(u.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m9getInst().getString(u.j.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.SW == null) {
                    this.SW = new TextView(this.aKR.getPageActivity());
                    this.SW.setGravity(17);
                    this.SW.setOnClickListener(this.cqG);
                    jr(this.cqz.getMeasuredHeight());
                }
                agZ();
                if (this.cqz != null && this.SW.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.fr()) {
                            int dimensionPixelSize = this.aKR.getResources().getDimensionPixelSize(u.e.ds20);
                            int dimensionPixelSize2 = this.aKR.getResources().getDimensionPixelSize(u.e.ds40);
                            this.SW.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.SW.setTextSize(0, this.aKR.getResources().getDimensionPixelSize(u.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.sO().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            av.k(this.SW, u.f.bg_home_float);
                            av.j((View) this.SW, u.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.SW.setPadding(0, 0, 0, 0);
                        this.SW.setTextSize(0, this.aKR.getResources().getDimensionPixelSize(u.e.fontsize24));
                        av.k(this.SW, u.d.common_color_10260);
                        av.j((View) this.SW, u.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.cqz.addView(this.SW, layoutParams);
                    this.SW.setText(str);
                    this.SW.setVisibility(0);
                    if (i == 1) {
                        this.cqv = 4000;
                    } else {
                        this.cqv = 2000;
                    }
                    com.baidu.adp.lib.h.h.dM().removeCallbacks(this.cqF);
                    com.baidu.adp.lib.h.h.dM().postDelayed(this.cqF, this.cqv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.cqF);
        if (this.SW != null && this.SW.getParent() != null) {
            this.SW.startAnimation(this.cqH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agZ() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.cqF);
        if (this.SW != null) {
            this.SW.clearAnimation();
            if (this.SW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.SW.getParent()).removeView(this.SW);
            }
            this.SW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("close_new_user_guide_tip", true);
        if (this.cqo != null && this.cqo.age_sex != null) {
            this.cqo.age_sex = null;
            if (z) {
                agW();
            }
        }
        if (this.aJj != null && this.aJj.size() > 0 && (this.aJj.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j)) {
            this.aJj.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        this.cqt.bp(new ArrayList(this.aJj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aha() {
        if (this.cqo != null && this.cqo.interestion != null) {
            this.cqo.interestion = null;
            agW();
        }
        if (this.aJj != null && this.aJj.size() > 0 && (this.aJj.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aJj.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        this.cqt.bp(new ArrayList(this.aJj));
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.adR != null) {
                this.adR.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.adR);
            }
            if (this.cqJ != null) {
                this.cqJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqJ);
            }
            if (this.cqK != null) {
                this.cqK.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqK);
            }
            if (this.cqL != null) {
                this.cqL.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqL);
            }
            if (this.cqM != null) {
                this.cqM.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqM);
            }
            this.cqN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqN);
            this.aex.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aex);
        }
    }

    public void ahb() {
        this.bCz = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bCz.bbJ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bCz != null) {
            if (i == 0) {
                this.bCz.bbJ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.eXe;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.a.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bCz.bg(i3, i7 + 1);
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

    public void js(int i) {
        int qz = this.bCz != null ? this.bCz.qz(i) : -1;
        if (qz >= 0 && this.bou != null && this.bou.getData() != null && this.bou.getData().size() > i) {
            this.bCz.qA(i);
            com.baidu.adp.widget.ListView.v vVar = this.bou.getData().get(i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.card.a.d)) {
                com.baidu.tieba.card.e.a((com.baidu.tieba.card.a.d) vVar, 1);
            } else {
                com.baidu.tieba.card.e.N(1, qz);
            }
        }
    }

    public com.baidu.tieba.play.f Il() {
        return this.aIG;
    }

    public void eE(boolean z) {
        this.cqC = z;
    }
}
