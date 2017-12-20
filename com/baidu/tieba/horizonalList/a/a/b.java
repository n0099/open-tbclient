package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dtb;
    private AbsHListView dtc;

    public b(AbsHListView absHListView) {
        this.dtc = absHListView;
    }

    public void a(a aVar) {
        this.dtb = aVar;
    }

    public boolean auw() {
        return this.dtb != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dtb.onCreateActionMode(actionMode, menu)) {
            this.dtc.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dtb.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dtb.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dtb.onDestroyActionMode(actionMode);
        this.dtc.mChoiceActionMode = null;
        this.dtc.clearChoices();
        this.dtc.mDataChanged = true;
        this.dtc.rememberSyncState();
        this.dtc.requestLayout();
        this.dtc.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dtb.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dtc.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
