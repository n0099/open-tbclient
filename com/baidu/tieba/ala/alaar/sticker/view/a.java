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
    private BdGridView fOk;
    private d fOl;
    private int fOm;
    private c.b fOn;
    private c.a fOo;
    private CommonEmptyView fOp;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.fOm = i;
        this.fOn = bVar;
        this.fOo = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fOk = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fOm == 2) {
            this.fOk.setNumColumns(2);
        } else if (this.fOm == 1) {
            this.fOk.setNumColumns(3);
        } else if (this.fOm == 3) {
            this.fOk.setNumColumns(5);
        }
        this.fOl = new d(this.mContext, this.fOm, this.fOn);
        this.fOk.setAdapter((ListAdapter) this.fOl);
        this.fOk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fOp = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fOp.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fOp.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.fOp.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fOo != null) {
                    if (a.this.fOm == 2) {
                        a.this.fOo.bIZ();
                    } else if (a.this.fOm == 1) {
                        a.this.fOo.bJa();
                    } else if (a.this.fOm == 3) {
                        a.this.fOo.bJb();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fOl != null) {
            this.fOl.setDatas(list);
        }
        if (list == null) {
            this.fOp.setVisibility(0);
            this.fOk.setEmptyView(this.fOp);
            return;
        }
        this.fOp.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fOm == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fOm == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fOm == 3) {
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
