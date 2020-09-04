package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a iWG;
    private AbsHListView iWH;

    public b(AbsHListView absHListView) {
        this.iWH = absHListView;
    }

    public void a(a aVar) {
        this.iWG = aVar;
    }

    public boolean NI() {
        return this.iWG != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iWG.onCreateActionMode(actionMode, menu)) {
            this.iWH.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iWG.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iWG.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iWG.onDestroyActionMode(actionMode);
        this.iWH.mChoiceActionMode = null;
        this.iWH.clearChoices();
        this.iWH.mDataChanged = true;
        this.iWH.rememberSyncState();
        this.iWH.requestLayout();
        this.iWH.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iWG.a(actionMode, i, j, z);
        if (this.iWH.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
