package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ctC;
    private AbsHListView ctD;

    public b(AbsHListView absHListView) {
        this.ctD = absHListView;
    }

    public void a(a aVar) {
        this.ctC = aVar;
    }

    public boolean ajN() {
        return this.ctC != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ctC.onCreateActionMode(actionMode, menu)) {
            this.ctD.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ctC.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ctC.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ctC.onDestroyActionMode(actionMode);
        this.ctD.ctG = null;
        this.ctD.clearChoices();
        this.ctD.aeC = true;
        this.ctD.akD();
        this.ctD.requestLayout();
        this.ctD.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.ctC.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.ctD.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
