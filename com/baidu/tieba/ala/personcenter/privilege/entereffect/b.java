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
    private RelativeLayout fwU;
    private IImageFramePlayerViewController fwV;
    private AlaEffectPreviewView fwW;
    private AlaEnterEffectData fwX;
    private int fwY = 2;
    private IFrameCallback fwZ = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.fwY <= 0 && b.this.fwX != null) {
                b.this.a(b.this.fwX);
            }
        }
    };
    private a fxa = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bsB() {
            b.a(b.this);
            if (b.this.fwX != null) {
                if (b.this.fwX.type != 1 || b.this.fwY > 0) {
                    if (b.this.fwX.type == 0) {
                        b.this.a(b.this.fwX);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.fwX);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bsB();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.fwY;
        bVar.fwY = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fwU = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fwX = alaEnterEffectData;
            if (this.fwX.type == 1) {
                this.fwY = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.fwX.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.fwV == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.fwV = (IImageFramePlayerViewController) runTask.getData();
            this.fwV.setFrameCallback(this.fwZ);
        }
        if (this.fwV != null) {
            if (this.fwV.getAnimView().getParent() == null) {
                this.fwU.addView(this.fwV.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.fwV.setData(alaDynamicGiftAndNativeData);
            this.fwV.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.fwW == null) {
            this.fwW = new AlaEffectPreviewView(this.mContext);
            this.fwW.setAnimCompleteCallback(this.fxa);
        }
        if (this.fwW.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.fwU.addView(this.fwW, layoutParams);
        }
        this.fwW.setData(alaEnterEffectData);
        this.fwW.bsz();
    }

    public void onDestory() {
        if (this.fwV != null) {
            this.fwV.onDestroy();
        }
        if (this.fwW != null) {
            this.fwW.onDestory();
        }
    }
}
