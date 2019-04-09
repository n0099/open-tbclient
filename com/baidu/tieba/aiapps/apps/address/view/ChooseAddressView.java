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
    private com.baidu.tieba.aiapps.apps.address.a.a cSA;
    private View cSB;
    private TextView cSC;
    private CommonEmptyView cSD;
    private View cSE;
    private a.b cSF;
    private RecyclerView cSz;

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
        this.cSz = (RecyclerView) findViewById(d.g.delivery_list);
        this.cSB = findViewById(d.g.delivery_add);
        this.cSE = findViewById(d.g.delivery_add_line);
        this.cSD = (CommonEmptyView) findViewById(d.g.delivery_empty);
        this.cSC = (TextView) findViewById(d.g.delivery_add_txt);
        a(PageState.Normal);
        fR(com.baidu.swan.apps.u.a.CR().Dq());
        this.cSA = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.cSz.setLayoutManager(new LinearLayoutManager(context));
        this.cSz.addItemDecoration(new a(0, x.dip2px(context, 7.0f)));
        this.cSz.setAdapter(this.cSA);
        this.cSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.cSF != null) {
                    ChooseAddressView.this.cSF.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void fR(boolean z) {
        if (z) {
            this.cSz.setBackgroundColor(Color.parseColor("#161616"));
            this.cSE.setBackgroundColor(Color.parseColor("#303030"));
            this.cSB.setBackgroundColor(Color.parseColor("#191919"));
            this.cSC.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.cSC.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.cSD.setTitle(getResources().getString(d.j.delivery_empty_title));
        this.cSD.setIcon(getResources().getDrawable(d.f.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.cSD.setTitle(getResources().getString(d.j.net_error));
        this.cSD.setIcon(getResources().getDrawable(d.f.aiapps_empty_icon_network));
        this.cSD.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.cSD.setVisibility(z ? 8 : 0);
        this.cSz.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.cSA;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.cSF = bVar;
        this.cSA.setDeliveryChooseListener(this.cSF);
    }

    public void aC(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cSA.ay(list);
            a(PageState.Normal);
            GP();
            return;
        }
        showEmptyView();
    }

    public void GP() {
        this.cSA.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int cSH;
        private int cSI;

        public a(int i, int i2) {
            this.cSH = i;
            this.cSI = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.cSI;
            rect.left = this.cSH;
            rect.right = this.cSH;
        }
    }
}
