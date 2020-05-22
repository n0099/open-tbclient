package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a ijH;
    private AbsHListView ijI;

    public b(AbsHListView absHListView) {
        this.ijI = absHListView;
    }

    public void a(a aVar) {
        this.ijH = aVar;
    }

    public boolean Gw() {
        return this.ijH != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ijH.onCreateActionMode(actionMode, menu)) {
            this.ijI.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ijH.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ijH.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ijH.onDestroyActionMode(actionMode);
        this.ijI.mChoiceActionMode = null;
        this.ijI.clearChoices();
        this.ijI.mDataChanged = true;
        this.ijI.rememberSyncState();
        this.ijI.requestLayout();
        this.ijI.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ijH.a(actionMode, i, j, z);
        if (this.ijI.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
