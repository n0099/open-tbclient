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
    private int abC;
    private ViewPager.OnPageChangeListener hVA;
    private int hVB = 0;
    private List<Fragment> hVC = new LinkedList();
    private PersonListFragment hVD;
    private boolean hVm;
    private PersonViewPagerAdapter hVu;
    private ViewPager hVv;
    protected Object hVw;
    protected Object hVx;
    private PersonPageIndicator hVy;
    private int hVz;
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
            this.hVz = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hVz = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        ap(inflate);
        initListener();
        cpp();
        xG(this.type);
        return inflate;
    }

    private void cpp() {
        this.hVy.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVy.setViewPager(this.hVv, this.hVz / 3);
        } else {
            this.hVy.setViewPager(this.hVv, this.hVz / 2);
        }
        this.hVy.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVC.add(PersonPlayBacksListFragment.y(this.userId, null));
            this.hVy.IT(getString(a.h.ala_person_playbacks));
        }
        this.hVC.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hVw));
        this.hVy.IT(getString(a.h.ala_person_fans));
        this.hVD = PersonListFragment.a(1, this.userId, this.metaKey, this.hVx);
        this.hVC.add(this.hVD);
        this.hVy.IT(getString(a.h.ala_person_attentions));
        this.hVu = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hVu.setData(this.hVC);
        this.hVv.setAdapter(this.hVu);
    }

    private void initListener() {
        this.hVv.setOnPageChangeListener(this);
    }

    public void xG(int i) {
        this.type = i;
        this.hVm = false;
        cpq();
        if (this.hVv != null) {
            this.hVv.setCurrentItem(this.abC);
        }
    }

    private void cpq() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.abC = 0;
            } else if (this.type == 0) {
                this.abC = 1;
            } else if (this.type == 1) {
                this.abC = 2;
            }
        } else if (this.type == 2) {
            this.abC = 2;
        } else if (this.type == 0) {
            this.abC = 0;
        } else if (this.type == 1) {
            this.abC = 1;
        }
    }

    private void ap(View view) {
        this.hVv = (ViewPager) view.findViewById(a.f.viewpager);
        this.hVv.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hVB));
        this.hVy = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hVA != null) {
            this.hVA.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hVA != null) {
            this.hVA.onPageSelected(i);
        }
        this.abC = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hVA != null) {
            this.hVA.onPageScrollStateChanged(i);
        }
    }
}
