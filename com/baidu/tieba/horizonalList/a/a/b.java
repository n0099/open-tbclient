package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dZP;
    private AbsHListView dZQ;

    public b(AbsHListView absHListView) {
        this.dZQ = absHListView;
    }

    public void a(a aVar) {
        this.dZP = aVar;
    }

    public boolean aED() {
        return this.dZP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dZP.onCreateActionMode(actionMode, menu)) {
            this.dZQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dZP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dZP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dZP.onDestroyActionMode(actionMode);
        this.dZQ.mChoiceActionMode = null;
        this.dZQ.clearChoices();
        this.dZQ.mDataChanged = true;
        this.dZQ.rememberSyncState();
        this.dZQ.requestLayout();
        this.dZQ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dZP.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dZQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
