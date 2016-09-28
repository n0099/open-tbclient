package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cJh;
    private AbsHListView cJi;

    public b(AbsHListView absHListView) {
        this.cJi = absHListView;
    }

    public void a(a aVar) {
        this.cJh = aVar;
    }

    public boolean anr() {
        return this.cJh != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cJh.onCreateActionMode(actionMode, menu)) {
            this.cJi.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cJh.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cJh.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cJh.onDestroyActionMode(actionMode);
        this.cJi.cJl = null;
        this.cJi.clearChoices();
        this.cJi.aeL = true;
        this.cJi.aoh();
        this.cJi.requestLayout();
        this.cJi.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cJh.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cJi.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
