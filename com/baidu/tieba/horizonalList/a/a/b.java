package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dGV;
    private AbsHListView dGW;

    public b(AbsHListView absHListView) {
        this.dGW = absHListView;
    }

    public void a(a aVar) {
        this.dGV = aVar;
    }

    public boolean ayb() {
        return this.dGV != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dGV.onCreateActionMode(actionMode, menu)) {
            this.dGW.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dGV.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dGV.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dGV.onDestroyActionMode(actionMode);
        this.dGW.mChoiceActionMode = null;
        this.dGW.clearChoices();
        this.dGW.mDataChanged = true;
        this.dGW.rememberSyncState();
        this.dGW.requestLayout();
        this.dGW.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dGV.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dGW.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
