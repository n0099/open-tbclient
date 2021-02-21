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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.af.a {
    private ab aDd;
    private List<FuFaceItem> gsM;
    private AlaStickerDragContentView guf;
    private AlaStickerDragDeletePanelView gug;
    private c guh;
    private a.InterfaceC0156a gui;
    private AlaTextStickerEditView guj;
    private DragTextView guk;
    private com.baidu.live.i.a gul;
    private ViewGroup gum;
    private ViewGroup gun;
    private ViewGroup guo;
    private Map<String, Integer> gur;
    private FuFaceItem gus;
    private List<AlaLiveStickerInfo> guu;
    private Context mContext;
    private int gup = 0;
    private int gdQ = 0;
    private boolean fCP = true;
    private Handler mHandler = new Handler();
    private boolean guq = false;
    private boolean gut = true;
    private c.b guv = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> guD = new ArrayList();
        FuFaceItem guE;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bQn() {
            return b.this.gut;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gus = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.guD.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.guq) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.guf != null && b.this.guf.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bQg()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bQk();
                    b.this.guk = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.guE = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.gui != null) {
                    b.this.gui.F(fuFaceItem.getSticker());
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
        public void bQo() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.guD.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.guD.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.guD.clear();
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("picsticker_id", jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b.this.q("picsticker_suc", jSONObject);
            }
            if (jSONArray2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("textsticker_id", jSONArray2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b.this.q("textsticker_suc", jSONObject2);
            }
            if (this.guE != null && !TextUtils.isEmpty(this.guE.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.guE.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.q("arssticker_suc", jSONObject3);
            }
            this.guE = null;
        }
    };
    private Runnable fyN = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fCP = true;
        }
    };
    private e guw = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fCP) {
                b.this.fCP = false;
                b.this.mHandler.postDelayed(b.this.fyN, 600L);
                if (view instanceof DragTextView) {
                    b.this.guk = (DragTextView) view;
                    if (b.this.gui != null) {
                        b.this.gui.QG();
                    }
                    b.this.FL(b.this.guk.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void g(View view, int i, int i2, int i3, int i4) {
            if (b.this.gug != null) {
                b.this.gug.setVisibility(8);
                b.this.gug.mm(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gug.getTopDeletePanelBottom()) {
                    if (b.this.gul != null) {
                        Log.d("bugbye", "bugbye");
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bQg()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.guf.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.guf.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.guf.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.guf.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bQg()) {
                        ((DragTextView) view).bQz();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void C(int i, int i2, int i3, int i4) {
            if (b.this.gug != null) {
                b.this.gug.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gug.getTopDeletePanelBottom()) {
                    b.this.gug.mm(true);
                } else {
                    b.this.gug.mm(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bQq() {
            int i;
            int i2;
            if (b.this.gui != null) {
                b.this.gdQ = b.this.gui.QJ();
                b.this.gup = b.this.gui.QI();
                i2 = b.this.gui.QK();
                int imMsgListViewHeight = b.this.gui.getImMsgListViewHeight();
                b.this.gug.setDeleteBottomHeight(b.this.gdQ);
                b.this.gug.setTopDeletePanelHeight(b.this.gup);
                b.this.gug.setImMsgViewSize(i2, imMsgListViewHeight);
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.guf != null) {
                int width = b.this.gum.getWidth();
                int height = b.this.gum.getHeight() - b.this.gdQ;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.guf.bz(width, height);
                for (int i3 = 0; i3 < b.this.guf.getChildCount(); i3++) {
                    View childAt = b.this.guf.getChildAt(i3);
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
            if (b.this.gug != null) {
                b.this.gug.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bQr() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bQg();
        }
    };
    private HttpMessageListener gux = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gsM = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gsM;
                if (b.this.gsM != null && !b.this.gsM.isEmpty() && b.this.gur != null && !b.this.gur.isEmpty()) {
                    b.this.F(b.this.gur);
                }
            }
        }
    };
    private HttpMessageListener guy = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bQf();
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
                            a2.bQz();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bQz();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bQf();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.guu == null) {
                                b.this.guu = new LinkedList();
                            }
                            b.this.guu.add(alaLiveStickerInfo);
                            b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.guu);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gsP.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gsP.centerY;
                        alaLiveStickerInfo2.text = dVar2.gsP.text;
                        b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.guu);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.guu.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.guu);
                        b.this.cg(a3);
                        b.this.bQl();
                        if (b.this.gul != null) {
                            b.this.gul.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.guk = null;
        }
    };
    CustomMessageListener guz = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.gur = hashMap;
                    if (b.this.gsM != null && !b.this.gsM.isEmpty()) {
                        b.this.F(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.QF();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener guA = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gsM != null) {
                    for (int i = 0; i < b.this.gsM.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gsM.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.gut = false;
                    if (b.this.gui != null) {
                        b.this.gui.F(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.ae.a.Qj().buX.aMf;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.guB, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable guB = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQm();
        }
    };
    CustomMessageListener guC = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.guB);
                b.this.bQm();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gux);
        MessageManager.getInstance().registerListener(this.guy);
        MessageManager.getInstance().registerListener(this.guz);
        MessageManager.getInstance().registerListener(this.guA);
        MessageManager.getInstance().registerListener(this.guC);
    }

    @Override // com.baidu.live.af.a
    public void r(ViewGroup viewGroup) {
        this.gum = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void s(ViewGroup viewGroup) {
        this.guo = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void dX(int i) {
        this.gdQ = i;
    }

    @Override // com.baidu.live.af.a
    public void setStickerCanOperate(boolean z) {
        if (this.guf != null) {
            this.guf.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.af.a
    public void dY(int i) {
        if (this.guf != null) {
            this.guf.setVisibility(i);
        }
    }

    @Override // com.baidu.live.af.a
    public void t(ViewGroup viewGroup) {
        this.gun = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.i.a aVar) {
        this.gul = aVar;
    }

    @Override // com.baidu.live.af.a
    public void QE() {
        if (this.guh == null) {
            this.guh = new c(this.mContext, this.guv);
        } else {
            this.guh.bQs();
        }
        this.guh.show();
    }

    @Override // com.baidu.live.af.a
    public void cV(boolean z) {
        this.guq = z;
    }

    @Override // com.baidu.live.af.a
    public void setLiveShowInfo(ab abVar) {
        this.aDd = abVar;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.guu = fe(this.aDd.mLiveInfo.live_id);
            if (this.guu != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.guu) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.af.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.guj != null) {
                this.guj.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guj.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.guj.setLayoutParams(layoutParams);
                    this.guj.setBottom(0);
                }
            }
        } else if (this.guj != null && this.gun != null) {
            if (this.gun.indexOfChild(this.guj) >= 0) {
                this.gun.removeView(this.guj);
            }
            this.guj.setVisibility(8);
            this.guk = null;
            if (this.gui != null) {
                this.gui.QH();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.af.a
    public void QF() {
        com.baidu.tieba.ala.alaar.sticker.a.g.QF();
    }

    @Override // com.baidu.live.af.a
    public void a(a.InterfaceC0156a interfaceC0156a) {
        this.gui = interfaceC0156a;
    }

    @Override // com.baidu.live.af.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.guj != null) {
            this.guj.unRegisterListener();
            this.guj = null;
        }
        if (this.guh != null) {
            this.guh.unRegisterListener();
            this.guh = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gux);
        MessageManager.getInstance().unRegisterListener(this.guy);
        MessageManager.getInstance().unRegisterListener(this.guz);
        MessageManager.getInstance().unRegisterListener(this.guA);
        MessageManager.getInstance().unRegisterListener(this.guC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, JSONObject jSONObject) {
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
    public void FL(String str) {
        if (this.guj == null) {
            this.guj = new AlaTextStickerEditView(this.mContext);
            this.guj.setLiveShowInfo(this.aDd);
            this.guj.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void FM(String str2) {
                    if (str2 != null && b.this.guk != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bQg()) {
                        b.this.guk.setText(str2);
                        long j = b.this.aDd.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.guk.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bQp() {
                }
            });
        }
        if (this.gun != null) {
            if (this.gun.indexOfChild(this.guj) >= 0) {
                this.gun.removeView(this.guj);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.guj.setVisibility(0);
            this.gun.addView(this.guj, layoutParams);
            this.guj.FO(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQk() {
        if (this.guf == null) {
            this.guf = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gug == null) {
            this.gug = new AlaStickerDragDeletePanelView(this.mContext);
            this.gug.setVisibility(8);
        }
        if (this.guf.getParent() == null) {
            this.guf.bz(this.gum.getWidth(), this.gum.getHeight() - this.gdQ);
            this.gum.addView(this.guf, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gug.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.gui != null) {
                this.gug.setDeleteBottomHeight(this.gui.QJ());
                this.gug.setTopDeletePanelHeight(this.gui.QI());
            }
            this.guo.addView(this.gug, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQl() {
        if (this.guf.getChildCount() == 0) {
            if (this.guf != null) {
                ((ViewGroup) this.guf.getParent()).removeView(this.guf);
            }
            if (this.gug != null) {
                ((ViewGroup) this.gug.getParent()).removeView(this.gug);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.guf != null) {
            return this.guf.a(i, bitmap, i2, this.guw, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.guf != null) {
            this.guf.b(i, bitmap, i2, this.guw, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
        if (this.guf != null) {
            this.guf.ch(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Map<String, Integer> map) {
        if (this.gsM != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gsM.size()) {
                    break;
                }
                hashMap.put(this.gsM.get(i2).id, this.gsM.get(i2));
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
                        if (b.this.gur != null) {
                            b.this.gur.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bPQ().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.h.a(fuFaceItem, new h.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: b */
                    public void J(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    /* renamed from: c */
                    public void aF(FuFaceItem fuFaceItem2) {
                        if (b.this.gur != null) {
                            b.this.gur.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.gur != null && b.this.gur.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.gur.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.gur.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.gur.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bQm() {
        FuFaceItem fuFaceItem;
        if (!this.gut) {
            if (this.gus != null) {
                fuFaceItem = this.gus;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gsM.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gsM.get(i2);
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
            this.gut = true;
            this.guv.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.guf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.guf.getChildCount()) {
                    break;
                }
                View childAt = this.guf.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gsP || alaLiveStickerInfo.id == dVar.gsP.id) {
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
            com.baidu.live.d.xc().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.d.xc().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> fe(long j) {
        String string = com.baidu.live.d.xc().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bQk();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
