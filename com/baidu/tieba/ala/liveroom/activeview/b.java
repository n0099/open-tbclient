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
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.l;
import com.baidu.live.data.u;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.live.x.d;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private u aAP;
    private int aFS;
    private long aRW;
    private com.baidu.tieba.ala.liveroom.a.c goH;
    private HttpMessageListener goP;
    private HttpMessageListener goQ;
    private CustomMessageListener goR;
    private CustomMessageListener goS;
    private HandlerC0618b goT;
    private Runnable goU;
    private List<String> goV;
    private boolean goW;
    private boolean goX;
    private com.baidu.live.g.a goY;
    private String goZ;
    private TbPageContext mPageContext;
    private String otherParams;
    private String goI = "";
    private boolean isHost = false;
    private Map<Integer, c> goJ = new HashMap();
    private Map<Integer, AlaActiveRootView> goK = new HashMap();
    private SimpleArrayMap<Integer, Integer> goL = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> goM = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> goN = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> goO = new ArrayList<>();
    private h byJ = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void hU(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (b.this.ec(str, "fullscreen")) {
                    b.this.Gk(str);
                } else if (b.this.ec(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                    b.this.Gm(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a gof = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean uh(int i) {
            return b.this.uh(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof l) {
                b.this.a(view, (l) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aRW >= 400) {
                b.this.aRW = currentTimeMillis;
                if ((obj instanceof l) && b.this.aAP != null && b.this.aAP.aEz != null && b.this.aAP.mLiveInfo != null) {
                    l lVar = (l) obj;
                    String str2 = lVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aAP != null && b.this.aAP.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aAP.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aAP.aEz.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aAP.aEz.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aAP.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aAP.aEz.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!uh(lVar.aEl)) {
                        b.this.ug(lVar.aEl);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).ua(i);
                        } else if ((view instanceof AlaActiveDynamicView) && lVar.aEc && b.this.gof.uh(lVar.aEl)) {
                            lVar.aEc = false;
                        }
                    }
                    b.this.aJ(lVar.aEq, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aAP.mLiveInfo != null) {
                        str3 = b.this.aAP.mLiveInfo.feed_id;
                        str4 = b.this.aAP.mLiveInfo.live_id + "";
                    }
                    b.this.b(lVar, str3, str4);
                    b.this.a(lVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.goK != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.goK.get(Integer.valueOf(i2));
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

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, Object obj, int i);

        void b(View view, Object obj, int i);

        boolean uh(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.goL.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.fTe);
    }

    public void Gj(String str) {
        this.goZ = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(u uVar, boolean z) {
        this.goW = z;
        for (int i = 1; i <= 2; i++) {
            uf(i);
        }
        if (this.goJ != null) {
            this.goJ.clear();
        }
        k(uVar);
        if (this.aAP != null) {
            this.goI = com.baidu.live.c.AR().getString("ala_active_view_click_info", "");
            bNX();
            bNY();
            bvV();
        }
    }

    public void y(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && z(aVar)) {
                    Gk(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.goX) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bOi();
            bOj();
            this.goH.Gi(str);
        }
    }

    private boolean z(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Kq = aVar.Kq();
        return ListUtils.isEmpty(Kq) || Kq.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.goJ.put(Integer.valueOf(i), new c(pendantParentView));
            ud(i);
        }
    }

    private void bNX() {
        if (this.goP == null) {
            this.goP = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aAP == null || b.this.aAP.mLiveInfo == null || b.this.aAP.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aAP.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bNZ();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Mk() != null) {
                                b.this.aFS = getLiveActivityHttpResponseMessage.Mk().aFS;
                                b.this.ca(getLiveActivityHttpResponseMessage.Mk().aKw);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.goP);
    }

    private void bNY() {
        if (this.goS == null) {
            this.goS = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Gm((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.goS);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.goK != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.goK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.goK != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.goK.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bOk()) {
                        bOd();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.goH != null) {
            this.goH.resume();
        }
        bvV();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.goK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.goK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.goH != null) {
            this.goH.pause();
        }
        bOa();
        bOe();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void k(u uVar) {
        this.aAP = uVar;
    }

    public void setVisible(int i) {
        if (this.goK != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bI(i2, i);
            }
        }
    }

    public void bI(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.goL.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bJ = bJ(i, i2);
        if (this.goK != null && (alaActiveRootView = this.goK.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bJ);
        }
    }

    private int bJ(int i, int i2) {
        if (this.goM != null && this.goM.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.goL != null && this.goL.get(Integer.valueOf(i)).intValue() != 0) {
            return this.goL.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Gl(String str) {
        if (d.NU().ht(str)) {
            bvV();
        }
    }

    public void release() {
        this.aAP = null;
        this.goZ = null;
        if (this.goP != null) {
            MessageManager.getInstance().unRegisterListener(this.goP);
            this.goP = null;
        }
        if (this.goQ != null) {
            MessageManager.getInstance().unRegisterListener(this.goQ);
            this.goQ = null;
        }
        if (this.fTe != null) {
            MessageManager.getInstance().unRegisterListener(this.fTe);
            this.fTe = null;
        }
        if (this.goS != null) {
            MessageManager.getInstance().unRegisterListener(this.goS);
            this.goS = null;
        }
        if (this.goT != null) {
            this.goT.removeCallbacksAndMessages(null);
        }
        d.NU().release();
        bOe();
        if (this.goK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.goK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bO(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.goK.clear();
        }
        if (this.goH != null) {
            this.goH.release();
            this.goH = null;
        }
    }

    public void lD(boolean z) {
    }

    public void lE(boolean z) {
    }

    public void updateView() {
        if (this.goK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.goK.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bJ(i2, this.goL.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dD(int i) {
        if (this.goH != null) {
            this.goH.dD(i);
        }
    }

    public void lF(boolean z) {
        this.goX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvV() {
        if (this.aAP != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.x.b.NR().d(this.aAP.aFb.userId, this.aAP.aEz.userId, this.aAP.mLiveInfo.room_id, this.aAP.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNZ() {
        if (this.mRunning) {
            if (this.goT == null) {
                this.goT = new HandlerC0618b(this);
            }
            if (this.goU == null) {
                this.goU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bvV();
                    }
                };
            }
            bOa();
            if (this.aFS <= 0) {
                this.aFS = 5;
            }
            this.goT.postDelayed(this.goU, this.aFS * 1000);
        }
    }

    private void bOa() {
        if (this.goT != null && this.goU != null) {
            this.goT.removeCallbacks(this.goU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ca(List<l> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (l lVar : list) {
                if (lVar != null) {
                    if (lVar.aEn == 1) {
                        long j = lVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= lVar.showTime && j <= lVar.end_time && lVar.aEs != null && lVar.aEs.pos >= 0 && lVar.aEs.pos <= 2) {
                            if (lVar.aEs.pos == 0) {
                                lVar.aEs.pos = 1;
                            }
                            switch (lVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(lVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(lVar.aEs.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(lVar.aEs.pos), list2);
                                        }
                                        list2.add(lVar);
                                        if (!z2 || lVar.aEr == null) {
                                            z = z2;
                                        } else {
                                            d.NU().b(lVar.aEr);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(lVar.aEs.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(lVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(lVar.webUrl) && lVar.aEs != null && lVar.aEs.width > 0 && lVar.aEs.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(lVar.aEs.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(lVar);
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
            d.NU().b(null);
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
    private void k(int i, List<l> list) {
        int i2;
        l lVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bOb();
            uf(i);
            return;
        }
        Iterator<l> it = list.iterator();
        ArrayList<l> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            l next = it.next();
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
        this.goN.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                uf(i);
                break;
            case 3:
                z = a(i, lVar);
                break;
        }
        c cVar = this.goJ.get(Integer.valueOf(i));
        if (cVar != null && cVar.gpc != null && z) {
            cVar.gpc.a(this.goK.get(Integer.valueOf(i)));
        }
        bOc();
    }

    private void bOb() {
        if (this.goY != null) {
            Iterator<com.baidu.live.g.b> it = this.goO.iterator();
            while (it.hasNext()) {
                this.goY.b(it.next());
            }
            this.goO.clear();
            this.goY.Dv();
        }
    }

    private void bOc() {
        if (this.goY != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView ue = ue(i);
                if (ue != null && ue.getVisibility() == 0 && ue.getChildCount() > 0 && !this.goO.contains(ue)) {
                    this.goO.add(ue);
                    this.goY.a(ue);
                }
            }
            this.goY.Dv();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.goY = aVar;
    }

    private AlaActiveRootView ud(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.goK == null || (alaActiveRootView = this.goK.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.goJ != null && (cVar = this.goJ.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gpc;
                if (pendantParentView == null || this.goK == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.goK.put(Integer.valueOf(i), alaActiveRootView2);
                bO(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bO(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView ue(int i) {
        if (this.goK != null) {
            return this.goK.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<l> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            uf(i);
            return false;
        }
        AlaActiveRootView ue = ue(i);
        if (ue != null && ue.getChildCount() == 1) {
            View lastChild = ue.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.goM.put(Integer.valueOf(i), null);
        uf(i);
        AlaActiveRootView ud = ud(i);
        if (ud == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(ud.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.gof);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.goW || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.goW && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        ud.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, l lVar) {
        String o = o(lVar.webUrl, lVar.jump_url, lVar.aEq);
        if (!TextUtils.isEmpty(o) && lVar.aEs != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, lVar.aEs.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, lVar.aEs.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView ue = ue(i);
            if (ue != null && ue.getChildCount() == 1) {
                View lastChild = ue.getLastChild();
                if (lastChild instanceof AlaActiveWebView) {
                    if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(o)) {
                        ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                        ((AlaActiveWebView) lastChild).loadUrl(o);
                    }
                    ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                    if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                        layoutParams.width = applyDimension;
                        layoutParams.height = applyDimension2;
                        lastChild.setLayoutParams(layoutParams);
                    }
                    if (this.gof != null) {
                        this.gof.a(lastChild, lVar, 0);
                    }
                    return false;
                }
            }
            this.goM.put(Integer.valueOf(i), null);
            uf(i);
            AlaActiveRootView ud = ud(i);
            if (ud == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(ud.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void lG(boolean z) {
                    if (z) {
                        b.this.bOd();
                    }
                }
            });
            g gVar = new g();
            gVar.w(this.mPageContext.getPageActivity()).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void eL(int i2) {
                    b.this.goM.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.byJ);
            com.baidu.live.view.web.a[] RE = gVar.RE();
            for (com.baidu.live.view.web.a aVar : RE) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(o);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.goW || i == 2) {
                layoutParams2.gravity = 5;
            }
            ud.addView(alaActiveWebView, layoutParams2);
            if (this.gof != null) {
                this.gof.a(alaActiveWebView, lVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String o(String str, String str2, int i) {
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aAP == null) {
            return str;
        }
        String valueOf = this.aAP.aFb != null ? String.valueOf(this.aAP.aFb.userId) : null;
        String valueOf2 = this.aAP.aEz != null ? String.valueOf(this.aAP.aEz.userId) : null;
        if (this.aAP.mLiveInfo != null) {
            str3 = String.valueOf(this.aAP.mLiveInfo.room_id);
            str4 = String.valueOf(this.aAP.mLiveInfo.live_id);
        } else {
            str3 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(this.isHost, valueOf, valueOf2, str3, str4);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aE(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aE(String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            str2 = WebviewHelper.addQueryParams(str, hashMap);
        } else {
            str2 = str;
        }
        try {
            return URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ec(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (TextUtils.isEmpty(queryParameter)) {
            int indexOf = str.indexOf(str2 + ETAG.EQUAL);
            int length = str2.length() + 1;
            if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                queryParameter = str.substring(indexOf + length, indexOf + length + 1);
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        try {
            return Integer.parseInt(queryParameter) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOd() {
        if (Build.VERSION.SDK_INT >= 19) {
            bOg();
            if (this.goT == null) {
                this.goT = new HandlerC0618b(this);
            }
            if (!this.goT.hasMessages(1000)) {
                this.goT.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bOe() {
        if (this.goV != null) {
            this.goV.clear();
        }
        if (this.goT != null) {
            this.goT.removeMessages(1000);
        }
        bOh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOf() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.goK != null) {
            if (this.goV == null || (size = this.goV.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.goV.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.goV.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.goK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bOk()) {
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
                this.goT.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bOe();
            }
        }
    }

    private void bOg() {
        if (this.goV == null) {
            this.goV = new ArrayList();
        }
        this.goV.clear();
        this.goR = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.goV.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.goR);
    }

    private void bOh() {
        if (this.goR != null) {
            MessageManager.getInstance().unRegisterListener(this.goR);
            this.goR = null;
        }
    }

    private void uf(int i) {
        AlaActiveRootView ue = ue(i);
        if (ue != null) {
            ue.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aAP != null) {
                String valueOf = this.aAP.aFb != null ? String.valueOf(this.aAP.aFb.userId) : null;
                String valueOf2 = this.aAP.aEz != null ? String.valueOf(this.aAP.aEz.userId) : null;
                if (this.aAP.mLiveInfo != null) {
                    str3 = String.valueOf(this.aAP.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aAP.mLiveInfo.live_id);
                    str4 = valueOf2;
                    str5 = valueOf;
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = valueOf2;
                    str5 = valueOf;
                }
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.goZ);
            if (i == 2) {
                Gm(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Gm(String str) {
        int i = 2;
        bOi();
        bOj();
        if (!this.goW) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.goH.aC(str, i);
    }

    private void bOi() {
        if (this.goH == null) {
            this.goH = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bOj() {
        this.goH.setHost(this.isHost);
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            this.goH.e(this.aAP.mLiveInfo.user_id, this.aAP.mLiveInfo.getNameShow(), this.aAP.aEz != null ? this.aAP.aEz.portrait : null);
            this.goH.setLiveId(this.aAP.mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (lVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(lVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (lVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(lVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar, String str, String str2) {
        if (!this.isHost && lVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, lVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.goI)) {
                jSONArray = new JSONArray(this.goI);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.goI = jSONArray.toString();
            com.baidu.live.c.AR().putString("ala_active_view_click_info", this.goI);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uh(int i) {
        if (StringUtils.isNull(this.goI)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.goI);
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
    /* loaded from: classes4.dex */
    public static class c {
        PendantParentView gpc;

        c(PendantParentView pendantParentView) {
            this.gpc = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0618b extends Handler {
        private final WeakReference<b> gpb;

        HandlerC0618b(b bVar) {
            this.gpb = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gpb.get() != null && message.what == 1000) {
                this.gpb.get().bOf();
            }
        }
    }
}
