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
    private boolean aMy = false;
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.frs.gametab.a.1
        final int bzE = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            if (N(i2)) {
                a.this.er(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            if (N(i2)) {
                a.this.er(true);
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 5.0f;
        }
    };
    private boolean cCl;
    private com.baidu.tieba.e.b csh;
    private Context mContext;
    private BdUniqueId mPageId;

    public a(Context context, BdUniqueId bdUniqueId, boolean z) {
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.cCl = z;
        if (this.cCl) {
            this.csh = new com.baidu.tieba.e.b(context);
            this.csh.a(this.bZO);
        }
    }

    public void d(View view, MotionEvent motionEvent) {
        if (this.cCl && this.csh != null) {
            this.csh.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(boolean z) {
        this.aMy = z;
        if (this.cCl) {
            m(!this.aMy, true);
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
