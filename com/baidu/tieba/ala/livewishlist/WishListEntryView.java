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
/* loaded from: classes10.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView hOr;
    private LinearLayout hOs;
    private TextView hOt;
    private TextView hOu;
    private TbImageView hOv;
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
        this.hOr = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hOs = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hOt = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hOu = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hOv = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ac(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hOr.cpp();
            this.hOr.ai(null);
            this.hOr.setVisibility(8);
            this.hOs.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hOr.cpp();
            this.hOr.ai(null);
            this.hOr.setVisibility(8);
            this.hOs.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hOs.setVisibility(8);
            this.hOr.setVisibility(0);
            this.hOr.cpq();
            this.hOr.ai(arrayList);
        }
    }

    public void ad(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hOr.cpp();
            this.hOr.ai(null);
            this.hOr.setVisibility(8);
            this.hOs.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hOr.cpp();
            this.hOr.ai(null);
            this.hOr.setVisibility(8);
            this.hOs.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hOs.setVisibility(8);
            this.hOr.setVisibility(0);
            this.hOr.cpq();
            this.hOr.ai(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hOt.setText(alaLiveWishListData.gift_name);
            this.hOv.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hOv.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hOv.setAutoChangeStyle(false);
            this.hOv.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hOu.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hOr != null) {
            this.hOr.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
