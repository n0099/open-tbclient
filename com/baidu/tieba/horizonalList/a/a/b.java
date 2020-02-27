package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a hjt;
    private AbsHListView hju;

    public b(AbsHListView absHListView) {
        this.hju = absHListView;
    }

    public void a(a aVar) {
        this.hjt = aVar;
    }

    public boolean zz() {
        return this.hjt != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.hjt.onCreateActionMode(actionMode, menu)) {
            this.hju.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.hjt.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.hjt.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.hjt.onDestroyActionMode(actionMode);
        this.hju.mChoiceActionMode = null;
        this.hju.clearChoices();
        this.hju.mDataChanged = true;
        this.hju.rememberSyncState();
        this.hju.requestLayout();
        this.hju.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.hjt.a(actionMode, i, j, z);
        if (this.hju.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
