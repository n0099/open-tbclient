package com.baidu.tbadk.widget.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b implements a {
    private final HashSet<com.baidu.tbadk.widget.pulltorefresh.library.a.b> bJl = new HashSet<>();

    public void a(com.baidu.tbadk.widget.pulltorefresh.library.a.b bVar) {
        if (bVar != null) {
            this.bJl.add(bVar);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<com.baidu.tbadk.widget.pulltorefresh.library.a.b> it = this.bJl.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<com.baidu.tbadk.widget.pulltorefresh.library.a.b> it = this.bJl.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<com.baidu.tbadk.widget.pulltorefresh.library.a.b> it = this.bJl.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        Iterator<com.baidu.tbadk.widget.pulltorefresh.library.a.b> it = this.bJl.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<com.baidu.tbadk.widget.pulltorefresh.library.a.b> it = this.bJl.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
