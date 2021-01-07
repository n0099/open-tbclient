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
/* loaded from: classes9.dex */
public class SigleRecordsFragment extends BaseFragment {
    private BdListView WV;
    private TextView frf;
    private ConsumptionRecordsActivity iBV;
    private ConsumptionRecordsModel iBW;
    private c iBZ;
    private TbImageView iCa;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private int type;
    private boolean iBX = false;
    private boolean iBY = false;
    private g mPullView = null;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iBV = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        this.iBW = new ConsumptionRecordsModel(getUniqueId());
        this.iBW.setType(this.type);
        if (this.type == 3) {
            this.iBW.setShowMember(1);
        } else {
            this.iBW.setShowMember(0);
        }
        this.iBW.a(new ConsumptionRecordsModel.a() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.1
            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void a(int i, String str, ArrayList<a> arrayList, b bVar, boolean z) {
                SigleRecordsFragment.this.iBY = z;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                SigleRecordsFragment.this.WV.completePullRefresh();
                if (i == 0) {
                    SigleRecordsFragment.this.iBX = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        SigleRecordsFragment.this.caZ();
                        if (z) {
                            SigleRecordsFragment.this.frf.setText(R.string.loading_more_now);
                        } else {
                            SigleRecordsFragment.this.frf.setText(R.string.no_more_data);
                        }
                        SigleRecordsFragment.this.iBZ.ar(arrayList);
                        SigleRecordsFragment.this.iBZ.notifyDataSetChanged();
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
                if (!SigleRecordsFragment.this.iBX) {
                    SigleRecordsFragment.this.showNoDataView();
                } else if (z) {
                    SigleRecordsFragment.this.frf.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.frf.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.iBX = true;
            }

            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void cvU() {
                SigleRecordsFragment.this.iBX = true;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                if (SigleRecordsFragment.this.iBY) {
                    SigleRecordsFragment.this.frf.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.frf.setText(R.string.no_more_data);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.WV = (BdListView) this.mRootView.findViewById(R.id.records_list_view);
        this.mPullView = new g(this.iBV.getPageContext());
        this.iBZ = new c(this.iBV.getPageContext(), this.type);
        this.WV.setAdapter((ListAdapter) this.iBZ);
        this.WV.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.iBV.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iBV.getActivity(), R.dimen.ds176)));
        this.WV.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                SigleRecordsFragment.this.iBW.cvS();
            }
        });
        this.WV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                SigleRecordsFragment.this.iBW.cvT();
            }
        });
        this.frf = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
        this.WV.addFooterView(this.frf);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.iBX) {
            this.iBW.cvS();
            showLoadingView(this.mRootView, true, 400);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iBW != null) {
            this.iBW.destroy();
        }
        hideLoadingView(this.mRootView);
        this.WV.completePullRefresh();
        this.mPullView = null;
        this.mNoDataView = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mRootView != null) {
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
        if (this.frf != null) {
            ao.setViewTextColor(this.frf, R.color.CAM_X0108);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iBZ != null && this.WV != null) {
            ao.setBackgroundColor(this.WV, R.color.CAM_X0204);
            this.iBZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.onChangeSkinType(this.iBV.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.iBV.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iBV.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iBV.getPageContext(), TbadkApplication.getInst().getSkinType());
        cwb();
        cba();
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
            if (this.iCa == null) {
                this.iCa = new TbImageView(getActivity());
                this.iCa.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.iCa.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.iCa.startLoad(bVar.getIconUrl(), 10, false);
            this.iCa.setVisibility(0);
            this.iCa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    be.bwv().b(SigleRecordsFragment.this.getPageContext(), new String[]{bVar.getLinkUrl()});
                }
            });
            cba();
            hideNoDataView();
            this.mRootView.addView(this.iCa);
        }
    }

    private void cwb() {
        if (this.iCa != null) {
            this.mRootView.removeView(this.iCa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caZ() {
        hideNoDataView();
        cwb();
        if (this.WV != null) {
            this.WV.setVisibility(0);
        }
    }

    private void cba() {
        if (this.WV != null) {
            this.WV.setVisibility(8);
        }
    }
}
