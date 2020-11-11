package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
/* loaded from: classes4.dex */
public abstract class a extends SupportXFragment {
    private e gIe;
    protected boolean mInitialed;
    protected boolean mVisible;

    protected abstract e bTu();

    protected abstract int bTv();

    protected abstract void onInflate(View view, Bundle bundle);

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gIe = bTu();
        this.mView = layoutInflater.inflate(bTv(), viewGroup, false);
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
        if (this.gIe != null) {
            this.gIe.onResume();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onPause() {
        if (this.gIe != null) {
            this.gIe.onPause();
        }
        super.onPause();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        if (this.gIe != null) {
            this.gIe.onDestoryView();
        }
        this.mInitialed = false;
        super.onDestroyView();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        if (this.gIe != null) {
            this.gIe.onDestroy();
        }
        super.onDestroy();
    }

    private void initData() {
        this.mInitialed = true;
        if (this.gIe != null) {
            this.gIe.onInitial();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged(boolean z) {
        if (this.gIe != null) {
            this.gIe.onVisibilityChanged(z);
        }
    }
}
