package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.live.challenge.e;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a implements e {
    private TextView fCb;
    private boolean fCc;
    private Context mContext;
    private int mCount = 0;
    private PopupWindow mPopupWindow;
    private View mRootView;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_bubble_view_layout, (ViewGroup) null);
        this.fCb = (TextView) this.mRootView.findViewById(a.g.ala_challenger_count);
    }

    @Override // com.baidu.live.challenge.e
    public void J(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (this.mPopupWindow == null) {
                this.mPopupWindow = new PopupWindow(this.mRootView, -2, -2);
                this.mPopupWindow.setFocusable(false);
                this.mPopupWindow.setTouchable(true);
            }
            if (!this.mPopupWindow.isShowing() && this.mCount > 0) {
                this.mRootView.measure(0, 0);
                this.mPopupWindow.showAsDropDown(view, (-(this.mRootView.getMeasuredWidth() - view.getMeasuredWidth())) / 2, -(this.mRootView.getMeasuredHeight() + view.getMeasuredHeight() + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4)));
                this.fCc = true;
            }
            if (this.mCount > 0) {
                this.fCb.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(this.mCount)));
            }
        }
    }

    @Override // com.baidu.live.challenge.e
    public boolean uj() {
        return this.fCc;
    }

    @Override // com.baidu.live.challenge.e
    public void setClickListener(View.OnClickListener onClickListener) {
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.live.challenge.e
    public void aQ(boolean z) {
        this.fCc = z;
    }

    @Override // com.baidu.live.challenge.e
    public void bw(int i) {
        this.mCount = i;
        if (i <= 0) {
            if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
                this.mPopupWindow.dismiss();
                return;
            }
            return;
        }
        this.fCb.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
    }

    @Override // com.baidu.live.challenge.e
    public boolean isShowing() {
        return this.mPopupWindow != null && this.mPopupWindow.isShowing();
    }

    @Override // com.baidu.live.challenge.e
    public void hide() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }
}
