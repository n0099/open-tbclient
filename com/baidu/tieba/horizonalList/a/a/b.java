package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gig;
    private AbsHListView gih;

    public b(AbsHListView absHListView) {
        this.gih = absHListView;
    }

    public void a(a aVar) {
        this.gig = aVar;
    }

    public boolean buT() {
        return this.gig != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gig.onCreateActionMode(actionMode, menu)) {
            this.gih.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gig.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gig.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gig.onDestroyActionMode(actionMode);
        this.gih.mChoiceActionMode = null;
        this.gih.clearChoices();
        this.gih.mDataChanged = true;
        this.gih.rememberSyncState();
        this.gih.requestLayout();
        this.gih.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.gig.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.gih.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
