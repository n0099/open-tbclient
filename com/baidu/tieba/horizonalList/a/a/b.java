package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a drW;
    private AbsHListView drX;

    public b(AbsHListView absHListView) {
        this.drX = absHListView;
    }

    public void a(a aVar) {
        this.drW = aVar;
    }

    public boolean auo() {
        return this.drW != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.drW.onCreateActionMode(actionMode, menu)) {
            this.drX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.drW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.drW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.drW.onDestroyActionMode(actionMode);
        this.drX.mChoiceActionMode = null;
        this.drX.clearChoices();
        this.drX.mDataChanged = true;
        this.drX.rememberSyncState();
        this.drX.requestLayout();
        this.drX.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.drW.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.drX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
