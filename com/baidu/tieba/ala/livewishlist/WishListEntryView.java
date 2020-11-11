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
    private ScrollTextView hxJ;
    private LinearLayout hxK;
    private TextView hxL;
    private TextView hxM;
    private TbImageView hxN;
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
        this.hxJ = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hxK = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hxL = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hxM = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hxN = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hxJ.cmG();
            this.hxJ.am(null);
            this.hxJ.setVisibility(8);
            this.hxK.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hxJ.cmG();
            this.hxJ.am(null);
            this.hxJ.setVisibility(8);
            this.hxK.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hxK.setVisibility(8);
            this.hxJ.setVisibility(0);
            this.hxJ.cmH();
            this.hxJ.am(arrayList);
        }
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hxJ.cmG();
            this.hxJ.am(null);
            this.hxJ.setVisibility(8);
            this.hxK.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hxJ.cmG();
            this.hxJ.am(null);
            this.hxJ.setVisibility(8);
            this.hxK.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hxK.setVisibility(8);
            this.hxJ.setVisibility(0);
            this.hxJ.cmH();
            this.hxJ.am(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hxL.setText(alaLiveWishListData.gift_name);
            this.hxN.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hxN.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hxN.setAutoChangeStyle(false);
            this.hxN.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hxM.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hxJ != null) {
            this.hxJ.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
