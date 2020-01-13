package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.person.adapter.PersonViewPagerAdapter;
import com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment;
import com.baidu.tieba.ala.person.view.PersonPageIndicator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int Ec;
    private PersonViewPagerAdapter fnF;
    private ViewPager fnG;
    protected Object fnH;
    protected Object fnI;
    private PersonPageIndicator fnJ;
    private int fnK;
    private ViewPager.OnPageChangeListener fnL;
    private int fnM = 0;
    private List<Fragment> fnN = new LinkedList();
    private PersonListFragment fnO;
    private boolean fnx;
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
            this.fnK = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fnK = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        bqo();
        qA(this.type);
        return inflate;
    }

    private void bqo() {
        this.fnJ.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fnJ.setViewPager(this.fnG, this.fnK / 3);
        } else {
            this.fnJ.setViewPager(this.fnG, this.fnK / 2);
        }
        this.fnJ.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fnN.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fnJ.zm(getString(a.i.ala_person_playbacks));
        }
        this.fnN.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fnH));
        this.fnJ.zm(getString(a.i.ala_person_fans));
        this.fnO = PersonListFragment.a(1, this.userId, this.metaKey, this.fnI);
        this.fnN.add(this.fnO);
        this.fnJ.zm(getString(a.i.ala_person_attentions));
        this.fnF = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fnF.setData(this.fnN);
        this.fnG.setAdapter(this.fnF);
    }

    private void initListener() {
        this.fnG.setOnPageChangeListener(this);
    }

    public void qA(int i) {
        this.type = i;
        this.fnx = false;
        bqp();
        if (this.fnG != null) {
            this.fnG.setCurrentItem(this.Ec);
        }
    }

    private void bqp() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Ec = 0;
            } else if (this.type == 0) {
                this.Ec = 1;
            } else if (this.type == 1) {
                this.Ec = 2;
            }
        } else if (this.type == 2) {
            this.Ec = 2;
        } else if (this.type == 0) {
            this.Ec = 0;
        } else if (this.type == 1) {
            this.Ec = 1;
        }
    }

    private void initView(View view) {
        this.fnG = (ViewPager) view.findViewById(a.g.viewpager);
        this.fnG.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fnM));
        this.fnJ = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fnL != null) {
            this.fnL.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fnL != null) {
            this.fnL.onPageSelected(i);
        }
        this.Ec = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fnL != null) {
            this.fnL.onPageScrollStateChanged(i);
        }
    }
}
