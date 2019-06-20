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
    private com.baidu.tieba.f.b dWj;
    private boolean fEF;
    private Context mContext;
    private BdUniqueId mPageId;
    private VelocityTracker mVelocityTracker;
    private boolean cBS = false;
    private a.InterfaceC0302a dWk = new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.gametab.b.1
        final int egj = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ax(i2)) {
                b.this.kb(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (Math.abs(i) <= Math.abs(i2) && ax(i2)) {
                b.this.kb(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 10.0f;
        }
    };

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.fEF = z;
        if (this.fEF) {
            this.dWj = new com.baidu.tieba.f.b(context);
            this.dWj.a(this.dWk);
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
                    this.fEF = false;
                    break;
                } else {
                    this.fEF = true;
                    break;
                }
        }
        if (this.fEF && this.dWj != null) {
            this.dWj.onTouchEvent(motionEvent);
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
    public void kb(boolean z) {
        this.cBS = z;
        if (this.fEF) {
            t(!this.cBS, true);
        }
    }

    private void t(boolean z, boolean z2) {
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
