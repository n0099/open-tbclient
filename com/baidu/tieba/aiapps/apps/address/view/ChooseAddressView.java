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
    private RecyclerView dcC;
    private com.baidu.tieba.aiapps.apps.address.a.a dcD;
    private View dcE;
    private TextView dcF;
    private CommonEmptyView dcG;
    private View dcH;
    private a.b dcI;

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
        this.dcC = (RecyclerView) findViewById(R.id.delivery_list);
        this.dcE = findViewById(R.id.delivery_add);
        this.dcH = findViewById(R.id.delivery_add_line);
        this.dcG = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.dcF = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        gs(com.baidu.swan.apps.u.a.EF().Fe());
        this.dcD = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.dcC.setLayoutManager(new LinearLayoutManager(context));
        this.dcC.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.dcC.setAdapter(this.dcD);
        this.dcE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dcI != null) {
                    ChooseAddressView.this.dcI.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void gs(boolean z) {
        if (z) {
            this.dcC.setBackgroundColor(Color.parseColor("#161616"));
            this.dcH.setBackgroundColor(Color.parseColor("#303030"));
            this.dcE.setBackgroundColor(Color.parseColor("#191919"));
            this.dcF.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.dcF.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.dcG.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.dcG.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.dcG.setTitle(getResources().getString(R.string.net_error));
        this.dcG.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.dcG.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.dcG.setVisibility(z ? 8 : 0);
        this.dcC.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.dcD;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dcI = bVar;
        this.dcD.setDeliveryChooseListener(this.dcI);
    }

    public void aJ(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dcD.aF(list);
            a(PageState.Normal);
            JS();
            return;
        }
        showEmptyView();
    }

    public void JS() {
        this.dcD.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dcK;
        private int dcL;

        public a(int i, int i2) {
            this.dcK = i;
            this.dcL = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dcL;
            rect.left = this.dcK;
            rect.right = this.dcK;
        }
    }
}
