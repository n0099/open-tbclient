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
import com.baidu.live.data.i;
import com.baidu.live.data.q;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.v.d;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
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
    private long aKF;
    private q avf;
    private int azu;
    private List<String> bdA;
    private CustomMessageListener bdC;
    private HttpMessageListener fZF;
    private HttpMessageListener fZG;
    private CustomMessageListener fZH;
    private HandlerC0575b fZI;
    private Runnable fZJ;
    private boolean fZK;
    private com.baidu.live.g.a fZL;
    private String fZM;
    private com.baidu.tieba.ala.liveroom.a.c fZx;
    private TbPageContext mPageContext;
    private String otherParams;
    private String fZy = "";
    private boolean isHost = false;
    private Map<Integer, c> fZz = new HashMap();
    private Map<Integer, AlaActiveRootView> fZA = new HashMap();
    private SimpleArrayMap<Integer, Integer> fZB = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fZC = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fZD = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> fZE = new ArrayList<>();
    private h bpD = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void gc(String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter(UbcStatConstant.KEY_CONTENT_ROOM);
                if (TextUtils.isEmpty(queryParameter)) {
                    int indexOf = str.indexOf("room=");
                    int length = UbcStatConstant.KEY_CONTENT_ROOM.length() + 1;
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
                    b.this.Dr(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a fYV = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean rC(int i) {
            return b.this.rC(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof i) {
                b.this.a(view, (i) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aKF >= 400) {
                b.this.aKF = currentTimeMillis;
                if ((obj instanceof i) && b.this.avf != null && b.this.avf.ayC != null && b.this.avf.mLiveInfo != null) {
                    i iVar = (i) obj;
                    String str2 = iVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.avf != null && b.this.avf.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.avf.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.avf.ayC.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.avf.ayC.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.avf.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.avf.ayC.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!rC(iVar.ayo)) {
                        b.this.rB(iVar.ayo);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).rv(i);
                        } else if ((view instanceof AlaActiveDynamicView) && iVar.ayf && b.this.fYV.rC(iVar.ayo)) {
                            iVar.ayf = false;
                        }
                    }
                    b.this.aL(iVar.ayt, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.avf.mLiveInfo != null) {
                        str3 = b.this.avf.mLiveInfo.feed_id;
                        str4 = b.this.avf.mLiveInfo.live_id + "";
                    }
                    b.this.b(iVar, str3, str4);
                    b.this.a(iVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.fZA != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fZA.get(Integer.valueOf(i2));
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

        boolean rC(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.fZB.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.fEy);
    }

    public void Dp(String str) {
        this.fZM = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(q qVar, boolean z) {
        this.fZK = z;
        for (int i = 1; i <= 2; i++) {
            rA(i);
        }
        if (this.fZz != null) {
            this.fZz.clear();
        }
        j(qVar);
        if (this.avf != null) {
            this.fZy = com.baidu.live.c.vf().getString("ala_active_view_click_info", "");
            bDs();
            bDt();
            bmd();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.fZz.put(Integer.valueOf(i), new c(pendantParentView));
            ry(i);
        }
    }

    private void bDs() {
        if (this.fZF == null) {
            this.fZF = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.avf == null || b.this.avf.mLiveInfo == null || b.this.avf.mLiveInfo.mAlaLiveSwitchData == null || !b.this.avf.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bDu();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.FV() != null) {
                                b.this.azu = getLiveActivityHttpResponseMessage.FV().azu;
                                b.this.bU(getLiveActivityHttpResponseMessage.FV().aDU);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fZF);
    }

    private void bDt() {
        if (this.fZH == null) {
            this.fZH = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Dr((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fZH);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.fZA != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.fZA.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.fZA != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.fZA.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bDz()) {
                        Hd();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.fZx != null) {
            this.fZx.resume();
        }
        bmd();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.fZA != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fZA.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.fZx != null) {
            this.fZx.pause();
        }
        bDv();
        Hh();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(q qVar) {
        this.avf = qVar;
    }

    public void setVisible(int i) {
        if (this.fZA != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bA(i2, i);
            }
        }
    }

    public void bA(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.fZB.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bB = bB(i, i2);
        if (this.fZA != null && (alaActiveRootView = this.fZA.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bB);
        }
    }

    private int bB(int i, int i2) {
        if (this.fZC != null && this.fZC.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.fZB != null && this.fZB.get(Integer.valueOf(i)).intValue() != 0) {
            return this.fZB.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Dq(String str) {
        if (d.Hz().fI(str)) {
            bmd();
        }
    }

    public void release() {
        this.avf = null;
        this.fZM = null;
        if (this.fZF != null) {
            MessageManager.getInstance().unRegisterListener(this.fZF);
            this.fZF = null;
        }
        if (this.fZG != null) {
            MessageManager.getInstance().unRegisterListener(this.fZG);
            this.fZG = null;
        }
        if (this.fEy != null) {
            MessageManager.getInstance().unRegisterListener(this.fEy);
            this.fEy = null;
        }
        if (this.fZH != null) {
            MessageManager.getInstance().unRegisterListener(this.fZH);
            this.fZH = null;
        }
        if (this.fZI != null) {
            this.fZI.removeCallbacksAndMessages(null);
        }
        d.Hz().release();
        Hh();
        if (this.fZA != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fZA.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bI(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.fZA.clear();
        }
        if (this.fZx != null) {
            this.fZx.release();
            this.fZx = null;
        }
    }

    public void la(boolean z) {
    }

    public void lb(boolean z) {
    }

    public void updateView() {
        if (this.fZA != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.fZA.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bB(i2, this.fZB.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bN(int i) {
        if (this.fZx != null) {
            this.fZx.bN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        if (this.avf != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.Hw().d(this.avf.ayV.userId, this.avf.ayC.userId, this.avf.mLiveInfo.room_id, this.avf.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDu() {
        if (this.mRunning) {
            if (this.fZI == null) {
                this.fZI = new HandlerC0575b(this);
            }
            if (this.fZJ == null) {
                this.fZJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bmd();
                    }
                };
            }
            bDv();
            if (this.azu <= 0) {
                this.azu = 5;
            }
            this.fZI.postDelayed(this.fZJ, this.azu * 1000);
        }
    }

    private void bDv() {
        if (this.fZI != null && this.fZJ != null) {
            this.fZI.removeCallbacks(this.fZJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bU(List<i> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (i iVar : list) {
                if (iVar != null) {
                    if (iVar.ayq == 1) {
                        long j = iVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= iVar.showTime && j <= iVar.end_time && iVar.ayv != null && iVar.ayv.pos >= 0 && iVar.ayv.pos <= 2) {
                            if (iVar.ayv.pos == 0) {
                                iVar.ayv.pos = 1;
                            }
                            switch (iVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(iVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.ayv.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(iVar.ayv.pos), list2);
                                        }
                                        list2.add(iVar);
                                        if (!z2 || iVar.ayu == null) {
                                            z = z2;
                                        } else {
                                            d.Hz().b(iVar.ayu);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(iVar.ayv.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(iVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(iVar.webUrl) && iVar.ayv != null && iVar.ayv.width > 0 && iVar.ayv.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.ayv.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(iVar);
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
            d.Hz().b(null);
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
    private void k(int i, List<i> list) {
        int i2;
        i iVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bDw();
            rA(i);
            return;
        }
        Iterator<i> it = list.iterator();
        ArrayList<i> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            i next = it.next();
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
        this.fZD.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                rA(i);
                break;
            case 3:
                z = a(i, iVar);
                break;
        }
        c cVar = this.fZz.get(Integer.valueOf(i));
        if (cVar != null && cVar.fZO != null && z) {
            cVar.fZO.a(this.fZA.get(Integer.valueOf(i)));
        }
        bDx();
    }

    private void bDw() {
        if (this.fZL != null) {
            Iterator<com.baidu.live.g.b> it = this.fZE.iterator();
            while (it.hasNext()) {
                this.fZL.b(it.next());
            }
            this.fZE.clear();
            this.fZL.xC();
        }
    }

    private void bDx() {
        if (this.fZL != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView rz = rz(i);
                if (rz != null && rz.getVisibility() == 0 && rz.getChildCount() > 0 && !this.fZE.contains(rz)) {
                    this.fZE.add(rz);
                    this.fZL.a(rz);
                }
            }
            this.fZL.xC();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.fZL = aVar;
    }

    private AlaActiveRootView ry(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.fZA == null || (alaActiveRootView = this.fZA.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.fZz != null && (cVar = this.fZz.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.fZO;
                if (pendantParentView == null || this.fZA == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.fZA.put(Integer.valueOf(i), alaActiveRootView2);
                bI(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bI(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView rz(int i) {
        if (this.fZA != null) {
            return this.fZA.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<i> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            rA(i);
            return false;
        }
        AlaActiveRootView rz = rz(i);
        if (rz != null && rz.getChildCount() == 1) {
            View lastChild = rz.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.fZC.put(Integer.valueOf(i), null);
        rA(i);
        AlaActiveRootView ry = ry(i);
        if (ry == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(ry.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.fYV);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.fZK || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.fZK && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        ry.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, i iVar) {
        String n = n(iVar.webUrl, iVar.jump_url, iVar.ayt);
        if (!TextUtils.isEmpty(n) && iVar.ayv != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, iVar.ayv.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, iVar.ayv.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView rz = rz(i);
            if (rz != null && rz.getChildCount() == 1) {
                View lastChild = rz.getLastChild();
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
                    if (this.fYV != null) {
                        this.fYV.a(lastChild, iVar, 0);
                    }
                    return false;
                }
            }
            this.fZC.put(Integer.valueOf(i), null);
            rA(i);
            AlaActiveRootView ry = ry(i);
            if (ry == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(ry.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void cb(boolean z) {
                    if (z) {
                        b.this.Hd();
                    }
                }
            });
            g gVar = new g();
            gVar.v(this.mPageContext.getPageActivity()).b(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void cN(int i2) {
                    b.this.fZC.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bpD);
            com.baidu.live.view.web.a[] KV = gVar.KV();
            for (com.baidu.live.view.web.a aVar : KV) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(n);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.fZK || i == 2) {
                layoutParams2.gravity = 5;
            }
            ry.addView(alaActiveWebView, layoutParams2);
            if (this.fYV != null) {
                this.fYV.a(alaActiveWebView, iVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.avf != null) {
            Map<String, Object> bDy = bDy();
            if (i == 2) {
                bDy.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            bDy.put(BigdayActivityConfig.JUMP_URL, aB(str2, i));
            return WebviewHelper.addQueryParams(str, bDy);
        }
        return str;
    }

    private Map<String, Object> bDy() {
        HashMap hashMap = new HashMap();
        if (this.avf != null) {
            if (this.avf.ayV != null) {
                hashMap.put("user_id", Long.valueOf(this.avf.ayV.userId));
            }
            if (this.avf.ayC != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.avf.ayC.userId));
            }
            if (this.avf.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.avf.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.avf.mLiveInfo.live_id));
            }
        }
        hashMap.put("subapp_type", TbConfig.getSubappType());
        hashMap.put("_client_type", "2");
        hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        if (this.isHost) {
            hashMap.put("is_host", 1);
        }
        return hashMap;
    }

    private String aB(String str, int i) {
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
    public void Hd() {
        if (Build.VERSION.SDK_INT >= 19) {
            Hf();
            if (this.fZI == null) {
                this.fZI = new HandlerC0575b(this);
            }
            if (!this.fZI.hasMessages(1000)) {
                this.fZI.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void Hh() {
        if (this.bdA != null) {
            this.bdA.clear();
        }
        if (this.fZI != null) {
            this.fZI.removeMessages(1000);
        }
        Hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.fZA != null) {
            if (this.bdA == null || (size = this.bdA.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.bdA.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.bdA.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.fZA.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bDz()) {
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
                this.fZI.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                Hh();
            }
        }
    }

    private void Hf() {
        if (this.bdA == null) {
            this.bdA = new ArrayList();
        }
        this.bdA.clear();
        this.bdC = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.bdA.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdC);
    }

    private void Hi() {
        if (this.bdC != null) {
            MessageManager.getInstance().unRegisterListener(this.bdC);
            this.bdC = null;
        }
    }

    private void rA(int i) {
        AlaActiveRootView rz = rz(i);
        if (rz != null) {
            rz.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> bDy = bDy();
                bDy.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, bDy);
                if (!TextUtils.isEmpty(this.fZM)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.fZM;
                }
                Dr(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, bDy());
            }
            if (!TextUtils.isEmpty(this.fZM)) {
                str = str + ETAG.ITEM_SEPARATOR + this.fZM;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Dr(String str) {
        int i;
        if (this.fZx == null) {
            this.fZx = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.fZx.setHost(this.isHost);
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.fZx.e(this.avf.mLiveInfo.user_id, this.avf.mLiveInfo.getNameShow(), this.avf.ayC != null ? this.avf.ayC.portrait : null);
            this.fZx.setLiveId(this.avf.mLiveInfo.live_id);
        }
        if (!this.fZK) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.fZx.az(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, i iVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (iVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(iVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (iVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(iVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i iVar, String str, String str2) {
        if (!this.isHost && iVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, iVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.fZy)) {
                jSONArray = new JSONArray(this.fZy);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.fZy = jSONArray.toString();
            com.baidu.live.c.vf().putString("ala_active_view_click_info", this.fZy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rC(int i) {
        if (StringUtils.isNull(this.fZy)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.fZy);
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
        PendantParentView fZO;

        c(PendantParentView pendantParentView) {
            this.fZO = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0575b extends Handler {
        private final WeakReference<b> bdF;

        HandlerC0575b(b bVar) {
            this.bdF = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.bdF.get() != null && message.what == 1000) {
                this.bdF.get().Hg();
            }
        }
    }
}
