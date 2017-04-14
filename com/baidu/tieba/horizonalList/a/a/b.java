package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cAB;
    private AbsHListView cAC;

    public b(AbsHListView absHListView) {
        this.cAC = absHListView;
    }

    public void a(a aVar) {
        this.cAB = aVar;
    }

    public boolean aka() {
        return this.cAB != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cAB.onCreateActionMode(actionMode, menu)) {
            this.cAC.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cAB.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cAB.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cAB.onDestroyActionMode(actionMode);
        this.cAC.cAF = null;
        this.cAC.clearChoices();
        this.cAC.ajq = true;
        this.cAC.akQ();
        this.cAC.requestLayout();
        this.cAC.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cAB.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cAC.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
