package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gpn;
    private AbsHListView gpo;

    public b(AbsHListView absHListView) {
        this.gpo = absHListView;
    }

    public void a(a aVar) {
        this.gpn = aVar;
    }

    public boolean bxQ() {
        return this.gpn != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gpn.onCreateActionMode(actionMode, menu)) {
            this.gpo.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gpn.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gpn.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gpn.onDestroyActionMode(actionMode);
        this.gpo.mChoiceActionMode = null;
        this.gpo.clearChoices();
        this.gpo.mDataChanged = true;
        this.gpo.rememberSyncState();
        this.gpo.requestLayout();
        this.gpo.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.gpn.a(actionMode, i, j, z);
        if (this.gpo.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
