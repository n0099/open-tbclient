package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hdP;
    private AbsHListView hdQ;

    public b(AbsHListView absHListView) {
        this.hdQ = absHListView;
    }

    public void a(a aVar) {
        this.hdP = aVar;
    }

    public boolean wS() {
        return this.hdP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hdP.onCreateActionMode(actionMode, menu)) {
            this.hdQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hdP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hdP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hdP.onDestroyActionMode(actionMode);
        this.hdQ.mChoiceActionMode = null;
        this.hdQ.clearChoices();
        this.hdQ.mDataChanged = true;
        this.hdQ.rememberSyncState();
        this.hdQ.requestLayout();
        this.hdQ.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hdP.a(actionMode, i, j, z);
        if (this.hdQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
