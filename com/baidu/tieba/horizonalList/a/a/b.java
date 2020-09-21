package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a jfm;
    private AbsHListView jfn;

    public b(AbsHListView absHListView) {
        this.jfn = absHListView;
    }

    public void a(a aVar) {
        this.jfm = aVar;
    }

    public boolean Ol() {
        return this.jfm != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.jfm.onCreateActionMode(actionMode, menu)) {
            this.jfn.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.jfm.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.jfm.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.jfm.onDestroyActionMode(actionMode);
        this.jfn.mChoiceActionMode = null;
        this.jfn.clearChoices();
        this.jfn.mDataChanged = true;
        this.jfn.rememberSyncState();
        this.jfn.requestLayout();
        this.jfn.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.jfm.a(actionMode, i, j, z);
        if (this.jfn.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
