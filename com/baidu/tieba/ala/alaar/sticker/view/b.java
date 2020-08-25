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
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.a;
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
/* loaded from: classes7.dex */
public class b implements com.baidu.live.x.a {
    private r aAh;
    private List<FuFaceItem> fxB;
    private AlaStickerDragContentView fyS;
    private AlaStickerDragDeletePanelView fyT;
    private c fyU;
    private a.InterfaceC0202a fyV;
    private AlaTextStickerEditView fyW;
    private DragTextView fyX;
    private com.baidu.live.g.a fyY;
    private ViewGroup fyZ;
    private ViewGroup fza;
    private ViewGroup fzb;
    private Map<String, Integer> fze;
    private FuFaceItem fzf;
    private List<AlaLiveStickerInfo> fzh;
    private Context mContext;
    private int fzc = 0;
    private int flH = 0;
    private boolean eLX = true;
    private Handler mHandler = new Handler();
    private boolean fzd = false;
    private boolean fzg = true;
    private c.b fzi = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bEO() {
            return b.this.fzg;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fzf = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fzd) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fyS != null && b.this.fyS.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bEG()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bEL();
                    b.this.fyX = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAh.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fyV != null) {
                b.this.fyV.H(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bEP() {
        }
    };
    private Runnable eIl = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.eLX = true;
        }
    };
    private e fzj = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.eLX) {
                b.this.eLX = false;
                b.this.mHandler.postDelayed(b.this.eIl, 600L);
                if (view instanceof DragTextView) {
                    b.this.fyX = (DragTextView) view;
                    if (b.this.fyV != null) {
                        b.this.fyV.Nx();
                    }
                    b.this.Eo(b.this.fyX.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fyT != null) {
                b.this.fyT.setVisibility(8);
                b.this.fyT.kt(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fyT.getTopDeletePanelBottom()) {
                    if (b.this.fyY != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bEG()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fyS.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fyS.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fyS.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fyS.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAh.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bEG()) {
                        ((DragTextView) view).bFa();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAh.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fyT != null) {
                b.this.fyT.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fyT.getTopDeletePanelBottom()) {
                    b.this.fyT.kt(true);
                } else {
                    b.this.fyT.kt(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bER() {
            int i;
            int i2;
            if (b.this.fyV != null) {
                b.this.flH = b.this.fyV.NA();
                b.this.fzc = b.this.fyV.Nz();
                int NB = b.this.fyV.NB();
                int imMsgListViewHeight = b.this.fyV.getImMsgListViewHeight();
                b.this.fyT.setDeleteBottomHeight(b.this.flH);
                b.this.fyT.setTopDeletePanelHeight(b.this.fzc);
                b.this.fyT.setImMsgViewSize(NB, imMsgListViewHeight);
                i2 = NB;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fyS != null) {
                int width = b.this.fyZ.getWidth();
                int height = b.this.fyZ.getHeight() - b.this.flH;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fyS.bB(width, height);
                for (int i3 = 0; i3 < b.this.fyS.getChildCount(); i3++) {
                    View childAt = b.this.fyS.getChildAt(i3);
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
            if (b.this.fyT != null) {
                b.this.fyT.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bES() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bEG();
        }
    };
    private HttpMessageListener fzk = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fxB = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fxB;
                if (b.this.fxB != null && !b.this.fxB.isEmpty() && b.this.fze != null && !b.this.fze.isEmpty()) {
                    b.this.s(b.this.fze);
                }
            }
        }
    };
    private HttpMessageListener fzl = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bEF();
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
                            a.bFa();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a != null) {
                        a.bFa();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bEF();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a2 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a2 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a2.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fzh == null) {
                                b.this.fzh = new LinkedList();
                            }
                            b.this.fzh.add(alaLiveStickerInfo);
                            b.this.a(b.this.aAh.mLiveInfo.live_id, b.this.fzh);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a2 != null && a2.getParent() != null) {
                                ((ViewGroup) a2.getParent()).removeView(a2);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a2.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fxE.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fxE.centerY;
                        alaLiveStickerInfo2.text = dVar2.fxE.text;
                        b.this.a(b.this.aAh.mLiveInfo.live_id, b.this.fzh);
                    } else if (dVar2.mRequestType == 3 && a2 != null) {
                        b.this.fzh.remove((AlaLiveStickerInfo) a2.getTag());
                        b.this.a(b.this.aAh.mLiveInfo.live_id, b.this.fzh);
                        b.this.bE(a2);
                        b.this.bEM();
                        if (b.this.fyY != null) {
                            b.this.fyY.L(a2);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fyX = null;
        }
    };
    CustomMessageListener fzm = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fze = hashMap;
                    if (b.this.fxB != null && !b.this.fxB.isEmpty()) {
                        b.this.s(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fzn = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fxB != null) {
                    for (int i = 0; i < b.this.fxB.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fxB.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fzg = false;
                    if (b.this.fyV != null) {
                        b.this.fyV.H(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.w.a.Nk().beH.aGx;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fzo, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fzo = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bEN();
        }
    };
    CustomMessageListener fzp = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fzo);
                b.this.bEN();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fzk);
        MessageManager.getInstance().registerListener(this.fzl);
        MessageManager.getInstance().registerListener(this.fzm);
        MessageManager.getInstance().registerListener(this.fzn);
        MessageManager.getInstance().registerListener(this.fzp);
    }

    @Override // com.baidu.live.x.a
    public void q(ViewGroup viewGroup) {
        this.fyZ = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void r(ViewGroup viewGroup) {
        this.fzb = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void eI(int i) {
        this.flH = i;
    }

    @Override // com.baidu.live.x.a
    public void setStickerCanOperate(boolean z) {
        if (this.fyS != null) {
            this.fyS.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.x.a
    public void eJ(int i) {
        if (this.fyS != null) {
            this.fyS.setVisibility(i);
        }
    }

    @Override // com.baidu.live.x.a
    public void s(ViewGroup viewGroup) {
        this.fza = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void a(com.baidu.live.g.a aVar) {
        this.fyY = aVar;
    }

    @Override // com.baidu.live.x.a
    public void Nv() {
        if (this.fyU == null) {
            this.fyU = new c(this.mContext, this.fzi);
        } else {
            this.fyU.bET();
        }
        this.fyU.show();
    }

    @Override // com.baidu.live.x.a
    public void cn(boolean z) {
        this.fzd = z;
    }

    @Override // com.baidu.live.x.a
    public void setLiveShowInfo(r rVar) {
        this.aAh = rVar;
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            this.fzh = dN(this.aAh.mLiveInfo.live_id);
            if (this.fzh != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fzh) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.x.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fyW != null) {
                this.fyW.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fyW.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fyW.setLayoutParams(layoutParams);
                    this.fyW.setBottom(0);
                }
            }
        } else if (this.fyW != null && this.fza != null) {
            if (this.fza.indexOfChild(this.fyW) >= 0) {
                this.fza.removeView(this.fyW);
            }
            this.fyW.setVisibility(8);
            this.fyX = null;
            if (this.fyV != null) {
                this.fyV.Ny();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.x.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.x.a
    public void Nw() {
        com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
    }

    @Override // com.baidu.live.x.a
    public void a(a.InterfaceC0202a interfaceC0202a) {
        this.fyV = interfaceC0202a;
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyW != null) {
            this.fyW.unRegisterListener();
            this.fyW = null;
        }
        if (this.fyU != null) {
            this.fyU.unRegisterListener();
            this.fyU = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fzk);
        MessageManager.getInstance().unRegisterListener(this.fzl);
        MessageManager.getInstance().unRegisterListener(this.fzm);
        MessageManager.getInstance().unRegisterListener(this.fzn);
        MessageManager.getInstance().unRegisterListener(this.fzp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo(String str) {
        if (this.fyW == null) {
            this.fyW = new AlaTextStickerEditView(this.mContext);
            this.fyW.setLiveShowInfo(this.aAh);
            this.fyW.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Ep(String str2) {
                    if (str2 != null && b.this.fyX != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bEG()) {
                        b.this.fyX.setText(str2);
                        long j = b.this.aAh.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fyX.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bEQ() {
                }
            });
        }
        if (this.fza != null) {
            if (this.fza.indexOfChild(this.fyW) >= 0) {
                this.fza.removeView(this.fyW);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fyW.setVisibility(0);
            this.fza.addView(this.fyW, layoutParams);
            this.fyW.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEL() {
        if (this.fyS == null) {
            this.fyS = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fyT == null) {
            this.fyT = new AlaStickerDragDeletePanelView(this.mContext);
            this.fyT.setVisibility(8);
        }
        if (this.fyS.getParent() == null) {
            this.fyS.bB(this.fyZ.getWidth(), this.fyZ.getHeight() - this.flH);
            this.fyZ.addView(this.fyS, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fyT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fyV != null) {
                this.fyT.setDeleteBottomHeight(this.fyV.NA());
                this.fyT.setTopDeletePanelHeight(this.fyV.Nz());
            }
            this.fzb.addView(this.fyT, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEM() {
        if (this.fyS.getChildCount() == 0) {
            if (this.fyS != null) {
                ((ViewGroup) this.fyS.getParent()).removeView(this.fyS);
            }
            if (this.fyT != null) {
                ((ViewGroup) this.fyT.getParent()).removeView(this.fyT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fyS != null) {
            return this.fyS.a(i, bitmap, i2, this.fzj, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fyS != null) {
            this.fyS.b(i, bitmap, i2, this.fzj, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
        if (this.fyS != null) {
            this.fyS.bF(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Integer> map) {
        if (this.fxB != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fxB.size()) {
                    break;
                }
                hashMap.put(this.fxB.get(i2).id, this.fxB.get(i2));
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
                        if (b.this.fze != null) {
                            b.this.fze.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bEs().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(fuFaceItem, new g.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: b */
                    public void ax(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: c */
                    public void ay(FuFaceItem fuFaceItem2) {
                        if (b.this.fze != null) {
                            b.this.fze.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fze != null && b.this.fze.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fze.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fze.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fze.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bEN() {
        FuFaceItem fuFaceItem;
        if (!this.fzg) {
            if (this.fzf != null) {
                fuFaceItem = this.fzf;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fxB.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fxB.get(i2);
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
            this.fzg = true;
            this.fzi.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fyS != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fyS.getChildCount()) {
                    break;
                }
                View childAt = this.fyS.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fxE || alaLiveStickerInfo.id == dVar.fxE.id) {
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
            com.baidu.live.c.AD().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.c.AD().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> dN(long j) {
        String string = com.baidu.live.c.AD().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bEL();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
