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
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.f.b eab;
    private boolean fJD;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean cDj = false;
    private a.InterfaceC0305a eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int ekN = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ax(i2)) {
                b.this.kl(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ax(i2)) {
                b.this.kl(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.fJD = z;
        if (this.fJD) {
            this.eab = new com.baidu.tieba.f.b(context);
            this.eab.a(this.eac);
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
                releaseVelocityTracker();
                break;
            case 2:
                this.mVelocityTracker.computeCurrentVelocity(1000);
                if (Math.abs(this.mVelocityTracker.getXVelocity()) > Math.abs(this.mVelocityTracker.getYVelocity())) {
                    this.fJD = false;
                    break;
                } else {
                    this.fJD = true;
                    break;
                }
        }
        if (this.fJD && this.eab != null) {
            this.eab.onTouchEvent(motionEvent);
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
    public void kl(boolean z) {
        this.cDj = z;
        if (this.fJD) {
            v(!this.cDj, true);
        }
    }

    private void v(boolean z, boolean z2) {
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
