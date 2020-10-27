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
    private BdGridView fXA;
    private d fXB;
    private int fXC;
    private c.b fXD;
    private c.a fXE;
    private CommonEmptyView fXF;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.fXC = i;
        this.fXD = bVar;
        this.fXE = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fXA = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fXC == 2) {
            this.fXA.setNumColumns(2);
        } else if (this.fXC == 1) {
            this.fXA.setNumColumns(3);
        } else if (this.fXC == 3) {
            this.fXA.setNumColumns(5);
        }
        this.fXB = new d(this.mContext, this.fXC, this.fXD);
        this.fXA.setAdapter((ListAdapter) this.fXB);
        this.fXA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fXF = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fXF.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fXF.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.fXF.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fXE != null) {
                    if (a.this.fXC == 2) {
                        a.this.fXE.bLz();
                    } else if (a.this.fXC == 1) {
                        a.this.fXE.bLA();
                    } else if (a.this.fXC == 3) {
                        a.this.fXE.bLB();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fXB != null) {
            this.fXB.setDatas(list);
        }
        if (list == null) {
            this.fXF.setVisibility(0);
            this.fXA.setEmptyView(this.fXF);
            return;
        }
        this.fXF.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fXC == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fXC == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fXC == 3) {
            return this.mContext.getString(a.i.live_sticker_ar);
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
