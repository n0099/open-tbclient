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
import com.baidu.live.d;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
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
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.live.z.f;
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
    private w aEc;
    private int aJy;
    private long aWC;
    private com.baidu.tieba.ala.liveroom.a.c gOO;
    private HttpMessageListener gOW;
    private HttpMessageListener gOX;
    private CustomMessageListener gOY;
    private CustomMessageListener gOZ;
    private HandlerC0652b gPa;
    private Runnable gPb;
    private List<String> gPc;
    private boolean gPd;
    private boolean gPe;
    private com.baidu.live.g.a gPf;
    private String gPg;
    private TbPageContext mPageContext;
    private String otherParams;
    private String gOP = "";
    private boolean isHost = false;
    private Map<Integer, c> gOQ = new HashMap();
    private Map<Integer, AlaActiveRootView> gOR = new HashMap();
    private SimpleArrayMap<Integer, Integer> gOS = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> gOT = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> gOU = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gOV = new ArrayList<>();
    private h bIl = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void iG(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (b.this.eq(str, "fullscreen")) {
                    b.this.Hu(str);
                } else if (b.this.eq(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                    b.this.Hw(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a gOm = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean vf(int i) {
            return b.this.vf(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof o) {
                b.this.a(view, (o) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aWC >= 400) {
                b.this.aWC = currentTimeMillis;
                if ((obj instanceof o) && b.this.aEc != null && b.this.aEc.aIe != null && b.this.aEc.mLiveInfo != null) {
                    o oVar = (o) obj;
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aEc != null && b.this.aEc.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aEc.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aEc.aIe.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aEc.aIe.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aEc.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aEc.aIe.portrait)) {
                                str2 = URLEncoder.encode(b.this.aEc.aIe.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vf(oVar.aHQ)) {
                        b.this.ve(oVar.aHQ);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).uY(i);
                        } else if ((view instanceof AlaActiveDynamicView) && oVar.aHH && b.this.gOm.vf(oVar.aHQ)) {
                            oVar.aHH = false;
                        }
                    }
                    b.this.aU(oVar.aHV, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aEc.mLiveInfo != null) {
                        str3 = b.this.aEc.mLiveInfo.feed_id;
                        str4 = b.this.aEc.mLiveInfo.live_id + "";
                    }
                    b.this.b(oVar, str3, str4);
                    b.this.a(oVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gOR != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.gOR.get(Integer.valueOf(i2));
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

        boolean vf(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gOS.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gpA);
    }

    public void Ht(String str) {
        this.gPg = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.gPd = z;
        for (int i = 1; i <= 2; i++) {
            vd(i);
        }
        if (this.gOQ != null) {
            this.gOQ.clear();
        }
        j(wVar);
        if (this.aEc != null) {
            this.gOP = d.AZ().getString("ala_active_view_click_info", "");
            bUl();
            bUm();
            bAy();
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && D(aVar)) {
                    Hu(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hu(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.gPe) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bUw();
            bUx();
            this.gOO.Hs(str);
        }
    }

    private boolean D(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> LQ = aVar.LQ();
        return ListUtils.isEmpty(LQ) || LQ.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gOQ.put(Integer.valueOf(i), new c(pendantParentView));
            vb(i);
        }
    }

    private void bUl() {
        if (this.gOW == null) {
            this.gOW = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aEc == null || b.this.aEc.mLiveInfo == null || b.this.aEc.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aEc.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bUn();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.NJ() != null) {
                                b.this.aJy = getLiveActivityHttpResponseMessage.NJ().aJy;
                                b.this.cn(getLiveActivityHttpResponseMessage.NJ().aOg);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gOW);
    }

    private void bUm() {
        if (this.gOZ == null) {
            this.gOZ = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Hw((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gOZ);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.gOR != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.gOR.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.gOR != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.gOR.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bUy()) {
                        bUr();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.gOO != null) {
            this.gOO.resume();
        }
        bAy();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gOR != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gOR.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.gOO != null) {
            this.gOO.pause();
        }
        bUo();
        bUs();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(w wVar) {
        this.aEc = wVar;
    }

    public void setVisible(int i) {
        if (this.gOR != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bK(i2, i);
            }
        }
    }

    public void bK(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.gOS.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bL = bL(i, i2);
        if (this.gOR != null && (alaActiveRootView = this.gOR.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bL);
        }
    }

    private int bL(int i, int i2) {
        if (this.gOT != null && this.gOT.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.gOS != null && this.gOS.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gOS.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Hv(String str) {
        if (f.PF().hS(str)) {
            bAy();
        }
    }

    public void release() {
        this.aEc = null;
        this.gPg = null;
        if (this.gOW != null) {
            MessageManager.getInstance().unRegisterListener(this.gOW);
            this.gOW = null;
        }
        if (this.gOX != null) {
            MessageManager.getInstance().unRegisterListener(this.gOX);
            this.gOX = null;
        }
        if (this.gpA != null) {
            MessageManager.getInstance().unRegisterListener(this.gpA);
            this.gpA = null;
        }
        if (this.gOZ != null) {
            MessageManager.getInstance().unRegisterListener(this.gOZ);
            this.gOZ = null;
        }
        if (this.gPa != null) {
            this.gPa.removeCallbacksAndMessages(null);
        }
        f.PF().release();
        bUs();
        if (this.gOR != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gOR.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bV(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.gOR.clear();
        }
        if (this.gOO != null) {
            this.gOO.release();
            this.gOO = null;
        }
    }

    public void mw(boolean z) {
    }

    public void mx(boolean z) {
    }

    public void updateView() {
        if (this.gOR != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.gOR.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bL(i2, this.gOS.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dI(int i) {
        if (this.gOO != null) {
            this.gOO.dI(i);
        }
    }

    public void my(boolean z) {
        this.gPe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        if (this.aEc != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.z.d.PC().a(this.aEc.aIA.userId, this.aEc.aIe.userId, this.aEc.mLiveInfo.room_id, this.aEc.mLiveInfo.live_id, this.aEc.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        if (this.mRunning) {
            if (this.gPa == null) {
                this.gPa = new HandlerC0652b(this);
            }
            if (this.gPb == null) {
                this.gPb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bAy();
                    }
                };
            }
            bUo();
            if (this.aJy <= 0) {
                this.aJy = 5;
            }
            this.gPa.postDelayed(this.gPb, this.aJy * 1000);
        }
    }

    private void bUo() {
        if (this.gPa != null && this.gPb != null) {
            this.gPa.removeCallbacks(this.gPb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cn(List<o> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (o oVar : list) {
                if (oVar != null) {
                    if (oVar.aHS == 1) {
                        long j = oVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= oVar.showTime && j <= oVar.end_time && oVar.aHX != null && oVar.aHX.pos >= 0 && oVar.aHX.pos <= 2) {
                            if (oVar.aHX.pos == 0) {
                                oVar.aHX.pos = 1;
                            }
                            switch (oVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(oVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aHX.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(oVar.aHX.pos), list2);
                                        }
                                        list2.add(oVar);
                                        if (!z2 || oVar.aHW == null) {
                                            z = z2;
                                        } else {
                                            f.PF().b(oVar.aHW);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(oVar.aHX.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(oVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(oVar.webUrl) && oVar.aHX != null && oVar.aHX.width > 0 && oVar.aHX.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aHX.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(oVar);
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
            f.PF().b(null);
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
    private void k(int i, List<o> list) {
        int i2;
        o oVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bUp();
            vd(i);
            return;
        }
        Iterator<o> it = list.iterator();
        ArrayList<o> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            o next = it.next();
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
        this.gOU.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                vd(i);
                break;
            case 3:
                z = a(i, oVar);
                break;
        }
        c cVar = this.gOQ.get(Integer.valueOf(i));
        if (cVar != null && cVar.gPj != null && z) {
            cVar.gPj.a(this.gOR.get(Integer.valueOf(i)));
        }
        bUq();
    }

    private void bUp() {
        if (this.gPf != null) {
            Iterator<com.baidu.live.g.b> it = this.gOV.iterator();
            while (it.hasNext()) {
                this.gPf.b(it.next());
            }
            this.gOV.clear();
            this.gPf.EE();
        }
    }

    private void bUq() {
        if (this.gPf != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vc = vc(i);
                if (vc != null && vc.getVisibility() == 0 && vc.getChildCount() > 0 && !this.gOV.contains(vc)) {
                    this.gOV.add(vc);
                    this.gPf.a(vc);
                }
            }
            this.gPf.EE();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.gPf = aVar;
    }

    private AlaActiveRootView vb(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.gOR == null || (alaActiveRootView = this.gOR.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.gOQ != null && (cVar = this.gOQ.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gPj;
                if (pendantParentView == null || this.gOR == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gOR.put(Integer.valueOf(i), alaActiveRootView2);
                bV(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bV(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView vc(int i) {
        if (this.gOR != null) {
            return this.gOR.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<o> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            vd(i);
            return false;
        }
        AlaActiveRootView vc = vc(i);
        if (vc != null && vc.getChildCount() == 1) {
            View lastChild = vc.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.gOT.put(Integer.valueOf(i), null);
        vd(i);
        AlaActiveRootView vb = vb(i);
        if (vb == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(vb.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.gOm);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.gPd || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.gPd && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        vb.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, o oVar) {
        String o = o(oVar.webUrl, oVar.jump_url, oVar.aHV);
        if (!TextUtils.isEmpty(o) && oVar.aHX != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, oVar.aHX.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, oVar.aHX.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView vc = vc(i);
            if (vc != null && vc.getChildCount() == 1) {
                View lastChild = vc.getLastChild();
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
                    if (this.gOm != null) {
                        this.gOm.a(lastChild, oVar, 0);
                    }
                    return false;
                }
            }
            this.gOT.put(Integer.valueOf(i), null);
            vd(i);
            AlaActiveRootView vb = vb(i);
            if (vb == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(vb.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void mz(boolean z) {
                    if (z) {
                        b.this.bUr();
                    }
                }
            });
            g gVar = new g();
            gVar.x(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void eX(int i2) {
                    b.this.gOT.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bIl);
            com.baidu.live.view.web.a[] Ux = gVar.Ux();
            for (com.baidu.live.view.web.a aVar : Ux) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(o);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.gPd || i == 2) {
                layoutParams2.gravity = 5;
            }
            vb.addView(alaActiveWebView, layoutParams2);
            if (this.gOm != null) {
                this.gOm.a(alaActiveWebView, oVar, 0);
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
        if (this.aEc == null) {
            return str;
        }
        String valueOf = this.aEc.aIA != null ? String.valueOf(this.aEc.aIA.userId) : null;
        String valueOf2 = this.aEc.aIe != null ? String.valueOf(this.aEc.aIe.userId) : null;
        if (this.aEc.mLiveInfo != null) {
            str3 = String.valueOf(this.aEc.mLiveInfo.room_id);
            str4 = String.valueOf(this.aEc.mLiveInfo.live_id);
        } else {
            str3 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(this.isHost, valueOf, valueOf2, str3, str4);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aG(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aG(String str, int i) {
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
    public boolean eq(String str, String str2) {
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
    public void bUr() {
        if (Build.VERSION.SDK_INT >= 19) {
            bUu();
            if (this.gPa == null) {
                this.gPa = new HandlerC0652b(this);
            }
            if (!this.gPa.hasMessages(1000)) {
                this.gPa.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bUs() {
        if (this.gPc != null) {
            this.gPc.clear();
        }
        if (this.gPa != null) {
            this.gPa.removeMessages(1000);
        }
        bUv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUt() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gOR != null) {
            if (this.gPc == null || (size = this.gPc.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gPc.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gPc.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.gOR.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bUy()) {
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
                this.gPa.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bUs();
            }
        }
    }

    private void bUu() {
        if (this.gPc == null) {
            this.gPc = new ArrayList();
        }
        this.gPc.clear();
        this.gOY = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.gPc.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gOY);
    }

    private void bUv() {
        if (this.gOY != null) {
            MessageManager.getInstance().unRegisterListener(this.gOY);
            this.gOY = null;
        }
    }

    private void vd(int i) {
        AlaActiveRootView vc = vc(i);
        if (vc != null) {
            vc.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aEc != null) {
                String valueOf = this.aEc.aIA != null ? String.valueOf(this.aEc.aIA.userId) : null;
                String valueOf2 = this.aEc.aIe != null ? String.valueOf(this.aEc.aIe.userId) : null;
                if (this.aEc.mLiveInfo != null) {
                    str3 = String.valueOf(this.aEc.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aEc.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.gPg);
            if (i == 2) {
                Hw(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Hw(String str) {
        int i = 2;
        bUw();
        bUx();
        if (!this.gPd) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.gOO.aE(str, i);
    }

    private void bUw() {
        if (this.gOO == null) {
            this.gOO = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bUx() {
        this.gOO.setHost(this.isHost);
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            this.gOO.e(this.aEc.mLiveInfo.user_id, this.aEc.mLiveInfo.getNameShow(), this.aEc.aIe != null ? this.aEc.aIe.portrait : null);
            this.gOO.setLiveId(this.aEc.mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, o oVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, String str, String str2) {
        if (!this.isHost && oVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, oVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gOP)) {
                jSONArray = new JSONArray(this.gOP);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gOP = jSONArray.toString();
            d.AZ().putString("ala_active_view_click_info", this.gOP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vf(int i) {
        if (StringUtils.isNull(this.gOP)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gOP);
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
        PendantParentView gPj;

        c(PendantParentView pendantParentView) {
            this.gPj = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0652b extends Handler {
        private final WeakReference<b> gPi;

        HandlerC0652b(b bVar) {
            this.gPi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gPi.get() != null && message.what == 1000) {
                this.gPi.get().bUt();
            }
        }
    }
}
