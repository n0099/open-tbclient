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
    private boolean evu = false;
    private a.InterfaceC0607a gLT = new a.InterfaceC0607a() { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (ad(i2)) {
                b.this.nf(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (ad(i2)) {
                b.this.nf(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };
    private boolean hDK;
    private com.baidu.tieba.f.b hrk;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.hDK = z;
        if (this.hDK) {
            this.hrk = new com.baidu.tieba.f.b(context);
            this.hrk.a(this.gLT);
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
                    this.hDK = false;
                    break;
                } else {
                    this.hDK = true;
                    break;
                }
        }
        if (this.hDK && this.hrk != null) {
            this.hrk.onTouchEvent(motionEvent);
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
    public void nf(boolean z) {
        this.evu = z;
        if (this.hDK) {
            D(!this.evu, true);
        }
    }

    private void D(boolean z, boolean z2) {
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
