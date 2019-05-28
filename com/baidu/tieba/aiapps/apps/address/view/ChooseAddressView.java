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
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.address.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private RecyclerView daV;
    private com.baidu.tieba.aiapps.apps.address.a.a daW;
    private View daX;
    private TextView daY;
    private CommonEmptyView daZ;
    private View dba;
    private a.b dbb;

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
        LayoutInflater.from(context).inflate(R.layout.delivery_choose_layout, this);
        this.daV = (RecyclerView) findViewById(R.id.delivery_list);
        this.daX = findViewById(R.id.delivery_add);
        this.dba = findViewById(R.id.delivery_add_line);
        this.daZ = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.daY = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        go(com.baidu.swan.apps.u.a.DW().Ev());
        this.daW = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.daV.setLayoutManager(new LinearLayoutManager(context));
        this.daV.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.daV.setAdapter(this.daW);
        this.daX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dbb != null) {
                    ChooseAddressView.this.dbb.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void go(boolean z) {
        if (z) {
            this.daV.setBackgroundColor(Color.parseColor("#161616"));
            this.dba.setBackgroundColor(Color.parseColor("#303030"));
            this.daX.setBackgroundColor(Color.parseColor("#191919"));
            this.daY.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.daY.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.daZ.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.daZ.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.daZ.setTitle(getResources().getString(R.string.net_error));
        this.daZ.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.daZ.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.daZ.setVisibility(z ? 8 : 0);
        this.daV.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.daW;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dbb = bVar;
        this.daW.setDeliveryChooseListener(this.dbb);
    }

    public void aJ(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.daW.aF(list);
            a(PageState.Normal);
            Jf();
            return;
        }
        showEmptyView();
    }

    public void Jf() {
        this.daW.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dbd;
        private int dbe;

        public a(int i, int i2) {
            this.dbd = i;
            this.dbe = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dbe;
            rect.left = this.dbd;
            rect.right = this.dbd;
        }
    }
}
