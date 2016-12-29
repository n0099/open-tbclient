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
import com.baidu.tbadk.core.util.ar;
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
    private final BdTypeListView aMc;
    private com.baidu.tieba.play.aa aMd;
    private com.baidu.tieba.d.a aMe;
    private final com.baidu.adp.base.h<?> aTE;
    private View agt;
    private com.baidu.tieba.tbadkCore.data.f byd;
    private boolean cgM;
    public com.baidu.tieba.homepage.framework.b.a coW;
    private final long cqd;
    private DataRes.Builder cqf;
    private final com.baidu.tieba.homepage.personalize.b.ab cqk;
    private final FrameLayout cql;
    private cs cqm;
    private final com.baidu.tieba.homepage.personalize.c.a cqn;
    private ScrollFragmentTabHost cqp;
    private ViewGroup cqq;
    private View.OnTouchListener cqr;
    private int cqv;
    private a cqe = null;
    private final List<com.baidu.adp.widget.ListView.v> aNw = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cqg = false;
    private long cqh = 0;
    private int cqi = 1;
    private int cqj = 0;
    private TextView Ww = null;
    private int bCr = 2000;
    public com.baidu.tbadk.performanceLog.m cqo = null;
    private boolean aMf = false;
    private int aMh = 0;
    private int aMg = 0;
    private boolean cqs = false;
    private boolean cqt = true;
    private boolean cqu = false;
    private boolean cqw = false;
    private AbsListView.OnScrollListener BM = new o(this);
    private View.OnTouchListener aJN = new z(this);
    private a.InterfaceC0057a aMk = new ab(this);
    private View.OnClickListener cqx = new ac(this);
    private final CustomMessageListener cqy = new ad(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cqz = new ae(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cqA = new af(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cqB = new ag(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cqC = new ah(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener ahj = new p(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener ahW = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cqD = "lastReadReadPositionKey";
    private int cqE = 0;
    private m cqF = new r(this);
    private CustomMessageListener cqG = new t(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    /* loaded from: classes.dex */
    public interface a {
        void av(int i, int i2);

        void bo(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();

        void u(int i, int i2, int i3);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (eVar != null) {
            this.coW = eVar.aiH();
            this.cqq = eVar.SY();
            this.cqr = eVar.aiI();
        }
    }

    public void Us() {
        if (this.coW != null) {
            this.coW.eV(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cqp = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.Ww != null && this.Ww.getParent() != null && this.Ww.getVisibility() != 8) {
                i2 = (i2 - this.Ww.getMeasuredHeight()) - as(this.Ww);
            }
            jw(i2);
        }
    }

    private void jw(int i) {
        if (this.agt != null && this.agt.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.agt.getLayoutParams();
            layoutParams.height = i;
            this.agt.setLayoutParams(layoutParams);
        }
    }

    private int as(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.cqs = z;
    }

    public void dB(boolean z) {
        this.cqs = z;
        if (this.aMd != null) {
            this.aMd.ki(!z);
            if (z) {
                this.aMd.alQ();
            } else if (this.cqt) {
                this.aMd.a(this.aMh, this.aMg, this.aMf, true);
            }
        }
    }

    public n(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.homepage.personalize.b.ab abVar, FrameLayout frameLayout) {
        this.aTE = hVar;
        this.aMc = bdTypeListView;
        this.agt = view;
        this.aMc.setOnTouchListener(this.aJN);
        this.aMe = new com.baidu.tieba.d.a();
        this.aMe.a(this.aMk);
        this.cql = frameLayout;
        this.cqk = abVar;
        this.cqn = new com.baidu.tieba.homepage.personalize.c.a();
        this.cqd = com.baidu.tbadk.core.sharedPref.b.tW().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.BM);
        this.cqm = new cs();
        ajj();
        this.aMd = new com.baidu.tieba.play.aa(this.aTE, this.aMc);
    }

    private boolean aiW() {
        return com.baidu.tbadk.core.sharedPref.b.tW().getBoolean(aiY(), true);
    }

    private void aiX() {
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean(aiY(), false);
    }

    private String aiY() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aif().jl(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aif().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cqw = true;
        if (this.aNw.size() == 0 && !this.cqg && !aiW()) {
            aje();
        } else {
            ajb();
        }
    }

    public void aiZ() {
        if (this.aMd != null && !this.cqs && this.cqt) {
            this.aMd.a(this.aMh, this.aMg, this.aMf, true);
        }
        if (this.cqu) {
            if (this.cgM && this.cqj > 0) {
                if (fa(false)) {
                    aw(3, this.cqj);
                } else if (this.cqv > 0) {
                    aw(2, this.cqj);
                }
            } else if (!this.cgM && this.cqj == 0) {
                aw(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.tW().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cqu = false;
            this.cgM = false;
            this.cqv = 0;
            if (this.cqw) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cqw = false;
        }
    }

    public void WJ() {
        if (!wv() && this.cqe != null) {
            ajd();
            this.mPn++;
            setIsLoading(true);
            this.cqe.u(this.mPn, (this.cqf == null || this.cqf.thread_list == null) ? 0 : this.cqf.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.aMc.l(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.tW().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cqf == null || this.cqf.thread_list == null) ? 0 : this.cqf.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            this.cqu = false;
            if (this.aNw.size() > 0) {
                if (this.cqe != null) {
                    this.cqe.onError(1, str);
                    return;
                }
                return;
            } else if (this.cqe != null) {
                this.cqe.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aiX();
        if (this.cqe != null) {
            this.cqe.onSuccess();
        }
        this.cqu = true;
        this.cgM = z;
        this.cqv = size;
        ajf();
    }

    public void eZ(boolean z) {
        if (z) {
            this.cqk.notifyDataSetChanged();
        }
        if (!aja()) {
            ajh();
        }
    }

    public void onDestroy() {
        if (this.aMd != null) {
            this.aMd.destroy();
        }
        if (this.cqo != null) {
            this.cqo.onDestroy();
        }
        if (this.cqm != null) {
            this.cqm.onDestroy();
        }
    }

    public void onPause() {
        jz(this.cqE);
        jx(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jx(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jx(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.aTE.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$14
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aja() {
        if (fa(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("close_new_user_guide_tip", false)) {
                fb(true);
            }
            aji();
            if (this.aMc != null) {
                this.aMc.setSelection(0);
                this.aMc.kv();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ajb() {
        if (this.cqe != null) {
            this.cqe.av((this.cqf == null || this.cqf.thread_list == null || ajg()) ? 0 : this.cqf.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cqg = true;
        if (dataRes != null) {
            if (a(false, true, dataRes) && !ajg()) {
                if (this.cqe != null) {
                    this.cqe.onSuccess();
                }
                ajh();
                return;
            }
            ajb();
            return;
        }
        ajb();
    }

    private void ajc() {
        boolean z;
        boolean z2;
        if (this.cqf != null) {
            if (this.cqf.age_sex != null) {
                if (this.cqf.age_sex.sex_tag != null && this.cqf.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.cqf.age_sex.sex_tag.iterator();
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
                        gVar.crV = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                    }
                }
                if (this.cqf.age_sex.age_tag != null && this.cqf.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.cqf.age_sex.age_tag.iterator();
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
                        gVar2.crV = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar2));
                    }
                }
            }
            if (this.cqf.age_sex == null && this.cqf.interestion != null && this.cqf.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.cqf.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private void bp(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.t(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.OW() != null) {
                        dVar.OW().Pz = new com.baidu.tbadk.core.data.b();
                        dVar.OW().Pz.OO = "NEWINDEX";
                        dVar.OW().Pz.pn = 1;
                        dVar.OW().Pz.extensionInfo = dVar.OW().extensionInfo;
                        dVar.OW().Pz.OT = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cqh = dataRes.sug_seconds.intValue() * 1000;
            if (z2 && ajg()) {
                this.cqf = null;
            }
            int size = z2 ? 0 : this.aNw.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aNw.clear();
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cqn.a(z, this.cqf, builder, z2 ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.csd;
                this.cqj = a2.cse;
                list = list2;
            }
            if (list != null) {
                this.aNw.addAll(list);
                if (z2) {
                    bp(list);
                }
                a(z2 ? 0 : 1, list, size);
                if (this.cqw) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
                }
            }
            if (this.cqf == null) {
                this.cqf = builder;
            }
            ajc();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.cqe != null) {
                ArrayList<TagInfo> arrayList = new ArrayList<>(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.aTE.getString(r.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.x.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                N(arrayList);
                this.cqe.bo(arrayList);
            }
            if (this.aNw.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aNw);
                this.cqk.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.cqk.bq(linkedList);
                if (this.aMd != null && this.cqt) {
                    this.aMd.a(this.aMh, this.aMg, this.aMf, true);
                }
                r1 = true;
            }
            com.baidu.tieba.homepage.framework.a.aif().d(System.currentTimeMillis() - currentTimeMillis, 1);
            long jl = com.baidu.tieba.homepage.framework.a.aif().jl(1);
            if (jl > 0) {
                com.baidu.tieba.homepage.framework.a.aif().e(System.currentTimeMillis() - jl, 1);
                com.baidu.tieba.homepage.framework.a.aif().f(0L, 1);
            }
        }
        return r1;
    }

    private void N(ArrayList<TagInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<TagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TagInfo next = it.next();
                if (next.tag_type.intValue() == 5) {
                    com.baidu.tieba.lego.d.e eVar = new com.baidu.tieba.lego.d.e();
                    eVar.dpp = next.lego_page_id.longValue();
                    eVar.dpq = com.baidu.tieba.tbadkCore.u.qb(next.lego_qs);
                    eVar.itemId = com.baidu.tieba.tbadkCore.u.pZ(next.lego_qs);
                    eVar.rn = com.baidu.tieba.tbadkCore.u.qc(next.lego_qs);
                    eVar.params = next.lego_qs;
                    eVar.refresh();
                }
            }
        }
    }

    private void ajd() {
        if (com.baidu.tbadk.core.util.x.s(this.aNw) >= this.cqn.ajq() - 40) {
            com.baidu.tieba.homepage.personalize.c.d a2 = this.cqn.a(true, this.cqf, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.csd : null;
            if (list != null) {
                this.aNw.clear();
                this.aNw.addAll(list);
                this.cqk.bq(new LinkedList(this.aNw));
            }
        }
    }

    private void aje() {
        com.baidu.tbadk.util.t.a(new u(this), new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajf() {
        if (this.cqf != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cqf.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.util.t.a(new w(this, builder), null);
        }
    }

    private boolean ajg() {
        return fa(true);
    }

    private boolean fa(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.tW().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cqd;
    }

    public void a(a aVar) {
        this.cqe = aVar;
    }

    private boolean wv() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        long j = com.baidu.tbadk.core.sharedPref.b.tW().getLong("recommend_frs_guide_time", 0L);
        if (this.cqh != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cqh) {
                aw(1, 0);
            }
        }
    }

    private void aw(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cqp != null && this.cqp.aiv()) {
            this.cqm.Yj();
        } else if (this.cqp == null || this.cqp.getCurrentItem() <= 0) {
            this.cqi = i;
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
                if (this.Ww == null) {
                    this.Ww = new TextView(this.aTE.getPageActivity());
                    this.Ww.setGravity(17);
                    this.Ww.setOnClickListener(this.cqx);
                    jw(this.cqq.getMeasuredHeight());
                }
                this.cqm.Yj();
                if (this.cqq != null && this.Ww.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int dimensionPixelSize = this.aTE.getResources().getDimensionPixelSize(r.e.ds20);
                            int dimensionPixelSize2 = this.aTE.getResources().getDimensionPixelSize(r.e.ds40);
                            this.Ww.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.Ww.setTextSize(0, this.aTE.getResources().getDimensionPixelSize(r.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.tW().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            ar.k(this.Ww, r.f.bg_home_float);
                            ar.j((View) this.Ww, r.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.Ww.setPadding(0, 0, 0, 0);
                        this.Ww.setTextSize(0, this.aTE.getResources().getDimensionPixelSize(r.e.fontsize24));
                        ar.k(this.Ww, r.d.common_color_10260);
                        ar.j((View) this.Ww, r.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.Ww.setText(str);
                    if (i == 1) {
                        this.bCr = 4000;
                    } else {
                        this.bCr = 2000;
                    }
                    this.cqm.a(this.Ww, this.cqq, layoutParams, this.bCr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("close_new_user_guide_tip", true);
        if (this.cqf != null && this.cqf.age_sex != null) {
            this.cqf.age_sex = null;
            if (z) {
                ajf();
            }
        }
        if (this.aNw != null && this.aNw.size() > 0 && (this.aNw.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aNw.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        if (this.aNw != null) {
            this.cqk.bq(new ArrayList(this.aNw));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        if (this.cqf != null && this.cqf.interestion != null) {
            this.cqf.interestion = null;
            ajf();
        }
        if (this.aNw != null && this.aNw.size() > 0 && (this.aNw.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aNw.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        if (this.aNw != null) {
            this.cqk.bq(new ArrayList(this.aNw));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ahj != null) {
                this.ahj.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ahj);
            }
            if (this.cqy != null) {
                this.cqy.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqy);
            }
            if (this.cqz != null) {
                this.cqz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqz);
            }
            if (this.cqA != null) {
                this.cqA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqA);
            }
            if (this.cqB != null) {
                this.cqB.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cqB);
            }
            this.cqC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqC);
            this.ahW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahW);
            this.cqG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqG);
        }
    }

    public void ajj() {
        this.byd = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.byd.bfy();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.byd != null) {
            if (i == 0) {
                this.byd.bfy();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.ffX;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.byd.bk(i3, i7 + 1);
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

    public void jy(int i) {
        if ((this.byd != null ? this.byd.rf(i) : -1) >= 0 && this.aMc != null && this.aMc.getData() != null && this.aMc.getData().size() > i) {
            this.byd.rg(i);
        }
    }

    public com.baidu.tieba.play.aa JI() {
        return this.aMd;
    }

    public void fc(boolean z) {
        this.cqt = z;
    }

    public void jz(int i) {
        com.baidu.tbadk.util.t.a(new x(this, i), null);
    }

    public void a(m mVar) {
        com.baidu.tbadk.util.t.a(new y(this), new aa(this, mVar));
    }

    public void ajk() {
        a(this.cqF);
    }
}
