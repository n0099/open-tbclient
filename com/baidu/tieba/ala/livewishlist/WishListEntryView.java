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
    private ScrollTextView hrM;
    private LinearLayout hrN;
    private TextView hrO;
    private TextView hrP;
    private TbImageView hrQ;
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
        this.hrM = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.hrN = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.hrO = (TextView) this.mView.findViewById(a.g.wish_text);
        this.hrP = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.hrQ = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hrM.cke();
            this.hrM.am(null);
            this.hrM.setVisibility(8);
            this.hrN.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hrM.cke();
            this.hrM.am(null);
            this.hrM.setVisibility(8);
            this.hrN.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hrN.setVisibility(8);
            this.hrM.setVisibility(0);
            this.hrM.ckf();
            this.hrM.am(arrayList);
        }
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hrM.cke();
            this.hrM.am(null);
            this.hrM.setVisibility(8);
            this.hrN.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hrM.cke();
            this.hrM.am(null);
            this.hrM.setVisibility(8);
            this.hrN.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hrN.setVisibility(8);
            this.hrM.setVisibility(0);
            this.hrM.ckf();
            this.hrM.am(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hrO.setText(alaLiveWishListData.gift_name);
            this.hrQ.setDefaultBgResource(a.f.icon_live_gift_default);
            this.hrQ.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.hrQ.setAutoChangeStyle(false);
            this.hrQ.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hrP.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hrM != null) {
            this.hrM.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
