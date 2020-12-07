package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.widget.ScrollTextView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView hGV;
    private LinearLayout hGW;
    private TextView hGX;
    private TextView hGY;
    private TbImageView hGZ;
    private Context mContext;
    private View mView;

    public WishListEntryView(Context context) {
        this(context, null);
    }

    public WishListEntryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WishListEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI(context);
    }

    private void initUI(Context context) {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.live_scroll_wish_list_widget_entry, (ViewGroup) this, true);
        this.hGV = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hGW = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hGX = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hGY = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hGZ = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hGV.cqm();
            this.hGV.an(null);
            this.hGV.setVisibility(8);
            this.hGW.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hGV.cqm();
            this.hGV.an(null);
            this.hGV.setVisibility(8);
            this.hGW.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hGW.setVisibility(8);
            this.hGV.setVisibility(0);
            this.hGV.cqn();
            this.hGV.an(arrayList);
        }
    }

    public void ai(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hGV.cqm();
            this.hGV.an(null);
            this.hGV.setVisibility(8);
            this.hGW.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hGV.cqm();
            this.hGV.an(null);
            this.hGV.setVisibility(8);
            this.hGW.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hGW.setVisibility(8);
            this.hGV.setVisibility(0);
            this.hGV.cqn();
            this.hGV.an(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hGX.setText(alaLiveWishListData.gift_name);
            this.hGZ.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hGZ.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hGZ.setAutoChangeStyle(false);
            this.hGZ.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hGY.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hGV != null) {
            this.hGV.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
