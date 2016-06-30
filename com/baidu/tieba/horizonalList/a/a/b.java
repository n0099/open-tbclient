package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ctW;
    private AbsHListView ctX;

    public b(AbsHListView absHListView) {
        this.ctX = absHListView;
    }

    public void a(a aVar) {
        this.ctW = aVar;
    }

    public boolean ahF() {
        return this.ctW != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ctW.onCreateActionMode(actionMode, menu)) {
            this.ctX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ctW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ctW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ctW.onDestroyActionMode(actionMode);
        this.ctX.cua = null;
        this.ctX.clearChoices();
        this.ctX.aaZ = true;
        this.ctX.aiv();
        this.ctX.requestLayout();
        this.ctX.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ctW.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ctX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
