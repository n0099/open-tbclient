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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class p extends BaseAdapter {
    private o iXA;
    private FacePurchaseRecordsData iXB = null;
    private boolean iXC;

    public p(o oVar) {
        this.iXA = oVar;
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.buy_his == null || facePurchaseRecordsData.buy_his.size() == 0) {
            this.iXC = false;
        } else {
            this.iXC = true;
        }
        this.iXB = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.iXC || this.iXB == null || this.iXB.buy_his == null) {
            return 1;
        }
        return this.iXB.buy_his.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iXB == null || this.iXB.buy_his == null) {
            return null;
        }
        ArrayList<FacePurchasePackageData> arrayList = this.iXB.buy_his;
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
        if (!this.iXC) {
            return czw();
        }
        if (view == null) {
            view = createView();
        }
        a aVar = (a) view.getTag();
        com.baidu.tbadk.core.c layoutMode = this.iXA.getLayoutMode();
        layoutMode.setNightMode(skinType == 1);
        layoutMode.onModeChanged(view);
        a(i, aVar);
        return view;
    }

    private View createView() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.iXA.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        aVar.gGY = (TbImageView) inflate.findViewById(R.id.cover);
        aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
        aVar.gFl = (TextView) inflate.findViewById(R.id.time);
        aVar.fkS = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(int i, a aVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData != null) {
            aVar.gGY.setTag(facePurchasePackageData.cover_url);
            aVar.gGY.a(facePurchasePackageData.cover_url, 10, this.iXA.getResources().getDimensionPixelSize(R.dimen.ds94), this.iXA.getResources().getDimensionPixelSize(R.dimen.ds94), false);
            aVar.fkS.setText(facePurchasePackageData.price);
            aVar.mTitle.setText(facePurchasePackageData.pname);
            Date date = new Date();
            date.setTime(facePurchasePackageData.puy_time * 1000);
            aVar.gFl.setText(au.getDateStringDay(date));
        }
    }

    private View czw() {
        View inflate = LayoutInflater.from(this.iXA.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iXA.getPageContext().getContext(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.EMOTION, (int) this.iXA.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.d.aV(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iXA.getResources().getString(R.string.go_to_download_emotion), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(p.this.iXA.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                p.this.iXA.finish();
            }
        })));
        com.baidu.tbadk.core.c layoutMode = this.iXA.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.setNightMode(skinType == 1);
            layoutMode.onModeChanged(inflate);
        }
        a2.onChangeSkinType(this.iXA.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView fkS;
        TextView gFl;
        TbImageView gGY;
        TextView mTitle;

        private a() {
        }
    }
}
