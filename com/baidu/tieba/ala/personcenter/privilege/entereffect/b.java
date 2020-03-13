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
    private RelativeLayout fxi;
    private IImageFramePlayerViewController fxj;
    private AlaEffectPreviewView fxk;
    private AlaEnterEffectData fxl;
    private int fxm = 2;
    private IFrameCallback fxn = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.fxm <= 0 && b.this.fxl != null) {
                b.this.a(b.this.fxl);
            }
        }
    };
    private a fxo = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bsE() {
            b.a(b.this);
            if (b.this.fxl != null) {
                if (b.this.fxl.type != 1 || b.this.fxm > 0) {
                    if (b.this.fxl.type == 0) {
                        b.this.a(b.this.fxl);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.fxl);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bsE();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.fxm;
        bVar.fxm = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fxi = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fxl = alaEnterEffectData;
            if (this.fxl.type == 1) {
                this.fxm = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.fxl.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.fxj == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.fxj = (IImageFramePlayerViewController) runTask.getData();
            this.fxj.setFrameCallback(this.fxn);
        }
        if (this.fxj != null) {
            if (this.fxj.getAnimView().getParent() == null) {
                this.fxi.addView(this.fxj.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.fxj.setData(alaDynamicGiftAndNativeData);
            this.fxj.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.fxk == null) {
            this.fxk = new AlaEffectPreviewView(this.mContext);
            this.fxk.setAnimCompleteCallback(this.fxo);
        }
        if (this.fxk.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.fxi.addView(this.fxk, layoutParams);
        }
        this.fxk.setData(alaEnterEffectData);
        this.fxk.bsC();
    }

    public void onDestory() {
        if (this.fxj != null) {
            this.fxj.onDestroy();
        }
        if (this.fxk != null) {
            this.fxk.onDestory();
        }
    }
}
