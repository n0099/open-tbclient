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
    private RelativeLayout gWn;
    private IImageFramePlayerViewController gWo;
    private AlaEffectPreviewView gWp;
    private AlaEnterEffectData gWq;
    private int gWr = 2;
    private IFrameCallback gWs = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.gWr <= 0 && b.this.gWq != null) {
                b.this.a(b.this.gWq);
            }
        }
    };
    private a gWt = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bZa() {
            b.a(b.this);
            if (b.this.gWq != null) {
                if (b.this.gWq.type != 1 || b.this.gWr > 0) {
                    if (b.this.gWq.type == 0) {
                        b.this.a(b.this.gWq);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.gWq);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bZa();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.gWr;
        bVar.gWr = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.gWn = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gWq = alaEnterEffectData;
            if (this.gWq.type == 1) {
                this.gWr = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.gWq.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gWo == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gWo = (IImageFramePlayerViewController) runTask.getData();
            this.gWo.setFrameCallback(this.gWs);
        }
        if (this.gWo != null) {
            if (this.gWo.getAnimView().getParent() == null) {
                this.gWn.addView(this.gWo.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gWo.setData(alaDynamicGiftAndNativeData);
            this.gWo.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.gWp == null) {
            this.gWp = new AlaEffectPreviewView(this.mContext);
            this.gWp.setAnimCompleteCallback(this.gWt);
        }
        if (this.gWp.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.gWn.addView(this.gWp, layoutParams);
        }
        this.gWp.setData(alaEnterEffectData);
        this.gWp.bYY();
    }

    public void onDestory() {
        if (this.gWo != null) {
            this.gWo.onDestroy();
        }
        if (this.gWp != null) {
            this.gWp.onDestory();
        }
    }
}
