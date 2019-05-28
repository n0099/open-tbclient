package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a gih;
    private AbsHListView gii;

    public b(AbsHListView absHListView) {
        this.gii = absHListView;
    }

    public void a(a aVar) {
        this.gih = aVar;
    }

    public boolean buW() {
        return this.gih != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.gih.onCreateActionMode(actionMode, menu)) {
            this.gii.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.gih.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.gih.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.gih.onDestroyActionMode(actionMode);
        this.gii.mChoiceActionMode = null;
        this.gii.clearChoices();
        this.gii.mDataChanged = true;
        this.gii.rememberSyncState();
        this.gii.requestLayout();
        this.gii.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.gih.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.gii.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
