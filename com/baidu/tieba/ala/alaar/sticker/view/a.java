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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.view.tabhost.a {
    private BdGridView gtK;
    private d gtL;
    private int gtM;
    private c.b gtN;
    private c.a gtO;
    private CommonEmptyView gtP;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gtM = i;
        this.gtN = bVar;
        this.gtO = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gtK = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gtM == 2) {
            this.gtK.setNumColumns(2);
        } else if (this.gtM == 1) {
            this.gtK.setNumColumns(3);
        } else if (this.gtM == 3) {
            this.gtK.setNumColumns(5);
        }
        this.gtL = new d(this.mContext, this.gtM, this.gtN);
        this.gtK.setAdapter((ListAdapter) this.gtL);
        this.gtK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.gtP = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.gtP.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gtP.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.gtP.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gtO != null) {
                    if (a.this.gtM == 2) {
                        a.this.gtO.bQo();
                    } else if (a.this.gtM == 1) {
                        a.this.gtO.bQp();
                    } else if (a.this.gtM == 3) {
                        a.this.gtO.bQq();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gtL != null) {
            this.gtL.setDatas(list);
        }
        if (list == null) {
            this.gtP.setVisibility(0);
            this.gtK.setEmptyView(this.gtP);
            return;
        }
        this.gtP.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gtM == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gtM == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gtM == 3) {
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
