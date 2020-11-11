package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a jMJ;
    private AbsHListView jMK;

    public b(AbsHListView absHListView) {
        this.jMK = absHListView;
    }

    public void a(a aVar) {
        this.jMJ = aVar;
    }

    public boolean ST() {
        return this.jMJ != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.jMJ.onCreateActionMode(actionMode, menu)) {
            this.jMK.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.jMJ.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.jMJ.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.jMJ.onDestroyActionMode(actionMode);
        this.jMK.mChoiceActionMode = null;
        this.jMK.clearChoices();
        this.jMK.mDataChanged = true;
        this.jMK.rememberSyncState();
        this.jMK.requestLayout();
        this.jMK.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.jMJ.a(actionMode, i, j, z);
        if (this.jMK.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
