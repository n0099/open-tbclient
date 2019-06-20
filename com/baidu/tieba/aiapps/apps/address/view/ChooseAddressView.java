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
    private RecyclerView daW;
    private com.baidu.tieba.aiapps.apps.address.a.a daX;
    private View daY;
    private TextView daZ;
    private CommonEmptyView dba;
    private View dbb;
    private a.b dbc;

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
        this.daW = (RecyclerView) findViewById(R.id.delivery_list);
        this.daY = findViewById(R.id.delivery_add);
        this.dbb = findViewById(R.id.delivery_add_line);
        this.dba = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.daZ = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        go(com.baidu.swan.apps.u.a.DW().Ev());
        this.daX = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.daW.setLayoutManager(new LinearLayoutManager(context));
        this.daW.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.daW.setAdapter(this.daX);
        this.daY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dbc != null) {
                    ChooseAddressView.this.dbc.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void go(boolean z) {
        if (z) {
            this.daW.setBackgroundColor(Color.parseColor("#161616"));
            this.dbb.setBackgroundColor(Color.parseColor("#303030"));
            this.daY.setBackgroundColor(Color.parseColor("#191919"));
            this.daZ.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.daZ.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.dba.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.dba.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.dba.setTitle(getResources().getString(R.string.net_error));
        this.dba.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.dba.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.dba.setVisibility(z ? 8 : 0);
        this.daW.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.daX;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dbc = bVar;
        this.daX.setDeliveryChooseListener(this.dbc);
    }

    public void aJ(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.daX.aF(list);
            a(PageState.Normal);
            Jf();
            return;
        }
        showEmptyView();
    }

    public void Jf() {
        this.daX.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dbe;
        private int dbf;

        public a(int i, int i2) {
            this.dbe = i;
            this.dbf = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dbf;
            rect.left = this.dbe;
            rect.right = this.dbe;
        }
    }
}
