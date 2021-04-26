package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.i0.d0.h;
/* loaded from: classes4.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public Context f14480e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14481f;

    /* renamed from: g  reason: collision with root package name */
    public h f14482g;
    public int j;
    public String k;
    public String l;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14483h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14484i = false;
    public CustomMessageListener m = new a(2921442);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.f14484i = false;
            }
        }
    }

    public void E0() {
        this.f14481f.setVisibility(8);
    }

    public void F0() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
        this.f14484i = true;
    }

    public boolean G0() {
        return (k.isEmpty(this.k) || k.isEmpty(this.l)) ? false : true;
    }

    public abstract void H0();

    public void I0(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    public void J0() {
        this.f14481f.setVisibility(0);
        if (this.f14482g == null) {
            this.f14482g = new h(this.f14480e, null);
        }
        this.f14482g.e();
        this.f14482g.i(R.drawable.new_pic_emotion_03);
        this.f14482g.n(this.f14480e.getResources().getString(R.string.no_data_common_txt));
        this.f14482g.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.f14482g.b() == null || this.f14482g.b().getParent() != null) {
            return;
        }
        this.f14481f.addView(this.f14482g.b(), layoutParams);
    }

    public abstract void loadData();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        h hVar = this.f14482g;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    public abstract void p();
}
