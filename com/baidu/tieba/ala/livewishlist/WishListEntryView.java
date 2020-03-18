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
    private ScrollTextView fpk;
    private LinearLayout fpl;
    private TextView fpm;
    private TextView fpn;
    private TbImageView fpo;
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
        this.fpk = (ScrollTextView) this.mView.findViewById(a.g.scroll_text_view);
        this.fpl = (LinearLayout) this.mView.findViewById(a.g.one_wish_layout);
        this.fpm = (TextView) this.mView.findViewById(a.g.wish_text);
        this.fpn = (TextView) this.mView.findViewById(a.g.wish_count_tv);
        this.fpo = (TbImageView) this.mView.findViewById(a.g.wish_image_view);
    }

    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fpk.btL();
            this.fpk.ab(null);
            this.fpk.setVisibility(8);
            this.fpl.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fpk.btL();
            this.fpk.ab(null);
            this.fpk.setVisibility(8);
            this.fpl.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fpl.setVisibility(8);
            this.fpk.setVisibility(0);
            this.fpk.btM();
            this.fpk.ab(arrayList);
        }
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            this.fpk.btL();
            this.fpk.ab(null);
            this.fpk.setVisibility(8);
            this.fpl.setVisibility(8);
        } else if (arrayList != null && arrayList.size() == 1) {
            this.fpk.btL();
            this.fpk.ab(null);
            this.fpk.setVisibility(8);
            this.fpl.setVisibility(0);
            setOneWishData(arrayList.get(0));
        } else {
            this.fpl.setVisibility(8);
            this.fpk.setVisibility(0);
            this.fpk.btM();
            this.fpk.ab(arrayList);
        }
    }

    private void setOneWishData(AlaLiveWishListData alaLiveWishListData) {
        if (alaLiveWishListData != null) {
            this.fpm.setText(alaLiveWishListData.gift_name);
            this.fpo.setDefaultBgResource(a.f.icon_live_gift_default);
            this.fpo.setDefaultErrorResource(a.f.icon_live_gift_default);
            this.fpo.setAutoChangeStyle(false);
            this.fpo.startLoad(alaLiveWishListData.gift_url, 10, false);
            this.fpn.setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
        }
    }

    public void setOnScrollTextViewChangeListener(ScrollTextView.c cVar) {
        if (this.fpk != null) {
            this.fpk.setOnScrollTextViewChangeListener(cVar);
        }
    }

    public View getView() {
        return this.mView;
    }
}
