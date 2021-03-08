package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes10.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int acR;
    private boolean hWX;
    private PersonViewPagerAdapter hXf;
    private ViewPager hXg;
    protected Object hXh;
    protected Object hXi;
    private PersonPageIndicator hXj;
    private int hXk;
    private ViewPager.OnPageChangeListener hXl;
    private int hXm = 0;
    private List<Fragment> hXn = new LinkedList();
    private PersonListFragment hXo;
    private String metaKey;
    private int type;
    private String userId;

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getInt("type");
        this.userId = getArguments().getString("user_id");
        this.metaKey = getArguments().getString("meta_key");
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            this.hXk = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hXk = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        am(inflate);
        initListener();
        cmJ();
        wm(this.type);
        return inflate;
    }

    private void cmJ() {
        this.hXj.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hXj.setViewPager(this.hXg, this.hXk / 3);
        } else {
            this.hXj.setViewPager(this.hXg, this.hXk / 2);
        }
        this.hXj.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hXn.add(PersonPlayBacksListFragment.x(this.userId, null));
            this.hXj.Iv(getString(a.h.ala_person_playbacks));
        }
        this.hXn.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hXh));
        this.hXj.Iv(getString(a.h.ala_person_fans));
        this.hXo = PersonListFragment.a(1, this.userId, this.metaKey, this.hXi);
        this.hXn.add(this.hXo);
        this.hXj.Iv(getString(a.h.ala_person_attentions));
        this.hXf = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hXf.setData(this.hXn);
        this.hXg.setAdapter(this.hXf);
    }

    private void initListener() {
        this.hXg.setOnPageChangeListener(this);
    }

    public void wm(int i) {
        this.type = i;
        this.hWX = false;
        cmK();
        if (this.hXg != null) {
            this.hXg.setCurrentItem(this.acR);
        }
    }

    private void cmK() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.acR = 0;
            } else if (this.type == 0) {
                this.acR = 1;
            } else if (this.type == 1) {
                this.acR = 2;
            }
        } else if (this.type == 2) {
            this.acR = 2;
        } else if (this.type == 0) {
            this.acR = 0;
        } else if (this.type == 1) {
            this.acR = 1;
        }
    }

    private void am(View view) {
        this.hXg = (ViewPager) view.findViewById(a.f.viewpager);
        this.hXg.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hXm));
        this.hXj = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hXl != null) {
            this.hXl.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hXl != null) {
            this.hXl.onPageSelected(i);
        }
        this.acR = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hXl != null) {
            this.hXl.onPageScrollStateChanged(i);
        }
    }
}
