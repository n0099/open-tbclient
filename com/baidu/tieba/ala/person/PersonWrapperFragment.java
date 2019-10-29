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
    private int BQ;
    private boolean etI;
    private PersonViewPagerAdapter etQ;
    private ViewPager etR;
    protected Object etS;
    protected Object etT;
    private PersonPageIndicator etU;
    private int etV;
    private ViewPager.OnPageChangeListener etW;
    private int etX = 0;
    private List<Fragment> etY = new LinkedList();
    private PersonListFragment etZ;
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
            this.etV = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.etV = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        W(inflate);
        initListener();
        aXr();
        oe(this.type);
        return inflate;
    }

    private void aXr() {
        this.etU.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.etU.setViewPager(this.etR, this.etV / 3);
        } else {
            this.etU.setViewPager(this.etR, this.etV / 2);
        }
        this.etU.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.etY.add(PersonPlayBacksListFragment.l(this.userId, null));
            this.etU.uk(getString(a.i.ala_person_playbacks));
        }
        this.etY.add(PersonListFragment.a(0, this.userId, this.metaKey, this.etS));
        this.etU.uk(getString(a.i.ala_person_fans));
        this.etZ = PersonListFragment.a(1, this.userId, this.metaKey, this.etT);
        this.etY.add(this.etZ);
        this.etU.uk(getString(a.i.ala_person_attentions));
        this.etQ = new PersonViewPagerAdapter(getChildFragmentManager());
        this.etQ.setData(this.etY);
        this.etR.setAdapter(this.etQ);
    }

    private void initListener() {
        this.etR.setOnPageChangeListener(this);
    }

    public void oe(int i) {
        this.type = i;
        this.etI = false;
        aXs();
        if (this.etR != null) {
            this.etR.setCurrentItem(this.BQ);
        }
    }

    private void aXs() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.BQ = 0;
            } else if (this.type == 0) {
                this.BQ = 1;
            } else if (this.type == 1) {
                this.BQ = 2;
            }
        } else if (this.type == 2) {
            this.BQ = 2;
        } else if (this.type == 0) {
            this.BQ = 0;
        } else if (this.type == 1) {
            this.BQ = 1;
        }
    }

    private void W(View view) {
        this.etR = (ViewPager) view.findViewById(a.g.viewpager);
        this.etR.setLayoutParams(new LinearLayout.LayoutParams(-2, this.etX));
        this.etU = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.etW != null) {
            this.etW.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.etW != null) {
            this.etW.onPageSelected(i);
        }
        this.BQ = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.etW != null) {
            this.etW.onPageScrollStateChanged(i);
        }
    }
}
