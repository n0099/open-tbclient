package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a eqy;
    private AbsHListView eqz;

    public b(AbsHListView absHListView) {
        this.eqz = absHListView;
    }

    public void a(a aVar) {
        this.eqy = aVar;
    }

    public boolean aJI() {
        return this.eqy != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.eqy.onCreateActionMode(actionMode, menu)) {
            this.eqz.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.eqy.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.eqy.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.eqy.onDestroyActionMode(actionMode);
        this.eqz.mChoiceActionMode = null;
        this.eqz.clearChoices();
        this.eqz.mDataChanged = true;
        this.eqz.rememberSyncState();
        this.eqz.requestLayout();
        this.eqz.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.eqy.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.eqz.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
