package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hlh;
    private AbsHListView hli;

    public b(AbsHListView absHListView) {
        this.hli = absHListView;
    }

    public void a(a aVar) {
        this.hlh = aVar;
    }

    public boolean zI() {
        return this.hlh != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hlh.onCreateActionMode(actionMode, menu)) {
            this.hli.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hlh.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hlh.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hlh.onDestroyActionMode(actionMode);
        this.hli.mChoiceActionMode = null;
        this.hli.clearChoices();
        this.hli.mDataChanged = true;
        this.hli.rememberSyncState();
        this.hli.requestLayout();
        this.hli.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hlh.a(actionMode, i, j, z);
        if (this.hli.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
