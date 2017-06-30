package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cLq;
    private AbsHListView cLr;

    public b(AbsHListView absHListView) {
        this.cLr = absHListView;
    }

    public void a(a aVar) {
        this.cLq = aVar;
    }

    public boolean amS() {
        return this.cLq != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cLq.onCreateActionMode(actionMode, menu)) {
            this.cLr.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cLq.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cLq.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cLq.onDestroyActionMode(actionMode);
        this.cLr.cLu = null;
        this.cLr.clearChoices();
        this.cLr.mDataChanged = true;
        this.cLr.rememberSyncState();
        this.cLr.requestLayout();
        this.cLr.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cLq.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cLr.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
