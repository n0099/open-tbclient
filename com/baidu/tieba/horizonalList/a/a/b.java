package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a bBL;
    private AbsHListView bBM;

    public b(AbsHListView absHListView) {
        this.bBM = absHListView;
    }

    public void a(a aVar) {
        this.bBL = aVar;
    }

    public boolean Ua() {
        return this.bBL != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bBL.onCreateActionMode(actionMode, menu)) {
            this.bBM.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bBL.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bBL.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bBL.onDestroyActionMode(actionMode);
        this.bBM.bBP = null;
        this.bBM.clearChoices();
        this.bBM.aeW = true;
        this.bBM.UQ();
        this.bBM.requestLayout();
        this.bBM.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.bBL.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.bBM.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
