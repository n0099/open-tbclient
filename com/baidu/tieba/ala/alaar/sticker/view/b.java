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
import com.baidu.live.ag.a;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.x;
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
public class b implements com.baidu.live.ag.a {
    private x aBr;
    private List<FuFaceItem> gpO;
    private AlaStickerDragContentView grh;
    private AlaStickerDragDeletePanelView gri;
    private c grj;
    private a.InterfaceC0156a grk;
    private AlaTextStickerEditView grl;
    private DragTextView grm;
    private com.baidu.live.j.a grn;
    private ViewGroup gro;
    private ViewGroup grp;
    private ViewGroup grq;
    private Map<String, Integer> grt;
    private FuFaceItem gru;
    private List<AlaLiveStickerInfo> grw;
    private Context mContext;
    private int grr = 0;
    private int gbw = 0;
    private boolean fAA = true;
    private Handler mHandler = new Handler();
    private boolean grs = false;
    private boolean grv = true;
    private c.b grx = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> grF = new ArrayList();
        FuFaceItem grG;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bPC() {
            return b.this.grv;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gru = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.grF.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.grs) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.grh != null && b.this.grh.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bPv()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bPz();
                    b.this.grm = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aBr.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.grG = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.grk != null) {
                    b.this.grk.F(fuFaceItem.getSticker());
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
        public void bPD() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.grF.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.grF.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.grF.clear();
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
            if (this.grG != null && !TextUtils.isEmpty(this.grG.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.grG.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.q("arssticker_suc", jSONObject3);
            }
            this.grG = null;
        }
    };
    private Runnable fwx = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fAA = true;
        }
    };
    private e gry = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fAA) {
                b.this.fAA = false;
                b.this.mHandler.postDelayed(b.this.fwx, 600L);
                if (view instanceof DragTextView) {
                    b.this.grm = (DragTextView) view;
                    if (b.this.grk != null) {
                        b.this.grk.Pf();
                    }
                    b.this.Fm(b.this.grm.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void g(View view, int i, int i2, int i3, int i4) {
            if (b.this.gri != null) {
                b.this.gri.setVisibility(8);
                b.this.gri.mi(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gri.getTopDeletePanelBottom()) {
                    if (b.this.grn != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bPv()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.grh.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.grh.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.grh.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.grh.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aBr.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bPv()) {
                        ((DragTextView) view).bPO();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aBr.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void C(int i, int i2, int i3, int i4) {
            if (b.this.gri != null) {
                b.this.gri.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gri.getTopDeletePanelBottom()) {
                    b.this.gri.mi(true);
                } else {
                    b.this.gri.mi(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bPF() {
            int i;
            int i2;
            if (b.this.grk != null) {
                b.this.gbw = b.this.grk.Pi();
                b.this.grr = b.this.grk.Ph();
                i2 = b.this.grk.Pj();
                int imMsgListViewHeight = b.this.grk.getImMsgListViewHeight();
                b.this.gri.setDeleteBottomHeight(b.this.gbw);
                b.this.gri.setTopDeletePanelHeight(b.this.grr);
                b.this.gri.setImMsgViewSize(i2, imMsgListViewHeight);
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.grh != null) {
                int width = b.this.gro.getWidth();
                int height = b.this.gro.getHeight() - b.this.gbw;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.grh.bB(width, height);
                for (int i3 = 0; i3 < b.this.grh.getChildCount(); i3++) {
                    View childAt = b.this.grh.getChildAt(i3);
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
            if (b.this.gri != null) {
                b.this.gri.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bPG() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bPv();
        }
    };
    private HttpMessageListener grz = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gpO = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gpO;
                if (b.this.gpO != null && !b.this.gpO.isEmpty() && b.this.grt != null && !b.this.grt.isEmpty()) {
                    b.this.D(b.this.grt);
                }
            }
        }
    };
    private HttpMessageListener grA = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bPu();
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
                            a2.bPO();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bPO();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bPu();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.grw == null) {
                                b.this.grw = new LinkedList();
                            }
                            b.this.grw.add(alaLiveStickerInfo);
                            b.this.a(b.this.aBr.mLiveInfo.live_id, b.this.grw);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gpR.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gpR.centerY;
                        alaLiveStickerInfo2.text = dVar2.gpR.text;
                        b.this.a(b.this.aBr.mLiveInfo.live_id, b.this.grw);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.grw.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aBr.mLiveInfo.live_id, b.this.grw);
                        b.this.ck(a3);
                        b.this.bPA();
                        if (b.this.grn != null) {
                            b.this.grn.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.grm = null;
        }
    };
    CustomMessageListener grB = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.grt = hashMap;
                    if (b.this.gpO != null && !b.this.gpO.isEmpty()) {
                        b.this.D(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.Pe();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener grC = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gpO != null) {
                    for (int i = 0; i < b.this.gpO.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gpO.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.grv = false;
                    if (b.this.grk != null) {
                        b.this.grk.F(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.af.a.OJ().bru.aJv;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.grD, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable grD = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bPB();
        }
    };
    CustomMessageListener grE = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.grD);
                b.this.bPB();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.grz);
        MessageManager.getInstance().registerListener(this.grA);
        MessageManager.getInstance().registerListener(this.grB);
        MessageManager.getInstance().registerListener(this.grC);
        MessageManager.getInstance().registerListener(this.grE);
    }

    @Override // com.baidu.live.ag.a
    public void t(ViewGroup viewGroup) {
        this.gro = viewGroup;
    }

    @Override // com.baidu.live.ag.a
    public void u(ViewGroup viewGroup) {
        this.grq = viewGroup;
    }

    @Override // com.baidu.live.ag.a
    public void dT(int i) {
        this.gbw = i;
    }

    @Override // com.baidu.live.ag.a
    public void setStickerCanOperate(boolean z) {
        if (this.grh != null) {
            this.grh.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.ag.a
    public void dU(int i) {
        if (this.grh != null) {
            this.grh.setVisibility(i);
        }
    }

    @Override // com.baidu.live.ag.a
    public void v(ViewGroup viewGroup) {
        this.grp = viewGroup;
    }

    @Override // com.baidu.live.ag.a
    public void a(com.baidu.live.j.a aVar) {
        this.grn = aVar;
    }

    @Override // com.baidu.live.ag.a
    public void Pd() {
        if (this.grj == null) {
            this.grj = new c(this.mContext, this.grx);
        } else {
            this.grj.bPH();
        }
        this.grj.show();
    }

    @Override // com.baidu.live.ag.a
    public void cM(boolean z) {
        this.grs = z;
    }

    @Override // com.baidu.live.ag.a
    public void setLiveShowInfo(x xVar) {
        this.aBr = xVar;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            this.grw = eY(this.aBr.mLiveInfo.live_id);
            if (this.grw != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.grw) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.ag.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.grl != null) {
                this.grl.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grl.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.grl.setLayoutParams(layoutParams);
                    this.grl.setBottom(0);
                }
            }
        } else if (this.grl != null && this.grp != null) {
            if (this.grp.indexOfChild(this.grl) >= 0) {
                this.grp.removeView(this.grl);
            }
            this.grl.setVisibility(8);
            this.grm = null;
            if (this.grk != null) {
                this.grk.Pg();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.ag.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.ag.a
    public void Pe() {
        com.baidu.tieba.ala.alaar.sticker.a.g.Pe();
    }

    @Override // com.baidu.live.ag.a
    public void a(a.InterfaceC0156a interfaceC0156a) {
        this.grk = interfaceC0156a;
    }

    @Override // com.baidu.live.ag.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.grl != null) {
            this.grl.unRegisterListener();
            this.grl = null;
        }
        if (this.grj != null) {
            this.grj.unRegisterListener();
            this.grj = null;
        }
        MessageManager.getInstance().unRegisterListener(this.grz);
        MessageManager.getInstance().unRegisterListener(this.grA);
        MessageManager.getInstance().unRegisterListener(this.grB);
        MessageManager.getInstance().unRegisterListener(this.grC);
        MessageManager.getInstance().unRegisterListener(this.grE);
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
    public void Fm(String str) {
        if (this.grl == null) {
            this.grl = new AlaTextStickerEditView(this.mContext);
            this.grl.setLiveShowInfo(this.aBr);
            this.grl.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Fn(String str2) {
                    if (str2 != null && b.this.grm != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bPv()) {
                        b.this.grm.setText(str2);
                        long j = b.this.aBr.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.grm.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bPE() {
                }
            });
        }
        if (this.grp != null) {
            if (this.grp.indexOfChild(this.grl) >= 0) {
                this.grp.removeView(this.grl);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.grl.setVisibility(0);
            this.grp.addView(this.grl, layoutParams);
            this.grl.Fp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPz() {
        if (this.grh == null) {
            this.grh = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gri == null) {
            this.gri = new AlaStickerDragDeletePanelView(this.mContext);
            this.gri.setVisibility(8);
        }
        if (this.grh.getParent() == null) {
            this.grh.bB(this.gro.getWidth(), this.gro.getHeight() - this.gbw);
            this.gro.addView(this.grh, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gri.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.grk != null) {
                this.gri.setDeleteBottomHeight(this.grk.Pi());
                this.gri.setTopDeletePanelHeight(this.grk.Ph());
            }
            this.grq.addView(this.gri, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPA() {
        if (this.grh.getChildCount() == 0) {
            if (this.grh != null) {
                ((ViewGroup) this.grh.getParent()).removeView(this.grh);
            }
            if (this.gri != null) {
                ((ViewGroup) this.gri.getParent()).removeView(this.gri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.grh != null) {
            return this.grh.a(i, bitmap, i2, this.gry, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.grh != null) {
            this.grh.b(i, bitmap, i2, this.gry, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(View view) {
        if (this.grh != null) {
            this.grh.cl(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Map<String, Integer> map) {
        if (this.gpO != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gpO.size()) {
                    break;
                }
                hashMap.put(this.gpO.get(i2).id, this.gpO.get(i2));
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
                        if (b.this.grt != null) {
                            b.this.grt.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bPf().isRunning(fuFaceItem.file)) {
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
                        if (b.this.grt != null) {
                            b.this.grt.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.grt != null && b.this.grt.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.grt.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.grt.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.grt.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bPB() {
        FuFaceItem fuFaceItem;
        if (!this.grv) {
            if (this.gru != null) {
                fuFaceItem = this.gru;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gpO.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gpO.get(i2);
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
            this.grv = true;
            this.grx.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.grh != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.grh.getChildCount()) {
                    break;
                }
                View childAt = this.grh.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gpR || alaLiveStickerInfo.id == dVar.gpR.id) {
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

    private List<AlaLiveStickerInfo> eY(long j) {
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
                        b.this.bPz();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
