package com.baidu.tbadk.widget.extend.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c {
    private SparseArray<WeakReference<View>> fpu;
    private View itemView;
    private int mLayoutId;

    public c(View view) {
        this(view, -1);
    }

    public c(View view, int i) {
        this.itemView = view;
        this.fpu = new SparseArray<>();
        this.mLayoutId = i;
    }

    public c i(View.OnClickListener onClickListener) {
        this.itemView.setOnClickListener(onClickListener);
        return this;
    }

    public View getView() {
        return this.itemView;
    }

    public <T extends View> T rL(int i) {
        WeakReference<View> weakReference = this.fpu.get(i);
        if (weakReference == null) {
            T t = (T) this.itemView.findViewById(i);
            if (t != null) {
                this.fpu.put(i, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }
}
