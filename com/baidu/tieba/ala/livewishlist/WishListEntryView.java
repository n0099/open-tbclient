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
    private ScrollTextView giE;
    private LinearLayout giF;
    private TextView giG;
    private TextView giH;
    private TbImageView giI;
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
        this.giE = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.giF = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.giG = (TextView) this.mView.findViewById(a.g.wish_text);
        this.giH = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.giI = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.giE.bJM();
            this.giE.ac(null);
            this.giE.setVisibility(8);
            this.giF.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.giE.bJM();
            this.giE.ac(null);
            this.giE.setVisibility(8);
            this.giF.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.giF.setVisibility(8);
            this.giE.setVisibility(0);
            this.giE.bJN();
            this.giE.ac(arrayList);
        }
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.giE.bJM();
            this.giE.ac(null);
            this.giE.setVisibility(8);
            this.giF.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.giE.bJM();
            this.giE.ac(null);
            this.giE.setVisibility(8);
            this.giF.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.giF.setVisibility(8);
            this.giE.setVisibility(0);
            this.giE.bJN();
            this.giE.ac(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.giG.setText(alaLiveWishListData.gift_name);
            this.giI.setDefaultBgResource(a.f.icon_live_gift_default);
            this.giI.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.giI.setAutoChangeStyle(false);
            this.giI.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.giH.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.giE != null) {
            this.giE.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
