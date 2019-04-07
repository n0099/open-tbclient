package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a fQT;
    private AbsHListView fQU;

    public b(AbsHListView absHListView) {
        this.fQU = absHListView;
    }

    public void a(a aVar) {
        this.fQT = aVar;
    }

    public boolean bnq() {
        return this.fQT != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.fQT.onCreateActionMode(actionMode, menu)) {
            this.fQU.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.fQT.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.fQT.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.fQT.onDestroyActionMode(actionMode);
        this.fQU.mChoiceActionMode = null;
        this.fQU.clearChoices();
        this.fQU.mDataChanged = true;
        this.fQU.rememberSyncState();
        this.fQU.requestLayout();
        this.fQU.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.fQT.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.fQU.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
