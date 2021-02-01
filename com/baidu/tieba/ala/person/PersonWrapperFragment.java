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
    private boolean hVa;
    private PersonViewPagerAdapter hVi;
    private ViewPager hVj;
    protected Object hVk;
    protected Object hVl;
    private PersonPageIndicator hVm;
    private int hVn;
    private ViewPager.OnPageChangeListener hVo;
    private int hVp = 0;
    private List<Fragment> hVq = new LinkedList();
    private PersonListFragment hVr;
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
            this.hVn = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hVn = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        am(inflate);
        initListener();
        cmw();
        wl(this.type);
        return inflate;
    }

    private void cmw() {
        this.hVm.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVm.setViewPager(this.hVj, this.hVn / 3);
        } else {
            this.hVm.setViewPager(this.hVj, this.hVn / 2);
        }
        this.hVm.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hVq.add(PersonPlayBacksListFragment.w(this.userId, null));
            this.hVm.Il(getString(a.h.ala_person_playbacks));
        }
        this.hVq.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hVk));
        this.hVm.Il(getString(a.h.ala_person_fans));
        this.hVr = PersonListFragment.a(1, this.userId, this.metaKey, this.hVl);
        this.hVq.add(this.hVr);
        this.hVm.Il(getString(a.h.ala_person_attentions));
        this.hVi = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hVi.setData(this.hVq);
        this.hVj.setAdapter(this.hVi);
    }

    private void initListener() {
        this.hVj.setOnPageChangeListener(this);
    }

    public void wl(int i) {
        this.type = i;
        this.hVa = false;
        cmx();
        if (this.hVj != null) {
            this.hVj.setCurrentItem(this.abv);
        }
    }

    private void cmx() {
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
        this.hVj = (ViewPager) view.findViewById(a.f.viewpager);
        this.hVj.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hVp));
        this.hVm = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hVo != null) {
            this.hVo.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hVo != null) {
            this.hVo.onPageSelected(i);
        }
        this.abv = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hVo != null) {
            this.hVo.onPageScrollStateChanged(i);
        }
    }
}
