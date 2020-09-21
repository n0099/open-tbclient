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
    private RelativeLayout gZY;
    private IImageFramePlayerViewController gZZ;
    private AlaEffectPreviewView haa;
    private AlaEnterEffectData hab;
    private int hac = 2;
    private IFrameCallback had = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.hac <= 0 && b.this.hab != null) {
                b.this.a(b.this.hab);
            }
        }
    };
    private a hae = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void caX() {
            b.a(b.this);
            if (b.this.hab != null) {
                if (b.this.hab.type != 1 || b.this.hac > 0) {
                    if (b.this.hab.type == 0) {
                        b.this.a(b.this.hab);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.hab);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void caX();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.hac;
        bVar.hac = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.gZY = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hab = alaEnterEffectData;
            if (this.hab.type == 1) {
                this.hac = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.hab.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gZZ == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gZZ = (IImageFramePlayerViewController) runTask.getData();
            this.gZZ.setFrameCallback(this.had);
        }
        if (this.gZZ != null) {
            if (this.gZZ.getAnimView().getParent() == null) {
                this.gZY.addView(this.gZZ.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gZZ.setData(alaDynamicGiftAndNativeData);
            this.gZZ.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.haa == null) {
            this.haa = new AlaEffectPreviewView(this.mContext);
            this.haa.setAnimCompleteCallback(this.hae);
        }
        if (this.haa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.gZY.addView(this.haa, layoutParams);
        }
        this.haa.setData(alaEnterEffectData);
        this.haa.caV();
    }

    public void onDestory() {
        if (this.gZZ != null) {
            this.gZZ.onDestroy();
        }
        if (this.haa != null) {
            this.haa.onDestory();
        }
    }
}
