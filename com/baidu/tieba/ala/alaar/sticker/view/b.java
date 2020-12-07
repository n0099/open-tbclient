package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
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
public class b implements com.baidu.live.af.a {
    private w aFN;
    private List<FuFaceItem> gjU;
    private Map<String, Integer> glA;
    private FuFaceItem glB;
    private List<AlaLiveStickerInfo> glD;
    private AlaStickerDragContentView glo;
    private AlaStickerDragDeletePanelView glp;
    private c glq;
    private a.InterfaceC0172a glr;
    private AlaTextStickerEditView gls;
    private DragTextView glt;
    private com.baidu.live.i.a glu;
    private ViewGroup glv;
    private ViewGroup glw;
    private ViewGroup glx;
    private Context mContext;
    private int gly = 0;
    private int fWx = 0;
    private boolean fvC = true;
    private Handler mHandler = new Handler();
    private boolean glz = false;
    private boolean glC = true;
    private c.b glE = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> glM = new ArrayList();
        FuFaceItem glN;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bQU() {
            return b.this.glC;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.glB = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.glM.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.glz) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.glo != null && b.this.glo.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bQM()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bQR();
                    b.this.glt = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.glN = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.glr != null) {
                    b.this.glr.J(fuFaceItem.getSticker());
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
        public void bQV() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.glM.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.glM.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.glM.clear();
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
            if (this.glN != null && !TextUtils.isEmpty(this.glN.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.glN.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.p("arssticker_suc", jSONObject3);
            }
            this.glN = null;
        }
    };
    private Runnable frA = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fvC = true;
        }
    };
    private e glF = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fvC) {
                b.this.fvC = false;
                b.this.mHandler.postDelayed(b.this.frA, 600L);
                if (view instanceof DragTextView) {
                    b.this.glt = (DragTextView) view;
                    if (b.this.glr != null) {
                        b.this.glr.RW();
                    }
                    b.this.GA(b.this.glt.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.glp != null) {
                b.this.glp.setVisibility(8);
                b.this.glp.lP(false);
                if (((i4 - i2) / 5) + i2 >= b.this.glp.getTopDeletePanelBottom()) {
                    if (b.this.glu != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bQM()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.glo.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.glo.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.glo.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.glo.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bQM()) {
                        ((DragTextView) view).bRg();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void B(int i, int i2, int i3, int i4) {
            if (b.this.glp != null) {
                b.this.glp.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.glp.getTopDeletePanelBottom()) {
                    b.this.glp.lP(true);
                } else {
                    b.this.glp.lP(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bQX() {
            int i;
            int i2;
            if (b.this.glr != null) {
                b.this.fWx = b.this.glr.RZ();
                b.this.gly = b.this.glr.RY();
                int Sa = b.this.glr.Sa();
                int imMsgListViewHeight = b.this.glr.getImMsgListViewHeight();
                b.this.glp.setDeleteBottomHeight(b.this.fWx);
                b.this.glp.setTopDeletePanelHeight(b.this.gly);
                b.this.glp.setImMsgViewSize(Sa, imMsgListViewHeight);
                i2 = Sa;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.glo != null) {
                int width = b.this.glv.getWidth();
                int height = b.this.glv.getHeight() - b.this.fWx;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.glo.bD(width, height);
                for (int i3 = 0; i3 < b.this.glo.getChildCount(); i3++) {
                    View childAt = b.this.glo.getChildAt(i3);
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
            if (b.this.glp != null) {
                b.this.glp.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bQY() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bQM();
        }
    };
    private HttpMessageListener glG = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gjU = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gjU;
                if (b.this.gjU != null && !b.this.gjU.isEmpty() && b.this.glA != null && !b.this.glA.isEmpty()) {
                    b.this.C(b.this.glA);
                }
            }
        }
    };
    private HttpMessageListener glH = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bQL();
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
                            a2.bRg();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bRg();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bQL();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.glD == null) {
                                b.this.glD = new LinkedList();
                            }
                            b.this.glD.add(alaLiveStickerInfo);
                            b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glD);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gjX.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gjX.centerY;
                        alaLiveStickerInfo2.text = dVar2.gjX.text;
                        b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glD);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.glD.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glD);
                        b.this.cb(a3);
                        b.this.bQS();
                        if (b.this.glu != null) {
                            b.this.glu.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.glt = null;
        }
    };
    CustomMessageListener glI = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.glA = hashMap;
                    if (b.this.gjU != null && !b.this.gjU.isEmpty()) {
                        b.this.C(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.RV();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener glJ = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gjU != null) {
                    for (int i = 0; i < b.this.gjU.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gjU.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.glC = false;
                    if (b.this.glr != null) {
                        b.this.glr.J(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.ae.a.RB().brA.aNE;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.glK, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable glK = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQT();
        }
    };
    CustomMessageListener glL = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.glK);
                b.this.bQT();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.glG);
        MessageManager.getInstance().registerListener(this.glH);
        MessageManager.getInstance().registerListener(this.glI);
        MessageManager.getInstance().registerListener(this.glJ);
        MessageManager.getInstance().registerListener(this.glL);
    }

    @Override // com.baidu.live.af.a
    public void q(ViewGroup viewGroup) {
        this.glv = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void r(ViewGroup viewGroup) {
        this.glx = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void fy(int i) {
        this.fWx = i;
    }

    @Override // com.baidu.live.af.a
    public void setStickerCanOperate(boolean z) {
        if (this.glo != null) {
            this.glo.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.af.a
    public void fz(int i) {
        if (this.glo != null) {
            this.glo.setVisibility(i);
        }
    }

    @Override // com.baidu.live.af.a
    public void s(ViewGroup viewGroup) {
        this.glw = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.i.a aVar) {
        this.glu = aVar;
    }

    @Override // com.baidu.live.af.a
    public void RU() {
        if (this.glq == null) {
            this.glq = new c(this.mContext, this.glE);
        } else {
            this.glq.bQZ();
        }
        this.glq.show();
    }

    @Override // com.baidu.live.af.a
    public void cN(boolean z) {
        this.glz = z;
    }

    @Override // com.baidu.live.af.a
    public void setLiveShowInfo(w wVar) {
        this.aFN = wVar;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.glD = eY(this.aFN.mLiveInfo.live_id);
            if (this.glD != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.glD) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.af.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.gls != null) {
                this.gls.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gls.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gls.setLayoutParams(layoutParams);
                    this.gls.setBottom(0);
                }
            }
        } else if (this.gls != null && this.glw != null) {
            if (this.glw.indexOfChild(this.gls) >= 0) {
                this.glw.removeView(this.gls);
            }
            this.gls.setVisibility(8);
            this.glt = null;
            if (this.glr != null) {
                this.glr.RX();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.af.a
    public void RV() {
        com.baidu.tieba.ala.alaar.sticker.a.g.RV();
    }

    @Override // com.baidu.live.af.a
    public void a(a.InterfaceC0172a interfaceC0172a) {
        this.glr = interfaceC0172a;
    }

    @Override // com.baidu.live.af.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gls != null) {
            this.gls.unRegisterListener();
            this.gls = null;
        }
        if (this.glq != null) {
            this.glq.unRegisterListener();
            this.glq = null;
        }
        MessageManager.getInstance().unRegisterListener(this.glG);
        MessageManager.getInstance().unRegisterListener(this.glH);
        MessageManager.getInstance().unRegisterListener(this.glI);
        MessageManager.getInstance().unRegisterListener(this.glJ);
        MessageManager.getInstance().unRegisterListener(this.glL);
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA(String str) {
        if (this.gls == null) {
            this.gls = new AlaTextStickerEditView(this.mContext);
            this.gls.setLiveShowInfo(this.aFN);
            this.gls.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void GB(String str2) {
                    if (str2 != null && b.this.glt != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bQM()) {
                        b.this.glt.setText(str2);
                        long j = b.this.aFN.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.glt.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bQW() {
                }
            });
        }
        if (this.glw != null) {
            if (this.glw.indexOfChild(this.gls) >= 0) {
                this.glw.removeView(this.gls);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.gls.setVisibility(0);
            this.glw.addView(this.gls, layoutParams);
            this.gls.GD(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQR() {
        if (this.glo == null) {
            this.glo = new AlaStickerDragContentView(this.mContext);
        }
        if (this.glp == null) {
            this.glp = new AlaStickerDragDeletePanelView(this.mContext);
            this.glp.setVisibility(8);
        }
        if (this.glo.getParent() == null) {
            this.glo.bD(this.glv.getWidth(), this.glv.getHeight() - this.fWx);
            this.glv.addView(this.glo, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.glp.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.glr != null) {
                this.glp.setDeleteBottomHeight(this.glr.RZ());
                this.glp.setTopDeletePanelHeight(this.glr.RY());
            }
            this.glx.addView(this.glp, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQS() {
        if (this.glo.getChildCount() == 0) {
            if (this.glo != null) {
                ((ViewGroup) this.glo.getParent()).removeView(this.glo);
            }
            if (this.glp != null) {
                ((ViewGroup) this.glp.getParent()).removeView(this.glp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.glo != null) {
            return this.glo.a(i, bitmap, i2, this.glF, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.glo != null) {
            this.glo.b(i, bitmap, i2, this.glF, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(View view) {
        if (this.glo != null) {
            this.glo.cc(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.gjU != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gjU.size()) {
                    break;
                }
                hashMap.put(this.gjU.get(i2).id, this.gjU.get(i2));
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
                        if (b.this.glA != null) {
                            b.this.glA.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bQw().isRunning(fuFaceItem.file)) {
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
                        if (b.this.glA != null) {
                            b.this.glA.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.glA != null && b.this.glA.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.glA.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.glA.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.glA.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bQT() {
        FuFaceItem fuFaceItem;
        if (!this.glC) {
            if (this.glB != null) {
                fuFaceItem = this.glB;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gjU.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gjU.get(i2);
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
            this.glC = true;
            this.glE.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.glo != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.glo.getChildCount()) {
                    break;
                }
                View childAt = this.glo.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gjX || alaLiveStickerInfo.id == dVar.gjX.id) {
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
            com.baidu.live.d.BM().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.d.BM().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> eY(long j) {
        String string = com.baidu.live.d.BM().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bQR();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
