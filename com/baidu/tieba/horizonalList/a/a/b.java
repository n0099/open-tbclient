package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a iHC;
    private AbsHListView iHD;

    public b(AbsHListView absHListView) {
        this.iHD = absHListView;
    }

    public void a(a aVar) {
        this.iHC = aVar;
    }

    public boolean HP() {
        return this.iHC != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iHC.onCreateActionMode(actionMode, menu)) {
            this.iHD.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iHC.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iHC.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iHC.onDestroyActionMode(actionMode);
        this.iHD.mChoiceActionMode = null;
        this.iHD.clearChoices();
        this.iHD.mDataChanged = true;
        this.iHD.rememberSyncState();
        this.iHD.requestLayout();
        this.iHD.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iHC.a(actionMode, i, j, z);
        if (this.iHD.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
