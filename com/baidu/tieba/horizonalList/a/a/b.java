package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a egG;
    private AbsHListView egH;

    public b(AbsHListView absHListView) {
        this.egH = absHListView;
    }

    public void a(a aVar) {
        this.egG = aVar;
    }

    public boolean aBG() {
        return this.egG != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.egG.onCreateActionMode(actionMode, menu)) {
            this.egH.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.egG.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.egG.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.egG.onDestroyActionMode(actionMode);
        this.egH.mChoiceActionMode = null;
        this.egH.clearChoices();
        this.egH.mDataChanged = true;
        this.egH.rememberSyncState();
        this.egH.requestLayout();
        this.egH.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.egG.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.egH.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
