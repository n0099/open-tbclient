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
    private ChildViewPager aXP;
    private ef aXQ;
    private a aXR;
    private com.baidu.tbadk.core.data.p aXS;
    private IndicatorView ari;
    private Context mContext;
    private final Handler.Callback mCallback = new cs(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ct(this);
    private ChildViewPager.a aXT = new cu(this);

    public cr(ChildViewPager childViewPager, IndicatorView indicatorView) {
        this.aXP = childViewPager;
        this.ari = indicatorView;
        this.mContext = childViewPager.getContext();
        this.aXQ = new ef(this.mContext);
        this.aXQ.setPortraitClicklistener(this);
        this.aXP.setAdapter(this.aXQ);
        this.aXP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aXP.setOnSingleTouchListener(this.aXT);
        this.ari.setSelector(com.baidu.tbadk.core.util.an.getDrawable(i.e.dot_live_s));
        this.ari.setDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.dot_live_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mz() {
        int count;
        if (this.aXP != null && this.aXQ != null && (count = this.aXQ.getCount()) >= 2) {
            int currentItem = this.aXP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aXP.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aXP.setCurrentItem(1, false);
            } else {
                this.aXP.setCurrentItem(currentItem + 1);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null && pVar.rM() != null) {
            this.aXS = pVar;
            this.aXR = new a(pVar.rM());
            this.aXQ.setDatas(this.aXR.ME());
            this.aXP.setAdapter(this.aXQ);
            this.aXP.setCurrentItem(this.aXR.MD(), false);
            if (this.aXR.MC() >= 2) {
                this.ari.setVisibility(0);
                if (this.ari.getCount() != this.aXR.MC()) {
                    this.ari.setCount(this.aXR.MC());
                }
                MA();
                return;
            }
            this.ari.setVisibility(8);
            MB();
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

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10178").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", this.aXR.fM(this.aXP.getCurrentItem()) + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<PhotoLiveCardData> aXV;
        private List<PhotoLiveCardData> aXW;
        private final boolean aXX;

        public a(List<PhotoLiveCardData> list) {
            this.aXV = list;
            if (list != null && list.size() > 1) {
                this.aXX = true;
            } else {
                this.aXX = false;
            }
            this.aXW = Z(this.aXV);
        }

        private List<PhotoLiveCardData> Z(List<PhotoLiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.aXX && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fL(int i) {
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

        public List<PhotoLiveCardData> ME() {
            return this.aXW;
        }
    }
}
