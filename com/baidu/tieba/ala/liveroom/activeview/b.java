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
    private long aBk;
    private n aDE;
    private int aqT;
    private com.baidu.tieba.ala.liveroom.a.c fuM;
    private Map<Integer, c> fuO;
    private Map<Integer, AlaActiveRootView> fuP;
    private HttpMessageListener fuT;
    private HttpMessageListener fuU;
    private CustomMessageListener fuV;
    private CustomMessageListener fuW;
    private HandlerC0488b fuX;
    private Runnable fuY;
    private List<String> fuZ;
    private boolean fva;
    private boolean fvb;
    private boolean fvc;
    private com.baidu.live.g.a fvd;
    private TbPageContext mPageContext;
    private String otherParams;
    private String fuN = "";
    private boolean isHost = false;
    private SimpleArrayMap<Integer, Integer> fuQ = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fuR = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> fuS = new ArrayList<>();
    private h bcC = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
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
                    b.this.Av(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a fuj = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
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
            if (currentTimeMillis - b.this.aBk >= 400) {
                b.this.aBk = currentTimeMillis;
                if ((obj instanceof f) && b.this.aDE != null && b.this.aDE.aqe != null && b.this.aDE.mLiveInfo != null) {
                    f fVar = (f) obj;
                    String str2 = fVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDE != null && b.this.aDE.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDE.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDE.aqe.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDE.aqe.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDE.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aDE.aqe.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!qk(fVar.apQ)) {
                        b.this.qj(fVar.apQ);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).qd(i);
                        } else if ((view instanceof AlaActiveDynamicView) && fVar.apH && b.this.fuj.qk(fVar.apQ)) {
                            fVar.apH = false;
                        }
                    }
                    b.this.aC(fVar.apV, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDE.mLiveInfo != null) {
                        str3 = b.this.aDE.mLiveInfo.feed_id;
                        str4 = b.this.aDE.mLiveInfo.live_id + "";
                    }
                    b.this.b(fVar, str3, str4);
                    b.this.a(fVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.fuP != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fuP.get(Integer.valueOf(i2));
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
        MessageManager.getInstance().registerListener(this.fal);
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(n nVar, boolean z) {
        this.fvc = z;
        for (int i = 1; i <= 2; i++) {
            qi(i);
        }
        if (this.fuO != null) {
            this.fuO.clear();
        }
        h(nVar);
        if (this.aDE != null) {
            this.fuN = com.baidu.live.c.tH().getString("ala_active_view_click_info", "");
            brq();
            brr();
            bnj();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.fuO == null) {
            this.fuO = new HashMap();
        }
        this.fuO.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        qg(i);
    }

    private void brq() {
        this.fuT = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aDE == null || b.this.aDE.mLiveInfo == null || b.this.aDE.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDE.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.brs();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.DU() != null) {
                            b.this.aqT = getLiveActivityHttpResponseMessage.DU().aqT;
                            b.this.bK(getLiveActivityHttpResponseMessage.DU().ava);
                            b.this.updateView();
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fuT);
    }

    private void brr() {
        this.fuW = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.Av((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fuW);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.fuP != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.fuP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.fuP != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.fuP.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).brC()) {
                        brw();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.fuM != null) {
            this.fuM.resume();
        }
        bnj();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.fuP != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fuP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.fuM != null) {
            this.fuM.pause();
        }
        brt();
        brx();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void h(n nVar) {
        this.aDE = nVar;
    }

    public void setVisible(int i) {
        if (this.fuP != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                i = bq(i2, i);
                bp(i2, i);
            }
        }
    }

    public void bp(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        int bq = bq(i, i2);
        if (this.fuP != null && (alaActiveRootView = this.fuP.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bq);
        }
    }

    private int bq(int i, int i2) {
        if (this.fuQ == null || this.fuQ.get(Integer.valueOf(i)) == null) {
            if (this.fva) {
                if (i2 != 8) {
                    if (this.fvb) {
                        if (i == 1) {
                            if (this.fuR.get(1) == null || this.fuR.get(1).intValue() != 3) {
                                return i2;
                            }
                            return 8;
                        } else if (i == 2) {
                            if (this.fuR.get(2) != null && this.fuR.get(2).intValue() == 3) {
                                return 8;
                            }
                            if (this.fuP != null && this.fuP.get(1) != null) {
                                if (this.fuP.get(1).getVisibility() != 0 || this.fuP.get(1).getChildCount() == 0) {
                                    return i2;
                                }
                                return 8;
                            }
                        }
                    } else if (i == 1) {
                        if (this.fuR.get(1) == null || this.fuR.get(1).intValue() == 3 || this.fuR.get(2) == null || this.fuR.get(2).intValue() != 3) {
                            return i2;
                        }
                        return 8;
                    } else if (i == 2 && this.fuP != null && this.fuP.get(1) != null) {
                        if (this.fuP.get(1).getVisibility() != 0 || this.fuP.get(1).getChildCount() == 0) {
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

    public void Au(String str) {
        if (d.Ev().eQ(str)) {
            bnj();
        }
    }

    public void release() {
        this.aDE = null;
        if (this.fuT != null) {
            MessageManager.getInstance().unRegisterListener(this.fuT);
            this.fuT = null;
        }
        if (this.fuU != null) {
            MessageManager.getInstance().unRegisterListener(this.fuU);
            this.fuU = null;
        }
        if (this.fal != null) {
            MessageManager.getInstance().unRegisterListener(this.fal);
            this.fal = null;
        }
        if (this.fuW != null) {
            MessageManager.getInstance().unRegisterListener(this.fuW);
            this.fuW = null;
        }
        if (this.fuX != null) {
            this.fuX.removeCallbacksAndMessages(null);
        }
        d.Ev().release();
        brx();
        if (this.fuP != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fuP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bA(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.fuP.clear();
        }
        if (this.fuM != null) {
            this.fuM.release();
            this.fuM = null;
        }
    }

    public void jP(boolean z) {
        this.fva = z;
    }

    public void jQ(boolean z) {
        this.fvb = z;
    }

    public void updateView() {
        if (this.fuP != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    if (this.fuP.get(Integer.valueOf(i2)) != null) {
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
        if (this.fuP != null && viewGroup != null && (alaActiveRootView = this.fuP.get(Integer.valueOf(i))) != null) {
            bA(alaActiveRootView);
            alaActiveRootView.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(i2));
            viewGroup.addView(alaActiveRootView, layoutParams);
        }
    }

    public void cl(int i) {
        if (this.fuM != null) {
            this.fuM.cl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.aDE != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.Es().d(this.aDE.aqx.userId, this.aDE.aqe.userId, this.aDE.mLiveInfo.room_id, this.aDE.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        if (this.mRunning) {
            if (this.fuX == null) {
                this.fuX = new HandlerC0488b(this);
            }
            if (this.fuY == null) {
                this.fuY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bnj();
                    }
                };
            }
            brt();
            if (this.aqT <= 0) {
                this.aqT = 5;
            }
            this.fuX.postDelayed(this.fuY, this.aqT * 1000);
        }
    }

    private void brt() {
        if (this.fuX != null && this.fuY != null) {
            this.fuX.removeCallbacks(this.fuY);
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
                    if (fVar.apS == 1) {
                        long j = fVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= fVar.showTime && j <= fVar.end_time && fVar.apX != null && fVar.apX.pos >= 0 && fVar.apX.pos <= 2) {
                            if (fVar.apX.pos == 0) {
                                fVar.apX.pos = 1;
                            }
                            switch (fVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(fVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.apX.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(fVar.apX.pos), list2);
                                        }
                                        list2.add(fVar);
                                        if (!z2 || fVar.apW == null) {
                                            z = z2;
                                        } else {
                                            d.Ev().b(fVar.apW);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(fVar.apX.pos));
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
                                    if (!TextUtils.isEmpty(fVar.webUrl) && fVar.apX != null && fVar.apX.width > 0 && fVar.apX.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.apX.pos));
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
            d.Ev().b(null);
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
            bru();
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
        this.fuR.put(Integer.valueOf(i), Integer.valueOf(i2));
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
        brv();
    }

    private void bru() {
        if (this.fvd != null) {
            Iterator<com.baidu.live.g.b> it = this.fuS.iterator();
            while (it.hasNext()) {
                this.fvd.b(it.next());
            }
            this.fuS.clear();
            this.fvd.vm();
        }
    }

    private void brv() {
        if (this.fvd != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView qh = qh(i);
                if (qh != null && qh.getVisibility() == 0 && qh.getChildCount() > 0 && !this.fuS.contains(qh)) {
                    this.fuS.add(qh);
                    this.fvd.a(qh);
                }
            }
            this.fvd.vm();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.fvd = aVar;
    }

    private ViewGroup qg(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.fuP == null || (alaActiveRootView = this.fuP.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.fuO != null && (cVar = this.fuO.get(Integer.valueOf(i))) != null && (viewGroup = cVar.fvh) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.fuP == null) {
                    this.fuP = new HashMap();
                }
                this.fuP.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(this.fvc ? 1 : 22));
                }
                bA(alaActiveRootView2);
                if (cVar.fvi != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.fvi);
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
        if (this.fuP != null) {
            return this.fuP.get(Integer.valueOf(i));
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
        this.fuQ.put(Integer.valueOf(i), null);
        qi(i);
        ViewGroup qg = qg(i);
        if (qg != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(qg.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.fuj);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.fvc || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.fvc && i == 2) {
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
        this.fuQ.put(Integer.valueOf(i), null);
        qi(i);
        ViewGroup qg = qg(i);
        if (qg != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(qg.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(f fVar2) {
                    if (b.this.fuj != null) {
                        b.this.fuj.b(alaActiveDynamicView, fVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(fVar);
            if (fVar.apH && this.fuj.qk(fVar.apQ)) {
                fVar.apH = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.fvc || i == 2) {
                layoutParams.gravity = 5;
            }
            qg.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(final int i, f fVar) {
        String n = n(fVar.webUrl, fVar.jump_url, fVar.apV);
        if (!TextUtils.isEmpty(n) && fVar.apX != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, fVar.apX.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, fVar.apX.height, this.mPageContext.getResources().getDisplayMetrics());
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
                        if (this.fuj != null) {
                            this.fuj.a(lastChild, fVar, 0);
                            return;
                        }
                        return;
                    }
                }
                this.fuQ.put(Integer.valueOf(i), null);
                qi(i);
                ViewGroup qg = qg(i);
                if (qg != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(qg.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void jR(boolean z) {
                            if (z) {
                                b.this.brw();
                            }
                        }
                    });
                    g gVar = new g();
                    gVar.u(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
                        @Override // com.baidu.live.view.web.f
                        /* renamed from: do */
                        public void mo22do(int i2) {
                            b.this.fuQ.put(Integer.valueOf(i), 8);
                            b.this.updateView();
                        }
                    }).a(alaActiveWebView.getSchemeCallback()).b(this.bcC);
                    com.baidu.live.view.web.a[] HN = gVar.HN();
                    for (com.baidu.live.view.web.a aVar : HN) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(n);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.fvc || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    qg.addView(alaActiveWebView, layoutParams2);
                    if (this.fuj != null) {
                        this.fuj.a(alaActiveWebView, fVar, 0);
                    }
                }
            }
        }
    }

    private String n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aDE != null) {
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
        sb.append(this.aDE.aqx.userId);
        sb.append("&charm_user_id=");
        sb.append(this.aDE.aqe.userId);
        sb.append("&room_id=");
        sb.append(this.aDE.mLiveInfo.room_id);
        sb.append("&live_id=");
        sb.append(this.aDE.mLiveInfo.live_id);
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
    public void brw() {
        if (Build.VERSION.SDK_INT >= 19) {
            brz();
            if (this.fuX == null) {
                this.fuX = new HandlerC0488b(this);
            }
            if (!this.fuX.hasMessages(1000)) {
                this.fuX.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void brx() {
        if (this.fuZ != null) {
            this.fuZ.clear();
        }
        if (this.fuX != null) {
            this.fuX.removeMessages(1000);
        }
        brA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bry() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.fuP != null) {
            if (this.fuZ == null || (size = this.fuZ.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fuZ.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.fuZ.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.fuP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).brC()) {
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
                this.fuX.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                brx();
            }
        }
    }

    private void brz() {
        if (this.fuZ == null) {
            this.fuZ = new ArrayList();
        }
        this.fuZ.clear();
        this.fuV = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.fuZ.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fuV);
    }

    private void brA() {
        if (this.fuV != null) {
            MessageManager.getInstance().unRegisterListener(this.fuV);
            this.fuV = null;
        }
    }

    private void qi(int i) {
        AlaActiveRootView qh = qh(i);
        if (qh != null) {
            qh.release();
        }
    }

    private void c(f fVar) {
        brB();
        d.Ev().c(this.aDE.mLiveInfo.user_id, this.aDE.mLiveInfo.live_id, fVar.activityId);
    }

    private void brB() {
        if (this.fuU == null) {
            this.fuU = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.DT() != null && b.this.fuP != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fuP.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.DT());
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
            MessageManager.getInstance().registerListener(this.fuU);
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
            f.a aVar = activityInfo.apW;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.pu(2);
                alaActiveDynamicView.setTimer(aoVar.avg + " *" + aVar.aqa);
                alaActiveDynamicView.v(j, aVar.endTime);
            } else {
                alaActiveDynamicView.pu(1);
            }
            if (z) {
                if (this.fuj != null) {
                    this.fuj.a(alaActiveDynamicView, activityInfo, 0);
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
                Av(sb.toString());
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

    public void Av(String str) {
        int i = 2;
        if (this.fuM == null) {
            this.fuM = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.fuM.setHost(this.isHost);
        if (this.aDE != null && this.aDE.mLiveInfo != null) {
            this.fuM.g(this.aDE.mLiveInfo.user_id, this.aDE.mLiveInfo.getNameShow());
            this.fuM.setLiveId(this.aDE.mLiveInfo.live_id);
        }
        if (!this.fvc) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.fuM.az(str, i);
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
        if (!this.isHost && fVar != null && this.aDE != null && this.aDE.mLiveInfo != null) {
            String str = this.aDE.mLiveInfo.feed_id;
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
            if (!StringUtils.isNull(this.fuN)) {
                jSONArray = new JSONArray(this.fuN);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.fuN = jSONArray.toString();
            com.baidu.live.c.tH().putString("ala_active_view_click_info", this.fuN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qk(int i) {
        if (StringUtils.isNull(this.fuN)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.fuN);
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
        ViewGroup fvh;
        ViewGroup.LayoutParams fvi;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.fvh = viewGroup;
            this.fvi = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0488b extends Handler {
        private final WeakReference<b> fvg;

        HandlerC0488b(b bVar) {
            this.fvg = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.fvg.get() != null && message.what == 1000) {
                this.fvg.get().bry();
            }
        }
    }
}
