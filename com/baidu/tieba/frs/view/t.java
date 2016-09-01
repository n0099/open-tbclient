package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class t {
    private final bm chH;
    private final Animation chI;
    private final Animation chJ;
    private View chL;
    private final at mRealTimeData;
    private final TbPageContext mTbPageContext;
    private int mState = 1;
    private Animation.AnimationListener chM = new u(this);
    private final a chK = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Handler {
        private final WeakReference<t> chQ;

        public a(t tVar) {
            this.chQ = new WeakReference<>(tVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    t tVar = this.chQ.get();
                    if (tVar != null) {
                        tVar.chL.startAnimation(tVar.chJ);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public t(at atVar, bm bmVar, TbPageContext tbPageContext) {
        this.mRealTimeData = atVar;
        this.chH = bmVar;
        this.mTbPageContext = tbPageContext;
        this.chI = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), t.a.realtime_gifview_rotate_out);
        this.chJ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), t.a.realtime_gifview_rotate);
    }

    public void show() {
        String icon = this.mRealTimeData.getIcon();
        com.baidu.adp.lib.g.c.eA().a(icon, 17, new v(this, icon), this.mTbPageContext.getUniqueId());
        this.chJ.setAnimationListener(this.chM);
        this.chI.setAnimationListener(this.chM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.chK.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            long longValue = this.mRealTimeData.qz().longValue();
            ay ayVar = new ay(str);
            if (!TextUtils.isEmpty(str2)) {
                ayVar.ab("obj_type", str2);
            }
            ayVar.ab("obj_id", String.valueOf(longValue));
            TiebaStatic.log(ayVar);
        }
    }
}
