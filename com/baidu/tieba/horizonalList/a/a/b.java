package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cCS;
    private AbsHListView cCT;

    public b(AbsHListView absHListView) {
        this.cCT = absHListView;
    }

    public void a(a aVar) {
        this.cCS = aVar;
    }

    public boolean alb() {
        return this.cCS != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cCS.onCreateActionMode(actionMode, menu)) {
            this.cCT.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cCS.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cCS.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cCS.onDestroyActionMode(actionMode);
        this.cCT.cCW = null;
        this.cCT.clearChoices();
        this.cCT.ajr = true;
        this.cCT.alR();
        this.cCT.requestLayout();
        this.cCT.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cCS.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cCT.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
