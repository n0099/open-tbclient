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
import com.baidu.tieba.g.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.g.b iMX;
    private boolean jaT;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean fym = false;
    private a.InterfaceC0740a igS = new a.InterfaceC0740a() { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            if (ax(i2)) {
                b.this.pQ(true);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            if (ax(i2)) {
                b.this.pQ(false);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.jaT = z;
        if (this.jaT) {
            this.iMX = new com.baidu.tieba.g.b(context);
            this.iMX.a(this.igS);
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
                    this.jaT = false;
                    break;
                } else {
                    this.jaT = true;
                    break;
                }
        }
        if (this.jaT && this.iMX != null) {
            this.iMX.onTouchEvent(motionEvent);
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
    public void pQ(boolean z) {
        this.fym = z;
        if (this.jaT) {
            J(!this.fym, true);
        }
    }

    private void J(boolean z, boolean z2) {
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
