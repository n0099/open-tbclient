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
/* loaded from: classes7.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int Zf;
    private PersonListFragment gPA;
    private boolean gPj;
    private PersonViewPagerAdapter gPr;
    private ViewPager gPs;
    protected Object gPt;
    protected Object gPu;
    private PersonPageIndicator gPv;
    private int gPw;
    private ViewPager.OnPageChangeListener gPx;
    private int gPy = 0;
    private List<Fragment> gPz = new LinkedList();
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
            this.gPw = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gPw = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ak(inflate);
        initListener();
        bYl();
        uK(this.type);
        return inflate;
    }

    private void bYl() {
        this.gPv.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPv.setViewPager(this.gPs, this.gPw / 3);
        } else {
            this.gPv.setViewPager(this.gPs, this.gPw / 2);
        }
        this.gPv.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPz.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.gPv.GH(getString(a.i.ala_person_playbacks));
        }
        this.gPz.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gPt));
        this.gPv.GH(getString(a.i.ala_person_fans));
        this.gPA = PersonListFragment.a(1, this.userId, this.metaKey, this.gPu);
        this.gPz.add(this.gPA);
        this.gPv.GH(getString(a.i.ala_person_attentions));
        this.gPr = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gPr.setData(this.gPz);
        this.gPs.setAdapter(this.gPr);
    }

    private void initListener() {
        this.gPs.setOnPageChangeListener(this);
    }

    public void uK(int i) {
        this.type = i;
        this.gPj = false;
        bYm();
        if (this.gPs != null) {
            this.gPs.setCurrentItem(this.Zf);
        }
    }

    private void bYm() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Zf = 0;
            } else if (this.type == 0) {
                this.Zf = 1;
            } else if (this.type == 1) {
                this.Zf = 2;
            }
        } else if (this.type == 2) {
            this.Zf = 2;
        } else if (this.type == 0) {
            this.Zf = 0;
        } else if (this.type == 1) {
            this.Zf = 1;
        }
    }

    private void ak(View view) {
        this.gPs = (ViewPager) view.findViewById(a.g.viewpager);
        this.gPs.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gPy));
        this.gPv = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gPx != null) {
            this.gPx.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gPx != null) {
            this.gPx.onPageSelected(i);
        }
        this.Zf = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gPx != null) {
            this.gPx.onPageScrollStateChanged(i);
        }
    }
}
