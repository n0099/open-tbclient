package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a deP;
    private AbsHListView deQ;

    public b(AbsHListView absHListView) {
        this.deQ = absHListView;
    }

    public void a(a aVar) {
        this.deP = aVar;
    }

    public boolean arh() {
        return this.deP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.deP.onCreateActionMode(actionMode, menu)) {
            this.deQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.deP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.deP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.deP.onDestroyActionMode(actionMode);
        this.deQ.deT = null;
        this.deQ.clearChoices();
        this.deQ.mDataChanged = true;
        this.deQ.rememberSyncState();
        this.deQ.requestLayout();
        this.deQ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.deP.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.deQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
