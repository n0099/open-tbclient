package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.p;
import com.baidu.tieba.data.q;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private int ats;
    private p ayb;
    private com.baidu.tieba.view.j ayc;
    private Context context;
    private boolean auf = false;
    private boolean ayd = false;
    private float aye = 0.4f;
    private boolean mIsFromCDN = false;

    public void a(p pVar) {
        bJ(az.mD().mF());
        this.auf = true;
        this.ayb = pVar;
    }

    public g(Context context) {
        this.ats = Constants.MEDIA_INFO;
        this.context = context;
        this.ats = com.baidu.adp.lib.util.m.n(context);
        bJ(az.mD().mF());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<q> yV;
        if (!this.auf) {
            return 1;
        }
        if (this.ayb == null || (yV = this.ayb.yV()) == null) {
            return 0;
        }
        return yV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.auf || this.ayb == null || this.ayb.yV() == null) {
            return null;
        }
        ArrayList<q> yV = this.ayb.yV();
        if (i < 0 || yV == null || i >= yV.size()) {
            return null;
        }
        return yV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        if (!this.auf) {
            return Ej();
        }
        if (this.ayc == null) {
            this.ayc = new com.baidu.tieba.view.j(this.context);
        }
        this.ayc.a(this.ats, this.ayd, this.aye);
        this.ayc.setFromCDN(this.mIsFromCDN);
        View hA = (view == null || view.getTag() == null) ? this.ayc.hA() : view;
        hA.setPadding(0, i == 0 ? this.context.getResources().getDimensionPixelSize(t.forumfeed_first_item_margin_top) : 0, 0, 0);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        ArrayList<q> yV = this.ayb.yV();
        if (yV != null && (qVar = yV.get(i)) != null) {
            this.ayc.a(hA, qVar);
            this.ayc.c(skinType, hA);
        }
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.context;
        baseFragmentActivity.getLayoutMode().L(skinType == 1);
        baseFragmentActivity.getLayoutMode().h(hA);
        return hA;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        q qVar;
        ArrayList<MediaData> medias;
        if (this.auf && this.ayb != null) {
            ArrayList<q> yV = this.ayb.yV();
            if (yV == null || (qVar = yV.get(i)) == null || (medias = qVar.getMedias()) == null) {
                return 2;
            }
            int size = medias.size();
            if (size >= 3) {
                return 5;
            }
            if (size == 2) {
                return 4;
            }
            return size == 1 ? 3 : 2;
        }
        return 0;
    }

    public View Ej() {
        View view = new View(this.context);
        view.setBackgroundColor(0);
        return view;
    }

    public void bJ(boolean z) {
        this.ayd = z;
    }
}
