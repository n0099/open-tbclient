package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ChildViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cr implements PhotoLiveCardView.b {
    private ChildViewPager aXv;
    private ed aXw;
    private a aXx;
    private com.baidu.tbadk.core.data.o aXy;
    private IndicatorView apz;
    private Context mContext;
    private final Handler.Callback mCallback = new cs(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ct(this);
    private ChildViewPager.a aXz = new cu(this);

    public cr(ChildViewPager childViewPager, IndicatorView indicatorView) {
        this.aXv = childViewPager;
        this.apz = indicatorView;
        this.mContext = childViewPager.getContext();
        this.aXw = new ed(this.mContext);
        this.aXw.setPortraitClicklistener(this);
        this.aXv.setAdapter(this.aXw);
        this.aXv.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aXv.setOnSingleTouchListener(this.aXz);
        this.apz.setSelector(com.baidu.tbadk.core.util.am.getDrawable(i.e.dot_live_s));
        this.apz.setDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.e.dot_live_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        int count;
        if (this.aXv != null && this.aXw != null && (count = this.aXw.getCount()) >= 2) {
            int currentItem = this.aXv.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aXv.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aXv.setCurrentItem(1, false);
            } else {
                this.aXv.setCurrentItem(currentItem + 1);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && oVar.rN() != null) {
            this.aXy = oVar;
            this.aXx = new a(oVar.rN());
            this.aXw.setDatas(this.aXx.Ms());
            this.aXv.setAdapter(this.aXw);
            this.aXv.setCurrentItem(this.aXx.Mr(), false);
            if (this.aXx.Mq() >= 2) {
                this.apz.setVisibility(0);
                if (this.apz.getCount() != this.aXx.Mq()) {
                    this.apz.setCount(this.aXx.Mq());
                }
                Mo();
                return;
            }
            this.apz.setVisibility(8);
            Mp();
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

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10178").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", this.aXx.fE(this.aXv.getCurrentItem()) + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<PhotoLiveCardData> aXB;
        private List<PhotoLiveCardData> aXC;
        private final boolean aXD;

        public a(List<PhotoLiveCardData> list) {
            this.aXB = list;
            if (list != null && list.size() > 1) {
                this.aXD = true;
            } else {
                this.aXD = false;
            }
            this.aXC = X(this.aXB);
        }

        private List<PhotoLiveCardData> X(List<PhotoLiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.aXD && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fD(int i) {
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

        public List<PhotoLiveCardData> Ms() {
            return this.aXC;
        }
    }
}
