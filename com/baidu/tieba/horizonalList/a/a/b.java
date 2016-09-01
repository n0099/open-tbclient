package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cIq;
    private AbsHListView cIr;

    public b(AbsHListView absHListView) {
        this.cIr = absHListView;
    }

    public void a(a aVar) {
        this.cIq = aVar;
    }

    public boolean and() {
        return this.cIq != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cIq.onCreateActionMode(actionMode, menu)) {
            this.cIr.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cIq.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cIq.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cIq.onDestroyActionMode(actionMode);
        this.cIr.cIu = null;
        this.cIr.clearChoices();
        this.cIr.aeA = true;
        this.cIr.anT();
        this.cIr.requestLayout();
        this.cIr.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cIq.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cIr.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
