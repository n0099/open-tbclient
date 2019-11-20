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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.address.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private RecyclerView dmR;
    private com.baidu.tieba.aiapps.apps.address.a.a dmS;
    private View dmT;
    private TextView dmU;
    private CommonEmptyView dmV;
    private View dmW;
    private a.b dmX;

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
        this.dmR = (RecyclerView) findViewById(R.id.delivery_list);
        this.dmT = findViewById(R.id.delivery_add);
        this.dmW = findViewById(R.id.delivery_add_line);
        this.dmV = (CommonEmptyView) findViewById(R.id.delivery_empty);
        this.dmU = (TextView) findViewById(R.id.delivery_add_txt);
        a(PageState.Normal);
        gk(com.baidu.swan.apps.u.a.JE().Kd());
        this.dmS = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.dmR.setLayoutManager(new LinearLayoutManager(context));
        this.dmR.addItemDecoration(new a(0, z.dip2px(context, 7.0f)));
        this.dmR.setAdapter(this.dmS);
        this.dmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.dmX != null) {
                    ChooseAddressView.this.dmX.b(new com.baidu.tieba.aiapps.apps.address.c.b(), IMTrack.DbBuilder.ACTION_ADD);
                }
            }
        });
    }

    public void gk(boolean z) {
        if (z) {
            this.dmR.setBackgroundColor(Color.parseColor("#161616"));
            this.dmW.setBackgroundColor(Color.parseColor("#303030"));
            this.dmT.setBackgroundColor(Color.parseColor("#191919"));
            this.dmU.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.dmU.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void aFS() {
        a(PageState.EMPTY_DATA);
        this.dmV.setTitle(getResources().getString(R.string.delivery_empty_title));
        this.dmV.setIcon(getResources().getDrawable(R.drawable.empty_icon_document));
    }

    public void j(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.dmV.setTitle(getResources().getString(R.string.net_error));
        this.dmV.setIcon(getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.dmV.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.dmV.setVisibility(z ? 8 : 0);
        this.dmR.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.dmS;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.dmX = bVar;
        this.dmS.setDeliveryChooseListener(this.dmX);
    }

    public void bc(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dmS.aY(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        aFS();
    }

    public void updateUI() {
        this.dmS.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int dmZ;
        private int dna;

        public a(int i, int i2) {
            this.dmZ = i;
            this.dna = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.dna;
            rect.left = this.dmZ;
            rect.right = this.dmZ;
        }
    }
}
