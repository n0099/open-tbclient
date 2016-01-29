package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a bEX;
    private AbsHListView bEY;

    public b(AbsHListView absHListView) {
        this.bEY = absHListView;
    }

    public void a(a aVar) {
        this.bEX = aVar;
    }

    public boolean Wk() {
        return this.bEX != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bEX.onCreateActionMode(actionMode, menu)) {
            this.bEY.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bEX.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bEX.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bEX.onDestroyActionMode(actionMode);
        this.bEY.bFb = null;
        this.bEY.clearChoices();
        this.bEY.afI = true;
        this.bEY.Xa();
        this.bEY.requestLayout();
        this.bEY.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.bEX.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.bEY.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
