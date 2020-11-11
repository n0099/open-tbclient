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
    private int ZQ;
    private ViewPager.OnPageChangeListener hAa;
    private int hAb = 0;
    private List<Fragment> hAc = new LinkedList();
    private PersonListFragment hAd;
    private boolean hzM;
    private PersonViewPagerAdapter hzU;
    private ViewPager hzV;
    protected Object hzW;
    protected Object hzX;
    private PersonPageIndicator hzY;
    private int hzZ;
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
            this.hzZ = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hzZ = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        al(inflate);
        initListener();
        cjk();
        wq(this.type);
        return inflate;
    }

    private void cjk() {
        this.hzY.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hzY.setViewPager(this.hzV, this.hzZ / 3);
        } else {
            this.hzY.setViewPager(this.hzV, this.hzZ / 2);
        }
        this.hzY.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hAc.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.hzY.IF(getString(a.h.ala_person_playbacks));
        }
        this.hAc.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hzW));
        this.hzY.IF(getString(a.h.ala_person_fans));
        this.hAd = PersonListFragment.a(1, this.userId, this.metaKey, this.hzX);
        this.hAc.add(this.hAd);
        this.hzY.IF(getString(a.h.ala_person_attentions));
        this.hzU = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hzU.setData(this.hAc);
        this.hzV.setAdapter(this.hzU);
    }

    private void initListener() {
        this.hzV.setOnPageChangeListener(this);
    }

    public void wq(int i) {
        this.type = i;
        this.hzM = false;
        cjl();
        if (this.hzV != null) {
            this.hzV.setCurrentItem(this.ZQ);
        }
    }

    private void cjl() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.ZQ = 0;
            } else if (this.type == 0) {
                this.ZQ = 1;
            } else if (this.type == 1) {
                this.ZQ = 2;
            }
        } else if (this.type == 2) {
            this.ZQ = 2;
        } else if (this.type == 0) {
            this.ZQ = 0;
        } else if (this.type == 1) {
            this.ZQ = 1;
        }
    }

    private void al(View view) {
        this.hzV = (ViewPager) view.findViewById(a.f.viewpager);
        this.hzV.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hAb));
        this.hzY = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hAa != null) {
            this.hAa.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hAa != null) {
            this.hAa.onPageSelected(i);
        }
        this.ZQ = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hAa != null) {
            this.hAa.onPageScrollStateChanged(i);
        }
    }
}
