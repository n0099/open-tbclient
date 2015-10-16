package com.baidu.tieba.hottopic.b;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.hottopic.a.m;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e implements RelateForumViewPager.a {
    private IndicatorView apA;
    private RelateForumViewPager bpT;
    private TextView bpV;
    private m bpW;
    private a bpX;
    private HotTopicActivity bpY;
    private com.baidu.tieba.hottopic.data.g bpZ = new com.baidu.tieba.hottopic.data.g();
    private final Handler.Callback mCallback = new f(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener bqa = new g(this);

    public e(HotTopicActivity hotTopicActivity, RelateForumViewPager relateForumViewPager, IndicatorView indicatorView, TextView textView) {
        this.bpT = relateForumViewPager;
        this.apA = indicatorView;
        this.bpV = textView;
        this.bpY = hotTopicActivity;
        this.bpW = new m(hotTopicActivity);
        this.bpT.setAdapter(this.bpW);
        this.bpT.setOnPageChangeListener(this.bqa);
        this.apA.setSelector(an.getDrawable(i.e.icon_choose_dot_s));
        this.apA.setDrawable(an.getDrawable(i.e.icon_choose_dot_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<RelateForumItemData> aXM;
        private List<RelateForumItemData> aXN;
        private final boolean aXO;

        public a(List<RelateForumItemData> list) {
            this.aXM = list;
            if (list != null && list.size() >= 2 && list.size() <= 4) {
                this.aXO = true;
            } else {
                this.aXO = false;
            }
            this.aXN = QZ();
        }

        private List<RelateForumItemData> QZ() {
            ArrayList arrayList = new ArrayList();
            if (this.aXM != null) {
                if (this.aXO) {
                    arrayList.addAll(this.aXM);
                    arrayList.add(0, this.aXM.get(this.aXM.size() - 1));
                    arrayList.add(this.aXM.get(0));
                } else if (this.aXM != null && this.aXM.size() > 0) {
                    arrayList.add(this.aXM.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int gE(int i) {
            if (this.aXO) {
                int size = this.aXN.size();
                if (i == 0) {
                    return size - 2;
                }
                if (i == size - 1) {
                    return 1;
                }
                return i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fE(int i) {
            if (this.aXO) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int Mq() {
            if (this.aXM == null) {
                return 0;
            }
            return this.aXM.size();
        }

        public int Mr() {
            return this.aXO ? 1 : 0;
        }

        public List<RelateForumItemData> Ms() {
            return this.aXN;
        }
    }

    public void a(com.baidu.tieba.hottopic.data.g gVar) {
        if (gVar.getCount() > 0) {
            this.bpZ = gVar;
            this.bpX = new a(gVar.bpq);
            this.bpW.setDatas(this.bpX.Ms());
            this.bpT.setAdapter(this.bpW);
            this.bpT.setCurrentItem(this.bpX.Mr(), false);
            if (this.bpX.Mq() > 0) {
                if (this.bpX.Mq() > 4) {
                    this.apA.setVisibility(8);
                    an.b(this.bpV, i.c.cp_cont_d, 1);
                    this.bpV.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_scan_all));
                    this.bpV.setVisibility(0);
                    this.bpV.setOnClickListener(new h(this));
                    Mp();
                }
                if (this.bpX.Mq() >= 2 && this.bpX.Mq() <= 4) {
                    this.bpV.setVisibility(8);
                    this.bpV.getRootView().setEnabled(false);
                    this.apA.setVisibility(0);
                    if (this.apA.getCount() != this.bpX.Mq()) {
                        this.apA.setCount(this.bpX.Mq());
                    }
                    Mo();
                }
                if (this.bpX.Mq() < 2) {
                    this.bpV.setVisibility(8);
                    this.apA.setVisibility(8);
                    Mp();
                }
                this.bpW.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        int count;
        if (this.bpT != null && this.bpW != null && (count = this.bpW.getCount()) >= 2) {
            int currentItem = this.bpT.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bpT.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bpT.setCurrentItem(1, false);
            } else {
                this.bpT.setCurrentItem(currentItem + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mo() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tieba.hottopic.view.RelateForumViewPager.a
    public void destory() {
        this.bpW.destory();
        this.bpT.removeAllViews();
    }

    public void QK() {
        this.bpW.QK();
        this.apA.setSelector(an.getDrawable(i.e.icon_choose_dot_s));
        this.apA.setDrawable(an.getDrawable(i.e.icon_choose_dot_n));
    }
}
