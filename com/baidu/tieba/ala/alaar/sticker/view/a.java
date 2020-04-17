package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.view.tabhost.a {
    private BdGridView eKX;
    private d eKY;
    private int eKZ;
    private c.a eLa;
    private CommonEmptyView eLb;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.a aVar) {
        this.mContext = context;
        this.eKZ = i;
        this.eLa = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.eKX = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.eKZ == 1) {
            this.eKX.setNumColumns(2);
        } else if (this.eKZ == 2) {
            this.eKX.setNumColumns(3);
        } else if (this.eKZ == 3) {
            this.eKX.setNumColumns(5);
        }
        this.eKY = new d(this.mContext, this.eKZ, this.eLa);
        this.eKX.setAdapter((ListAdapter) this.eKY);
        this.eKX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.eLb = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.eLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bkx();
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.eKY != null) {
            this.eKY.setDatas(list);
        }
        this.eKX.setEmptyView(this.eLb);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.eKZ == 2) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.eKZ == 1) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.eKZ == 3) {
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
