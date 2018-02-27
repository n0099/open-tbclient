package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ekZ;
    private AbsHListView ela;

    public b(AbsHListView absHListView) {
        this.ela = absHListView;
    }

    public void a(a aVar) {
        this.ekZ = aVar;
    }

    public boolean aDe() {
        return this.ekZ != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ekZ.onCreateActionMode(actionMode, menu)) {
            this.ela.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ekZ.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ekZ.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ekZ.onDestroyActionMode(actionMode);
        this.ela.mChoiceActionMode = null;
        this.ela.clearChoices();
        this.ela.mDataChanged = true;
        this.ela.rememberSyncState();
        this.ela.requestLayout();
        this.ela.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ekZ.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ela.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
