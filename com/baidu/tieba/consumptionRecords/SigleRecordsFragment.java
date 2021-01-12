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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
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
    private BdListView WT;
    private TextView fmv;
    private ConsumptionRecordsActivity ixo;
    private ConsumptionRecordsModel ixp;
    private c ixs;
    private TbImageView ixt;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private int type;
    private boolean ixq = false;
    private boolean ixr = false;
    private g mPullView = null;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ixo = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        this.ixp = new ConsumptionRecordsModel(getUniqueId());
        this.ixp.setType(this.type);
        if (this.type == 3) {
            this.ixp.setShowMember(1);
        } else {
            this.ixp.setShowMember(0);
        }
        this.ixp.a(new ConsumptionRecordsModel.a() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.1
            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void a(int i, String str, ArrayList<a> arrayList, b bVar, boolean z) {
                SigleRecordsFragment.this.ixr = z;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                SigleRecordsFragment.this.WT.completePullRefresh();
                if (i == 0) {
                    SigleRecordsFragment.this.ixq = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        SigleRecordsFragment.this.bXh();
                        if (z) {
                            SigleRecordsFragment.this.fmv.setText(R.string.loading_more_now);
                        } else {
                            SigleRecordsFragment.this.fmv.setText(R.string.no_more_data);
                        }
                        SigleRecordsFragment.this.ixs.am(arrayList);
                        SigleRecordsFragment.this.ixs.notifyDataSetChanged();
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
                if (!SigleRecordsFragment.this.ixq) {
                    SigleRecordsFragment.this.showNoDataView();
                } else if (z) {
                    SigleRecordsFragment.this.fmv.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.fmv.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.ixq = true;
            }

            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void csc() {
                SigleRecordsFragment.this.ixq = true;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                if (SigleRecordsFragment.this.ixr) {
                    SigleRecordsFragment.this.fmv.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.fmv.setText(R.string.no_more_data);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.WT = (BdListView) this.mRootView.findViewById(R.id.records_list_view);
        this.mPullView = new g(this.ixo.getPageContext());
        this.ixs = new c(this.ixo.getPageContext(), this.type);
        this.WT.setAdapter((ListAdapter) this.ixs);
        this.WT.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.ixo.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ixo.getActivity(), R.dimen.ds176)));
        this.WT.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                SigleRecordsFragment.this.ixp.csa();
            }
        });
        this.WT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                SigleRecordsFragment.this.ixp.csb();
            }
        });
        this.fmv = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
        this.WT.addFooterView(this.fmv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.ixq) {
            this.ixp.csa();
            showLoadingView(this.mRootView, true, 400);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ixp != null) {
            this.ixp.destroy();
        }
        hideLoadingView(this.mRootView);
        this.WT.completePullRefresh();
        this.mPullView = null;
        this.mNoDataView = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mRootView != null) {
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
        if (this.fmv != null) {
            ao.setViewTextColor(this.fmv, R.color.CAM_X0108);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ixs != null && this.WT != null) {
            ao.setBackgroundColor(this.WT, R.color.CAM_X0204);
            this.ixs.notifyDataSetChanged();
        }
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.onChangeSkinType(this.ixo.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.ixo.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ixo.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pu(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.ixo.getPageContext(), TbadkApplication.getInst().getSkinType());
        csj();
        bXi();
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
            if (this.ixt == null) {
                this.ixt = new TbImageView(getActivity());
                this.ixt.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.ixt.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.ixt.startLoad(bVar.getIconUrl(), 10, false);
            this.ixt.setVisibility(0);
            this.ixt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    be.bsB().b(SigleRecordsFragment.this.getPageContext(), new String[]{bVar.getLinkUrl()});
                }
            });
            bXi();
            hideNoDataView();
            this.mRootView.addView(this.ixt);
        }
    }

    private void csj() {
        if (this.ixt != null) {
            this.mRootView.removeView(this.ixt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXh() {
        hideNoDataView();
        csj();
        if (this.WT != null) {
            this.WT.setVisibility(0);
        }
    }

    private void bXi() {
        if (this.WT != null) {
            this.WT.setVisibility(8);
        }
    }
}
