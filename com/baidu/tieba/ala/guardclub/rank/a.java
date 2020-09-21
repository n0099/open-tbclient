package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
/* loaded from: classes4.dex */
public abstract class a extends SupportXFragment {
    private e gfX;
    protected boolean mInitialed;
    protected boolean mVisible;

    protected abstract e bLG();

    protected abstract int bLH();

    protected abstract void onInflate(View view, Bundle bundle);

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gfX = bLG();
        this.mView = layoutInflater.inflate(bLH(), viewGroup, false);
        onInflate(this.mView, bundle);
        return this.mView;
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.mVisible && !this.mInitialed) {
            initData();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mVisible = z;
        if (getView() != null) {
            if (!this.mInitialed && z) {
                initData();
            }
            onVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onResume() {
        super.onResume();
        if (this.gfX != null) {
            this.gfX.onResume();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onPause() {
        if (this.gfX != null) {
            this.gfX.onPause();
        }
        super.onPause();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        if (this.gfX != null) {
            this.gfX.onDestoryView();
        }
        this.mInitialed = false;
        super.onDestroyView();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        if (this.gfX != null) {
            this.gfX.onDestroy();
        }
        super.onDestroy();
    }

    private void initData() {
        this.mInitialed = true;
        if (this.gfX != null) {
            this.gfX.onInitial();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged(boolean z) {
        if (this.gfX != null) {
            this.gfX.onVisibilityChanged(z);
        }
    }
}
