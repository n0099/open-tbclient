package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ddT;
    private AbsHListView ddU;

    public b(AbsHListView absHListView) {
        this.ddU = absHListView;
    }

    public void a(a aVar) {
        this.ddT = aVar;
    }

    public boolean aqW() {
        return this.ddT != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ddT.onCreateActionMode(actionMode, menu)) {
            this.ddU.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ddT.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ddT.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ddT.onDestroyActionMode(actionMode);
        this.ddU.ddX = null;
        this.ddU.clearChoices();
        this.ddU.mDataChanged = true;
        this.ddU.rememberSyncState();
        this.ddU.requestLayout();
        this.ddU.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ddT.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ddU.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
