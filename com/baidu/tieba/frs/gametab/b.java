package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.e.b ckT;
    private boolean dNS;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean bBr = false;
    private a.InterfaceC0109a ckU = new a.InterfaceC0109a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int cGo = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && Z(i2)) {
                b.this.fP(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && Z(i2)) {
                b.this.fP(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }

        private boolean Z(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.dNS = z;
        if (this.dNS) {
            this.ckT = new com.baidu.tieba.e.b(context);
            this.ckT.a(this.ckU);
        }
    }

    public void f(View view, MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                iJ();
                break;
            case 2:
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(this.mVelocityTracker.getXVelocity()) > Math.abs(this.mVelocityTracker.getYVelocity())) {
                    this.dNS = false;
                    break;
                } else {
                    this.dNS = true;
                    break;
                }
        }
        if (this.dNS && this.ckT != null) {
            this.ckT.onTouchEvent(motionEvent);
        }
    }

    private void iJ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(boolean z) {
        this.bBr = z;
        if (this.dNS) {
            p(!this.bBr, true);
        }
    }

    private void p(boolean z, boolean z2) {
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
