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
    private int Yz;
    private boolean gCK;
    private PersonViewPagerAdapter gCS;
    private ViewPager gCT;
    protected Object gCU;
    protected Object gCV;
    private PersonPageIndicator gCW;
    private int gCX;
    private ViewPager.OnPageChangeListener gCY;
    private int gCZ = 0;
    private List<Fragment> gDa = new LinkedList();
    private PersonListFragment gDb;
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
            this.gCX = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gCX = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        aj(inflate);
        initListener();
        bOl();
        sw(this.type);
        return inflate;
    }

    private void bOl() {
        this.gCW.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gCW.setViewPager(this.gCT, this.gCX / 3);
        } else {
            this.gCW.setViewPager(this.gCT, this.gCX / 2);
        }
        this.gCW.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gDa.add(PersonPlayBacksListFragment.A(this.userId, null));
            this.gCW.Ei(getString(a.i.ala_person_playbacks));
        }
        this.gDa.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gCU));
        this.gCW.Ei(getString(a.i.ala_person_fans));
        this.gDb = PersonListFragment.a(1, this.userId, this.metaKey, this.gCV);
        this.gDa.add(this.gDb);
        this.gCW.Ei(getString(a.i.ala_person_attentions));
        this.gCS = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gCS.setData(this.gDa);
        this.gCT.setAdapter(this.gCS);
    }

    private void initListener() {
        this.gCT.setOnPageChangeListener(this);
    }

    public void sw(int i) {
        this.type = i;
        this.gCK = false;
        bOm();
        if (this.gCT != null) {
            this.gCT.setCurrentItem(this.Yz);
        }
    }

    private void bOm() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Yz = 0;
            } else if (this.type == 0) {
                this.Yz = 1;
            } else if (this.type == 1) {
                this.Yz = 2;
            }
        } else if (this.type == 2) {
            this.Yz = 2;
        } else if (this.type == 0) {
            this.Yz = 0;
        } else if (this.type == 1) {
            this.Yz = 1;
        }
    }

    private void aj(View view) {
        this.gCT = (ViewPager) view.findViewById(a.g.viewpager);
        this.gCT.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gCZ));
        this.gCW = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gCY != null) {
            this.gCY.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gCY != null) {
            this.gCY.onPageSelected(i);
        }
        this.Yz = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gCY != null) {
            this.gCY.onPageScrollStateChanged(i);
        }
    }
}
