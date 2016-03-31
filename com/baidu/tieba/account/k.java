package com.baidu.tieba.account;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private View.OnClickListener afZ;
    private BaseActivity avA;
    private List<AccountData> aLU = null;
    private boolean aLT = false;

    public k(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.avA = baseActivity;
        this.afZ = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aLU = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aLU != null) {
            i = this.aLU.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLU == null || i < 0 || i >= this.aLU.size()) {
            return null;
        }
        return this.aLU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e  */
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
                        view2 = LayoutInflater.from(this.avA.getPageContext().getContext()).inflate(t.h.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aLV = (TextView) view2.findViewById(t.g.account);
                        aVar.aLX = (ImageView) view2.findViewById(t.g.active);
                        aVar.aLY = (Button) view2.findViewById(t.g.delete);
                        aVar.amH = view2.findViewById(t.g.account_item_line_layout);
                        aVar.aLY.setOnClickListener(this.afZ);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.avA.getPageContext().getContext()).inflate(t.h.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aLW = (TextView) view2.findViewById(t.g.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aLX.setVisibility(8);
                        aVar.aLY.setVisibility(8);
                        aVar.aLY.setTag(accountData);
                        if (accountData != null) {
                            if (StringUtils.isNull(accountData.getDisplayName())) {
                                aVar.aLV.setText(accountData.getAccount());
                            } else {
                                aVar.aLV.setText(accountData.getDisplayName());
                            }
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aLX.setVisibility(0);
                            }
                            if (this.aLT) {
                                aVar.aLY.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.amH.setVisibility(8);
                        } else {
                            aVar.amH.setVisibility(0);
                        }
                    }
                    this.avA.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.avA.getLayoutMode().x(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.avA.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() != 1);
                    this.avA.getLayoutMode().x(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.avA.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.avA.getLayoutMode().x(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.avA.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() != 1);
            this.avA.getLayoutMode().x(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.avA.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.avA.getLayoutMode().x(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aLT = z;
    }

    public boolean JH() {
        return this.aLT;
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
        TextView aLV;
        TextView aLW;
        ImageView aLX;
        Button aLY;
        View amH;

        private a() {
        }

        /* synthetic */ a(k kVar, a aVar) {
            this();
        }
    }
}
