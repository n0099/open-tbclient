package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cxc;
    private AbsHListView cxd;

    public b(AbsHListView absHListView) {
        this.cxd = absHListView;
    }

    public void a(a aVar) {
        this.cxc = aVar;
    }

    public boolean ahR() {
        return this.cxc != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cxc.onCreateActionMode(actionMode, menu)) {
            this.cxd.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cxc.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cxc.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cxc.onDestroyActionMode(actionMode);
        this.cxd.cxg = null;
        this.cxd.clearChoices();
        this.cxd.aiO = true;
        this.cxd.aiH();
        this.cxd.requestLayout();
        this.cxd.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cxc.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cxd.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
