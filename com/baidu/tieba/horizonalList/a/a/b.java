package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cAG;
    private AbsHListView cAH;

    public b(AbsHListView absHListView) {
        this.cAH = absHListView;
    }

    public void a(a aVar) {
        this.cAG = aVar;
    }

    public boolean akU() {
        return this.cAG != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cAG.onCreateActionMode(actionMode, menu)) {
            this.cAH.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cAG.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cAG.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cAG.onDestroyActionMode(actionMode);
        this.cAH.cAK = null;
        this.cAH.clearChoices();
        this.cAH.adN = true;
        this.cAH.alK();
        this.cAH.requestLayout();
        this.cAH.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cAG.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cAH.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
