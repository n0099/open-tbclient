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
    private RecyclerView bCh;
    private com.baidu.tieba.aiapps.apps.address.a.a bCi;
    private View bCj;
    private TextView bCk;
    private CommonEmptyView bCl;
    private View bCm;
    private a.b bCn;

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
        this.bCh = (RecyclerView) findViewById(e.g.delivery_list);
        this.bCj = findViewById(e.g.delivery_add);
        this.bCm = findViewById(e.g.delivery_add_line);
        this.bCl = (CommonEmptyView) findViewById(e.g.delivery_empty);
        this.bCk = (TextView) findViewById(e.g.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bCi = new com.baidu.tieba.aiapps.apps.address.a.a(context);
        this.bCh.setLayoutManager(new LinearLayoutManager(context));
        this.bCh.addItemDecoration(new a(0, AiAppsUIUtils.dip2px(context, 7.0f)));
        this.bCh.setAdapter(this.bCi);
        this.bCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bCn != null) {
                    ChooseAddressView.this.bCn.b(new b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bCh.setBackgroundColor(Color.parseColor("#161616"));
            this.bCm.setBackgroundColor(Color.parseColor("#303030"));
            this.bCj.setBackgroundColor(Color.parseColor("#191919"));
            this.bCk.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bCk.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void showEmptyView() {
        a(PageState.EMPTY_DATA);
        this.bCl.setTitle(getResources().getString(e.j.delivery_empty_title));
        this.bCl.setIcon(getResources().getDrawable(e.f.empty_icon_document));
    }

    public void g(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bCl.setTitle(getResources().getString(e.j.net_error));
        this.bCl.setIcon(getResources().getDrawable(e.f.aiapps_empty_icon_network));
        this.bCl.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bCl.setVisibility(z ? 8 : 0);
        this.bCh.setVisibility(z ? 0 : 8);
    }

    public com.baidu.tieba.aiapps.apps.address.a.a getDeliveryAdapter() {
        return this.bCi;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bCn = bVar;
        this.bCi.setDeliveryChooseListener(this.bCn);
    }

    public void ap(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bCi.al(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        showEmptyView();
    }

    public void updateUI() {
        this.bCi.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bCp;
        private int bCq;

        public a(int i, int i2) {
            this.bCp = i;
            this.bCq = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bCq;
            rect.left = this.bCp;
            rect.right = this.bCp;
        }
    }
}
