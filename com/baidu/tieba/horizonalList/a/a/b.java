package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a iBw;
    private AbsHListView iBx;

    public b(AbsHListView absHListView) {
        this.iBx = absHListView;
    }

    public void a(a aVar) {
        this.iBw = aVar;
    }

    public boolean HJ() {
        return this.iBw != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iBw.onCreateActionMode(actionMode, menu)) {
            this.iBx.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iBw.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iBw.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iBw.onDestroyActionMode(actionMode);
        this.iBx.mChoiceActionMode = null;
        this.iBx.clearChoices();
        this.iBx.mDataChanged = true;
        this.iBx.rememberSyncState();
        this.iBx.requestLayout();
        this.iBx.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iBw.a(actionMode, i, j, z);
        if (this.iBx.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
