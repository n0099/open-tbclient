package com.baidu.tieba.ala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ao;
import com.baidu.live.data.f;
import com.baidu.live.data.n;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.v.d;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private long aBq;
    private n aDK;
    private int aqZ;
    private com.baidu.tieba.ala.liveroom.a.c fuR;
    private Map<Integer, c> fuT;
    private Map<Integer, AlaActiveRootView> fuU;
    private HttpMessageListener fuY;
    private HttpMessageListener fuZ;
    private CustomMessageListener fva;
    private CustomMessageListener fvb;
    private HandlerC0509b fvc;
    private Runnable fvd;
    private List<String> fve;
    private boolean fvf;
    private boolean fvg;
    private boolean fvh;
    private com.baidu.live.g.a fvi;
    private TbPageContext mPageContext;
    private String otherParams;
    private String fuS = "";
    private boolean isHost = false;
    private SimpleArrayMap<Integer, Integer> fuV = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fuW = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> fuX = new ArrayList<>();
    private h bcH = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        @Override // com.baidu.live.view.web.h
        public void fj(String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter("room");
                if (TextUtils.isEmpty(queryParameter)) {
                    int indexOf = str.indexOf("room=");
                    int length = "room".length() + 1;
                    if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                        queryParameter = str.substring(indexOf + length, indexOf + length + 1);
                    }
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        z = Integer.parseInt(queryParameter) == 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    b.this.Ay(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a fuo = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean qk(int i) {
            return b.this.qk(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof f) {
                b.this.a(view, (f) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aBq >= 400) {
                b.this.aBq = currentTimeMillis;
                if ((obj instanceof f) && b.this.aDK != null && b.this.aDK.aqk != null && b.this.aDK.mLiveInfo != null) {
                    f fVar = (f) obj;
                    String str2 = fVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDK != null && b.this.aDK.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDK.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDK.aqk.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDK.aqk.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDK.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aDK.aqk.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!qk(fVar.apW)) {
                        b.this.qj(fVar.apW);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).qd(i);
                        } else if ((view instanceof AlaActiveDynamicView) && fVar.apN && b.this.fuo.qk(fVar.apW)) {
                            fVar.apN = false;
                        }
                    }
                    b.this.aC(fVar.aqb, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDK.mLiveInfo != null) {
                        str3 = b.this.aDK.mLiveInfo.feed_id;
                        str4 = b.this.aDK.mLiveInfo.live_id + "";
                    }
                    b.this.b(fVar, str3, str4);
                    b.this.a(fVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.fuU != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fuU.get(Integer.valueOf(i2));
                            if (alaActiveRootView != null) {
                                View lastChild = alaActiveRootView.getLastChild();
                                if (lastChild instanceof AlaActiveBannerView) {
                                    ((AlaActiveBannerView) lastChild).setOtherParams(b.this.otherParams);
                                }
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    private boolean mRunning = true;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj, int i);

        void b(View view, Object obj, int i);

        boolean qk(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.faq);
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(n nVar, boolean z) {
        this.fvh = z;
        for (int i = 1; i <= 2; i++) {
            qi(i);
        }
        if (this.fuT != null) {
            this.fuT.clear();
        }
        h(nVar);
        if (this.aDK != null) {
            this.fuS = com.baidu.live.c.tG().getString("ala_active_view_click_info", "");
            bro();
            brp();
            bnh();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.fuT == null) {
            this.fuT = new HashMap();
        }
        this.fuT.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        qg(i);
    }

    private void bro() {
        this.fuY = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aDK == null || b.this.aDK.mLiveInfo == null || b.this.aDK.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDK.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.brq();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.DT() != null) {
                            b.this.aqZ = getLiveActivityHttpResponseMessage.DT().aqZ;
                            b.this.bK(getLiveActivityHttpResponseMessage.DT().avg);
                            b.this.updateView();
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fuY);
    }

    private void brp() {
        this.fvb = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.Ay((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fvb);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.fuU != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.fuU.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.fuU != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.fuU.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).brA()) {
                        bru();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.fuR != null) {
            this.fuR.resume();
        }
        bnh();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.fuU != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fuU.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.fuR != null) {
            this.fuR.pause();
        }
        brr();
        brv();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void h(n nVar) {
        this.aDK = nVar;
    }

    public void setVisible(int i) {
        if (this.fuU != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                i = bq(i2, i);
                bp(i2, i);
            }
        }
    }

    public void bp(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        int bq = bq(i, i2);
        if (this.fuU != null && (alaActiveRootView = this.fuU.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bq);
        }
    }

    private int bq(int i, int i2) {
        if (this.fuV == null || this.fuV.get(Integer.valueOf(i)) == null) {
            if (this.fvf) {
                if (i2 != 8) {
                    if (this.fvg) {
                        if (i == 1) {
                            if (this.fuW.get(1) == null || this.fuW.get(1).intValue() != 3) {
                                return i2;
                            }
                            return 8;
                        } else if (i == 2) {
                            if (this.fuW.get(2) != null && this.fuW.get(2).intValue() == 3) {
                                return 8;
                            }
                            if (this.fuU != null && this.fuU.get(1) != null) {
                                if (this.fuU.get(1).getVisibility() != 0 || this.fuU.get(1).getChildCount() == 0) {
                                    return i2;
                                }
                                return 8;
                            }
                        }
                    } else if (i == 1) {
                        if (this.fuW.get(1) == null || this.fuW.get(1).intValue() == 3 || this.fuW.get(2) == null || this.fuW.get(2).intValue() != 3) {
                            return i2;
                        }
                        return 8;
                    } else if (i == 2 && this.fuU != null && this.fuU.get(1) != null) {
                        if (this.fuU.get(1).getVisibility() != 0 || this.fuU.get(1).getChildCount() == 0) {
                            return i2;
                        }
                        return 8;
                    }
                }
                return 8;
            }
            return i2;
        }
        return 8;
    }

    public void Ax(String str) {
        if (d.Eu().eQ(str)) {
            bnh();
        }
    }

    public void release() {
        this.aDK = null;
        if (this.fuY != null) {
            MessageManager.getInstance().unRegisterListener(this.fuY);
            this.fuY = null;
        }
        if (this.fuZ != null) {
            MessageManager.getInstance().unRegisterListener(this.fuZ);
            this.fuZ = null;
        }
        if (this.faq != null) {
            MessageManager.getInstance().unRegisterListener(this.faq);
            this.faq = null;
        }
        if (this.fvb != null) {
            MessageManager.getInstance().unRegisterListener(this.fvb);
            this.fvb = null;
        }
        if (this.fvc != null) {
            this.fvc.removeCallbacksAndMessages(null);
        }
        d.Eu().release();
        brv();
        if (this.fuU != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fuU.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bA(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.fuU.clear();
        }
        if (this.fuR != null) {
            this.fuR.release();
            this.fuR = null;
        }
    }

    public void jP(boolean z) {
        this.fvf = z;
    }

    public void jQ(boolean z) {
        this.fvg = z;
    }

    public void updateView() {
        if (this.fuU != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    if (this.fuU.get(Integer.valueOf(i2)) != null) {
                        bp(i2, 0);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.fuU != null && viewGroup != null && (alaActiveRootView = this.fuU.get(Integer.valueOf(i))) != null) {
            bA(alaActiveRootView);
            alaActiveRootView.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(i2));
            viewGroup.addView(alaActiveRootView, layoutParams);
        }
    }

    public void cl(int i) {
        if (this.fuR != null) {
            this.fuR.cl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnh() {
        if (this.aDK != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.Er().d(this.aDK.aqD.userId, this.aDK.aqk.userId, this.aDK.mLiveInfo.room_id, this.aDK.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brq() {
        if (this.mRunning) {
            if (this.fvc == null) {
                this.fvc = new HandlerC0509b(this);
            }
            if (this.fvd == null) {
                this.fvd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bnh();
                    }
                };
            }
            brr();
            if (this.aqZ <= 0) {
                this.aqZ = 5;
            }
            this.fvc.postDelayed(this.fvd, this.aqZ * 1000);
        }
    }

    private void brr() {
        if (this.fvc != null && this.fvd != null) {
            this.fvc.removeCallbacks(this.fvd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bK(List<f> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (f fVar : list) {
                if (fVar != null) {
                    if (fVar.apY == 1) {
                        long j = fVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= fVar.showTime && j <= fVar.end_time && fVar.aqd != null && fVar.aqd.pos >= 0 && fVar.aqd.pos <= 2) {
                            if (fVar.aqd.pos == 0) {
                                fVar.aqd.pos = 1;
                            }
                            switch (fVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(fVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.aqd.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(fVar.aqd.pos), list2);
                                        }
                                        list2.add(fVar);
                                        if (!z2 || fVar.aqc == null) {
                                            z = z2;
                                        } else {
                                            d.Eu().b(fVar.aqc);
                                            z = true;
                                        }
                                        z2 = z;
                                        break;
                                    }
                                    break;
                                case 1:
                                case 2:
                                default:
                                    if (hashMap == null) {
                                    }
                                    list2 = (List) hashMap.get(Integer.valueOf(fVar.aqd.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(fVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(fVar.webUrl) && fVar.aqd != null && fVar.aqd.width > 0 && fVar.aqd.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.aqd.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(fVar);
                                        if (z2) {
                                        }
                                        z = z2;
                                        z2 = z;
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (!z2) {
            d.Eu().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r0.picType;
        r2 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(int i, List<f> list) {
        int i2;
        f fVar = null;
        if (list == null || list.isEmpty()) {
            brs();
            qi(i);
            return;
        }
        Iterator<f> it = list.iterator();
        ArrayList<f> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            f next = it.next();
            if (next.picType != 1 && next.picType != 3) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                if (arrayList.size() >= 5) {
                    i2 = 0;
                    break;
                }
            } else {
                break;
            }
        }
        this.fuW.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                a(i, arrayList, "");
                break;
            case 1:
                a(i, fVar);
                c(fVar);
                break;
            case 2:
            default:
                qi(i);
                break;
            case 3:
                b(i, fVar);
                break;
        }
        brt();
    }

    private void brs() {
        if (this.fvi != null) {
            Iterator<com.baidu.live.g.b> it = this.fuX.iterator();
            while (it.hasNext()) {
                this.fvi.b(it.next());
            }
            this.fuX.clear();
            this.fvi.vl();
        }
    }

    private void brt() {
        if (this.fvi != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView qh = qh(i);
                if (qh != null && qh.getVisibility() == 0 && qh.getChildCount() > 0 && !this.fuX.contains(qh)) {
                    this.fuX.add(qh);
                    this.fvi.a(qh);
                }
            }
            this.fvi.vl();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.fvi = aVar;
    }

    private ViewGroup qg(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.fuU == null || (alaActiveRootView = this.fuU.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.fuT != null && (cVar = this.fuT.get(Integer.valueOf(i))) != null && (viewGroup = cVar.fvm) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.fuU == null) {
                    this.fuU = new HashMap();
                }
                this.fuU.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(this.fvh ? 1 : 22));
                }
                bA(alaActiveRootView2);
                if (cVar.fvn != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.fvn);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bA(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView qh(int i) {
        if (this.fuU != null) {
            return this.fuU.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<f> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            qi(i);
            return;
        }
        AlaActiveRootView qh = qh(i);
        if (qh != null && qh.getChildCount() == 1) {
            View lastChild = qh.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        this.fuV.put(Integer.valueOf(i), null);
        qi(i);
        ViewGroup qg = qg(i);
        if (qg != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(qg.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.fuo);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.fvh || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.fvh && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            }
            qg.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, f fVar) {
        AlaActiveRootView qh = qh(i);
        if (qh != null && qh.getChildCount() == 1) {
            View lastChild = qh.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(fVar);
                return;
            }
        }
        this.fuV.put(Integer.valueOf(i), null);
        qi(i);
        ViewGroup qg = qg(i);
        if (qg != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(qg.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(f fVar2) {
                    if (b.this.fuo != null) {
                        b.this.fuo.b(alaActiveDynamicView, fVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(fVar);
            if (fVar.apN && this.fuo.qk(fVar.apW)) {
                fVar.apN = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.fvh || i == 2) {
                layoutParams.gravity = 5;
            }
            qg.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(final int i, f fVar) {
        String n = n(fVar.webUrl, fVar.jump_url, fVar.aqb);
        if (!TextUtils.isEmpty(n) && fVar.aqd != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, fVar.aqd.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, fVar.aqd.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView qh = qh(i);
                if (qh != null && qh.getChildCount() == 1) {
                    View lastChild = qh.getLastChild();
                    if (lastChild instanceof AlaActiveWebView) {
                        if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(n)) {
                            ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                            ((AlaActiveWebView) lastChild).loadUrl(n);
                        }
                        ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                        if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                            layoutParams.width = applyDimension;
                            layoutParams.height = applyDimension2;
                            lastChild.setLayoutParams(layoutParams);
                        }
                        if (this.fuo != null) {
                            this.fuo.a(lastChild, fVar, 0);
                            return;
                        }
                        return;
                    }
                }
                this.fuV.put(Integer.valueOf(i), null);
                qi(i);
                ViewGroup qg = qg(i);
                if (qg != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(qg.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void jR(boolean z) {
                            if (z) {
                                b.this.bru();
                            }
                        }
                    });
                    g gVar = new g();
                    gVar.u(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
                        @Override // com.baidu.live.view.web.f
                        /* renamed from: do */
                        public void mo22do(int i2) {
                            b.this.fuV.put(Integer.valueOf(i), 8);
                            b.this.updateView();
                        }
                    }).a(alaActiveWebView.getSchemeCallback()).b(this.bcH);
                    com.baidu.live.view.web.a[] HM = gVar.HM();
                    for (com.baidu.live.view.web.a aVar : HM) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(n);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.fvh || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    qg.addView(alaActiveWebView, layoutParams2);
                    if (this.fuo != null) {
                        this.fuo.a(alaActiveWebView, fVar, 0);
                    }
                }
            }
        }
    }

    private String n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aDK != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            a(sb);
            sb.append("&jump_url=");
            sb.append(aC(str2, i));
            return sb.toString();
        }
        return str;
    }

    private void a(StringBuilder sb) {
        sb.append("user_id=");
        sb.append(this.aDK.aqD.userId);
        sb.append("&charm_user_id=");
        sb.append(this.aDK.aqk.userId);
        sb.append("&room_id=");
        sb.append(this.aDK.mLiveInfo.room_id);
        sb.append("&live_id=");
        sb.append(this.aDK.mLiveInfo.live_id);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&_client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        if (this.isHost) {
            sb.append("&is_host=1");
        }
    }

    private String aC(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        if (i == 2) {
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("room");
            sb.append(ETAG.EQUAL);
            sb.append(1);
        }
        try {
            return URLEncoder.encode(sb.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bru() {
        if (Build.VERSION.SDK_INT >= 19) {
            brx();
            if (this.fvc == null) {
                this.fvc = new HandlerC0509b(this);
            }
            if (!this.fvc.hasMessages(1000)) {
                this.fvc.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void brv() {
        if (this.fve != null) {
            this.fve.clear();
        }
        if (this.fvc != null) {
            this.fvc.removeMessages(1000);
        }
        bry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.fuU != null) {
            if (this.fve == null || (size = this.fve.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fve.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.fve.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.fuU.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).brA()) {
                        if (!TextUtils.isEmpty(str)) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                ((AlaActiveWebView) lastChild).evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                                z = true;
                                i2++;
                                z2 = z;
                            } else {
                                ((AlaActiveWebView) lastChild).loadUrl("javascript:getClientInfo(" + str + ")");
                            }
                        }
                        z = true;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.fvc.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                brv();
            }
        }
    }

    private void brx() {
        if (this.fve == null) {
            this.fve = new ArrayList();
        }
        this.fve.clear();
        this.fva = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.fve.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fva);
    }

    private void bry() {
        if (this.fva != null) {
            MessageManager.getInstance().unRegisterListener(this.fva);
            this.fva = null;
        }
    }

    private void qi(int i) {
        AlaActiveRootView qh = qh(i);
        if (qh != null) {
            qh.release();
        }
    }

    private void c(f fVar) {
        brz();
        d.Eu().a(this.aDK.mLiveInfo.user_id, this.aDK.mLiveInfo.live_id, fVar.activityId);
    }

    private void brz() {
        if (this.fuZ == null) {
            this.fuZ = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.DS() != null && b.this.fuU != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fuU.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.DS());
                                                return;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                    i = i2 + 1;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fuZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, ao aoVar) {
        boolean z;
        f activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, aoVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            } else {
                z = false;
            }
            f.a aVar = activityInfo.aqc;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.pu(2);
                alaActiveDynamicView.setTimer(aoVar.avm + " *" + aVar.aqg);
                alaActiveDynamicView.v(j, aVar.endTime);
            } else {
                alaActiveDynamicView.pu(1);
            }
            if (z) {
                if (this.fuo != null) {
                    this.fuo.a(alaActiveDynamicView, activityInfo, 0);
                }
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                sb.append("room");
                sb.append(ETAG.EQUAL);
                sb.append(1);
                sb.append(ETAG.ITEM_SEPARATOR);
                a(sb);
                Ay(sb.toString());
                return;
            }
            if (i == 1) {
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                a(sb2);
                str = sb2.toString();
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Ay(String str) {
        int i = 2;
        if (this.fuR == null) {
            this.fuR = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.fuR.setHost(this.isHost);
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            this.fuR.g(this.aDK.mLiveInfo.user_id, this.aDK.mLiveInfo.getNameShow());
            this.fuR.setLiveId(this.aDK.mLiveInfo.live_id);
        }
        if (!this.fvh) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.fuR.az(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, f fVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (fVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(fVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (fVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(fVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar, String str, String str2) {
        if (!this.isHost && fVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, fVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void d(f fVar) {
        if (!this.isHost && fVar != null && this.aDK != null && this.aDK.mLiveInfo != null) {
            String str = this.aDK.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                    alaStaticItem.addParams("feed_id", str);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, fVar.activityId + "");
                    alaStaticItem.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.fuS)) {
                jSONArray = new JSONArray(this.fuS);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.fuS = jSONArray.toString();
            com.baidu.live.c.tG().putString("ala_active_view_click_info", this.fuS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qk(int i) {
        if (StringUtils.isNull(this.fuS)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.fuS);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.optInt(i2, -1) == i) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ViewGroup fvm;
        ViewGroup.LayoutParams fvn;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.fvm = viewGroup;
            this.fvn = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0509b extends Handler {
        private final WeakReference<b> fvl;

        HandlerC0509b(b bVar) {
            this.fvl = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.fvl.get() != null && message.what == 1000) {
                this.fvl.get().brw();
            }
        }
    }
}
