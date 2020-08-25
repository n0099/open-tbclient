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
    private TbImageView gNA;
    private ScrollTextView gNw;
    private LinearLayout gNx;
    private TextView gNy;
    private TextView gNz;
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
        this.gNw = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.gNx = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.gNy = (TextView) this.mView.findViewById(a.g.wish_text);
        this.gNz = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.gNA = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void af(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gNw.caq();
            this.gNw.aj(null);
            this.gNw.setVisibility(8);
            this.gNx.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gNw.caq();
            this.gNw.aj(null);
            this.gNw.setVisibility(8);
            this.gNx.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gNx.setVisibility(8);
            this.gNw.setVisibility(0);
            this.gNw.car();
            this.gNw.aj(arrayList);
        }
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gNw.caq();
            this.gNw.aj(null);
            this.gNw.setVisibility(8);
            this.gNx.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gNw.caq();
            this.gNw.aj(null);
            this.gNw.setVisibility(8);
            this.gNx.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gNx.setVisibility(8);
            this.gNw.setVisibility(0);
            this.gNw.car();
            this.gNw.aj(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.gNy.setText(alaLiveWishListData.gift_name);
            this.gNA.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gNA.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gNA.setAutoChangeStyle(false);
            this.gNA.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.gNz.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.gNw != null) {
            this.gNw.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
