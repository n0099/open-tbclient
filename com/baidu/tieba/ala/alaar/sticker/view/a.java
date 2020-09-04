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
    private BdGridView fyP;
    private d fyQ;
    private int fyR;
    private c.b fyS;
    private c.a fyT;
    private CommonEmptyView fyU;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.fyR = i;
        this.fyS = bVar;
        this.fyT = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fyP = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fyR == 2) {
            this.fyP.setNumColumns(2);
        } else if (this.fyR == 1) {
            this.fyP.setNumColumns(3);
        } else if (this.fyR == 3) {
            this.fyP.setNumColumns(5);
        }
        this.fyQ = new d(this.mContext, this.fyR, this.fyS);
        this.fyP.setAdapter((ListAdapter) this.fyQ);
        this.fyP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fyU = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fyU.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fyU.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.fyU.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fyT != null) {
                    if (a.this.fyR == 2) {
                        a.this.fyT.bEX();
                    } else if (a.this.fyR == 1) {
                        a.this.fyT.bEY();
                    } else if (a.this.fyR == 3) {
                        a.this.fyT.bEZ();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fyQ != null) {
            this.fyQ.setDatas(list);
        }
        if (list == null) {
            this.fyU.setVisibility(0);
            this.fyP.setEmptyView(this.fyU);
            return;
        }
        this.fyU.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fyR == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fyR == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fyR == 3) {
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
