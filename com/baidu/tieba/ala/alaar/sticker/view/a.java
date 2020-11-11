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
    private BdGridView gdr;
    private d gds;
    private int gdt;
    private c.b gdu;
    private c.a gdv;
    private CommonEmptyView gdw;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gdt = i;
        this.gdu = bVar;
        this.gdv = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gdr = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gdt == 2) {
            this.gdr.setNumColumns(2);
        } else if (this.gdt == 1) {
            this.gdr.setNumColumns(3);
        } else if (this.gdt == 3) {
            this.gdr.setNumColumns(5);
        }
        this.gds = new d(this.mContext, this.gdt, this.gdu);
        this.gdr.setAdapter((ListAdapter) this.gds);
        this.gdr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.gdw = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.gdw.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gdw.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.gdw.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gdv != null) {
                    if (a.this.gdt == 2) {
                        a.this.gdv.bNY();
                    } else if (a.this.gdt == 1) {
                        a.this.gdv.bNZ();
                    } else if (a.this.gdt == 3) {
                        a.this.gdv.bOa();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gds != null) {
            this.gds.setDatas(list);
        }
        if (list == null) {
            this.gdw.setVisibility(0);
            this.gdr.setEmptyView(this.gdw);
            return;
        }
        this.gdw.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gdt == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gdt == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gdt == 3) {
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
