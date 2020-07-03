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
    private RelativeLayout gEn;
    private IImageFramePlayerViewController gEo;
    private AlaEffectPreviewView gEp;
    private AlaEnterEffectData gEq;
    private int gEr = 2;
    private IFrameCallback gEs = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.gEr <= 0 && b.this.gEq != null) {
                b.this.a(b.this.gEq);
            }
        }
    };
    private a gEt = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bLR() {
            b.a(b.this);
            if (b.this.gEq != null) {
                if (b.this.gEq.type != 1 || b.this.gEr > 0) {
                    if (b.this.gEq.type == 0) {
                        b.this.a(b.this.gEq);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.gEq);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bLR();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.gEr;
        bVar.gEr = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.gEn = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gEq = alaEnterEffectData;
            if (this.gEq.type == 1) {
                this.gEr = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.gEq.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gEo == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gEo = (IImageFramePlayerViewController) runTask.getData();
            this.gEo.setFrameCallback(this.gEs);
        }
        if (this.gEo != null) {
            if (this.gEo.getAnimView().getParent() == null) {
                this.gEn.addView(this.gEo.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gEo.setData(alaDynamicGiftAndNativeData);
            this.gEo.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.gEp == null) {
            this.gEp = new AlaEffectPreviewView(this.mContext);
            this.gEp.setAnimCompleteCallback(this.gEt);
        }
        if (this.gEp.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.gEn.addView(this.gEp, layoutParams);
        }
        this.gEp.setData(alaEnterEffectData);
        this.gEp.bLP();
    }

    public void onDestory() {
        if (this.gEo != null) {
            this.gEo.onDestroy();
        }
        if (this.gEp != null) {
            this.gEp.onDestory();
        }
    }
}
