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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.view.tabhost.a {
    private BdGridView fyL;
    private d fyM;
    private int fyN;
    private c.b fyO;
    private c.a fyP;
    private CommonEmptyView fyQ;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.fyN = i;
        this.fyO = bVar;
        this.fyP = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fyL = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fyN == 2) {
            this.fyL.setNumColumns(2);
        } else if (this.fyN == 1) {
            this.fyL.setNumColumns(3);
        } else if (this.fyN == 3) {
            this.fyL.setNumColumns(5);
        }
        this.fyM = new d(this.mContext, this.fyN, this.fyO);
        this.fyL.setAdapter((ListAdapter) this.fyM);
        this.fyL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fyQ = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fyQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fyQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.fyQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fyP != null) {
                    if (a.this.fyN == 2) {
                        a.this.fyP.bEW();
                    } else if (a.this.fyN == 1) {
                        a.this.fyP.bEX();
                    } else if (a.this.fyN == 3) {
                        a.this.fyP.bEY();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fyM != null) {
            this.fyM.setDatas(list);
        }
        if (list == null) {
            this.fyQ.setVisibility(0);
            this.fyL.setEmptyView(this.fyQ);
            return;
        }
        this.fyQ.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fyN == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fyN == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fyN == 3) {
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
