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
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.aiapps.apps.address.c.b;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = c.DEBUG;
    private RecyclerView cSA;
    private com.baidu.tieba.aiapps.apps.address.a.a cSB;
    private View cSC;
    private TextView cSD;
    private CommonEmptyView cSE;
    private View cSF;
    private a.b cSG;

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
        this.cSA = (RecyclerView) findViewById(d.g.delivery_list);
        this.cSC = findViewById(d.g.delivery_add);
        this.cSF = findViewById(d.g.delivery_add_line);
        this.cSE = (CommonEmptyView) findViewById(d.g.delivery_empty);
        this.cSD = (TextView) findViewById(d.g.delivery_add_txt);
        a(PageState.Normal);
        fR(com.baidu.swan.apps.u.a.CT().Ds());
        this.cSB = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.cSA.setLayoutManager(new LinearLayoutManager(context));
        this.cSA.addItemDecoration(new a(0, x.dip2px(context, 7.0f)));
        this.cSA.setAdapter(this.cSB);
        this.cSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.cSG != null) {
                    ChooseAddressView.this.cSG.b(new b(), "add");
                }
            }
        });
    }

    public void fR(boolean z) {
        if (z) {
            this.cSA.setBackgroundColor(Color.parseColor("#161616"));
            this.cSF.setBackgroundColor(Color.parseColor("#303030"));
            this.cSC.setBackgroundColor(Color.parseColor("#191919"));
            this.cSD.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.cSD.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.cSE.setTitle(getResources().getString(d.j.delivery_empty_title));
        this.cSE.setIcon(getResources().getDrawable(d.f.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.cSE.setTitle(getResources().getString(d.j.net_error));
        this.cSE.setIcon(getResources().getDrawable(d.f.aiapps_empty_icon_network));
        this.cSE.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.cSE.setVisibility(z ? 8 : 0);
        this.cSA.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.cSB;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.cSG = bVar;
        this.cSB.setDeliveryChooseListener(this.cSG);
    }

    public void aC(List<b> list) {
        if (list != null && list.size() > 0) {
            this.cSB.ay(list);
            a(PageState.Normal);
            GR();
            return;
        }
        showEmptyView();
    }

    public void GR() {
        this.cSB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int cSI;
        private int cSJ;

        public a(int i, int i2) {
            this.cSI = i;
            this.cSJ = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.cSJ;
            rect.left = this.cSI;
            rect.right = this.cSI;
        }
    }
}
