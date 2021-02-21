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
/* loaded from: classes9.dex */
public class SigleRecordsFragment extends BaseFragment {
    private BdListView WO;
    private TextView foN;
    private ConsumptionRecordsActivity iDm;
    private ConsumptionRecordsModel iDn;
    private c iDq;
    private TbImageView iDr;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private int type;
    private boolean iDo = false;
    private boolean iDp = false;
    private g mPullView = null;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iDm = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        this.iDn = new ConsumptionRecordsModel(getUniqueId());
        this.iDn.setType(this.type);
        if (this.type == 3) {
            this.iDn.setShowMember(1);
        } else {
            this.iDn.setShowMember(0);
        }
        this.iDn.a(new ConsumptionRecordsModel.a() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.1
            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void a(int i, String str, ArrayList<a> arrayList, b bVar, boolean z) {
                SigleRecordsFragment.this.iDp = z;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                SigleRecordsFragment.this.WO.completePullRefresh();
                if (i == 0) {
                    SigleRecordsFragment.this.iDo = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        SigleRecordsFragment.this.bYo();
                        if (z) {
                            SigleRecordsFragment.this.foN.setText(R.string.loading_more_now);
                        } else {
                            SigleRecordsFragment.this.foN.setText(R.string.no_more_data);
                        }
                        SigleRecordsFragment.this.iDq.al(arrayList);
                        SigleRecordsFragment.this.iDq.notifyDataSetChanged();
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
                if (!SigleRecordsFragment.this.iDo) {
                    SigleRecordsFragment.this.showNoDataView();
                } else if (z) {
                    SigleRecordsFragment.this.foN.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.foN.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.iDo = true;
            }

            @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.a
            public void ctv() {
                SigleRecordsFragment.this.iDo = true;
                SigleRecordsFragment.this.hideLoadingView(SigleRecordsFragment.this.mRootView);
                if (SigleRecordsFragment.this.iDp) {
                    SigleRecordsFragment.this.foN.setText(R.string.load_more);
                } else {
                    SigleRecordsFragment.this.foN.setText(R.string.no_more_data);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.WO = (BdListView) this.mRootView.findViewById(R.id.records_list_view);
        this.mPullView = new g(this.iDm.getPageContext());
        this.iDq = new c(this.iDm.getPageContext(), this.type);
        this.WO.setAdapter((ListAdapter) this.iDq);
        this.WO.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.iDm.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iDm.getActivity(), R.dimen.ds176)));
        this.WO.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                SigleRecordsFragment.this.iDn.ctt();
            }
        });
        this.WO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                SigleRecordsFragment.this.iDn.ctu();
            }
        });
        this.foN = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
        this.WO.addFooterView(this.foN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.iDo) {
            this.iDn.ctt();
            showLoadingView(this.mRootView, true, 400);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iDn != null) {
            this.iDn.destroy();
        }
        hideLoadingView(this.mRootView);
        this.WO.completePullRefresh();
        this.mPullView = null;
        this.mNoDataView = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mRootView != null) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
        if (this.foN != null) {
            ap.setViewTextColor(this.foN, R.color.CAM_X0108);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iDq != null && this.WO != null) {
            ap.setBackgroundColor(this.WO, R.color.CAM_X0204);
            this.iDq.notifyDataSetChanged();
        }
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.onChangeSkinType(this.iDm.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.iDm.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iDm.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iDm.getPageContext(), TbadkApplication.getInst().getSkinType());
        ctC();
        bYp();
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
            if (this.iDr == null) {
                this.iDr = new TbImageView(getActivity());
                this.iDr.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.iDr.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.iDr.startLoad(bVar.getIconUrl(), 10, false);
            this.iDr.setVisibility(0);
            this.iDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.consumptionRecords.SigleRecordsFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bf.bsV().b(SigleRecordsFragment.this.getPageContext(), new String[]{bVar.getLinkUrl()});
                }
            });
            bYp();
            hideNoDataView();
            this.mRootView.addView(this.iDr);
        }
    }

    private void ctC() {
        if (this.iDr != null) {
            this.mRootView.removeView(this.iDr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYo() {
        hideNoDataView();
        ctC();
        if (this.WO != null) {
            this.WO.setVisibility(0);
        }
    }

    private void bYp() {
        if (this.WO != null) {
            this.WO.setVisibility(8);
        }
    }
}
