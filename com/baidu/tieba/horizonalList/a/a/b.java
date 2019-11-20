package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gpM;
    private AbsHListView gpN;

    public b(AbsHListView absHListView) {
        this.gpN = absHListView;
    }

    public void a(a aVar) {
        this.gpM = aVar;
    }

    public boolean uT() {
        return this.gpM != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gpM.onCreateActionMode(actionMode, menu)) {
            this.gpN.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gpM.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gpM.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gpM.onDestroyActionMode(actionMode);
        this.gpN.mChoiceActionMode = null;
        this.gpN.clearChoices();
        this.gpN.mDataChanged = true;
        this.gpN.rememberSyncState();
        this.gpN.requestLayout();
        this.gpN.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.gpM.a(actionMode, i, j, z);
        if (this.gpN.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
