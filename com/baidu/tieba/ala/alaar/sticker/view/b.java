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
    private r aAj;
    private List<FuFaceItem> fxF;
    private AlaStickerDragContentView fyW;
    private AlaStickerDragDeletePanelView fyX;
    private c fyY;
    private a.InterfaceC0202a fyZ;
    private AlaTextStickerEditView fza;
    private DragTextView fzb;
    private com.baidu.live.g.a fzc;
    private ViewGroup fzd;
    private ViewGroup fze;
    private ViewGroup fzf;
    private Map<String, Integer> fzi;
    private FuFaceItem fzj;
    private List<AlaLiveStickerInfo> fzl;
    private Context mContext;
    private int fzg = 0;
    private int flL = 0;
    private boolean eMb = true;
    private Handler mHandler = new Handler();
    private boolean fzh = false;
    private boolean fzk = true;
    private c.b fzm = new c.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public boolean bEP() {
            return b.this.fzk;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void a(FuFaceItem fuFaceItem, String str) {
            b.this.fzj = fuFaceItem;
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.fzh) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.fyW != null && b.this.fyW.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                } else if (!com.baidu.tieba.ala.alaar.sticker.a.f.bEH()) {
                    int i = a.d.sdk_cp_cont_q;
                    AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
                    alaLiveStickerInfo.type = picStickerItem.sticker_type;
                    alaLiveStickerInfo.link = picStickerItem.url;
                    b.this.bEM();
                    b.this.fzb = b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i, alaLiveStickerInfo);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAj.mLiveInfo.live_id, 1, alaLiveStickerInfo);
                }
            } else if (b.this.fyZ != null) {
                b.this.fyZ.H(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.b
        public void bEQ() {
        }
    };
    private Runnable eIp = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.8
        @Override // java.lang.Runnable
        public void run() {
            b.this.eMb = true;
        }
    };
    private e fzn = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.9
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.eMb) {
                b.this.eMb = false;
                b.this.mHandler.postDelayed(b.this.eIp, 600L);
                if (view instanceof DragTextView) {
                    b.this.fzb = (DragTextView) view;
                    if (b.this.fyZ != null) {
                        b.this.fyZ.Nx();
                    }
                    b.this.Ep(b.this.fzb.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.fyX != null) {
                b.this.fyX.setVisibility(8);
                b.this.fyX.kv(false);
                if (((i4 - i2) / 5) + i2 >= b.this.fyX.getTopDeletePanelBottom()) {
                    if (b.this.fzc != null) {
                    }
                    if (!com.baidu.tieba.ala.alaar.sticker.a.f.bEH()) {
                        int dip2px = BdUtilHelper.dip2px(b.this.mContext, 98.0f) / 2;
                        int dip2px2 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        int dip2px3 = BdUtilHelper.dip2px(b.this.mContext, 162.0f) / 2;
                        int dip2px4 = BdUtilHelper.dip2px(b.this.mContext, 64.0f) / 2;
                        if (view instanceof DragTextView) {
                            AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) view.getTag());
                            if (alaLiveStickerInfo.type == 1) {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px) * 1.0f) / b.this.fyW.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((dip2px2 + i2) * 1.0f) / b.this.fyW.getHeight()) * 10000.0d) / 10000.0d;
                            } else {
                                alaLiveStickerInfo.centerX = Math.round((((i + dip2px3) * 1.0f) / b.this.fyW.getWidth()) * 10000.0d) / 10000.0d;
                                alaLiveStickerInfo.centerY = Math.round((((i2 + dip2px4) * 1.0f) / b.this.fyW.getHeight()) * 10000.0d) / 10000.0d;
                            }
                            com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAj.mLiveInfo.live_id, 2, alaLiveStickerInfo);
                        }
                    }
                } else if (view.getParent() != null && (view instanceof DragTextView)) {
                    AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) view.getTag();
                    if (com.baidu.tieba.ala.alaar.sticker.a.f.bEH()) {
                        ((DragTextView) view).bFb();
                        return;
                    }
                    view.setVisibility(4);
                    com.baidu.tieba.ala.alaar.sticker.a.f.a(b.this.aAj.mLiveInfo.live_id, 3, alaLiveStickerInfo2);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void w(int i, int i2, int i3, int i4) {
            if (b.this.fyX != null) {
                b.this.fyX.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.fyX.getTopDeletePanelBottom()) {
                    b.this.fyX.kv(true);
                } else {
                    b.this.fyX.kv(false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void bES() {
            int i;
            int i2;
            if (b.this.fyZ != null) {
                b.this.flL = b.this.fyZ.NA();
                b.this.fzg = b.this.fyZ.Nz();
                int NB = b.this.fyZ.NB();
                int imMsgListViewHeight = b.this.fyZ.getImMsgListViewHeight();
                b.this.fyX.setDeleteBottomHeight(b.this.flL);
                b.this.fyX.setTopDeletePanelHeight(b.this.fzg);
                b.this.fyX.setImMsgViewSize(NB, imMsgListViewHeight);
                i2 = NB;
                i = imMsgListViewHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            if (b.this.fyW != null) {
                int width = b.this.fzd.getWidth();
                int height = b.this.fzd.getHeight() - b.this.flL;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(b.this.mContext) - i2;
                b.this.fyW.bB(width, height);
                for (int i3 = 0; i3 < b.this.fyW.getChildCount(); i3++) {
                    View childAt = b.this.fyW.getChildAt(i3);
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
            if (b.this.fyX != null) {
                b.this.fyX.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public boolean bET() {
            return !com.baidu.tieba.ala.alaar.sticker.a.f.bEH();
        }
    };
    private HttpMessageListener fzo = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                b.this.fxF = ((GetArStickerListHttpResponseMessage) httpResponsedMessage).fxF;
                if (b.this.fxF != null && !b.this.fxF.isEmpty() && b.this.fzi != null && !b.this.fzi.isEmpty()) {
                    b.this.s(b.this.fzi);
                }
            }
        }
    };
    private HttpMessageListener fzp = new HttpMessageListener(1021206) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.alaar.messages.d dVar;
            if (!(httpResponsedMessage instanceof SetPicTxtStickerHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bEG();
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
                            a.bFb();
                            return;
                        }
                        return;
                    } else if (dVar.mRequestType == 3 && a != null) {
                        a.bFb();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            com.baidu.tieba.ala.alaar.sticker.a.f.bEG();
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.alaar.messages.d) {
                com.baidu.tieba.ala.alaar.messages.d dVar2 = (com.baidu.tieba.ala.alaar.messages.d) httpResponsedMessage.getOrginalMessage();
                if (dVar2 != null) {
                    DragTextView a2 = b.this.a(dVar2);
                    if (dVar2.mRequestType == 1) {
                        List<AlaLiveStickerInfo> data = ((SetPicTxtStickerHttpResponseMessage) httpResponsedMessage).getData();
                        if (data != null && a2 != null) {
                            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) a2.getTag();
                            alaLiveStickerInfo.id = data.get(data.size() - 1).id;
                            if (b.this.fzl == null) {
                                b.this.fzl = new LinkedList();
                            }
                            b.this.fzl.add(alaLiveStickerInfo);
                            b.this.a(b.this.aAj.mLiveInfo.live_id, b.this.fzl);
                        } else {
                            BdUtilHelper.showToast(b.this.mContext, b.this.mContext.getString(a.i.ala_live_sticker_set_fail));
                            if (a2 != null && a2.getParent() != null) {
                                ((ViewGroup) a2.getParent()).removeView(a2);
                            }
                        }
                    } else if (dVar2.mRequestType == 2) {
                        AlaLiveStickerInfo alaLiveStickerInfo2 = (AlaLiveStickerInfo) a2.getTag();
                        alaLiveStickerInfo2.centerX = dVar2.fxI.centerX;
                        alaLiveStickerInfo2.centerY = dVar2.fxI.centerY;
                        alaLiveStickerInfo2.text = dVar2.fxI.text;
                        b.this.a(b.this.aAj.mLiveInfo.live_id, b.this.fzl);
                    } else if (dVar2.mRequestType == 3 && a2 != null) {
                        b.this.fzl.remove((AlaLiveStickerInfo) a2.getTag());
                        b.this.a(b.this.aAj.mLiveInfo.live_id, b.this.fzl);
                        b.this.bE(a2);
                        b.this.bEN();
                        if (b.this.fzc != null) {
                            b.this.fzc.L(a2);
                        }
                    }
                } else {
                    return;
                }
            }
            b.this.fzb = null;
        }
    };
    CustomMessageListener fzq = new CustomMessageListener(2913209) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
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
                    b.this.fzi = hashMap;
                    if (b.this.fxF != null && !b.this.fxF.isEmpty()) {
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
    CustomMessageListener fzr = new CustomMessageListener(2913210) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FuFaceItem fuFaceItem;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.fxF != null) {
                    for (int i = 0; i < b.this.fxF.size(); i++) {
                        fuFaceItem = (FuFaceItem) b.this.fxF.get(i);
                        if (TextUtils.equals(str, fuFaceItem.id)) {
                            break;
                        }
                    }
                }
                fuFaceItem = null;
                if (fuFaceItem != null && fuFaceItem.isResLoaded()) {
                    b.this.fzk = false;
                    if (b.this.fyZ != null) {
                        b.this.fyZ.H(fuFaceItem.getSticker());
                    }
                    int i2 = com.baidu.live.w.a.Nk().beJ.aGz;
                    if (i2 == 0) {
                        i2 = 60;
                    }
                    b.this.mHandler.postDelayed(b.this.fzs, i2 * 1000);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913212));
            }
        }
    };
    private Runnable fzs = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.bEO();
        }
    };
    CustomMessageListener fzt = new CustomMessageListener(2913211) { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.mHandler.removeCallbacks(b.this.fzs);
                b.this.bEO();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.fzo);
        MessageManager.getInstance().registerListener(this.fzp);
        MessageManager.getInstance().registerListener(this.fzq);
        MessageManager.getInstance().registerListener(this.fzr);
        MessageManager.getInstance().registerListener(this.fzt);
    }

    @Override // com.baidu.live.x.a
    public void q(ViewGroup viewGroup) {
        this.fzd = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void r(ViewGroup viewGroup) {
        this.fzf = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void eI(int i) {
        this.flL = i;
    }

    @Override // com.baidu.live.x.a
    public void setStickerCanOperate(boolean z) {
        if (this.fyW != null) {
            this.fyW.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.x.a
    public void eJ(int i) {
        if (this.fyW != null) {
            this.fyW.setVisibility(i);
        }
    }

    @Override // com.baidu.live.x.a
    public void s(ViewGroup viewGroup) {
        this.fze = viewGroup;
    }

    @Override // com.baidu.live.x.a
    public void a(com.baidu.live.g.a aVar) {
        this.fzc = aVar;
    }

    @Override // com.baidu.live.x.a
    public void Nv() {
        if (this.fyY == null) {
            this.fyY = new c(this.mContext, this.fzm);
        } else {
            this.fyY.bEU();
        }
        this.fyY.show();
    }

    @Override // com.baidu.live.x.a
    public void co(boolean z) {
        this.fzh = z;
    }

    @Override // com.baidu.live.x.a
    public void setLiveShowInfo(r rVar) {
        this.aAj = rVar;
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            this.fzl = dN(this.aAj.mLiveInfo.live_id);
            if (this.fzl != null) {
                for (AlaLiveStickerInfo alaLiveStickerInfo : this.fzl) {
                    a(alaLiveStickerInfo);
                }
            }
        }
    }

    @Override // com.baidu.live.x.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.fza != null) {
                this.fza.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fza.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fza.setLayoutParams(layoutParams);
                    this.fza.setBottom(0);
                }
            }
        } else if (this.fza != null && this.fze != null) {
            if (this.fze.indexOfChild(this.fza) >= 0) {
                this.fze.removeView(this.fza);
            }
            this.fza.setVisibility(8);
            this.fzb = null;
            if (this.fyZ != null) {
                this.fyZ.Ny();
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
        this.fyZ = interfaceC0202a;
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fza != null) {
            this.fza.unRegisterListener();
            this.fza = null;
        }
        if (this.fyY != null) {
            this.fyY.unRegisterListener();
            this.fyY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fzo);
        MessageManager.getInstance().unRegisterListener(this.fzp);
        MessageManager.getInstance().unRegisterListener(this.fzq);
        MessageManager.getInstance().unRegisterListener(this.fzr);
        MessageManager.getInstance().unRegisterListener(this.fzt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ep(String str) {
        if (this.fza == null) {
            this.fza = new AlaTextStickerEditView(this.mContext);
            this.fza.setLiveShowInfo(this.aAj);
            this.fza.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.7
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void Eq(String str2) {
                    if (str2 != null && b.this.fzb != null && !com.baidu.tieba.ala.alaar.sticker.a.f.bEH()) {
                        b.this.fzb.setText(str2);
                        long j = b.this.aAj.mLiveInfo.live_id;
                        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo((AlaLiveStickerInfo) b.this.fzb.getTag());
                        alaLiveStickerInfo.text = str2;
                        com.baidu.tieba.ala.alaar.sticker.a.f.a(j, 2, alaLiveStickerInfo);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void bER() {
                }
            });
        }
        if (this.fze != null) {
            if (this.fze.indexOfChild(this.fza) >= 0) {
                this.fze.removeView(this.fza);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.fza.setVisibility(0);
            this.fze.addView(this.fza, layoutParams);
            this.fza.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEM() {
        if (this.fyW == null) {
            this.fyW = new AlaStickerDragContentView(this.mContext);
        }
        if (this.fyX == null) {
            this.fyX = new AlaStickerDragDeletePanelView(this.mContext);
            this.fyX.setVisibility(8);
        }
        if (this.fyW.getParent() == null) {
            this.fyW.bB(this.fzd.getWidth(), this.fzd.getHeight() - this.flL);
            this.fzd.addView(this.fyW, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.fyX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.fyZ != null) {
                this.fyX.setDeleteBottomHeight(this.fyZ.NA());
                this.fyX.setTopDeletePanelHeight(this.fyZ.Nz());
            }
            this.fzf.addView(this.fyX, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        if (this.fyW.getChildCount() == 0) {
            if (this.fyW != null) {
                ((ViewGroup) this.fyW.getParent()).removeView(this.fyW);
            }
            if (this.fyX != null) {
                ((ViewGroup) this.fyX.getParent()).removeView(this.fyX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fyW != null) {
            return this.fyW.a(i, bitmap, i2, this.fzn, alaLiveStickerInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Bitmap bitmap, int i2, AlaLiveStickerInfo alaLiveStickerInfo) {
        if (this.fyW != null) {
            this.fyW.b(i, bitmap, i2, this.fzn, alaLiveStickerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
        if (this.fyW != null) {
            this.fyW.bF(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Map<String, Integer> map) {
        if (this.fxF != null && map != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fxF.size()) {
                    break;
                }
                hashMap.put(this.fxF.get(i2).id, this.fxF.get(i2));
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
                        if (b.this.fzi != null) {
                            b.this.fzi.remove(fuFaceItem.id);
                        }
                    }
                });
            } else if (!com.baidu.tieba.ala.alaar.sticker.download.b.bEt().isRunning(fuFaceItem.file)) {
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
                        if (b.this.fzi != null) {
                            b.this.fzi.remove(fuFaceItem2.id);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                    public void a(final FuFaceItem fuFaceItem2, int i, int i2, String str) {
                        if (b.this.fzi != null && b.this.fzi.containsKey(fuFaceItem2.id)) {
                            int intValue = ((Integer) b.this.fzi.get(fuFaceItem2.id)).intValue();
                            if (intValue >= 2) {
                                b.this.fzi.remove(fuFaceItem2.id);
                                return;
                            }
                            b.this.fzi.put(fuFaceItem2.id, Integer.valueOf(intValue + 1));
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
    public void bEO() {
        FuFaceItem fuFaceItem;
        if (!this.fzk) {
            if (this.fzj != null) {
                fuFaceItem = this.fzj;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.fxF.size()) {
                        fuFaceItem = null;
                        break;
                    }
                    fuFaceItem = this.fxF.get(i2);
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
            this.fzk = true;
            this.fzm.a(fuFaceItem, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragTextView a(com.baidu.tieba.ala.alaar.messages.d dVar) {
        if (this.fyW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fyW.getChildCount()) {
                    break;
                }
                View childAt = this.fyW.getChildAt(i2);
                if (childAt instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) childAt;
                    AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) dragTextView.getTag();
                    if (alaLiveStickerInfo == dVar.fxI || alaLiveStickerInfo.id == dVar.fxI.id) {
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
                        b.this.bEM();
                        b.this.b(alaLiveStickerInfo.type, alaLiveStickerInfo.bitmap, i2, alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }
}
