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
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.w.a;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.SetPicTxtStickerHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.a.g;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
import com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.w.a {
    private q avf;
    private List<FuFaceItem> fmf;
    private AlaTextStickerEditView fnA;
    private DragTextView fnB;
    private com.baidu.live.g.a fnC;
    private ViewGroup fnD;
    private ViewGroup fnE;
    private ViewGroup fnF;
    private Map<String, Integer> fnI;
    private FuFaceItem fnJ;
    private List<AlaLiveStickerInfo> fnL;
    private AlaStickerDragContentView fnw;
    private AlaStickerDragDeletePanelView fnx;
    private c fny;
    private a.InterfaceC0194a fnz;
    private Context mContext;
    private int fnG = 0;
    private int fap = 0;
    private boolean eBy = true;
    private Handler mHandler = new Handler();
    private boolean fnH = false;
    private boolean fnK = true;
    private c.a fnM = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public boolean bvT() {
            return b.this.fnK;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fnJ = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fnH) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fnw != null && b.this.fnw.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bvL()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bvQ();
                    b.this.fnB = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.avf.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fnz != null) {
                b.this.fnz.G(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bvU() {
        }
    };
    private Runnable exL = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.eBy = true;
        }
    };
    private e fnN = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.eBy) {
                b.this.eBy = false;
                b.this.mHandler.postDelayed(b.this.exL, 600L);
                if (view instanceof DragTextView) {
                    b.this.fnB = (DragTextView) view;
                    if (b.this.fnz != null) {
                        b.this.fnz.HE();
                    }
                    b.this.BU(b.this.fnB.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fnx != null) {
                b.this.fnx.setVisibility(8);
                b.this.fnx.jV(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fnx.getTopDeletePanelBottom()) {
                    if (b.this.fnC != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bvL()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fnw.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fnw.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fnw.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fnw.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.avf.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bvL()) {
                        ((DragTextView) view).bwc();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.avf.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fnx != null) {
                b.this.fnx.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fnx.getTopDeletePanelBottom()) {
                    b.this.fnx.jV(true);
                } else {
                    b.this.fnx.jV(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bvW() {
            int i;
            int i2;
            if (b.this.fnz != null) {
                b.this.fap = b.this.fnz.HH();
                b.this.fnG = b.this.fnz.HG();
                int HI = b.this.fnz.HI();
                int imMsgListViewHeight = b.this.fnz.getImMsgListViewHeight();
                b.this.fnx.setDeleteBottomHeight(b.this.fap);
                b.this.fnx.setTopDeletePanelHeight(b.this.fnG);
                b.this.fnx.setImMsgViewSize(HI, imMsgListViewHeight);
                i2 = HI;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fnw != null) {
                int width = b.this.fnD.getWidth();
                int height = b.this.fnD.getHeight() - b.this.fap;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fnw.bs(width, height);
                for (int i3 = 0; i3 < b.this.fnw.getChildCount(); i3++) {
                    View childAt = b.this.fnw.getChildAt(i3);
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
            if (b.this.fnx != null) {
                b.this.fnx.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bvX() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bvL();
        }
    };
    private HttpMessageListener fnO = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fmf = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fmf;
                if (b.this.fmf != null && !b.this.fmf.isEmpty() && b.this.fnI != null && !b.this.fnI.isEmpty()) {
                    b.this.s(b.this.fnI);
                }
            }
        }
    };
    private HttpMessageListener fnP = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bvK();
                BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.sdk_net_fail_tip));
                if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) && (dVar = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage()) != null) {
                    DragTextView a = b.this.a(dVar);
                    if (dVar.mRequestType == 1) {
                        if (a != null && a.getParent() != null) {
                            ((ViewGroup) a.getParent()).removeView(a);
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 2) {
                        if (a != null) {
                            a.bwc();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a != null) {
                        a.bwc();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bvK();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a2 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a2 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a2.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fnL == null) {
                                b.this.fnL = new LinkedList();
                            }
                            b.this.fnL.add(alaLiveStickerInfo);
                            b.this.a(b.this.avf.mLiveInfo.live_id, b.this.fnL);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a2 != null && a2.getParent() != null) {
                                ((ViewGroup) a2.getParent()).removeView(a2);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a2.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fmi.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fmi.centerY;
                        alaLiveStickerInfo2.text = dVar2.fmi.text;
                        b.this.a(b.this.avf.mLiveInfo.live_id, b.this.fnL);
                    } else if (dVar2.mRequestType == 3 && a2 != null) {
                        b.this.fnL.remove((AlaLiveStickerInfo) a2.getTag());
                        b.this.a(b.this.avf.mLiveInfo.live_id, b.this.fnL);
                        b.this.bC(a2);
                        b.this.bvR();
                        if (b.this.fnC != null) {
                            b.this.fnC.L(a2);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fnB = null;
        }
    };
    CustomMessageListener fnQ = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fnI = hashMap;
                    if (b.this.fmf != null && !b.this.fmf.isEmpty()) {
                        b.this.s(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.f.HD();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fnR = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fmf != null) {
                    for (int i = 0; i < b.this.fmf.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fmf.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fnK = false;
                    if (b.this.fnz != null) {
                        b.this.fnz.G(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.v.a.Hs().aZn.aBn;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fnS, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fnS = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bvS();
        }
    };
    CustomMessageListener fnT = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fnS);
                b.this.bvS();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fnO);
        MessageManager.getInstance().registerListener(this.fnP);
        MessageManager.getInstance().registerListener(this.fnQ);
        MessageManager.getInstance().registerListener(this.fnR);
        MessageManager.getInstance().registerListener(this.fnT);
    }

    @Override // com.baidu.live.w.a
    public void p(ViewGroup viewGroup) {
        this.fnD = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void q(ViewGroup viewGroup) {
        this.fnF = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cP(int i) {
        this.fap = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.fnw != null) {
            this.fnw.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void cQ(int i) {
        if (this.fnw != null) {
            this.fnw.setVisibility(i);
        }
    }

    @Override // com.baidu.live.w.a
    public void r(ViewGroup viewGroup) {
        this.fnE = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.fnC = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.fny == null) {
            this.fny = new c(this.mContext, this.fnM);
        } else {
            this.fny.bvY();
        }
        this.fny.show();
    }

    @Override // com.baidu.live.w.a
    public void ce(boolean z) {
        this.fnH = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(q qVar) {
        this.avf = qVar;
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.fnL = dC(this.avf.mLiveInfo.live_id);
            if (this.fnL != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fnL) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fnA != null) {
                this.fnA.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fnA.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fnA.setLayoutParams(layoutParams);
                    this.fnA.setBottom(0);
                }
            }
        } else if (this.fnA != null && this.fnE != null) {
            if (this.fnE.indexOfChild(this.fnA) >= 0) {
                this.fnE.removeView(this.fnA);
            }
            this.fnA.setVisibility(8);
            this.fnB = null;
            if (this.fnz != null) {
                this.fnz.HF();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void HD() {
        com.baidu.tieba.ala.alaar.sticker.a.f.HD();
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.fnz = interfaceC0194a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fnA != null) {
            this.fnA.unRegisterListener();
            this.fnA = null;
        }
        if (this.fny != null) {
            this.fny.unRegisterListener();
            this.fny = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fnO);
        MessageManager.getInstance().unRegisterListener(this.fnP);
        MessageManager.getInstance().unRegisterListener(this.fnQ);
        MessageManager.getInstance().unRegisterListener(this.fnR);
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU(String str) {
        if (this.fnA == null) {
            this.fnA = new AlaTextStickerEditView(this.mContext);
            this.fnA.setLiveShowInfo(this.avf);
            this.fnA.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void BV(String str2) {
                    if (str2 != null && b.this.fnB != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bvL()) {
                        b.this.fnB.setText(str2);
                        long j = b.this.avf.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fnB.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bvV() {
                }
            });
        }
        if (this.fnE != null) {
            if (this.fnE.indexOfChild(this.fnA) >= 0) {
                this.fnE.removeView(this.fnA);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fnA.setVisibility(0);
            this.fnE.addView(this.fnA, layoutParams);
            this.fnA.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvQ() {
        if (this.fnw == null) {
            this.fnw = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fnx == null) {
            this.fnx = new AlaStickerDragDeletePanelView(this.mContext);
            this.fnx.setVisibility(8);
        }
        if (this.fnw.getParent() == null) {
            this.fnw.bs(this.fnD.getWidth(), this.fnD.getHeight() - this.fap);
            this.fnD.addView(this.fnw, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fnx.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fnz != null) {
                this.fnx.setDeleteBottomHeight(this.fnz.HH());
                this.fnx.setTopDeletePanelHeight(this.fnz.HG());
            }
            this.fnF.addView(this.fnx, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvR() {
        if (this.fnw.getChildCount() == 0) {
            if (this.fnw != null) {
                ((ViewGroup) this.fnw.getParent()).removeView(this.fnw);
            }
            if (this.fnx != null) {
                ((ViewGroup) this.fnx.getParent()).removeView(this.fnx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fnw != null) {
            return this.fnw.a(i, bitmap, i2, this.fnN, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fnw != null) {
            this.fnw.b(i, bitmap, i2, this.fnN, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(View view) {
        if (this.fnw != null) {
            this.fnw.bD(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Integer> map) {
        if (this.fmf != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fmf.size()) {
                    break;
                }
                hashMap.put(this.fmf.get(i2).id, this.fmf.get(i2));
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
                        if (b.this.fnI != null) {
                            b.this.fnI.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bvx().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(fuFaceItem, new g.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: b */
                    public void av(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: c */
                    public void aw(FuFaceItem fuFaceItem2) {
                        if (b.this.fnI != null) {
                            b.this.fnI.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fnI != null && b.this.fnI.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fnI.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fnI.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fnI.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bvS() {
        FuFaceItem fuFaceItem;
        if (!this.fnK) {
            if (this.fnJ != null) {
                fuFaceItem = this.fnJ;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fmf.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fmf.get(i2);
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
            this.fnK = true;
            this.fnM.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fnw != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fnw.getChildCount()) {
                    break;
                }
                View childAt = this.fnw.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fmi || alaLiveStickerInfo.id == dVar.fmi.id) {
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
            com.baidu.live.c.vf().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.c.vf().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> dC(long j) {
        String string = com.baidu.live.c.vf().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bvQ();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
