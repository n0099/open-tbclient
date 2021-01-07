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
/* loaded from: classes9.dex */
public class p extends BaseAdapter {
    private o iUD;
    private FacePurchaseRecordsData iUE = null;
    private boolean iUF;

    public p(o oVar) {
        this.iUD = oVar;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.buy_his == null || facePurchaseRecordsData.buy_his.size() == 0) {
            this.iUF = false;
        } else {
            this.iUF = true;
        }
        this.iUE = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.iUF || this.iUE == null || this.iUE.buy_his == null) {
            return 1;
        }
        return this.iUE.buy_his.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iUE == null || this.iUE.buy_his == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.iUE.buy_his;
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
        if (!this.iUF) {
            return cBQ();
        }
        if (view == null) {
            view = createView();
        }
        a aVar = (a) view.getTag();
        com.baidu.tbadk.core.c layoutMode = this.iUD.getLayoutMode();
        layoutMode.setNightMode(skinType == 1);
        layoutMode.onModeChanged(view);
        a(i, aVar);
        return view;
    }

    private View createView() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.iUD.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        aVar.gGX = (TbImageView) inflate.findViewById(R.id.cover);
        aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
        aVar.gFk = (TextView) inflate.findViewById(R.id.time);
        aVar.flL = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(int i, a aVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            aVar.gGX.setTag(facePurchasePackageData.cover_url);
            aVar.gGX.a(facePurchasePackageData.cover_url, 10, this.iUD.getResources().getDimensionPixelSize(R.dimen.ds94), this.iUD.getResources().getDimensionPixelSize(R.dimen.ds94), false);
            aVar.flL.setText(facePurchasePackageData.price);
            aVar.mTitle.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puy_time * 1000);
            aVar.gFk.setText(at.getDateStringDay(date));
        }
    }

    private View cBQ() {
        View inflate = LayoutInflater.from(this.iUD.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iUD.getPageContext().getContext(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.EMOTION, (int) this.iUD.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.d.aY(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iUD.getResources().getString(R.string.go_to_download_emotion), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(p.this.iUD.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                p.this.iUD.finish();
            }
        })));
        com.baidu.tbadk.core.c layoutMode = this.iUD.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.setNightMode(skinType == 1);
            layoutMode.onModeChanged(inflate);
        }
        a2.onChangeSkinType(this.iUD.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        TextView flL;
        TextView gFk;
        TbImageView gGX;
        TextView mTitle;

        private a() {
        }
    }
}
