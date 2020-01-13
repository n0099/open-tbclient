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
/* loaded from: classes2.dex */
public class b {
    private RelativeLayout fut;
    private IImageFramePlayerViewController fuu;
    private AlaEffectPreviewView fuv;
    private AlaEnterEffectData fuw;
    private int fux = 2;
    private IFrameCallback fuy = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.fux <= 0 && b.this.fuw != null) {
                b.this.a(b.this.fuw);
            }
        }
    };
    private a fuz = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bqX() {
            b.a(b.this);
            if (b.this.fuw != null) {
                if (b.this.fuw.type != 1 || b.this.fux > 0) {
                    if (b.this.fuw.type == 0) {
                        b.this.a(b.this.fuw);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.fuw);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void bqX();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.fux;
        bVar.fux = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fut = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fuw = alaEnterEffectData;
            if (this.fuw.type == 1) {
                this.fux = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.fuw.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.fuu == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.fuu = (IImageFramePlayerViewController) runTask.getData();
            this.fuu.setFrameCallback(this.fuy);
        }
        if (this.fuu != null) {
            if (this.fuu.getAnimView().getParent() == null) {
                this.fut.addView(this.fuu.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.fuu.setData(alaDynamicGiftAndNativeData);
            this.fuu.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.fuv == null) {
            this.fuv = new AlaEffectPreviewView(this.mContext);
            this.fuv.setAnimCompleteCallback(this.fuz);
        }
        if (this.fuv.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.fut.addView(this.fuv, layoutParams);
        }
        this.fuv.setData(alaEnterEffectData);
        this.fuv.bqV();
    }

    public void onDestory() {
        if (this.fuu != null) {
            this.fuu.onDestroy();
        }
        if (this.fuv != null) {
            this.fuv.onDestory();
        }
    }
}
