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
    private RelativeLayout gWr;
    private IImageFramePlayerViewController gWs;
    private AlaEffectPreviewView gWt;
    private AlaEnterEffectData gWu;
    private int gWv = 2;
    private IFrameCallback gWw = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.gWv <= 0 && b.this.gWu != null) {
                b.this.a(b.this.gWu);
            }
        }
    };
    private a gWx = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bZb() {
            b.a(b.this);
            if (b.this.gWu != null) {
                if (b.this.gWu.type != 1 || b.this.gWv > 0) {
                    if (b.this.gWu.type == 0) {
                        b.this.a(b.this.gWu);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.gWu);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bZb();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.gWv;
        bVar.gWv = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.gWr = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gWu = alaEnterEffectData;
            if (this.gWu.type == 1) {
                this.gWv = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.gWu.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gWs == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gWs = (IImageFramePlayerViewController) runTask.getData();
            this.gWs.setFrameCallback(this.gWw);
        }
        if (this.gWs != null) {
            if (this.gWs.getAnimView().getParent() == null) {
                this.gWr.addView(this.gWs.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gWs.setData(alaDynamicGiftAndNativeData);
            this.gWs.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.gWt == null) {
            this.gWt = new AlaEffectPreviewView(this.mContext);
            this.gWt.setAnimCompleteCallback(this.gWx);
        }
        if (this.gWt.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.gWr.addView(this.gWt, layoutParams);
        }
        this.gWt.setData(alaEnterEffectData);
        this.gWt.bYZ();
    }

    public void onDestory() {
        if (this.gWs != null) {
            this.gWs.onDestroy();
        }
        if (this.gWt != null) {
            this.gWt.onDestory();
        }
    }
}
