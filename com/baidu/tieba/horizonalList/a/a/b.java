package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a fRf;
    private AbsHListView fRg;

    public b(AbsHListView absHListView) {
        this.fRg = absHListView;
    }

    public void a(a aVar) {
        this.fRf = aVar;
    }

    public boolean bnt() {
        return this.fRf != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.fRf.onCreateActionMode(actionMode, menu)) {
            this.fRg.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.fRf.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.fRf.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.fRf.onDestroyActionMode(actionMode);
        this.fRg.mChoiceActionMode = null;
        this.fRg.clearChoices();
        this.fRg.mDataChanged = true;
        this.fRg.rememberSyncState();
        this.fRg.requestLayout();
        this.fRg.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.fRf.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.fRg.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
