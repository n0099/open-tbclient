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
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.NewChildViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class dh implements PhotoLiveCardView.b {
    private IndicatorView agf;
    private NewChildViewPager bdP;
    private final ex bdQ;
    private a bdR;
    private com.baidu.tbadk.core.data.s bdS;
    private Context mContext;
    private final Handler.Callback mCallback = new di(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new dj(this);
    private NewChildViewPager.b bdT = new dk(this);

    public dh(NewChildViewPager newChildViewPager, IndicatorView indicatorView, ex exVar) {
        this.bdP = newChildViewPager;
        this.agf = indicatorView;
        this.mContext = newChildViewPager.getContext();
        if (exVar != null) {
            this.bdQ = exVar;
        } else {
            this.bdQ = new ex(this.mContext);
        }
        this.bdQ.setPortraitClicklistener(this);
        this.bdP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.bdP.setOnItemClickListener(this.bdT);
        this.agf.setSelector(com.baidu.tbadk.core.util.as.getDrawable(n.e.dot_live_s));
        this.agf.setDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.dot_live_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        int count;
        if (this.bdP != null && this.bdQ != null && (count = this.bdQ.getCount()) >= 2) {
            int currentItem = this.bdP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bdP.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bdP.setCurrentItem(1, false);
            } else {
                this.bdP.setCurrentItem(currentItem + 1);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null && sVar.sj() != null) {
            this.bdS = sVar;
            this.bdR = new a(sVar.sj());
            this.bdQ.setDatas(this.bdR.wx());
            this.bdP.setAdapter(this.bdQ);
            this.bdP.setCurrentItem(this.bdR.ww(), false);
            if (this.bdR.wv() >= 2) {
                this.agf.setVisibility(0);
                if (this.agf.getCount() != this.bdR.wv()) {
                    this.agf.setCount(this.bdR.wv());
                }
                wp();
                this.bdP.setAllowParentIntercept(false);
                return;
            }
            this.agf.setVisibility(8);
            wq();
            this.bdP.setAllowParentIntercept(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10178").ab(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", this.bdR.db(this.bdP.getCurrentItem()) + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<PhotoLiveCardData> agt;
        private List<PhotoLiveCardData> agu;
        private final boolean agv;

        public a(List<PhotoLiveCardData> list) {
            this.agt = list;
            if (list != null && list.size() > 1) {
                this.agv = true;
            } else {
                this.agv = false;
            }
            this.agu = af(this.agt);
        }

        private List<PhotoLiveCardData> af(List<PhotoLiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.agv && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int gi(int i) {
            if (this.agv) {
                int size = this.agu.size();
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
        public int db(int i) {
            if (this.agv) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int wv() {
            if (this.agt == null) {
                return 0;
            }
            return this.agt.size();
        }

        public int ww() {
            return this.agv ? 1 : 0;
        }

        public List<PhotoLiveCardData> wx() {
            return this.agu;
        }
    }
}
