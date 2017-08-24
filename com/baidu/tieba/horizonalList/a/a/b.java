package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cXm;
    private AbsHListView cXn;

    public b(AbsHListView absHListView) {
        this.cXn = absHListView;
    }

    public void a(a aVar) {
        this.cXm = aVar;
    }

    public boolean apm() {
        return this.cXm != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cXm.onCreateActionMode(actionMode, menu)) {
            this.cXn.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cXm.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cXm.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cXm.onDestroyActionMode(actionMode);
        this.cXn.cXq = null;
        this.cXn.clearChoices();
        this.cXn.mDataChanged = true;
        this.cXn.rememberSyncState();
        this.cXn.requestLayout();
        this.cXn.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cXm.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cXn.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
