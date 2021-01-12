package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes10.dex */
public class AlaAirDropView extends RelativeLayout {
    private CommonWebLayout bue;
    public RelativeLayout mContainer;
    private View mView;

    public AlaAirDropView(Context context) {
        super(context);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bue;
    }

    public View getView() {
        return this.mView;
    }

    private void init() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.ala_air_drop_view, (ViewGroup) this, true);
        this.mContainer = (RelativeLayout) this.mView.findViewById(a.f.layout_container);
        q(this.mContainer);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(getContext());
        viewGroup.addView(this.bue, -1, -1);
        this.bue.setLayoutParams((RelativeLayout.LayoutParams) this.bue.getLayoutParams());
    }

    public boolean isShowing() {
        return this.bue.getVisibility() == 0;
    }
}
