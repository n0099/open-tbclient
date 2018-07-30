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
import com.baidu.tieba.f.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.f.b bKb;
    private boolean dBm;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean aWD = false;
    private a.InterfaceC0145a bKc = new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int cnC = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ae(i2)) {
                b.this.fN(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ae(i2)) {
                b.this.fN(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }

        private boolean ae(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.dBm = z;
        if (this.dBm) {
            this.bKb = new com.baidu.tieba.f.b(context);
            this.bKb.a(this.bKc);
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
                    this.dBm = false;
                    break;
                } else {
                    this.dBm = true;
                    break;
                }
        }
        if (this.dBm && this.bKb != null) {
            this.bKb.onTouchEvent(motionEvent);
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
    public void fN(boolean z) {
        this.aWD = z;
        if (this.dBm) {
            l(!this.aWD, true);
        }
    }

    private void l(boolean z, boolean z2) {
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
