package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a diC;
    private AbsHListView diD;

    public b(AbsHListView absHListView) {
        this.diD = absHListView;
    }

    public void a(a aVar) {
        this.diC = aVar;
    }

    public boolean ase() {
        return this.diC != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.diC.onCreateActionMode(actionMode, menu)) {
            this.diD.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.diC.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.diC.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.diC.onDestroyActionMode(actionMode);
        this.diD.diG = null;
        this.diD.clearChoices();
        this.diD.mDataChanged = true;
        this.diD.rememberSyncState();
        this.diD.requestLayout();
        this.diD.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.diC.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.diD.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
