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
    private BdGridView glh;
    private d gli;
    private int glj;
    private c.b glk;
    private c.a gll;
    private CommonEmptyView glm;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.glj = i;
        this.glk = bVar;
        this.gll = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.glh = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.glj == 2) {
            this.glh.setNumColumns(2);
        } else if (this.glj == 1) {
            this.glh.setNumColumns(3);
        } else if (this.glj == 3) {
            this.glh.setNumColumns(5);
        }
        this.gli = new d(this.mContext, this.glj, this.glk);
        this.glh.setAdapter((ListAdapter) this.gli);
        this.glh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.glm = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.glm.setTitle(a.h.sdk_net_fail_tip_rank);
        this.glm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.glm.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gll != null) {
                    if (a.this.glj == 2) {
                        a.this.gll.bRc();
                    } else if (a.this.glj == 1) {
                        a.this.gll.bRd();
                    } else if (a.this.glj == 3) {
                        a.this.gll.bRe();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gli != null) {
            this.gli.setDatas(list);
        }
        if (list == null) {
            this.glm.setVisibility(0);
            this.glh.setEmptyView(this.glm);
            return;
        }
        this.glm.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.glj == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.glj == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.glj == 3) {
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
