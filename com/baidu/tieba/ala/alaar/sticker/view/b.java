package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.aa.a;
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
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.aa.a {
    private w aEc;
    private List<FuFaceItem> fWl;
    private AlaStickerDragContentView fXH;
    private AlaStickerDragDeletePanelView fXI;
    private c fXJ;
    private a.InterfaceC0168a fXK;
    private AlaTextStickerEditView fXL;
    private DragTextView fXM;
    private com.baidu.live.g.a fXN;
    private ViewGroup fXO;
    private ViewGroup fXP;
    private ViewGroup fXQ;
    private Map<String, Integer> fXT;
    private FuFaceItem fXU;
    private List<AlaLiveStickerInfo> fXW;
    private Context mContext;
    private int fXR = 0;
    private int fJn = 0;
    private boolean fiZ = true;
    private Handler mHandler = new Handler();
    private boolean fXS = false;
    private boolean fXV = true;
    private c.b fXX = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> fYf = new ArrayList();
        FuFaceItem fYg;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bLr() {
            return b.this.fXV;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.fXU = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.fYf.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.fXS) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fXH != null && b.this.fXH.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bLj()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bLo();
                    b.this.fXM = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aEc.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.fYg = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.fXK != null) {
                    b.this.fXK.K(fuFaceItem.getSticker());
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
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bLs() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fYf.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.fYf.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.fYf.clear();
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("picsticker_id", jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b.this.p("picsticker_suc", jSONObject);
            }
            if (jSONArray2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("textsticker_id", jSONArray2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b.this.p("textsticker_suc", jSONObject2);
            }
            if (this.fYg != null && !TextUtils.isEmpty(this.fYg.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.fYg.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.p("arssticker_suc", jSONObject3);
            }
            this.fYg = null;
        }
    };
    private Runnable feZ = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fiZ = true;
        }
    };
    private e fXY = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fiZ) {
                b.this.fiZ = false;
                b.this.mHandler.postDelayed(b.this.feZ, 600L);
                if (view instanceof DragTextView) {
                    b.this.fXM = (DragTextView) view;
                    if (b.this.fXK != null) {
                        b.this.fXK.PL();
                    }
                    b.this.FW(b.this.fXM.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fXI != null) {
                b.this.fXI.setVisibility(8);
                b.this.fXI.lk(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fXI.getTopDeletePanelBottom()) {
                    if (b.this.fXN != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bLj()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fXH.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fXH.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fXH.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fXH.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aEc.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bLj()) {
                        ((DragTextView) view).bLD();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aEc.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fXI != null) {
                b.this.fXI.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fXI.getTopDeletePanelBottom()) {
                    b.this.fXI.lk(true);
                } else {
                    b.this.fXI.lk(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bLu() {
            int i;
            int i2;
            if (b.this.fXK != null) {
                b.this.fJn = b.this.fXK.PO();
                b.this.fXR = b.this.fXK.PN();
                int PP = b.this.fXK.PP();
                int imMsgListViewHeight = b.this.fXK.getImMsgListViewHeight();
                b.this.fXI.setDeleteBottomHeight(b.this.fJn);
                b.this.fXI.setTopDeletePanelHeight(b.this.fXR);
                b.this.fXI.setImMsgViewSize(PP, imMsgListViewHeight);
                i2 = PP;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fXH != null) {
                int width = b.this.fXO.getWidth();
                int height = b.this.fXO.getHeight() - b.this.fJn;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fXH.bB(width, height);
                for (int i3 = 0; i3 < b.this.fXH.getChildCount(); i3++) {
                    View childAt = b.this.fXH.getChildAt(i3);
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
            if (b.this.fXI != null) {
                b.this.fXI.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bLv() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bLj();
        }
    };
    private HttpMessageListener fXZ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fWl = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fWl;
                if (b.this.fWl != null && !b.this.fWl.isEmpty() && b.this.fXT != null && !b.this.fXT.isEmpty()) {
                    b.this.C(b.this.fXT);
                }
            }
        }
    };
    private HttpMessageListener fYa = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bLi();
                BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.sdk_net_fail_tip));
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
                            a2.bLD();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bLD();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bLi();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fXW == null) {
                                b.this.fXW = new LinkedList();
                            }
                            b.this.fXW.add(alaLiveStickerInfo);
                            b.this.a(b.this.aEc.mLiveInfo.live_id, b.this.fXW);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fWo.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fWo.centerY;
                        alaLiveStickerInfo2.text = dVar2.fWo.text;
                        b.this.a(b.this.aEc.mLiveInfo.live_id, b.this.fXW);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.fXW.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aEc.mLiveInfo.live_id, b.this.fXW);
                        b.this.bN(a3);
                        b.this.bLp();
                        if (b.this.fXN != null) {
                            b.this.fXN.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fXM = null;
        }
    };
    CustomMessageListener fYb = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fXT = hashMap;
                    if (b.this.fWl != null && !b.this.fWl.isEmpty()) {
                        b.this.C(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.PK();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fYc = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fWl != null) {
                    for (int i = 0; i < b.this.fWl.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fWl.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fXV = false;
                    if (b.this.fXK != null) {
                        b.this.fXK.K(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.z.a.Pq().bmJ.aLu;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fYd, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fYd = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bLq();
        }
    };
    CustomMessageListener fYe = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fYd);
                b.this.bLq();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fXZ);
        MessageManager.getInstance().registerListener(this.fYa);
        MessageManager.getInstance().registerListener(this.fYb);
        MessageManager.getInstance().registerListener(this.fYc);
        MessageManager.getInstance().registerListener(this.fYe);
    }

    @Override // com.baidu.live.aa.a
    public void t(ViewGroup viewGroup) {
        this.fXO = viewGroup;
    }

    @Override // com.baidu.live.aa.a
    public void u(ViewGroup viewGroup) {
        this.fXQ = viewGroup;
    }

    @Override // com.baidu.live.aa.a
    public void fe(int i) {
        this.fJn = i;
    }

    @Override // com.baidu.live.aa.a
    public void setStickerCanOperate(boolean z) {
        if (this.fXH != null) {
            this.fXH.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.aa.a
    public void ff(int i) {
        if (this.fXH != null) {
            this.fXH.setVisibility(i);
        }
    }

    @Override // com.baidu.live.aa.a
    public void v(ViewGroup viewGroup) {
        this.fXP = viewGroup;
    }

    @Override // com.baidu.live.aa.a
    public void a(com.baidu.live.g.a aVar) {
        this.fXN = aVar;
    }

    @Override // com.baidu.live.aa.a
    public void PJ() {
        if (this.fXJ == null) {
            this.fXJ = new c(this.mContext, this.fXX);
        } else {
            this.fXJ.bLw();
        }
        this.fXJ.show();
    }

    @Override // com.baidu.live.aa.a
    public void cw(boolean z) {
        this.fXS = z;
    }

    @Override // com.baidu.live.aa.a
    public void setLiveShowInfo(w wVar) {
        this.aEc = wVar;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            this.fXW = dZ(this.aEc.mLiveInfo.live_id);
            if (this.fXW != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fXW) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.aa.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fXL != null) {
                this.fXL.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXL.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fXL.setLayoutParams(layoutParams);
                    this.fXL.setBottom(0);
                }
            }
        } else if (this.fXL != null && this.fXP != null) {
            if (this.fXP.indexOfChild(this.fXL) >= 0) {
                this.fXP.removeView(this.fXL);
            }
            this.fXL.setVisibility(8);
            this.fXM = null;
            if (this.fXK != null) {
                this.fXK.PM();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.aa.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.aa.a
    public void PK() {
        com.baidu.tieba.ala.alaar.sticker.a.g.PK();
    }

    @Override // com.baidu.live.aa.a
    public void a(a.InterfaceC0168a interfaceC0168a) {
        this.fXK = interfaceC0168a;
    }

    @Override // com.baidu.live.aa.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fXL != null) {
            this.fXL.unRegisterListener();
            this.fXL = null;
        }
        if (this.fXJ != null) {
            this.fXJ.unRegisterListener();
            this.fXJ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fXZ);
        MessageManager.getInstance().unRegisterListener(this.fYa);
        MessageManager.getInstance().unRegisterListener(this.fYb);
        MessageManager.getInstance().unRegisterListener(this.fYc);
        MessageManager.getInstance().unRegisterListener(this.fYe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW(String str) {
        if (this.fXL == null) {
            this.fXL = new AlaTextStickerEditView(this.mContext);
            this.fXL.setLiveShowInfo(this.aEc);
            this.fXL.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void FX(String str2) {
                    if (str2 != null && b.this.fXM != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bLj()) {
                        b.this.fXM.setText(str2);
                        long j = b.this.aEc.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fXM.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bLt() {
                }
            });
        }
        if (this.fXP != null) {
            if (this.fXP.indexOfChild(this.fXL) >= 0) {
                this.fXP.removeView(this.fXL);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fXL.setVisibility(0);
            this.fXP.addView(this.fXL, layoutParams);
            this.fXL.FZ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLo() {
        if (this.fXH == null) {
            this.fXH = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fXI == null) {
            this.fXI = new AlaStickerDragDeletePanelView(this.mContext);
            this.fXI.setVisibility(8);
        }
        if (this.fXH.getParent() == null) {
            this.fXH.bB(this.fXO.getWidth(), this.fXO.getHeight() - this.fJn);
            this.fXO.addView(this.fXH, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fXI.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fXK != null) {
                this.fXI.setDeleteBottomHeight(this.fXK.PO());
                this.fXI.setTopDeletePanelHeight(this.fXK.PN());
            }
            this.fXQ.addView(this.fXI, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLp() {
        if (this.fXH.getChildCount() == 0) {
            if (this.fXH != null) {
                ((ViewGroup) this.fXH.getParent()).removeView(this.fXH);
            }
            if (this.fXI != null) {
                ((ViewGroup) this.fXI.getParent()).removeView(this.fXI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fXH != null) {
            return this.fXH.a(i, bitmap, i2, this.fXY, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fXH != null) {
            this.fXH.b(i, bitmap, i2, this.fXY, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(View view) {
        if (this.fXH != null) {
            this.fXH.bO(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.fWl != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fWl.size()) {
                    break;
                }
                hashMap.put(this.fWl.get(i2).id, this.fWl.get(i2));
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
                        if (b.this.fXT != null) {
                            b.this.fXT.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bKT().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.h.a(fuFaceItem, new h.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: b */
                    public void aD(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: c */
                    public void aE(FuFaceItem fuFaceItem2) {
                        if (b.this.fXT != null) {
                            b.this.fXT.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fXT != null && b.this.fXT.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fXT.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fXT.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fXT.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bLq() {
        FuFaceItem fuFaceItem;
        if (!this.fXV) {
            if (this.fXU != null) {
                fuFaceItem = this.fXU;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fWl.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fWl.get(i2);
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
            this.fXV = true;
            this.fXX.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fXH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fXH.getChildCount()) {
                    break;
                }
                View childAt = this.fXH.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fWo || alaLiveStickerInfo.id == dVar.fWo.id) {
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
            com.baidu.live.d.AZ().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.d.AZ().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> dZ(long j) {
        String string = com.baidu.live.d.AZ().getString("sp_ala_live_master_sticker_info", "");
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
                        int i2 = a.d.sdk_cp_cont_q;
                        b.this.bLo();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
