package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a iku;
    private AbsHListView ikv;

    public b(AbsHListView absHListView) {
        this.ikv = absHListView;
    }

    public void a(a aVar) {
        this.iku = aVar;
    }

    public boolean Gw() {
        return this.iku != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.iku.onCreateActionMode(actionMode, menu)) {
            this.ikv.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.iku.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.iku.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.iku.onDestroyActionMode(actionMode);
        this.ikv.mChoiceActionMode = null;
        this.ikv.clearChoices();
        this.ikv.mDataChanged = true;
        this.ikv.rememberSyncState();
        this.ikv.requestLayout();
        this.ikv.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.iku.a(actionMode, i, j, z);
        if (this.ikv.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
