package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a eAl;
    private AbsHListView eAm;

    public b(AbsHListView absHListView) {
        this.eAm = absHListView;
    }

    public void a(a aVar) {
        this.eAl = aVar;
    }

    public boolean aMn() {
        return this.eAl != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.eAl.onCreateActionMode(actionMode, menu)) {
            this.eAm.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.eAl.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.eAl.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.eAl.onDestroyActionMode(actionMode);
        this.eAm.mChoiceActionMode = null;
        this.eAm.clearChoices();
        this.eAm.mDataChanged = true;
        this.eAm.rememberSyncState();
        this.eAm.requestLayout();
        this.eAm.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.eAl.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.eAm.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
