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
    private List<FuFaceItem> gjW;
    private Map<String, Integer> glC;
    private FuFaceItem glD;
    private List<AlaLiveStickerInfo> glF;
    private AlaStickerDragContentView glq;
    private AlaStickerDragDeletePanelView glr;
    private c gls;
    private a.InterfaceC0172a glt;
    private AlaTextStickerEditView glu;
    private DragTextView glv;
    private com.baidu.live.i.a glw;
    private ViewGroup glx;
    private ViewGroup gly;
    private ViewGroup glz;
    private Context mContext;
    private int glA = 0;
    private int fWz = 0;
    private boolean fvC = true;
    private Handler mHandler = new Handler();
    private boolean glB = false;
    private boolean glE = true;
    private c.b glG = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> glO = new ArrayList();
        FuFaceItem glP;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bQV() {
            return b.this.glE;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.glD = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.glO.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.glB) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.glq != null && b.this.glq.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bQN()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bQS();
                    b.this.glv = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.glP = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.glt != null) {
                    b.this.glt.J(fuFaceItem.getSticker());
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
        public void bQW() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.glO.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.glO.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.glO.clear();
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
            if (this.glP != null && !TextUtils.isEmpty(this.glP.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.glP.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.p("arssticker_suc", jSONObject3);
            }
            this.glP = null;
        }
    };
    private Runnable frA = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fvC = true;
        }
    };
    private e glH = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fvC) {
                b.this.fvC = false;
                b.this.mHandler.postDelayed(b.this.frA, 600L);
                if (view instanceof DragTextView) {
                    b.this.glv = (DragTextView) view;
                    if (b.this.glt != null) {
                        b.this.glt.RW();
                    }
                    b.this.GA(b.this.glv.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.glr != null) {
                b.this.glr.setVisibility(8);
                b.this.glr.lP(false);
                if (((i4 - i2) / 5) + i2 >= b.this.glr.getTopDeletePanelBottom()) {
                    if (b.this.glw != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bQN()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.glq.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.glq.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.glq.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.glq.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bQN()) {
                        ((DragTextView) view).bRh();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aFN.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void B(int i, int i2, int i3, int i4) {
            if (b.this.glr != null) {
                b.this.glr.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.glr.getTopDeletePanelBottom()) {
                    b.this.glr.lP(true);
                } else {
                    b.this.glr.lP(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bQY() {
            int i;
            int i2;
            if (b.this.glt != null) {
                b.this.fWz = b.this.glt.RZ();
                b.this.glA = b.this.glt.RY();
                int Sa = b.this.glt.Sa();
                int imMsgListViewHeight = b.this.glt.getImMsgListViewHeight();
                b.this.glr.setDeleteBottomHeight(b.this.fWz);
                b.this.glr.setTopDeletePanelHeight(b.this.glA);
                b.this.glr.setImMsgViewSize(Sa, imMsgListViewHeight);
                i2 = Sa;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.glq != null) {
                int width = b.this.glx.getWidth();
                int height = b.this.glx.getHeight() - b.this.fWz;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.glq.bD(width, height);
                for (int i3 = 0; i3 < b.this.glq.getChildCount(); i3++) {
                    View childAt = b.this.glq.getChildAt(i3);
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
            if (b.this.glr != null) {
                b.this.glr.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bQZ() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bQN();
        }
    };
    private HttpMessageListener glI = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gjW = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gjW;
                if (b.this.gjW != null && !b.this.gjW.isEmpty() && b.this.glC != null && !b.this.glC.isEmpty()) {
                    b.this.C(b.this.glC);
                }
            }
        }
    };
    private HttpMessageListener glJ = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bQM();
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
                            a2.bRh();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bRh();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bQM();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.glF == null) {
                                b.this.glF = new LinkedList();
                            }
                            b.this.glF.add(alaLiveStickerInfo);
                            b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glF);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gjZ.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gjZ.centerY;
                        alaLiveStickerInfo2.text = dVar2.gjZ.text;
                        b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glF);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.glF.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aFN.mLiveInfo.live_id, b.this.glF);
                        b.this.cb(a3);
                        b.this.bQT();
                        if (b.this.glw != null) {
                            b.this.glw.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.glv = null;
        }
    };
    CustomMessageListener glK = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.glC = hashMap;
                    if (b.this.gjW != null && !b.this.gjW.isEmpty()) {
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
    CustomMessageListener glL = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gjW != null) {
                    for (int i = 0; i < b.this.gjW.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gjW.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.glE = false;
                    if (b.this.glt != null) {
                        b.this.glt.J(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.ae.a.RB().brA.aNE;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.glM, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable glM = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQU();
        }
    };
    CustomMessageListener glN = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.glM);
                b.this.bQU();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.glI);
        MessageManager.getInstance().registerListener(this.glJ);
        MessageManager.getInstance().registerListener(this.glK);
        MessageManager.getInstance().registerListener(this.glL);
        MessageManager.getInstance().registerListener(this.glN);
    }

    @Override // com.baidu.live.af.a
    public void q(ViewGroup viewGroup) {
        this.glx = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void r(ViewGroup viewGroup) {
        this.glz = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void fy(int i) {
        this.fWz = i;
    }

    @Override // com.baidu.live.af.a
    public void setStickerCanOperate(boolean z) {
        if (this.glq != null) {
            this.glq.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.af.a
    public void fz(int i) {
        if (this.glq != null) {
            this.glq.setVisibility(i);
        }
    }

    @Override // com.baidu.live.af.a
    public void s(ViewGroup viewGroup) {
        this.gly = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.i.a aVar) {
        this.glw = aVar;
    }

    @Override // com.baidu.live.af.a
    public void RU() {
        if (this.gls == null) {
            this.gls = new c(this.mContext, this.glG);
        } else {
            this.gls.bRa();
        }
        this.gls.show();
    }

    @Override // com.baidu.live.af.a
    public void cN(boolean z) {
        this.glB = z;
    }

    @Override // com.baidu.live.af.a
    public void setLiveShowInfo(w wVar) {
        this.aFN = wVar;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.glF = eY(this.aFN.mLiveInfo.live_id);
            if (this.glF != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.glF) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.af.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.glu != null) {
                this.glu.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glu.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.glu.setLayoutParams(layoutParams);
                    this.glu.setBottom(0);
                }
            }
        } else if (this.glu != null && this.gly != null) {
            if (this.gly.indexOfChild(this.glu) >= 0) {
                this.gly.removeView(this.glu);
            }
            this.glu.setVisibility(8);
            this.glv = null;
            if (this.glt != null) {
                this.glt.RX();
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
        this.glt = interfaceC0172a;
    }

    @Override // com.baidu.live.af.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.glu != null) {
            this.glu.unRegisterListener();
            this.glu = null;
        }
        if (this.gls != null) {
            this.gls.unRegisterListener();
            this.gls = null;
        }
        MessageManager.getInstance().unRegisterListener(this.glI);
        MessageManager.getInstance().unRegisterListener(this.glJ);
        MessageManager.getInstance().unRegisterListener(this.glK);
        MessageManager.getInstance().unRegisterListener(this.glL);
        MessageManager.getInstance().unRegisterListener(this.glN);
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
        if (this.glu == null) {
            this.glu = new AlaTextStickerEditView(this.mContext);
            this.glu.setLiveShowInfo(this.aFN);
            this.glu.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void GB(String str2) {
                    if (str2 != null && b.this.glv != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bQN()) {
                        b.this.glv.setText(str2);
                        long j = b.this.aFN.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.glv.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bQX() {
                }
            });
        }
        if (this.gly != null) {
            if (this.gly.indexOfChild(this.glu) >= 0) {
                this.gly.removeView(this.glu);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.glu.setVisibility(0);
            this.gly.addView(this.glu, layoutParams);
            this.glu.GD(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQS() {
        if (this.glq == null) {
            this.glq = new AlaStickerDragContentView(this.mContext);
        }
        if (this.glr == null) {
            this.glr = new AlaStickerDragDeletePanelView(this.mContext);
            this.glr.setVisibility(8);
        }
        if (this.glq.getParent() == null) {
            this.glq.bD(this.glx.getWidth(), this.glx.getHeight() - this.fWz);
            this.glx.addView(this.glq, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.glr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.glt != null) {
                this.glr.setDeleteBottomHeight(this.glt.RZ());
                this.glr.setTopDeletePanelHeight(this.glt.RY());
            }
            this.glz.addView(this.glr, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQT() {
        if (this.glq.getChildCount() == 0) {
            if (this.glq != null) {
                ((ViewGroup) this.glq.getParent()).removeView(this.glq);
            }
            if (this.glr != null) {
                ((ViewGroup) this.glr.getParent()).removeView(this.glr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.glq != null) {
            return this.glq.a(i, bitmap, i2, this.glH, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.glq != null) {
            this.glq.b(i, bitmap, i2, this.glH, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(View view) {
        if (this.glq != null) {
            this.glq.cc(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.gjW != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gjW.size()) {
                    break;
                }
                hashMap.put(this.gjW.get(i2).id, this.gjW.get(i2));
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
                        if (b.this.glC != null) {
                            b.this.glC.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(fuFaceItem.file)) {
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
                        if (b.this.glC != null) {
                            b.this.glC.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.glC != null && b.this.glC.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.glC.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.glC.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.glC.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bQU() {
        FuFaceItem fuFaceItem;
        if (!this.glE) {
            if (this.glD != null) {
                fuFaceItem = this.glD;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gjW.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gjW.get(i2);
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
            this.glE = true;
            this.glG.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.glq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.glq.getChildCount()) {
                    break;
                }
                View childAt = this.glq.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gjZ || alaLiveStickerInfo.id == dVar.gjZ.id) {
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
                        b.this.bQS();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
