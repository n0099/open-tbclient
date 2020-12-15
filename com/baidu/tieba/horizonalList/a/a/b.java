package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a kaY;
    private AbsHListView kaZ;

    public b(AbsHListView absHListView) {
        this.kaZ = absHListView;
    }

    public void a(a aVar) {
        this.kaY = aVar;
    }

    public boolean UJ() {
        return this.kaY != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.kaY.onCreateActionMode(actionMode, menu)) {
            this.kaZ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.kaY.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.kaY.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.kaY.onDestroyActionMode(actionMode);
        this.kaZ.mChoiceActionMode = null;
        this.kaZ.clearChoices();
        this.kaZ.mDataChanged = true;
        this.kaZ.rememberSyncState();
        this.kaZ.requestLayout();
        this.kaZ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.kaY.a(actionMode, i, j, z);
        if (this.kaZ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
