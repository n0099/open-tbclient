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
    private RecyclerView bGp;
    private com.baidu.tieba.aiapps.apps.address.a.a bGq;
    private View bGr;
    private TextView bGs;
    private CommonEmptyView bGt;
    private View bGu;
    private a.b bGv;

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
        this.bGp = (RecyclerView) findViewById(e.g.delivery_list);
        this.bGr = findViewById(e.g.delivery_add);
        this.bGu = findViewById(e.g.delivery_add_line);
        this.bGt = (CommonEmptyView) findViewById(e.g.delivery_empty);
        this.bGs = (TextView) findViewById(e.g.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bGq = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.bGp.setLayoutManager(new LinearLayoutManager(context));
        this.bGp.addItemDecoration(new a(0, AiAppsUIUtils.dip2px(context, 7.0f)));
        this.bGp.setAdapter(this.bGq);
        this.bGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bGv != null) {
                    ChooseAddressView.this.bGv.b(new b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bGp.setBackgroundColor(Color.parseColor("#161616"));
            this.bGu.setBackgroundColor(Color.parseColor("#303030"));
            this.bGr.setBackgroundColor(Color.parseColor("#191919"));
            this.bGs.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bGs.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.bGt.setTitle(getResources().getString(e.j.delivery_empty_title));
        this.bGt.setIcon(getResources().getDrawable(e.f.empty_icon_document));
    }

    public void h(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bGt.setTitle(getResources().getString(e.j.net_error));
        this.bGt.setIcon(getResources().getDrawable(e.f.aiapps_empty_icon_network));
        this.bGt.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bGt.setVisibility(z ? 8 : 0);
        this.bGp.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.bGq;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bGv = bVar;
        this.bGq.setDeliveryChooseListener(this.bGv);
    }

    public void ao(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bGq.ak(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        showEmptyView();
    }

    public void updateUI() {
        this.bGq.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bGx;
        private int bGy;

        public a(int i, int i2) {
            this.bGx = i;
            this.bGy = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bGy;
            rect.left = this.bGx;
            rect.right = this.bGx;
        }
    }
}
