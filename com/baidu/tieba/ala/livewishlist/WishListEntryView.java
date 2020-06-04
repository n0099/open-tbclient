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
    private ScrollTextView giP;
    private LinearLayout giQ;
    private TextView giR;
    private TextView giS;
    private TbImageView giT;
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
        this.giP = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.giQ = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.giR = (TextView) this.mView.findViewById(a.g.wish_text);
        this.giS = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.giT = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.giP.bJO();
            this.giP.ac(null);
            this.giP.setVisibility(8);
            this.giQ.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.giP.bJO();
            this.giP.ac(null);
            this.giP.setVisibility(8);
            this.giQ.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.giQ.setVisibility(8);
            this.giP.setVisibility(0);
            this.giP.bJP();
            this.giP.ac(arrayList);
        }
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.giP.bJO();
            this.giP.ac(null);
            this.giP.setVisibility(8);
            this.giQ.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.giP.bJO();
            this.giP.ac(null);
            this.giP.setVisibility(8);
            this.giQ.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.giQ.setVisibility(8);
            this.giP.setVisibility(0);
            this.giP.bJP();
            this.giP.ac(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.giR.setText(alaLiveWishListData.gift_name);
            this.giT.setDefaultBgResource(a.f.icon_live_gift_default);
            this.giT.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.giT.setAutoChangeStyle(false);
            this.giT.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.giS.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.giP != null) {
            this.giP.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
