package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes11.dex */
public class AlaAirDropView extends RelativeLayout {
    private CommonWebLayout bVC;
    public RelativeLayout mContainer;
    private View mView;

    public AlaAirDropView(Context context) {
        super(context);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bVC;
    }

    public View getView() {
        return this.mView;
    }

    private void init() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.ala_air_drop_view, (ViewGroup) this, true);
        this.mContainer = (RelativeLayout) this.mView.findViewById(a.f.layout_container);
        x(this.mContainer);
    }

    private void x(ViewGroup viewGroup) {
        this.bVC = new CommonWebLayout(getContext());
        viewGroup.addView(this.bVC, -1, -1);
        this.bVC.setLayoutParams((RelativeLayout.LayoutParams) this.bVC.getLayoutParams());
    }

    public boolean isShowing() {
        return this.bVC.getVisibility() == 0;
    }
}
