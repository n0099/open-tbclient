package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ksa;
    private AbsHListView ksb;

    public b(AbsHListView absHListView) {
        this.ksb = absHListView;
    }

    public void a(a aVar) {
        this.ksa = aVar;
    }

    public boolean TC() {
        return this.ksa != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ksa.onCreateActionMode(actionMode, menu)) {
            this.ksb.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ksa.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ksa.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ksa.onDestroyActionMode(actionMode);
        this.ksb.mChoiceActionMode = null;
        this.ksb.clearChoices();
        this.ksb.mDataChanged = true;
        this.ksb.rememberSyncState();
        this.ksb.requestLayout();
        this.ksb.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ksa.a(actionMode, i, j, z);
        if (this.ksb.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
