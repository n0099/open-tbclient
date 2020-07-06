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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.w.a {
    private q aLQ;
    private List<FuFaceItem> fgX;
    private Map<String, Integer> fiB;
    private FuFaceItem fiC;
    private List<AlaLiveStickerInfo> fiE;
    private AlaStickerDragContentView fio;
    private AlaStickerDragDeletePanelView fip;
    private c fiq;
    private a.InterfaceC0192a fir;
    private AlaTextStickerEditView fis;
    private DragTextView fit;
    private com.baidu.live.g.a fiu;
    private ViewGroup fiv;
    private ViewGroup fiw;
    private ViewGroup fiy;
    private Context mContext;
    private int fiz = 0;
    private int eTU = 0;
    private boolean evf = true;
    private Handler mHandler = new Handler();
    private boolean fiA = false;
    private boolean fiD = true;
    private c.a fiF = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public boolean bsK() {
            return b.this.fiD;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fiC = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fiA) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fio != null && b.this.fio.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bsC()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bsH();
                    b.this.fit = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aLQ.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fir != null) {
                b.this.fir.G(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bsL() {
        }
    };
    private Runnable ert = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.evf = true;
        }
    };
    private e fiG = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.evf) {
                b.this.evf = false;
                b.this.mHandler.postDelayed(b.this.ert, 600L);
                if (view instanceof DragTextView) {
                    b.this.fit = (DragTextView) view;
                    if (b.this.fir != null) {
                        b.this.fir.Hy();
                    }
                    b.this.Bj(b.this.fit.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fip != null) {
                b.this.fip.setVisibility(8);
                b.this.fip.jr(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fip.getTopDeletePanelBottom()) {
                    if (b.this.fiu != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bsC()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fio.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fio.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fio.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fio.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aLQ.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bsC()) {
                        ((DragTextView) view).bsT();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aLQ.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void v(int i, int i2, int i3, int i4) {
            if (b.this.fip != null) {
                b.this.fip.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fip.getTopDeletePanelBottom()) {
                    b.this.fip.jr(true);
                } else {
                    b.this.fip.jr(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bsN() {
            int i;
            int i2;
            if (b.this.fir != null) {
                b.this.eTU = b.this.fir.HB();
                b.this.fiz = b.this.fir.HA();
                int HC = b.this.fir.HC();
                int imMsgListViewHeight = b.this.fir.getImMsgListViewHeight();
                b.this.fip.setDeleteBottomHeight(b.this.eTU);
                b.this.fip.setTopDeletePanelHeight(b.this.fiz);
                b.this.fip.setImMsgViewSize(HC, imMsgListViewHeight);
                i2 = HC;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fio != null) {
                int width = b.this.fiv.getWidth();
                int height = b.this.fiv.getHeight() - b.this.eTU;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fio.bp(width, height);
                for (int i3 = 0; i3 < b.this.fio.getChildCount(); i3++) {
                    View childAt = b.this.fio.getChildAt(i3);
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
            if (b.this.fip != null) {
                b.this.fip.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bsO() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bsC();
        }
    };
    private HttpMessageListener fiH = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fgX = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fgX;
                if (b.this.fgX != null && !b.this.fgX.isEmpty() && b.this.fiB != null && !b.this.fiB.isEmpty()) {
                    b.this.s(b.this.fiB);
                }
            }
        }
    };
    private HttpMessageListener fiI = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bsB();
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
                            a.bsT();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a != null) {
                        a.bsT();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bsB();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a2 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a2 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a2.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fiE == null) {
                                b.this.fiE = new LinkedList();
                            }
                            b.this.fiE.add(alaLiveStickerInfo);
                            b.this.a(b.this.aLQ.mLiveInfo.live_id, b.this.fiE);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a2 != null && a2.getParent() != null) {
                                ((ViewGroup) a2.getParent()).removeView(a2);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a2.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fha.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fha.centerY;
                        alaLiveStickerInfo2.text = dVar2.fha.text;
                        b.this.a(b.this.aLQ.mLiveInfo.live_id, b.this.fiE);
                    } else if (dVar2.mRequestType == 3 && a2 != null) {
                        b.this.fiE.remove((AlaLiveStickerInfo) a2.getTag());
                        b.this.a(b.this.aLQ.mLiveInfo.live_id, b.this.fiE);
                        b.this.bw(a2);
                        b.this.bsI();
                        if (b.this.fiu != null) {
                            b.this.fiu.I(a2);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fit = null;
        }
    };
    CustomMessageListener fiJ = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fiB = hashMap;
                    if (b.this.fgX != null && !b.this.fgX.isEmpty()) {
                        b.this.s(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.f.Hx();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fiK = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fgX != null) {
                    for (int i = 0; i < b.this.fgX.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fgX.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fiD = false;
                    if (b.this.fir != null) {
                        b.this.fir.G(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.v.a.Hm().aZp.aAa;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fiL, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fiL = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bsJ();
        }
    };
    CustomMessageListener fiM = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fiL);
                b.this.bsJ();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fiH);
        MessageManager.getInstance().registerListener(this.fiI);
        MessageManager.getInstance().registerListener(this.fiJ);
        MessageManager.getInstance().registerListener(this.fiK);
        MessageManager.getInstance().registerListener(this.fiM);
    }

    @Override // com.baidu.live.w.a
    public void o(ViewGroup viewGroup) {
        this.fiv = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void p(ViewGroup viewGroup) {
        this.fiy = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cO(int i) {
        this.fiz = i;
    }

    @Override // com.baidu.live.w.a
    public void cP(int i) {
        this.eTU = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.fio != null) {
            this.fio.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void cQ(int i) {
        if (this.fio != null) {
            this.fio.setVisibility(i);
        }
    }

    @Override // com.baidu.live.w.a
    public void q(ViewGroup viewGroup) {
        this.fiw = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.fiu = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.fiq == null) {
            this.fiq = new c(this.mContext, this.fiF);
        } else {
            this.fiq.bsP();
        }
        this.fiq.show();
    }

    @Override // com.baidu.live.w.a
    public void cc(boolean z) {
        this.fiA = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(q qVar) {
        this.aLQ = qVar;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            this.fiE = m33do(this.aLQ.mLiveInfo.live_id);
            if (this.fiE != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fiE) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fis != null) {
                this.fis.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fis.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fis.setLayoutParams(layoutParams);
                    this.fis.setBottom(0);
                }
            }
        } else if (this.fis != null && this.fiw != null) {
            if (this.fiw.indexOfChild(this.fis) >= 0) {
                this.fiw.removeView(this.fis);
            }
            this.fis.setVisibility(8);
            this.fit = null;
            if (this.fir != null) {
                this.fir.Hz();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void Hx() {
        com.baidu.tieba.ala.alaar.sticker.a.f.Hx();
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0192a interfaceC0192a) {
        this.fir = interfaceC0192a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fis != null) {
            this.fis.unRegisterListener();
            this.fis = null;
        }
        if (this.fiq != null) {
            this.fiq.unRegisterListener();
            this.fiq = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fiH);
        MessageManager.getInstance().unRegisterListener(this.fiI);
        MessageManager.getInstance().unRegisterListener(this.fiJ);
        MessageManager.getInstance().unRegisterListener(this.fiK);
        MessageManager.getInstance().unRegisterListener(this.fiM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(String str) {
        if (this.fis == null) {
            this.fis = new AlaTextStickerEditView(this.mContext);
            this.fis.setLiveShowInfo(this.aLQ);
            this.fis.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Bk(String str2) {
                    if (str2 != null && b.this.fit != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bsC()) {
                        b.this.fit.setText(str2);
                        long j = b.this.aLQ.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fit.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bsM() {
                }
            });
        }
        if (this.fiw != null) {
            if (this.fiw.indexOfChild(this.fis) >= 0) {
                this.fiw.removeView(this.fis);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fis.setVisibility(0);
            this.fiw.addView(this.fis, layoutParams);
            this.fis.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsH() {
        if (this.fio == null) {
            this.fio = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fip == null) {
            this.fip = new AlaStickerDragDeletePanelView(this.mContext);
            this.fip.setVisibility(8);
        }
        if (this.fio.getParent() == null) {
            this.fio.bp(this.fiv.getWidth(), this.fiv.getHeight() - this.eTU);
            this.fiv.addView(this.fio, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fip.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fir != null) {
                this.fip.setDeleteBottomHeight(this.fir.HB());
                this.fip.setTopDeletePanelHeight(this.fir.HA());
            }
            this.fiy.addView(this.fip, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsI() {
        if (this.fio.getChildCount() == 0) {
            if (this.fio != null) {
                ((ViewGroup) this.fio.getParent()).removeView(this.fio);
            }
            if (this.fip != null) {
                ((ViewGroup) this.fip.getParent()).removeView(this.fip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fio != null) {
            return this.fio.a(i, bitmap, i2, this.fiG, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fio != null) {
            this.fio.b(i, bitmap, i2, this.fiG, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(View view) {
        if (this.fio != null) {
            this.fio.bx(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Integer> map) {
        if (this.fgX != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fgX.size()) {
                    break;
                }
                hashMap.put(this.fgX.get(i2).id, this.fgX.get(i2));
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
                        if (b.this.fiB != null) {
                            b.this.fiB.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bso().isRunning(fuFaceItem.file)) {
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
                        if (b.this.fiB != null) {
                            b.this.fiB.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fiB != null && b.this.fiB.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fiB.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fiB.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fiB.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bsJ() {
        FuFaceItem fuFaceItem;
        if (!this.fiD) {
            if (this.fiC != null) {
                fuFaceItem = this.fiC;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fgX.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fgX.get(i2);
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
            this.fiD = true;
            this.fiF.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fio != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fio.getChildCount()) {
                    break;
                }
                View childAt = this.fio.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fha || alaLiveStickerInfo.id == dVar.fha.id) {
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

    /* renamed from: do  reason: not valid java name */
    private List<AlaLiveStickerInfo> m33do(long j) {
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
                        b.this.bsH();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
