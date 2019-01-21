package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a eAY;
    private AbsHListView eAZ;

    public b(AbsHListView absHListView) {
        this.eAZ = absHListView;
    }

    public void a(a aVar) {
        this.eAY = aVar;
    }

    public boolean aMN() {
        return this.eAY != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.eAY.onCreateActionMode(actionMode, menu)) {
            this.eAZ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.eAY.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.eAY.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.eAY.onDestroyActionMode(actionMode);
        this.eAZ.mChoiceActionMode = null;
        this.eAZ.clearChoices();
        this.eAZ.mDataChanged = true;
        this.eAZ.rememberSyncState();
        this.eAZ.requestLayout();
        this.eAZ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.eAY.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.eAZ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
