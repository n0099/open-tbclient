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
    private int XM;
    private PersonListFragment fVB;
    private boolean fVk;
    private PersonViewPagerAdapter fVs;
    private ViewPager fVt;
    protected Object fVu;
    protected Object fVv;
    private PersonPageIndicator fVw;
    private int fVx;
    private ViewPager.OnPageChangeListener fVy;
    private String metaKey;
    private int type;
    private String userId;
    private int fVz = 0;
    private List<Fragment> fVA = new LinkedList();

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getInt("type");
        this.userId = getArguments().getString("user_id");
        this.metaKey = getArguments().getString("meta_key");
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            this.fVx = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fVx = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ag(inflate);
        initListener();
        bBF();
        rc(this.type);
        return inflate;
    }

    private void bBF() {
        this.fVw.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVw.setViewPager(this.fVt, this.fVx / 3);
        } else {
            this.fVw.setViewPager(this.fVt, this.fVx / 2);
        }
        this.fVw.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVA.add(PersonPlayBacksListFragment.x(this.userId, null));
            this.fVw.Bk(getString(a.i.ala_person_playbacks));
        }
        this.fVA.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fVu));
        this.fVw.Bk(getString(a.i.ala_person_fans));
        this.fVB = PersonListFragment.a(1, this.userId, this.metaKey, this.fVv);
        this.fVA.add(this.fVB);
        this.fVw.Bk(getString(a.i.ala_person_attentions));
        this.fVs = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fVs.setData(this.fVA);
        this.fVt.setAdapter(this.fVs);
    }

    private void initListener() {
        this.fVt.setOnPageChangeListener(this);
    }

    public void rc(int i) {
        this.type = i;
        this.fVk = false;
        bBG();
        if (this.fVt != null) {
            this.fVt.setCurrentItem(this.XM);
        }
    }

    private void bBG() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.XM = 0;
            } else if (this.type == 0) {
                this.XM = 1;
            } else if (this.type == 1) {
                this.XM = 2;
            }
        } else if (this.type == 2) {
            this.XM = 2;
        } else if (this.type == 0) {
            this.XM = 0;
        } else if (this.type == 1) {
            this.XM = 1;
        }
    }

    private void ag(View view) {
        this.fVt = (ViewPager) view.findViewById(a.g.viewpager);
        this.fVt.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fVz));
        this.fVw = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fVy != null) {
            this.fVy.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fVy != null) {
            this.fVy.onPageSelected(i);
        }
        this.XM = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fVy != null) {
            this.fVy.onPageScrollStateChanged(i);
        }
    }
}
