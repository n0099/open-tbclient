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
    private FacePurchaseRecordsData aue = null;
    private boolean auf;
    private Context mContext;

    public aw(Context context) {
        this.mContext = context;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.buy_his == null || facePurchaseRecordsData.buy_his.size() == 0) {
            this.auf = false;
        } else {
            this.auf = true;
        }
        this.aue = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auf) {
            return this.aue.buy_his.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aue == null || this.aue.buy_his == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.aue.buy_his;
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
        if (!this.auf) {
            return Dt();
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
        ayVar.atz = (TbImageView) inflate.findViewById(bz.cover);
        ayVar.JM = (TextView) inflate.findViewById(bz.title);
        ayVar.auh = (TextView) inflate.findViewById(bz.time);
        ayVar.atB = (TextView) inflate.findViewById(bz.price);
        inflate.setTag(ayVar);
        return inflate;
    }

    private void a(int i, ay ayVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            ayVar.atz.setTag(facePurchasePackageData.cover_url);
            ayVar.atz.a(facePurchasePackageData.cover_url, 10, this.mContext.getResources().getDimensionPixelSize(bx.faceshop_purchase_cover_width), this.mContext.getResources().getDimensionPixelSize(bx.faceshop_purchase_cover_height), false);
            ayVar.atB.setText(facePurchasePackageData.price);
            ayVar.JM.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puy_time * 1000);
            ayVar.auh.setText(com.baidu.tbadk.core.util.ay.d(date));
        }
    }

    private View Dt() {
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
