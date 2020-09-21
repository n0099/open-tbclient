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
    private ScrollTextView gQQ;
    private LinearLayout gQR;
    private TextView gQS;
    private TextView gQT;
    private TbImageView gQU;
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
        this.gQQ = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.gQR = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.gQS = (TextView) this.mView.findViewById(a.g.wish_text);
        this.gQT = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.gQU = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void af(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gQQ.cdB();
            this.gQQ.al(null);
            this.gQQ.setVisibility(8);
            this.gQR.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gQQ.cdB();
            this.gQQ.al(null);
            this.gQQ.setVisibility(8);
            this.gQR.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gQR.setVisibility(8);
            this.gQQ.setVisibility(0);
            this.gQQ.cdC();
            this.gQQ.al(arrayList);
        }
    }

    public void ag(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gQQ.cdB();
            this.gQQ.al(null);
            this.gQQ.setVisibility(8);
            this.gQR.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gQQ.cdB();
            this.gQQ.al(null);
            this.gQQ.setVisibility(8);
            this.gQR.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gQR.setVisibility(8);
            this.gQQ.setVisibility(0);
            this.gQQ.cdC();
            this.gQQ.al(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.gQS.setText(alaLiveWishListData.gift_name);
            this.gQU.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gQU.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gQU.setAutoChangeStyle(false);
            this.gQU.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.gQT.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.gQQ != null) {
            this.gQQ.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
