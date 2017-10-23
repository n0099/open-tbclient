package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a daN;
    private AbsHListView daO;

    public b(AbsHListView absHListView) {
        this.daO = absHListView;
    }

    public void a(a aVar) {
        this.daN = aVar;
    }

    public boolean apI() {
        return this.daN != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.daN.onCreateActionMode(actionMode, menu)) {
            this.daO.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.daN.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.daN.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.daN.onDestroyActionMode(actionMode);
        this.daO.daR = null;
        this.daO.clearChoices();
        this.daO.mDataChanged = true;
        this.daO.rememberSyncState();
        this.daO.requestLayout();
        this.daO.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.daN.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.daO.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
