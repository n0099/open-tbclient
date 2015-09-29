package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ed extends PagerAdapter {
    private PhotoLiveCardView.b akV;
    private Context mContext;
    private List<PhotoLiveCardView> aYO = new ArrayList();
    private List<PhotoLiveCardData> mDatas = new ArrayList();

    public ed(Context context) {
        this.mContext = context;
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
        View fJ = fJ(i);
        if (fJ != null) {
            viewGroup.addView(fJ);
            return fJ;
        }
        return fJ;
    }

    public View fJ(int i) {
        PhotoLiveCardView photoLiveCardView = null;
        if (i < this.mDatas.size()) {
            int size = this.aYO.size();
            PhotoLiveCardView remove = size > 0 ? this.aYO.remove(size - 1) : null;
            photoLiveCardView = remove == null ? Mx() : remove;
            photoLiveCardView.setData(this.mDatas.get(i));
            if (this.akV != null) {
                photoLiveCardView.setPortraitClicklistener(this.akV);
            }
        }
        return photoLiveCardView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        PhotoLiveCardView photoLiveCardView = (PhotoLiveCardView) obj;
        viewGroup.removeView(photoLiveCardView);
        this.aYO.add(photoLiveCardView);
    }

    private PhotoLiveCardView Mx() {
        PhotoLiveCardView photoLiveCardView = (PhotoLiveCardView) LayoutInflater.from(this.mContext).inflate(i.g.frs_photo_live_view_pager_item, (ViewGroup) null);
        photoLiveCardView.setShowContent(false);
        photoLiveCardView.setShowBottom(true);
        photoLiveCardView.setHeadPaddingTop(i.d.ds24);
        photoLiveCardView.setShowLiveIcon(true);
        photoLiveCardView.setShowRefreshTimeInButtom(true);
        photoLiveCardView.setShowHeadLiveIcon(true);
        photoLiveCardView.setParentBackground(i.e.addresslist_item_bg);
        photoLiveCardView.setTitleMaxLines(1);
        return photoLiveCardView;
    }

    public void setPortraitClicklistener(PhotoLiveCardView.b bVar) {
        this.akV = bVar;
    }
}
