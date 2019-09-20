package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gre;
    private AbsHListView grf;

    public b(AbsHListView absHListView) {
        this.grf = absHListView;
    }

    public void a(a aVar) {
        this.gre = aVar;
    }

    public boolean byE() {
        return this.gre != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gre.onCreateActionMode(actionMode, menu)) {
            this.grf.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gre.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gre.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gre.onDestroyActionMode(actionMode);
        this.grf.mChoiceActionMode = null;
        this.grf.clearChoices();
        this.grf.mDataChanged = true;
        this.grf.rememberSyncState();
        this.grf.requestLayout();
        this.grf.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.gre.a(actionMode, i, j, z);
        if (this.grf.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
