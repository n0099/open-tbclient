package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a krM;
    private AbsHListView krN;

    public b(AbsHListView absHListView) {
        this.krN = absHListView;
    }

    public void a(a aVar) {
        this.krM = aVar;
    }

    public boolean TC() {
        return this.krM != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.krM.onCreateActionMode(actionMode, menu)) {
            this.krN.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.krM.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.krM.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.krM.onDestroyActionMode(actionMode);
        this.krN.mChoiceActionMode = null;
        this.krN.clearChoices();
        this.krN.mDataChanged = true;
        this.krN.rememberSyncState();
        this.krN.requestLayout();
        this.krN.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.krM.a(actionMode, i, j, z);
        if (this.krN.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
