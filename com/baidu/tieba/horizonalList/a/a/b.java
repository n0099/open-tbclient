package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dba;
    private AbsHListView dbb;

    public b(AbsHListView absHListView) {
        this.dbb = absHListView;
    }

    public void a(a aVar) {
        this.dba = aVar;
    }

    public boolean apN() {
        return this.dba != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dba.onCreateActionMode(actionMode, menu)) {
            this.dbb.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dba.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dba.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dba.onDestroyActionMode(actionMode);
        this.dbb.dbe = null;
        this.dbb.clearChoices();
        this.dbb.mDataChanged = true;
        this.dbb.rememberSyncState();
        this.dbb.requestLayout();
        this.dbb.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dba.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dbb.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
