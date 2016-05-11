package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ab {
    private final cn bwR;
    private final Animation bwS;
    private final Animation bwT;
    private View bwV;
    private final ak mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener bwW = new ac(this);
    private final a bwU = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<ab> bxa;

        public a(ab abVar) {
            this.bxa = new WeakReference<>(abVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ab abVar = this.bxa.get();
                    if (abVar != null) {
                        abVar.bwV.startAnimation(abVar.bwT);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ab(ak akVar, cn cnVar, TbPageContext tbPageContext) {
        this.mRealTimeData = akVar;
        this.bwR = cnVar;
        this.mTbPageContext = tbPageContext;
        this.bwS = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), t.a.realtime_gifview_rotate_out);
        this.bwT = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), t.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.dF().a(icon, 17, new ad(this, icon), this.mTbPageContext.getUniqueId());
        this.bwT.setAnimationListener(this.bwW);
        this.bwS.setAnimationListener(this.bwW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.bwU.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.pS().longValue();
            aw awVar = new aw(str);
            if (!TextUtils.isEmpty(str2)) {
                awVar.ac("obj_type", str2);
            }
            awVar.ac("obj_id", String.valueOf(longValue));
            TiebaStatic.log(awVar);
        }
    }
}
