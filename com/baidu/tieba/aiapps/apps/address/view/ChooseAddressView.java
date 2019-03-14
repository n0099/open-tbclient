package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private CommonEmptyView cSA;
    private View cSB;
    private a.b cSC;
    private RecyclerView cSw;
    private com.baidu.tieba.aiapps.apps.address.a.a cSx;
    private View cSy;
    private TextView cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum PageState {
        Normal,
        EMPTY_DATA,
        NET_ERROR
    }

    public ChooseAddressView(Context context) {
        super(context);
        init(context);
    }

    public ChooseAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.delivery_choose_layout, this);
        this.cSw = (RecyclerView) findViewById(d.g.delivery_list);
        this.cSy = findViewById(d.g.delivery_add);
        this.cSB = findViewById(d.g.delivery_add_line);
        this.cSA = (CommonEmptyView) findViewById(d.g.delivery_empty);
        this.cSz = (TextView) findViewById(d.g.delivery_add_txt);
        a(PageState.Normal);
        fR(com.baidu.swan.apps.u.a.CT().Ds());
        this.cSx = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.cSw.setLayoutManager(new LinearLayoutManager(context));
        this.cSw.addItemDecoration(new a(0, x.dip2px(context, 7.0f)));
        this.cSw.setAdapter(this.cSx);
        this.cSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.cSC != null) {
                    ChooseAddressView.this.cSC.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void fR(boolean z) {
        if (z) {
            this.cSw.setBackgroundColor(Color.parseColor("#161616"));
            this.cSB.setBackgroundColor(Color.parseColor("#303030"));
            this.cSy.setBackgroundColor(Color.parseColor("#191919"));
            this.cSz.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.cSz.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.cSA.setTitle(getResources().getString(d.j.delivery_empty_title));
        this.cSA.setIcon(getResources().getDrawable(d.f.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.cSA.setTitle(getResources().getString(d.j.net_error));
        this.cSA.setIcon(getResources().getDrawable(d.f.aiapps_empty_icon_network));
        this.cSA.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.cSA.setVisibility(z ? 8 : 0);
        this.cSw.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.cSx;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.cSC = bVar;
        this.cSx.setDeliveryChooseListener(this.cSC);
    }

    public void aC(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cSx.ay(list);
            a(PageState.Normal);
            GR();
            return;
        }
        showEmptyView();
    }

    public void GR() {
        this.cSx.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int cSE;
        private int cSF;

        public a(int i, int i2) {
            this.cSE = i;
            this.cSF = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.cSF;
            rect.left = this.cSE;
            rect.right = this.cSE;
        }
    }
}
