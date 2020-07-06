package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.person.adapter.PersonViewPagerAdapter;
import com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment;
import com.baidu.tieba.ala.person.view.PersonPageIndicator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int YJ;
    private PersonListFragment gxA;
    private boolean gxj;
    private PersonViewPagerAdapter gxr;
    private ViewPager gxs;
    protected Object gxt;
    protected Object gxu;
    private PersonPageIndicator gxv;
    private int gxw;
    private ViewPager.OnPageChangeListener gxx;
    private int gxy = 0;
    private List<Fragment> gxz = new LinkedList();
    private String metaKey;
    private int type;
    private String userId;

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getInt("type");
        this.userId = getArguments().getString("user_id");
        this.metaKey = getArguments().getString("meta_key");
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            this.gxw = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gxw = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ag(inflate);
        initListener();
        bLd();
        se(this.type);
        return inflate;
    }

    private void bLd() {
        this.gxv.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gxv.setViewPager(this.gxs, this.gxw / 3);
        } else {
            this.gxv.setViewPager(this.gxs, this.gxw / 2);
        }
        this.gxv.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gxz.add(PersonPlayBacksListFragment.A(this.userId, null));
            this.gxv.Dx(getString(a.i.ala_person_playbacks));
        }
        this.gxz.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gxt));
        this.gxv.Dx(getString(a.i.ala_person_fans));
        this.gxA = PersonListFragment.a(1, this.userId, this.metaKey, this.gxu);
        this.gxz.add(this.gxA);
        this.gxv.Dx(getString(a.i.ala_person_attentions));
        this.gxr = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gxr.setData(this.gxz);
        this.gxs.setAdapter(this.gxr);
    }

    private void initListener() {
        this.gxs.setOnPageChangeListener(this);
    }

    public void se(int i) {
        this.type = i;
        this.gxj = false;
        bLe();
        if (this.gxs != null) {
            this.gxs.setCurrentItem(this.YJ);
        }
    }

    private void bLe() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.YJ = 0;
            } else if (this.type == 0) {
                this.YJ = 1;
            } else if (this.type == 1) {
                this.YJ = 2;
            }
        } else if (this.type == 2) {
            this.YJ = 2;
        } else if (this.type == 0) {
            this.YJ = 0;
        } else if (this.type == 1) {
            this.YJ = 1;
        }
    }

    private void ag(View view) {
        this.gxs = (ViewPager) view.findViewById(a.g.viewpager);
        this.gxs.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gxy));
        this.gxv = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gxx != null) {
            this.gxx.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gxx != null) {
            this.gxx.onPageSelected(i);
        }
        this.YJ = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gxx != null) {
            this.gxx.onPageScrollStateChanged(i);
        }
    }
}
