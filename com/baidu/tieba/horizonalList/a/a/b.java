package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a jul;
    private AbsHListView jum;

    public b(AbsHListView absHListView) {
        this.jum = absHListView;
    }

    public void a(a aVar) {
        this.jul = aVar;
    }

    public boolean Pq() {
        return this.jul != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.jul.onCreateActionMode(actionMode, menu)) {
            this.jum.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.jul.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.jul.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.jul.onDestroyActionMode(actionMode);
        this.jum.mChoiceActionMode = null;
        this.jum.clearChoices();
        this.jum.mDataChanged = true;
        this.jum.rememberSyncState();
        this.jum.requestLayout();
        this.jum.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.jul.a(actionMode, i, j, z);
        if (this.jum.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
