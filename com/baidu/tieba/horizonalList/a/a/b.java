package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a bPu;
    private AbsHListView bPv;

    public b(AbsHListView absHListView) {
        this.bPv = absHListView;
    }

    public void a(a aVar) {
        this.bPu = aVar;
    }

    public boolean ZJ() {
        return this.bPu != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bPu.onCreateActionMode(actionMode, menu)) {
            this.bPv.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bPu.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bPu.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bPu.onDestroyActionMode(actionMode);
        this.bPv.bPy = null;
        this.bPv.clearChoices();
        this.bPv.afh = true;
        this.bPv.aaz();
        this.bPv.requestLayout();
        this.bPv.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.bPu.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.bPv.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
