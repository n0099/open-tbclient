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
/* loaded from: classes9.dex */
public class b {
    private RelativeLayout ier;
    private IImageFramePlayerViewController ies;
    private AlaEffectPreviewView iet;
    private AlaEnterEffectData ieu;
    private int iev = 2;
    private IFrameCallback iew = new IFrameCallback() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.1
        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.a(b.this);
            if (b.this.iev <= 0 && b.this.ieu != null) {
                b.this.a(b.this.ieu);
            }
        }
    };
    private a iex = new a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.b.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.b.a
        public void cnz() {
            b.a(b.this);
            if (b.this.ieu != null) {
                if (b.this.ieu.type != 1 || b.this.iev > 0) {
                    if (b.this.ieu.type == 0) {
                        b.this.a(b.this.ieu);
                        return;
                    }
                    return;
                }
                b.this.a(b.this.ieu);
            }
        }
    };
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void cnz();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.iev;
        bVar.iev = i - 1;
        return i;
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.ier = relativeLayout;
    }

    public void a(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.ieu = alaEnterEffectData;
            if (this.ieu.type == 1) {
                this.iev = 2;
                b(alaEnterEffectData);
                c(alaEnterEffectData);
            } else if (this.ieu.type == 0) {
                c(alaEnterEffectData);
            }
        }
    }

    private void b(AlaEnterEffectData alaEnterEffectData) {
        CustomResponsedMessage runTask;
        if (this.ies == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.mContext)) != null && runTask.getData() != null) {
            this.ies = (IImageFramePlayerViewController) runTask.getData();
            this.ies.setFrameCallback(this.iew);
        }
        if (this.ies != null) {
            if (this.ies.getAnimView().getParent() == null) {
                this.ier.addView(this.ies.getAnimView(), new RelativeLayout.LayoutParams(-1, l.getEquipmentHeight(this.mContext)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaEnterEffectData.gift;
            if (alaDynamicGiftAndNativeData.mAlaDynamicGift != null && alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo != null) {
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.isBottomMargin = 1;
                alaDynamicGiftAndNativeData.mAlaDynamicGift.configInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.ies.setData(alaDynamicGiftAndNativeData);
            this.ies.startAnim();
        }
    }

    private void c(AlaEnterEffectData alaEnterEffectData) {
        if (this.iet == null) {
            this.iet = new AlaEffectPreviewView(this.mContext);
            this.iet.setAnimCompleteCallback(this.iex);
        }
        if (this.iet.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.ier.addView(this.iet, layoutParams);
        }
        this.iet.setData(alaEnterEffectData);
        this.iet.cnx();
    }

    public void onDestory() {
        if (this.ies != null) {
            this.ies.onDestroy();
        }
        if (this.iet != null) {
            this.iet.onDestory();
        }
    }
}
