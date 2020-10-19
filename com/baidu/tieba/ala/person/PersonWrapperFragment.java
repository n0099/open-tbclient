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
    private int ZP;
    private boolean hhS;
    private PersonViewPagerAdapter hia;
    private ViewPager hib;
    protected Object hic;
    protected Object hie;
    private PersonPageIndicator hif;
    private int hig;
    private ViewPager.OnPageChangeListener hih;
    private int hii = 0;
    private List<Fragment> hij = new LinkedList();
    private PersonListFragment hik;
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
            this.hig = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hig = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        an(inflate);
        initListener();
        cdG();
        vJ(this.type);
        return inflate;
    }

    private void cdG() {
        this.hif.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hif.setViewPager(this.hib, this.hig / 3);
        } else {
            this.hif.setViewPager(this.hib, this.hig / 2);
        }
        this.hif.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hij.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.hif.HP(getString(a.i.ala_person_playbacks));
        }
        this.hij.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hic));
        this.hif.HP(getString(a.i.ala_person_fans));
        this.hik = PersonListFragment.a(1, this.userId, this.metaKey, this.hie);
        this.hij.add(this.hik);
        this.hif.HP(getString(a.i.ala_person_attentions));
        this.hia = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hia.setData(this.hij);
        this.hib.setAdapter(this.hia);
    }

    private void initListener() {
        this.hib.setOnPageChangeListener(this);
    }

    public void vJ(int i) {
        this.type = i;
        this.hhS = false;
        cdH();
        if (this.hib != null) {
            this.hib.setCurrentItem(this.ZP);
        }
    }

    private void cdH() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.ZP = 0;
            } else if (this.type == 0) {
                this.ZP = 1;
            } else if (this.type == 1) {
                this.ZP = 2;
            }
        } else if (this.type == 2) {
            this.ZP = 2;
        } else if (this.type == 0) {
            this.ZP = 0;
        } else if (this.type == 1) {
            this.ZP = 1;
        }
    }

    private void an(View view) {
        this.hib = (ViewPager) view.findViewById(a.g.viewpager);
        this.hib.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hii));
        this.hif = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hih != null) {
            this.hih.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hih != null) {
            this.hih.onPageSelected(i);
        }
        this.ZP = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hih != null) {
            this.hih.onPageScrollStateChanged(i);
        }
    }
}
