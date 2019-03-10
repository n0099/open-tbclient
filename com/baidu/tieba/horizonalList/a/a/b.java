package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a fRg;
    private AbsHListView fRh;

    public b(AbsHListView absHListView) {
        this.fRh = absHListView;
    }

    public void a(a aVar) {
        this.fRg = aVar;
    }

    public boolean bnu() {
        return this.fRg != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.fRg.onCreateActionMode(actionMode, menu)) {
            this.fRh.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.fRg.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.fRg.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.fRg.onDestroyActionMode(actionMode);
        this.fRh.mChoiceActionMode = null;
        this.fRh.clearChoices();
        this.fRh.mDataChanged = true;
        this.fRh.rememberSyncState();
        this.fRh.requestLayout();
        this.fRh.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.fRg.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.fRh.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
