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
    private RelativeLayout icq;
    private IImageFramePlayerViewController icr;
    private AlaEffectPreviewView ics;
    private AlaEnterEffectData ict;
    private int icu = 2;
    private IFrameCallback icv = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.icu <= 0 && b.this.ict != null) {
                b.this.a(b.this.ict);
            }
        }
    };
    private a icw = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cnm() {
            b.a(b.this);
            if (b.this.ict != null) {
                if (b.this.ict.type != 1 || b.this.icu > 0) {
                    if (b.this.ict.type == 0) {
                        b.this.a(b.this.ict);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.ict);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void cnm();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.icu;
        bVar.icu = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.icq = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.ict = alaEnterEffectData;
            if (this.ict.type == 1) {
                this.icu = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.ict.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.icr == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.icr = (IImageFramePlayerViewController) runTask.getData();
            this.icr.setFrameCallback(this.icv);
        }
        if (this.icr != null) {
            if (this.icr.getAnimView().getParent() == null) {
                this.icq.addView(this.icr.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.icr.setData(alaDynamicGiftAndNativeData);
            this.icr.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.ics == null) {
            this.ics = new AlaEffectPreviewView(this.mContext);
            this.ics.setAnimCompleteCallback(this.icw);
        }
        if (this.ics.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.icq.addView(this.ics, layoutParams);
        }
        this.ics.setData(alaEnterEffectData);
        this.ics.cnk();
    }

    public void onDestory() {
        if (this.icr != null) {
            this.icr.onDestroy();
        }
        if (this.ics != null) {
            this.ics.onDestory();
        }
    }
}
