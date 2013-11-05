package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f1464a = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Context context;
        if (motionEvent.getAction() == 0) {
            context = this.f1464a.f1463a;
            ((ImageView) view).setImageBitmap(((BitmapDrawable) context.getResources().getDrawable(R.drawable.but_face_close_s)).getBitmap());
            return false;
        }
        if (motionEvent.getAction() == 1) {
        }
        return false;
    }
}
