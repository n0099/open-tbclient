package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a iHA;
    private AbsHListView iHB;

    public b(AbsHListView absHListView) {
        this.iHB = absHListView;
    }

    public void a(a aVar) {
        this.iHA = aVar;
    }

    public boolean HP() {
        return this.iHA != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iHA.onCreateActionMode(actionMode, menu)) {
            this.iHB.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iHA.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iHA.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iHA.onDestroyActionMode(actionMode);
        this.iHB.mChoiceActionMode = null;
        this.iHB.clearChoices();
        this.iHB.mDataChanged = true;
        this.iHB.rememberSyncState();
        this.iHB.requestLayout();
        this.iHB.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iHA.a(actionMode, i, j, z);
        if (this.iHB.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
