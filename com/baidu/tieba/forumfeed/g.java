package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.data.p;
import com.baidu.tieba.data.q;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private int atB;
    private p ayk;
    private com.baidu.tieba.view.j ayl;
    private Context context;
    private boolean auo = false;
    private boolean aym = false;
    private float ayn = 0.4f;
    private boolean mIsFromCDN = false;

    public void a(p pVar) {
        bJ(ba.mD().mF());
        this.auo = true;
        this.ayk = pVar;
    }

    public g(Context context) {
        this.atB = Constants.MEDIA_INFO;
        this.context = context;
        this.atB = com.baidu.adp.lib.util.m.n(context);
        bJ(ba.mD().mF());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<q> yX;
        if (!this.auo) {
            return 1;
        }
        if (this.ayk == null || (yX = this.ayk.yX()) == null) {
            return 0;
        }
        return yX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.auo || this.ayk == null || this.ayk.yX() == null) {
            return null;
        }
        ArrayList<q> yX = this.ayk.yX();
        if (i < 0 || yX == null || i >= yX.size()) {
            return null;
        }
        return yX.get(i);
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
        if (!this.auo) {
            return El();
        }
        if (this.ayl == null) {
            this.ayl = new com.baidu.tieba.view.j(this.context);
        }
        this.ayl.a(this.atB, this.aym, this.ayn);
        this.ayl.setFromCDN(this.mIsFromCDN);
        View hA = (view == null || view.getTag() == null) ? this.ayl.hA() : view;
        hA.setPadding(0, i == 0 ? this.context.getResources().getDimensionPixelSize(t.forumfeed_first_item_margin_top) : 0, 0, 0);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        ArrayList<q> yX = this.ayk.yX();
        if (yX != null && (qVar = yX.get(i)) != null) {
            this.ayl.a(hA, qVar);
            this.ayl.c(skinType, hA);
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
        if (this.auo && this.ayk != null) {
            ArrayList<q> yX = this.ayk.yX();
            if (yX == null || (qVar = yX.get(i)) == null || (medias = qVar.getMedias()) == null) {
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

    public View El() {
        View view = new View(this.context);
        view.setBackgroundColor(0);
        return view;
    }

    public void bJ(boolean z) {
        this.aym = z;
    }
}
