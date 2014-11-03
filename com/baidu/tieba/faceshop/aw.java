package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class aw extends BaseAdapter {
    private FacePurchaseRecordsData aun = null;
    private boolean auo;
    private Context mContext;

    public aw(Context context) {
        this.mContext = context;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.buy_his == null || facePurchaseRecordsData.buy_his.size() == 0) {
            this.auo = false;
        } else {
            this.auo = true;
        }
        this.aun = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auo) {
            return this.aun.buy_his.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aun == null || this.aun.buy_his == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.aun.buy_his;
        if (i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (!this.auo) {
            return Dv();
        }
        if (view == null) {
            view = hA();
        }
        ay ayVar = (ay) view.getTag();
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(view);
        }
        a(i, ayVar);
        return view;
    }

    private View hA() {
        ay ayVar = new ay(this, null);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_purchase_record_item, null);
        ayVar.atI = (TbImageView) inflate.findViewById(bz.cover);
        ayVar.JN = (TextView) inflate.findViewById(bz.title);
        ayVar.auq = (TextView) inflate.findViewById(bz.time);
        ayVar.atK = (TextView) inflate.findViewById(bz.price);
        inflate.setTag(ayVar);
        return inflate;
    }

    private void a(int i, ay ayVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            ayVar.atI.setTag(facePurchasePackageData.cover_url);
            ayVar.atI.a(facePurchasePackageData.cover_url, 10, this.mContext.getResources().getDimensionPixelSize(bx.faceshop_purchase_cover_width), this.mContext.getResources().getDimensionPixelSize(bx.faceshop_purchase_cover_height), false);
            ayVar.atK.setText(facePurchasePackageData.price);
            ayVar.JN.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puy_time * 1000);
            ayVar.auq.setText(com.baidu.tbadk.core.util.az.d(date));
        }
    }

    private View Dv() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.buy_no_face_item, null);
        com.baidu.tbadk.core.view.o a = NoDataViewFactory.a(this.mContext, inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.EMOTION, (int) this.mContext.getResources().getDimension(bx.ds160)), com.baidu.tbadk.core.view.s.q(cb.buy_no_emotion, cb.go_to_emotion_store), com.baidu.tbadk.core.view.q.a(new com.baidu.tbadk.core.view.p(this.mContext.getResources().getString(cb.go_to_download_emotion), new ax(this))));
        BaseActivity baseActivity = (BaseActivity) this.mContext;
        int skinType = TbadkApplication.m251getInst().getSkinType();
        baseActivity.getLayoutMode().L(skinType == 1);
        baseActivity.getLayoutMode().h(inflate);
        a.onChangeSkinType(skinType);
        a.setVisibility(0);
        return inflate;
    }
}
