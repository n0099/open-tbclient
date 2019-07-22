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
    private View dcA;
    private a.b dcB;
    private RecyclerView dcv;
    private com.baidu.tieba.aiapps.apps.address.a.a dcw;
    private View dcx;
    private TextView dcy;
    private CommonEmptyView dcz;

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
        this.dcv = (RecyclerView) findViewById(R.id.delivery_list);
        this.dcx = findViewById(R.id.delivery_add);
        this.dcA = findViewById(R.id.delivery_add_line);
        this.dcz = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.dcy = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        gs(com.baidu.swan.apps.u.a.EF().Fe());
        this.dcw = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.dcv.setLayoutManager(new LinearLayoutManager(context));
        this.dcv.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.dcv.setAdapter(this.dcw);
        this.dcx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dcB != null) {
                    ChooseAddressView.this.dcB.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void gs(boolean z) {
        if (z) {
            this.dcv.setBackgroundColor(Color.parseColor("#161616"));
            this.dcA.setBackgroundColor(Color.parseColor("#303030"));
            this.dcx.setBackgroundColor(Color.parseColor("#191919"));
            this.dcy.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.dcy.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.dcz.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.dcz.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.dcz.setTitle(getResources().getString(R.string.net_error));
        this.dcz.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.dcz.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.dcz.setVisibility(z ? 8 : 0);
        this.dcv.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.dcw;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dcB = bVar;
        this.dcw.setDeliveryChooseListener(this.dcB);
    }

    public void aJ(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dcw.aF(list);
            a(PageState.Normal);
            JS();
            return;
        }
        showEmptyView();
    }

    public void JS() {
        this.dcw.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dcD;
        private int dcE;

        public a(int i, int i2) {
            this.dcD = i;
            this.dcE = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dcE;
            rect.left = this.dcD;
            rect.right = this.dcD;
        }
    }
}
