package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cTU;
    private AbsHListView cTV;

    public b(AbsHListView absHListView) {
        this.cTV = absHListView;
    }

    public void a(a aVar) {
        this.cTU = aVar;
    }

    public boolean aoz() {
        return this.cTU != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cTU.onCreateActionMode(actionMode, menu)) {
            this.cTV.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cTU.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cTU.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cTU.onDestroyActionMode(actionMode);
        this.cTV.cTY = null;
        this.cTV.clearChoices();
        this.cTV.mDataChanged = true;
        this.cTV.rememberSyncState();
        this.cTV.requestLayout();
        this.cTV.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cTU.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cTV.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
