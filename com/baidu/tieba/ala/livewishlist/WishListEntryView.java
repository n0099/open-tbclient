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
/* loaded from: classes7.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView gNA;
    private LinearLayout gNB;
    private TextView gNC;
    private TextView gND;
    private TbImageView gNE;
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
        this.gNA = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.gNB = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.gNC = (TextView) this.mView.findViewById(a.g.wish_text);
        this.gND = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.gNE = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void af(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gNA.car();
            this.gNA.aj(null);
            this.gNA.setVisibility(8);
            this.gNB.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gNA.car();
            this.gNA.aj(null);
            this.gNA.setVisibility(8);
            this.gNB.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gNB.setVisibility(8);
            this.gNA.setVisibility(0);
            this.gNA.cas();
            this.gNA.aj(arrayList);
        }
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gNA.car();
            this.gNA.aj(null);
            this.gNA.setVisibility(8);
            this.gNB.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gNA.car();
            this.gNA.aj(null);
            this.gNA.setVisibility(8);
            this.gNB.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gNB.setVisibility(8);
            this.gNA.setVisibility(0);
            this.gNA.cas();
            this.gNA.aj(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.gNC.setText(alaLiveWishListData.gift_name);
            this.gNE.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gNE.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gNE.setAutoChangeStyle(false);
            this.gNE.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.gND.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.gNA != null) {
            this.gNA.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
