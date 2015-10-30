package com.baidu.tieba.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private View.OnClickListener adY;
    private BaseActivity asb;
    private List<AccountData> mData = null;
    private boolean aEC = false;

    public i(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.asb = baseActivity;
        this.adY = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=4] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        aVar = (a) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = LayoutInflater.from(this.asb.getPageContext().getContext()).inflate(i.g.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aED = (TextView) view2.findViewById(i.f.account);
                        aVar.aEF = (ImageView) view2.findViewById(i.f.active);
                        aVar.aEG = (Button) view2.findViewById(i.f.delete);
                        aVar.mLine = view2.findViewById(i.f.account_item_line_layout);
                        aVar.aEG.setOnClickListener(this.adY);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.asb.getPageContext().getContext()).inflate(i.g.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aEE = (TextView) view2.findViewById(i.f.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aEF.setVisibility(8);
                        aVar.aEG.setVisibility(8);
                        aVar.aEG.setTag(accountData);
                        if (accountData != null) {
                            aVar.aED.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                aVar.aEF.setVisibility(0);
                            }
                            if (this.aEC) {
                                aVar.aEG.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.mLine.setVisibility(8);
                        } else {
                            aVar.mLine.setVisibility(0);
                        }
                    }
                    this.asb.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.asb.getLayoutMode().k(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.asb.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.asb.getLayoutMode().k(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.detailException(e);
                this.asb.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() != 1);
                this.asb.getLayoutMode().k(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.asb.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() != 1);
            this.asb.getLayoutMode().k(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.asb.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.asb.getLayoutMode().k(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aEC = z;
    }

    public boolean FR() {
        return this.aEC;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aED;
        TextView aEE;
        ImageView aEF;
        Button aEG;
        View mLine;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
