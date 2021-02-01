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
/* loaded from: classes11.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView hSN;
    private LinearLayout hSO;
    private TextView hSP;
    private TextView hSQ;
    private TbImageView hSR;
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
        this.hSN = (ScrollTextView) this.mView.findViewById(a.f.scroll_text_view);
        this.hSO = (LinearLayout) this.mView.findViewById(a.f.one_wish_layout);
        this.hSP = (TextView) this.mView.findViewById(a.f.wish_text);
        this.hSQ = (TextView) this.mView.findViewById(a.f.wish_count_tv);
        this.hSR = (TbImageView) this.mView.findViewById(a.f.wish_image_view);
    }

    public void ab(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hSN.cqz();
            this.hSN.ah(null);
            this.hSN.setVisibility(8);
            this.hSO.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hSN.cqz();
            this.hSN.ah(null);
            this.hSN.setVisibility(8);
            this.hSO.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hSO.setVisibility(8);
            this.hSN.setVisibility(0);
            this.hSN.cqA();
            this.hSN.ah(arrayList);
        }
    }

    public void ac(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.hSN.cqz();
            this.hSN.ah(null);
            this.hSN.setVisibility(8);
            this.hSO.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.hSN.cqz();
            this.hSN.ah(null);
            this.hSN.setVisibility(8);
            this.hSO.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.hSO.setVisibility(8);
            this.hSN.setVisibility(0);
            this.hSN.cqA();
            this.hSN.ah(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.hSP.setText(alaLiveWishListData.gift_name);
            this.hSR.setDefaultBgResource(a.e.icon_live_gift_default);
            this.hSR.setDefaultErrorResource(a.e.icon_live_gift_default);
            this.hSR.setAutoChangeStyle(false);
            this.hSR.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.hSQ.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.hSN != null) {
            this.hSN.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
