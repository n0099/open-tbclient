package com.baidu.tieba.hottopic.b;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.hottopic.a.m;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e implements RelateForumViewPager.a {
    private IndicatorView apz;
    private RelateForumViewPager bpI;
    private TextView bpK;
    private m bpL;
    private a bpM;
    private HotTopicActivity bpN;
    private com.baidu.tieba.hottopic.data.g bpO = new com.baidu.tieba.hottopic.data.g();
    private final Handler.Callback mCallback = new f(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener bpP = new g(this);

    public e(HotTopicActivity hotTopicActivity, RelateForumViewPager relateForumViewPager, IndicatorView indicatorView, TextView textView) {
        this.bpI = relateForumViewPager;
        this.apz = indicatorView;
        this.bpK = textView;
        this.bpN = hotTopicActivity;
        this.bpL = new m(hotTopicActivity);
        this.bpI.setAdapter(this.bpL);
        this.bpI.setOnPageChangeListener(this.bpP);
        this.apz.setSelector(am.getDrawable(i.e.icon_choose_dot_s));
        this.apz.setDrawable(am.getDrawable(i.e.icon_choose_dot_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<RelateForumItemData> aXB;
        private List<RelateForumItemData> aXC;
        private final boolean aXD;

        public a(List<RelateForumItemData> list) {
            this.aXB = list;
            if (list != null && list.size() >= 2 && list.size() <= 4) {
                this.aXD = true;
            } else {
                this.aXD = false;
            }
            this.aXC = QZ();
        }

        private List<RelateForumItemData> QZ() {
            ArrayList arrayList = new ArrayList();
            if (this.aXB != null) {
                if (this.aXD) {
                    arrayList.addAll(this.aXB);
                    arrayList.add(0, this.aXB.get(this.aXB.size() - 1));
                    arrayList.add(this.aXB.get(0));
                } else if (this.aXB != null && this.aXB.size() > 0) {
                    arrayList.add(this.aXB.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int gE(int i) {
            if (this.aXD) {
                int size = this.aXC.size();
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
            if (this.aXD) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int Mq() {
            if (this.aXB == null) {
                return 0;
            }
            return this.aXB.size();
        }

        public int Mr() {
            return this.aXD ? 1 : 0;
        }

        public List<RelateForumItemData> Ms() {
            return this.aXC;
        }
    }

    public void a(com.baidu.tieba.hottopic.data.g gVar) {
        if (gVar.getCount() > 0) {
            this.bpO = gVar;
            this.bpM = new a(gVar.bpf);
            this.bpL.setDatas(this.bpM.Ms());
            this.bpI.setAdapter(this.bpL);
            this.bpI.setCurrentItem(this.bpM.Mr(), false);
            if (this.bpM.Mq() > 0) {
                if (this.bpM.Mq() > 4) {
                    this.apz.setVisibility(8);
                    am.b(this.bpK, i.c.cp_cont_d, 1);
                    this.bpK.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_scan_all));
                    this.bpK.setVisibility(0);
                    this.bpK.setOnClickListener(new h(this));
                    Mp();
                }
                if (this.bpM.Mq() >= 2 && this.bpM.Mq() <= 4) {
                    this.bpK.setVisibility(8);
                    this.bpK.getRootView().setEnabled(false);
                    this.apz.setVisibility(0);
                    if (this.apz.getCount() != this.bpM.Mq()) {
                        this.apz.setCount(this.bpM.Mq());
                    }
                    Mo();
                }
                if (this.bpM.Mq() < 2) {
                    this.bpK.setVisibility(8);
                    this.apz.setVisibility(8);
                    Mp();
                }
                this.bpL.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        int count;
        if (this.bpI != null && this.bpL != null && (count = this.bpL.getCount()) >= 2) {
            int currentItem = this.bpI.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bpI.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bpI.setCurrentItem(1, false);
            } else {
                this.bpI.setCurrentItem(currentItem + 1);
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
        this.bpL.destory();
        this.bpI.removeAllViews();
    }

    public void QK() {
        this.bpL.QK();
        this.apz.setSelector(am.getDrawable(i.e.icon_choose_dot_s));
        this.apz.setDrawable(am.getDrawable(i.e.icon_choose_dot_n));
    }
}
