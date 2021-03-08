package com.baidu.tieba.consumptionRecords;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class SigleRecordsFragment extends BaseFragment {
    private BdListView Yj;
    private TextView fqn;
    private ConsumptionRecordsActivity iEV;
    private ConsumptionRecordsModel iEW;
    private c iEZ;
    private TbImageView iFa;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private int type;
    private boolean iEX = false;
    private boolean iEY = false;
    private g mPullView = null;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEV = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        this.iEW = new ConsumptionRecordsModel(getUniqueId());
        this.iEW.setType(this.type);
        if (this.type == 3) {
            this.iEW.setShowMember(1);
        } else {
            this.iEW.setShowMember(0);
        }
        this.iEW.a(new ConsumptionRecordsModel.a() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.1
            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void a(int i, String str, ArrayList<a> arrayList, b bVar, boolean z) {
                SigleRecordsFragment.this.iEY = z;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                SigleRecordsFragment.this.Yj.completePullRefresh();
                if (i == 0) {
                    SigleRecordsFragment.this.iEX = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        SigleRecordsFragment.this.bYu();
                        if (z) {
                            SigleRecordsFragment.this.fqn.setText(R.string.loading_more_now);
                        } else {
                            SigleRecordsFragment.this.fqn.setText(R.string.no_more_data);
                        }
                        SigleRecordsFragment.this.iEZ.al(arrayList);
                        SigleRecordsFragment.this.iEZ.notifyDataSetChanged();
                        return;
                    } else if (bVar != null) {
                        SigleRecordsFragment.this.a(bVar);
                        return;
                    } else {
                        SigleRecordsFragment.this.showNoDataView();
                        return;
                    }
                }
                SigleRecordsFragment.this.showToast(str);
                if (!SigleRecordsFragment.this.iEX) {
                    SigleRecordsFragment.this.showNoDataView();
                } else if (z) {
                    SigleRecordsFragment.this.fqn.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.fqn.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.iEX = true;
            }

            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void ctB() {
                SigleRecordsFragment.this.iEX = true;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                if (SigleRecordsFragment.this.iEY) {
                    SigleRecordsFragment.this.fqn.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.fqn.setText(R.string.no_more_data);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.Yj = (BdListView) this.mRootView.findViewById(R.id.records_list_view);
        this.mPullView = new g(this.iEV.getPageContext());
        this.iEZ = new c(this.iEV.getPageContext(), this.type);
        this.Yj.setAdapter((ListAdapter) this.iEZ);
        this.Yj.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.iEV.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iEV.getActivity(), R.dimen.ds176)));
        this.Yj.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                SigleRecordsFragment.this.iEW.ctz();
            }
        });
        this.Yj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                SigleRecordsFragment.this.iEW.ctA();
            }
        });
        this.fqn = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
        this.Yj.addFooterView(this.fqn);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.iEX) {
            this.iEW.ctz();
            showLoadingView(this.mRootView, true, 400);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iEW != null) {
            this.iEW.destroy();
        }
        hideLoadingView(this.mRootView);
        this.Yj.completePullRefresh();
        this.mPullView = null;
        this.mNoDataView = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mRootView != null) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
        if (this.fqn != null) {
            ap.setViewTextColor(this.fqn, R.color.CAM_X0108);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iEZ != null && this.Yj != null) {
            ap.setBackgroundColor(this.Yj, R.color.CAM_X0204);
            this.iEZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.onChangeSkinType(this.iEV.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i;
        switch (this.type) {
            case 1:
                i = R.string.no_expenditure_records_tip;
                break;
            case 2:
                i = R.string.no_income_records_tip;
                break;
            case 3:
                i = R.string.no_recharge_records_tip;
                break;
            default:
                i = R.string.no_records_tip;
                break;
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iEV.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iEV.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pA(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iEV.getPageContext(), TbadkApplication.getInst().getSkinType());
        ctI();
        bYv();
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        if (bVar != null && this.mRootView != null) {
            if (this.iFa == null) {
                this.iFa = new TbImageView(getActivity());
                this.iFa.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.iFa.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.iFa.startLoad(bVar.getIconUrl(), 10, false);
            this.iFa.setVisibility(0);
            this.iFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bf.bsY().b(SigleRecordsFragment.this.getPageContext(), new String[]{bVar.getLinkUrl()});
                }
            });
            bYv();
            hideNoDataView();
            this.mRootView.addView(this.iFa);
        }
    }

    private void ctI() {
        if (this.iFa != null) {
            this.mRootView.removeView(this.iFa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        hideNoDataView();
        ctI();
        if (this.Yj != null) {
            this.Yj.setVisibility(0);
        }
    }

    private void bYv() {
        if (this.Yj != null) {
            this.Yj.setVisibility(8);
        }
    }
}
