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
    private BdGridView gvH;
    private d gvI;
    private int gvJ;
    private c.b gvK;
    private c.a gvL;
    private CommonEmptyView gvM;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gvJ = i;
        this.gvK = bVar;
        this.gvL = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gvH = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gvJ == 2) {
            this.gvH.setNumColumns(2);
        } else if (this.gvJ == 1) {
            this.gvH.setNumColumns(3);
        } else if (this.gvJ == 3) {
            this.gvH.setNumColumns(5);
        }
        this.gvI = new d(this.mContext, this.gvJ, this.gvK);
        this.gvH.setAdapter((ListAdapter) this.gvI);
        this.gvH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.gvM = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.gvM.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gvM.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.gvM.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gvL != null) {
                    if (a.this.gvJ == 2) {
                        a.this.gvL.bQB();
                    } else if (a.this.gvJ == 1) {
                        a.this.gvL.bQC();
                    } else if (a.this.gvJ == 3) {
                        a.this.gvL.bQD();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gvI != null) {
            this.gvI.setDatas(list);
        }
        if (list == null) {
            this.gvM.setVisibility(0);
            this.gvH.setEmptyView(this.gvM);
            return;
        }
        this.gvM.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gvJ == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gvJ == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gvJ == 3) {
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
