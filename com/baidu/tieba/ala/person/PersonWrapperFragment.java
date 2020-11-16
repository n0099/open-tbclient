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
/* loaded from: classes4.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int ZV;
    private PersonViewPagerAdapter hzB;
    private ViewPager hzC;
    protected Object hzD;
    protected Object hzE;
    private PersonPageIndicator hzF;
    private int hzG;
    private ViewPager.OnPageChangeListener hzH;
    private int hzI = 0;
    private List<Fragment> hzJ = new LinkedList();
    private PersonListFragment hzK;
    private boolean hzt;
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
            this.hzG = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hzG = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        al(inflate);
        initListener();
        ciD();
        wO(this.type);
        return inflate;
    }

    private void ciD() {
        this.hzF.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hzF.setViewPager(this.hzC, this.hzG / 3);
        } else {
            this.hzF.setViewPager(this.hzC, this.hzG / 2);
        }
        this.hzF.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hzJ.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.hzF.Ig(getString(a.h.ala_person_playbacks));
        }
        this.hzJ.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hzD));
        this.hzF.Ig(getString(a.h.ala_person_fans));
        this.hzK = PersonListFragment.a(1, this.userId, this.metaKey, this.hzE);
        this.hzJ.add(this.hzK);
        this.hzF.Ig(getString(a.h.ala_person_attentions));
        this.hzB = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hzB.setData(this.hzJ);
        this.hzC.setAdapter(this.hzB);
    }

    private void initListener() {
        this.hzC.setOnPageChangeListener(this);
    }

    public void wO(int i) {
        this.type = i;
        this.hzt = false;
        ciE();
        if (this.hzC != null) {
            this.hzC.setCurrentItem(this.ZV);
        }
    }

    private void ciE() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.ZV = 0;
            } else if (this.type == 0) {
                this.ZV = 1;
            } else if (this.type == 1) {
                this.ZV = 2;
            }
        } else if (this.type == 2) {
            this.ZV = 2;
        } else if (this.type == 0) {
            this.ZV = 0;
        } else if (this.type == 1) {
            this.ZV = 1;
        }
    }

    private void al(View view) {
        this.hzC = (ViewPager) view.findViewById(a.f.viewpager);
        this.hzC.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hzI));
        this.hzF = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hzH != null) {
            this.hzH.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hzH != null) {
            this.hzH.onPageSelected(i);
        }
        this.ZV = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hzH != null) {
            this.hzH.onPageScrollStateChanged(i);
        }
    }
}
