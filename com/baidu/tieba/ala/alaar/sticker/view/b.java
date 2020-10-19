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
    private u aDU;
    private List<FuFaceItem> fNa;
    private ViewGroup fOA;
    private Map<String, Integer> fOD;
    private FuFaceItem fOE;
    private List<AlaLiveStickerInfo> fOG;
    private AlaStickerDragContentView fOr;
    private AlaStickerDragDeletePanelView fOs;
    private c fOt;
    private a.InterfaceC0217a fOu;
    private AlaTextStickerEditView fOv;
    private DragTextView fOw;
    private com.baidu.live.g.a fOx;
    private ViewGroup fOy;
    private ViewGroup fOz;
    private Context mContext;
    private int fOB = 0;
    private int fAS = 0;
    private boolean faA = true;
    private Handler mHandler = new Handler();
    private boolean fOC = false;
    private boolean fOF = true;
    private c.b fOH = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bIR() {
            return b.this.fOF;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fOE = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fOC) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fOr != null && b.this.fOr.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bIJ()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bIO();
                    b.this.fOw = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aDU.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fOu != null) {
                b.this.fOu.K(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bIS() {
        }
    };
    private Runnable eWD = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.faA = true;
        }
    };
    private e fOI = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.faA) {
                b.this.faA = false;
                b.this.mHandler.postDelayed(b.this.eWD, 600L);
                if (view instanceof DragTextView) {
                    b.this.fOw = (DragTextView) view;
                    if (b.this.fOu != null) {
                        b.this.fOu.Pf();
                    }
                    b.this.Fx(b.this.fOw.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fOs != null) {
                b.this.fOs.setVisibility(8);
                b.this.fOs.kV(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fOs.getTopDeletePanelBottom()) {
                    if (b.this.fOx != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bIJ()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fOr.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fOr.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fOr.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fOr.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aDU.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bIJ()) {
                        ((DragTextView) view).bJd();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aDU.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fOs != null) {
                b.this.fOs.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fOs.getTopDeletePanelBottom()) {
                    b.this.fOs.kV(true);
                } else {
                    b.this.fOs.kV(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bIU() {
            int i;
            int i2;
            if (b.this.fOu != null) {
                b.this.fAS = b.this.fOu.Pi();
                b.this.fOB = b.this.fOu.Ph();
                int Pj = b.this.fOu.Pj();
                int imMsgListViewHeight = b.this.fOu.getImMsgListViewHeight();
                b.this.fOs.setDeleteBottomHeight(b.this.fAS);
                b.this.fOs.setTopDeletePanelHeight(b.this.fOB);
                b.this.fOs.setImMsgViewSize(Pj, imMsgListViewHeight);
                i2 = Pj;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fOr != null) {
                int width = b.this.fOy.getWidth();
                int height = b.this.fOy.getHeight() - b.this.fAS;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fOr.bA(width, height);
                for (int i3 = 0; i3 < b.this.fOr.getChildCount(); i3++) {
                    View childAt = b.this.fOr.getChildAt(i3);
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
            if (b.this.fOs != null) {
                b.this.fOs.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bIV() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bIJ();
        }
    };
    private HttpMessageListener fOJ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fNa = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fNa;
                if (b.this.fNa != null && !b.this.fNa.isEmpty() && b.this.fOD != null && !b.this.fOD.isEmpty()) {
                    b.this.C(b.this.fOD);
                }
            }
        }
    };
    private HttpMessageListener fOK = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bII();
                BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.sdk_net_fail_tip));
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
                            a2.bJd();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a2 != null) {
                        a2.bJd();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bII();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a3 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a3 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a3.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fOG == null) {
                                b.this.fOG = new LinkedList();
                            }
                            b.this.fOG.add(alaLiveStickerInfo);
                            b.this.a(b.this.aDU.mLiveInfo.live_id, b.this.fOG);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a3 != null && a3.getParent() != null) {
                                ((ViewGroup) a3.getParent()).removeView(a3);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a3.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fNd.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fNd.centerY;
                        alaLiveStickerInfo2.text = dVar2.fNd.text;
                        b.this.a(b.this.aDU.mLiveInfo.live_id, b.this.fOG);
                    } else if (dVar2.mRequestType == 3 && a3 != null) {
                        b.this.fOG.remove((AlaLiveStickerInfo) a3.getTag());
                        b.this.a(b.this.aDU.mLiveInfo.live_id, b.this.fOG);
                        b.this.bM(a3);
                        b.this.bIP();
                        if (b.this.fOx != null) {
                            b.this.fOx.L(a3);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fOw = null;
        }
    };
    CustomMessageListener fOL = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fOD = hashMap;
                    if (b.this.fNa != null && !b.this.fNa.isEmpty()) {
                        b.this.C(hashMap);
                    } else {
                        com.baidu.tieba.ala.alaar.sticker.a.f.Pe();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    CustomMessageListener fOM = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fNa != null) {
                    for (int i = 0; i < b.this.fNa.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fNa.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fOF = false;
                    if (b.this.fOu != null) {
                        b.this.fOu.K(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.x.a.OS().blo.aKS;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fON, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fON = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bIQ();
        }
    };
    CustomMessageListener fOO = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fON);
                b.this.bIQ();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fOJ);
        MessageManager.getInstance().registerListener(this.fOK);
        MessageManager.getInstance().registerListener(this.fOL);
        MessageManager.getInstance().registerListener(this.fOM);
        MessageManager.getInstance().registerListener(this.fOO);
    }

    @Override // com.baidu.live.y.a
    public void t(ViewGroup viewGroup) {
        this.fOy = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void u(ViewGroup viewGroup) {
        this.fOA = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void fc(int i) {
        this.fAS = i;
    }

    @Override // com.baidu.live.y.a
    public void setStickerCanOperate(boolean z) {
        if (this.fOr != null) {
            this.fOr.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.y.a
    public void fd(int i) {
        if (this.fOr != null) {
            this.fOr.setVisibility(i);
        }
    }

    @Override // com.baidu.live.y.a
    public void v(ViewGroup viewGroup) {
        this.fOz = viewGroup;
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.g.a aVar) {
        this.fOx = aVar;
    }

    @Override // com.baidu.live.y.a
    public void Pd() {
        if (this.fOt == null) {
            this.fOt = new c(this.mContext, this.fOH);
        } else {
            this.fOt.bIW();
        }
        this.fOt.show();
    }

    @Override // com.baidu.live.y.a
    public void cs(boolean z) {
        this.fOC = z;
    }

    @Override // com.baidu.live.y.a
    public void setLiveShowInfo(u uVar) {
        this.aDU = uVar;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            this.fOG = dX(this.aDU.mLiveInfo.live_id);
            if (this.fOG != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fOG) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fOv != null) {
                this.fOv.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fOv.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fOv.setLayoutParams(layoutParams);
                    this.fOv.setBottom(0);
                }
            }
        } else if (this.fOv != null && this.fOz != null) {
            if (this.fOz.indexOfChild(this.fOv) >= 0) {
                this.fOz.removeView(this.fOv);
            }
            this.fOv.setVisibility(8);
            this.fOw = null;
            if (this.fOu != null) {
                this.fOu.Pg();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        }
    }

    @Override // com.baidu.live.y.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.y.a
    public void Pe() {
        com.baidu.tieba.ala.alaar.sticker.a.f.Pe();
    }

    @Override // com.baidu.live.y.a
    public void a(a.InterfaceC0217a interfaceC0217a) {
        this.fOu = interfaceC0217a;
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fOv != null) {
            this.fOv.unRegisterListener();
            this.fOv = null;
        }
        if (this.fOt != null) {
            this.fOt.unRegisterListener();
            this.fOt = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fOJ);
        MessageManager.getInstance().unRegisterListener(this.fOK);
        MessageManager.getInstance().unRegisterListener(this.fOL);
        MessageManager.getInstance().unRegisterListener(this.fOM);
        MessageManager.getInstance().unRegisterListener(this.fOO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fx(String str) {
        if (this.fOv == null) {
            this.fOv = new AlaTextStickerEditView(this.mContext);
            this.fOv.setLiveShowInfo(this.aDU);
            this.fOv.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Fy(String str2) {
                    if (str2 != null && b.this.fOw != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bIJ()) {
                        b.this.fOw.setText(str2);
                        long j = b.this.aDU.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fOw.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bIT() {
                }
            });
        }
        if (this.fOz != null) {
            if (this.fOz.indexOfChild(this.fOv) >= 0) {
                this.fOz.removeView(this.fOv);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fOv.setVisibility(0);
            this.fOz.addView(this.fOv, layoutParams);
            this.fOv.Fz(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIO() {
        if (this.fOr == null) {
            this.fOr = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fOs == null) {
            this.fOs = new AlaStickerDragDeletePanelView(this.mContext);
            this.fOs.setVisibility(8);
        }
        if (this.fOr.getParent() == null) {
            this.fOr.bA(this.fOy.getWidth(), this.fOy.getHeight() - this.fAS);
            this.fOy.addView(this.fOr, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fOs.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fOu != null) {
                this.fOs.setDeleteBottomHeight(this.fOu.Pi());
                this.fOs.setTopDeletePanelHeight(this.fOu.Ph());
            }
            this.fOA.addView(this.fOs, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIP() {
        if (this.fOr.getChildCount() == 0) {
            if (this.fOr != null) {
                ((ViewGroup) this.fOr.getParent()).removeView(this.fOr);
            }
            if (this.fOs != null) {
                ((ViewGroup) this.fOs.getParent()).removeView(this.fOs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fOr != null) {
            return this.fOr.a(i, bitmap, i2, this.fOI, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fOr != null) {
            this.fOr.b(i, bitmap, i2, this.fOI, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(View view) {
        if (this.fOr != null) {
            this.fOr.bN(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Map<String, Integer> map) {
        if (this.fNa != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fNa.size()) {
                    break;
                }
                hashMap.put(this.fNa.get(i2).id, this.fNa.get(i2));
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
                        if (b.this.fOD != null) {
                            b.this.fOD.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bIv().isRunning(fuFaceItem.file)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(fuFaceItem, new g.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: b */
                    public void aC(FuFaceItem fuFaceItem2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    /* renamed from: c */
                    public void aD(FuFaceItem fuFaceItem2) {
                        if (b.this.fOD != null) {
                            b.this.fOD.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fOD != null && b.this.fOD.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fOD.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fOD.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fOD.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bIQ() {
        FuFaceItem fuFaceItem;
        if (!this.fOF) {
            if (this.fOE != null) {
                fuFaceItem = this.fOE;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fNa.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fNa.get(i2);
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
            this.fOF = true;
            this.fOH.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fOr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fOr.getChildCount()) {
                    break;
                }
                View childAt = this.fOr.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fNd || alaLiveStickerInfo.id == dVar.fNd.id) {
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
            com.baidu.live.c.AZ().putString("sp_ala_live_master_sticker_info", "");
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
        com.baidu.live.c.AZ().putString("sp_ala_live_master_sticker_info", jSONObject.toString());
    }

    private List<AlaLiveStickerInfo> dX(long j) {
        String string = com.baidu.live.c.AZ().getString("sp_ala_live_master_sticker_info", "");
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
                        b.this.bIO();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
