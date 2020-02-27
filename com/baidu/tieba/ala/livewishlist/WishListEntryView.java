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
    private TextView foA;
    private TbImageView foB;
    private ScrollTextView fox;
    private LinearLayout foy;
    private TextView foz;
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
        this.fox = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.foy = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.foz = (TextView) this.mView.findViewById(a.g.wish_text);
        this.foA = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.foB = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fox.btD();
            this.fox.ab(null);
            this.fox.setVisibility(8);
            this.foy.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fox.btD();
            this.fox.ab(null);
            this.fox.setVisibility(8);
            this.foy.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foy.setVisibility(8);
            this.fox.setVisibility(0);
            this.fox.btE();
            this.fox.ab(arrayList);
        }
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fox.btD();
            this.fox.ab(null);
            this.fox.setVisibility(8);
            this.foy.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fox.btD();
            this.fox.ab(null);
            this.fox.setVisibility(8);
            this.foy.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foy.setVisibility(8);
            this.fox.setVisibility(0);
            this.fox.btE();
            this.fox.ab(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.foz.setText(alaLiveWishListData.gift_name);
            this.foB.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foB.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foB.setAutoChangeStyle(false);
            this.foB.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.foA.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.fox != null) {
            this.fox.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
