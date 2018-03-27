package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a elp;
    private AbsHListView elq;

    public b(AbsHListView absHListView) {
        this.elq = absHListView;
    }

    public void a(a aVar) {
        this.elp = aVar;
    }

    public boolean aDf() {
        return this.elp != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.elp.onCreateActionMode(actionMode, menu)) {
            this.elq.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.elp.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.elp.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.elp.onDestroyActionMode(actionMode);
        this.elq.mChoiceActionMode = null;
        this.elq.clearChoices();
        this.elq.mDataChanged = true;
        this.elq.rememberSyncState();
        this.elq.requestLayout();
        this.elq.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.elp.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.elq.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
