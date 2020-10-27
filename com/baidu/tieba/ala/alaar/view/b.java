package com.baidu.tieba.ala.alaar.view;

import android.support.annotation.NonNull;
import android.view.View;
/* loaded from: classes4.dex */
public abstract class b<T> {
    protected a gal;
    public T item;
    @NonNull
    public final View itemView;
    public int position;

    /* loaded from: classes4.dex */
    public interface a<H extends b> {
    }

    public abstract void k(int i, T t);

    public b(View view, a aVar) {
        this.itemView = view;
        view.setTag(this);
        this.gal = aVar;
    }

    public void i(int i, T t) {
        if (this.item != t && this.item != null) {
            j(this.position, this.item);
        }
        this.position = i;
        this.item = t;
        k(i, t);
    }

    public void j(int i, T t) {
    }

    public boolean tz(int i) {
        return false;
    }
}
