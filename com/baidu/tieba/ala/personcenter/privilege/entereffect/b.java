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
/* loaded from: classes10.dex */
public class b {
    private RelativeLayout icE;
    private IImageFramePlayerViewController icF;
    private AlaEffectPreviewView icG;
    private AlaEnterEffectData icH;
    private int icI = 2;
    private IFrameCallback icJ = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.icI <= 0 && b.this.icH != null) {
                b.this.a(b.this.icH);
            }
        }
    };
    private a icK = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cnt() {
            b.a(b.this);
            if (b.this.icH != null) {
                if (b.this.icH.type != 1 || b.this.icI > 0) {
                    if (b.this.icH.type == 0) {
                        b.this.a(b.this.icH);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.icH);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void cnt();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.icI;
        bVar.icI = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.icE = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.icH = alaEnterEffectData;
            if (this.icH.type == 1) {
                this.icI = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.icH.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.icF == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.icF = (IImageFramePlayerViewController) runTask.getData();
            this.icF.setFrameCallback(this.icJ);
        }
        if (this.icF != null) {
            if (this.icF.getAnimView().getParent() == null) {
                this.icE.addView(this.icF.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.icF.setData(alaDynamicGiftAndNativeData);
            this.icF.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.icG == null) {
            this.icG = new AlaEffectPreviewView(this.mContext);
            this.icG.setAnimCompleteCallback(this.icK);
        }
        if (this.icG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.icE.addView(this.icG, layoutParams);
        }
        this.icG.setData(alaEnterEffectData);
        this.icG.cnr();
    }

    public void onDestory() {
        if (this.icF != null) {
            this.icF.onDestroy();
        }
        if (this.icG != null) {
            this.icG.onDestory();
        }
    }
}
