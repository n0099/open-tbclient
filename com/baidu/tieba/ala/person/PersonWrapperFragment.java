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
    private int XP;
    protected Object fVA;
    private PersonPageIndicator fVB;
    private int fVC;
    private ViewPager.OnPageChangeListener fVD;
    private int fVE = 0;
    private List<Fragment> fVF = new LinkedList();
    private PersonListFragment fVG;
    private boolean fVp;
    private PersonViewPagerAdapter fVx;
    private ViewPager fVy;
    protected Object fVz;
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
            this.fVC = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fVC = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ag(inflate);
        initListener();
        bBD();
        rc(this.type);
        return inflate;
    }

    private void bBD() {
        this.fVB.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVB.setViewPager(this.fVy, this.fVC / 3);
        } else {
            this.fVB.setViewPager(this.fVy, this.fVC / 2);
        }
        this.fVB.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVF.add(PersonPlayBacksListFragment.x(this.userId, null));
            this.fVB.Bn(getString(a.i.ala_person_playbacks));
        }
        this.fVF.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fVz));
        this.fVB.Bn(getString(a.i.ala_person_fans));
        this.fVG = PersonListFragment.a(1, this.userId, this.metaKey, this.fVA);
        this.fVF.add(this.fVG);
        this.fVB.Bn(getString(a.i.ala_person_attentions));
        this.fVx = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fVx.setData(this.fVF);
        this.fVy.setAdapter(this.fVx);
    }

    private void initListener() {
        this.fVy.setOnPageChangeListener(this);
    }

    public void rc(int i) {
        this.type = i;
        this.fVp = false;
        bBE();
        if (this.fVy != null) {
            this.fVy.setCurrentItem(this.XP);
        }
    }

    private void bBE() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.XP = 0;
            } else if (this.type == 0) {
                this.XP = 1;
            } else if (this.type == 1) {
                this.XP = 2;
            }
        } else if (this.type == 2) {
            this.XP = 2;
        } else if (this.type == 0) {
            this.XP = 0;
        } else if (this.type == 1) {
            this.XP = 1;
        }
    }

    private void ag(View view) {
        this.fVy = (ViewPager) view.findViewById(a.g.viewpager);
        this.fVy.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fVE));
        this.fVB = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fVD != null) {
            this.fVD.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fVD != null) {
            this.fVD.onPageSelected(i);
        }
        this.XP = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fVD != null) {
            this.fVD.onPageScrollStateChanged(i);
        }
    }
}
