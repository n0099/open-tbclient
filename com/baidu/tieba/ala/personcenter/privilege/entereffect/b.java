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
    private RelativeLayout ezJ;
    private IImageFramePlayerViewController ezK;
    private AlaEffectPreviewView ezL;
    private AlaEnterEffectData ezM;
    private int ezN = 2;
    private IFrameCallback ezO = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.ezN <= 0 && b.this.ezM != null) {
                b.this.a(b.this.ezM);
            }
        }
    };
    private a ezP = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void aYa() {
            b.a(b.this);
            if (b.this.ezM != null) {
                if (b.this.ezM.type != 1 || b.this.ezN > 0) {
                    if (b.this.ezM.type == 0) {
                        b.this.a(b.this.ezM);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.ezM);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void aYa();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.ezN;
        bVar.ezN = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.ezJ = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.ezM = alaEnterEffectData;
            if (this.ezM.type == 1) {
                this.ezN = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.ezM.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.ezK == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.ezK = (IImageFramePlayerViewController) runTask.getData();
            this.ezK.setFrameCallback(this.ezO);
        }
        if (this.ezK != null) {
            if (this.ezK.getAnimView().getParent() == null) {
                this.ezJ.addView(this.ezK.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.ezK.setData(alaDynamicGiftAndNativeData);
            this.ezK.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.ezL == null) {
            this.ezL = new AlaEffectPreviewView(this.mContext);
            this.ezL.setAnimCompleteCallback(this.ezP);
        }
        if (this.ezL.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.ezJ.addView(this.ezL, layoutParams);
        }
        this.ezL.setData(alaEnterEffectData);
        this.ezL.aXY();
    }

    public void onDestory() {
        if (this.ezK != null) {
            this.ezK.onDestroy();
        }
        if (this.ezL != null) {
            this.ezL.onDestory();
        }
    }
}
