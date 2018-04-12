package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dFS;
    private AbsHListView dFT;

    public b(AbsHListView absHListView) {
        this.dFT = absHListView;
    }

    public void a(a aVar) {
        this.dFS = aVar;
    }

    public boolean ayd() {
        return this.dFS != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dFS.onCreateActionMode(actionMode, menu)) {
            this.dFT.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dFS.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dFS.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dFS.onDestroyActionMode(actionMode);
        this.dFT.mChoiceActionMode = null;
        this.dFT.clearChoices();
        this.dFT.mDataChanged = true;
        this.dFT.rememberSyncState();
        this.dFT.requestLayout();
        this.dFT.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dFS.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dFT.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
