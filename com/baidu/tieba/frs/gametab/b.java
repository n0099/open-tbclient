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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes.dex */
public class b {
    private boolean cOw = false;
    private a.InterfaceC0400a eXk = new a.InterfaceC0400a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int dQA = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void t(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && aj(i2)) {
                b.this.kc(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void u(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && aj(i2)) {
                b.this.kc(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void v(int i, int i2) {
        }

        private boolean aj(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };
    private boolean fKJ;
    private com.baidu.tieba.f.b fyF;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.fKJ = z;
        if (this.fKJ) {
            this.fyF = new com.baidu.tieba.f.b(context);
            this.fyF.a(this.eXk);
        }
    }

    public void c(View view, MotionEvent motionEvent) {
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
                    this.fKJ = false;
                    break;
                } else {
                    this.fKJ = true;
                    break;
                }
        }
        if (this.fKJ && this.fyF != null) {
            this.fyF.onTouchEvent(motionEvent);
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
    public void kc(boolean z) {
        this.cOw = z;
        if (this.fKJ) {
            y(!this.cOw, true);
        }
    }

    private void y(boolean z, boolean z2) {
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
