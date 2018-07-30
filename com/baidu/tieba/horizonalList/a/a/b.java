package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dZS;
    private AbsHListView dZT;

    public b(AbsHListView absHListView) {
        this.dZT = absHListView;
    }

    public void a(a aVar) {
        this.dZS = aVar;
    }

    public boolean aEG() {
        return this.dZS != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dZS.onCreateActionMode(actionMode, menu)) {
            this.dZT.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dZS.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dZS.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dZS.onDestroyActionMode(actionMode);
        this.dZT.mChoiceActionMode = null;
        this.dZT.clearChoices();
        this.dZT.mDataChanged = true;
        this.dZT.rememberSyncState();
        this.dZT.requestLayout();
        this.dZT.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dZS.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dZT.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
