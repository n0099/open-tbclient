package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hUW;
    private AbsHListView hUX;

    public b(AbsHListView absHListView) {
        this.hUX = absHListView;
    }

    public void a(a aVar) {
        this.hUW = aVar;
    }

    public boolean EF() {
        return this.hUW != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hUW.onCreateActionMode(actionMode, menu)) {
            this.hUX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hUW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hUW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hUW.onDestroyActionMode(actionMode);
        this.hUX.mChoiceActionMode = null;
        this.hUX.clearChoices();
        this.hUX.mDataChanged = true;
        this.hUX.rememberSyncState();
        this.hUX.requestLayout();
        this.hUX.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hUW.a(actionMode, i, j, z);
        if (this.hUX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
