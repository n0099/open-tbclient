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
    private RelativeLayout hGR;
    private IImageFramePlayerViewController hGS;
    private AlaEffectPreviewView hGT;
    private AlaEnterEffectData hGU;
    private int hGV = 2;
    private IFrameCallback hGW = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hGV <= 0 && b.this.hGU != null) {
                b.this.a(b.this.hGU);
            }
        }
    };
    private a hGX = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cjZ() {
            b.a(b.this);
            if (b.this.hGU != null) {
                if (b.this.hGU.type != 1 || b.this.hGV > 0) {
                    if (b.this.hGU.type == 0) {
                        b.this.a(b.this.hGU);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hGU);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void cjZ();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hGV;
        bVar.hGV = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hGR = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hGU = alaEnterEffectData;
            if (this.hGU.type == 1) {
                this.hGV = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hGU.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hGS == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hGS = (IImageFramePlayerViewController) runTask.getData();
            this.hGS.setFrameCallback(this.hGW);
        }
        if (this.hGS != null) {
            if (this.hGS.getAnimView().getParent() == null) {
                this.hGR.addView(this.hGS.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hGS.setData(alaDynamicGiftAndNativeData);
            this.hGS.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hGT == null) {
            this.hGT = new AlaEffectPreviewView(this.mContext);
            this.hGT.setAnimCompleteCallback(this.hGX);
        }
        if (this.hGT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hGR.addView(this.hGT, layoutParams);
        }
        this.hGT.setData(alaEnterEffectData);
        this.hGT.cjX();
    }

    public void onDestory() {
        if (this.hGS != null) {
            this.hGS.onDestroy();
        }
        if (this.hGT != null) {
            this.hGT.onDestory();
        }
    }
}
