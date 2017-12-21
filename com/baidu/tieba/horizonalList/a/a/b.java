package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a dtf;
    private AbsHListView dtg;

    public b(AbsHListView absHListView) {
        this.dtg = absHListView;
    }

    public void a(a aVar) {
        this.dtf = aVar;
    }

    public boolean aux() {
        return this.dtf != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.dtf.onCreateActionMode(actionMode, menu)) {
            this.dtg.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.dtf.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.dtf.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.dtf.onDestroyActionMode(actionMode);
        this.dtg.mChoiceActionMode = null;
        this.dtg.clearChoices();
        this.dtg.mDataChanged = true;
        this.dtg.rememberSyncState();
        this.dtg.requestLayout();
        this.dtg.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.dtf.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.dtg.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
