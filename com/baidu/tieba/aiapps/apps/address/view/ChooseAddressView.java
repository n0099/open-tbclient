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
    private RecyclerView bHc;
    private com.baidu.tieba.aiapps.apps.address.a.a bHd;
    private View bHe;
    private TextView bHf;
    private CommonEmptyView bHg;
    private View bHh;
    private a.b bHi;

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
        this.bHc = (RecyclerView) findViewById(e.g.delivery_list);
        this.bHe = findViewById(e.g.delivery_add);
        this.bHh = findViewById(e.g.delivery_add_line);
        this.bHg = (CommonEmptyView) findViewById(e.g.delivery_empty);
        this.bHf = (TextView) findViewById(e.g.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bHd = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.bHc.setLayoutManager(new LinearLayoutManager(context));
        this.bHc.addItemDecoration(new a(0, AiAppsUIUtils.dip2px(context, 7.0f)));
        this.bHc.setAdapter(this.bHd);
        this.bHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bHi != null) {
                    ChooseAddressView.this.bHi.b(new b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bHc.setBackgroundColor(Color.parseColor("#161616"));
            this.bHh.setBackgroundColor(Color.parseColor("#303030"));
            this.bHe.setBackgroundColor(Color.parseColor("#191919"));
            this.bHf.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bHf.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.bHg.setTitle(getResources().getString(e.j.delivery_empty_title));
        this.bHg.setIcon(getResources().getDrawable(e.f.empty_icon_document));
    }

    public void h(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bHg.setTitle(getResources().getString(e.j.net_error));
        this.bHg.setIcon(getResources().getDrawable(e.f.aiapps_empty_icon_network));
        this.bHg.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bHg.setVisibility(z ? 8 : 0);
        this.bHc.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.bHd;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bHi = bVar;
        this.bHd.setDeliveryChooseListener(this.bHi);
    }

    public void ap(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bHd.al(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        showEmptyView();
    }

    public void updateUI() {
        this.bHd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bHk;
        private int bHl;

        public a(int i, int i2) {
            this.bHk = i;
            this.bHl = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bHl;
            rect.left = this.bHk;
            rect.right = this.bHk;
        }
    }
}
