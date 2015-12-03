package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ex extends PagerAdapter {
    private PhotoLiveCardView.b amM;
    private Context mContext;
    private List<PhotoLiveCardView> bfq = new ArrayList();
    private List<PhotoLiveCardData> mDatas = new ArrayList();

    public ex(Context context) {
        this.mContext = context;
        if (this.bfq.size() < 4) {
            int size = 4 - this.bfq.size();
            for (int i = 0; i < size; i++) {
                this.bfq.add(Oi());
            }
        }
    }

    public void setDatas(List<PhotoLiveCardData> list) {
        if (list != null && list.size() != 0) {
            this.mDatas.clear();
            this.mDatas.addAll(list);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mDatas.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mDatas.size()) {
            return null;
        }
        View cY = cY(i);
        if (cY != null) {
            viewGroup.addView(cY);
            return cY;
        }
        return cY;
    }

    public View cY(int i) {
        PhotoLiveCardView photoLiveCardView = null;
        if (i < this.mDatas.size()) {
            int size = this.bfq.size();
            PhotoLiveCardView remove = size > 0 ? this.bfq.remove(size - 1) : null;
            photoLiveCardView = remove == null ? Oi() : remove;
            photoLiveCardView.setData(this.mDatas.get(i));
            if (this.amM != null) {
                photoLiveCardView.setPortraitClicklistener(this.amM);
            }
        }
        return photoLiveCardView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        PhotoLiveCardView photoLiveCardView = (PhotoLiveCardView) obj;
        viewGroup.removeView(photoLiveCardView);
        this.bfq.add(photoLiveCardView);
    }

    private PhotoLiveCardView Oi() {
        PhotoLiveCardView photoLiveCardView = (PhotoLiveCardView) LayoutInflater.from(this.mContext).inflate(n.g.frs_photo_live_view_pager_item, (ViewGroup) null);
        photoLiveCardView.setShowContent(false);
        photoLiveCardView.setShowBottom(true);
        photoLiveCardView.setHeadPaddingTop(n.d.ds24);
        photoLiveCardView.setShowLiveIcon(true);
        photoLiveCardView.setShowRefreshTimeInButtom(true);
        photoLiveCardView.setShowHeadLiveIcon(true);
        photoLiveCardView.setParentBackground(n.e.addresslist_item_bg);
        photoLiveCardView.setTitleMaxLines(1);
        return photoLiveCardView;
    }

    public void setPortraitClicklistener(PhotoLiveCardView.b bVar) {
        this.amM = bVar;
    }
}
