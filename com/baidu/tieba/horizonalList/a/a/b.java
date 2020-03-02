package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hjv;
    private AbsHListView hjw;

    public b(AbsHListView absHListView) {
        this.hjw = absHListView;
    }

    public void a(a aVar) {
        this.hjv = aVar;
    }

    public boolean zB() {
        return this.hjv != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hjv.onCreateActionMode(actionMode, menu)) {
            this.hjw.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hjv.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hjv.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hjv.onDestroyActionMode(actionMode);
        this.hjw.mChoiceActionMode = null;
        this.hjw.clearChoices();
        this.hjw.mDataChanged = true;
        this.hjw.rememberSyncState();
        this.hjw.requestLayout();
        this.hjw.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hjv.a(actionMode, i, j, z);
        if (this.hjw.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
