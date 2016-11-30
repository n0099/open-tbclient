package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cOw;
    private AbsHListView cOx;

    public b(AbsHListView absHListView) {
        this.cOx = absHListView;
    }

    public void a(a aVar) {
        this.cOw = aVar;
    }

    public boolean apl() {
        return this.cOw != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cOw.onCreateActionMode(actionMode, menu)) {
            this.cOx.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cOw.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cOw.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cOw.onDestroyActionMode(actionMode);
        this.cOx.cOA = null;
        this.cOx.clearChoices();
        this.cOx.afj = true;
        this.cOx.aqb();
        this.cOx.requestLayout();
        this.cOx.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cOw.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cOx.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
