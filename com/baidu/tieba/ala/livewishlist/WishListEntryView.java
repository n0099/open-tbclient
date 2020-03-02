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
    private TextView foB;
    private TbImageView foC;
    private ScrollTextView foy;
    private LinearLayout foz;
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
        this.foy = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.foz = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.foA = (TextView) this.mView.findViewById(a.g.wish_text);
        this.foB = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.foC = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.foy.btF();
            this.foy.ab(null);
            this.foy.setVisibility(8);
            this.foz.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.foy.btF();
            this.foy.ab(null);
            this.foy.setVisibility(8);
            this.foz.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foz.setVisibility(8);
            this.foy.setVisibility(0);
            this.foy.btG();
            this.foy.ab(arrayList);
        }
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.foy.btF();
            this.foy.ab(null);
            this.foy.setVisibility(8);
            this.foz.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.foy.btF();
            this.foy.ab(null);
            this.foy.setVisibility(8);
            this.foz.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.foz.setVisibility(8);
            this.foy.setVisibility(0);
            this.foy.btG();
            this.foy.ab(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.foA.setText(alaLiveWishListData.gift_name);
            this.foC.setDefaultBgResource(a.f.icon_live_gift_default);
            this.foC.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.foC.setAutoChangeStyle(false);
            this.foC.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.foB.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.foy != null) {
            this.foy.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
