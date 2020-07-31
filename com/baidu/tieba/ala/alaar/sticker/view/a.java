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
    private BdGridView fnq;
    private d fnr;
    private int fns;
    private c.a fnt;
    private CommonEmptyView fnu;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.a aVar) {
        this.mContext = context;
        this.fns = i;
        this.fnt = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.fnq = (BdGridView) this.mRootView.findViewById(a.g.ala_live_sticker_gridview);
        if (this.fns == 2) {
            this.fnq.setNumColumns(2);
        } else if (this.fns == 1) {
            this.fnq.setNumColumns(3);
        } else if (this.fns == 3) {
            this.fnq.setNumColumns(5);
        }
        this.fnr = new d(this.mContext, this.fns, this.fnt);
        this.fnq.setAdapter((ListAdapter) this.fnr);
        this.fnq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.fnu = (CommonEmptyView) this.mRootView.findViewById(a.g.errorView);
        this.fnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alaar.sticker.a.f.HD();
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.fnr != null) {
            this.fnr.setDatas(list);
        }
        this.fnq.setEmptyView(this.fnu);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.i.live_sticker_pic);
        if (this.fns == 1) {
            return this.mContext.getString(a.i.live_sticker_pic);
        }
        if (this.fns == 2) {
            return this.mContext.getString(a.i.live_sticker_text);
        }
        if (this.fns == 3) {
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
