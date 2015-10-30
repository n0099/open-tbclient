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
    private ChildViewPager aXG;
    private ed aXH;
    private a aXI;
    private com.baidu.tbadk.core.data.p aXJ;
    private IndicatorView apA;
    private Context mContext;
    private final Handler.Callback mCallback = new cs(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ct(this);
    private ChildViewPager.a aXK = new cu(this);

    public cr(ChildViewPager childViewPager, IndicatorView indicatorView) {
        this.aXG = childViewPager;
        this.apA = indicatorView;
        this.mContext = childViewPager.getContext();
        this.aXH = new ed(this.mContext);
        this.aXH.setPortraitClicklistener(this);
        this.aXG.setAdapter(this.aXH);
        this.aXG.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aXG.setOnSingleTouchListener(this.aXK);
        this.apA.setSelector(com.baidu.tbadk.core.util.an.getDrawable(i.e.dot_live_s));
        this.apA.setDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.dot_live_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj() {
        int count;
        if (this.aXG != null && this.aXH != null && (count = this.aXH.getCount()) >= 2) {
            int currentItem = this.aXG.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aXG.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aXG.setCurrentItem(1, false);
            } else {
                this.aXG.setCurrentItem(currentItem + 1);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null && pVar.rK() != null) {
            this.aXJ = pVar;
            this.aXI = new a(pVar.rK());
            this.aXH.setDatas(this.aXI.Mo());
            this.aXG.setAdapter(this.aXH);
            this.aXG.setCurrentItem(this.aXI.Mn(), false);
            if (this.aXI.Mm() >= 2) {
                this.apA.setVisibility(0);
                if (this.apA.getCount() != this.aXI.Mm()) {
                    this.apA.setCount(this.aXI.Mm());
                }
                Mk();
                return;
            }
            this.apA.setVisibility(8);
            Ml();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ml() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10178").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", this.aXI.fE(this.aXG.getCurrentItem()) + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<PhotoLiveCardData> aXM;
        private List<PhotoLiveCardData> aXN;
        private final boolean aXO;

        public a(List<PhotoLiveCardData> list) {
            this.aXM = list;
            if (list != null && list.size() > 1) {
                this.aXO = true;
            } else {
                this.aXO = false;
            }
            this.aXN = X(this.aXM);
        }

        private List<PhotoLiveCardData> X(List<PhotoLiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.aXO && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fD(int i) {
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
        public int Mm() {
            if (this.aXM == null) {
                return 0;
            }
            return this.aXM.size();
        }

        public int Mn() {
            return this.aXO ? 1 : 0;
        }

        public List<PhotoLiveCardData> Mo() {
            return this.aXN;
        }
    }
}
