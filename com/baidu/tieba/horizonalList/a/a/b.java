package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ehl;
    private AbsHListView ehm;

    public b(AbsHListView absHListView) {
        this.ehm = absHListView;
    }

    public void a(a aVar) {
        this.ehl = aVar;
    }

    public boolean aGS() {
        return this.ehl != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ehl.onCreateActionMode(actionMode, menu)) {
            this.ehm.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ehl.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ehl.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ehl.onDestroyActionMode(actionMode);
        this.ehm.mChoiceActionMode = null;
        this.ehm.clearChoices();
        this.ehm.mDataChanged = true;
        this.ehm.rememberSyncState();
        this.ehm.requestLayout();
        this.ehm.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ehl.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ehm.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
