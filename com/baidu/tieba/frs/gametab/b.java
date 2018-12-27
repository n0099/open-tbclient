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
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.f.b cwP;
    private Context mContext;
    private boolean mIsEnable;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean biN = false;
    private a.InterfaceC0214a cwQ = new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int cIa = (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ag(i2)) {
                b.this.gQ(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ag(i2)) {
                b.this.gQ(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mIsEnable = z;
        if (this.mIsEnable) {
            this.cwP = new com.baidu.tieba.f.b(context);
            this.cwP.a(this.cwQ);
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
                releaseVelocityTracker();
                break;
            case 2:
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(this.mVelocityTracker.getXVelocity()) > Math.abs(this.mVelocityTracker.getYVelocity())) {
                    this.mIsEnable = false;
                    break;
                } else {
                    this.mIsEnable = true;
                    break;
                }
        }
        if (this.mIsEnable && this.cwP != null) {
            this.cwP.onTouchEvent(motionEvent);
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
    public void gQ(boolean z) {
        this.biN = z;
        if (this.mIsEnable) {
            o(!this.biN, true);
        }
    }

    private void o(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.mPageId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.mPageId);
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }
}
