package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dSg;
    private AbsHListView dSh;

    public b(AbsHListView absHListView) {
        this.dSh = absHListView;
    }

    public void a(a aVar) {
        this.dSg = aVar;
    }

    public boolean aCW() {
        return this.dSg != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dSg.onCreateActionMode(actionMode, menu)) {
            this.dSh.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dSg.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dSg.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dSg.onDestroyActionMode(actionMode);
        this.dSh.mChoiceActionMode = null;
        this.dSh.clearChoices();
        this.dSh.mDataChanged = true;
        this.dSh.rememberSyncState();
        this.dSh.requestLayout();
        this.dSh.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dSg.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dSh.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
