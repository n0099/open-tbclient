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
    private int aaR;
    private boolean hJa;
    private PersonViewPagerAdapter hJi;
    private ViewPager hJj;
    protected Object hJk;
    protected Object hJl;
    private PersonPageIndicator hJm;
    private int hJn;
    private ViewPager.OnPageChangeListener hJo;
    private int hJp = 0;
    private List<Fragment> hJq = new LinkedList();
    private PersonListFragment hJr;
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
            this.hJn = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hJn = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        an(inflate);
        initListener();
        cmy();
        xt(this.type);
        return inflate;
    }

    private void cmy() {
        this.hJm.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hJm.setViewPager(this.hJj, this.hJn / 3);
        } else {
            this.hJm.setViewPager(this.hJj, this.hJn / 2);
        }
        this.hJm.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hJq.add(PersonPlayBacksListFragment.y(this.userId, null));
            this.hJm.IV(getString(a.h.ala_person_playbacks));
        }
        this.hJq.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hJk));
        this.hJm.IV(getString(a.h.ala_person_fans));
        this.hJr = PersonListFragment.a(1, this.userId, this.metaKey, this.hJl);
        this.hJq.add(this.hJr);
        this.hJm.IV(getString(a.h.ala_person_attentions));
        this.hJi = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hJi.setData(this.hJq);
        this.hJj.setAdapter(this.hJi);
    }

    private void initListener() {
        this.hJj.setOnPageChangeListener(this);
    }

    public void xt(int i) {
        this.type = i;
        this.hJa = false;
        cmz();
        if (this.hJj != null) {
            this.hJj.setCurrentItem(this.aaR);
        }
    }

    private void cmz() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.aaR = 0;
            } else if (this.type == 0) {
                this.aaR = 1;
            } else if (this.type == 1) {
                this.aaR = 2;
            }
        } else if (this.type == 2) {
            this.aaR = 2;
        } else if (this.type == 0) {
            this.aaR = 0;
        } else if (this.type == 1) {
            this.aaR = 1;
        }
    }

    private void an(View view) {
        this.hJj = (ViewPager) view.findViewById(a.f.viewpager);
        this.hJj.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hJp));
        this.hJm = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hJo != null) {
            this.hJo.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hJo != null) {
            this.hJo.onPageSelected(i);
        }
        this.aaR = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hJo != null) {
            this.hJo.onPageScrollStateChanged(i);
        }
    }
}
