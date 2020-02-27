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
    private boolean fqb;
    private PersonViewPagerAdapter fqj;
    private ViewPager fqk;
    protected Object fql;
    protected Object fqm;
    private PersonPageIndicator fqn;
    private int fqo;
    private ViewPager.OnPageChangeListener fqp;
    private int fqq = 0;
    private List<Fragment> fqr = new LinkedList();
    private PersonListFragment fqs;
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
            this.fqo = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.fqo = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        initView(inflate);
        initListener();
        brS();
        qH(this.type);
        return inflate;
    }

    private void brS() {
        this.fqn.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqn.setViewPager(this.fqk, this.fqo / 3);
        } else {
            this.fqn.setViewPager(this.fqk, this.fqo / 2);
        }
        this.fqn.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqr.add(PersonPlayBacksListFragment.s(this.userId, null));
            this.fqn.zD(getString(a.i.ala_person_playbacks));
        }
        this.fqr.add(PersonListFragment.a(0, this.userId, this.metaKey, this.fql));
        this.fqn.zD(getString(a.i.ala_person_fans));
        this.fqs = PersonListFragment.a(1, this.userId, this.metaKey, this.fqm);
        this.fqr.add(this.fqs);
        this.fqn.zD(getString(a.i.ala_person_attentions));
        this.fqj = new PersonViewPagerAdapter(getChildFragmentManager());
        this.fqj.setData(this.fqr);
        this.fqk.setAdapter(this.fqj);
    }

    private void initListener() {
        this.fqk.setOnPageChangeListener(this);
    }

    public void qH(int i) {
        this.type = i;
        this.fqb = false;
        brT();
        if (this.fqk != null) {
            this.fqk.setCurrentItem(this.Ev);
        }
    }

    private void brT() {
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
        this.fqk = (ViewPager) view.findViewById(a.g.viewpager);
        this.fqk.setLayoutParams(new LinearLayout.LayoutParams(-2, this.fqq));
        this.fqn = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fqp != null) {
            this.fqp.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.fqp != null) {
            this.fqp.onPageSelected(i);
        }
        this.Ev = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.fqp != null) {
            this.fqp.onPageScrollStateChanged(i);
        }
    }
}
