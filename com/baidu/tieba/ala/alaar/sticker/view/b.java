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
    private w aDh;
    private List<FuFaceItem> gbJ;
    private AlaStickerDragContentView gdf;
    private AlaStickerDragDeletePanelView gdg;
    private c gdh;
    private a.InterfaceC0166a gdi;
    private AlaTextStickerEditView gdj;
    private DragTextView gdk;
    private com.baidu.live.g.a gdl;
    private ViewGroup gdm;
    private ViewGroup gdn;
    private ViewGroup gdo;
    private Map<String, Integer> gdr;
    private FuFaceItem gds;
    private List<AlaLiveStickerInfo> gdu;
    private Context mContext;
    private int gdp = 0;
    private int fOJ = 0;
    private boolean fnY = true;
    private Handler mHandler = new Handler();
    private boolean gdq = false;
    private boolean gdt = true;
    private c.b gdv = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        List<PicStickerItem> gdD = new ArrayList();
        FuFaceItem gdE;

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bNj() {
            return b.this.gdt;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            String str2;
            String str3;
            b.this.gds = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                this.gdD.add((PicStickerItem) fuFaceItem);
                str2 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_clk" : "textsticker_clk";
                str3 = ((PicStickerItem) fuFaceItem).sticker_type == 1 ? "picsticker_id" : "textsticker_id";
                if (b.this.gdq) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_master_live_unable_sticker);
                    a(fuFaceItem, str2, str3);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.gdf != null && b.this.gdf.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.h.ala_live_sticker_max_striker);
                    a(fuFaceItem, str2, str3);
                    return;
                } else if (com.baidu.tieba.ala.alaar.sticker.a.g.bNb()) {
                    a(fuFaceItem, str2, str3);
                    return;
                } else {
                    int i = a.c.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bNg();
                    b.this.gdk = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDh.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else {
                this.gdE = fuFaceItem;
                str2 = "arssticker_clk";
                str3 = "arssticker_id";
                if (b.this.gdi != null) {
                    b.this.gdi.J(fuFaceItem.getSticker());
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
        public void bNk() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void onCompleted() {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gdD.size()) {
                    break;
                }
                PicStickerItem picStickerItem = this.gdD.get(i2);
                if (picStickerItem != null) {
                    if (picStickerItem.sticker_type == 1) {
                        jSONArray.put(picStickerItem.getId());
                    } else {
                        jSONArray2.put(picStickerItem.getId());
                    }
                }
                i = i2 + 1;
            }
            this.gdD.clear();
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
            if (this.gdE != null && !TextUtils.isEmpty(this.gdE.getId())) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("arssticker_id", this.gdE.getId());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b.this.p("arssticker_suc", jSONObject3);
            }
            this.gdE = null;
        }
    };
    private Runnable fka = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.fnY = true;
        }
    };
    private e gdw = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.fnY) {
                b.this.fnY = false;
                b.this.mHandler.postDelayed(b.this.fka, 600L);
                if (view instanceof DragTextView) {
                    b.this.gdk = (DragTextView) view;
                    if (b.this.gdi != null) {
                        b.this.gdi.PC();
                    }
                    b.this.FL(b.this.gdk.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.gdg != null) {
                b.this.gdg.setVisibility(8);
                b.this.gdg.lu(false);
                if (((i4 - i2) / 5) + i2 >= b.this.gdg.getTopDeletePanelBottom()) {
                    if (b.this.gdl != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.g.bNb()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.gdf.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.gdf.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.gdf.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.gdf.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDh.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.g.bNb()) {
                        ((DragTextView) view).bNv();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.g.a(b.this.aDh.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void x(int i, int i2, int i3, int i4) {
            if (b.this.gdg != null) {
                b.this.gdg.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.gdg.getTopDeletePanelBottom()) {
                    b.this.gdg.lu(true);
                } else {
                    b.this.gdg.lu(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bNm() {
            int i;
            int i2;
            if (b.this.gdi != null) {
                b.this.fOJ = b.this.gdi.PF();
                b.this.gdp = b.this.gdi.PE();
                int PG = b.this.gdi.PG();
                int imMsgListViewHeight = b.this.gdi.getImMsgListViewHeight();
                b.this.gdg.setDeleteBottomHeight(b.this.fOJ);
                b.this.gdg.setTopDeletePanelHeight(b.this.gdp);
                b.this.gdg.setImMsgViewSize(PG, imMsgListViewHeight);
                i2 = PG;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.gdf != null) {
                int width = b.this.gdm.getWidth();
                int height = b.this.gdm.getHeight() - b.this.fOJ;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.gdf.bB(width, height);
                for (int i3 = 0; i3 < b.this.gdf.getChildCount(); i3++) {
                    View childAt = b.this.gdf.getChildAt(i3);
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
            if (b.this.gdg != null) {
                b.this.gdg.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bNn() {
            return !com.baidu.tieba.ala.alaar.sticker.a.g.bNb();
        }
    };
    private HttpMessageListener gdx = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.gbJ = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).gbJ;
                if (b.this.gbJ != null && !b.this.gbJ.isEmpty() && b.this.gdr != null && !b.this.gdr.isEmpty()) {
                    b.this.C(b.this.gdr);
                }
            }
        }
    };
    private HttpMessageListener gdy = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.g.bNa();
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
                            a2.bNv();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bNv();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.g.bNa();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.gdu == null) {
                                b.this.gdu = new LinkedList();
                            }
                            b.this.gdu.add(alaLiveStickerInfo);
                            b.this.a(b.this.aDh.mLiveInfo.live_id, b.this.gdu);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.h.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.gbM.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.gbM.centerY;
                        alaLiveStickerInfo2.text = dVar2.gbM.text;
                        b.this.a(b.this.aDh.mLiveInfo.live_id, b.this.gdu);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.gdu.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aDh.mLiveInfo.live_id, b.this.gdu);
                        b.this.bU(a3);
                        b.this.bNh();
                        if (b.this.gdl != null) {
                            b.this.gdl.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.gdk = null;
        }
    };
    CustomMessageListener gdz = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.gdr = hashMap;
                    if (b.this.gbJ != null && !b.this.gbJ.isEmpty()) {
                        b.this.C(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.g.PB();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener gdA = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.gbJ != null) {
                    for (int i = 0; i < b.this.gbJ.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.gbJ.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.gdt = false;
                    if (b.this.gdi != null) {
                        b.this.gdi.J(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.aa.a.Ph().bms.aKJ;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.gdB, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable gdB = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bNi();
        }
    };
    CustomMessageListener gdC = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.gdB);
                b.this.bNi();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gdx);
        MessageManager.getInstance().registerListener(this.gdy);
        MessageManager.getInstance().registerListener(this.gdz);
        MessageManager.getInstance().registerListener(this.gdA);
        MessageManager.getInstance().registerListener(this.gdC);
    }

    @Override // com.baidu.live.ab.a
    public void q(ViewGroup viewGroup) {
        this.gdm = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void r(ViewGroup viewGroup) {
        this.gdo = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void fa(int i) {
        this.fOJ = i;
    }

    @Override // com.baidu.live.ab.a
    public void setStickerCanOperate(boolean z) {
        if (this.gdf != null) {
            this.gdf.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.ab.a
    public void fb(int i) {
        if (this.gdf != null) {
            this.gdf.setVisibility(i);
        }
    }

    @Override // com.baidu.live.ab.a
    public void s(ViewGroup viewGroup) {
        this.gdn = viewGroup;
    }

    @Override // com.baidu.live.ab.a
    public void a(com.baidu.live.g.a aVar) {
        this.gdl = aVar;
    }

    @Override // com.baidu.live.ab.a
    public void PA() {
        if (this.gdh == null) {
            this.gdh = new c(this.mContext, this.gdv);
        } else {
            this.gdh.bNo();
        }
        this.gdh.show();
    }

    @Override // com.baidu.live.ab.a
    public void cz(boolean z) {
        this.gdq = z;
    }

    @Override // com.baidu.live.ab.a
    public void setLiveShowInfo(w wVar) {
        this.aDh = wVar;
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            this.gdu = ev(this.aDh.mLiveInfo.live_id);
            if (this.gdu != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.gdu) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.ab.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.gdj != null) {
                this.gdj.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdj.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gdj.setLayoutParams(layoutParams);
                    this.gdj.setBottom(0);
                }
            }
        } else if (this.gdj != null && this.gdn != null) {
            if (this.gdn.indexOfChild(this.gdj) >= 0) {
                this.gdn.removeView(this.gdj);
            }
            this.gdj.setVisibility(8);
            this.gdk = null;
            if (this.gdi != null) {
                this.gdi.PD();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.ab.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.ab.a
    public void PB() {
        com.baidu.tieba.ala.alaar.sticker.a.g.PB();
    }

    @Override // com.baidu.live.ab.a
    public void a(a.InterfaceC0166a interfaceC0166a) {
        this.gdi = interfaceC0166a;
    }

    @Override // com.baidu.live.ab.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gdj != null) {
            this.gdj.unRegisterListener();
            this.gdj = null;
        }
        if (this.gdh != null) {
            this.gdh.unRegisterListener();
            this.gdh = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gdx);
        MessageManager.getInstance().unRegisterListener(this.gdy);
        MessageManager.getInstance().unRegisterListener(this.gdz);
        MessageManager.getInstance().unRegisterListener(this.gdA);
        MessageManager.getInstance().unRegisterListener(this.gdC);
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
    public void FL(String str) {
        if (this.gdj == null) {
            this.gdj = new AlaTextStickerEditView(this.mContext);
            this.gdj.setLiveShowInfo(this.aDh);
            this.gdj.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void FM(String str2) {
                    if (str2 != null && b.this.gdk != null && !com.baidu.tieba.ala.alaar.sticker.a.g.bNb()) {
                        b.this.gdk.setText(str2);
                        long j = b.this.aDh.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.gdk.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.g.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bNl() {
                }
            });
        }
        if (this.gdn != null) {
            if (this.gdn.indexOfChild(this.gdj) >= 0) {
                this.gdn.removeView(this.gdj);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.gdj.setVisibility(0);
            this.gdn.addView(this.gdj, layoutParams);
            this.gdj.FO(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNg() {
        if (this.gdf == null) {
            this.gdf = new AlaStickerDragContentView(this.mContext);
        }
        if (this.gdg == null) {
            this.gdg = new AlaStickerDragDeletePanelView(this.mContext);
            this.gdg.setVisibility(8);
        }
        if (this.gdf.getParent() == null) {
            this.gdf.bB(this.gdm.getWidth(), this.gdm.getHeight() - this.fOJ);
            this.gdm.addView(this.gdf, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.gdg.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.gdi != null) {
                this.gdg.setDeleteBottomHeight(this.gdi.PF());
                this.gdg.setTopDeletePanelHeight(this.gdi.PE());
            }
            this.gdo.addView(this.gdg, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNh() {
        if (this.gdf.getChildCount() == 0) {
            if (this.gdf != null) {
                ((ViewGroup) this.gdf.getParent()).removeView(this.gdf);
            }
            if (this.gdg != null) {
                ((ViewGroup) this.gdg.getParent()).removeView(this.gdg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gdf != null) {
            return this.gdf.a(i, bitmap, i2, this.gdw, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.gdf != null) {
            this.gdf.b(i, bitmap, i2, this.gdw, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(View view) {
        if (this.gdf != null) {
            this.gdf.bV(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.gbJ != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gbJ.size()) {
                    break;
                }
                hashMap.put(this.gbJ.get(i2).id, this.gbJ.get(i2));
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
                        if (b.this.gdr != null) {
                            b.this.gdr.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bML().isRunning(fuFaceItem.file)) {
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
                        if (b.this.gdr != null) {
                            b.this.gdr.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.gdr != null && b.this.gdr.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.gdr.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.gdr.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.gdr.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bNi() {
        FuFaceItem fuFaceItem;
        if (!this.gdt) {
            if (this.gds != null) {
                fuFaceItem = this.gds;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gbJ.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.gbJ.get(i2);
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
            this.gdt = true;
            this.gdv.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.gdf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gdf.getChildCount()) {
                    break;
                }
                View childAt = this.gdf.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.gbM || alaLiveStickerInfo.id == dVar.gbM.id) {
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
            com.baidu.live.d.Aq().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.d.Aq().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> ev(long j) {
        String string = com.baidu.live.d.Aq().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bNg();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
