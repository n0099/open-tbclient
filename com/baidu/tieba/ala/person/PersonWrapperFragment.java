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
    private PersonListFragment gkB;
    private boolean gkk;
    private PersonViewPagerAdapter gks;
    private ViewPager gkt;
    protected Object gku;
    protected Object gkv;
    private PersonPageIndicator gkw;
    private int gkx;
    private ViewPager.OnPageChangeListener gky;
    private String metaKey;
    private int type;
    private String userId;
    private int gkz = 0;
    private List<Fragment> gkA = new LinkedList();

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getInt("type");
        this.userId = getArguments().getString("user_id");
        this.metaKey = getArguments().getString("meta_key");
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            this.gkx = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.gkx = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ag(inflate);
        initListener();
        bHW();
        rE(this.type);
        return inflate;
    }

    private void bHW() {
        this.gkw.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gkw.setViewPager(this.gkt, this.gkx / 3);
        } else {
            this.gkw.setViewPager(this.gkt, this.gkx / 2);
        }
        this.gkw.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gkA.add(PersonPlayBacksListFragment.A(this.userId, null));
            this.gkw.CW(getString(a.i.ala_person_playbacks));
        }
        this.gkA.add(PersonListFragment.a(0, this.userId, this.metaKey, this.gku));
        this.gkw.CW(getString(a.i.ala_person_fans));
        this.gkB = PersonListFragment.a(1, this.userId, this.metaKey, this.gkv);
        this.gkA.add(this.gkB);
        this.gkw.CW(getString(a.i.ala_person_attentions));
        this.gks = new PersonViewPagerAdapter(getChildFragmentManager());
        this.gks.setData(this.gkA);
        this.gkt.setAdapter(this.gks);
    }

    private void initListener() {
        this.gkt.setOnPageChangeListener(this);
    }

    public void rE(int i) {
        this.type = i;
        this.gkk = false;
        bHX();
        if (this.gkt != null) {
            this.gkt.setCurrentItem(this.Yf);
        }
    }

    private void bHX() {
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
        this.gkt = (ViewPager) view.findViewById(a.g.viewpager);
        this.gkt.setLayoutParams(new LinearLayout.LayoutParams(-2, this.gkz));
        this.gkw = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gky != null) {
            this.gky.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.gky != null) {
            this.gky.onPageSelected(i);
        }
        this.Yf = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.gky != null) {
            this.gky.onPageScrollStateChanged(i);
        }
    }
}
