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
    private com.baidu.tieba.e.b bHH;
    private boolean cWv;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean aNh = false;
    private a.InterfaceC0083a bHI = new a.InterfaceC0083a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int bRc = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void af(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && K(i2)) {
                b.this.fb(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ag(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && K(i2)) {
                b.this.fb(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ah(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.cWv = z;
        if (this.cWv) {
            this.bHH = new com.baidu.tieba.e.b(context);
            this.bHH.a(this.bHI);
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                lj();
                break;
            case 2:
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(this.mVelocityTracker.getXVelocity()) > Math.abs(this.mVelocityTracker.getYVelocity())) {
                    this.cWv = false;
                    break;
                } else {
                    this.cWv = true;
                    break;
                }
        }
        if (this.cWv && this.bHH != null) {
            this.bHH.onTouchEvent(motionEvent);
        }
    }

    private void lj() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        this.aNh = z;
        if (this.cWv) {
            n(!this.aNh, true);
        }
    }

    private void n(boolean z, boolean z2) {
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
