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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.widget.ScrollTextView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView flU;
    private LinearLayout flV;
    private TextView flW;
    private TextView flX;
    private TbImageView flY;
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
        this.flU = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.flV = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.flW = (TextView) this.mView.findViewById(a.g.wish_text);
        this.flX = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.flY = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void W(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.flU.brZ();
            this.flU.aa(null);
            this.flU.setVisibility(8);
            this.flV.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.flU.brZ();
            this.flU.aa(null);
            this.flU.setVisibility(8);
            this.flV.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.flV.setVisibility(8);
            this.flU.setVisibility(0);
            this.flU.bsa();
            this.flU.aa(arrayList);
        }
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.flU.brZ();
            this.flU.aa(null);
            this.flU.setVisibility(8);
            this.flV.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.flU.brZ();
            this.flU.aa(null);
            this.flU.setVisibility(8);
            this.flV.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.flV.setVisibility(8);
            this.flU.setVisibility(0);
            this.flU.bsa();
            this.flU.aa(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.flW.setText(alaLiveWishListData.gift_name);
            this.flY.setDefaultBgResource(a.f.icon_live_gift_default);
            this.flY.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.flY.setAutoChangeStyle(false);
            this.flY.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.flX.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.flU != null) {
            this.flU.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
