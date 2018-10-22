package com.baidu.tieba.horizonalList.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
public class b implements a {
    private a epf;
    private AbsHListView epg;

    public b(AbsHListView absHListView) {
        this.epg = absHListView;
    }

    public void a(a aVar) {
        this.epf = aVar;
    }

    public boolean aKk() {
        return this.epf != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.epf.onCreateActionMode(actionMode, menu)) {
            this.epg.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.epf.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.epf.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.epf.onDestroyActionMode(actionMode);
        this.epg.mChoiceActionMode = null;
        this.epg.clearChoices();
        this.epg.mDataChanged = true;
        this.epg.rememberSyncState();
        this.epg.requestLayout();
        this.epg.setLongClickable(true);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.a
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.epf.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.epg.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
