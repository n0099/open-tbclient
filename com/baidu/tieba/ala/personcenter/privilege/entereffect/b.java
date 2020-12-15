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
    private RelativeLayout hQh;
    private IImageFramePlayerViewController hQi;
    private AlaEffectPreviewView hQj;
    private AlaEnterEffectData hQk;
    private int hQl = 2;
    private IFrameCallback hQm = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hQl <= 0 && b.this.hQk != null) {
                b.this.a(b.this.hQk);
            }
        }
    };
    private a hQn = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cnn() {
            b.a(b.this);
            if (b.this.hQk != null) {
                if (b.this.hQk.type != 1 || b.this.hQl > 0) {
                    if (b.this.hQk.type == 0) {
                        b.this.a(b.this.hQk);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hQk);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void cnn();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hQl;
        bVar.hQl = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.hQh = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hQk = alaEnterEffectData;
            if (this.hQk.type == 1) {
                this.hQl = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hQk.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.hQi == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.hQi = (IImageFramePlayerViewController) runTask.getData();
            this.hQi.setFrameCallback(this.hQm);
        }
        if (this.hQi != null) {
            if (this.hQi.getAnimView().getParent() == null) {
                this.hQh.addView(this.hQi.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.hQi.setData(alaDynamicGiftAndNativeData);
            this.hQi.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.hQj == null) {
            this.hQj = new AlaEffectPreviewView(this.mContext);
            this.hQj.setAnimCompleteCallback(this.hQn);
        }
        if (this.hQj.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.hQh.addView(this.hQj, layoutParams);
        }
        this.hQj.setData(alaEnterEffectData);
        this.hQj.cnl();
    }

    public void onDestory() {
        if (this.hQi != null) {
            this.hQi.onDestroy();
        }
        if (this.hQj != null) {
            this.hQj.onDestory();
        }
    }
}
