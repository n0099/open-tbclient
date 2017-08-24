package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class a {
    private int aMR = 0;
    private boolean aMS = false;
    private a.InterfaceC0080a bWS = new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.gametab.a.1
        final int byM = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                a.this.eo(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2)) {
                a.this.eo(true);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private com.baidu.tieba.e.b cmN;
    private boolean cvH;
    private Context mContext;
    private BdUniqueId mPageId;

    public a(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.cvH = z;
        if (this.cvH) {
            this.cmN = new com.baidu.tieba.e.b(context);
            this.cmN.a(this.bWS);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cvH) {
            this.aMR = i;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.cvH && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aMR) {
                l(false, true);
            } else if (firstVisiblePosition < this.aMR) {
                l(true, true);
            } else if (firstVisiblePosition == this.aMR) {
                if (!this.aMS || firstVisiblePosition <= 0 || a(absListView)) {
                    l(true, true);
                } else {
                    l(false, true);
                }
            }
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.cvH && this.cmN != null) {
            this.cmN.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        this.aMS = z;
    }

    private boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void l(boolean z, boolean z2) {
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
