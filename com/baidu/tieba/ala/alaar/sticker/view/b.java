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
    private List<FuFaceItem> gsy;
    private AlaStickerDragContentView gtR;
    private AlaStickerDragDeletePanelView gtS;
    private c gtT;
    private a.InterfaceC0156a gtU;
    private AlaTextStickerEditView gtV;
    private DragTextView gtW;
    private com.baidu.live.i.a gtX;
    private ViewGroup gtY;
    private ViewGroup gtZ;
    private ViewGroup gua;
    private Map<String, Integer> gud;
    private FuFaceItem gue;
    private List<AlaLiveStickerInfo> gug;
    private Context mContext;
    private int gub = 0;
    private int gdL = 0;
    private boolean fCP = true;
    private Handler mHandler = new Handler();
    private boolean guc = false;
    private boolean guf = true;
    private c.b guh = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> gup = new ArrayList();
        FuFaceItem guq;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bQg() {
            return b.this.guf;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gue = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.gup.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.guc) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.gtR != null && b.this.gtR.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bPZ()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bQd();
                    b.this.gtW = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.guq = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.gtU != null) {
                    b.this.gtU.F(fuFaceItem.getSticker());
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
        public void bQh() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gup.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.gup.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.gup.clear();
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
            if (this.guq != null && !TextUtils.isEmpty(this.guq.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.guq.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.q("arssticker_suc", jSONObject3);
            }
            this.guq = null;
        }
    };
    private Runnable fyN = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fCP = true;
        }
    };
    private e gui = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fCP) {
                b.this.fCP = false;
                b.this.mHandler.postDelayed(b.this.fyN, 600L);
                if (view instanceof DragTextView) {
                    b.this.gtW = (DragTextView) view;
                    if (b.this.gtU != null) {
                        b.this.gtU.QG();
                    }
                    b.this.FK(b.this.gtW.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void g(View view, int i, int i2, int i3, int i4) {
            if (b.this.gtS != null) {
                b.this.gtS.setVisibility(8);
                b.this.gtS.mm(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gtS.getTopDeletePanelBottom()) {
                    if (b.this.gtX != null) {
                        Log.d("bugbye", "bugbye");
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bPZ()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.gtR.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.gtR.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.gtR.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.gtR.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bPZ()) {
                        ((DragTextView) view).bQs();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDd.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void C(int i, int i2, int i3, int i4) {
            if (b.this.gtS != null) {
                b.this.gtS.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gtS.getTopDeletePanelBottom()) {
                    b.this.gtS.mm(true);
                } else {
                    b.this.gtS.mm(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bQj() {
            int i;
            int i2;
            if (b.this.gtU != null) {
                b.this.gdL = b.this.gtU.QJ();
                b.this.gub = b.this.gtU.QI();
                i2 = b.this.gtU.QK();
                int imMsgListViewHeight = b.this.gtU.getImMsgListViewHeight();
                b.this.gtS.setDeleteBottomHeight(b.this.gdL);
                b.this.gtS.setTopDeletePanelHeight(b.this.gub);
                b.this.gtS.setImMsgViewSize(i2, imMsgListViewHeight);
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.gtR != null) {
                int width = b.this.gtY.getWidth();
                int height = b.this.gtY.getHeight() - b.this.gdL;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.gtR.by(width, height);
                for (int i3 = 0; i3 < b.this.gtR.getChildCount(); i3++) {
                    View childAt = b.this.gtR.getChildAt(i3);
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
            if (b.this.gtS != null) {
                b.this.gtS.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bQk() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bPZ();
        }
    };
    private HttpMessageListener guj = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gsy = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gsy;
                if (b.this.gsy != null && !b.this.gsy.isEmpty() && b.this.gud != null && !b.this.gud.isEmpty()) {
                    b.this.F(b.this.gud);
                }
            }
        }
    };
    private HttpMessageListener guk = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bPY();
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
                            a2.bQs();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bQs();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bPY();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.gug == null) {
                                b.this.gug = new LinkedList();
                            }
                            b.this.gug.add(alaLiveStickerInfo);
                            b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.gug);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gsB.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gsB.centerY;
                        alaLiveStickerInfo2.text = dVar2.gsB.text;
                        b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.gug);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.gug.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aDd.mLiveInfo.live_id, b.this.gug);
                        b.this.cg(a3);
                        b.this.bQe();
                        if (b.this.gtX != null) {
                            b.this.gtX.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.gtW = null;
        }
    };
    CustomMessageListener gul = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.gud = hashMap;
                    if (b.this.gsy != null && !b.this.gsy.isEmpty()) {
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
    CustomMessageListener gum = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gsy != null) {
                    for (int i = 0; i < b.this.gsy.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gsy.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.guf = false;
                    if (b.this.gtU != null) {
                        b.this.gtU.F(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.ae.a.Qj().buX.aMf;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.gun, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable gun = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQf();
        }
    };
    CustomMessageListener guo = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.gun);
                b.this.bQf();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.guj);
        MessageManager.getInstance().registerListener(this.guk);
        MessageManager.getInstance().registerListener(this.gul);
        MessageManager.getInstance().registerListener(this.gum);
        MessageManager.getInstance().registerListener(this.guo);
    }

    @Override // com.baidu.live.af.a
    public void r(ViewGroup viewGroup) {
        this.gtY = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void s(ViewGroup viewGroup) {
        this.gua = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void dX(int i) {
        this.gdL = i;
    }

    @Override // com.baidu.live.af.a
    public void setStickerCanOperate(boolean z) {
        if (this.gtR != null) {
            this.gtR.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.af.a
    public void dY(int i) {
        if (this.gtR != null) {
            this.gtR.setVisibility(i);
        }
    }

    @Override // com.baidu.live.af.a
    public void t(ViewGroup viewGroup) {
        this.gtZ = viewGroup;
    }

    @Override // com.baidu.live.af.a
    public void a(com.baidu.live.i.a aVar) {
        this.gtX = aVar;
    }

    @Override // com.baidu.live.af.a
    public void QE() {
        if (this.gtT == null) {
            this.gtT = new c(this.mContext, this.guh);
        } else {
            this.gtT.bQl();
        }
        this.gtT.show();
    }

    @Override // com.baidu.live.af.a
    public void cV(boolean z) {
        this.guc = z;
    }

    @Override // com.baidu.live.af.a
    public void setLiveShowInfo(ab abVar) {
        this.aDd = abVar;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.gug = fe(this.aDd.mLiveInfo.live_id);
            if (this.gug != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.gug) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.af.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.gtV != null) {
                this.gtV.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtV.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gtV.setLayoutParams(layoutParams);
                    this.gtV.setBottom(0);
                }
            }
        } else if (this.gtV != null && this.gtZ != null) {
            if (this.gtZ.indexOfChild(this.gtV) >= 0) {
                this.gtZ.removeView(this.gtV);
            }
            this.gtV.setVisibility(8);
            this.gtW = null;
            if (this.gtU != null) {
                this.gtU.QH();
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
        this.gtU = interfaceC0156a;
    }

    @Override // com.baidu.live.af.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gtV != null) {
            this.gtV.unRegisterListener();
            this.gtV = null;
        }
        if (this.gtT != null) {
            this.gtT.unRegisterListener();
            this.gtT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.guj);
        MessageManager.getInstance().unRegisterListener(this.guk);
        MessageManager.getInstance().unRegisterListener(this.gul);
        MessageManager.getInstance().unRegisterListener(this.gum);
        MessageManager.getInstance().unRegisterListener(this.guo);
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
    public void FK(String str) {
        if (this.gtV == null) {
            this.gtV = new AlaTextStickerEditView(this.mContext);
            this.gtV.setLiveShowInfo(this.aDd);
            this.gtV.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void FL(String str2) {
                    if (str2 != null && b.this.gtW != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bPZ()) {
                        b.this.gtW.setText(str2);
                        long j = b.this.aDd.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.gtW.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bQi() {
                }
            });
        }
        if (this.gtZ != null) {
            if (this.gtZ.indexOfChild(this.gtV) >= 0) {
                this.gtZ.removeView(this.gtV);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.gtV.setVisibility(0);
            this.gtZ.addView(this.gtV, layoutParams);
            this.gtV.FN(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQd() {
        if (this.gtR == null) {
            this.gtR = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gtS == null) {
            this.gtS = new AlaStickerDragDeletePanelView(this.mContext);
            this.gtS.setVisibility(8);
        }
        if (this.gtR.getParent() == null) {
            this.gtR.by(this.gtY.getWidth(), this.gtY.getHeight() - this.gdL);
            this.gtY.addView(this.gtR, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gtS.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.gtU != null) {
                this.gtS.setDeleteBottomHeight(this.gtU.QJ());
                this.gtS.setTopDeletePanelHeight(this.gtU.QI());
            }
            this.gua.addView(this.gtS, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQe() {
        if (this.gtR.getChildCount() == 0) {
            if (this.gtR != null) {
                ((ViewGroup) this.gtR.getParent()).removeView(this.gtR);
            }
            if (this.gtS != null) {
                ((ViewGroup) this.gtS.getParent()).removeView(this.gtS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gtR != null) {
            return this.gtR.a(i, bitmap, i2, this.gui, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gtR != null) {
            this.gtR.b(i, bitmap, i2, this.gui, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
        if (this.gtR != null) {
            this.gtR.ch(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Map<String, Integer> map) {
        if (this.gsy != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gsy.size()) {
                    break;
                }
                hashMap.put(this.gsy.get(i2).id, this.gsy.get(i2));
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
                        if (b.this.gud != null) {
                            b.this.gud.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bPJ().isRunning(fuFaceItem.file)) {
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
                        if (b.this.gud != null) {
                            b.this.gud.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.gud != null && b.this.gud.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.gud.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.gud.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.gud.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bQf() {
        FuFaceItem fuFaceItem;
        if (!this.guf) {
            if (this.gue != null) {
                fuFaceItem = this.gue;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gsy.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gsy.get(i2);
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
            this.guf = true;
            this.guh.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.gtR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gtR.getChildCount()) {
                    break;
                }
                View childAt = this.gtR.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gsB || alaLiveStickerInfo.id == dVar.gsB.id) {
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
                        b.this.bQd();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
