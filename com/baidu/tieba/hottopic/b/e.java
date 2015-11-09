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
    private IndicatorView ari;
    private m bqA;
    private a bqB;
    private HotTopicActivity bqC;
    private RelateForumViewPager bqx;
    private TextView bqz;
    private com.baidu.tieba.hottopic.data.g bqD = new com.baidu.tieba.hottopic.data.g();
    private final Handler.Callback mCallback = new f(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener bqE = new g(this);

    public e(HotTopicActivity hotTopicActivity, RelateForumViewPager relateForumViewPager, IndicatorView indicatorView, TextView textView) {
        this.bqx = relateForumViewPager;
        this.ari = indicatorView;
        this.bqz = textView;
        this.bqC = hotTopicActivity;
        this.bqA = new m(hotTopicActivity);
        this.bqx.setAdapter(this.bqA);
        this.bqx.setOnPageChangeListener(this.bqE);
        this.ari.setSelector(an.getDrawable(i.e.icon_choose_dot_s));
        this.ari.setDrawable(an.getDrawable(i.e.icon_choose_dot_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<RelateForumItemData> aXV;
        private List<RelateForumItemData> aXW;
        private final boolean aXX;

        public a(List<RelateForumItemData> list) {
            this.aXV = list;
            if (list != null && list.size() >= 2 && list.size() <= 4) {
                this.aXX = true;
            } else {
                this.aXX = false;
            }
            this.aXW = Rr();
        }

        private List<RelateForumItemData> Rr() {
            ArrayList arrayList = new ArrayList();
            if (this.aXV != null) {
                if (this.aXX) {
                    arrayList.addAll(this.aXV);
                    arrayList.add(0, this.aXV.get(this.aXV.size() - 1));
                    arrayList.add(this.aXV.get(0));
                } else if (this.aXV != null && this.aXV.size() > 0) {
                    arrayList.add(this.aXV.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int gR(int i) {
            if (this.aXX) {
                int size = this.aXW.size();
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
        public int fM(int i) {
            if (this.aXX) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int MC() {
            if (this.aXV == null) {
                return 0;
            }
            return this.aXV.size();
        }

        public int MD() {
            return this.aXX ? 1 : 0;
        }

        public List<RelateForumItemData> ME() {
            return this.aXW;
        }
    }

    public void a(com.baidu.tieba.hottopic.data.g gVar) {
        if (gVar.getCount() > 0) {
            this.bqD = gVar;
            this.bqB = new a(gVar.bpU);
            this.bqA.setDatas(this.bqB.ME());
            this.bqx.setAdapter(this.bqA);
            this.bqx.setCurrentItem(this.bqB.MD(), false);
            if (this.bqB.MC() > 0) {
                if (this.bqB.MC() > 4) {
                    this.ari.setVisibility(8);
                    an.b(this.bqz, i.c.cp_cont_d, 1);
                    this.bqz.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_scan_all));
                    this.bqz.setVisibility(0);
                    this.bqz.setOnClickListener(new h(this));
                    MB();
                }
                if (this.bqB.MC() >= 2 && this.bqB.MC() <= 4) {
                    this.bqz.setVisibility(8);
                    this.bqz.getRootView().setEnabled(false);
                    this.ari.setVisibility(0);
                    if (this.ari.getCount() != this.bqB.MC()) {
                        this.ari.setCount(this.bqB.MC());
                    }
                    MA();
                }
                if (this.bqB.MC() < 2) {
                    this.bqz.setVisibility(8);
                    this.ari.setVisibility(8);
                    MB();
                }
                this.bqA.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mz() {
        int count;
        if (this.bqx != null && this.bqA != null && (count = this.bqA.getCount()) >= 2) {
            int currentItem = this.bqx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bqx.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bqx.setCurrentItem(1, false);
            } else {
                this.bqx.setCurrentItem(currentItem + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MA() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MB() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tieba.hottopic.view.RelateForumViewPager.a
    public void destory() {
        this.bqA.destory();
        this.bqx.removeAllViews();
    }

    public void Rc() {
        this.bqA.Rc();
        this.ari.setSelector(an.getDrawable(i.e.icon_choose_dot_s));
        this.ari.setDrawable(an.getDrawable(i.e.icon_choose_dot_n));
    }
}
