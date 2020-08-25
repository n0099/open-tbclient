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
import com.baidu.live.data.r;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
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
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.live.w.d;
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
/* loaded from: classes7.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private r aAh;
    private int aEF;
    private long aPS;
    private HttpMessageListener glE;
    private HttpMessageListener glF;
    private CustomMessageListener glG;
    private CustomMessageListener glH;
    private HandlerC0622b glI;
    private Runnable glJ;
    private List<String> glK;
    private boolean glL;
    private boolean glM;
    private com.baidu.live.g.a glN;
    private String glO;
    private com.baidu.tieba.ala.liveroom.a.c glw;
    private TbPageContext mPageContext;
    private String otherParams;
    private String glx = "";
    private boolean isHost = false;
    private Map<Integer, c> gly = new HashMap();
    private Map<Integer, AlaActiveRootView> glz = new HashMap();
    private SimpleArrayMap<Integer, Integer> glA = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> glB = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> glC = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> glD = new ArrayList<>();
    private h bvt = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void hx(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (b.this.dZ(str, "fullscreen")) {
                    b.this.FM(str);
                } else if (b.this.dZ(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                    b.this.FO(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a gkU = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean tO(int i) {
            return b.this.tO(i);
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
            if (currentTimeMillis - b.this.aPS >= 400) {
                b.this.aPS = currentTimeMillis;
                if ((obj instanceof i) && b.this.aAh != null && b.this.aAh.aDE != null && b.this.aAh.mLiveInfo != null) {
                    i iVar = (i) obj;
                    String str2 = iVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aAh != null && b.this.aAh.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aAh.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aAh.aDE.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aAh.aDE.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aAh.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aAh.aDE.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!tO(iVar.aDq)) {
                        b.this.tN(iVar.aDq);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).tH(i);
                        } else if ((view instanceof AlaActiveDynamicView) && iVar.aDh && b.this.gkU.tO(iVar.aDq)) {
                            iVar.aDh = false;
                        }
                    }
                    b.this.aJ(iVar.aDv, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aAh.mLiveInfo != null) {
                        str3 = b.this.aAh.mLiveInfo.feed_id;
                        str4 = b.this.aAh.mLiveInfo.live_id + "";
                    }
                    b.this.b(iVar, str3, str4);
                    b.this.a(iVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.glz != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.glz.get(Integer.valueOf(i2));
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view, Object obj, int i);

        void b(View view, Object obj, int i);

        boolean tO(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.glA.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.fPP);
    }

    public void FL(String str) {
        this.glO = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(r rVar, boolean z) {
        this.glL = z;
        for (int i = 1; i <= 2; i++) {
            tM(i);
        }
        if (this.gly != null) {
            this.gly.clear();
        }
        j(rVar);
        if (this.aAh != null) {
            this.glx = com.baidu.live.c.AD().getString("ala_active_view_click_info", "");
            bMM();
            bMN();
            buQ();
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
                    FM(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.glM) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bMY();
            bMZ();
            this.glw.FK(str);
        }
    }

    private boolean z(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> JM = aVar.JM();
        return ListUtils.isEmpty(JM) || JM.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gly.put(Integer.valueOf(i), new c(pendantParentView));
            tK(i);
        }
    }

    private void bMM() {
        if (this.glE == null) {
            this.glE = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aAh == null || b.this.aAh.mLiveInfo == null || b.this.aAh.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aAh.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bMO();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.LJ() != null) {
                                b.this.aEF = getLiveActivityHttpResponseMessage.LJ().aEF;
                                b.this.bV(getLiveActivityHttpResponseMessage.LJ().aJe);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.glE);
    }

    private void bMN() {
        if (this.glH == null) {
            this.glH = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.FO((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.glH);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.glz != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.glz.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.glz != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.glz.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bNa()) {
                        bMT();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.glw != null) {
            this.glw.resume();
        }
        buQ();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.glz != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.glz.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.glw != null) {
            this.glw.pause();
        }
        bMP();
        bMU();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(r rVar) {
        this.aAh = rVar;
    }

    public void setVisible(int i) {
        if (this.glz != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bI(i2, i);
            }
        }
    }

    public void bI(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.glA.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bJ = bJ(i, i2);
        if (this.glz != null && (alaActiveRootView = this.glz.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bJ);
        }
    }

    private int bJ(int i, int i2) {
        if (this.glB != null && this.glB.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.glA != null && this.glA.get(Integer.valueOf(i)).intValue() != 0) {
            return this.glA.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void FN(String str) {
        if (d.Nr().hc(str)) {
            buQ();
        }
    }

    public void release() {
        this.aAh = null;
        this.glO = null;
        if (this.glE != null) {
            MessageManager.getInstance().unRegisterListener(this.glE);
            this.glE = null;
        }
        if (this.glF != null) {
            MessageManager.getInstance().unRegisterListener(this.glF);
            this.glF = null;
        }
        if (this.fPP != null) {
            MessageManager.getInstance().unRegisterListener(this.fPP);
            this.fPP = null;
        }
        if (this.glH != null) {
            MessageManager.getInstance().unRegisterListener(this.glH);
            this.glH = null;
        }
        if (this.glI != null) {
            this.glI.removeCallbacksAndMessages(null);
        }
        d.Nr().release();
        bMU();
        if (this.glz != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.glz.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bK(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.glz.clear();
        }
        if (this.glw != null) {
            this.glw.release();
            this.glw = null;
        }
    }

    public void lz(boolean z) {
    }

    public void lA(boolean z) {
    }

    public void updateView() {
        if (this.glz != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.glz.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bJ(i2, this.glA.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dz(int i) {
        if (this.glw != null) {
            this.glw.dz(i);
        }
    }

    public void lB(boolean z) {
        this.glM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        if (this.aAh != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.w.b.No().d(this.aAh.aEd.userId, this.aAh.aDE.userId, this.aAh.mLiveInfo.room_id, this.aAh.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMO() {
        if (this.mRunning) {
            if (this.glI == null) {
                this.glI = new HandlerC0622b(this);
            }
            if (this.glJ == null) {
                this.glJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.buQ();
                    }
                };
            }
            bMP();
            if (this.aEF <= 0) {
                this.aEF = 5;
            }
            this.glI.postDelayed(this.glJ, this.aEF * 1000);
        }
    }

    private void bMP() {
        if (this.glI != null && this.glJ != null) {
            this.glI.removeCallbacks(this.glJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bV(List<i> list) {
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
                    if (iVar.aDs == 1) {
                        long j = iVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= iVar.showTime && j <= iVar.end_time && iVar.aDx != null && iVar.aDx.pos >= 0 && iVar.aDx.pos <= 2) {
                            if (iVar.aDx.pos == 0) {
                                iVar.aDx.pos = 1;
                            }
                            switch (iVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(iVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.aDx.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(iVar.aDx.pos), list2);
                                        }
                                        list2.add(iVar);
                                        if (!z2 || iVar.aDw == null) {
                                            z = z2;
                                        } else {
                                            d.Nr().b(iVar.aDw);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(iVar.aDx.pos));
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
                                    if (!TextUtils.isEmpty(iVar.webUrl) && iVar.aDx != null && iVar.aDx.width > 0 && iVar.aDx.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.aDx.pos));
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
            d.Nr().b(null);
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
            bMQ();
            tM(i);
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
        this.glC.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                tM(i);
                break;
            case 3:
                z = a(i, iVar);
                break;
        }
        c cVar = this.gly.get(Integer.valueOf(i));
        if (cVar != null && cVar.glR != null && z) {
            cVar.glR.a(this.glz.get(Integer.valueOf(i)));
        }
        bMR();
    }

    private void bMQ() {
        if (this.glN != null) {
            Iterator<com.baidu.live.g.b> it = this.glD.iterator();
            while (it.hasNext()) {
                this.glN.b(it.next());
            }
            this.glD.clear();
            this.glN.Df();
        }
    }

    private void bMR() {
        if (this.glN != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView tL = tL(i);
                if (tL != null && tL.getVisibility() == 0 && tL.getChildCount() > 0 && !this.glD.contains(tL)) {
                    this.glD.add(tL);
                    this.glN.a(tL);
                }
            }
            this.glN.Df();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.glN = aVar;
    }

    private AlaActiveRootView tK(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.glz == null || (alaActiveRootView = this.glz.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.gly != null && (cVar = this.gly.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.glR;
                if (pendantParentView == null || this.glz == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.glz.put(Integer.valueOf(i), alaActiveRootView2);
                bK(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bK(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView tL(int i) {
        if (this.glz != null) {
            return this.glz.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<i> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            tM(i);
            return false;
        }
        AlaActiveRootView tL = tL(i);
        if (tL != null && tL.getChildCount() == 1) {
            View lastChild = tL.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.glB.put(Integer.valueOf(i), null);
        tM(i);
        AlaActiveRootView tK = tK(i);
        if (tK == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(tK.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.gkU);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.glL || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.glL && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        tK.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, i iVar) {
        String o = o(iVar.webUrl, iVar.jump_url, iVar.aDv);
        if (!TextUtils.isEmpty(o) && iVar.aDx != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, iVar.aDx.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, iVar.aDx.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView tL = tL(i);
            if (tL != null && tL.getChildCount() == 1) {
                View lastChild = tL.getLastChild();
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
                    if (this.gkU != null) {
                        this.gkU.a(lastChild, iVar, 0);
                    }
                    return false;
                }
            }
            this.glB.put(Integer.valueOf(i), null);
            tM(i);
            AlaActiveRootView tK = tK(i);
            if (tK == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(tK.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void lC(boolean z) {
                    if (z) {
                        b.this.bMT();
                    }
                }
            });
            g gVar = new g();
            gVar.v(this.mPageContext.getPageActivity()).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void fA(int i2) {
                    b.this.glB.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bvt);
            com.baidu.live.view.web.a[] QV = gVar.QV();
            for (com.baidu.live.view.web.a aVar : QV) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(o);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.glL || i == 2) {
                layoutParams2.gravity = 5;
            }
            tK.addView(alaActiveWebView, layoutParams2);
            if (this.gkU != null) {
                this.gkU.a(alaActiveWebView, iVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String o(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aAh != null) {
            Map<String, Object> bMS = bMS();
            if (i == 2) {
                bMS.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            bMS.put(BigdayActivityConfig.JUMP_URL, aE(str2, i));
            return WebviewHelper.addQueryParams(str, bMS);
        }
        return str;
    }

    private Map<String, Object> bMS() {
        HashMap hashMap = new HashMap();
        if (this.aAh != null) {
            if (this.aAh.aEd != null) {
                hashMap.put("user_id", Long.valueOf(this.aAh.aEd.userId));
            }
            if (this.aAh.aDE != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aAh.aDE.userId));
            }
            if (this.aAh.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aAh.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aAh.mLiveInfo.live_id));
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
    public boolean dZ(String str, String str2) {
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
    public void bMT() {
        if (Build.VERSION.SDK_INT >= 19) {
            bMW();
            if (this.glI == null) {
                this.glI = new HandlerC0622b(this);
            }
            if (!this.glI.hasMessages(1000)) {
                this.glI.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bMU() {
        if (this.glK != null) {
            this.glK.clear();
        }
        if (this.glI != null) {
            this.glI.removeMessages(1000);
        }
        bMX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMV() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.glz != null) {
            if (this.glK == null || (size = this.glK.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.glK.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.glK.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.glz.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bNa()) {
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
                this.glI.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bMU();
            }
        }
    }

    private void bMW() {
        if (this.glK == null) {
            this.glK = new ArrayList();
        }
        this.glK.clear();
        this.glG = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.glK.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.glG);
    }

    private void bMX() {
        if (this.glG != null) {
            MessageManager.getInstance().unRegisterListener(this.glG);
            this.glG = null;
        }
    }

    private void tM(int i) {
        AlaActiveRootView tL = tL(i);
        if (tL != null) {
            tL.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> bMS = bMS();
                bMS.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, bMS);
                if (!TextUtils.isEmpty(this.glO)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.glO;
                }
                FO(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, bMS());
            }
            if (!TextUtils.isEmpty(this.glO)) {
                str = str + ETAG.ITEM_SEPARATOR + this.glO;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void FO(String str) {
        int i = 2;
        bMY();
        bMZ();
        if (!this.glL) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.glw.aC(str, i);
    }

    private void bMY() {
        if (this.glw == null) {
            this.glw = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bMZ() {
        this.glw.setHost(this.isHost);
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            this.glw.e(this.aAh.mLiveInfo.user_id, this.aAh.mLiveInfo.getNameShow(), this.aAh.aDE != null ? this.aAh.aDE.portrait : null);
            this.glw.setLiveId(this.aAh.mLiveInfo.live_id);
        }
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
    public void tN(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.glx)) {
                jSONArray = new JSONArray(this.glx);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.glx = jSONArray.toString();
            com.baidu.live.c.AD().putString("ala_active_view_click_info", this.glx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tO(int i) {
        if (StringUtils.isNull(this.glx)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.glx);
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
    /* loaded from: classes7.dex */
    public static class c {
        PendantParentView glR;

        c(PendantParentView pendantParentView) {
            this.glR = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0622b extends Handler {
        private final WeakReference<b> glQ;

        HandlerC0622b(b bVar) {
            this.glQ = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.glQ.get() != null && message.what == 1000) {
                this.glQ.get().bMV();
            }
        }
    }
}
