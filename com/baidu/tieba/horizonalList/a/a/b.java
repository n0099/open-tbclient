package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a bPV;
    private AbsHListView bPW;

    public b(AbsHListView absHListView) {
        this.bPW = absHListView;
    }

    public void a(a aVar) {
        this.bPV = aVar;
    }

    public boolean ZI() {
        return this.bPV != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bPV.onCreateActionMode(actionMode, menu)) {
            this.bPW.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bPV.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bPV.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bPV.onDestroyActionMode(actionMode);
        this.bPW.bPZ = null;
        this.bPW.clearChoices();
        this.bPW.aaG = true;
        this.bPW.aay();
        this.bPW.requestLayout();
        this.bPW.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.bPV.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.bPW.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
