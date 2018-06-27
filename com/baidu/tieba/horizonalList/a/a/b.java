package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dWa;
    private AbsHListView dWb;

    public b(AbsHListView absHListView) {
        this.dWb = absHListView;
    }

    public void a(a aVar) {
        this.dWa = aVar;
    }

    public boolean aDG() {
        return this.dWa != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dWa.onCreateActionMode(actionMode, menu)) {
            this.dWb.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dWa.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dWa.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dWa.onDestroyActionMode(actionMode);
        this.dWb.mChoiceActionMode = null;
        this.dWb.clearChoices();
        this.dWb.mDataChanged = true;
        this.dWb.rememberSyncState();
        this.dWb.requestLayout();
        this.dWb.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dWa.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dWb.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
