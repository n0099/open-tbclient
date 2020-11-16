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
    private ScrollTextView hxq;
    private LinearLayout hxr;
    private TextView hxs;
    private TextView hxt;
    private TbImageView hxu;
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
        this.hxq = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hxr = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hxs = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hxt = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hxu = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hxq.clZ();
            this.hxq.am(null);
            this.hxq.setVisibility(8);
            this.hxr.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hxq.clZ();
            this.hxq.am(null);
            this.hxq.setVisibility(8);
            this.hxr.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hxr.setVisibility(8);
            this.hxq.setVisibility(0);
            this.hxq.cma();
            this.hxq.am(arrayList);
        }
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hxq.clZ();
            this.hxq.am(null);
            this.hxq.setVisibility(8);
            this.hxr.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hxq.clZ();
            this.hxq.am(null);
            this.hxq.setVisibility(8);
            this.hxr.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hxr.setVisibility(8);
            this.hxq.setVisibility(0);
            this.hxq.cma();
            this.hxq.am(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hxs.setText(alaLiveWishListData.gift_name);
            this.hxu.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hxu.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hxu.setAutoChangeStyle(false);
            this.hxu.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hxt.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hxq != null) {
            this.hxq.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
