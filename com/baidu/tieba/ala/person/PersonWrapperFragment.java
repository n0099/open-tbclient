package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.adapter.PersonViewPagerAdapter;
import com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment;
import com.baidu.tieba.ala.person.view.PersonPageIndicator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int Ev;
    private boolean fqO;
    private PersonViewPagerAdapter fqW;
    private ViewPager fqX;
    protected Object fqY;
    protected Object fqZ;
    private PersonPageIndicator fra;
    private int frb;
    private ViewPager.OnPageChangeListener frc;
    private int frd = 0;
    private List<Fragment> fre = new LinkedList();
    private PersonListFragment frf;
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
            this.frb = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.frb = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        bsa();
        qJ(this.type);
        return inflate;
    }

    private void bsa() {
        this.fra.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fra.setViewPager(this.fqX, this.frb / 3);
        } else {
            this.fra.setViewPager(this.fqX, this.frb / 2);
        }
        this.fra.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fre.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fra.zF(getString(a.i.ala_person_playbacks));
        }
        this.fre.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fqY));
        this.fra.zF(getString(a.i.ala_person_fans));
        this.frf = PersonListFragment.a(1, this.userId, this.metaKey, this.fqZ);
        this.fre.add(this.frf);
        this.fra.zF(getString(a.i.ala_person_attentions));
        this.fqW = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fqW.setData(this.fre);
        this.fqX.setAdapter(this.fqW);
    }

    private void initListener() {
        this.fqX.setOnPageChangeListener(this);
    }

    public void qJ(int i) {
        this.type = i;
        this.fqO = false;
        bsb();
        if (this.fqX != null) {
            this.fqX.setCurrentItem(this.Ev);
        }
    }

    private void bsb() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Ev = 0;
            } else if (this.type == 0) {
                this.Ev = 1;
            } else if (this.type == 1) {
                this.Ev = 2;
            }
        } else if (this.type == 2) {
            this.Ev = 2;
        } else if (this.type == 0) {
            this.Ev = 0;
        } else if (this.type == 1) {
            this.Ev = 1;
        }
    }

    private void initView(View view) {
        this.fqX = (ViewPager) view.findViewById(a.g.viewpager);
        this.fqX.setLayoutParams(new LinearLayout.LayoutParams(-2, this.frd));
        this.fra = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.frc != null) {
            this.frc.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.frc != null) {
            this.frc.onPageSelected(i);
        }
        this.Ev = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.frc != null) {
            this.frc.onPageScrollStateChanged(i);
        }
    }
}
