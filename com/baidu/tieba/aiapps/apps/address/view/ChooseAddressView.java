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
    private RecyclerView bGm;
    private com.baidu.tieba.aiapps.apps.address.a.a bGn;
    private View bGo;
    private TextView bGp;
    private CommonEmptyView bGq;
    private View bGr;
    private a.b bGs;

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
        this.bGm = (RecyclerView) findViewById(e.g.delivery_list);
        this.bGo = findViewById(e.g.delivery_add);
        this.bGr = findViewById(e.g.delivery_add_line);
        this.bGq = (CommonEmptyView) findViewById(e.g.delivery_empty);
        this.bGp = (TextView) findViewById(e.g.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bGn = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.bGm.setLayoutManager(new LinearLayoutManager(context));
        this.bGm.addItemDecoration(new a(0, AiAppsUIUtils.dip2px(context, 7.0f)));
        this.bGm.setAdapter(this.bGn);
        this.bGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bGs != null) {
                    ChooseAddressView.this.bGs.b(new b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bGm.setBackgroundColor(Color.parseColor("#161616"));
            this.bGr.setBackgroundColor(Color.parseColor("#303030"));
            this.bGo.setBackgroundColor(Color.parseColor("#191919"));
            this.bGp.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bGp.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.bGq.setTitle(getResources().getString(e.j.delivery_empty_title));
        this.bGq.setIcon(getResources().getDrawable(e.f.empty_icon_document));
    }

    public void h(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bGq.setTitle(getResources().getString(e.j.net_error));
        this.bGq.setIcon(getResources().getDrawable(e.f.aiapps_empty_icon_network));
        this.bGq.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bGq.setVisibility(z ? 8 : 0);
        this.bGm.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.bGn;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bGs = bVar;
        this.bGn.setDeliveryChooseListener(this.bGs);
    }

    public void ao(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bGn.ak(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        showEmptyView();
    }

    public void updateUI() {
        this.bGn.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bGu;
        private int bGv;

        public a(int i, int i2) {
            this.bGu = i;
            this.bGv = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bGv;
            rect.left = this.bGu;
            rect.right = this.bGu;
        }
    }
}
