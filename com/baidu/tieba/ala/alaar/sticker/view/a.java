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
    private BdGridView gtY;
    private d gtZ;
    private int gua;
    private c.b gub;
    private c.a guc;
    private CommonEmptyView gud;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gua = i;
        this.gub = bVar;
        this.guc = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.gtY = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gua == 2) {
            this.gtY.setNumColumns(2);
        } else if (this.gua == 1) {
            this.gtY.setNumColumns(3);
        } else if (this.gua == 3) {
            this.gtY.setNumColumns(5);
        }
        this.gtZ = new d(this.mContext, this.gua, this.gub);
        this.gtY.setAdapter((ListAdapter) this.gtZ);
        this.gtY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.gud = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.gud.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gud.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.gud.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.guc != null) {
                    if (a.this.gua == 2) {
                        a.this.guc.bQv();
                    } else if (a.this.gua == 1) {
                        a.this.guc.bQw();
                    } else if (a.this.gua == 3) {
                        a.this.guc.bQx();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.gtZ != null) {
            this.gtZ.setDatas(list);
        }
        if (list == null) {
            this.gud.setVisibility(0);
            this.gtY.setEmptyView(this.gud);
            return;
        }
        this.gud.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gua == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gua == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gua == 3) {
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
