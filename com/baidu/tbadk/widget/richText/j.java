package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* loaded from: classes.dex */
class j implements d.a {
    final /* synthetic */ TbRichTextView aPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbRichTextView tbRichTextView) {
        this.aPX = tbRichTextView;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        dVar = this.aPX.aPs;
        if (dVar != null) {
            dVar2 = this.aPX.aPs;
            dVar2.aS(view);
            dVar3 = this.aPX.aPs;
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
        View.OnClickListener onClickListener2;
        onClickListener = this.aPX.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.aPX.mOnClickListener;
            onClickListener2.onClick(view);
            return true;
        }
        return false;
    }
}
