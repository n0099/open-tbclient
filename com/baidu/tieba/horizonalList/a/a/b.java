package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dFP;
    private AbsHListView dFQ;

    public b(AbsHListView absHListView) {
        this.dFQ = absHListView;
    }

    public void a(a aVar) {
        this.dFP = aVar;
    }

    public boolean ayd() {
        return this.dFP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dFP.onCreateActionMode(actionMode, menu)) {
            this.dFQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dFP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dFP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dFP.onDestroyActionMode(actionMode);
        this.dFQ.mChoiceActionMode = null;
        this.dFQ.clearChoices();
        this.dFQ.mDataChanged = true;
        this.dFQ.rememberSyncState();
        this.dFQ.requestLayout();
        this.dFQ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dFP.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dFQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
