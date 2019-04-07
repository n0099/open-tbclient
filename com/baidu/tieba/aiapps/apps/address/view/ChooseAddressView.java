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
    private View cSA;
    private TextView cSB;
    private CommonEmptyView cSC;
    private View cSD;
    private a.b cSE;
    private RecyclerView cSy;
    private com.baidu.tieba.aiapps.apps.address.a.a cSz;

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
        this.cSy = (RecyclerView) findViewById(d.g.delivery_list);
        this.cSA = findViewById(d.g.delivery_add);
        this.cSD = findViewById(d.g.delivery_add_line);
        this.cSC = (CommonEmptyView) findViewById(d.g.delivery_empty);
        this.cSB = (TextView) findViewById(d.g.delivery_add_txt);
        a(PageState.Normal);
        fR(com.baidu.swan.apps.u.a.CR().Dq());
        this.cSz = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.cSy.setLayoutManager(new LinearLayoutManager(context));
        this.cSy.addItemDecoration(new a(0, x.dip2px(context, 7.0f)));
        this.cSy.setAdapter(this.cSz);
        this.cSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.cSE != null) {
                    ChooseAddressView.this.cSE.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void fR(boolean z) {
        if (z) {
            this.cSy.setBackgroundColor(Color.parseColor("#161616"));
            this.cSD.setBackgroundColor(Color.parseColor("#303030"));
            this.cSA.setBackgroundColor(Color.parseColor("#191919"));
            this.cSB.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.cSB.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.cSC.setTitle(getResources().getString(d.j.delivery_empty_title));
        this.cSC.setIcon(getResources().getDrawable(d.f.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.cSC.setTitle(getResources().getString(d.j.net_error));
        this.cSC.setIcon(getResources().getDrawable(d.f.aiapps_empty_icon_network));
        this.cSC.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.cSC.setVisibility(z ? 8 : 0);
        this.cSy.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.cSz;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.cSE = bVar;
        this.cSz.setDeliveryChooseListener(this.cSE);
    }

    public void aC(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cSz.ay(list);
            a(PageState.Normal);
            GP();
            return;
        }
        showEmptyView();
    }

    public void GP() {
        this.cSz.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int cSG;
        private int cSH;

        public a(int i, int i2) {
            this.cSG = i;
            this.cSH = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.cSH;
            rect.left = this.cSG;
            rect.right = this.cSG;
        }
    }
}
