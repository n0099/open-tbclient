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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.view.tabhost.a {
    private BdGridView gra;
    private d grb;
    private int grc;
    private c.b grd;
    private c.a gre;
    private CommonEmptyView grf;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.grc = i;
        this.grd = bVar;
        this.gre = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gra = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.grc == 2) {
            this.gra.setNumColumns(2);
        } else if (this.grc == 1) {
            this.gra.setNumColumns(3);
        } else if (this.grc == 3) {
            this.gra.setNumColumns(5);
        }
        this.grb = new d(this.mContext, this.grc, this.grd);
        this.gra.setAdapter((ListAdapter) this.grb);
        this.gra.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.grf = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.grf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.grf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.grf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gre != null) {
                    if (a.this.grc == 2) {
                        a.this.gre.bPK();
                    } else if (a.this.grc == 1) {
                        a.this.gre.bPL();
                    } else if (a.this.grc == 3) {
                        a.this.gre.bPM();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.grb != null) {
            this.grb.setDatas(list);
        }
        if (list == null) {
            this.grf.setVisibility(0);
            this.gra.setEmptyView(this.grf);
            return;
        }
        this.grf.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.grc == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.grc == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.grc == 3) {
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
