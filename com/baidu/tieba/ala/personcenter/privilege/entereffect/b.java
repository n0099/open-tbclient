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
    private RelativeLayout grn;
    private IImageFramePlayerViewController gro;
    private AlaEffectPreviewView grp;
    private AlaEnterEffectData grq;
    private int grr = 2;
    private IFrameCallback grs = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.grr <= 0 && b.this.grq != null) {
                b.this.a(b.this.grq);
            }
        }
    };
    private a grt = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void bIK() {
            b.a(b.this);
            if (b.this.grq != null) {
                if (b.this.grq.type != 1 || b.this.grr > 0) {
                    if (b.this.grq.type == 0) {
                        b.this.a(b.this.grq);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.grq);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bIK();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.grr;
        bVar.grr = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.grn = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.grq = alaEnterEffectData;
            if (this.grq.type == 1) {
                this.grr = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.grq.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.gro == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.gro = (IImageFramePlayerViewController) runTask.getData();
            this.gro.setFrameCallback(this.grs);
        }
        if (this.gro != null) {
            if (this.gro.getAnimView().getParent() == null) {
                this.grn.addView(this.gro.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.gro.setData(alaDynamicGiftAndNativeData);
            this.gro.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.grp == null) {
            this.grp = new AlaEffectPreviewView(this.mContext);
            this.grp.setAnimCompleteCallback(this.grt);
        }
        if (this.grp.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.grn.addView(this.grp, layoutParams);
        }
        this.grp.setData(alaEnterEffectData);
        this.grp.bII();
    }

    public void onDestory() {
        if (this.gro != null) {
            this.gro.onDestroy();
        }
        if (this.grp != null) {
            this.grp.onDestory();
        }
    }
}
