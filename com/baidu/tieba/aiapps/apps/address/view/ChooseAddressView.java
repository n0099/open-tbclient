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
import com.baidu.searchbox.ng.ai.apps.res.ui.CommonEmptyView;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.aiapps.apps.address.c.b;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseAddressView extends FrameLayout {
    private RecyclerView bCT;
    private com.baidu.tieba.aiapps.apps.address.a.a bCU;
    private View bCV;
    private TextView bCW;
    private CommonEmptyView bCX;
    private View bCY;
    private a.b bCZ;

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
        LayoutInflater.from(context).inflate(e.h.delivery_choose_layout, this);
        this.bCT = (RecyclerView) findViewById(e.g.delivery_list);
        this.bCV = findViewById(e.g.delivery_add);
        this.bCY = findViewById(e.g.delivery_add_line);
        this.bCX = (CommonEmptyView) findViewById(e.g.delivery_empty);
        this.bCW = (TextView) findViewById(e.g.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bCU = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.bCT.setLayoutManager(new LinearLayoutManager(context));
        this.bCT.addItemDecoration(new a(0, AiAppsUIUtils.dip2px(context, 7.0f)));
        this.bCT.setAdapter(this.bCU);
        this.bCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bCZ != null) {
                    ChooseAddressView.this.bCZ.b(new b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bCT.setBackgroundColor(Color.parseColor("#161616"));
            this.bCY.setBackgroundColor(Color.parseColor("#303030"));
            this.bCV.setBackgroundColor(Color.parseColor("#191919"));
            this.bCW.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bCW.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.bCX.setTitle(getResources().getString(e.j.delivery_empty_title));
        this.bCX.setIcon(getResources().getDrawable(e.f.empty_icon_document));
    }

    public void h(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bCX.setTitle(getResources().getString(e.j.net_error));
        this.bCX.setIcon(getResources().getDrawable(e.f.aiapps_empty_icon_network));
        this.bCX.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bCX.setVisibility(z ? 8 : 0);
        this.bCT.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.bCU;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bCZ = bVar;
        this.bCU.setDeliveryChooseListener(this.bCZ);
    }

    public void ao(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bCU.ak(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        showEmptyView();
    }

    public void updateUI() {
        this.bCU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bDb;
        private int bDc;

        public a(int i, int i2) {
            this.bDb = i;
            this.bDc = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bDc;
            rect.left = this.bDb;
            rect.right = this.bDb;
        }
    }
}
