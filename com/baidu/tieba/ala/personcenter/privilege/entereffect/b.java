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
    private RelativeLayout frj;
    private IImageFramePlayerViewController frk;
    private AlaEffectPreviewView frl;
    private AlaEnterEffectData frm;
    private int frn = 2;
    private IFrameCallback fro = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.frn <= 0 && b.this.frm != null) {
                b.this.a(b.this.frm);
            }
        }
    };
    private a frp = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bpW() {
            b.a(b.this);
            if (b.this.frm != null) {
                if (b.this.frm.type != 1 || b.this.frn > 0) {
                    if (b.this.frm.type == 0) {
                        b.this.a(b.this.frm);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.frm);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void bpW();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.frn;
        bVar.frn = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.frj = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.frm = alaEnterEffectData;
            if (this.frm.type == 1) {
                this.frn = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.frm.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.frk == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.frk = (IImageFramePlayerViewController) runTask.getData();
            this.frk.setFrameCallback(this.fro);
        }
        if (this.frk != null) {
            if (this.frk.getAnimView().getParent() == null) {
                this.frj.addView(this.frk.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.frk.setData(alaDynamicGiftAndNativeData);
            this.frk.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.frl == null) {
            this.frl = new AlaEffectPreviewView(this.mContext);
            this.frl.setAnimCompleteCallback(this.frp);
        }
        if (this.frl.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.frj.addView(this.frl, layoutParams);
        }
        this.frl.setData(alaEnterEffectData);
        this.frl.bpU();
    }

    public void onDestory() {
        if (this.frk != null) {
            this.frk.onDestroy();
        }
        if (this.frl != null) {
            this.frl.onDestory();
        }
    }
}
