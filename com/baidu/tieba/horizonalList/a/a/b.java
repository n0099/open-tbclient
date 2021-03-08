package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a kuc;
    private AbsHListView kud;

    public b(AbsHListView absHListView) {
        this.kud = absHListView;
    }

    public void a(a aVar) {
        this.kuc = aVar;
    }

    public boolean TF() {
        return this.kuc != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.kuc.onCreateActionMode(actionMode, menu)) {
            this.kud.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.kuc.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.kuc.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.kuc.onDestroyActionMode(actionMode);
        this.kud.mChoiceActionMode = null;
        this.kud.clearChoices();
        this.kud.mDataChanged = true;
        this.kud.rememberSyncState();
        this.kud.requestLayout();
        this.kud.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.kuc.a(actionMode, i, j, z);
        if (this.kud.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
