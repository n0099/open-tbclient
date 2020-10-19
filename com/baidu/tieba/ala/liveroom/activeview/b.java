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
    private u aDU;
    private int aIW;
    private long aVh;
    private com.baidu.tieba.ala.liveroom.a.c gDa;
    private HttpMessageListener gDi;
    private HttpMessageListener gDj;
    private CustomMessageListener gDk;
    private CustomMessageListener gDl;
    private HandlerC0636b gDm;
    private Runnable gDn;
    private List<String> gDo;
    private boolean gDp;
    private boolean gDq;
    private com.baidu.live.g.a gDr;
    private String gDs;
    private TbPageContext mPageContext;
    private String otherParams;
    private String gDb = "";
    private boolean isHost = false;
    private Map<Integer, c> gDc = new HashMap();
    private Map<Integer, AlaActiveRootView> gDd = new HashMap();
    private SimpleArrayMap<Integer, Integer> gDe = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> gDf = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> gDg = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gDh = new ArrayList<>();
    private h bFm = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void iv(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (b.this.ej(str, "fullscreen")) {
                    b.this.GW(str);
                } else if (b.this.ej(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                    b.this.GY(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a gCy = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean uM(int i) {
            return b.this.uM(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof l) {
                b.this.a(view, (l) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aVh >= 400) {
                b.this.aVh = currentTimeMillis;
                if ((obj instanceof l) && b.this.aDU != null && b.this.aDU.aHD != null && b.this.aDU.mLiveInfo != null) {
                    l lVar = (l) obj;
                    String str = lVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDU != null && b.this.aDU.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDU.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDU.aHD.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDU.aHD.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDU.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aDU.aHD.portrait)) {
                                str2 = URLEncoder.encode(b.this.aDU.aHD.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!uM(lVar.aHp)) {
                        b.this.uL(lVar.aHp);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).uF(i);
                        } else if ((view instanceof AlaActiveDynamicView) && lVar.aHg && b.this.gCy.uM(lVar.aHp)) {
                            lVar.aHg = false;
                        }
                    }
                    b.this.aT(lVar.aHu, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDU.mLiveInfo != null) {
                        str3 = b.this.aDU.mLiveInfo.feed_id;
                        str4 = b.this.aDU.mLiveInfo.live_id + "";
                    }
                    b.this.b(lVar, str3, str4);
                    b.this.a(lVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gDd != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.gDd.get(Integer.valueOf(i2));
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

        boolean uM(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gDe.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gfx);
    }

    public void GV(String str) {
        this.gDs = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(u uVar, boolean z) {
        this.gDp = z;
        for (int i = 1; i <= 2; i++) {
            uK(i);
        }
        if (this.gDc != null) {
            this.gDc.clear();
        }
        k(uVar);
        if (this.aDU != null) {
            this.gDb = com.baidu.live.c.AZ().getString("ala_active_view_click_info", "");
            bRo();
            bRp();
            byF();
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
                    GW(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.gDq) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bRz();
            bRA();
            this.gDa.GU(str);
        }
    }

    private boolean z(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Lv = aVar.Lv();
        return ListUtils.isEmpty(Lv) || Lv.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gDc.put(Integer.valueOf(i), new c(pendantParentView));
            uI(i);
        }
    }

    private void bRo() {
        if (this.gDi == null) {
            this.gDi = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aDU == null || b.this.aDU.mLiveInfo == null || b.this.aDU.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDU.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bRq();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Np() != null) {
                                b.this.aIW = getLiveActivityHttpResponseMessage.Np().aIW;
                                b.this.cd(getLiveActivityHttpResponseMessage.Np().aNB);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gDi);
    }

    private void bRp() {
        if (this.gDl == null) {
            this.gDl = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.GY((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gDl);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.gDd != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.gDd.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.gDd != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.gDd.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bRB()) {
                        bRu();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.gDa != null) {
            this.gDa.resume();
        }
        byF();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gDd != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gDd.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.gDa != null) {
            this.gDa.pause();
        }
        bRr();
        bRv();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void k(u uVar) {
        this.aDU = uVar;
    }

    public void setVisible(int i) {
        if (this.gDd != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bI(i2, i);
            }
        }
    }

    public void bI(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.gDe.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bJ = bJ(i, i2);
        if (this.gDd != null && (alaActiveRootView = this.gDd.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bJ);
        }
    }

    private int bJ(int i, int i2) {
        if (this.gDf != null && this.gDf.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.gDe != null && this.gDe.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gDe.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void GX(String str) {
        if (d.OZ().hK(str)) {
            byF();
        }
    }

    public void release() {
        this.aDU = null;
        this.gDs = null;
        if (this.gDi != null) {
            MessageManager.getInstance().unRegisterListener(this.gDi);
            this.gDi = null;
        }
        if (this.gDj != null) {
            MessageManager.getInstance().unRegisterListener(this.gDj);
            this.gDj = null;
        }
        if (this.gfx != null) {
            MessageManager.getInstance().unRegisterListener(this.gfx);
            this.gfx = null;
        }
        if (this.gDl != null) {
            MessageManager.getInstance().unRegisterListener(this.gDl);
            this.gDl = null;
        }
        if (this.gDm != null) {
            this.gDm.removeCallbacksAndMessages(null);
        }
        d.OZ().release();
        bRv();
        if (this.gDd != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gDd.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bS(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.gDd.clear();
        }
        if (this.gDa != null) {
            this.gDa.release();
            this.gDa = null;
        }
    }

    public void mf(boolean z) {
    }

    public void mg(boolean z) {
    }

    public void updateView() {
        if (this.gDd != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.gDd.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bJ(i2, this.gDe.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dI(int i) {
        if (this.gDa != null) {
            this.gDa.dI(i);
        }
    }

    public void mh(boolean z) {
        this.gDq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        if (this.aDU != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.x.b.OW().a(this.aDU.aIf.userId, this.aDU.aHD.userId, this.aDU.mLiveInfo.room_id, this.aDU.mLiveInfo.live_id, this.aDU.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (this.mRunning) {
            if (this.gDm == null) {
                this.gDm = new HandlerC0636b(this);
            }
            if (this.gDn == null) {
                this.gDn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.byF();
                    }
                };
            }
            bRr();
            if (this.aIW <= 0) {
                this.aIW = 5;
            }
            this.gDm.postDelayed(this.gDn, this.aIW * 1000);
        }
    }

    private void bRr() {
        if (this.gDm != null && this.gDn != null) {
            this.gDm.removeCallbacks(this.gDn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cd(List<l> list) {
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
                    if (lVar.aHr == 1) {
                        long j = lVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= lVar.showTime && j <= lVar.end_time && lVar.aHw != null && lVar.aHw.pos >= 0 && lVar.aHw.pos <= 2) {
                            if (lVar.aHw.pos == 0) {
                                lVar.aHw.pos = 1;
                            }
                            switch (lVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(lVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(lVar.aHw.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(lVar.aHw.pos), list2);
                                        }
                                        list2.add(lVar);
                                        if (!z2 || lVar.aHv == null) {
                                            z = z2;
                                        } else {
                                            d.OZ().b(lVar.aHv);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(lVar.aHw.pos));
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
                                    if (!TextUtils.isEmpty(lVar.webUrl) && lVar.aHw != null && lVar.aHw.width > 0 && lVar.aHw.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(lVar.aHw.pos));
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
            d.OZ().b(null);
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
            bRs();
            uK(i);
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
        this.gDg.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                uK(i);
                break;
            case 3:
                z = a(i, lVar);
                break;
        }
        c cVar = this.gDc.get(Integer.valueOf(i));
        if (cVar != null && cVar.gDv != null && z) {
            cVar.gDv.a(this.gDd.get(Integer.valueOf(i)));
        }
        bRt();
    }

    private void bRs() {
        if (this.gDr != null) {
            Iterator<com.baidu.live.g.b> it = this.gDh.iterator();
            while (it.hasNext()) {
                this.gDr.b(it.next());
            }
            this.gDh.clear();
            this.gDr.Es();
        }
    }

    private void bRt() {
        if (this.gDr != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView uJ = uJ(i);
                if (uJ != null && uJ.getVisibility() == 0 && uJ.getChildCount() > 0 && !this.gDh.contains(uJ)) {
                    this.gDh.add(uJ);
                    this.gDr.a(uJ);
                }
            }
            this.gDr.Es();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.gDr = aVar;
    }

    private AlaActiveRootView uI(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.gDd == null || (alaActiveRootView = this.gDd.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.gDc != null && (cVar = this.gDc.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gDv;
                if (pendantParentView == null || this.gDd == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gDd.put(Integer.valueOf(i), alaActiveRootView2);
                bS(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bS(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView uJ(int i) {
        if (this.gDd != null) {
            return this.gDd.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<l> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            uK(i);
            return false;
        }
        AlaActiveRootView uJ = uJ(i);
        if (uJ != null && uJ.getChildCount() == 1) {
            View lastChild = uJ.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.gDf.put(Integer.valueOf(i), null);
        uK(i);
        AlaActiveRootView uI = uI(i);
        if (uI == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(uI.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.gCy);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.gDp || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.gDp && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        uI.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, l lVar) {
        String o = o(lVar.webUrl, lVar.jump_url, lVar.aHu);
        if (!TextUtils.isEmpty(o) && lVar.aHw != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, lVar.aHw.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, lVar.aHw.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView uJ = uJ(i);
            if (uJ != null && uJ.getChildCount() == 1) {
                View lastChild = uJ.getLastChild();
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
                    if (this.gCy != null) {
                        this.gCy.a(lastChild, lVar, 0);
                    }
                    return false;
                }
            }
            this.gDf.put(Integer.valueOf(i), null);
            uK(i);
            AlaActiveRootView uI = uI(i);
            if (uI == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(uI.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void mi(boolean z) {
                    if (z) {
                        b.this.bRu();
                    }
                }
            });
            g gVar = new g();
            gVar.x(this.mPageContext.getPageActivity()).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void eU(int i2) {
                    b.this.gDf.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bFm);
            com.baidu.live.view.web.a[] Tx = gVar.Tx();
            for (com.baidu.live.view.web.a aVar : Tx) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(o);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.gDp || i == 2) {
                layoutParams2.gravity = 5;
            }
            uI.addView(alaActiveWebView, layoutParams2);
            if (this.gCy != null) {
                this.gCy.a(alaActiveWebView, lVar, 0);
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
        if (this.aDU == null) {
            return str;
        }
        String valueOf = this.aDU.aIf != null ? String.valueOf(this.aDU.aIf.userId) : null;
        String valueOf2 = this.aDU.aHD != null ? String.valueOf(this.aDU.aHD.userId) : null;
        if (this.aDU.mLiveInfo != null) {
            str3 = String.valueOf(this.aDU.mLiveInfo.room_id);
            str4 = String.valueOf(this.aDU.mLiveInfo.live_id);
        } else {
            str3 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(this.isHost, valueOf, valueOf2, str3, str4);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aF(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aF(String str, int i) {
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
    public boolean ej(String str, String str2) {
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
    public void bRu() {
        if (Build.VERSION.SDK_INT >= 19) {
            bRx();
            if (this.gDm == null) {
                this.gDm = new HandlerC0636b(this);
            }
            if (!this.gDm.hasMessages(1000)) {
                this.gDm.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bRv() {
        if (this.gDo != null) {
            this.gDo.clear();
        }
        if (this.gDm != null) {
            this.gDm.removeMessages(1000);
        }
        bRy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRw() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gDd != null) {
            if (this.gDo == null || (size = this.gDo.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gDo.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gDo.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.gDd.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bRB()) {
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
                this.gDm.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bRv();
            }
        }
    }

    private void bRx() {
        if (this.gDo == null) {
            this.gDo = new ArrayList();
        }
        this.gDo.clear();
        this.gDk = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.gDo.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gDk);
    }

    private void bRy() {
        if (this.gDk != null) {
            MessageManager.getInstance().unRegisterListener(this.gDk);
            this.gDk = null;
        }
    }

    private void uK(int i) {
        AlaActiveRootView uJ = uJ(i);
        if (uJ != null) {
            uJ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aDU != null) {
                String valueOf = this.aDU.aIf != null ? String.valueOf(this.aDU.aIf.userId) : null;
                String valueOf2 = this.aDU.aHD != null ? String.valueOf(this.aDU.aHD.userId) : null;
                if (this.aDU.mLiveInfo != null) {
                    str3 = String.valueOf(this.aDU.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aDU.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.gDs);
            if (i == 2) {
                GY(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void GY(String str) {
        int i = 2;
        bRz();
        bRA();
        if (!this.gDp) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.gDa.aD(str, i);
    }

    private void bRz() {
        if (this.gDa == null) {
            this.gDa = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bRA() {
        this.gDa.setHost(this.isHost);
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            this.gDa.e(this.aDU.mLiveInfo.user_id, this.aDU.mLiveInfo.getNameShow(), this.aDU.aHD != null ? this.aDU.aHD.portrait : null);
            this.gDa.setLiveId(this.aDU.mLiveInfo.live_id);
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
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
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
    public void uL(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gDb)) {
                jSONArray = new JSONArray(this.gDb);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gDb = jSONArray.toString();
            com.baidu.live.c.AZ().putString("ala_active_view_click_info", this.gDb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uM(int i) {
        if (StringUtils.isNull(this.gDb)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gDb);
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
        PendantParentView gDv;

        c(PendantParentView pendantParentView) {
            this.gDv = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0636b extends Handler {
        private final WeakReference<b> gDu;

        HandlerC0636b(b bVar) {
            this.gDu = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gDu.get() != null && message.what == 1000) {
                this.gDu.get().bRw();
            }
        }
    }
}
