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
    private ScrollTextView foL;
    private LinearLayout foM;
    private TextView foN;
    private TextView foO;
    private TbImageView foP;
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
        this.foL = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.foM = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.foN = (TextView) this.mView.findViewById(a.g.wish_text);
        this.foO = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.foP = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.foL.btG();
            this.foL.ab(null);
            this.foL.setVisibility(8);
            this.foM.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.foL.btG();
            this.foL.ab(null);
            this.foL.setVisibility(8);
            this.foM.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foM.setVisibility(8);
            this.foL.setVisibility(0);
            this.foL.btH();
            this.foL.ab(arrayList);
        }
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.foL.btG();
            this.foL.ab(null);
            this.foL.setVisibility(8);
            this.foM.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.foL.btG();
            this.foL.ab(null);
            this.foL.setVisibility(8);
            this.foM.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foM.setVisibility(8);
            this.foL.setVisibility(0);
            this.foL.btH();
            this.foL.ab(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.foN.setText(alaLiveWishListData.gift_name);
            this.foP.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foP.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foP.setAutoChangeStyle(false);
            this.foP.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.foO.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.foL != null) {
            this.foL.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
