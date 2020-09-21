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
    private BdGridView fCb;
    private d fCc;
    private int fCd;
    private c.b fCe;
    private c.a fCf;
    private CommonEmptyView fCg;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.fCd = i;
        this.fCe = bVar;
        this.fCf = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fCb = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fCd == 2) {
            this.fCb.setNumColumns(2);
        } else if (this.fCd == 1) {
            this.fCb.setNumColumns(3);
        } else if (this.fCd == 3) {
            this.fCb.setNumColumns(5);
        }
        this.fCc = new d(this.mContext, this.fCd, this.fCe);
        this.fCb.setAdapter((ListAdapter) this.fCc);
        this.fCb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fCg = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fCg.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fCg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.fCg.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fCf != null) {
                    if (a.this.fCd == 2) {
                        a.this.fCf.bGn();
                    } else if (a.this.fCd == 1) {
                        a.this.fCf.bGo();
                    } else if (a.this.fCd == 3) {
                        a.this.fCf.bGp();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fCc != null) {
            this.fCc.setDatas(list);
        }
        if (list == null) {
            this.fCg.setVisibility(0);
            this.fCb.setEmptyView(this.fCg);
            return;
        }
        this.fCg.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fCd == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fCd == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fCd == 3) {
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
