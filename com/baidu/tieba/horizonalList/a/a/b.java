package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gij;
    private AbsHListView gik;

    public b(AbsHListView absHListView) {
        this.gik = absHListView;
    }

    public void a(a aVar) {
        this.gij = aVar;
    }

    public boolean buX() {
        return this.gij != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gij.onCreateActionMode(actionMode, menu)) {
            this.gik.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gij.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gij.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gij.onDestroyActionMode(actionMode);
        this.gik.mChoiceActionMode = null;
        this.gik.clearChoices();
        this.gik.mDataChanged = true;
        this.gik.rememberSyncState();
        this.gik.requestLayout();
        this.gik.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.gij.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.gik.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
