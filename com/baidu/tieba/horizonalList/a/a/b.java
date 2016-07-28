package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cwL;
    private AbsHListView cwM;

    public b(AbsHListView absHListView) {
        this.cwM = absHListView;
    }

    public void a(a aVar) {
        this.cwL = aVar;
    }

    public boolean aip() {
        return this.cwL != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cwL.onCreateActionMode(actionMode, menu)) {
            this.cwM.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cwL.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cwL.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cwL.onDestroyActionMode(actionMode);
        this.cwM.cwP = null;
        this.cwM.clearChoices();
        this.cwM.abK = true;
        this.cwM.ajf();
        this.cwM.requestLayout();
        this.cwM.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cwL.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cwM.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
