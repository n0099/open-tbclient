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
/* loaded from: classes6.dex */
public class b {
    private RelativeLayout hQf;
    private IImageFramePlayerViewController hQg;
    private AlaEffectPreviewView hQh;
    private AlaEnterEffectData hQi;
    private int hQj = 2;
    private IFrameCallback hQk = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hQj <= 0 && b.this.hQi != null) {
                b.this.a(b.this.hQi);
            }
        }
    };
    private a hQl = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cnm() {
            b.a(b.this);
            if (b.this.hQi != null) {
                if (b.this.hQi.type != 1 || b.this.hQj > 0) {
                    if (b.this.hQi.type == 0) {
                        b.this.a(b.this.hQi);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hQi);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void cnm();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hQj;
        bVar.hQj = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hQf = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hQi = alaEnterEffectData;
            if (this.hQi.type == 1) {
                this.hQj = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hQi.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hQg == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hQg = (IImageFramePlayerViewController) runTask.getData();
            this.hQg.setFrameCallback(this.hQk);
        }
        if (this.hQg != null) {
            if (this.hQg.getAnimView().getParent() == null) {
                this.hQf.addView(this.hQg.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hQg.setData(alaDynamicGiftAndNativeData);
            this.hQg.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hQh == null) {
            this.hQh = new AlaEffectPreviewView(this.mContext);
            this.hQh.setAnimCompleteCallback(this.hQl);
        }
        if (this.hQh.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hQf.addView(this.hQh, layoutParams);
        }
        this.hQh.setData(alaEnterEffectData);
        this.hQh.cnk();
    }

    public void onDestory() {
        if (this.hQg != null) {
            this.hQg.onDestroy();
        }
        if (this.hQh != null) {
            this.hQh.onDestory();
        }
    }
}
