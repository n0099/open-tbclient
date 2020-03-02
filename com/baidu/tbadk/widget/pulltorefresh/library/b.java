package com.baidu.tbadk.widget.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b implements a {
    private final HashSet<LoadingLayout> dMS = new HashSet<>();

    public void a(LoadingLayout loadingLayout) {
        if (loadingLayout != null) {
            this.dMS.add(loadingLayout);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.dMS.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayout> it = this.dMS.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.dMS.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.dMS.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.dMS.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
