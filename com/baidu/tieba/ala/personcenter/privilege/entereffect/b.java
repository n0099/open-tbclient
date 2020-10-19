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
    private RelativeLayout hoZ;
    private IImageFramePlayerViewController hpa;
    private AlaEffectPreviewView hpb;
    private AlaEnterEffectData hpc;
    private int hpd = 2;
    private IFrameCallback hpe = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hpd <= 0 && b.this.hpc != null) {
                b.this.a(b.this.hpc);
            }
        }
    };
    private a hpf = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cev() {
            b.a(b.this);
            if (b.this.hpc != null) {
                if (b.this.hpc.type != 1 || b.this.hpd > 0) {
                    if (b.this.hpc.type == 0) {
                        b.this.a(b.this.hpc);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hpc);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void cev();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hpd;
        bVar.hpd = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hoZ = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hpc = alaEnterEffectData;
            if (this.hpc.type == 1) {
                this.hpd = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hpc.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hpa == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hpa = (IImageFramePlayerViewController) runTask.getData();
            this.hpa.setFrameCallback(this.hpe);
        }
        if (this.hpa != null) {
            if (this.hpa.getAnimView().getParent() == null) {
                this.hoZ.addView(this.hpa.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hpa.setData(alaDynamicGiftAndNativeData);
            this.hpa.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hpb == null) {
            this.hpb = new AlaEffectPreviewView(this.mContext);
            this.hpb.setAnimCompleteCallback(this.hpf);
        }
        if (this.hpb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hoZ.addView(this.hpb, layoutParams);
        }
        this.hpb.setData(alaEnterEffectData);
        this.hpb.cet();
    }

    public void onDestory() {
        if (this.hpa != null) {
            this.hpa.onDestroy();
        }
        if (this.hpb != null) {
            this.hpb.onDestory();
        }
    }
}
