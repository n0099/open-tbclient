package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a efl;
    private AbsHListView efm;

    public b(AbsHListView absHListView) {
        this.efm = absHListView;
    }

    public void a(a aVar) {
        this.efl = aVar;
    }

    public boolean aBB() {
        return this.efl != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.efl.onCreateActionMode(actionMode, menu)) {
            this.efm.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.efl.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.efl.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.efl.onDestroyActionMode(actionMode);
        this.efm.mChoiceActionMode = null;
        this.efm.clearChoices();
        this.efm.mDataChanged = true;
        this.efm.rememberSyncState();
        this.efm.requestLayout();
        this.efm.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.efl.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.efm.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
