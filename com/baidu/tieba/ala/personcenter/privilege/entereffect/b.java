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
    private RelativeLayout gct;
    private IImageFramePlayerViewController gcu;
    private AlaEffectPreviewView gcv;
    private AlaEnterEffectData gcw;
    private int gcx = 2;
    private IFrameCallback gcy = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.gcx <= 0 && b.this.gcw != null) {
                b.this.a(b.this.gcw);
            }
        }
    };
    private a gcz = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bCq() {
            b.a(b.this);
            if (b.this.gcw != null) {
                if (b.this.gcw.type != 1 || b.this.gcx > 0) {
                    if (b.this.gcw.type == 0) {
                        b.this.a(b.this.gcw);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.gcw);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bCq();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.gcx;
        bVar.gcx = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.gct = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gcw = alaEnterEffectData;
            if (this.gcw.type == 1) {
                this.gcx = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.gcw.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gcu == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gcu = (IImageFramePlayerViewController) runTask.getData();
            this.gcu.setFrameCallback(this.gcy);
        }
        if (this.gcu != null) {
            if (this.gcu.getAnimView().getParent() == null) {
                this.gct.addView(this.gcu.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gcu.setData(alaDynamicGiftAndNativeData);
            this.gcu.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.gcv == null) {
            this.gcv = new AlaEffectPreviewView(this.mContext);
            this.gcv.setAnimCompleteCallback(this.gcz);
        }
        if (this.gcv.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.gct.addView(this.gcv, layoutParams);
        }
        this.gcv.setData(alaEnterEffectData);
        this.gcv.bCo();
    }

    public void onDestory() {
        if (this.gcu != null) {
            this.gcu.onDestroy();
        }
        if (this.gcv != null) {
            this.gcv.onDestory();
        }
    }
}
