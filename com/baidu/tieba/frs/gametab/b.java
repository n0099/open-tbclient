package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.f.a;
/* loaded from: classes.dex */
public class b {
    private boolean eYw = false;
    private a.InterfaceC0671a hyK = new a.InterfaceC0671a() { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            if (al(i2)) {
                b.this.oH(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            if (al(i2)) {
                b.this.oH(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }

        private boolean al(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };
    private com.baidu.tieba.f.b ieU;
    private boolean isV;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.isV = z;
        if (this.isV) {
            this.ieU = new com.baidu.tieba.f.b(context);
            this.ieU.a(this.hyK);
        }
    }

    public void b(View view, MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                releaseVelocityTracker();
                break;
            case 2:
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(this.mVelocityTracker.getXVelocity()) > Math.abs(this.mVelocityTracker.getYVelocity())) {
                    this.isV = false;
                    break;
                } else {
                    this.isV = true;
                    break;
                }
        }
        if (this.isV && this.ieU != null) {
            this.ieU.onTouchEvent(motionEvent);
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(boolean z) {
        this.eYw = z;
        if (this.isV) {
            H(!this.eYw, true);
        }
    }

    private void H(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
            customMessage.setTag(this.mPageId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
        customMessage2.setTag(this.mPageId);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }
}
