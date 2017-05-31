package com.baidu.tbadk.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ TbImageView aKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbImageView tbImageView) {
        this.aKR = tbImageView;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        dVar = this.aKR.aKE;
        if (dVar != null) {
            dVar2 = this.aKR.aKE;
            dVar2.aQ(view);
            dVar3 = this.aKR.aKE;
            return dVar3.onDoubleTap(motionEvent);
        }
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean c(View view, MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        View.OnClickListener onClickListener2;
        boolean z;
        if (this.aKR.getBdImage() == null && this.aKR.getDrawable() == null) {
            z = this.aKR.aKF;
            if (z) {
                this.aKR.startLoading();
                com.baidu.adp.lib.f.c.fM().a(this.aKR.mUrl, this.aKR.mType, this.aKR.aIz, this.aKR.mWidth, this.aKR.mHeight, this.aKR.mPageId, new Object[0]);
                return true;
            }
        }
        onClickListener = this.aKR.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.aKR.mOnClickListener;
            onClickListener2.onClick(view);
            return true;
        }
        dVar = this.aKR.aKE;
        if (dVar != null) {
            dVar2 = this.aKR.aKE;
            dVar2.aQ(view);
            dVar3 = this.aKR.aKE;
            return dVar3.onSingleTapConfirmed(motionEvent);
        }
        return false;
    }
}
