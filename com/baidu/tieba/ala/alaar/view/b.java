package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public abstract class b<T> {
    protected a gwt;
    public T item;
    @NonNull
    public final View itemView;
    public int position;

    /* loaded from: classes11.dex */
    public interface a<H extends b> {
    }

    public abstract void j(int i, T t);

    public b(View view, a aVar) {
        this.itemView = view;
        view.setTag(this);
        this.gwt = aVar;
    }

    public void h(int i, T t) {
        if (this.item != t && this.item != null) {
            i(this.position, this.item);
        }
        this.position = i;
        this.item = t;
        j(i, t);
    }

    public void i(int i, T t) {
    }

    public boolean tx(int i) {
        return false;
    }
}
