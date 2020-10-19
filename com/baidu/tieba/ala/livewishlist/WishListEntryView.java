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
    private ScrollTextView hfN;
    private LinearLayout hfO;
    private TextView hfP;
    private TextView hfQ;
    private TbImageView hfR;
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
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.live_scroll_wish_list_widget_entry, (ViewGroup) this, true);
        this.hfN = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.hfO = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.hfP = (TextView) this.mView.findViewById(a.g.wish_text);
        this.hfQ = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.hfR = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void af(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hfN.cgX();
            this.hfN.al(null);
            this.hfN.setVisibility(8);
            this.hfO.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hfN.cgX();
            this.hfN.al(null);
            this.hfN.setVisibility(8);
            this.hfO.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hfO.setVisibility(8);
            this.hfN.setVisibility(0);
            this.hfN.cgY();
            this.hfN.al(arrayList);
        }
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hfN.cgX();
            this.hfN.al(null);
            this.hfN.setVisibility(8);
            this.hfO.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hfN.cgX();
            this.hfN.al(null);
            this.hfN.setVisibility(8);
            this.hfO.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hfO.setVisibility(8);
            this.hfN.setVisibility(0);
            this.hfN.cgY();
            this.hfN.al(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hfP.setText(alaLiveWishListData.gift_name);
            this.hfR.setDefaultBgResource(a.f.icon_live_gift_default);
            this.hfR.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.hfR.setAutoChangeStyle(false);
            this.hfR.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hfQ.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hfN != null) {
            this.hfN.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
