package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class p extends BaseAdapter {
    private o iPW;
    private FacePurchaseRecordsData iPX = null;
    private boolean iPY;

    public p(o oVar) {
        this.iPW = oVar;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.buy_his == null || facePurchaseRecordsData.buy_his.size() == 0) {
            this.iPY = false;
        } else {
            this.iPY = true;
        }
        this.iPX = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.iPY || this.iPX == null || this.iPX.buy_his == null) {
            return 1;
        }
        return this.iPX.buy_his.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iPX == null || this.iPX.buy_his == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.iPX.buy_his;
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
        int skinType = TbadkApplication.getInst().getSkinType();
        if (!this.iPY) {
            return cxY();
        }
        if (view == null) {
            view = createView();
        }
        a aVar = (a) view.getTag();
        com.baidu.tbadk.core.c layoutMode = this.iPW.getLayoutMode();
        layoutMode.setNightMode(skinType == 1);
        layoutMode.onModeChanged(view);
        a(i, aVar);
        return view;
    }

    private View createView() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.iPW.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        aVar.gCr = (TbImageView) inflate.findViewById(R.id.cover);
        aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
        aVar.gAE = (TextView) inflate.findViewById(R.id.time);
        aVar.fha = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(int i, a aVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            aVar.gCr.setTag(facePurchasePackageData.cover_url);
            aVar.gCr.a(facePurchasePackageData.cover_url, 10, this.iPW.getResources().getDimensionPixelSize(R.dimen.ds94), this.iPW.getResources().getDimensionPixelSize(R.dimen.ds94), false);
            aVar.fha.setText(facePurchasePackageData.price);
            aVar.mTitle.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puy_time * 1000);
            aVar.gAE.setText(at.getDateStringDay(date));
        }
    }

    private View cxY() {
        View inflate = LayoutInflater.from(this.iPW.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iPW.getPageContext().getContext(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.EMOTION, (int) this.iPW.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.d.aY(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iPW.getResources().getString(R.string.go_to_download_emotion), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(p.this.iPW.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                p.this.iPW.finish();
            }
        })));
        com.baidu.tbadk.core.c layoutMode = this.iPW.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.setNightMode(skinType == 1);
            layoutMode.onModeChanged(inflate);
        }
        a2.onChangeSkinType(this.iPW.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView fha;
        TextView gAE;
        TbImageView gCr;
        TextView mTitle;

        private a() {
        }
    }
}
