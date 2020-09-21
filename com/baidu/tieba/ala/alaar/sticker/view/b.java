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
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.y.a;
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
public class b implements com.baidu.live.y.a {
    private u aAP;
    private List<FuFaceItem> fAR;
    private AlaStickerDragContentView fCi;
    private AlaStickerDragDeletePanelView fCj;
    private c fCk;
    private a.InterfaceC0202a fCl;
    private AlaTextStickerEditView fCm;
    private DragTextView fCn;
    private com.baidu.live.g.a fCo;
    private ViewGroup fCp;
    private ViewGroup fCq;
    private ViewGroup fCr;
    private Map<String, Integer> fCu;
    private FuFaceItem fCv;
    private List<AlaLiveStickerInfo> fCx;
    private Context mContext;
    private int fCs = 0;
    private int foE = 0;
    private boolean eOt = true;
    private Handler mHandler = new Handler();
    private boolean fCt = false;
    private boolean fCw = true;
    private c.b fCy = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bGf() {
            return b.this.fCw;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fCv = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fCt) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fCi != null && b.this.fCi.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bFX()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bGc();
                    b.this.fCn = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAP.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fCl != null) {
                b.this.fCl.I(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bGg() {
        }
    };
    private Runnable eKw = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.eOt = true;
        }
    };
    private e fCz = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.eOt) {
                b.this.eOt = false;
                b.this.mHandler.postDelayed(b.this.eKw, 600L);
                if (view instanceof DragTextView) {
                    b.this.fCn = (DragTextView) view;
                    if (b.this.fCl != null) {
                        b.this.fCl.Oa();
                    }
                    b.this.EM(b.this.fCn.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fCj != null) {
                b.this.fCj.setVisibility(8);
                b.this.fCj.kx(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fCj.getTopDeletePanelBottom()) {
                    if (b.this.fCo != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bFX()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fCi.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fCi.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fCi.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fCi.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAP.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bFX()) {
                        ((DragTextView) view).bGr();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAP.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fCj != null) {
                b.this.fCj.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fCj.getTopDeletePanelBottom()) {
                    b.this.fCj.kx(true);
                } else {
                    b.this.fCj.kx(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bGi() {
            int i;
            int i2;
            if (b.this.fCl != null) {
                b.this.foE = b.this.fCl.Od();
                b.this.fCs = b.this.fCl.Oc();
                int Oe = b.this.fCl.Oe();
                int imMsgListViewHeight = b.this.fCl.getImMsgListViewHeight();
                b.this.fCj.setDeleteBottomHeight(b.this.foE);
                b.this.fCj.setTopDeletePanelHeight(b.this.fCs);
                b.this.fCj.setImMsgViewSize(Oe, imMsgListViewHeight);
                i2 = Oe;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fCi != null) {
                int width = b.this.fCp.getWidth();
                int height = b.this.fCp.getHeight() - b.this.foE;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fCi.bB(width, height);
                for (int i3 = 0; i3 < b.this.fCi.getChildCount(); i3++) {
                    View childAt = b.this.fCi.getChildAt(i3);
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
            if (b.this.fCj != null) {
                b.this.fCj.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bGj() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bFX();
        }
    };
    private HttpMessageListener fCA = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fAR = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fAR;
                if (b.this.fAR != null && !b.this.fAR.isEmpty() && b.this.fCu != null && !b.this.fCu.isEmpty()) {
                    b.this.s(b.this.fCu);
                }
            }
        }
    };
    private HttpMessageListener fCB = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bFW();
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
                            a.bGr();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a != null) {
                        a.bGr();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bFW();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a2 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a2 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a2.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fCx == null) {
                                b.this.fCx = new LinkedList();
                            }
                            b.this.fCx.add(alaLiveStickerInfo);
                            b.this.a(b.this.aAP.mLiveInfo.live_id, b.this.fCx);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a2 != null && a2.getParent() != null) {
                                ((ViewGroup) a2.getParent()).removeView(a2);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a2.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fAU.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fAU.centerY;
                        alaLiveStickerInfo2.text = dVar2.fAU.text;
                        b.this.a(b.this.aAP.mLiveInfo.live_id, b.this.fCx);
                    } else if (dVar2.mRequestType == 3 && a2 != null) {
                        b.this.fCx.remove((AlaLiveStickerInfo) a2.getTag());
                        b.this.a(b.this.aAP.mLiveInfo.live_id, b.this.fCx);
                        b.this.bI(a2);
                        b.this.bGd();
                        if (b.this.fCo != null) {
                            b.this.fCo.L(a2);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fCn = null;
        }
    };
    CustomMessageListener fCC = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fCu = hashMap;
                    if (b.this.fAR != null && !b.this.fAR.isEmpty()) {
                        b.this.s(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.f.NZ();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fCD = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fAR != null) {
                    for (int i = 0; i < b.this.fAR.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fAR.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fCw = false;
                    if (b.this.fCl != null) {
                        b.this.fCl.I(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.x.a.NN().bhy.aHO;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fCE, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fCE = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bGe();
        }
    };
    CustomMessageListener fCF = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fCE);
                b.this.bGe();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fCA);
        MessageManager.getInstance().registerListener(this.fCB);
        MessageManager.getInstance().registerListener(this.fCC);
        MessageManager.getInstance().registerListener(this.fCD);
        MessageManager.getInstance().registerListener(this.fCF);
    }

    @Override // com.baidu.live.y.a
    public void t(ViewGroup viewGroup) {
        this.fCp = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void u(ViewGroup viewGroup) {
        this.fCr = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void eT(int i) {
        this.foE = i;
    }

    @Override // com.baidu.live.y.a
    public void setStickerCanOperate(boolean z) {
        if (this.fCi != null) {
            this.fCi.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.y.a
    public void eU(int i) {
        if (this.fCi != null) {
            this.fCi.setVisibility(i);
        }
    }

    @Override // com.baidu.live.y.a
    public void v(ViewGroup viewGroup) {
        this.fCq = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.g.a aVar) {
        this.fCo = aVar;
    }

    @Override // com.baidu.live.y.a
    public void NY() {
        if (this.fCk == null) {
            this.fCk = new c(this.mContext, this.fCy);
        } else {
            this.fCk.bGk();
        }
        this.fCk.show();
    }

    @Override // com.baidu.live.y.a
    public void cp(boolean z) {
        this.fCt = z;
    }

    @Override // com.baidu.live.y.a
    public void setLiveShowInfo(u uVar) {
        this.aAP = uVar;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            this.fCx = dO(this.aAP.mLiveInfo.live_id);
            if (this.fCx != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fCx) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fCm != null) {
                this.fCm.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCm.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fCm.setLayoutParams(layoutParams);
                    this.fCm.setBottom(0);
                }
            }
        } else if (this.fCm != null && this.fCq != null) {
            if (this.fCq.indexOfChild(this.fCm) >= 0) {
                this.fCq.removeView(this.fCm);
            }
            this.fCm.setVisibility(8);
            this.fCn = null;
            if (this.fCl != null) {
                this.fCl.Ob();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.y.a
    public void NZ() {
        com.baidu.tieba.ala.alaar.sticker.a.f.NZ();
    }

    @Override // com.baidu.live.y.a
    public void a(a.InterfaceC0202a interfaceC0202a) {
        this.fCl = interfaceC0202a;
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fCm != null) {
            this.fCm.unRegisterListener();
            this.fCm = null;
        }
        if (this.fCk != null) {
            this.fCk.unRegisterListener();
            this.fCk = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fCA);
        MessageManager.getInstance().unRegisterListener(this.fCB);
        MessageManager.getInstance().unRegisterListener(this.fCC);
        MessageManager.getInstance().unRegisterListener(this.fCD);
        MessageManager.getInstance().unRegisterListener(this.fCF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(String str) {
        if (this.fCm == null) {
            this.fCm = new AlaTextStickerEditView(this.mContext);
            this.fCm.setLiveShowInfo(this.aAP);
            this.fCm.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void EN(String str2) {
                    if (str2 != null && b.this.fCn != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bFX()) {
                        b.this.fCn.setText(str2);
                        long j = b.this.aAP.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fCn.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bGh() {
                }
            });
        }
        if (this.fCq != null) {
            if (this.fCq.indexOfChild(this.fCm) >= 0) {
                this.fCq.removeView(this.fCm);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fCm.setVisibility(0);
            this.fCq.addView(this.fCm, layoutParams);
            this.fCm.EO(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGc() {
        if (this.fCi == null) {
            this.fCi = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fCj == null) {
            this.fCj = new AlaStickerDragDeletePanelView(this.mContext);
            this.fCj.setVisibility(8);
        }
        if (this.fCi.getParent() == null) {
            this.fCi.bB(this.fCp.getWidth(), this.fCp.getHeight() - this.foE);
            this.fCp.addView(this.fCi, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fCj.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fCl != null) {
                this.fCj.setDeleteBottomHeight(this.fCl.Od());
                this.fCj.setTopDeletePanelHeight(this.fCl.Oc());
            }
            this.fCr.addView(this.fCj, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGd() {
        if (this.fCi.getChildCount() == 0) {
            if (this.fCi != null) {
                ((ViewGroup) this.fCi.getParent()).removeView(this.fCi);
            }
            if (this.fCj != null) {
                ((ViewGroup) this.fCj.getParent()).removeView(this.fCj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fCi != null) {
            return this.fCi.a(i, bitmap, i2, this.fCz, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fCi != null) {
            this.fCi.b(i, bitmap, i2, this.fCz, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(View view) {
        if (this.fCi != null) {
            this.fCi.bJ(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Integer> map) {
        if (this.fAR != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fAR.size()) {
                    break;
                }
                hashMap.put(this.fAR.get(i2).id, this.fAR.get(i2));
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
                        if (b.this.fCu != null) {
                            b.this.fCu.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bFJ().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(fuFaceItem, new g.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: b */
                    public void az(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: c */
                    public void aA(FuFaceItem fuFaceItem2) {
                        if (b.this.fCu != null) {
                            b.this.fCu.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fCu != null && b.this.fCu.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fCu.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fCu.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fCu.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bGe() {
        FuFaceItem fuFaceItem;
        if (!this.fCw) {
            if (this.fCv != null) {
                fuFaceItem = this.fCv;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fAR.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fAR.get(i2);
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
            this.fCw = true;
            this.fCy.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fCi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fCi.getChildCount()) {
                    break;
                }
                View childAt = this.fCi.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fAU || alaLiveStickerInfo.id == dVar.fAU.id) {
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
            com.baidu.live.c.AR().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.c.AR().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> dO(long j) {
        String string = com.baidu.live.c.AR().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bGc();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
