package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a diW;
    private AbsHListView diX;

    public b(AbsHListView absHListView) {
        this.diX = absHListView;
    }

    public void a(a aVar) {
        this.diW = aVar;
    }

    public boolean asv() {
        return this.diW != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.diW.onCreateActionMode(actionMode, menu)) {
            this.diX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.diW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.diW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.diW.onDestroyActionMode(actionMode);
        this.diX.dja = null;
        this.diX.clearChoices();
        this.diX.mDataChanged = true;
        this.diX.rememberSyncState();
        this.diX.requestLayout();
        this.diX.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.diW.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.diX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
