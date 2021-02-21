package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class DragView extends FrameLayout {
    private DragTextView gvR;
    private TbImageView gvS;

    public DragView(Context context) {
        super(context);
        init(context);
    }

    public DragView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DragView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.drag_layout, this);
        this.gvR = (DragTextView) inflate.findViewById(a.f.drag_tv);
        this.gvS = (TbImageView) inflate.findViewById(a.f.drag_bg);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
