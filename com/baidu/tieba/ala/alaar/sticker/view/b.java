package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.ab.a;
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
public class b implements com.baidu.live.ab.a {
    private w aES;
    private List<FuFaceItem> gcc;
    private c gdA;
    private a.InterfaceC0168a gdB;
    private AlaTextStickerEditView gdC;
    private DragTextView gdD;
    private com.baidu.live.g.a gdE;
    private ViewGroup gdF;
    private ViewGroup gdG;
    private ViewGroup gdH;
    private Map<String, Integer> gdK;
    private FuFaceItem gdL;
    private List<AlaLiveStickerInfo> gdN;
    private AlaStickerDragContentView gdy;
    private AlaStickerDragDeletePanelView gdz;
    private Context mContext;
    private int gdI = 0;
    private int fPd = 0;
    private boolean foQ = true;
    private Handler mHandler = new Handler();
    private boolean gdJ = false;
    private boolean gdM = true;
    private c.b gdO = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> gdW = new ArrayList();
        FuFaceItem gdX;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bNQ() {
            return b.this.gdM;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gdL = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.gdW.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.gdJ) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.gdy != null && b.this.gdy.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bNI()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bNN();
                    b.this.gdD = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aES.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.gdX = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.gdB != null) {
                    b.this.gdB.J(fuFaceItem.getSticker());
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
        public void bNR() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gdW.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.gdW.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.gdW.clear();
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
            if (this.gdX != null && !TextUtils.isEmpty(this.gdX.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.gdX.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.r("arssticker_suc", jSONObject3);
            }
            this.gdX = null;
        }
    };
    private Runnable fkS = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.foQ = true;
        }
    };
    private e gdP = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.foQ) {
                b.this.foQ = false;
                b.this.mHandler.postDelayed(b.this.fkS, 600L);
                if (view instanceof DragTextView) {
                    b.this.gdD = (DragTextView) view;
                    if (b.this.gdB != null) {
                        b.this.gdB.Ql();
                    }
                    b.this.Gk(b.this.gdD.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.gdz != null) {
                b.this.gdz.setVisibility(8);
                b.this.gdz.lt(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gdz.getTopDeletePanelBottom()) {
                    if (b.this.gdE != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bNI()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.gdy.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.gdy.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.gdy.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.gdy.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aES.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bNI()) {
                        ((DragTextView) view).bOc();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aES.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.gdz != null) {
                b.this.gdz.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gdz.getTopDeletePanelBottom()) {
                    b.this.gdz.lt(true);
                } else {
                    b.this.gdz.lt(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bNT() {
            int i;
            int i2;
            if (b.this.gdB != null) {
                b.this.fPd = b.this.gdB.Qo();
                b.this.gdI = b.this.gdB.Qn();
                int Qp = b.this.gdB.Qp();
                int imMsgListViewHeight = b.this.gdB.getImMsgListViewHeight();
                b.this.gdz.setDeleteBottomHeight(b.this.fPd);
                b.this.gdz.setTopDeletePanelHeight(b.this.gdI);
                b.this.gdz.setImMsgViewSize(Qp, imMsgListViewHeight);
                i2 = Qp;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.gdy != null) {
                int width = b.this.gdF.getWidth();
                int height = b.this.gdF.getHeight() - b.this.fPd;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.gdy.bB(width, height);
                for (int i3 = 0; i3 < b.this.gdy.getChildCount(); i3++) {
                    View childAt = b.this.gdy.getChildAt(i3);
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
            if (b.this.gdz != null) {
                b.this.gdz.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bNU() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bNI();
        }
    };
    private HttpMessageListener gdQ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gcc = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gcc;
                if (b.this.gcc != null && !b.this.gcc.isEmpty() && b.this.gdK != null && !b.this.gdK.isEmpty()) {
                    b.this.C(b.this.gdK);
                }
            }
        }
    };
    private HttpMessageListener gdR = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bNH();
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
                            a2.bOc();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bOc();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bNH();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.gdN == null) {
                                b.this.gdN = new LinkedList();
                            }
                            b.this.gdN.add(alaLiveStickerInfo);
                            b.this.a(b.this.aES.mLiveInfo.live_id, b.this.gdN);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gcf.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gcf.centerY;
                        alaLiveStickerInfo2.text = dVar2.gcf.text;
                        b.this.a(b.this.aES.mLiveInfo.live_id, b.this.gdN);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.gdN.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aES.mLiveInfo.live_id, b.this.gdN);
                        b.this.bR(a3);
                        b.this.bNO();
                        if (b.this.gdE != null) {
                            b.this.gdE.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.gdD = null;
        }
    };
    CustomMessageListener gdS = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.gdK = hashMap;
                    if (b.this.gcc != null && !b.this.gcc.isEmpty()) {
                        b.this.C(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.Qk();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener gdT = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gcc != null) {
                    for (int i = 0; i < b.this.gcc.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gcc.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.gdM = false;
                    if (b.this.gdB != null) {
                        b.this.gdB.J(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.aa.a.PQ().bod.aMu;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.gdU, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable gdU = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bNP();
        }
    };
    CustomMessageListener gdV = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.gdU);
                b.this.bNP();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gdQ);
        MessageManager.getInstance().registerListener(this.gdR);
        MessageManager.getInstance().registerListener(this.gdS);
        MessageManager.getInstance().registerListener(this.gdT);
        MessageManager.getInstance().registerListener(this.gdV);
    }

    @Override // com.baidu.live.ab.a
    public void u(ViewGroup viewGroup) {
        this.gdF = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void v(ViewGroup viewGroup) {
        this.gdH = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void fe(int i) {
        this.fPd = i;
    }

    @Override // com.baidu.live.ab.a
    public void setStickerCanOperate(boolean z) {
        if (this.gdy != null) {
            this.gdy.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.ab.a
    public void ff(int i) {
        if (this.gdy != null) {
            this.gdy.setVisibility(i);
        }
    }

    @Override // com.baidu.live.ab.a
    public void w(ViewGroup viewGroup) {
        this.gdG = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void a(com.baidu.live.g.a aVar) {
        this.gdE = aVar;
    }

    @Override // com.baidu.live.ab.a
    public void Qj() {
        if (this.gdA == null) {
            this.gdA = new c(this.mContext, this.gdO);
        } else {
            this.gdA.bNV();
        }
        this.gdA.show();
    }

    @Override // com.baidu.live.ab.a
    public void cx(boolean z) {
        this.gdJ = z;
    }

    @Override // com.baidu.live.ab.a
    public void setLiveShowInfo(w wVar) {
        this.aES = wVar;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            this.gdN = ev(this.aES.mLiveInfo.live_id);
            if (this.gdN != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.gdN) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.ab.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.gdC != null) {
                this.gdC.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdC.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gdC.setLayoutParams(layoutParams);
                    this.gdC.setBottom(0);
                }
            }
        } else if (this.gdC != null && this.gdG != null) {
            if (this.gdG.indexOfChild(this.gdC) >= 0) {
                this.gdG.removeView(this.gdC);
            }
            this.gdC.setVisibility(8);
            this.gdD = null;
            if (this.gdB != null) {
                this.gdB.Qm();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.ab.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.ab.a
    public void Qk() {
        com.baidu.tieba.ala.alaar.sticker.a.g.Qk();
    }

    @Override // com.baidu.live.ab.a
    public void a(a.InterfaceC0168a interfaceC0168a) {
        this.gdB = interfaceC0168a;
    }

    @Override // com.baidu.live.ab.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gdC != null) {
            this.gdC.unRegisterListener();
            this.gdC = null;
        }
        if (this.gdA != null) {
            this.gdA.unRegisterListener();
            this.gdA = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gdQ);
        MessageManager.getInstance().unRegisterListener(this.gdR);
        MessageManager.getInstance().unRegisterListener(this.gdS);
        MessageManager.getInstance().unRegisterListener(this.gdT);
        MessageManager.getInstance().unRegisterListener(this.gdV);
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(String str) {
        if (this.gdC == null) {
            this.gdC = new AlaTextStickerEditView(this.mContext);
            this.gdC.setLiveShowInfo(this.aES);
            this.gdC.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Gl(String str2) {
                    if (str2 != null && b.this.gdD != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bNI()) {
                        b.this.gdD.setText(str2);
                        long j = b.this.aES.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.gdD.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bNS() {
                }
            });
        }
        if (this.gdG != null) {
            if (this.gdG.indexOfChild(this.gdC) >= 0) {
                this.gdG.removeView(this.gdC);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.gdC.setVisibility(0);
            this.gdG.addView(this.gdC, layoutParams);
            this.gdC.Gn(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNN() {
        if (this.gdy == null) {
            this.gdy = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gdz == null) {
            this.gdz = new AlaStickerDragDeletePanelView(this.mContext);
            this.gdz.setVisibility(8);
        }
        if (this.gdy.getParent() == null) {
            this.gdy.bB(this.gdF.getWidth(), this.gdF.getHeight() - this.fPd);
            this.gdF.addView(this.gdy, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gdz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.gdB != null) {
                this.gdz.setDeleteBottomHeight(this.gdB.Qo());
                this.gdz.setTopDeletePanelHeight(this.gdB.Qn());
            }
            this.gdH.addView(this.gdz, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNO() {
        if (this.gdy.getChildCount() == 0) {
            if (this.gdy != null) {
                ((ViewGroup) this.gdy.getParent()).removeView(this.gdy);
            }
            if (this.gdz != null) {
                ((ViewGroup) this.gdz.getParent()).removeView(this.gdz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gdy != null) {
            return this.gdy.a(i, bitmap, i2, this.gdP, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gdy != null) {
            this.gdy.b(i, bitmap, i2, this.gdP, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(View view) {
        if (this.gdy != null) {
            this.gdy.bS(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.gcc != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gcc.size()) {
                    break;
                }
                hashMap.put(this.gcc.get(i2).id, this.gcc.get(i2));
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
                        if (b.this.gdK != null) {
                            b.this.gdK.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bNs().isRunning(fuFaceItem.file)) {
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
                        if (b.this.gdK != null) {
                            b.this.gdK.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.gdK != null && b.this.gdK.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.gdK.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.gdK.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.gdK.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bNP() {
        FuFaceItem fuFaceItem;
        if (!this.gdM) {
            if (this.gdL != null) {
                fuFaceItem = this.gdL;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gcc.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gcc.get(i2);
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
            this.gdM = true;
            this.gdO.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.gdy != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gdy.getChildCount()) {
                    break;
                }
                View childAt = this.gdy.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gcf || alaLiveStickerInfo.id == dVar.gcf.id) {
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

    private List<AlaLiveStickerInfo> ev(long j) {
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
                        int i2 = a.c.sdk_cp_cont_q;
                        b.this.bNN();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
