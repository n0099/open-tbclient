package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaDynamicGiftAndNativeData;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.gift.IFrameCallback;
import com.baidu.ala.gift.IImageFramePlayerViewController;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class b {
    private RelativeLayout fxO;
    private IImageFramePlayerViewController fxP;
    private AlaEffectPreviewView fxQ;
    private AlaEnterEffectData fxR;
    private int fxS = 2;
    private IFrameCallback fxT = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.fxS <= 0 && b.this.fxR != null) {
                b.this.a(b.this.fxR);
            }
        }
    };
    private a fxU = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bsK() {
            b.a(b.this);
            if (b.this.fxR != null) {
                if (b.this.fxR.type != 1 || b.this.fxS > 0) {
                    if (b.this.fxR.type == 0) {
                        b.this.a(b.this.fxR);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.fxR);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bsK();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.fxS;
        bVar.fxS = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fxO = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fxR = alaEnterEffectData;
            if (this.fxR.type == 1) {
                this.fxS = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.fxR.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.fxP == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.fxP = (IImageFramePlayerViewController) runTask.getData();
            this.fxP.setFrameCallback(this.fxT);
        }
        if (this.fxP != null) {
            if (this.fxP.getAnimView().getParent() == null) {
                this.fxO.addView(this.fxP.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.fxP.setData(alaDynamicGiftAndNativeData);
            this.fxP.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.fxQ == null) {
            this.fxQ = new AlaEffectPreviewView(this.mContext);
            this.fxQ.setAnimCompleteCallback(this.fxU);
        }
        if (this.fxQ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.fxO.addView(this.fxQ, layoutParams);
        }
        this.fxQ.setData(alaEnterEffectData);
        this.fxQ.bsI();
    }

    public void onDestory() {
        if (this.fxP != null) {
            this.fxP.onDestroy();
        }
        if (this.fxQ != null) {
            this.fxQ.onDestory();
        }
    }
}
