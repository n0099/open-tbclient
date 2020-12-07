package com.baidu.tbadk.widget.extend.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c {
    private SparseArray<WeakReference<View>> fKY;
    private View itemView;
    private int mLayoutId;

    public c(View view) {
        this(view, -1);
    }

    public c(View view, int i) {
        this.itemView = view;
        this.fKY = new SparseArray<>();
        this.mLayoutId = i;
    }

    public c j(View.OnClickListener onClickListener) {
        this.itemView.setOnClickListener(onClickListener);
        return this;
    }

    public View getView() {
        return this.itemView;
    }

    public <T extends View> T th(int i) {
        WeakReference<View> weakReference = this.fKY.get(i);
        if (weakReference == null) {
            T t = (T) this.itemView.findViewById(i);
            if (t != null) {
                this.fKY.put(i, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }
}
