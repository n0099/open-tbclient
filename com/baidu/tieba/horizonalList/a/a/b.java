package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a kaW;
    private AbsHListView kaX;

    public b(AbsHListView absHListView) {
        this.kaX = absHListView;
    }

    public void a(a aVar) {
        this.kaW = aVar;
    }

    public boolean UJ() {
        return this.kaW != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.kaW.onCreateActionMode(actionMode, menu)) {
            this.kaX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.kaW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.kaW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.kaW.onDestroyActionMode(actionMode);
        this.kaX.mChoiceActionMode = null;
        this.kaX.clearChoices();
        this.kaX.mDataChanged = true;
        this.kaX.rememberSyncState();
        this.kaX.requestLayout();
        this.kaX.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.kaW.a(actionMode, i, j, z);
        if (this.kaX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
