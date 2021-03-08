package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.af.a;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.SetPicTxtStickerHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
import com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.af.a {
    private ab aED;
    private List<FuFaceItem> guv;
    private AlaStickerDragContentView gvO;
    private AlaStickerDragDeletePanelView gvP;
    private c gvQ;
    private a.InterfaceC0162a gvR;
    private AlaTextStickerEditView gvS;
    private DragTextView gvT;
    private com.baidu.live.i.a gvU;
    private ViewGroup gvV;
    private ViewGroup gvW;
    private ViewGroup gvX;
    private Map<String, Integer> gwa;
    private FuFaceItem gwb;
    private List<AlaLiveStickerInfo> gwd;
    private Context mContext;
    private int gvY = 0;
    private int gfu = 0;
    private boolean fEo = true;
    private Handler mHandler = new Handler();
    private boolean gvZ = false;
    private boolean gwc = true;
    private c.b gwe = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> gwm = new ArrayList();
        FuFaceItem gwn;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bQt() {
            return b.this.gwc;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gwb = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.gwm.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.gvZ) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.gvO != null && b.this.gvO.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bQm()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bQq();
                    b.this.gvT = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aED.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.gwn = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.gvR != null) {
                    b.this.gvR.H(fuFaceItem.getSticker());
                }
            }
            a(fuFaceItem, str2, str3);
        }

        private void a(FuFaceItem fuFaceItem, String str, String str2) {
            if (fuFaceItem != null && !TextUtils.isEmpty(fuFaceItem.getId())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
                    jSONObject.put(str2, fuFaceItem.getId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", str).setContentExt(jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bQu() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gwm.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.gwm.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.gwm.clear();
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("picsticker_id", jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b.this.r("picsticker_suc", jSONObject);
            }
            if (jSONArray2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("textsticker_id", jSONArray2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b.this.r("textsticker_suc", jSONObject2);
            }
            if (this.gwn != null && !TextUtils.isEmpty(this.gwn.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.gwn.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.r("arssticker_suc", jSONObject3);
            }
            this.gwn = null;
        }
    };
    private Runnable fAm = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fEo = true;
        }
    };
    private e gwf = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fEo) {
                b.this.fEo = false;
                b.this.mHandler.postDelayed(b.this.fAm, 600L);
                if (view instanceof DragTextView) {
                    b.this.gvT = (DragTextView) view;
                    if (b.this.gvR != null) {
                        b.this.gvR.QJ();
                    }
                    b.this.FU(b.this.gvT.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void g(View view, int i, int i2, int i3, int i4) {
            if (b.this.gvP != null) {
                b.this.gvP.setVisibility(8);
                b.this.gvP.mm(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gvP.getTopDeletePanelBottom()) {
                    if (b.this.gvU != null) {
                        Log.d("bugbye", "bugbye");
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bQm()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.gvO.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.gvO.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.gvO.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.gvO.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aED.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bQm()) {
                        ((DragTextView) view).bQF();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aED.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void C(int i, int i2, int i3, int i4) {
            if (b.this.gvP != null) {
                b.this.gvP.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gvP.getTopDeletePanelBottom()) {
                    b.this.gvP.mm(true);
                } else {
                    b.this.gvP.mm(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bQw() {
            int i;
            int i2;
            if (b.this.gvR != null) {
                b.this.gfu = b.this.gvR.QM();
                b.this.gvY = b.this.gvR.QL();
                i2 = b.this.gvR.QN();
                int imMsgListViewHeight = b.this.gvR.getImMsgListViewHeight();
                b.this.gvP.setDeleteBottomHeight(b.this.gfu);
                b.this.gvP.setTopDeletePanelHeight(b.this.gvY);
                b.this.gvP.setImMsgViewSize(i2, imMsgListViewHeight);
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.gvO != null) {
                int width = b.this.gvV.getWidth();
                int height = b.this.gvV.getHeight() - b.this.gfu;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.gvO.bz(width, height);
                for (int i3 = 0; i3 < b.this.gvO.getChildCount(); i3++) {
                    View childAt = b.this.gvO.getChildAt(i3);
                    if (childAt instanceof DragTextView) {
                        DragTextView dragTextView = (DragTextView) childAt;
                        dragTextView.setParentBorder(0, 0, width, height);
                        dragTextView.setImRightViewSize(equipmentWidth, i);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onLongPress() {
            if (b.this.gvP != null) {
                b.this.gvP.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bQx() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bQm();
        }
    };
    private HttpMessageListener gwg = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.guv = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).guv;
                if (b.this.guv != null && !b.this.guv.isEmpty() && b.this.gwa != null && !b.this.gwa.isEmpty()) {
                    b.this.F(b.this.gwa);
                }
            }
        }
    };
    private HttpMessageListener gwh = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bQl();
                BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.sdk_net_fail_tip));
                if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) && (dVar = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage()) != null) {
                    DragTextView a2 = b.this.a(dVar);
                    if (dVar.mRequestType == 1) {
                        if (a2 != null && a2.getParent() != null) {
                            ((ViewGroup) a2.getParent()).removeView(a2);
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 2) {
                        if (a2 != null) {
                            a2.bQF();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bQF();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bQl();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.gwd == null) {
                                b.this.gwd = new LinkedList();
                            }
                            b.this.gwd.add(alaLiveStickerInfo);
                            b.this.a(b.this.aED.mLiveInfo.live_id, b.this.gwd);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.guy.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.guy.centerY;
                        alaLiveStickerInfo2.text = dVar2.guy.text;
                        b.this.a(b.this.aED.mLiveInfo.live_id, b.this.gwd);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.gwd.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aED.mLiveInfo.live_id, b.this.gwd);
                        b.this.cg(a3);
                        b.this.bQr();
                        if (b.this.gvU != null) {
                            b.this.gvU.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.gvT = null;
        }
    };
    CustomMessageListener gwi = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                try {
                    HashMap hashMap = new HashMap();
                    Iterator it = ((List) customResponsedMessage.getData()).iterator();
                    while (it.hasNext()) {
                        hashMap.put(((Long) it.next()) + "", 0);
                    }
                    b.this.gwa = hashMap;
                    if (b.this.guv != null && !b.this.guv.isEmpty()) {
                        b.this.F(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.QI();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener gwj = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.guv != null) {
                    for (int i = 0; i < b.this.guv.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.guv.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.gwc = false;
                    if (b.this.gvR != null) {
                        b.this.gvR.H(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.ae.a.Qm().bwx.aNF;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.gwk, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable gwk = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQs();
        }
    };
    CustomMessageListener gwl = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.gwk);
                b.this.bQs();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gwg);
        MessageManager.getInstance().registerListener(this.gwh);
        MessageManager.getInstance().registerListener(this.gwi);
        MessageManager.getInstance().registerListener(this.gwj);
        MessageManager.getInstance().registerListener(this.gwl);
    }

    @Override // com.baidu.live.af.a
    public void r(ViewGroup viewGroup) {
        this.gvV = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void s(ViewGroup viewGroup) {
        this.gvX = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void dY(int i) {
        this.gfu = i;
    }

    @Override // com.baidu.live.af.a
    public void setStickerCanOperate(boolean z) {
        if (this.gvO != null) {
            this.gvO.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.af.a
    public void dZ(int i) {
        if (this.gvO != null) {
            this.gvO.setVisibility(i);
        }
    }

    @Override // com.baidu.live.af.a
    public void t(ViewGroup viewGroup) {
        this.gvW = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.i.a aVar) {
        this.gvU = aVar;
    }

    @Override // com.baidu.live.af.a
    public void QH() {
        if (this.gvQ == null) {
            this.gvQ = new c(this.mContext, this.gwe);
        } else {
            this.gvQ.bQy();
        }
        this.gvQ.show();
    }

    @Override // com.baidu.live.af.a
    public void cV(boolean z) {
        this.gvZ = z;
    }

    @Override // com.baidu.live.af.a
    public void setLiveShowInfo(ab abVar) {
        this.aED = abVar;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            this.gwd = fe(this.aED.mLiveInfo.live_id);
            if (this.gwd != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.gwd) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.af.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.gvS != null) {
                this.gvS.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gvS.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gvS.setLayoutParams(layoutParams);
                    this.gvS.setBottom(0);
                }
            }
        } else if (this.gvS != null && this.gvW != null) {
            if (this.gvW.indexOfChild(this.gvS) >= 0) {
                this.gvW.removeView(this.gvS);
            }
            this.gvS.setVisibility(8);
            this.gvT = null;
            if (this.gvR != null) {
                this.gvR.QK();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.af.a
    public void QI() {
        com.baidu.tieba.ala.alaar.sticker.a.g.QI();
    }

    @Override // com.baidu.live.af.a
    public void a(a.InterfaceC0162a interfaceC0162a) {
        this.gvR = interfaceC0162a;
    }

    @Override // com.baidu.live.af.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gvS != null) {
            this.gvS.unRegisterListener();
            this.gvS = null;
        }
        if (this.gvQ != null) {
            this.gvQ.unRegisterListener();
            this.gvQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gwg);
        MessageManager.getInstance().unRegisterListener(this.gwh);
        MessageManager.getInstance().unRegisterListener(this.gwi);
        MessageManager.getInstance().unRegisterListener(this.gwj);
        MessageManager.getInstance().unRegisterListener(this.gwl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU(String str) {
        if (this.gvS == null) {
            this.gvS = new AlaTextStickerEditView(this.mContext);
            this.gvS.setLiveShowInfo(this.aED);
            this.gvS.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void FV(String str2) {
                    if (str2 != null && b.this.gvT != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bQm()) {
                        b.this.gvT.setText(str2);
                        long j = b.this.aED.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.gvT.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bQv() {
                }
            });
        }
        if (this.gvW != null) {
            if (this.gvW.indexOfChild(this.gvS) >= 0) {
                this.gvW.removeView(this.gvS);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.gvS.setVisibility(0);
            this.gvW.addView(this.gvS, layoutParams);
            this.gvS.FX(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQq() {
        if (this.gvO == null) {
            this.gvO = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gvP == null) {
            this.gvP = new AlaStickerDragDeletePanelView(this.mContext);
            this.gvP.setVisibility(8);
        }
        if (this.gvO.getParent() == null) {
            this.gvO.bz(this.gvV.getWidth(), this.gvV.getHeight() - this.gfu);
            this.gvV.addView(this.gvO, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gvP.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.gvR != null) {
                this.gvP.setDeleteBottomHeight(this.gvR.QM());
                this.gvP.setTopDeletePanelHeight(this.gvR.QL());
            }
            this.gvX.addView(this.gvP, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQr() {
        if (this.gvO.getChildCount() == 0) {
            if (this.gvO != null) {
                ((ViewGroup) this.gvO.getParent()).removeView(this.gvO);
            }
            if (this.gvP != null) {
                ((ViewGroup) this.gvP.getParent()).removeView(this.gvP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gvO != null) {
            return this.gvO.a(i, bitmap, i2, this.gwf, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gvO != null) {
            this.gvO.b(i, bitmap, i2, this.gwf, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
        if (this.gvO != null) {
            this.gvO.ch(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Map<String, Integer> map) {
        if (this.guv != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.guv.size()) {
                    break;
                }
                hashMap.put(this.guv.get(i2).id, this.guv.get(i2));
                i = i2 + 1;
            }
            for (String str : map.keySet()) {
                if (hashMap.containsKey(str)) {
                    a((FuFaceItem) hashMap.get(str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final FuFaceItem fuFaceItem) {
        if (fuFaceItem != null && !TextUtils.isEmpty(fuFaceItem.file) && BdNetTypeUtil.isNetWorkAvailable()) {
            if (fuFaceItem.isResLoaded()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gwa != null) {
                            b.this.gwa.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bPW().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.h.a(fuFaceItem, new h.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: b */
                    public void L(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: c */
                    public void aH(FuFaceItem fuFaceItem2) {
                        if (b.this.gwa != null) {
                            b.this.gwa.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.gwa != null && b.this.gwa.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.gwa.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.gwa.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.gwa.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
                            b.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.a(fuFaceItem2);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQs() {
        FuFaceItem fuFaceItem;
        if (!this.gwc) {
            if (this.gwb != null) {
                fuFaceItem = this.gwb;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.guv.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.guv.get(i2);
                    if (fuFaceItem.isCancelItem) {
                        break;
                    }
                    i = i2 + 1;
                }
            }
            if (fuFaceItem == null) {
                fuFaceItem = new FuFaceItem();
                fuFaceItem.isCancelItem = true;
                fuFaceItem.getSticker().setId("cancelItem");
            }
            this.gwc = true;
            this.gwe.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.gvO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gvO.getChildCount()) {
                    break;
                }
                View childAt = this.gvO.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.guy || alaLiveStickerInfo.id == dVar.guy.id) {
                        return dragTextView;
                    }
                }
                i = i2 + 1;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<AlaLiveStickerInfo> list) {
        if (list == null || list.size() == 0) {
            com.baidu.live.d.xf().putString("sp_ala_live_master_sticker_info", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (AlaLiveStickerInfo alaLiveStickerInfo : list) {
            JSONObject createJson = AlaLiveStickerInfo.createJson(alaLiveStickerInfo);
            if (createJson != null) {
                jSONArray.put(createJson);
            }
        }
        try {
            jSONObject.put(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            jSONObject.put("stickers", jSONArray);
        } catch (JSONException e) {
        }
        com.baidu.live.d.xf().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> fe(long j) {
        String string = com.baidu.live.d.xf().getString("sp_ala_live_master_sticker_info", "");
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.optLong(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID) == j) {
                    JSONArray jSONArray = jSONObject.getJSONArray("stickers");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        AlaLiveStickerInfo parse = AlaLiveStickerInfo.parse(jSONArray.getJSONObject(i));
                        if (parse != null) {
                            linkedList.add(parse);
                        }
                    }
                    return linkedList;
                }
                return null;
            } catch (JSONException e) {
                return linkedList;
            }
        }
        return linkedList;
    }

    public void a(final AlaLiveStickerInfo alaLiveStickerInfo) {
        if (alaLiveStickerInfo != null && !TextUtils.isEmpty(alaLiveStickerInfo.link)) {
            final String str = alaLiveStickerInfo.link;
            BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str2, int i) {
                    super.onLoaded((AnonymousClass13) bdImage, str2, i);
                    if (bdImage != null && bdImage.getRawBitmap() != null && str2 != null && str2.equals(str)) {
                        alaLiveStickerInfo.bitmap = bdImage.getRawBitmap();
                        int i2 = a.c.sdk_cp_cont_q;
                        b.this.bQq();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
