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
    private RelativeLayout icD;
    private IImageFramePlayerViewController icE;
    private AlaEffectPreviewView icF;
    private AlaEnterEffectData icG;
    private int icH = 2;
    private IFrameCallback icI = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.icH <= 0 && b.this.icG != null) {
                b.this.a(b.this.icG);
            }
        }
    };
    private a icJ = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cqf() {
            b.a(b.this);
            if (b.this.icG != null) {
                if (b.this.icG.type != 1 || b.this.icH > 0) {
                    if (b.this.icG.type == 0) {
                        b.this.a(b.this.icG);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.icG);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void cqf();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.icH;
        bVar.icH = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.icD = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.icG = alaEnterEffectData;
            if (this.icG.type == 1) {
                this.icH = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.icG.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.icE == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.icE = (IImageFramePlayerViewController) runTask.getData();
            this.icE.setFrameCallback(this.icI);
        }
        if (this.icE != null) {
            if (this.icE.getAnimView().getParent() == null) {
                this.icD.addView(this.icE.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.icE.setData(alaDynamicGiftAndNativeData);
            this.icE.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.icF == null) {
            this.icF = new AlaEffectPreviewView(this.mContext);
            this.icF.setAnimCompleteCallback(this.icJ);
        }
        if (this.icF.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.icD.addView(this.icF, layoutParams);
        }
        this.icF.setData(alaEnterEffectData);
        this.icF.cqd();
    }

    public void onDestory() {
        if (this.icE != null) {
            this.icE.onDestroy();
        }
        if (this.icF != null) {
            this.icF.onDestory();
        }
    }
}
