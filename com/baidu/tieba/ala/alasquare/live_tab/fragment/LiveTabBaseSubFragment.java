package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.h0.d0.h;
/* loaded from: classes4.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public Context f14744e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14745f;

    /* renamed from: g  reason: collision with root package name */
    public h f14746g;
    public String j;
    public String k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14747h = false;
    public boolean i = false;
    public CustomMessageListener l = new a(2921442);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.i = false;
            }
        }
    }

    public void E0() {
        this.f14745f.setVisibility(8);
    }

    public void F0() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
        this.i = true;
    }

    public boolean G0() {
        return (k.isEmpty(this.j) || k.isEmpty(this.k)) ? false : true;
    }

    public abstract void H0();

    public void I0(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    public void J0() {
        this.f14745f.setVisibility(0);
        if (this.f14746g == null) {
            this.f14746g = new h(this.f14744e, null);
        }
        this.f14746g.e();
        this.f14746g.i(R.drawable.new_pic_emotion_03);
        this.f14746g.n(this.f14744e.getResources().getString(R.string.no_data_common_txt));
        this.f14746g.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.f14746g.b() == null || this.f14746g.b().getParent() != null) {
            return;
        }
        this.f14745f.addView(this.f14746g.b(), layoutParams);
    }

    public abstract void loadData();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        h hVar = this.f14746g;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    public abstract void w();
}
