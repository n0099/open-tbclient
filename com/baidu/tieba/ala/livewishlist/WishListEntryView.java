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
    private ScrollTextView hGX;
    private LinearLayout hGY;
    private TextView hGZ;
    private TextView hHa;
    private TbImageView hHb;
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
        this.hGX = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hGY = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hGZ = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hHa = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hHb = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hGX.cqn();
            this.hGX.an(null);
            this.hGX.setVisibility(8);
            this.hGY.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hGX.cqn();
            this.hGX.an(null);
            this.hGX.setVisibility(8);
            this.hGY.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hGY.setVisibility(8);
            this.hGX.setVisibility(0);
            this.hGX.cqo();
            this.hGX.an(arrayList);
        }
    }

    public void ai(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hGX.cqn();
            this.hGX.an(null);
            this.hGX.setVisibility(8);
            this.hGY.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hGX.cqn();
            this.hGX.an(null);
            this.hGX.setVisibility(8);
            this.hGY.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hGY.setVisibility(8);
            this.hGX.setVisibility(0);
            this.hGX.cqo();
            this.hGX.an(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hGZ.setText(alaLiveWishListData.gift_name);
            this.hHb.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hHb.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hHb.setAutoChangeStyle(false);
            this.hHb.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hHa.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hGX != null) {
            this.hGX.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
