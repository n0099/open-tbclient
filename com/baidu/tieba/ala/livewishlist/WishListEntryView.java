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
/* loaded from: classes3.dex */
public class WishListEntryView extends RelativeLayout {
    private ScrollTextView gvC;
    private LinearLayout gvD;
    private TextView gvE;
    private TextView gvF;
    private TbImageView gvG;
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
        this.gvC = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.gvD = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.gvE = (TextView) this.mView.findViewById(a.g.wish_text);
        this.gvF = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.gvG = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gvC.bMU();
            this.gvC.ac(null);
            this.gvC.setVisibility(8);
            this.gvD.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gvC.bMU();
            this.gvC.ac(null);
            this.gvC.setVisibility(8);
            this.gvD.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gvD.setVisibility(8);
            this.gvC.setVisibility(0);
            this.gvC.bMV();
            this.gvC.ac(arrayList);
        }
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.gvC.bMU();
            this.gvC.ac(null);
            this.gvC.setVisibility(8);
            this.gvD.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.gvC.bMU();
            this.gvC.ac(null);
            this.gvC.setVisibility(8);
            this.gvD.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.gvD.setVisibility(8);
            this.gvC.setVisibility(0);
            this.gvC.bMV();
            this.gvC.ac(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.gvE.setText(alaLiveWishListData.gift_name);
            this.gvG.setDefaultBgResource(a.f.icon_live_gift_default);
            this.gvG.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.gvG.setAutoChangeStyle(false);
            this.gvG.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.gvF.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.gvC != null) {
            this.gvC.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
