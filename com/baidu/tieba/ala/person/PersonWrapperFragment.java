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
    private boolean fqc;
    private PersonViewPagerAdapter fqk;
    private ViewPager fql;
    protected Object fqm;
    protected Object fqn;
    private PersonPageIndicator fqo;
    private int fqp;
    private ViewPager.OnPageChangeListener fqq;
    private int fqr = 0;
    private List<Fragment> fqs = new LinkedList();
    private PersonListFragment fqt;
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
            this.fqp = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fqp = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        brU();
        qH(this.type);
        return inflate;
    }

    private void brU() {
        this.fqo.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqo.setViewPager(this.fql, this.fqp / 3);
        } else {
            this.fqo.setViewPager(this.fql, this.fqp / 2);
        }
        this.fqo.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqs.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fqo.zD(getString(a.i.ala_person_playbacks));
        }
        this.fqs.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fqm));
        this.fqo.zD(getString(a.i.ala_person_fans));
        this.fqt = PersonListFragment.a(1, this.userId, this.metaKey, this.fqn);
        this.fqs.add(this.fqt);
        this.fqo.zD(getString(a.i.ala_person_attentions));
        this.fqk = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fqk.setData(this.fqs);
        this.fql.setAdapter(this.fqk);
    }

    private void initListener() {
        this.fql.setOnPageChangeListener(this);
    }

    public void qH(int i) {
        this.type = i;
        this.fqc = false;
        brV();
        if (this.fql != null) {
            this.fql.setCurrentItem(this.Ev);
        }
    }

    private void brV() {
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
        this.fql = (ViewPager) view.findViewById(a.g.viewpager);
        this.fql.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fqr));
        this.fqo = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fqq != null) {
            this.fqq.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fqq != null) {
            this.fqq.onPageSelected(i);
        }
        this.Ev = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fqq != null) {
            this.fqq.onPageScrollStateChanged(i);
        }
    }
}
