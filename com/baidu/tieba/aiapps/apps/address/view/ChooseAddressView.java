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
    private RecyclerView deo;
    private com.baidu.tieba.aiapps.apps.address.a.a dep;
    private View deq;
    private TextView der;
    private CommonEmptyView det;
    private View deu;
    private a.b dev;

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
        this.deo = (RecyclerView) findViewById(R.id.delivery_list);
        this.deq = findViewById(R.id.delivery_add);
        this.deu = findViewById(R.id.delivery_add_line);
        this.det = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.der = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        gv(com.baidu.swan.apps.u.a.EJ().Fi());
        this.dep = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.deo.setLayoutManager(new LinearLayoutManager(context));
        this.deo.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.deo.setAdapter(this.dep);
        this.deq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dev != null) {
                    ChooseAddressView.this.dev.b(new com.baidu.tieba.aiapps.apps.address.c.b(), "add");
                }
            }
        });
    }

    public void gv(boolean z) {
        if (z) {
            this.deo.setBackgroundColor(Color.parseColor("#161616"));
            this.deu.setBackgroundColor(Color.parseColor("#303030"));
            this.deq.setBackgroundColor(Color.parseColor("#191919"));
            this.der.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.der.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.det.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.det.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void i(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.det.setTitle(getResources().getString(R.string.net_error));
        this.det.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.det.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.det.setVisibility(z ? 8 : 0);
        this.deo.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.dep;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dev = bVar;
        this.dep.setDeliveryChooseListener(this.dev);
    }

    public void aJ(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dep.aF(list);
            a(PageState.Normal);
            JW();
            return;
        }
        showEmptyView();
    }

    public void JW() {
        this.dep.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dex;
        private int dey;

        public a(int i, int i2) {
            this.dex = i;
            this.dey = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dey;
            rect.left = this.dex;
            rect.right = this.dex;
        }
    }
}
