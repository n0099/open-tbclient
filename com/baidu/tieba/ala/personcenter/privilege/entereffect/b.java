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
    private RelativeLayout fwV;
    private IImageFramePlayerViewController fwW;
    private AlaEffectPreviewView fwX;
    private AlaEnterEffectData fwY;
    private int fwZ = 2;
    private IFrameCallback fxa = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.fwZ <= 0 && b.this.fwY != null) {
                b.this.a(b.this.fwY);
            }
        }
    };
    private a fxb = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bsD() {
            b.a(b.this);
            if (b.this.fwY != null) {
                if (b.this.fwY.type != 1 || b.this.fwZ > 0) {
                    if (b.this.fwY.type == 0) {
                        b.this.a(b.this.fwY);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.fwY);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bsD();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.fwZ;
        bVar.fwZ = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fwV = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fwY = alaEnterEffectData;
            if (this.fwY.type == 1) {
                this.fwZ = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.fwY.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.fwW == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.fwW = (IImageFramePlayerViewController) runTask.getData();
            this.fwW.setFrameCallback(this.fxa);
        }
        if (this.fwW != null) {
            if (this.fwW.getAnimView().getParent() == null) {
                this.fwV.addView(this.fwW.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.fwW.setData(alaDynamicGiftAndNativeData);
            this.fwW.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.fwX == null) {
            this.fwX = new AlaEffectPreviewView(this.mContext);
            this.fwX.setAnimCompleteCallback(this.fxb);
        }
        if (this.fwX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.fwV.addView(this.fwX, layoutParams);
        }
        this.fwX.setData(alaEnterEffectData);
        this.fwX.bsB();
    }

    public void onDestory() {
        if (this.fwW != null) {
            this.fwW.onDestroy();
        }
        if (this.fwX != null) {
            this.fwX.onDestory();
        }
    }
}
