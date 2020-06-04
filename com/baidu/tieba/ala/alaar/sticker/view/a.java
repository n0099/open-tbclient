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
    private BdGridView eXK;
    private d eXL;
    private int eXM;
    private c.a eXN;
    private CommonEmptyView eXO;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.a aVar) {
        this.mContext = context;
        this.eXM = i;
        this.eXN = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.eXK = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.eXM == 1) {
            this.eXK.setNumColumns(2);
        } else if (this.eXM == 2) {
            this.eXK.setNumColumns(3);
        } else if (this.eXM == 3) {
            this.eXK.setNumColumns(5);
        }
        this.eXL = new d(this.mContext, this.eXM, this.eXN);
        this.eXK.setAdapter((ListAdapter) this.eXL);
        this.eXK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.eXO = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.eXO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alaar.sticker.a.f.bpR();
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.eXL != null) {
            this.eXL.setDatas(list);
        }
        this.eXK.setEmptyView(this.eXO);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.eXM == 2) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.eXM == 1) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.eXM == 3) {
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
