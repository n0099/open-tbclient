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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.widget.ScrollTextView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView fiJ;
    private LinearLayout fiK;
    private TextView fiL;
    private TextView fiM;
    private TbImageView fiN;
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
        this.fiJ = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.fiK = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.fiL = (TextView) this.mView.findViewById(a.g.wish_text);
        this.fiM = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.fiN = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void W(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fiJ.bqX();
            this.fiJ.aa(null);
            this.fiJ.setVisibility(8);
            this.fiK.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fiJ.bqX();
            this.fiJ.aa(null);
            this.fiJ.setVisibility(8);
            this.fiK.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fiK.setVisibility(8);
            this.fiJ.setVisibility(0);
            this.fiJ.bqY();
            this.fiJ.aa(arrayList);
        }
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fiJ.bqX();
            this.fiJ.aa(null);
            this.fiJ.setVisibility(8);
            this.fiK.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fiJ.bqX();
            this.fiJ.aa(null);
            this.fiJ.setVisibility(8);
            this.fiK.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fiK.setVisibility(8);
            this.fiJ.setVisibility(0);
            this.fiJ.bqY();
            this.fiJ.aa(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.fiL.setText(alaLiveWishListData.gift_name);
            this.fiN.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fiN.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fiN.setAutoChangeStyle(false);
            this.fiN.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.fiM.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.fiJ != null) {
            this.fiJ.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
