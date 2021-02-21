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
/* loaded from: classes11.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int abv;
    private PersonPageIndicator hVA;
    private int hVB;
    private ViewPager.OnPageChangeListener hVC;
    private int hVD = 0;
    private List<Fragment> hVE = new LinkedList();
    private PersonListFragment hVF;
    private boolean hVo;
    private PersonViewPagerAdapter hVw;
    private ViewPager hVx;
    protected Object hVy;
    protected Object hVz;
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
            this.hVB = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hVB = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        am(inflate);
        initListener();
        cmD();
        wl(this.type);
        return inflate;
    }

    private void cmD() {
        this.hVA.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVA.setViewPager(this.hVx, this.hVB / 3);
        } else {
            this.hVA.setViewPager(this.hVx, this.hVB / 2);
        }
        this.hVA.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVE.add(PersonPlayBacksListFragment.w(this.userId, null));
            this.hVA.Im(getString(a.h.ala_person_playbacks));
        }
        this.hVE.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hVy));
        this.hVA.Im(getString(a.h.ala_person_fans));
        this.hVF = PersonListFragment.a(1, this.userId, this.metaKey, this.hVz);
        this.hVE.add(this.hVF);
        this.hVA.Im(getString(a.h.ala_person_attentions));
        this.hVw = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hVw.setData(this.hVE);
        this.hVx.setAdapter(this.hVw);
    }

    private void initListener() {
        this.hVx.setOnPageChangeListener(this);
    }

    public void wl(int i) {
        this.type = i;
        this.hVo = false;
        cmE();
        if (this.hVx != null) {
            this.hVx.setCurrentItem(this.abv);
        }
    }

    private void cmE() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.abv = 0;
            } else if (this.type == 0) {
                this.abv = 1;
            } else if (this.type == 1) {
                this.abv = 2;
            }
        } else if (this.type == 2) {
            this.abv = 2;
        } else if (this.type == 0) {
            this.abv = 0;
        } else if (this.type == 1) {
            this.abv = 1;
        }
    }

    private void am(View view) {
        this.hVx = (ViewPager) view.findViewById(a.f.viewpager);
        this.hVx.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hVD));
        this.hVA = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hVC != null) {
            this.hVC.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hVC != null) {
            this.hVC.onPageSelected(i);
        }
        this.abv = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hVC != null) {
            this.hVC.onPageScrollStateChanged(i);
        }
    }
}
