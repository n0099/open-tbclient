package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* loaded from: classes.dex */
class i implements d.a {
    final /* synthetic */ TbRichTextView aOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView) {
        this.aOF = tbRichTextView;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        dVar = this.aOF.aOc;
        if (dVar != null) {
            dVar2 = this.aOF.aOc;
            dVar2.aQ(view);
            dVar3 = this.aOF.aOc;
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
        onClickListener = this.aOF.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.aOF.mOnClickListener;
            onClickListener2.onClick(view);
            return true;
        }
        return false;
    }
}
