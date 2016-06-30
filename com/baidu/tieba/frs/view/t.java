package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class t {
    private View bUB;
    private final bq bUx;
    private final Animation bUy;
    private final Animation bUz;
    private final am mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener bUC = new u(this);
    private final a bUA = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<t> bUG;

        public a(t tVar) {
            this.bUG = new WeakReference<>(tVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    t tVar = this.bUG.get();
                    if (tVar != null) {
                        tVar.bUB.startAnimation(tVar.bUz);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public t(am amVar, bq bqVar, TbPageContext tbPageContext) {
        this.mRealTimeData = amVar;
        this.bUx = bqVar;
        this.mTbPageContext = tbPageContext;
        this.bUy = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), u.a.realtime_gifview_rotate_out);
        this.bUz = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), u.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.dG().a(icon, 17, new v(this, icon), this.mTbPageContext.getUniqueId());
        this.bUz.setAnimationListener(this.bUC);
        this.bUy.setAnimationListener(this.bUC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.bUA.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.pM().longValue();
            ay ayVar = new ay(str);
            if (!TextUtils.isEmpty(str2)) {
                ayVar.ab("obj_type", str2);
            }
            ayVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(ayVar);
        }
    }
}
