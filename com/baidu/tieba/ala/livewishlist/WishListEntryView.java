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
    private ScrollTextView gAZ;
    private LinearLayout gBa;
    private TextView gBb;
    private TextView gBc;
    private TbImageView gBd;
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
        this.gAZ = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.gBa = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.gBb = (TextView) this.mView.findViewById(a.g.wish_text);
        this.gBc = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.gBd = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gAZ.bQf();
            this.gAZ.ad(null);
            this.gAZ.setVisibility(8);
            this.gBa.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gAZ.bQf();
            this.gAZ.ad(null);
            this.gAZ.setVisibility(8);
            this.gBa.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gBa.setVisibility(8);
            this.gAZ.setVisibility(0);
            this.gAZ.bQg();
            this.gAZ.ad(arrayList);
        }
    }

    public void aa(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gAZ.bQf();
            this.gAZ.ad(null);
            this.gAZ.setVisibility(8);
            this.gBa.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gAZ.bQf();
            this.gAZ.ad(null);
            this.gAZ.setVisibility(8);
            this.gBa.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gBa.setVisibility(8);
            this.gAZ.setVisibility(0);
            this.gAZ.bQg();
            this.gAZ.ad(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.gBb.setText(alaLiveWishListData.gift_name);
            this.gBd.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gBd.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gBd.setAutoChangeStyle(false);
            this.gBd.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.gBc.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.gAZ != null) {
            this.gAZ.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
