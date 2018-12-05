package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a exs;
    private AbsHListView exu;

    public b(AbsHListView absHListView) {
        this.exu = absHListView;
    }

    public void a(a aVar) {
        this.exs = aVar;
    }

    public boolean aLA() {
        return this.exs != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.exs.onCreateActionMode(actionMode, menu)) {
            this.exu.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.exs.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.exs.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.exs.onDestroyActionMode(actionMode);
        this.exu.mChoiceActionMode = null;
        this.exu.clearChoices();
        this.exu.mDataChanged = true;
        this.exu.rememberSyncState();
        this.exu.requestLayout();
        this.exu.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.exs.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.exu.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
