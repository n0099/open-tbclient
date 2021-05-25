package com.baidu.tieba.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.m0.i0.c;
import d.a.n0.r0.q0;
import d.a.n0.r0.u;
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements q0 {

    /* renamed from: e  reason: collision with root package name */
    public View f15020e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15021f;

    /* renamed from: g  reason: collision with root package name */
    public String f15022g;

    @Override // d.a.n0.r0.q0
    public void B0() {
        RecyclerView recyclerView = this.f15021f;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    public final void D0(int i2, String str) {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15022g).param("obj_type", str).param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void E0() {
        View view = this.f15020e;
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f15020e.getParent()).removeView(this.f15020e);
        this.f15020e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    public void F0(View view) {
        this.f15020e = view;
        this.f15021f = (RecyclerView) view.findViewById(R.id.frs_lv_thread);
        E0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new c(getUniqueId(), "a006", baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15022g = arguments.getString("forum_id", "");
        }
        E0();
        return this.f15020e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            D0(2, "4");
        } else {
            D0(2, "5");
        }
    }

    @Override // d.a.n0.r0.q0
    public void t() {
        B0();
        u uVar = new u();
        uVar.f59661a = 1;
        uVar.f59662b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
