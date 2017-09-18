package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.MotionEvent;
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
public class a {
    private boolean cDd;
    private com.baidu.tieba.e.b csZ;
    private Context mContext;
    private BdUniqueId mPageId;
    private boolean aMv = false;
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.gametab.a.1
        final int bAv = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ak(int i, int i2) {
            if (N(i2)) {
                a.this.es(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void al(int i, int i2) {
            if (N(i2)) {
                a.this.es(true);
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 5.0f;
        }
    };

    public a(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.cDd = z;
        if (this.cDd) {
            this.csZ = new com.baidu.tieba.e.b(context);
            this.csZ.a(this.caG);
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.cDd && this.csZ != null) {
            this.csZ.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        this.aMv = z;
        if (this.cDd) {
            m(!this.aMv, true);
        }
    }

    private void m(boolean z, boolean z2) {
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
