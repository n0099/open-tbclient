package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cDt;
    private AbsHListView cDu;

    public b(AbsHListView absHListView) {
        this.cDu = absHListView;
    }

    public void a(a aVar) {
        this.cDt = aVar;
    }

    public boolean ajh() {
        return this.cDt != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cDt.onCreateActionMode(actionMode, menu)) {
            this.cDu.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cDt.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cDt.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cDt.onDestroyActionMode(actionMode);
        this.cDu.cDx = null;
        this.cDu.clearChoices();
        this.cDu.mDataChanged = true;
        this.cDu.rememberSyncState();
        this.cDu.requestLayout();
        this.cDu.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cDt.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cDu.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
