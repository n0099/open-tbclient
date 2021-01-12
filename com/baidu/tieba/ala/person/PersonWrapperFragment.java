package com.baidu.tieba.ala.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes10.dex */
public class PersonWrapperFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private int abA;
    private boolean hQF;
    private PersonViewPagerAdapter hQN;
    private ViewPager hQO;
    protected Object hQP;
    protected Object hQQ;
    private PersonPageIndicator hQR;
    private int hQS;
    private ViewPager.OnPageChangeListener hQT;
    private int hQU = 0;
    private List<Fragment> hQV = new LinkedList();
    private PersonListFragment hQW;
    private String metaKey;
    private int type;
    private String userId;

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getInt("type");
        this.userId = getArguments().getString("user_id");
        this.metaKey = getArguments().getString("meta_key");
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            this.hQS = getResources().getDimensionPixelSize(a.d.sdk_ds640) - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        } else if (UtilHelper.getRealScreenOrientation(getActivity()) == 1) {
            this.hQS = BdUtilHelper.getScreenDimensions(getActivity())[0] - (getResources().getDimensionPixelSize(a.d.sdk_ds34) * 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_wrapper, (ViewGroup) null);
        ap(inflate);
        initListener();
        cly();
        wa(this.type);
        return inflate;
    }

    private void cly() {
        this.hQR.setIndicatorMargin(getResources().getDimensionPixelSize(a.d.sdk_ds34));
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hQR.setViewPager(this.hQO, this.hQS / 3);
        } else {
            this.hQR.setViewPager(this.hQO, this.hQS / 2);
        }
        this.hQR.setOnPageChangeListener(this);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hQV.add(PersonPlayBacksListFragment.y(this.userId, null));
            this.hQR.HH(getString(a.h.ala_person_playbacks));
        }
        this.hQV.add(PersonListFragment.a(0, this.userId, this.metaKey, this.hQP));
        this.hQR.HH(getString(a.h.ala_person_fans));
        this.hQW = PersonListFragment.a(1, this.userId, this.metaKey, this.hQQ);
        this.hQV.add(this.hQW);
        this.hQR.HH(getString(a.h.ala_person_attentions));
        this.hQN = new PersonViewPagerAdapter(getChildFragmentManager());
        this.hQN.setData(this.hQV);
        this.hQO.setAdapter(this.hQN);
    }

    private void initListener() {
        this.hQO.setOnPageChangeListener(this);
    }

    public void wa(int i) {
        this.type = i;
        this.hQF = false;
        clz();
        if (this.hQO != null) {
            this.hQO.setCurrentItem(this.abA);
        }
    }

    private void clz() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            if (this.type == 2) {
                this.abA = 0;
            } else if (this.type == 0) {
                this.abA = 1;
            } else if (this.type == 1) {
                this.abA = 2;
            }
        } else if (this.type == 2) {
            this.abA = 2;
        } else if (this.type == 0) {
            this.abA = 0;
        } else if (this.type == 1) {
            this.abA = 1;
        }
    }

    private void ap(View view) {
        this.hQO = (ViewPager) view.findViewById(a.f.viewpager);
        this.hQO.setLayoutParams(new LinearLayout.LayoutParams(-2, this.hQU));
        this.hQR = (PersonPageIndicator) view.findViewById(a.f.page_indicator);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hQT != null) {
            this.hQT.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.hQT != null) {
            this.hQT.onPageSelected(i);
        }
        this.abA = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.hQT != null) {
            this.hQT.onPageScrollStateChanged(i);
        }
    }
}
