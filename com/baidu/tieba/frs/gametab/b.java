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
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.e.b coo;
    private boolean dQS;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean bDv = false;
    private a.InterfaceC0142a cop = new a.InterfaceC0142a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int cKm = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aY(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && af(i2)) {
                b.this.fW(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aZ(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && af(i2)) {
                b.this.fW(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void ba(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.dQS = z;
        if (this.dQS) {
            this.coo = new com.baidu.tieba.e.b(context);
            this.coo.a(this.cop);
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
                    this.dQS = false;
                    break;
                } else {
                    this.dQS = true;
                    break;
                }
        }
        if (this.dQS && this.coo != null) {
            this.coo.onTouchEvent(motionEvent);
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
    public void fW(boolean z) {
        this.bDv = z;
        if (this.dQS) {
            p(!this.bDv, true);
        }
    }

    private void p(boolean z, boolean z2) {
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
