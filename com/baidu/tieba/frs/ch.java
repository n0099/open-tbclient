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
public class ch implements PhotoLiveCardView.b {
    private ChildViewPager aYb;
    private dk aYc;
    private a aYd;
    private com.baidu.tbadk.core.data.p aYe;
    private IndicatorView aqZ;
    private Context mContext;
    private final Handler.Callback mCallback = new ci(this);
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new cj(this);
    private ChildViewPager.a aYf = new ck(this);

    public ch(ChildViewPager childViewPager, IndicatorView indicatorView) {
        this.aYb = childViewPager;
        this.aqZ = indicatorView;
        this.mContext = childViewPager.getContext();
        this.aYc = new dk(this.mContext);
        this.aYc.setPortraitClicklistener(this);
        this.aYb.setAdapter(this.aYc);
        this.aYb.setOnPageChangeListener(this.mOnPageChangeListener);
        this.aYb.setOnSingleTouchListener(this.aYf);
        this.aqZ.setSelector(com.baidu.tbadk.core.util.al.getDrawable(i.e.dot_live_s));
        this.aqZ.setDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.dot_live_n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mo() {
        int count;
        if (this.aYb != null && this.aYc != null && (count = this.aYc.getCount()) >= 2) {
            int currentItem = this.aYb.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aYb.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aYb.setCurrentItem(1, false);
            } else {
                this.aYb.setCurrentItem(currentItem + 1);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null && pVar.rS() != null) {
            this.aYe = pVar;
            this.aYd = new a(pVar.rS());
            this.aYc.setDatas(this.aYd.Mt());
            this.aYb.setAdapter(this.aYc);
            this.aYb.setCurrentItem(this.aYd.Ms(), false);
            if (this.aYd.Mr() >= 2) {
                this.aqZ.setVisibility(0);
                if (this.aqZ.getCount() != this.aYd.Mr()) {
                    this.aqZ.setCount(this.aYd.Mr());
                }
                Mp();
                return;
            }
            this.aqZ.setVisibility(8);
            Mq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10178").af(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", this.aYd.fz(this.aYb.getCurrentItem()) + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private List<PhotoLiveCardData> aYh;
        private List<PhotoLiveCardData> aYi;
        private final boolean aYj;

        public a(List<PhotoLiveCardData> list) {
            this.aYh = list;
            if (list != null && list.size() > 1) {
                this.aYj = true;
            } else {
                this.aYj = false;
            }
            this.aYi = W(this.aYh);
        }

        private List<PhotoLiveCardData> W(List<PhotoLiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.aYj && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fy(int i) {
            if (this.aYj) {
                int size = this.aYi.size();
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
        public int fz(int i) {
            if (this.aYj) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int Mr() {
            if (this.aYh == null) {
                return 0;
            }
            return this.aYh.size();
        }

        public int Ms() {
            return this.aYj ? 1 : 0;
        }

        public List<PhotoLiveCardData> Mt() {
            return this.aYi;
        }
    }
}
