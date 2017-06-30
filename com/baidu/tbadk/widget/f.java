package com.baidu.tbadk.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ TbImageView aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbImageView tbImageView) {
        this.aMh = tbImageView;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        dVar = this.aMh.aLT;
        if (dVar != null) {
            dVar2 = this.aMh.aLT;
            dVar2.aS(view);
            dVar3 = this.aMh.aLT;
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
        if (this.aMh.getBdImage() == null && this.aMh.getDrawable() == null) {
            z = this.aMh.aLU;
            if (z) {
                this.aMh.startLoading();
                com.baidu.adp.lib.f.c.fL().a(this.aMh.mUrl, this.aMh.mType, this.aMh.aJO, this.aMh.mWidth, this.aMh.mHeight, this.aMh.mPageId, new Object[0]);
                return true;
            }
        }
        onClickListener = this.aMh.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.aMh.mOnClickListener;
            onClickListener2.onClick(view);
            return true;
        }
        dVar = this.aMh.aLT;
        if (dVar != null) {
            dVar2 = this.aMh.aLT;
            dVar2.aS(view);
            dVar3 = this.aMh.aLT;
            return dVar3.onSingleTapConfirmed(motionEvent);
        }
        return false;
    }
}
