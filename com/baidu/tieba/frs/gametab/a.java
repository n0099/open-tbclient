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
    private boolean cDK;
    private com.baidu.tieba.e.b ctr;
    private Context mContext;
    private BdUniqueId mPageId;
    private boolean aLK = false;
    private a.InterfaceC0081a cau = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.gametab.a.1
        final int bBU = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            if (Q(i2)) {
                a.this.eJ(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            if (Q(i2)) {
                a.this.eJ(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }

        private boolean Q(float f) {
            return Math.abs(f) >= 5.0f;
        }
    };

    public a(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.cDK = z;
        if (this.cDK) {
            this.ctr = new com.baidu.tieba.e.b(context);
            this.ctr.a(this.cau);
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.cDK && this.ctr != null) {
            this.ctr.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        this.aLK = z;
        if (this.cDK) {
            n(!this.aLK, true);
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
