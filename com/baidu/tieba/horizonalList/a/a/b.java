package com.baidu.tieba.horizonalList.a.a;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a cCc;
    private AbsHListView cCd;

    public b(AbsHListView absHListView) {
        this.cCd = absHListView;
    }

    public void a(a aVar) {
        this.cCc = aVar;
    }

    public boolean akg() {
        return this.cCc != null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.cCc.onCreateActionMode(actionMode, menu)) {
            this.cCd.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.cCc.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.cCc.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.cCc.onDestroyActionMode(actionMode);
        this.cCd.cCg = null;
        this.cCd.clearChoices();
        this.cCd.ajc = true;
        this.cCd.akW();
        this.cCd.requestLayout();
        this.cCd.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.cCc.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.cCd.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
