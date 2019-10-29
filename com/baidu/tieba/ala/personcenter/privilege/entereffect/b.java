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
/* loaded from: classes6.dex */
public class b {
    private RelativeLayout eAA;
    private IImageFramePlayerViewController eAB;
    private AlaEffectPreviewView eAC;
    private AlaEnterEffectData eAD;
    private int eAE = 2;
    private IFrameCallback eAF = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.eAE <= 0 && b.this.eAD != null) {
                b.this.a(b.this.eAD);
            }
        }
    };
    private a eAG = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void aYc() {
            b.a(b.this);
            if (b.this.eAD != null) {
                if (b.this.eAD.type != 1 || b.this.eAE > 0) {
                    if (b.this.eAD.type == 0) {
                        b.this.a(b.this.eAD);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.eAD);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void aYc();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.eAE;
        bVar.eAE = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.eAA = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.eAD = alaEnterEffectData;
            if (this.eAD.type == 1) {
                this.eAE = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.eAD.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.eAB == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.eAB = (IImageFramePlayerViewController) runTask.getData();
            this.eAB.setFrameCallback(this.eAF);
        }
        if (this.eAB != null) {
            if (this.eAB.getAnimView().getParent() == null) {
                this.eAA.addView(this.eAB.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.eAB.setData(alaDynamicGiftAndNativeData);
            this.eAB.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.eAC == null) {
            this.eAC = new AlaEffectPreviewView(this.mContext);
            this.eAC.setAnimCompleteCallback(this.eAG);
        }
        if (this.eAC.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.eAA.addView(this.eAC, layoutParams);
        }
        this.eAC.setData(alaEnterEffectData);
        this.eAC.aYa();
    }

    public void onDestory() {
        if (this.eAB != null) {
            this.eAB.onDestroy();
        }
        if (this.eAC != null) {
            this.eAC.onDestory();
        }
    }
}
