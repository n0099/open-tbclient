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
    private int Yf;
    private PersonViewPagerAdapter gkD;
    private ViewPager gkE;
    protected Object gkF;
    protected Object gkG;
    private PersonPageIndicator gkH;
    private int gkI;
    private ViewPager.OnPageChangeListener gkJ;
    private int gkK = 0;
    private List<Fragment> gkL = new LinkedList();
    private PersonListFragment gkM;
    private boolean gkv;
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
            this.gkI = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gkI = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ag(inflate);
        initListener();
        bHY();
        rG(this.type);
        return inflate;
    }

    private void bHY() {
        this.gkH.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gkH.setViewPager(this.gkE, this.gkI / 3);
        } else {
            this.gkH.setViewPager(this.gkE, this.gkI / 2);
        }
        this.gkH.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gkL.add(PersonPlayBacksListFragment.A(this.userId, null));
            this.gkH.CW(getString(a.i.ala_person_playbacks));
        }
        this.gkL.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gkF));
        this.gkH.CW(getString(a.i.ala_person_fans));
        this.gkM = PersonListFragment.a(1, this.userId, this.metaKey, this.gkG);
        this.gkL.add(this.gkM);
        this.gkH.CW(getString(a.i.ala_person_attentions));
        this.gkD = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gkD.setData(this.gkL);
        this.gkE.setAdapter(this.gkD);
    }

    private void initListener() {
        this.gkE.setOnPageChangeListener(this);
    }

    public void rG(int i) {
        this.type = i;
        this.gkv = false;
        bHZ();
        if (this.gkE != null) {
            this.gkE.setCurrentItem(this.Yf);
        }
    }

    private void bHZ() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Yf = 0;
            } else if (this.type == 0) {
                this.Yf = 1;
            } else if (this.type == 1) {
                this.Yf = 2;
            }
        } else if (this.type == 2) {
            this.Yf = 2;
        } else if (this.type == 0) {
            this.Yf = 0;
        } else if (this.type == 1) {
            this.Yf = 1;
        }
    }

    private void ag(View view) {
        this.gkE = (ViewPager) view.findViewById(a.g.viewpager);
        this.gkE.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gkK));
        this.gkH = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gkJ != null) {
            this.gkJ.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gkJ != null) {
            this.gkJ.onPageSelected(i);
        }
        this.Yf = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gkJ != null) {
            this.gkJ.onPageScrollStateChanged(i);
        }
    }
}
