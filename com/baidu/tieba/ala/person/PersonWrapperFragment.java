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
/* loaded from: classes7.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int Zh;
    private int gPA;
    private ViewPager.OnPageChangeListener gPB;
    private int gPC = 0;
    private List<Fragment> gPD = new LinkedList();
    private PersonListFragment gPE;
    private boolean gPn;
    private PersonViewPagerAdapter gPv;
    private ViewPager gPw;
    protected Object gPx;
    protected Object gPy;
    private PersonPageIndicator gPz;
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
            this.gPA = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gPA = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ak(inflate);
        initListener();
        bYm();
        uK(this.type);
        return inflate;
    }

    private void bYm() {
        this.gPz.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPz.setViewPager(this.gPw, this.gPA / 3);
        } else {
            this.gPz.setViewPager(this.gPw, this.gPA / 2);
        }
        this.gPz.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPD.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.gPz.GI(getString(a.i.ala_person_playbacks));
        }
        this.gPD.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gPx));
        this.gPz.GI(getString(a.i.ala_person_fans));
        this.gPE = PersonListFragment.a(1, this.userId, this.metaKey, this.gPy);
        this.gPD.add(this.gPE);
        this.gPz.GI(getString(a.i.ala_person_attentions));
        this.gPv = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gPv.setData(this.gPD);
        this.gPw.setAdapter(this.gPv);
    }

    private void initListener() {
        this.gPw.setOnPageChangeListener(this);
    }

    public void uK(int i) {
        this.type = i;
        this.gPn = false;
        bYn();
        if (this.gPw != null) {
            this.gPw.setCurrentItem(this.Zh);
        }
    }

    private void bYn() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Zh = 0;
            } else if (this.type == 0) {
                this.Zh = 1;
            } else if (this.type == 1) {
                this.Zh = 2;
            }
        } else if (this.type == 2) {
            this.Zh = 2;
        } else if (this.type == 0) {
            this.Zh = 0;
        } else if (this.type == 1) {
            this.Zh = 1;
        }
    }

    private void ak(View view) {
        this.gPw = (ViewPager) view.findViewById(a.g.viewpager);
        this.gPw.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gPC));
        this.gPz = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gPB != null) {
            this.gPB.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gPB != null) {
            this.gPB.onPageSelected(i);
        }
        this.Zh = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gPB != null) {
            this.gPB.onPageScrollStateChanged(i);
        }
    }
}
