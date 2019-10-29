package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gqD;
    private AbsHListView gqE;

    public b(AbsHListView absHListView) {
        this.gqE = absHListView;
    }

    public void a(a aVar) {
        this.gqD = aVar;
    }

    public boolean uS() {
        return this.gqD != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gqD.onCreateActionMode(actionMode, menu)) {
            this.gqE.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gqD.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gqD.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gqD.onDestroyActionMode(actionMode);
        this.gqE.mChoiceActionMode = null;
        this.gqE.clearChoices();
        this.gqE.mDataChanged = true;
        this.gqE.rememberSyncState();
        this.gqE.requestLayout();
        this.gqE.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.gqD.a(actionMode, i, j, z);
        if (this.gqE.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
