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
    private int Zz;
    private boolean gSV;
    private PersonViewPagerAdapter gTd;
    private ViewPager gTe;
    protected Object gTf;
    protected Object gTg;
    private PersonPageIndicator gTh;
    private int gTi;
    private ViewPager.OnPageChangeListener gTj;
    private int gTk = 0;
    private List<Fragment> gTl = new LinkedList();
    private PersonListFragment gTm;
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
            this.gTi = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gTi = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        am(inflate);
        initListener();
        cai();
        vd(this.type);
        return inflate;
    }

    private void cai() {
        this.gTh.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTh.setViewPager(this.gTe, this.gTi / 3);
        } else {
            this.gTh.setViewPager(this.gTe, this.gTi / 2);
        }
        this.gTh.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTl.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.gTh.Hb(getString(a.i.ala_person_playbacks));
        }
        this.gTl.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gTf));
        this.gTh.Hb(getString(a.i.ala_person_fans));
        this.gTm = PersonListFragment.a(1, this.userId, this.metaKey, this.gTg);
        this.gTl.add(this.gTm);
        this.gTh.Hb(getString(a.i.ala_person_attentions));
        this.gTd = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gTd.setData(this.gTl);
        this.gTe.setAdapter(this.gTd);
    }

    private void initListener() {
        this.gTe.setOnPageChangeListener(this);
    }

    public void vd(int i) {
        this.type = i;
        this.gSV = false;
        caj();
        if (this.gTe != null) {
            this.gTe.setCurrentItem(this.Zz);
        }
    }

    private void caj() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Zz = 0;
            } else if (this.type == 0) {
                this.Zz = 1;
            } else if (this.type == 1) {
                this.Zz = 2;
            }
        } else if (this.type == 2) {
            this.Zz = 2;
        } else if (this.type == 0) {
            this.Zz = 0;
        } else if (this.type == 1) {
            this.Zz = 1;
        }
    }

    private void am(View view) {
        this.gTe = (ViewPager) view.findViewById(a.g.viewpager);
        this.gTe.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gTk));
        this.gTh = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gTj != null) {
            this.gTj.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gTj != null) {
            this.gTj.onPageSelected(i);
        }
        this.Zz = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gTj != null) {
            this.gTj.onPageScrollStateChanged(i);
        }
    }
}
