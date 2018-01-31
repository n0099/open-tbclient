package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ehb;
    private AbsHListView ehc;

    public b(AbsHListView absHListView) {
        this.ehc = absHListView;
    }

    public void a(a aVar) {
        this.ehb = aVar;
    }

    public boolean aBL() {
        return this.ehb != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ehb.onCreateActionMode(actionMode, menu)) {
            this.ehc.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ehb.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ehb.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ehb.onDestroyActionMode(actionMode);
        this.ehc.mChoiceActionMode = null;
        this.ehc.clearChoices();
        this.ehc.mDataChanged = true;
        this.ehc.rememberSyncState();
        this.ehc.requestLayout();
        this.ehc.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ehb.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ehc.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
