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
    protected Object fqA;
    private PersonPageIndicator fqB;
    private int fqC;
    private ViewPager.OnPageChangeListener fqD;
    private int fqE = 0;
    private List<Fragment> fqF = new LinkedList();
    private PersonListFragment fqG;
    private boolean fqp;
    private PersonViewPagerAdapter fqx;
    private ViewPager fqy;
    protected Object fqz;
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
            this.fqC = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fqC = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        brV();
        qH(this.type);
        return inflate;
    }

    private void brV() {
        this.fqB.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqB.setViewPager(this.fqy, this.fqC / 3);
        } else {
            this.fqB.setViewPager(this.fqy, this.fqC / 2);
        }
        this.fqB.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqF.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fqB.zE(getString(a.i.ala_person_playbacks));
        }
        this.fqF.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fqz));
        this.fqB.zE(getString(a.i.ala_person_fans));
        this.fqG = PersonListFragment.a(1, this.userId, this.metaKey, this.fqA);
        this.fqF.add(this.fqG);
        this.fqB.zE(getString(a.i.ala_person_attentions));
        this.fqx = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fqx.setData(this.fqF);
        this.fqy.setAdapter(this.fqx);
    }

    private void initListener() {
        this.fqy.setOnPageChangeListener(this);
    }

    public void qH(int i) {
        this.type = i;
        this.fqp = false;
        brW();
        if (this.fqy != null) {
            this.fqy.setCurrentItem(this.Ev);
        }
    }

    private void brW() {
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
        this.fqy = (ViewPager) view.findViewById(a.g.viewpager);
        this.fqy.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fqE));
        this.fqB = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fqD != null) {
            this.fqD.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fqD != null) {
            this.fqD.onPageSelected(i);
        }
        this.Ev = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fqD != null) {
            this.fqD.onPageScrollStateChanged(i);
        }
    }
}
