package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.view.tabhost.a {
    private BdGridView gcY;
    private d gcZ;
    private int gda;
    private c.b gdb;
    private c.a gdc;
    private CommonEmptyView gdd;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gda = i;
        this.gdb = bVar;
        this.gdc = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gcY = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gda == 2) {
            this.gcY.setNumColumns(2);
        } else if (this.gda == 1) {
            this.gcY.setNumColumns(3);
        } else if (this.gda == 3) {
            this.gcY.setNumColumns(5);
        }
        this.gcZ = new d(this.mContext, this.gda, this.gdb);
        this.gcY.setAdapter((ListAdapter) this.gcZ);
        this.gcY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.gdd = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.gdd.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gdd.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.gdd.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gdc != null) {
                    if (a.this.gda == 2) {
                        a.this.gdc.bNr();
                    } else if (a.this.gda == 1) {
                        a.this.gdc.bNs();
                    } else if (a.this.gda == 3) {
                        a.this.gdc.bNt();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gcZ != null) {
            this.gcZ.setDatas(list);
        }
        if (list == null) {
            this.gdd.setVisibility(0);
            this.gcY.setEmptyView(this.gdd);
            return;
        }
        this.gdd.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gda == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gda == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gda == 3) {
            return this.mContext.getString(a.h.live_sticker_ar);
        }
        return string;
    }

    @Override // com.baidu.live.view.tabhost.a
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.view.tabhost.a
    public void enterBackground() {
    }

    @Override // com.baidu.live.view.tabhost.a
    public void enterForeground() {
    }
}
