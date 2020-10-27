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
    private int ZQ;
    private boolean htP;
    private PersonViewPagerAdapter htX;
    private ViewPager htY;
    protected Object htZ;
    protected Object hua;
    private PersonPageIndicator hub;
    private int huc;
    private ViewPager.OnPageChangeListener hud;
    private int hue = 0;
    private List<Fragment> huf = new LinkedList();
    private PersonListFragment hug;
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
            this.huc = getResources().getDimensionPixelSize(a.e.sdk_ds640) - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.huc = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.e.sdk_ds34) * 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_wrapper, (ViewGroup) null);
        ah(inflate);
        initListener();
        cgI();
        wd(this.type);
        return inflate;
    }

    private void cgI() {
        this.hub.setIndicatorMargin(getResources().getDimensionPixelSize(a.e.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hub.setViewPager(this.htY, this.huc / 3);
        } else {
            this.hub.setViewPager(this.htY, this.huc / 2);
        }
        this.hub.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.huf.add(PersonPlayBacksListFragment.z(this.userId, null));
            this.hub.Io(getString(a.i.ala_person_playbacks));
        }
        this.huf.add(PersonListFragment.a(0, this.userId, this.metaKey, this.htZ));
        this.hub.Io(getString(a.i.ala_person_fans));
        this.hug = PersonListFragment.a(1, this.userId, this.metaKey, this.hua);
        this.huf.add(this.hug);
        this.hub.Io(getString(a.i.ala_person_attentions));
        this.htX = new PersonViewPagerAdapter(getChildFragmentManager());
        this.htX.setData(this.huf);
        this.htY.setAdapter(this.htX);
    }

    private void initListener() {
        this.htY.setOnPageChangeListener(this);
    }

    public void wd(int i) {
        this.type = i;
        this.htP = false;
        cgJ();
        if (this.htY != null) {
            this.htY.setCurrentItem(this.ZQ);
        }
    }

    private void cgJ() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.ZQ = 0;
            } else if (this.type == 0) {
                this.ZQ = 1;
            } else if (this.type == 1) {
                this.ZQ = 2;
            }
        } else if (this.type == 2) {
            this.ZQ = 2;
        } else if (this.type == 0) {
            this.ZQ = 0;
        } else if (this.type == 1) {
            this.ZQ = 1;
        }
    }

    private void ah(View view) {
        this.htY = (ViewPager) view.findViewById(a.g.viewpager);
        this.htY.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hue));
        this.hub = (PersonPageIndicator) view.findViewById(a.g.page_indicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hud != null) {
            this.hud.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hud != null) {
            this.hud.onPageSelected(i);
        }
        this.ZQ = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hud != null) {
            this.hud.onPageScrollStateChanged(i);
        }
    }
}
