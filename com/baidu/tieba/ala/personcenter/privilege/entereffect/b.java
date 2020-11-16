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
    private AlaEffectPreviewView hGA;
    private AlaEnterEffectData hGB;
    private int hGC = 2;
    private IFrameCallback hGD = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hGC <= 0 && b.this.hGB != null) {
                b.this.a(b.this.hGB);
            }
        }
    };
    private a hGE = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cjs() {
            b.a(b.this);
            if (b.this.hGB != null) {
                if (b.this.hGB.type != 1 || b.this.hGC > 0) {
                    if (b.this.hGB.type == 0) {
                        b.this.a(b.this.hGB);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hGB);
            }
        }
    };
    private RelativeLayout hGy;
    private IImageFramePlayerViewController hGz;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void cjs();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hGC;
        bVar.hGC = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hGy = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hGB = alaEnterEffectData;
            if (this.hGB.type == 1) {
                this.hGC = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hGB.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hGz == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hGz = (IImageFramePlayerViewController) runTask.getData();
            this.hGz.setFrameCallback(this.hGD);
        }
        if (this.hGz != null) {
            if (this.hGz.getAnimView().getParent() == null) {
                this.hGy.addView(this.hGz.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hGz.setData(alaDynamicGiftAndNativeData);
            this.hGz.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hGA == null) {
            this.hGA = new AlaEffectPreviewView(this.mContext);
            this.hGA.setAnimCompleteCallback(this.hGE);
        }
        if (this.hGA.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hGy.addView(this.hGA, layoutParams);
        }
        this.hGA.setData(alaEnterEffectData);
        this.hGA.cjq();
    }

    public void onDestory() {
        if (this.hGz != null) {
            this.hGz.onDestroy();
        }
        if (this.hGA != null) {
            this.hGA.onDestory();
        }
    }
}
