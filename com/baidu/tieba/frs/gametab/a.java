package com.baidu.tieba.frs.gametab;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class a {
    private int aLA = 0;
    private boolean aLB = false;
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.gametab.a.1
        final int bwS = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            if (Y(i2)) {
                a.this.en(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                a.this.en(true);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private BaseFragment bhx;
    private com.baidu.tieba.e.b ckS;
    private boolean css;

    public a(BaseFragment baseFragment, boolean z) {
        this.bhx = baseFragment;
        this.css = z;
        if (this.css) {
            this.ckS = new com.baidu.tieba.e.b(baseFragment.getActivity());
            this.ckS.a(this.bUZ);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.css) {
            this.aLA = i;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.css && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aLA) {
                m(false, true);
            } else if (firstVisiblePosition < this.aLA) {
                m(true, true);
            } else if (firstVisiblePosition == this.aLA) {
                if (!this.aLB || firstVisiblePosition <= 0 || a(absListView)) {
                    m(true, true);
                } else {
                    m(false, true);
                }
            }
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.css && this.ckS != null) {
            this.ckS.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        this.aLB = z;
    }

    private boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void m(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
            customMessage.setTag(this.bhx.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
        customMessage2.setTag(this.bhx.getBaseFragmentActivity().getUniqueId());
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }
}
