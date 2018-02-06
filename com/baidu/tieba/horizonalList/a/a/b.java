package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ell;
    private AbsHListView elm;

    public b(AbsHListView absHListView) {
        this.elm = absHListView;
    }

    public void a(a aVar) {
        this.ell = aVar;
    }

    public boolean aDf() {
        return this.ell != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ell.onCreateActionMode(actionMode, menu)) {
            this.elm.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ell.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ell.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ell.onDestroyActionMode(actionMode);
        this.elm.mChoiceActionMode = null;
        this.elm.clearChoices();
        this.elm.mDataChanged = true;
        this.elm.rememberSyncState();
        this.elm.requestLayout();
        this.elm.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ell.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.elm.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
