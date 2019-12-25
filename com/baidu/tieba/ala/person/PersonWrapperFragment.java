package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
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
    private int DX;
    private int fkA;
    private ViewPager.OnPageChangeListener fkB;
    private int fkC = 0;
    private List<Fragment> fkD = new LinkedList();
    private PersonListFragment fkE;
    private boolean fkn;
    private PersonViewPagerAdapter fkv;
    private ViewPager fkw;
    protected Object fkx;
    protected Object fky;
    private PersonPageIndicator fkz;
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
            this.fkA = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fkA = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        bpn();
        qv(this.type);
        return inflate;
    }

    private void bpn() {
        this.fkz.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fkz.setViewPager(this.fkw, this.fkA / 3);
        } else {
            this.fkz.setViewPager(this.fkw, this.fkA / 2);
        }
        this.fkz.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fkD.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fkz.zd(getString(a.i.ala_person_playbacks));
        }
        this.fkD.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fkx));
        this.fkz.zd(getString(a.i.ala_person_fans));
        this.fkE = PersonListFragment.a(1, this.userId, this.metaKey, this.fky);
        this.fkD.add(this.fkE);
        this.fkz.zd(getString(a.i.ala_person_attentions));
        this.fkv = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fkv.setData(this.fkD);
        this.fkw.setAdapter(this.fkv);
    }

    private void initListener() {
        this.fkw.setOnPageChangeListener(this);
    }

    public void qv(int i) {
        this.type = i;
        this.fkn = false;
        bpo();
        if (this.fkw != null) {
            this.fkw.setCurrentItem(this.DX);
        }
    }

    private void bpo() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.DX = 0;
            } else if (this.type == 0) {
                this.DX = 1;
            } else if (this.type == 1) {
                this.DX = 2;
            }
        } else if (this.type == 2) {
            this.DX = 2;
        } else if (this.type == 0) {
            this.DX = 0;
        } else if (this.type == 1) {
            this.DX = 1;
        }
    }

    private void initView(View view) {
        this.fkw = (ViewPager) view.findViewById(a.g.viewpager);
        this.fkw.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fkC));
        this.fkz = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fkB != null) {
            this.fkB.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fkB != null) {
            this.fkB.onPageSelected(i);
        }
        this.DX = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fkB != null) {
            this.fkB.onPageScrollStateChanged(i);
        }
    }
}
