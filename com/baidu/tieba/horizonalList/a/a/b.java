package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a eAX;
    private AbsHListView eAY;

    public b(AbsHListView absHListView) {
        this.eAY = absHListView;
    }

    public void a(a aVar) {
        this.eAX = aVar;
    }

    public boolean aMN() {
        return this.eAX != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.eAX.onCreateActionMode(actionMode, menu)) {
            this.eAY.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.eAX.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.eAX.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.eAX.onDestroyActionMode(actionMode);
        this.eAY.mChoiceActionMode = null;
        this.eAY.clearChoices();
        this.eAY.mDataChanged = true;
        this.eAY.rememberSyncState();
        this.eAY.requestLayout();
        this.eAY.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.eAX.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.eAY.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
