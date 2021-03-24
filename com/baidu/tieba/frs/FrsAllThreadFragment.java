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
import d.b.h0.i0.c;
import d.b.i0.p0.q0;
import d.b.i0.p0.u;
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements q0 {

    /* renamed from: e  reason: collision with root package name */
    public View f15967e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15968f;

    /* renamed from: g  reason: collision with root package name */
    public String f15969g;

    @Override // d.b.i0.p0.q0
    public void B0() {
        RecyclerView recyclerView = this.f15968f;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // d.b.i0.p0.q0
    public void E() {
        B0();
        u uVar = new u();
        uVar.f58581a = 1;
        uVar.f58582b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void E0(int i, String str) {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15969g).param("obj_type", str).param("obj_locate", i).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void F0() {
        View view = this.f15967e;
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f15967e.getParent()).removeView(this.f15967e);
        this.f15967e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    public void G0(View view) {
        this.f15967e = view;
        this.f15968f = (RecyclerView) view.findViewById(R.id.frs_lv_thread);
        F0();
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
            this.f15969g = arguments.getString("forum_id", "");
        }
        F0();
        return this.f15967e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            E0(2, "4");
        } else {
            E0(2, "5");
        }
    }
}
