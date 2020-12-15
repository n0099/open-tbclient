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
    private BdGridView glj;
    private d glk;
    private int gll;
    private c.b glm;
    private c.a gln;
    private CommonEmptyView glo;
    private Context mContext;
    private View mRootView;

    public a(Context context, int i, c.b bVar, c.a aVar) {
        this.mContext = context;
        this.gll = i;
        this.glm = bVar;
        this.gln = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_sticker_panel_item_view, (ViewGroup) null);
        this.glj = (BdGridView) this.mRootView.findViewById(a.f.ala_live_sticker_gridview);
        if (this.gll == 2) {
            this.glj.setNumColumns(2);
        } else if (this.gll == 1) {
            this.glj.setNumColumns(3);
        } else if (this.gll == 3) {
            this.glj.setNumColumns(5);
        }
        this.glk = new d(this.mContext, this.gll, this.glm);
        this.glj.setAdapter((ListAdapter) this.glk);
        this.glj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.glo = (CommonEmptyView) this.mRootView.findViewById(a.f.errorView);
        this.glo.setTitle(a.h.sdk_net_fail_tip_rank);
        this.glo.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.glo.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gln != null) {
                    if (a.this.gll == 2) {
                        a.this.gln.bRd();
                    } else if (a.this.gll == 1) {
                        a.this.gln.bRe();
                    } else if (a.this.gll == 3) {
                        a.this.gln.bRf();
                    }
                }
            }
        });
    }

    public void setDatas(List<FuFaceItem> list) {
        if (this.glk != null) {
            this.glk.setDatas(list);
        }
        if (list == null) {
            this.glo.setVisibility(0);
            this.glj.setEmptyView(this.glo);
            return;
        }
        this.glo.setVisibility(8);
    }

    @Override // com.baidu.live.view.tabhost.a
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.view.tabhost.a
    public String getTitle() {
        String string = this.mContext.getString(a.h.live_sticker_pic);
        if (this.gll == 1) {
            return this.mContext.getString(a.h.live_sticker_pic);
        }
        if (this.gll == 2) {
            return this.mContext.getString(a.h.live_sticker_text);
        }
        if (this.gll == 3) {
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
