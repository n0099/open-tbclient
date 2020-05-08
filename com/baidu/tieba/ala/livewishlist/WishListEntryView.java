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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.widget.ScrollTextView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView fTL;
    private LinearLayout fTM;
    private TextView fTN;
    private TextView fTO;
    private TbImageView fTP;
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
        this.fTL = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.fTM = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.fTN = (TextView) this.mView.findViewById(a.g.wish_text);
        this.fTO = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.fTP = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fTL.bDu();
            this.fTL.ac(null);
            this.fTL.setVisibility(8);
            this.fTM.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fTL.bDu();
            this.fTL.ac(null);
            this.fTL.setVisibility(8);
            this.fTM.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fTM.setVisibility(8);
            this.fTL.setVisibility(0);
            this.fTL.bDv();
            this.fTL.ac(arrayList);
        }
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fTL.bDu();
            this.fTL.ac(null);
            this.fTL.setVisibility(8);
            this.fTM.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fTL.bDu();
            this.fTL.ac(null);
            this.fTL.setVisibility(8);
            this.fTM.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fTM.setVisibility(8);
            this.fTL.setVisibility(0);
            this.fTL.bDv();
            this.fTL.ac(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.fTN.setText(alaLiveWishListData.gift_name);
            this.fTP.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fTP.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fTP.setAutoChangeStyle(false);
            this.fTP.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.fTO.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.fTL != null) {
            this.fTL.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
