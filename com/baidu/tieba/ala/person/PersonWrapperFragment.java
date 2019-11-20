package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.person.adapter.PersonViewPagerAdapter;
import com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment;
import com.baidu.tieba.ala.person.view.PersonPageIndicator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int Bq;
    private boolean esQ;
    private PersonViewPagerAdapter esY;
    private ViewPager esZ;
    protected Object eta;
    protected Object etb;
    private PersonPageIndicator etd;
    private int ete;
    private ViewPager.OnPageChangeListener etf;
    private int etg = 0;
    private List<Fragment> eth = new LinkedList();
    private PersonListFragment eti;
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
            this.ete = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.ete = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        W(inflate);
        initListener();
        aXp();
        od(this.type);
        return inflate;
    }

    private void aXp() {
        this.etd.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.etd.setViewPager(this.esZ, this.ete / 3);
        } else {
            this.etd.setViewPager(this.esZ, this.ete / 2);
        }
        this.etd.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.eth.add(PersonPlayBacksListFragment.l(this.userId, null));
            this.etd.uk(getString(a.i.ala_person_playbacks));
        }
        this.eth.add(PersonListFragment.a(0, this.userId, this.metaKey, this.eta));
        this.etd.uk(getString(a.i.ala_person_fans));
        this.eti = PersonListFragment.a(1, this.userId, this.metaKey, this.etb);
        this.eth.add(this.eti);
        this.etd.uk(getString(a.i.ala_person_attentions));
        this.esY = new PersonViewPagerAdapter(getChildFragmentManager());
        this.esY.setData(this.eth);
        this.esZ.setAdapter(this.esY);
    }

    private void initListener() {
        this.esZ.setOnPageChangeListener(this);
    }

    public void od(int i) {
        this.type = i;
        this.esQ = false;
        aXq();
        if (this.esZ != null) {
            this.esZ.setCurrentItem(this.Bq);
        }
    }

    private void aXq() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.Bq = 0;
            } else if (this.type == 0) {
                this.Bq = 1;
            } else if (this.type == 1) {
                this.Bq = 2;
            }
        } else if (this.type == 2) {
            this.Bq = 2;
        } else if (this.type == 0) {
            this.Bq = 0;
        } else if (this.type == 1) {
            this.Bq = 1;
        }
    }

    private void W(View view) {
        this.esZ = (ViewPager) view.findViewById(a.g.viewpager);
        this.esZ.setLayoutParams(new LinearLayout.LayoutParams(-2, this.etg));
        this.etd = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.etf != null) {
            this.etf.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.etf != null) {
            this.etf.onPageSelected(i);
        }
        this.Bq = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.etf != null) {
            this.etf.onPageScrollStateChanged(i);
        }
    }
}
