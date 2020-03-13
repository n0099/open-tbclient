package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hjH;
    private AbsHListView hjI;

    public b(AbsHListView absHListView) {
        this.hjI = absHListView;
    }

    public void a(a aVar) {
        this.hjH = aVar;
    }

    public boolean zB() {
        return this.hjH != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hjH.onCreateActionMode(actionMode, menu)) {
            this.hjI.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hjH.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hjH.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hjH.onDestroyActionMode(actionMode);
        this.hjI.mChoiceActionMode = null;
        this.hjI.clearChoices();
        this.hjI.mDataChanged = true;
        this.hjI.rememberSyncState();
        this.hjI.requestLayout();
        this.hjI.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hjH.a(actionMode, i, j, z);
        if (this.hjI.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
