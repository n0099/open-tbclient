package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.f.a aVar;
        com.baidu.tieba.f.a aVar2;
        View.OnTouchListener onTouchListener2;
        z = this.this$0.cxx;
        if (!z) {
            this.this$0.cxx = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_TIP, false));
        }
        onTouchListener = this.this$0.cxr;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cxr;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.aLf;
        if (aVar != null) {
            aVar2 = this.this$0.aLf;
            aVar2.onTouchEvent(motionEvent);
        }
        return false;
    }
}
