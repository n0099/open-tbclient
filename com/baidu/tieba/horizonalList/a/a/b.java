package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes2.dex */
public class b implements a {
    private a iWA;
    private AbsHListView iWB;

    public b(AbsHListView absHListView) {
        this.iWB = absHListView;
    }

    public void a(a aVar) {
        this.iWA = aVar;
    }

    public boolean NI() {
        return this.iWA != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iWA.onCreateActionMode(actionMode, menu)) {
            this.iWB.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iWA.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iWA.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iWA.onDestroyActionMode(actionMode);
        this.iWB.mChoiceActionMode = null;
        this.iWB.clearChoices();
        this.iWB.mDataChanged = true;
        this.iWB.rememberSyncState();
        this.iWB.requestLayout();
        this.iWB.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iWA.a(actionMode, i, j, z);
        if (this.iWB.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
