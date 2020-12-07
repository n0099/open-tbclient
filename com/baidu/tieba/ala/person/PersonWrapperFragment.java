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
    private boolean hIY;
    private PersonViewPagerAdapter hJg;
    private ViewPager hJh;
    protected Object hJi;
    protected Object hJj;
    private PersonPageIndicator hJk;
    private int hJl;
    private ViewPager.OnPageChangeListener hJm;
    private int hJn = 0;
    private List<Fragment> hJo = new LinkedList();
    private PersonListFragment hJp;
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
            this.hJl = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hJl = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        an(inflate);
        initListener();
        cmx();
        xt(this.type);
        return inflate;
    }

    private void cmx() {
        this.hJk.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hJk.setViewPager(this.hJh, this.hJl / 3);
        } else {
            this.hJk.setViewPager(this.hJh, this.hJl / 2);
        }
        this.hJk.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hJo.add(PersonPlayBacksListFragment.y(this.userId, null));
            this.hJk.IV(getString(a.h.ala_person_playbacks));
        }
        this.hJo.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hJi));
        this.hJk.IV(getString(a.h.ala_person_fans));
        this.hJp = PersonListFragment.a(1, this.userId, this.metaKey, this.hJj);
        this.hJo.add(this.hJp);
        this.hJk.IV(getString(a.h.ala_person_attentions));
        this.hJg = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hJg.setData(this.hJo);
        this.hJh.setAdapter(this.hJg);
    }

    private void initListener() {
        this.hJh.setOnPageChangeListener(this);
    }

    public void xt(int i) {
        this.type = i;
        this.hIY = false;
        cmy();
        if (this.hJh != null) {
            this.hJh.setCurrentItem(this.aaR);
        }
    }

    private void cmy() {
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
        this.hJh = (ViewPager) view.findViewById(a.f.viewpager);
        this.hJh.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hJn));
        this.hJk = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hJm != null) {
            this.hJm.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hJm != null) {
            this.hJm.onPageSelected(i);
        }
        this.aaR = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hJm != null) {
            this.hJm.onPageScrollStateChanged(i);
        }
    }
}
