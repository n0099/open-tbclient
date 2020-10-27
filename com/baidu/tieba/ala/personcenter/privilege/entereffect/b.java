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
/* loaded from: classes4.dex */
public class b {
    private RelativeLayout hAU;
    private IImageFramePlayerViewController hAV;
    private AlaEffectPreviewView hAW;
    private AlaEnterEffectData hAX;
    private int hAY = 2;
    private IFrameCallback hAZ = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hAY <= 0 && b.this.hAX != null) {
                b.this.a(b.this.hAX);
            }
        }
    };
    private a hBa = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void chx() {
            b.a(b.this);
            if (b.this.hAX != null) {
                if (b.this.hAX.type != 1 || b.this.hAY > 0) {
                    if (b.this.hAX.type == 0) {
                        b.this.a(b.this.hAX);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hAX);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void chx();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hAY;
        bVar.hAY = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hAU = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hAX = alaEnterEffectData;
            if (this.hAX.type == 1) {
                this.hAY = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hAX.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hAV == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hAV = (IImageFramePlayerViewController) runTask.getData();
            this.hAV.setFrameCallback(this.hAZ);
        }
        if (this.hAV != null) {
            if (this.hAV.getAnimView().getParent() == null) {
                this.hAU.addView(this.hAV.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hAV.setData(alaDynamicGiftAndNativeData);
            this.hAV.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hAW == null) {
            this.hAW = new AlaEffectPreviewView(this.mContext);
            this.hAW.setAnimCompleteCallback(this.hBa);
        }
        if (this.hAW.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hAU.addView(this.hAW, layoutParams);
        }
        this.hAW.setData(alaEnterEffectData);
        this.hAW.chv();
    }

    public void onDestory() {
        if (this.hAV != null) {
            this.hAV.onDestroy();
        }
        if (this.hAW != null) {
            this.hAW.onDestory();
        }
    }
}
